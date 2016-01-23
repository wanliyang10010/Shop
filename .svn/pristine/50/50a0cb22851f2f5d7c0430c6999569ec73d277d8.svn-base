package cn.xaut.shop.action;

import java.util.List;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.ShopEvaluation;
import cn.xaut.shop.pojo.UserInfo;

public class ShopEvaluationAction extends BaseAction<ShopEvaluation> {

	private static final long serialVersionUID = 1L;
	// 转发店铺积分
	public String forwardShopPoint() {
		UserInfo user = (UserInfo) session.get("userinfo");
		// 得到店铺表分值、店铺评价表信息
		List<Shop> shopList = shopService.getListByUserId(user.getUserinfoId());
		if (shopList == null || shopList.size() == 0) {
			request.put("msg_shoppoint", "暂无数据！");
		} else {
			String shoppoint = shopList.get(0).getPoint() + "分";
			request.put("msg_shoppoint", shoppoint);
			List<ShopEvaluation> shopEvaluationList = shopEvaluationService.getListByShopId(shopList.get(0).getShopId());
			if (shopEvaluationList == null || shopEvaluationList.size() == 0) {
				request.put("msg_shopEvaluationList", "0分");
			} else {
				request.put("shopEvaluationList", shopEvaluationList);
			}	
			page = shopEvaluationService.getListByShopId(page,shopList.get(0).getShopId());
			request.put("page", page);
		}
		return "forwardShopPoint";
	}
}
