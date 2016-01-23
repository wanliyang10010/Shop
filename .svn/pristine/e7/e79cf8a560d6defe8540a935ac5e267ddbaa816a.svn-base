package cn.xaut.shop.phoneAction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.ReturnGoods;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;

public class ReturnGoodsActionPhone extends BaseAction<ReturnGoods> {
	private static final long serialVersionUID = 1L;
	private Integer userinfoId;
	private Integer shopId;
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public Integer getUserinfoId() {
		return userinfoId;
	}
	public void setUserinfoId(Integer userinfoId) {
		this.userinfoId = userinfoId;
	}
	private HttpServletRequest req = ServletActionContext.getRequest();

	// 申请时    添加申请表
	public String save() {
		UserInfo user=userInfoService.getAdmin(userinfoId);
		//UserInfo user=userInfoService.getAdmin(245);
		Date now = new Date();
		model.setUserinfo(user);

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		model.setApplyTime(dateFormat.format(now));
		Integer orderid= Integer.parseInt(req.getParameter("orderid"));
		Order order= orderService.getOrder(orderid);
		model.setOrder(order);
		Shop shop = shopService.get(Integer.parseInt(req.getParameter("shopId")));
		model.setShop(shop);
		model.setRemainchecktime("2");
		model.setState("0");
		returnGoodsService.save(model);//添加退货申请表
		jsonMap.put("isResult", "true");
		//更新订单表
		order.setState("51");//待审核
		orderService.update(order);
		//给卖家发送消息
		/*messageService.sendMessage(messageService,"您有一个订单买家申请退货，请审核！", 
		user.getUserinfoId(), shop.getUserinfo().getUserinfoId(),
		"returnGoodsAction_searchMyCheckList.action","returnId", returnGoodsid);*/
		return "savehavePurchaseOrderSonReturn";
	}

	// 审核时查找记录
	public String searchMyCheckList() {
		Shop shop = shopService.findShopByshopId(shopId);
		//Shop shop = shopService.findShopByshopId(242);
		String shopname=shop.getShopname();
		jsonMap.put("shopname", shopname);
		int shopId = shop.getShopId();
		List<ReturnGoods> checkReturnList = returnGoodsService.getMyCheckList(shopId,
				fromdate(), todate(), "0");
		int i=0;
		List usernamelist=new ArrayList<>();
		for(i=0;i<checkReturnList.size();i++){
			String a=checkReturnList.get(i).getUserinfo().getUsername();
			usernamelist.add(a);
		}
		jsonMap.put("username",usernamelist.get(0));
		if (checkReturnList == null || checkReturnList.size() == 0) {
			jsonMap.put("isResult", "false");
		}
		else{
		jsonMap.put("checkReturnList", checkReturnList);//checkReturnList 需要审核的退货申请表记录
		//location(checkReturnList);//定位
		jsonMap.put("isResult", "true");
		}
		return "checkhavePurchaseOrderSonReturn";
	}

	// 审核通过，更新申请表
	public String passupdate() {
		UserInfo user=userInfoService.getAdmin(userinfoId);
		//UserInfo user=userInfoService.getAdmin(245);
				Date now = new Date();
				int modelId = Integer.parseInt(req.getParameter("returngoodsId"));
				ReturnGoods model = returnGoodsService.get(modelId);
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				model.setRemainchecktime("0");
				model.setCheckuserinfo(user);

				model.setCheckTime(dateFormat.format(now));
				model.setCheckIdea(req.getParameter("checkIdea"));
				model.setState("1");
				returnGoodsService.update(model);// 更新申请表
				
				//更新订单表
				Order order= orderService.getOrder(model.getOrder().getOrderid());
				
				order.setState("53");//审核通过，等待填单
				orderService.update(order);
				//给买家发送消息
			/*	messageService.sendMessage(messageService,"您申请的退货卖家已审核通过，请填写货运单！", 
						user.getUserinfoId(), model.getUserinfo().getUserinfoId(),
		                "returnGoodsAction_searchMyPassList.action","returnId", modelId);*/

				jsonMap.put("isResult", "true");
		//searchMyCheckList();
		return "checkpassReturnGoodsRedirect";

	}

