package cn.xaut.shop.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.GoodsEvaluation;
import cn.xaut.shop.pojo.OrderSon;
import cn.xaut.shop.pojo.ShopEvaluation;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.pojo.UserPoint;

public class GoodsEvaluationAction extends BaseAction<GoodsEvaluation> {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest req = ServletActionContext.getRequest();

	// 初次评价，填写商品评价表、店铺评价表、用户积分表，更新子订单表、店铺表、会员表
	public String save() {
		UserInfo user = (UserInfo) session.get("userinfo");
		Date now = new Date();

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		// 商品评价表,对商品的评价应该是根据ordersonId
		OrderSon orderSon = orderSonService.get(Integer.parseInt(req.getParameter("ordersonId")));
		
		if(orderSon.getSonstate().equals("41") || orderSon.getSonstate().equals("42")
				|| orderSon.getSonstate().equals("43")){
			return "reOperation";
		}
		
		model.setOrderSon(orderSon);
		Shop shop = shopService.get(Integer.parseInt(req.getParameter("shopId")));
		model.setShop(shop);
		model.setUserinfo(user);
		model.setEvaluationTime(dateFormat.format(now));
		Goods goods = goodsService.get(Integer.parseInt(req
				.getParameter("goodsId")));
		model.setGoods(goods);

		int goodspoint = Integer.parseInt(req.getParameter("goodspoint"));
		String ispublic = req.getParameter("ispublic");

		if (req.getParameter("goodscontent") == null
				|| req.getParameter("goodscontent") == "") {
			model.setGoodscontent("好评！");
		}
		model.setGoodspoint(goodspoint);
		model.setIspublic(ispublic);
		model.setState("0");// 初次买家评价
		
		//1111111111
		//goodsEvaluationService.save(model);// 保存商品评价表
		
		//更改子订单状态		
		orderSon.setSonstate("41");//代表已经评价，但是卖家未回复
		
		//22222222222
		//orderSonService.update(orderSon);
		
		//新增加店铺评价表
		ShopEvaluation shopEvaluation = new ShopEvaluation();
		shopEvaluation.setOrderSon(orderSon);
		shopEvaluation.setShop(shop);
		shopEvaluation.setUserinfo(user);
		shopEvaluation.setEvaluationTime(dateFormat.format(now));
		shopEvaluation.setGoods(goods);

		int describepoint = Integer.parseInt(req.getParameter("stars1-input"));
		int servicepoint = Integer.parseInt(req.getParameter("stars2-input"));
		int speedpoint = Integer.parseInt(req.getParameter("stars3-input"));
		shopEvaluation.setDescribepoint(describepoint);
		shopEvaluation.setServicepoint(servicepoint);
		shopEvaluation.setSpeedpoint(speedpoint);
		int shoppoint = shopEvaluation.getDescribepoint() + shopEvaluation.getServicepoint()
				+ shopEvaluation.getSpeedpoint();
		if (shoppoint > 11) {
			shopEvaluation.setShoppoint(3);
		} else if (shoppoint < 7) {
			shopEvaluation.setShoppoint(1);
		} else {
			shopEvaluation.setShoppoint(2);
		}
		
		//333333333333333
		//shopEvaluationService.save(shopEvaluation);// 保存店铺评价表

		// 更新店铺表
		int piont = shop.getPoint();
		int newpiont = (int) Math.ceil((piont + shopEvaluation.getShoppoint()) / 2.0);
		shop.setPoint(newpiont);
		
		//4444444444444444
		//shopService.update(shop);// 更新店铺表，店铺评分部分

		//新增加会员积分表
		UserPoint userPoint = new UserPoint();
		userPoint.setUserinfo(user);
		userPoint.setOperateTime(dateFormat.format(now));
		userPoint.setPoint(1);
		userPoint.setPlusminus("+");
		userPoint.setContent("评价奖励");
		
		//5555555555555555
		//userPointService.save(userPoint);// 保存会员积分表
		
		//会员表会员积分增加一分
		user.setPoints(user.getPoints()+1);
		
		//66666666666666666
		//userInfoService.merge(user);
		
		goodsEvaluationService.saveForFirstEvaluation(model,orderSon,shopEvaluation,shop,userPoint,user);
		
		searchPointEvaluation();
		return "otherPostViewEvaluationRedirect";//跳转至给他人的评价
	}

