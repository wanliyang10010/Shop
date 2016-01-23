package cn.xaut.shop.phoneAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.exception.CartException;
import cn.xaut.shop.exception.MsgException;
import cn.xaut.shop.pojo.Cart;
import cn.xaut.shop.pojo.CartItem;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;

/**
 * 购物项目action
 * 
 * 由于我们的设计：所有业务逻辑类都放到了baseAction 中
 * 
 * 我们可以在购物项Action中完成添加购物项的操作 和 计算总价格的操作
 * 
 * 也可以在CartAction完成添加购物项的操作，和 计算 总价格的操作
 * 
 * 按照严格的做法，不同的实体请求，要交给不同的action来做
 * 
 * 则，先跳转到cartItemAction完成添加购物项的功能，
 * 
 * 再跳转到CartAction完成计算总价的功能，
 * 
 * 最后到shopCar.jsp显示结果
 */

@SuppressWarnings("unchecked")
public class CartItemActionPhone extends BaseAction<CartItem> {

	private static final long serialVersionUID = 4857933931024989745L;
	HttpServletRequest req = (HttpServletRequest) request;
	/**/
	private Map<String,Object> responseJson = new HashMap<String,Object>();
	public Map<String, Object> getResponseJson() {
		return responseJson;
	}
	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}	
	
	
	////把购物项添加到购物车中
	public String addItemJson() {

		// 获得用户信息、
		String userinfoId =ServletActionContext.getRequest().getParameter("userinfoId");  
		UserInfo user=userInfoService.getAdmin(Integer.parseInt(userinfoId));		
		if (user == null) {
			System.out.println("Not Login --->  CartItemAdd -->  Login");			
			// 用户没登录 -- 那就退回登录页面
			String msglogin="请先登录再进行操作";
			responseJson.put("msglogin", msglogin);
			return "goLogin";
		}

		// 拿到session中的cartlist购物车list
		List<Cart> cartlist = (List<Cart>) session.get("cartlist");
		if (cartlist == null) {
			// 从数据库中加载以前的购物车
			cartlist = cartService.loadCartsByUserId(Integer.parseInt(userinfoId));
		}
		String g_id =ServletActionContext.getRequest().getParameter("g_id"); 
		// 获取request参数
		HttpServletRequest req = ServletActionContext.getRequest();
		String shop_id = req.getParameter("shop_id");

		// Goods good = goodsService.get(Integer.parseInt(g_id));
		Shop shop = shopService.get(Integer.parseInt(shop_id));
		// 购物项存入商品的引用
		//model.setGood(good);
		model.setGoodsId(Integer.parseInt(g_id));
		
		// 下面调用service实现业务逻辑，完成添加购物项目
		Cart cart = cartItemService.addCartItem(cartlist, model, shop, user);
		// 计算单车的总价
		// double totalAll = cartService.calcTotalAll(cartlist);
		// String str_Total = new java.text.DecimalFormat("#.00").format(totalAll);// 四舍五入
		cartService.saveOrUpdate(cart);
		// 把购物车重新返回到session中
		responseJson.put("data", "save");
		return "cartjson";
	}

	public String removeCartItem() {

		String userid = ServletActionContext.getRequest().getParameter("userid");
	     UserInfo userinfo=userInfoService.findById(Integer.parseInt(userid));   
		//List<Cart> cartlist = (List<Cart>) session.get("cartlist");
		List<Cart> cartlist = cartService.loadCartsByUserId(userinfo.getUserinfoId());
		// 删除指定的购物项
		Cart cart = cartItemService.updateRemoveCartItem(cartlist, model);

		// 更新list,更新数据库
		if (cart.getCartitems().size() == 0) {
			// 移除并删除购物车实体
			cartlist.remove(cart);
			jsonMap.put("shopid", cart.getShop().getShopId());
			cartService.delete(cart.getCartId());
		} else {
			// 删除这个购物项 --->下面这句不用了，在配置文件中使用了级联，update主表就删除了移除的子项
			//cartItemService.delete(cartitem.getItemId());
			// 更新购物车
			cartService.saveOrUpdate(cart);
		}
		
//		// 计算新总价格
//		double totalAll = cartService.calcTotalAll(cartlist);
//		String str_Total = new java.text.DecimalFormat("#.00").format(totalAll);// 四舍五入
//		session.put("totalMoney", str_Total);
//
//		// 新的购物车存入session
//		session.put("cartlist", cartlist);
//		jsonMap.put("data", "remove");
		jsonMap.put("delete", "true");
		return "json";
	}

	public String minusAmount() {
		
		List<Cart> cartlist = (List<Cart>) session.get("cartlist");

		// 减少指定的购物项数量
		Cart cart;
		try {
			cart = cartItemService.updateMinusAmount(cartlist, model);
			
			
			// 计算新总价格
			cartService.calcTotalAll(cartlist);

			// 更新list,更新数据库,更新购物车
			cartService.saveOrUpdate(cart);

			// 新的购物车存入session
			session.put("cartlist", cartlist);
			jsonMap.put("data", "change");
			
			
		} catch (CartException e) {
			e.printStackTrace();
		}

		return "json";
	}

	public String plusAmount() {
		
		List<Cart> cartlist = (List<Cart>) session.get("cartlist");
		
		try{
		// 增加指定的购物项数量
		Cart cart = cartItemService.updatePlusAmount(cartlist, model);

		// 计算新总价格
		cartService.calcTotalAll(cartlist);
		
		cartService.saveOrUpdate(cart);
		session.put("cartlist", cartlist);
		// 放入json
		jsonMap.put("data", "change");
		jsonMap.put("msg","SUCCESS");

		} catch(CartException e){
			jsonMap.put("data", "fail");
			jsonMap.put("dataMsg",e.getMessage());
		}
		
		return "json";
	}
	
}
