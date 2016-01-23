package cn.xaut.shop.phoneAction;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.GoodsEvaluation;
import cn.xaut.shop.pojo.OrderSon;
import cn.xaut.shop.pojo.ShopEvaluation;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.pojo.UserPoint;

public class GoodsEvaluationActionPhone extends BaseAction<GoodsEvaluation> {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest req = ServletActionContext.getRequest();

	
	////用户-店铺积分dwj
	public String forwardUserShopPoint() {
		
		String userinfoId =ServletActionContext.getRequest().getParameter("userinfoId");  
		UserInfo user=userInfoService.getAdmin(Integer.parseInt(userinfoId));				
		// 得到店铺表分值、店铺评价表信息
		List<Shop> shopList = shopService.getListByUserId(user.getUserinfoId());
		if (shopList == null || shopList.size() == 0) {
			jsonMap.put("msg_shoppoint", "0分");
		} else {
			String shoppoint = shopList.get(0).getPoint() + "分";
			jsonMap.put("msg_shoppoint", shoppoint);			
		}
		// 得到买家积分、会员积分表信息
		List<UserPoint> userPointList = userPointService.getListByUserId(user
				.getUserinfoId());
		if (userPointList == null || userPointList.size() == 0) {
			jsonMap.put("msg_userpoint", "0分");
		} else {
			int userpointTemp = 0;
			for (int i = 0; i < userPointList.size(); i++) {
				userpointTemp += userPointList.get(i).getPoint();
			}
			////int userpointTemp=userPointList.get(0).getPoint();			
			String userpoint = userpointTemp + "分";
			jsonMap.put("msg_userpoint", userpoint);
		}					
		return "forwardUserShopPoint";
	}