	// 积分评价查看页面、店铺积分页面、会员积分页面初始化
	public String searchPointEvaluation() {
		UserInfo user = (UserInfo) session.get("userinfo");
		// 得到店铺表分值、店铺评价表信息
		List<Shop> shopList = shopService.getListByUserId(user.getUserinfoId());
		if (shopList == null || shopList.size() == 0) {
			request.put("msg_shoppoint", "暂无数据！");
		} else {
			String shoppoint = shopList.get(0).getPoint() + "分";
			request.put("msg_shoppoint", shoppoint);

			List<ShopEvaluation> shopEvaluationList = shopEvaluationService
					.getListByShopId(shopList.get(0).getShopId());
			if (shopEvaluationList == null || shopEvaluationList.size() == 0) {
				request.put("msg_shopEvaluationList", "0分");
			} else {
				request.put("shopEvaluationList", shopEvaluationList);
			}				
		}

		// 得到买家积分、会员积分表信息
		List<UserPoint> userPointList = userPointService.getListByUserId(user
				.getUserinfoId());
		if (userPointList == null || userPointList.size() == 0) {
			request.put("msg_userpoint", "0分");
		} else {
			int userpointTemp = 0;
			for (int i = 0; i < userPointList.size(); i++) {
				if(userPointList.get(i).getPlusminus().equals("+")){
					userpointTemp += userPointList.get(i).getPoint();
				}else if(userPointList.get(i).getPlusminus().equals("-")){
					userpointTemp -= userPointList.get(i).getPoint();
				}else{
					request.put("msg_userpoint", "对不起，您的积分有误，请联系管理员！");
				}				
			}
			String userpoint = userpointTemp + "分";
			request.put("msg_userpoint", userpoint);
			request.put("userPointList", userPointList);
		}	
		// 得到来自卖家的评价
		page = goodsEvaluationService.getListByUserIdAndCheckId(page,user.getUserinfoId());
		if (page == null || page.getTotalItems() == 0) {
			request.put("msg_fromsell", "亲，没有来自卖家的评价哦！");
		}else {
		request.put("page", page);
		}				
		return "postViewEvaluation";
	}
	
    // 转发买家评论页面
	public String buySearchPointEvaluation() {
		UserInfo user = (UserInfo) session.get("userinfo");
		// 得到店铺表分值、店铺评价表信息
		List<Shop> shopList = shopService.getListByUserId(user.getUserinfoId());
		if (shopList == null || shopList.size() == 0) {
			request.put("msg_shoppoint", "暂无数据！");
		} else {
			String shoppoint = shopList.get(0).getPoint() + "分";
			request.put("msg_shoppoint", shoppoint);

			List<ShopEvaluation> shopEvaluationList = shopEvaluationService
					.getListByShopId(shopList.get(0).getShopId());
			if (shopEvaluationList == null || shopEvaluationList.size() == 0) {
				request.put("msg_shopEvaluationList", "0分");
			} else {
				request.put("shopEvaluationList", shopEvaluationList);
			}				
		}

		// 得到买家积分、会员积分表信息
		List<UserPoint> userPointList = userPointService.getListByUserId(user
				.getUserinfoId());
		if (userPointList == null || userPointList.size() == 0) {
			request.put("msg_userpoint", "0分");
		} else {
			int userpointTemp = 0;
			for (int i = 0; i < userPointList.size(); i++) {
				if(userPointList.get(i).getPlusminus().equals("+")){
					userpointTemp += userPointList.get(i).getPoint();
				}else if(userPointList.get(i).getPlusminus().equals("-")){
					userpointTemp -= userPointList.get(i).getPoint();
				}else{
					request.put("msg_userpoint", "对不起，您的积分有误，请联系管理员！");
				}				
			}
			String userpoint = userpointTemp + "分";
			request.put("msg_userpoint", userpoint);
			request.put("userPointList", userPointList);
		}	
		// 得到来自买家的评价
		if (shopList == null || shopList.size() == 0) {
			request.put("msg_frombuy", "亲，您没有开店，没有来自于买家的评论哦！");
		}else {						
		page = goodsEvaluationService.getListByUserIdAndShopId(page,shopList.get(0).getShopId());
		if (page == null || page.getTotalItems() == 0) {
			request.put("msg_frombuy", "亲，没有来自买家的评价哦！");
		}else {
			request.put("page", page);
			}
		}
		return "buyPostViewEvaluation";
	}

