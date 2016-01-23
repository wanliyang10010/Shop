package cn.xaut.shop.action;

import cn.xaut.shop.pojo.Favourite;
import cn.xaut.shop.pojo.UserInfo;

public class FavouriteAction extends BaseAction<Favourite> {

	private static final long serialVersionUID = -826504123905902772L;
//	private String sessionKey;
//	
//	public String getSessionKey() {
//		return sessionKey;
//	}
//
//	public void setSessionKey(String sessionKey) {
//		this.sessionKey = sessionKey;
//	}


	public String addFavourite() {

		UserInfo user = (UserInfo) session.get("userinfo");
		
		// 先查询是否已经收藏了
		if (favouriteService.isExits(user, model.getGood())) {
			// 已收藏
			jsonMap.put("data", "exits");
		} else {
			model.setUser(user);
			favouriteService.save(model);
			jsonMap.put("data", "save");
		}
		
		return "json";
	}


	/**
	 * 查询我的全部收藏
	 * 
	 * @returnx
	 */
	public String list() {
		// 查询的数据，如果能存到request中就不要存储在session中
		UserInfo user = (UserInfo) session.get("userinfo");
		page = favouriteService.queryByUserId(page, user);
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
		favouriteService.delete(model);

		// 删除完毕，查询剩余
		favouriteService.queryByUserId(page, user);

		request.put("page", page);

		return "list";
	}
	
	
	
//	public String getSession(){
//		
//		String str = "";
//		if(session.get("sessionKey") != null)
//			str= session.get("sessionKey").toString();
//		
//		jsonMap.put("data",str);
//		
//		return "json";
//	}
//	
//	public String writeSession(){
//		
//		session.put("sessionKey", sessionKey);
//		
//		jsonMap.put("data","1");
//		
//		return "json";
//	}

}