	// 初次评价，填写商品评价表、店铺评价表、用户积分表，更新子订单表、店铺表
	public String save() {
		//UserInfo user = (UserInfo) session.get("userinfo");
		String userinfoId = req.getParameter("userinfoId");
		UserInfo user = userInfoService.getAdmin(Integer.parseInt(userinfoId));
		Date now = new Date();

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		// 商品评价表,对商品的评价应该是根据ordersonId
		OrderSon orderSon = orderSonService.get(Integer.parseInt(req.getParameter("ordersonId")));
		model.setOrderSon(orderSon);
		Shop shop = shopService.get(Integer.parseInt(req.getParameter("shopId")));
		model.setShop(shop);
		model.setUserinfo(user);
		model.setEvaluationTime(dateFormat.format(now));
		Goods goods = goodsService.get(Integer.parseInt(req.getParameter("goodsId")));
		model.setGoods(goods);

		int goodspoint = Integer.parseInt(req.getParameter("goodspoint"));
		String ispublic = req.getParameter("ispublic");

		if (req.getParameter("goodscontent") == null|| req.getParameter("goodscontent") == "")
		{
			model.setGoodscontent("好评！");
		}
		model.setGoodspoint(goodspoint);
		model.setIspublic(ispublic);
		model.setState("0");// 初次买家评价
		goodsEvaluationService.save(model);// 保存商品评价表
		
		//更改子订单状态		
		orderSon.setSonstate("41");//代表已经评价，但是卖家未回复
		orderSonService.update(orderSon);
		
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
		shopEvaluationService.save(shopEvaluation);// 保存店铺评价表

		// 更新店铺表
		int piont = shop.getPoint();
		int newpiont = (int) Math.ceil((piont + shopEvaluation.getShoppoint()) / 2.0);
		shop.setPoint(newpiont);
		shopService.update(shop);// 更新店铺表，店铺评分部分

		//新增加会员积分表
		UserPoint userPoint = new UserPoint();
		userPoint.setUserinfo(user);
		userPoint.setOperateTime(dateFormat.format(now));
		userPoint.setPoint(1);
		userPoint.setPlusminus("+");
		userPoint.setContent("评价奖励");
		userPointService.save(userPoint);// 保存会员积分表

		//searchPointEvaluation();	
		//return "otherPostViewEvaluationAction";//跳转至给他人的评价
        jsonMap.put("isResult", "true");		
		return "save";
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
				userpointTemp += userPointList.get(i).getPoint();
			}
			String userpoint = userpointTemp + "分";
			request.put("msg_userpoint", userpoint);
			request.put("userPointList", userPointList);
		}

		// 得到来自买家的评价
		if (shopList == null || shopList.size() == 0) {
			request.put("msg_frombuy", "亲，您没有开店，没有来自于买家的评论哦！");
		}else {
		List<GoodsEvaluation> fromBuyList = goodsEvaluationService
				.getListByUserIdAndShopId(shopList.get(0).getShopId());
		if (fromBuyList == null || fromBuyList.size() == 0) {
			request.put("msg_frombuy", "亲，没有来自买家的评价哦！");
		} else {
			request.put("fromBuyList", fromBuyList);
		}
		}
		// 得到来自卖家的评价
		List<GoodsEvaluation> fromSellList = goodsEvaluationService
				.getListByUserIdAndCheckId(user.getUserinfoId());
		if (fromSellList == null || fromSellList.size() == 0) {
			request.put("msg_fromsell", "亲，没有来自卖家的评价哦！");
		} else {

			request.put("fromSellList", fromSellList);
		}
		// 得到给他人的评价
		List<GoodsEvaluation> toOtherList = goodsEvaluationService
				.getListByUserId(user.getUserinfoId());
		if (toOtherList == null || toOtherList.size() == 0) {
			request.put("msg_toother", "亲，没有给他人的评价哦！");
		} else {

			request.put("toOtherList", toOtherList);
		}
		return "postViewEvaluation";
	}
	
	// 获得店铺积分、会员积分
	public String searchPointEvaluationP() {
		String userinfoId = req.getParameter("userinfoId");
		//UserInfo user = userInfoService.getAdmin(Integer.parseInt(userinfoId));
		// 得到店铺表分值、店铺评价表信息
		List<Shop> shopList = shopService.getListByUserId(Integer.parseInt(userinfoId));
		if (shopList == null || shopList.size() == 0) {
			jsonMap.put("msg_shoppoint", "暂无数据！");
		} else {
			String shoppoint = shopList.get(0).getPoint() + "分";
			jsonMap.put("msg_shoppoint", shoppoint);
		}

		// 得到买家积分、会员积分表信息
		List<UserPoint> userPointList = userPointService.getListByUserId(Integer.parseInt(userinfoId));
		if (userPointList == null || userPointList.size() == 0) {
			jsonMap.put("msg_userpoint", "0分");
		} else {
			int userpointTemp = 0;
			for (int i = 0; i < userPointList.size(); i++) {
				userpointTemp += userPointList.get(i).getPoint();
			}
			String userpoint = userpointTemp + "分";
			jsonMap.put("msg_userpoint", userpoint);
		}

		// 得到来自买家的评价
		if (shopList == null || shopList.size() == 0) {
			jsonMap.put("msg_frombuy", "亲，您没有开店，没有来自于买家的评论哦！");
		}else {
			List<GoodsEvaluation> fromBuyList = goodsEvaluationService
					.getListByUserIdAndShopId(shopList.get(0).getShopId());
			if (fromBuyList == null || fromBuyList.size() == 0) {
				jsonMap.put("msg_frombuy", "亲，没有来自买家的评价哦！");
			} else {
				jsonMap.put("fromBuyList", fromBuyList);
			}
		}
		
		return "postViewEvaluationP";
	}
	
	// 得到来自买家的评价
	public String fromBuyComment() {
		String userinfoId = req.getParameter("userinfoId");
		//UserInfo user = userInfoService.getAdmin(Integer.parseInt(userinfoId));
		// 得到店铺表分值、店铺评价表信息
		List<Shop> shopList = shopService.getListByUserId(Integer.parseInt(userinfoId));

		// 得到来自买家的评价
		if (shopList == null || shopList.size() == 0) {
			jsonMap.put("isResult", "false");
			return "fromBuyComment";
		}else {
			List<GoodsEvaluation> fromBuyList = goodsEvaluationService
					.getListByUserIdAndShopId(shopList.get(0).getShopId());
			if (fromBuyList == null || fromBuyList.size() == 0) {
				jsonMap.put("isResult", "false");
				return "fromBuyComment";
			} else {
				jsonMap.put("fromBuyList", fromBuyList);
				return "fromBuyComment";
			}
		}	
	}
	
	// 给他人的评价
	public String fromOtherComment() {
		String userinfoId = req.getParameter("userinfoId");
		// 得到给他人的评价
		List<GoodsEvaluation> toOtherList = goodsEvaluationService.getListByUserId(Integer.parseInt(userinfoId));
		if (toOtherList == null || toOtherList.size() == 0) {
			jsonMap.put("isResult", "false");
			return "fromOtherComment";
		} else {
			jsonMap.put("toOtherList", toOtherList);
			return "fromOtherComment";
		}	
	}
    
	//获取会员积分
	public String getUserpoint(){
		String userinfoId = req.getParameter("userinfoId");
		//UserInfo user = userInfoService.getAdmin(Integer.parseInt(userinfoId));
		// 得到店铺表分值、店铺评价表信息
		List<UserPoint> userPointList = userPointService.getListByUserId(Integer.parseInt(userinfoId));
		if (userPointList == null || userPointList.size() == 0) {
			jsonMap.put("msg_userpoint", "0分");
			return "getUserpoint";
		} else {
			int userpointTemp = 0;
			for (int i = 0; i < userPointList.size(); i++) {
				userpointTemp += userPointList.get(i).getPoint();
			}
			String userpoint = userpointTemp + "分";
			jsonMap.put("msg_userpoint", userpoint);
			return "getUserpoint";
		}
		
	}
	
	//获取会员积分
	public String getShoppoint(){
		String userinfoId = req.getParameter("userinfoId");
		//UserInfo user = userInfoService.getAdmin(Integer.parseInt(userinfoId));
		// 得到店铺表分值、店铺评价表信息
		List<Shop> shopList = shopService.getListByUserId(Integer.parseInt(userinfoId));
		if (shopList == null || shopList.size() == 0) {
			jsonMap.put("msg_shoppoint", "暂无数据！");
			return "getShoppoint";
		} else {
			String shoppoint = shopList.get(0).getPoint() + "分";
			jsonMap.put("msg_shoppoint", shoppoint);
			return "getShoppoint";
		}
		
	}
	
	//转发店铺积分
	public String forwardShopPoint() {
		searchPointEvaluation();
		return "forwardShopPoint";
	}

	public String viewShopPoint() {
		
		String  userid = req.getParameter("userId");
		// 得到店铺表分值、店铺评价表信息
		List<Shop> shopList = shopService.getListByUserId(Integer.parseInt(userid));
		if (shopList == null || shopList.size() == 0) {
			jsonMap.put("isResult", "false");
			return "viewShopPoint";
		} else {
			List<ShopEvaluation> shopEvaluationList = shopEvaluationService.getListByShopId(shopList.get(0).getShopId());
			if (shopEvaluationList == null || shopEvaluationList.size() == 0) {
				jsonMap.put("isResult", "false");
				return "viewShopPoint";
			} else {
				jsonMap.put("isResult", shopEvaluationList);
				 return "viewShopPoint";
			}
		}
	}
	
	//转发用户积分
	public String forwardUserPoint() {
		searchPointEvaluation();
		return "forwardUserPoint";
	}

	
	public String viewUserPoint() {
		// 得到买家积分、会员积分表信息		
		String  userid = req.getParameter("userId");
		List<UserPoint> userPointList = userPointService.getListByUserId(Integer.parseInt(userid));
		if (userPointList == null || userPointList.size() == 0) {
			jsonMap.put("isResult", "false");		
		     return "viewUserPoint";
		} else {		
			 jsonMap.put("isResult", userPointList);		
		     return "viewUserPoint";
		}
	}
	// 转发买家评论页面
	public String buySearchPointEvaluation() {
		searchPointEvaluation();
		return "buyPostViewEvaluation";
	}

	//转发他人评论页面
	public String otherSearchPointEvaluation() {
		searchPointEvaluation();
		return "otherPostViewEvaluation";
	}

	// 更新商品评价表，使之匿名
	public String notpublic() {
		int id = Integer.parseInt(req.getParameter("id"));
		// 商品评价表
		GoodsEvaluation model = goodsEvaluationService.get(id);
		model.setIspublic("0");//0代表匿名
		goodsEvaluationService.update(model);// 更新商品评价表
		//searchPointEvaluation();
		jsonMap.put("isResult", "true");
		return "notpublic";
	}

	// 对来自于买家的信息进行回复
	public String replyfrombuy() {
		int id = Integer.parseInt(req.getParameter("id"));
		GoodsEvaluation model = goodsEvaluationService.get(id);

		UserInfo user = (UserInfo) session.get("userinfo");
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		model.setCheckuserinfo(user);		
		model.setCheckTime(dateFormat.format(now));
		model.setCheckIdea(req.getParameter("checkIdea"));
		model.setState("1");// 卖家已经回复
		goodsEvaluationService.update(model);// 更新商品评价表
		
		//更改子订单状态		
		OrderSon orderSon=orderSonService.get(model.getOrderSon().getOrdersonId());
		orderSon.setSonstate("42");//代表卖家已经回复
		orderSonService.update(orderSon);
		
		//searchPointEvaluation();
		jsonMap.put("isResult", "true");		
		return "replyfrombuy";//ajax提交，返回后不执行返回值内容
	}

	// 对来自于卖家的信息进行回复(追评)
	public String replyfromsell() {
		int id = Integer.parseInt(req.getParameter("id"));
		GoodsEvaluation model = goodsEvaluationService.get(id);

		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		model.setAddTime(dateFormat.format(now));
		model.setAddcontent(req.getParameter("addcontent"));
		model.setState("2");// 买家已经追评
		goodsEvaluationService.update(model);// 更新商品评价表
		
		//更改子订单状态	
		OrderSon orderSon=orderSonService.get(model.getOrderSon().getOrdersonId());
		orderSon.setSonstate("43");//代表已经追评
		orderSonService.update(orderSon);
		//searchPointEvaluation();
		jsonMap.put("isResult", "true");
		return "replyfromsell";//ajax提交，返回后不执行返回值内容
	}
	
}
