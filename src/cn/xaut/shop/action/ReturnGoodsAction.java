package cn.xaut.shop.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.ReturnGoods;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;

public class ReturnGoodsAction extends BaseAction<ReturnGoods> {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest req = ServletActionContext.getRequest();

	// 申请时添加申请表
	public String save() {
		Order order= orderService.get(Integer.parseInt(req.getParameter("orderid")));
		
		if (!order.getState().equals("4")) {
			return "reOperation";
		}
		
		UserInfo user = (UserInfo) session.get("userinfo");
		Date now = new Date();
		model.setUserinfo(user);

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		model.setApplyTime(dateFormat.format(now));
		
		model.setOrder(order);
		Shop shop = shopService.get(Integer.parseInt(req.getParameter("shopId")));
		model.setShop(shop);
		model.setRemainchecktime("2");
		model.setState("0");
		//int returnGoodsid=returnGoodsService.add(model).getReturngoodsId();//添加退货申请表
		
		//更新订单表
		order.setState("51");//待审核
		//orderService.update(order);
		int returnGoodsid=returnGoodsService.addAndUpdate(model,order);
		//给卖家发送消息
		messageService.sendMessage(messageService,"您有一个订单买家申请退货，请审核！", 
				user.getUserinfoId(), shop.getUserinfo().getUserinfoId(),
		        "returnGoodsAction_searchMyCheckList.action","returnId", returnGoodsid);
		return "viewReturnGoodsRedirect";
	}

	// 审核时查找记录
	public String searchMyCheckList() {
		Shop shop = (Shop) session.get("shop");
		int shopId = shop.getShopId();
		List<ReturnGoods> checkReturnList = returnGoodsService.getMyCheckList(shopId,
				fromdate(), todate(), "0");		
		int id=location(checkReturnList,-1);//定位		
		page = returnGoodsService.getMyCheckList(page,shopId, fromdate(), todate(),"0",id);
		if (page == null || page.getTotalItems() == 0) {
			request.put("msg_searchMyCheckList", "暂无需要审核的数据！");
		}
		request.put("page", page);// 需要审核的记录，以页面的形式返回	
		return "checkReturnGoods";
	}

	// 审核通过，更新申请表
	public String passupdate() {
		String[] valus = req.getParameterValues("ckbox");

		UserInfo user = (UserInfo) session.get("userinfo");
		Date now = new Date();
		if (valus.length != 0) {
			for (int i = 0; i < valus.length; i++) {
				int modelId = Integer.parseInt(valus[i]);
				ReturnGoods model = returnGoodsService.get(modelId);
				
				if(model.getState().equals("1")){
					return "reOperation";
				}
				
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				model.setRemainchecktime("0");
				model.setCheckuserinfo(user);

				model.setCheckTime(dateFormat.format(now));
				model.setCheckIdea(req.getParameter("checkIdea"));
				model.setState("1");
				//returnGoodsService.update(model);// 更新申请表
				
				//更新订单表
				Order order= orderService.get(model.getOrder().getOrderid());
				order.setState("53");//审核通过，等待填单
				//orderService.update(order);
				returnGoodsService.updateAndUpdatePass(model,order);
				//给买家发送消息
				messageService.sendMessage(messageService,"您申请的退货卖家已审核通过，请填写货运单！", 
						user.getUserinfoId(), model.getUserinfo().getUserinfoId(),
		                "returnGoodsAction_searchMyPassList.action","returnId", modelId);
			}
		}

		request.put("msg_checkover", "审核完成，等待买家填写物流信息！");
		return "checkReturnGoodsRedirect";

	}

	// 审核不通过
	public String notpassupdate() {
		String[] valus = req.getParameterValues("ckbox");

		UserInfo user = (UserInfo) session.get("userinfo");
		Date now = new Date();
		if (valus.length != 0) {
			for (int i = 0; i < valus.length; i++) {
				int modelId = Integer.parseInt(valus[i]);
				ReturnGoods model = returnGoodsService.get(modelId);

				if(model.getState().equals("2")){
					return "reOperation";
				}
				
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				model.setRemainchecktime("0");
				model.setCheckuserinfo(user);

				model.setCheckTime(dateFormat.format(now));
				model.setCheckIdea(req.getParameter("checkIdea"));
				model.setState("2");
				//returnGoodsService.update(model);
				
				//更新订单表
				Order order= orderService.get(model.getOrder().getOrderid());
				order.setState("52");//审核不通过
				//orderService.update(order);
				returnGoodsService.updateAndUpdateNotpass(model,order);
				//给买家发送消息
				messageService.sendMessage(messageService,"您申请的退货卖家审核不通过，请修改！", 
						user.getUserinfoId(), model.getUserinfo().getUserinfoId(),
		                "returnGoodsAction_searchMyAlterList.action","returnId", modelId);
			}
		}
		request.put("msg_checkover", "审核完成，等待买家修改！");
		return "checkReturnGoodsRedirect";
	}