	// 审核不通过
	public String notpassupdate() {
	

		//UserInfo user=userInfoService.getAdmin(245);
		UserInfo user=userInfoService.getAdmin(userinfoId);
		Date now = new Date();
				int modelId = Integer.parseInt(req.getParameter("returngoodsId"));
				ReturnGoods model = returnGoodsService.get(modelId);
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				model.setRemainchecktime("0");
				model.setCheckuserinfo(user);

				model.setCheckTime(dateFormat.format(now));
				model.setCheckIdea(req.getParameter("checkIdea"));
				model.setState("2");
				returnGoodsService.update(model);// 更新店铺申请表
				
				//更新订单表
				Order order= orderService.get(model.getOrder().getOrderid());
				order.setState("52");//审核不通过
				orderService.update(order);
				/*//给买家发送消息
				messageService.sendMessage(messageService,"您申请的退货卖家审核不通过，请修改！", 
						user.getUserinfoId(), model.getUserinfo().getUserinfoId(),
		                "returnGoodsAction_searchMyAlterList.action","returnId", modelId);*/
		//request.put("msg_checkover", "审核完成，等待买家修改！");
		//searchMyCheckList();
		jsonMap.put("isResult", "true");
		return "checkdispassReturnGoodsRedirect";
	}

	// 修改时查找记录
	public String searchMyAlterList() {
		//UserInfo user = (UserInfo) session.get("userinfo");
		//int userid = user.getUserinfoId();
		UserInfo userinfo=userInfoService.getAdmin(userinfoId);
		jsonMap.put("userinfo", userinfo);
		List<ReturnGoods> alterReturnList = returnGoodsService.getMyAlterList(userinfoId,
				fromdate(), todate(), "2");
		if (alterReturnList == null || alterReturnList.size() == 0) {
			jsonMap.put("isResult", "false");
		}
		jsonMap.put("alterReturnList", alterReturnList);//alterReturnList需要修改的退货申请表记录
		//location(alterReturnList);//定位
		return "alterpassReturnGoodsRedirect";
	}

	// 修改时删除
	public String delete() {
		//更新订单表
		Integer returngoodsId= Integer.parseInt(req.getParameter("returngoodsId"));
		Integer orderid= Integer.parseInt(req.getParameter("orderid"));
		Order order= orderService.getOrder(orderid);
		order.setState("4");//删除后订单状态改为已收货
		orderService.update(order);
		
		//int id = model.getReturngoodsId();
		returnGoodsService.delete(returngoodsId);
			
		jsonMap.put("isResult", "true");
		//searchMyAlterList();
		return "alertdReturnGoodsRedirect";
	}

