package cn.xaut.shop.phoneAction;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.ProlongApply;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.util.JSONUtils;

@SuppressWarnings("unchecked")
public class ProlongApplyActionPhone extends BaseAction<ProlongApply> {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest req = ServletActionContext.getRequest();

	// 申请时添加申请表，更新订单表
	public String save() {
		String userId = req.getParameter("userId");
		UserInfo user = userInfoService.getAdmin(Integer.parseInt(userId));
		//UserInfo user = (UserInfo) session.get("userinfo");
		String dayapply = req.getParameter("dayapply");
		model.setDayapply(dayapply);
		String reason = req.getParameter("reason");
		model.setReason(reason);
		Date now = new Date();
		model.setUserinfo(user);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		model.setApplyTime(dateFormat.format(now));

		Order order= orderService.get(Integer.parseInt(req.getParameter("orderid")));
		model.setOrder(order);
		Shop shop = shopService.get(Integer.parseInt(req.getParameter("shopId")));
		model.setShop(shop);
		model.setRemainchecktime("2");
		model.setState("0");
		int prolongApplyid=prolongApplyService.add(model).getProlongapplyId();//添加延长收货时间申请表
		
		//更新订单表
		order.setState("31");
		orderService.update(order);
		
		/*//给卖家发送消息
		messageService.sendMessage(messageService,"您有一个订单买家申请延长收货时间，请审核！", 
				user.getUserinfoId(), shop.getUserinfo().getUserinfoId(),
                "prolongApplyAction_searchMyCheckList.action","prolongId", prolongApplyid);*/
		jsonMap.put("isResult", "true");
		return "listProlongApply";
	}

	// 审核时查找记录
	public String searchMyCheckList() {
		//Shop shop = (Shop) session.get("shop");
		String userId = req.getParameter("userId");
		//String userId = Struts2Utils.getParameter("userId");
		Shop shop = shopService.checkShopidByUserId(Integer.parseInt(userId));		
		int shopId = shop.getShopId();
		page = prolongApplyService.getMyCheckListPhone(page, shopId, "0"); 
		if(page.getTotalItems()>0){
			//String jsonList = JSONUtils.toJSONString(page);
			jsonMap.put("isResult", page);
			return "checkProlongApply";
			
		}else{
			jsonMap.put("isResult", "false");
			return "checkProlongApply";
		}
			
	}

	// 审核通过，更新申请表
	public String passupdate() {
		String prolongapplyId = req.getParameter("id");
		String[] valus=new String[1];
		valus[0]=prolongapplyId;
		String userId = req.getParameter("CheckId");
		UserInfo user = userInfoService.findById(Integer.parseInt(userId));
		Date now = new Date();
		if (valus.length != 0) {
			for (int i = 0; i < valus.length; i++) {
				int modelId = Integer.parseInt(valus[i]);
				ProlongApply model = prolongApplyService.get(modelId);
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				model.setRemainchecktime("0");
				model.setCheckuserinfo(user);
				model.setCheckTime(dateFormat.format(now));
				model.setCheckIdea(req.getParameter("checkIdea"));
				model.setState("1");
				prolongApplyService.update(model);// 更新延长收货时间申请表
				
				//更新订单表
				Order order= orderService.get(model.getOrder().getOrderid());
				order.setState("33");//审核通过，已经延长收货时间
				orderService.update(order);
				
				//给买家发送消息
				/*messageService.sendMessage(messageService,"您申请的延长收货时间卖家已审核通过，请查看！", 
						user.getUserinfoId(), model.getUserinfo().getUserinfoId(),
		                "prolongApplyAction_searchMyViewList.action","prolongId", modelId);*/
			}
		}
		jsonMap.put("isResult", "true");
		return "checkProlongApplyRedirect";

	}

