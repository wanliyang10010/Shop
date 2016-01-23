package cn.xaut.shop.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.exception.CartException;
import cn.xaut.shop.exception.OrderException;
import cn.xaut.shop.pojo.DeliverAddr;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.OrderSon;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;

public interface OrderService extends BaseServiceR<Order,Integer>{

	
	/**
	 * 按用户查询Order
	 * @param fromdate
	 * @param todate
	 * @return 分页结果
	 */
	public Page<Order>  getOrderListbyUser(Page<Order> page, String fromdate,String todate,UserInfo user);
	
	/**
	 * 按店铺查询Order
	 * @param fromdate
	 * @param todate
	 * @param shop
	 * @return 分页结果
	 */
	public Page<Order>  getOrderListbyShop(Page<Order> page,String fromdate,String todate,Shop shop);

	/**
	 * 保存订单列表
	 * @param orderlist
	 * @param user
	 * @return 返回的是没有提交成功的订单
	 * @throws CartException 
	 */
	public OrderSon saveOrderList(HttpServletRequest req, List<Order> orderlist,UserInfo user,DeliverAddr addr) throws OrderException;
	
	/**
	 * 保存订单list
	 * 验证商品是否有效，验证库存是否足够，清除购物车购物项
	 * @param request 请求参数
	 * @param user 用户
	 * @throws OrderException 
	 */
	public void saveOrderbylist(Map<String,String[]> requestMap, UserInfo user) throws OrderException;
	
	/**
	 * 保存单个订单
	 * @param req
	 * @param user
	 * @return true 下单成功 false 下单失败
	 */
	public boolean saveSingleOrder(HttpServletRequest  req,UserInfo user,DeliverAddr addr);
	
	/**
	 * 保存单独一个订单
	 * @param property 商品类别的属性值(如果有)
	 * @param addrid 收货地址的Id
	 * @return true 下单成功 false 库存不足下单失败
	 */
	public Integer saveOneOrder(UserInfo user,int shopid, int goodsid, int amount,String property,String remark,int addrid);

	public double getTotalMoeny(Integer shopid, String fromdate, String todate);

	public Page<Order> getSaleOrder(Page<Order> page, Integer shopid,
			String fromdate, String todate);

	/**
	 * 根据订单表id查询订单实体
	 * @param id
	 * @return
	 */
	public  Order getOrder(int id);

	public boolean saveSingleOrderPhone(Order order, String goodsid, int amount);

	
	/**
	 * 给订单付款 [更新订单State=2，然后更新销量]
	 * @param order 要付款的订单
	 * @return
	 */
	public void updatePayOrder(Order order);


	public List<Order> findByUserId(String userinfoId);
	
	/**
	 * 形成预订单，没有存入数据库.
     * 用在“立即购买”情况下.
     * @param user 下单用户
	 * @param sid 店铺id
	 * @param gid 商品id
	 * @param amount 选购数量
	 * @param property 商品类别（如果存在的话）
	 */
	public Order preOrder(UserInfo user,int sid, int gid,int amount,String property);
	
	//取消订单 ywl
	public void updateCancelOrder(Order order);
	
	//退货 ywl
	public void returnGoods(Order order);
	
	//确认收货 ywl
	public void updateConfirmGoods(Order order);
} 

