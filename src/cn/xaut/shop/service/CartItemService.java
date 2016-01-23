package cn.xaut.shop.service;

import java.util.List;

import cn.xaut.shop.exception.CartException;
import cn.xaut.shop.pojo.Cart;
import cn.xaut.shop.pojo.CartItem;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;

public interface CartItemService extends BaseServiceR<CartItem,Integer> {

	/**
	 * 向购物车中添加购物项，判断重复店铺，判断重复项目
	 * 
	 * @param cartlist
	 *            购物车list
	 * @param cartitem
	 *            购物项
	 * @return 新添加的购物车
	 */
	public Cart addCartItem(List<Cart> cartlist, CartItem newcartitem,
			Shop shop, UserInfo user);

	/**
	 * 删除指定购物项
	 * 
	 * @return 返回操作的购物项
	 */
	public Cart updateRemoveCartItem(List<Cart> cartlist, CartItem ci);

	/**
	 * 根据购物车Id查询出购物项目
	 */
	public List<CartItem> findCartItemByCartId(int cart_id);

	
	/**
	 * 减少购物车中的选购数量,并更新购物车总价
	 * @param cartlist 购物车集合
	 * @param item 要修改的购物项
	 * @return
	 * @throws CartException
	 */
	public Cart updateMinusAmount(List<Cart> cartlist, CartItem item) throws CartException ;
	
	/**
	 * 增加购物车中的选购数量,并更新购物车总价
	 * @param cartlist 购物车集合
	 * @param item 要修改的购物项
	 * @return
	 * @throws CartException
	 */
	public Cart updatePlusAmount(List<Cart> cartlist, CartItem item) throws CartException ;
	

	/**
	 * 因提交订单，而删除购物项目
	 * @param cartlist
	 * @param orderlist
	 * @return 返回购物车list,这些cart中可能已经没有购物项了需要删除
	 */
	public List<Cart> removeItemCosByOrder(List<Cart> cartlist,List<Order> orderlist);
	
	/**
	 * 提交了一个订单,清除购物车
	 * @param cartlist
	 * @param order
	 * @return  返回的CartList在从新计算总价后，需要执行一次UpdateOrSave方法;
	 */
	public List<Cart> removeItemCosByOrder(List<Cart> cartlist,Order order);
	
}