	// 转发他人评论页面
	public String otherSearchPointEvaluation() {
		UserInfo user = (UserInfo) session.get("userinfo");
		// 得到店铺表分值、店铺评价表信息
		List<Shop> shopList = shopService.getListByUserId(user.getUserinfoId());
		if (shopList == null || shopList.size() == 0) {
			request.put("msg_shoppoint", "暂无数据！");
		} else {
			String shoppoint = shopList.get(0).getPoint() + "分";
			request.put("msg_shoppoint", shoppoint);

			List<ShopEvaluation> shopEvaluationList = shopEvaluationService
					.getListByShopId(shopList.get(0).getShopId());
			if (shopEvaluationList == null || shopEvaluationList.size() == 0) {
				request.put("msg_shopEvaluationList", "0分");
			} else {
				request.put("shopEvaluationList", shopEvaluationList);
			}				
		}

		// 得到买家积分、会员积分表信息
		List<UserPoint> userPointList = userPointService.getListByUserId(user
				.getUserinfoId());
		if (userPointList == null || userPointList.size() == 0) {
			request.put("msg_userpoint", "0分");
		} else {
			int userpointTemp = 0;
			for (int i = 0; i < userPointList.size(); i++) {
				if(userPointList.get(i).getPlusminus().equals("+")){
					userpointTemp += userPointList.get(i).getPoint();
				}else if(userPointList.get(i).getPlusminus().equals("-")){
					userpointTemp -= userPointList.get(i).getPoint();
				}else{
					request.put("msg_userpoint", "对不起，您的积分有误，请联系管理员！");
				}				
			}
			String userpoint = userpointTemp + "分";
			request.put("msg_userpoint", userpoint);
			request.put("userPointList", userPointList);
		}	
		page = goodsEvaluationService.getListByUserId(page,user.getUserinfoId());
		if (page == null || page.getTotalItems() == 0) {
			request.put("msg_toother", "亲，没有给他人的评价哦！");
		}else {
			request.put("page", page);
			}
		return "otherPostViewEvaluation";
	}	

	// 更新商品评价表，使之匿名
	public String notpublic() {
		int id = Integer.parseInt(req.getParameter("id"));
		// 商品评价表
		GoodsEvaluation model = goodsEvaluationService.get(id);
		
		if(model.getIspublic().equals("0")){
			jsonMap.put("data", "no");
			return "json";
		}
		
		model.setIspublic("0");//0代表匿名
		goodsEvaluationService.update(model);// 更新商品评价表
		searchPointEvaluation();
		return "json";
	}

	// 对来自于买家的信息进行回复
	public String replyfrombuy() {
		int id = Integer.parseInt(req.getParameter("id"));
		GoodsEvaluation model = goodsEvaluationService.get(id);

		if(model.getState().equals("1") || model.getState().equals("2")){
			jsonMap.put("data", "no");
			return "json";			
		}
		
		UserInfo user = (UserInfo) session.get("userinfo");
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		model.setCheckuserinfo(user);		
		model.setCheckTime(dateFormat.format(now));
		model.setCheckIdea(req.getParameter("checkIdea"));
		model.setState("1");// 卖家已经回复
		//goodsEvaluationService.update(model);// 更新商品评价表
		
		//更改子订单状态		
		OrderSon orderSon=orderSonService.get(model.getOrderSon().getOrdersonId());
		orderSon.setSonstate("42");//代表卖家已经回复
		//orderSonService.update(orderSon);
		
		goodsEvaluationService.updateForReplyfrombuy(model,orderSon);
		
		searchPointEvaluation();
		return "json";
	}

	// 对来自于卖家的信息进行回复
	public String replyfromsell() {
		int id = Integer.parseInt(req.getParameter("id"));
		GoodsEvaluation model = goodsEvaluationService.get(id);
		
		if(model.getState().equals("2")){
			jsonMap.put("data", "no");
			return "json";
		}
		
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		model.setAddTime(dateFormat.format(now));
		model.setAddcontent(req.getParameter("addcontent"));
		model.setState("2");// 买家已经追评
		//goodsEvaluationService.update(model);// 更新商品评价表
		
		//更改子订单状态	
		OrderSon orderSon=orderSonService.get(model.getOrderSon().getOrdersonId());
		orderSon.setSonstate("43");//代表已经追评
		//orderSonService.update(orderSon);
		goodsEvaluationService.updateForReplyfromSell(model,orderSon);
		
		searchPointEvaluation();
		return "json";
	}
	public String viewEvaluation() {
		int ordersonId = Integer.parseInt(req.getParameter("ordersonId"));
		List<GoodsEvaluation> goodsEvaluationList = goodsEvaluationService.getGoodsEvaluationByordersonId(ordersonId);
		if (goodsEvaluationList == null || goodsEvaluationList.size() == 0) {
			request.put("msg_goodsEvaluation", "评价暂时在路上，请联系管理员火速修复！");
		}else {
			GoodsEvaluation goodsEvaluationModel=goodsEvaluationList.get(0);
			request.put("goodsEvaluationModel", goodsEvaluationModel);
			}		
		return "viewEvaluation";
	}
}