	// 修改时查找记录
	public String searchMyAlterList() {
		UserInfo user = (UserInfo) session.get("userinfo");
		int userid = user.getUserinfoId();
		List<ReturnGoods> alterReturnList = returnGoodsService.getMyAlterList(userid,
				fromdate(), todate(), "2");
		int id=location(alterReturnList,-1);//定位		
		page = returnGoodsService.getMyAlterList(page,userid, fromdate(), todate(),"2",id);
		if (page == null || page.getTotalItems() == 0) {
			request.put("msg_searchMyAlterList", "暂无卖家审核不通过的数据，只有您申请的数据卖家审核不通过才能修改哦！");
		}
		request.put("page", page);
		
		return "alterReturnGoods";
	}

	// 修改时删除
	public String delete() {
		//更新订单表
		Order order= orderService.get(Integer.parseInt(req.getParameter("orderid")));
		
		if(order.getState().equals("4")){
			return "reOperation";
		}
		
		order.setState("4");//删除后订单状态改为已收货
		//orderService.update(order);
		
		int id = model.getReturngoodsId();
		//returnGoodsService.delete(id);
		returnGoodsService.deleteAndUpdate(id,order);
		
		request.put("msg_alterover", "删除成功！");
		return "alterReturnGoodsRedirect";
	}

	// 修改提交
	public String alterUpdate() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		ReturnGoods model2 = returnGoodsService.get(model.getReturngoodsId());
		
		if(model2.getState().equals("0")){
			return "reOperation";
		}
		
		model2.setApplyTime(dateFormat.format(now));
		model2.setReason(model.getReason());
		model2.setRemainchecktime("2");
		model2.setState("0");
		model2.setCheckTime("");
		model2.setCheckIdea("");
		//returnGoodsService.update(model2);
		
		//更新订单表
		Order order= orderService.get(model2.getOrder().getOrderid());
		order.setState("51");//修改完毕，等待审核
		//orderService.update(order);
		returnGoodsService.updateAndUpdateAlter(model2,order);
		
		request.put("msg_alterover", "修改已完成，等待卖家审核！");
		
