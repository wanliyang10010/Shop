package cn.xaut.shop.phoneAction;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.Favourite;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.util.Struts2Utils;

public class FavouriteActionPhone extends BaseAction<Favourite> {

	private static final long serialVersionUID = -826504123905902772L;

	// private Page<Favourite> page = new Page<Favourite>();
    //收藏商品
	public String add() {
		//UserInfo user = (UserInfo) session.get("userinfo");
		String userinfoId =ServletActionContext.getRequest().getParameter("userinfoId"); 
		UserInfo user=userInfoService.getAdmin(Integer.parseInt(userinfoId));		
		// 先查询是否已经收藏了
		/*
		if (favouriteService.isExits(user, model.getGood())) {
			// 已收藏
			jsonMap.put("data", "exits");
		} else {
			model.setUser(user);
			favouriteService.save(model);
			jsonMap.put("data", "save");
		}
		*/
		return "collectjson";
	}


	/**
	 * 查询我的全部收藏
	 * 
	 * @return
	 */
	public String list() {
		// 查询的数据，如果能存到request中就不要存储在session中
		//UserInfo user = (UserInfo) session.get("userinfo");
		String userid=ServletActionContext.getRequest().getParameter("userid");
	     UserInfo userinfo=userInfoService.findById(Integer.parseInt(userid));   
		page = favouriteService.queryByUserId(page, userinfo);
		if(page!=null&&page.getTotalItems()!=0)
		{
			jsonMap.put("LIST", page.getResult());
			boolean isFristPage = page.isFirstPage();
			boolean isLastPage = page.isLastPage();
			
			jsonMap.put("first", isFristPage);
			jsonMap.put("next", isLastPage);
		}else
		{		
			jsonMap.put("isResult", "false");
		}	
		return "json";
	}

	/**
	 * 删除收藏记录
	 * 
	 * @return
	 */
	public String delete() {

		//UserInfo user = (UserInfo) session.get("userinfo");
		String userid=ServletActionContext.getRequest().getParameter("userid");
	     UserInfo userinfo=userInfoService.findById(Integer.parseInt(userid));   
		// 删除指定数据
		favouriteService.delete(model);
		jsonMap.put("isResult", "false");
		// 删除完毕，查询剩余
//		page =favouriteService.queryByUserId(page, userinfo);
//
//		request.put("page", page);

		return "json";
	}

}