	// 审核不通过
	public String notpassupdate() {
		String prolongapplyId = req.getParameter("id");
		String[] valus=new String[1];
		valus[0]=prolongapplyId;
		String userId = req.getParameter("CheckId");
		UserInfo user = userInfoService.findById(Integer.parseInt(userId));
		Date now = new Date();
		if (valus.length != 0) {
			for (int i = 0; i < valus.length; i++) {
				int modelId = Integer.parseInt(valus[i]);
				ProlongApply model = prolongApplyService.get(modelId);
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				model.setRemainchecktime("0");
				model.setCheckuserinfo(user);			
				model.setCheckTime(dateFormat.format(now));
				model.setCheckIdea(req.getParameter("checkIdea"));
				model.setState("2");
				prolongApplyService.update(model);// 更新延长收货时间申请表
				
				//更新订单表
				Order order= orderService.get(model.getOrder().getOrderid());
				order.setState("32");//审核不通过
				orderService.update(order);
				
				//给买家发送消息
				//messageService.sendMessage(messageService,"您申请的延长收货时间卖家审核不通过，请修改！", 
					//	user.getUserinfoId(), model.getUserinfo().getUserinfoId(),
		               // "prolongApplyAction_searchMyAlterList.action","prolongId", modelId);
			}
		}
		jsonMap.put("isResult", "true");
		return "checkProlongApplyRedirect";
	}

	// 修改时查找记录
	public String searchMyAlterList() {
		String userId = req.getParameter("userId");
		page = prolongApplyService.getMyAlterListPhone(page, Integer.parseInt(userId), "2");

		if(page.getTotalItems()>0){
			//String jsonList = JSONUtils.toJSONString(page);
			jsonMap.put("isResult", page);
			return "alterProlongApply";
			
		}else{
			jsonMap.put("isResult", "false");
			return "alterProlongApply";
		}
		
	}
	
	//删除订单
	public String delete() {
		//更新订单表
		Order order= orderService.get(Integer.parseInt(req.getParameter("orderid")));
		order.setState("3");//删除后订单状态改为已发货
		//orderService.update(order);
				
		String id = req.getParameter("id");
		//prolongApplyService.delete(Integer.parseInt(id));
				
		jsonMap.put("isResult", "true");
		return "deleteAlterProlong";
	}

	// 修改提交
	public String alterUpdate() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String id = req.getParameter("id");
		ProlongApply model2 = prolongApplyService
				.get(Integer.parseInt(id));

		model2.setApplyTime(dateFormat.format(now));
		model2.setDayapply(req.getParameter("dayapply"));
		model2.setReason(req.getParameter("reason"));
		model2.setRemainchecktime("2");
		model2.setState("0");
		model2.setCheckTime("");
		model2.setCheckIdea("");
		prolongApplyService.update(model2);// 更新延长收货时间申请表
		
		//更新订单表
		Order order= orderService.get(model2.getOrder().getOrderid());
		order.setState("31");//修改完毕，等待审核
		orderService.update(order);

		//request.put("msg_alterover", "修改已完成！");
		
		//给卖家发送消息
		/*messageService.sendMessage(messageService,"您有一个订单买家申请延长收货时间，请审核！", 
				model2.getUserinfo().getUserinfoId(), model2.getCheckuserinfo().getUserinfoId(),
		                "prolongApplyAction_searchMyCheckList.action","prolongId", model.getProlongapplyId());		*/
		
		//searchMyAlterList();
		//return "viewProlongApplyRedirect";
		jsonMap.put("isResult", "true");
		return "UpdataAlterProlongApply";
	}

	// 查看时查找记录
	public String searchMyViewList() {
		String userId = req.getParameter("userId");
		page = prolongApplyService.getMyViewListPhone(page,Integer.parseInt(userId));

		if(page.getTotalItems()>0){
			//String jsonList = JSONUtils.toJSONString(page);
			jsonMap.put("isResult", page);
			return "viewProlongApply";
			
		}else{
			jsonMap.put("isResult", "false");
			return "viewProlongApply";
		}
		
	}
	
}
