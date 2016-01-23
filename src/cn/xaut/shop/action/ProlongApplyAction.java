package cn.xaut.shop.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.ProlongApply;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;

public class ProlongApplyAction extends BaseAction<ProlongApply> {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest req = ServletActionContext.getRequest();

	// 申请时添加申请表，更新订单表
	public String save() {
		Order order= orderService.get(Integer.parseInt(req.getParameter("orderid")));
		if (!order.getState().equals("3")) {
			return "reOperation";
		}
		
		UserInfo user = (UserInfo) session.get("userinfo");
		Date now = new Date();
		model.setUserinfo(user);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		model.setApplyTime(dateFormat.format(now));
		model.setDayapply(model.getDayapply().replaceFirst("^0*", ""));
		
		model.setOrder(order);
		Shop shop = shopService.get(Integer.parseInt(req.getParameter("shopId")));
		model.setShop(shop);
		model.setRemainchecktime("2");
		model.setState("0");		
		//int prolongApplyid=prolongApplyService.add(model).getProlongapplyId();//添加延长收货时间申请表		
		//更新订单表
		order.setState("31");
		//orderService.update(order);
		
		int prolongApplyid=prolongApplyService.addAndUpdate(model,order);
		//给卖家发送消息
		messageService.sendMessage(messageService,"您有一个订单买家申请延长收货时间，请审核！", 
				user.getUserinfoId(), shop.getUserinfo().getUserinfoId(),
                "prolongApplyAction_searchMyCheckList.action","prolongId", prolongApplyid);
		return "viewProlongApplyRedirect";
	}

	// 审核时查找记录
	public String searchMyCheckList() {
		Shop shop = (Shop) session.get("shop");
		int shopId = shop.getShopId();
		List<ProlongApply> checkProlongList = prolongApplyService.getMyCheckList(shopId,
				fromdate(), todate(), "0");
		int id=-1;
		String prolongId=req.getParameter("prolongId");//从消息中传过来
		String orderid=req.getParameter("orderid");//从已购买或者已售出宝贝界面传过来
		if(orderid!=null && orderid!="" && checkProlongList != null && checkProlongList.size() > 0){
			Iterator<ProlongApply> it=checkProlongList.iterator();
		while(it.hasNext()){	
			ProlongApply itmodel=it.next();
			if(orderid.equals(itmodel.getOrder().getOrderid().toString())){
				prolongId=itmodel.getProlongapplyId().toString();	
				break;
			}			
		}
	}
	if(prolongId!=null&&prolongId!=""){
		request.put("prolongId",prolongId);
		id=Integer.parseInt(prolongId);
	}

	page = prolongApplyService.getMyCheckList(page,shopId, fromdate(), todate(),"0",id);
	if (page == null || page.getTotalItems() == 0) {
		request.put("msg_searchMyCheckList", "暂无需要审核的数据！");
	}
	request.put("page", page);// 需要审核的记录，以页面的形式返回		
	return "checkProlongApply";
}

	// 审核通过，更新申请表
	public String passupdate() {
		String[] valus = req.getParameterValues("ckbox");

		UserInfo user = (UserInfo) session.get("userinfo");
		Date now = new Date();
		if (valus.length != 0) {
			for (int i = 0; i < valus.length; i++) {
				int modelId = Integer.parseInt(valus[i]);
				ProlongApply model = prolongApplyService.get(modelId);
				
				if(model.getState().equals("1")){
					return "reOperation";
				}
							
				Order order= orderService.get(model.getOrder().getOrderid());
				if (!order.getState().equals("31")) {
					model.setState("3");//数据失效
					prolongApplyService.updateAndUpdatePass(model,order);
					request.put("msg_checkover", "数据已失效，请移步已售出的宝贝查看详情！");
					return "checkProlongApplyRedirect";
				}
				
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				model.setRemainchecktime("0");
				model.setCheckuserinfo(user);
				model.setCheckTime(dateFormat.format(now));
				model.setCheckIdea(req.getParameter("checkIdea"));
				model.setState("1");
				//prolongApplyService.update(model);// 更新延长收货时间申请表
				
				//更新订单表
				//Order order= orderService.get(model.getOrder().getOrderid());
				order.setState("33");//审核通过，已经延长收货时间
				//orderService.update(order);
				prolongApplyService.updateAndUpdatePass(model,order);
				
				//给买家发送消息
				messageService.sendMessage(messageService,"您申请的延长收货时间卖家已审核通过，请查看！", 
						user.getUserinfoId(), model.getUserinfo().getUserinfoId(),
		                "prolongApplyAction_searchMyViewList.action","prolongId", modelId);
			}
		}
		request.put("msg_checkover", "审核完成！");
		return "checkProlongApplyRedirect";
	}

