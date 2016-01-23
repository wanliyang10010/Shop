package cn.xaut.shop.phoneAction;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.Cart;
import cn.xaut.shop.pojo.UserInfo;

public class CartActionPhone extends BaseAction<Cart> {
	
	private static final long serialVersionUID = 1L;

	public void logout()
	{
		System.out.println("logout");
		if(session.get("userinfo")!= null)
		{
			session.remove(session.get("userinfo"));
			System.out.println("logout sucessfully");
		}
	}
	
	
	public String calcTotal()
	{
		System.out.println("--------CartAction - Total -----------");
		//从session中拿到购物车
		Cart cart = (Cart) session.get("cart");
		cart.setTotal(cartService.calcTotal(cart));
		session.put("cart",cart);
		return "showCart";
	}
	
	/**
	 * 提交订单
	 * @return
	 */
	public String save()
	{
		//购物车的信息和订单配送信息合并
		Cart cart = (Cart)session.get("cart");
		cart.setRemark(model.getRemark());
		
		// 用户是外键
		cart.setUserInfo((UserInfo)session.get("users"));
		
		//购物车和购物项级联入库  --> 在hibernate.文件cart.hbm.xml中进行配置
		cartService.save(cart);
		
		return "bank";
	}
	
	
	public String queryCarts()
	{
		  //UserInfo user =  (UserInfo)session.get("userinfo");
		String userid=ServletActionContext.getRequest().getParameter("userid");
	    if(userid==null){
	    	jsonMap.put("isResult", "false");
	    	 return "json";
	    }
		
		UserInfo userinfo=userInfoService.findById(Integer.parseInt(userid));   
		  if(userinfo != null)
		  {
			  //用户已经登录，那么按用户Id查询
			  List<Cart> cartlist = cartService.loadCartsByUserId(userinfo.getUserinfoId());
			  
			  //存入session			 
			 
			  if(cartlist.size()!=0)
				{
					jsonMap.put("LIST", cartlist);				
									
				}else
				{		
					jsonMap.put("isResult", "false");
				}
			  
			  return "json";
		  }
		  return "json";
	}

}
