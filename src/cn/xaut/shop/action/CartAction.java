package cn.xaut.shop.action;

import java.util.List;

import cn.xaut.shop.pojo.Cart;
import cn.xaut.shop.pojo.UserInfo;

public class CartAction extends BaseAction<Cart> {
	
	private static final long serialVersionUID = 1L;
	
	public String queryCarts()
	{
		  UserInfo user =  (UserInfo)session.get("userinfo");
		  if(user != null)
		  {
			  //根据用户ID查询购物车
			  List<Cart> cartlist = cartService.loadCartsByUserId(user.getUserinfoId());
			  
			  //存入session
			  request.put("cartlist", cartlist);
			  return "loginshowCart";
		  }
		  return "unloginshowCart";
	}
	
	public String getItemCount(){
		UserInfo user = (UserInfo) session.get("userinfo");
		int count = cartService.getItemCount(user);
		session.put("cartItemCount", "("+ count +")");
		jsonMap.put("count", count);
		return "json";
	}

}
