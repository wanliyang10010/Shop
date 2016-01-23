package cn.xaut.shop.dao;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;

public interface OrderDao extends BaseDao<Order, Integer> {

	/**
	 * 用户查询历史订单
	 * @param user
	 * @return
	 */
	public Page<Order> queryHistoryOrderByUser(Page<Order> page, UserInfo user);


	/**
	 * 用户查询订单
	 */
	public Page<Order> getOrderList(Page<Order> page,String fromdate, String todate,UserInfo user);

	/**
	 * 店铺查询订单
	 * @param fromdate
	 * @param todate
	 * @param shop
	 * @return
	 */
	public Page<Order> getOrderList(Page<Order> page,String fromdate, String todate,Shop shop);
			
	/**
	 * 保存订单
	 * @param orderlist
	 * @param user
	 */
	public void saveOrderList(List<Order> orderlist);
	
	public List<Order> getSaleList(Integer shopid, String fromdate, String todate);
	
	public Page<Order> getSalePage(Page<Order> page, Integer shopid, String fromdate,
			String todate);
	
	/**
	 * 根据订单表id查找订单实体
	 * @param id
	 * @return
	 */
	public Order getOrder(int id);

	public List<Order> getSaleList(String userinfoId);
	
}