	// 审核不通过
	public String notpassupdate() {
		String[] valus = req.getParameterValues("ckbox");
		
		UserInfo user = (UserInfo) session.get("userinfo");
		Date now = new Date();
		if (valus.length != 0) {
			for (int i = 0; i < valus.length; i++) {
				int modelId = Integer.parseInt(valus[i]);
				ProlongApply model = prolongApplyService.get(modelId);
				
				if(model.getState().equals("2")){
					return "reOperation";
				}
				
				Order order= orderService.get(model.getOrder().getOrderid());
				if (!order.getState().equals("31")) {
					model.setState("3");//数据失效
					prolongApplyService.updateAndUpdatePass(model,order);
					request.put("msg_checkover", "数据已失效，请移步已售出的宝贝查看详情！");
					return "checkProlongApplyRedirect";
				}
				
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				model.setRemainchecktime("0");
				model.setCheckuserinfo(user);			
				model.setCheckTime(dateFormat.format(now));
				model.setCheckIdea(req.getParameter("checkIdea"));
				model.setState("2");
				//prolongApplyService.update(model);// 更新延长收货时间申请表
				
				//更新订单表
				//Order order= orderService.get(model.getOrder().getOrderid());
				order.setState("32");//审核不通过
				//orderService.update(order);
				prolongApplyService.updateAndUpdateNotpass(model,order);
				//给买家发送消息
				messageService.sendMessage(messageService,"您申请的延长收货时间卖家审核不通过，请修改！", 
						user.getUserinfoId(), model.getUserinfo().getUserinfoId(),
		                "prolongApplyAction_searchMyAlterList.action","prolongId", modelId);
			}
		}
		request.put("msg_checkover", "审核完成！");
		return "checkProlongApplyRedirect";
	}

	// 修改时查找记录
	public String searchMyAlterList() {
		UserInfo user = (UserInfo) session.get("userinfo");
		int userid = user.getUserinfoId();
		List<ProlongApply> alterProlongList = prolongApplyService.getMyAlterList(userid,
				fromdate(), todate(), "2");
		int id=-1;
		String prolongId=req.getParameter("prolongId");//从消息中传过来
		String orderid=req.getParameter("orderid");//从已购买或者已售出宝贝界面传过来
		if(orderid!=null && orderid!="" && alterProlongList != null && alterProlongList.size() > 0){
			Iterator<ProlongApply> it=alterProlongList.iterator();
		while(it.hasNext()){	
			ProlongApply itmodel=it.next();
			if(orderid.equals(itmodel.getOrder().getOrderid().toString())){
				prolongId=itmodel.getProlongapplyId().toString();	
				break;
			}			
		}
		}
		if(prolongId!=null&&prolongId!=""){
		request.put("prolongId",prolongId);
		id=Integer.parseInt(prolongId);
		}

		page = prolongApplyService.getMyAlterList(page,userid, fromdate(), todate(),"2",id);
		if (page == null || page.getTotalItems() == 0) {
			request.put("msg_searchMyAlterList", "暂无卖家审核不通过的数据，只有您申请的数据卖家审核不通过才能修改哦！");
		}
		request.put("page", page);// 需要审核的记录，以页面的形式返回			
		return "alterProlongApply";
	}

	// 修改提交
	public String alterUpdate() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		ProlongApply model2 = prolongApplyService.get(model.getProlongapplyId());

		if(model2.getState().equals("0")){
			return "reOperation";
		}
		
		Order order= orderService.get(model2.getOrder().getOrderid());
		if (!order.getState().equals("32")) {
			model2.setState("3");//数据失效
			prolongApplyService.updateAndUpdateAlter(model2,order);
			request.put("msg_alterover", "数据已失效，请移步已买到的宝贝查看详情！");
			return "viewProlongApplyRedirect";
		}
		
		model2.setApplyTime(dateFormat.format(now));
		model2.setDayapply(model.getDayapply());
		model2.setReason(model.getReason());
		model2.setRemainchecktime("2");
		model2.setState("0");
		model2.setCheckTime("");
		model2.setCheckIdea("");
		//prolongApplyService.update(model2);// 更新延长收货时间申请表
		
		//更新订单表
		//Order order= orderService.get(model2.getOrder().getOrderid());
		order.setState("31");//修改完毕，等待审核
		//orderService.update(order);
		prolongApplyService.updateAndUpdateAlter(model2,order);
		
		request.put("msg_alterover", "修改已完成！");
		
