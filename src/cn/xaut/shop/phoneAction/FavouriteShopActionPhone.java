package cn.xaut.shop.phoneAction;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.FavouriteShop;
import cn.xaut.shop.pojo.UserInfo;

public class FavouriteShopActionPhone extends BaseAction<FavouriteShop> {

	private static final long serialVersionUID = 706887258652404829L;

	public String add(){

		//UserInfo user = (UserInfo) session.get("userinfo");
		String userid=ServletActionContext.getRequest().getParameter("userid");
	     UserInfo userinfo=userInfoService.findById(Integer.parseInt(userid));   
		// 先查询是否已经收藏了
		if (favouriteShopService.isExits(userinfo, model.getShop())) {
			// 已收藏
			System.out.println("已经收藏过了");
			jsonMap.put("data", "exits");
		} else {
			model.setUser(userinfo);
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
		String userid=ServletActionContext.getRequest().getParameter("userid");
	     UserInfo userinfo=userInfoService.findById(Integer.parseInt(userid));   
		// 查询的数据，如果能存到request中就不要存储在session中
		//UserInfo user = (UserInfo) session.get("userinfo");
		page = favouriteShopService.queryByUserId(page, userinfo);
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
		favouriteShopService.delete(model);
		
		// 删除完毕，查询剩余
		//favouriteShopService.queryByUserId(page, user);
		
		//request.put("page", page);
		
		return "json";
	}

}
