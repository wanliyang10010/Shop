package cn.xaut.shop.service;
import java.util.List;

import cn.xaut.shop.exception.CartException;
import cn.xaut.shop.pojo.Cart;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.UserInfo;

public interface CartService extends BaseServiceR<Cart,Integer>{

	/**
	 * 计算购物车总价格
	 * @return
	 */
	public double calcTotal(Cart cart);
	
	
	/**
	 * 
	 * 遍历购物车list中的每一个购物车，根据购物车中每一个购物项，计算购物总价格
	 * 
	 * 最终累计出所有购物车的总价格
	 *
	 * @param cartlist 购物车list
	 * @return 所有购物车合计总价
	 */
	public double calcTotalAll(List<Cart> cartlist);
	
	/**
	 * 按照用户名查询购物车，返回结果为按店铺Id分组的购车list
	 * @param userId
	 * @return
	 */
	public List<Cart> loadCartsByUserId(int userId);
	
	/**
	 * 根据用户查询购物车
	 * @param user
	 * @return 购物车list
	 */
	public List<Cart> loadCartsByUserInfo(UserInfo user);
	
	/**
	 * 保存或更新购物车 
	 */
	public void saveOrUpdate(Cart cart);
	
	
	public void saveOrUpdatebyList(List<Cart> list);
	
	/**
	 * 清空购物车
	 * @param cartlist
	 * @return
	 */
	public List<Cart> clearCart(List<Cart> cartlist);
	
	
	/**
	 * 通过商品id从购物车list中转换出List<Order>
	 * @param cartlist 购物车list
	 * @param itemIdArray 购物项ID的数组
	 * @return 
	 */
	public List<Order>  getOrderList(List<Cart> cartlist,String[] itemIdArray) throws CartException;
	
	/**
	 * 通过勾选的购物车ID，勾选的商品ID生成预订单
	 * @param cartlist 购物车列表
	 * @param cartIdArray 选中的购物车ID数组
	 * @param itemIdArray 选中的购物项ID数组
	 * @return
	 * @throws CartException
	 */
	public List<Order> createPreOrderList(String[] cartIdArray, String[] itemIdArray) throws CartException;

	public int getItemCount(UserInfo user);
	
}