		//给卖家发送消息
		messageService.sendMessage(messageService,"您有一个订单买家申请延长收货时间，请审核！", 
				model2.getUserinfo().getUserinfoId(), model2.getCheckuserinfo().getUserinfoId(),
		                "prolongApplyAction_searchMyCheckList.action","prolongId", model.getProlongapplyId());		
		
		return "viewProlongApplyRedirect";
	}

	// 查看时查找记录
	public String searchMyViewList() {
		UserInfo user = (UserInfo) session.get("userinfo");
		int userid = user.getUserinfoId();
		List<ProlongApply> viewProlongList = prolongApplyService.getMyViewList(userid,
				fromdate(), todate());
		
		int id=-1;
		String prolongId=req.getParameter("prolongId");//从消息中传过来
		String orderid=req.getParameter("orderid");//从已购买宝贝界面传过来
		if(orderid!=null && orderid!="" && viewProlongList != null && viewProlongList.size() > 0){
			Iterator<ProlongApply> it=viewProlongList.iterator();
		while(it.hasNext()){	
			ProlongApply itmodel=it.next();
			if(orderid.equals(itmodel.getOrder().getOrderid().toString())){
				prolongId=itmodel.getProlongapplyId().toString();	
				break;
			}			
		}
		}
		if(prolongId!=null&&prolongId!=""){
		request.put("prolongId",prolongId);
		id=Integer.parseInt(prolongId);
		}
		
		page = prolongApplyService.getMyViewList(page,userid, fromdate(), todate(),id);
		if (page == null || page.getTotalItems() == 0) {
			request.put("msg_searchMyViewList", "暂无数据！");
		}
		request.put("page", page);// 需要审核的记录，以页面的形式返回	
	    return "viewProlongApply";
	}
	
	// 卖家查看时查找记录
	public String searchMyViewListSell() {
		Shop shop = (Shop) session.get("shop");
		int shopId = shop.getShopId();
		List<ProlongApply> viewProlongList = prolongApplyService.getMyViewListSell(shopId,
				fromdate(), todate());
		
		int id=-1;
		String prolongId=req.getParameter("prolongId");//从消息中传过来
		String orderid=req.getParameter("orderid");//从已售出宝贝界面传过来
		if(orderid!=null && orderid!="" && viewProlongList != null && viewProlongList.size() > 0){
			Iterator<ProlongApply> it=viewProlongList.iterator();
		while(it.hasNext()){	
			ProlongApply itmodel=it.next();
			if(orderid.equals(itmodel.getOrder().getOrderid().toString())){
				prolongId=itmodel.getProlongapplyId().toString();	
				break;
			}			
		}
		}
		if(prolongId!=null&&prolongId!=""){
		request.put("prolongId",prolongId);
		id=Integer.parseInt(prolongId);
		}
		
		page = prolongApplyService.getMyViewListSell(page,shopId, fromdate(), todate(),id);
		if (page == null || page.getTotalItems() == 0) {
			request.put("msg_searchMyViewList", "暂无数据！");
		}
		request.put("page", page);// 需要审核的记录，以页面的形式返回	
	    return "viewProlongApplySell";
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void location(List list) {
		String prolongId=req.getParameter("prolongId");//从消息中传过来
		String orderid=req.getParameter("orderid");//从已购买或者已售出宝贝界面传过来
		if(orderid!=null && orderid!="" && list != null && list.size() > 0){
			Iterator<ProlongApply> it=list.iterator();
			while(it.hasNext()){	
				ProlongApply itmodel=it.next();
				if(orderid.equals(itmodel.getOrder().getOrderid().toString())){
					prolongId=itmodel.getProlongapplyId().toString();	
					break;
				}			
			}
		}
		if(prolongId!=null&&prolongId!=""){
			request.put("prolongId",prolongId);
		}
	}
	
	public String delete() {
		//更新订单表
		Order order= orderService.get(Integer.parseInt(req.getParameter("orderid")));
		
		if(order.getState().equals("3")){
			return "reOperation";
		}
		
		order.setState("3");//删除后订单状态改为已发货
		//orderService.update(order);
				
		int id = model.getProlongapplyId();
		
		if(prolongApplyService.get(id)==null){
			return "reOperation";
		}
		//prolongApplyService.delete(id);
		prolongApplyService.deleteAndUpdate(id,order);	
		
		request.put("msg_alterover", "删除成功！");
		return "alterProlongApplyRedirect";
	}
	
	public String fromdate(){
		String fromdate = req.getParameter("fromdate");
		if (fromdate == null || fromdate.equals("")) {
			fromdate = "2015-01-01";
		}
		return fromdate;
	}
	public String todate(){
		String todate = req.getParameter("todate");
		if (todate == null || todate.equals("")) {
			todate = "2115-01-01";
		}
		return todate;
	}
}