		//给卖家发送消息
		messageService.sendMessage(messageService,"您有一个订单买家申请退货，请审核！", 
				model2.getUserinfo().getUserinfoId(), model2.getCheckuserinfo().getUserinfoId(),
		                "returnGoodsAction_searchMyCheckList.action","returnId", model.getReturngoodsId());		
		return "viewReturnGoodsRedirect";
	}

	// 查找审核通过记录
	public String searchMyPassList() {
		UserInfo user = (UserInfo) session.get("userinfo");
		int userid = user.getUserinfoId();
		List<ReturnGoods> PassReturnList = returnGoodsService.getMyAlterList(userid,
				fromdate(), todate(), "1");
		int id=location(PassReturnList,-1);//定位		
		page = returnGoodsService.getMyAlterList(page,userid, fromdate(), todate(),"1",id);
		if (page == null || page.getTotalItems() == 0) {
			request.put("msg_searchMyPassList", "暂无需要填写物流信息的数据！");
		}
		request.put("page", page);
		return "transInfoReturnGoods";
	}

	// 物流信息提交
	public String transInfoUpdate() {
		ReturnGoods model2 = returnGoodsService.get(model.getReturngoodsId());
		
		if(model2.getState().equals("3")){
			return "reOperation";
		}
		
		model2.setLogisticscompany(model.getLogisticscompany());
		model2.setLogisticsnum(model.getLogisticsnum());
		model2.setState("3"); // 已填写物流
		//returnGoodsService.update(model2);
		
		//更新订单表
		Order order= orderService.get(model2.getOrder().getOrderid());
		order.setState("54");//填单完毕，等待卖家收货
		//orderService.update(order);
		returnGoodsService.updateAndUpdateTransInfo(model2,order);
		
		request.put("msg_writeover", "物流信息已填写，等待卖家收货！");
		//给卖家发送消息
		messageService.sendMessage(messageService,"您有一个订单买家已经填写货运单，请查收！", 
				model2.getUserinfo().getUserinfoId(), model2.getCheckuserinfo().getUserinfoId(),
		                "returnGoodsAction_searchMyConfirmList.action","returnId", model.getReturngoodsId());		
		
		return "viewReturnGoodsRedirect";
	}

	// 查找需要我收货的记录
	public String searchMyConfirmList() {
		UserInfo user = (UserInfo) session.get("userinfo");
		int userid = user.getUserinfoId();
		List<ReturnGoods> ConfirmReturnList = returnGoodsService.getMyConfirmList(userid,
				fromdate(), todate(), "3");
		int id=location(ConfirmReturnList,-1);//定位		
		page = returnGoodsService.getMyConfirmList(page,userid, fromdate(), todate(),"3",id);
		if (page == null || page.getTotalItems() == 0) {
			request.put("msg_searchMyConfirmList", "暂无需要收货的数据！");
		}
		request.put("page", page);
		return "confirmReturnGoods";
	}

	// 卖家已经收到货
	public String confirmUpdate() {
		ReturnGoods model2 = returnGoodsService.get(model.getReturngoodsId());
		
		if(model2.getState().equals("4")){
			return "reOperation";
		}
		
		model2.setState("4"); // 已收货并且退费
		//returnGoodsService.update(model2);
		
		//更新订单表
		Order order= orderService.get(model2.getOrder().getOrderid());
		//orderService.returnGoods(order);
		returnGoodsService.updateAndUpdateConfirm(model2,order);
		
		request.put("msg_receive", "已收货并且退费，感谢您的光临！");
		
		//给买家发送消息
		messageService.sendMessage(messageService,"您申请的退货卖家已收货，请查看！", 
				model2.getCheckuserinfo().getUserinfoId(), model2.getUserinfo().getUserinfoId(),
                "returnGoodsAction_searchMyViewList.action","returnId", model.getReturngoodsId());
		
		//searchMyConfirmList();
		return "viewReturnGoodsSellRedirect";
	}

	// 查看记录
	public String searchMyViewList() {
		UserInfo user = (UserInfo) session.get("userinfo");
		int userid = user.getUserinfoId();
		List<ReturnGoods> viewReturnList = returnGoodsService.getMyViewList(userid,fromdate(), todate());
		int id=location(viewReturnList,-1);//定位		
		page = returnGoodsService.getMyViewList(page,userid, fromdate(), todate(),id);
		if (page == null || page.getTotalItems() == 0) {
			request.put("msg_searchMyViewList", "无相应数据！");
		}
		request.put("page", page);
		return "viewReturnGoods";
	}
	
	// 卖家查看记录
	public String searchMyViewListSell() {
		Shop shop = (Shop) session.get("shop");
		int shopId = shop.getShopId();
		List<ReturnGoods> viewReturnList = returnGoodsService.getMyViewListSell(shopId,fromdate(), todate());
		int id=location(viewReturnList,-1);//定位		
		page = returnGoodsService.getMyViewListSell(page,shopId, fromdate(), todate(),id);
		if (page == null || page.getTotalItems() == 0) {
			request.put("msg_searchMyViewList", "无相应数据！");
		}
		request.put("page", page);
		return "viewReturnGoodsSell";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int location(List list,int id) {		
		String returnId=req.getParameter("returnId");//从消息中传过来
		String orderid=req.getParameter("orderid");//从已购买或者已售出宝贝界面传过来
		if(orderid!=null && orderid!="" && list != null && list.size() > 0){
			Iterator<ReturnGoods> it=list.iterator();
			while(it.hasNext()){	
				ReturnGoods itmodel=it.next();
				if(orderid.equals(itmodel.getOrder().getOrderid().toString())){
					returnId=itmodel.getReturngoodsId().toString();	
					break;
				}			
			}
		}
		if(returnId!=null&&returnId!=""){
			request.put("returnId",returnId);
			id=Integer.parseInt(returnId);
		}
		return id;
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