	// 修改提交
	public String alterUpdate() {
		Date now = new Date();
		Integer returngoodsId= Integer.parseInt(req.getParameter("returngoodsId"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ReturnGoods model2 = returnGoodsService.get(returngoodsId);
		model2.setApplyTime(dateFormat.format(now));
		model2.setReason(model.getReason());
		model2.setRemainchecktime("2");
		model2.setState("0");
		model2.setCheckTime("");
		model2.setCheckIdea("");
		returnGoodsService.update(model2);
		//更新订单表
		Integer orderid= Integer.parseInt(req.getParameter("orderid"));
		Order order= orderService.getOrder(orderid);
		order.setState("51");//修改完毕，等待审核
		orderService.update(order);
		jsonMap.put("isResult", "true");
		//给卖家发送消息
		/*messageService.sendMessage(messageService,"您有一个订单买家申请退货，请审核！", 
				model2.getUserinfo().getUserinfoId(), model2.getCheckuserinfo().getUserinfoId(),
		                "returnGoodsAction_searchMyCheckList.action","returnId", model.getReturngoodsId());		*/
			
		//searchMyAlterList();
		return "alertsReturnGoodsRedirect";
	}

	// 查找审核通过记录
	public String searchMyPassList() {
		UserInfo user = (UserInfo) session.get("userinfo");
		int userid = user.getUserinfoId();
		List<ReturnGoods> PassReturnList = returnGoodsService.getMyAlterList(userid,
				fromdate(), todate(), "1");
		if (PassReturnList == null || PassReturnList.size() == 0) {
			request.put("msg_searchMyPassList", "暂无需要填写物流信息的数据！");
		}
		request.put("PassReturnList", PassReturnList);//PassReturnList审核通过的退货申请表记录
		location(PassReturnList);//定位
		return "transInfoReturnGoods";
	}

	// 物流信息提交
	public String transInfoUpdate() {
		ReturnGoods model2 = returnGoodsService.get(model.getReturngoodsId());
		model2.setLogisticscompany(model.getLogisticscompany());
		model2.setLogisticsnum(model.getLogisticsnum());
		model2.setState("3"); // 已填写物流
		returnGoodsService.update(model2);
		
		//更新订单表
		Order order= orderService.get(model2.getOrder().getOrderid());
		order.setState("54");//填单完毕，等待卖家收货
		orderService.update(order);

		request.put("msg_writeover", "物流信息已填写，等待卖家收货！");
		//给卖家发送消息
		messageService.sendMessage(messageService,"您有一个订单买家已经填写货运单，请查收！", 
				model2.getUserinfo().getUserinfoId(), model2.getCheckuserinfo().getUserinfoId(),
		                "returnGoodsAction_searchMyConfirmList.action","returnId", model.getReturngoodsId());		
		
		searchMyPassList();
		return "viewReturnGoodsRedirect";
	}

	// 查找需要我收货的记录
	public String searchMyConfirmList() {
		UserInfo user = (UserInfo) session.get("userinfo");
		int userid = user.getUserinfoId();
		List<ReturnGoods> ConfirmReturnList = returnGoodsService.getMyConfirmList(userid,
				fromdate(), todate(), "3");
		if (ConfirmReturnList == null || ConfirmReturnList.size() == 0) {
			request.put("msg_searchMyConfirmList", "暂无需要收货的数据！");
		}
		request.put("ConfirmReturnList", ConfirmReturnList);//ConfirmReturnList需要我收货的退货申请表记录
		location(ConfirmReturnList);//定位
		return "confirmReturnGoods";
	}

	// 卖家已经收到货
	public String confirmUpdate() {
		ReturnGoods model2 = returnGoodsService.get(model.getReturngoodsId());
		model2.setState("4"); // 已收货并且退费
		returnGoodsService.update(model2);
		
		//更新订单表
		Order order= orderService.get(model2.getOrder().getOrderid());
		order.setState("5");//已退货
		orderService.update(order);

		request.put("msg_receive", "已收货并且退费，感谢您的光临！");
		
		//给买家发送消息
		messageService.sendMessage(messageService,"您申请的退货卖家已收货，请查看！", 
				model2.getCheckuserinfo().getUserinfoId(), model2.getUserinfo().getUserinfoId(),
                "returnGoodsAction_searchMyViewList.action","returnId", model.getReturngoodsId());
		
		searchMyConfirmList();
		return "viewReturnGoodsRedirect";
	}

	// 查看退货记录(徐乐)
	public String searchMyViewList() {
		List<ReturnGoods> viewReturnList = returnGoodsService.getMyViewList(userinfoId,
				fromdate(), todate());
		UserInfo userinfo=userInfoService.getAdmin(userinfoId);
		jsonMap.put("userinfo", userinfo);
		if (viewReturnList == null || viewReturnList.size() == 0) {
			jsonMap.put("isResult", "false");
		}
		else{
		jsonMap.put("viewReturnList", viewReturnList);//viewReturnList查看我的退货申请表记录
		jsonMap.put("isResult", "true");
		//location(viewReturnList);//定位
		}
		return "viewReturnGoodsRedirect";
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void location(List list) {
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
		}
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