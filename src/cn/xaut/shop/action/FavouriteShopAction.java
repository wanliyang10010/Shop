package cn.xaut.shop.action;

import cn.xaut.shop.pojo.FavouriteShop;
import cn.xaut.shop.pojo.UserInfo;

public class FavouriteShopAction extends BaseAction<FavouriteShop> {

	private static final long serialVersionUID = 706887258652404829L;

	public String addFavourite(){

		UserInfo user = (UserInfo) session.get("userinfo");
		
		// 先查询是否已经收藏了
		if (favouriteShopService.isExits(user, model.getShop())) {
			// 已收藏
			System.out.println("已经收藏过了");
			jsonMap.put("data", "exits");
		} else {
			model.setUser(user);
			favouriteShopService.save(model);
			jsonMap.put("data", "save");
		}
		return "json";
	}


	/**
	 * 查询我的全部收藏
	 * 
	 * @return
	 */
	public String list() {
		// 查询的数据，如果能存到request中就不要存储在session中
		UserInfo user = (UserInfo) session.get("userinfo");
		page = favouriteShopService.queryByUserId(page, user);
		request.put("page", page);
		return "list";
	}

	/**
	 * 删除收藏记录
	 * 
	 * @return
	 */
	public String delete() {

		UserInfo user = (UserInfo) session.get("userinfo");
		// 删除指定数据
		favouriteShopService.delete(model);
		
		// 删除完毕，查询剩余
		favouriteShopService.queryByUserId(page, user);
		
		request.put("page", page);
		
		return "list";
	}

}
