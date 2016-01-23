package cn.xaut.shop.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import cn.xaut.shop.exception.CartException;
import cn.xaut.shop.pojo.Cart;
import cn.xaut.shop.pojo.CartItem;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;

@SuppressWarnings("unchecked")
public class CartItemAction extends BaseAction<CartItem> {

	private static final long serialVersionUID = 4857933931024989745L;

	private String gid;

	public String getGid() {
		return gid;
	}

	/**
	 * 把购物项添加到购物车中
	 */
	public String addItemJson() {

		UserInfo user = (UserInfo) session.get("userinfo");
		List<Cart> cartlist = cartService.loadCartsByUserId(user.getUserinfoId());

		HttpServletRequest req = ServletActionContext.getRequest();
		int shopid = Integer.parseInt(req.getParameter("shopid"));
		Shop shop = shopService.get(shopid);

		gid = req.getParameter("goodsId");
		// 商铺主不能添加自己出售的商品到购物车中
		if (user.getUserinfoId().equals(shop.getUserinfo().getUserinfoId())) {
			gid = req.getParameter("goodsId");
			//return "goodPage";
			jsonMap.put("data", "shopowner");
			jsonMap.put("goodsId", gid);
		} else {
			cartItemService.addCartItem(cartlist, model, shop, user);
			session.put("cartlist", cartlist);
			jsonMap.put("data", "ok");
		}
		return "json";
	}

	public String removeCartItem() {

		List<Cart> cartlist = (List<Cart>) session.get("cartlist");
		if (cartlist == null) {
			UserInfo user = (UserInfo) session.get("userinfo");
			cartlist = cartService.loadCartsByUserId(user.getUserinfoId());
		}

		// 删除指定的购物项
		Cart cart = cartItemService.updateRemoveCartItem(cartlist, model);
		if (cart.getCartitems().size() == 0) {
			// 页面上要删除的购物车
			jsonMap.put("shopid", cart.getShop().getShopId());
		}

		// 新的购物车存入session
		session.put("cartlist", cartlist);
		jsonMap.put("data", "remove");
		return "json";
	}

	public String minusAmount() {

		List<Cart> cartlist = (List<Cart>) session.get("cartlist");
		if (cartlist == null) {
			UserInfo user = (UserInfo) session.get("userinfo");
			cartlist = cartService.loadCartsByUserId(user.getUserinfoId());
		}
		try {
			// 已经设置ajax同步请求了，应该不会用到这段代码了
			// if(0 == model.getAmount() - 1){
			// jsonMap.put("data", "fail");
			// jsonMap.put("dataMsg", "数量不能为0");
			// return "json";
			// }

			cartItemService.updateMinusAmount(cartlist, model);
			session.put("cartlist", cartlist);// 新的购物车存入session
			jsonMap.put("data", "ok");

		} catch (CartException e) {
			// 自定义异常
			jsonMap.put("data", "fail");
			jsonMap.put("dataMsg", e.getMessage());
			switch (e.getErrFlag()) {
			case CartException.GREATER:
				jsonMap.put("dataFlag", "greater");
				session.put("cartlist", cartlist);// 新的购物车存入session
				CartItem errItem = (CartItem) e.getObject();
				jsonMap.put("dataAmount", errItem.getAmount());// 目前的数量是
				break;
			case CartException.INVALID:
				jsonMap.put("dataFlag", "invalid");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonMap.put("data", "err");
			jsonMap.put("dataMsg", "系统出现错误");
		}

		return "json";
	}

	public String plusAmount() {
		try {
			List<Cart> cartlist = (List<Cart>) session.get("cartlist");
			if (cartlist == null) {
				UserInfo user = (UserInfo) session.get("userinfo");
				cartlist = cartService.loadCartsByUserId(user.getUserinfoId());
			}
			
			// 增加指定的购物项数量
			cartItemService.updatePlusAmount(cartlist, model);
			session.put("cartlist", cartlist);
			jsonMap.put("data", "ok");

		} catch (CartException e) {
			jsonMap.put("data", "fail");
			jsonMap.put("dataMsg", e.getMessage());
			if (e.getErrFlag() == CartException.GREATER) {
				jsonMap.put("dataFlag", "greater"); // 库存不足
			} else if (e.getErrFlag() == CartException.INVALID) {
				jsonMap.put("dataFlag", "invalid");// 商品失效
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonMap.put("dataFlag", "商品出现异常");
		}
		return "json";
	}

}
