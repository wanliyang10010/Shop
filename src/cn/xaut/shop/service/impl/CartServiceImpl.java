package cn.xaut.shop.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.xaut.shop.dao.CartDao;
import cn.xaut.shop.dao.CartItemDao;
import cn.xaut.shop.dao.GoodsDao;
import cn.xaut.shop.exception.CartException;
import cn.xaut.shop.pojo.Cart;
import cn.xaut.shop.pojo.CartItem;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.OrderSon;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.service.CartService;
import cn.xaut.shop.util.NumberFormat;

@Service
@Transactional
public class CartServiceImpl extends BaseServiceRImpl<Cart,Integer> implements
		CartService {

	@Autowired
	private CartDao cartDao = null;
	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	
	@Autowired
	private GoodsDao goodsDao = null;
	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}
	
	@Autowired
	private CartItemDao cartItemDao = null;

	/**
	 * 根据每一个购物项，计算购物总价格
	 */
	public double calcTotal(Cart cart) {
		double total = 0.0;

		for (CartItem item : cart.getCartitems()) {
			total += item.getAmount() * item.getPrice();
		}
		cart.setTotal(total);
		return total;
	}

	/**
	 * 遍历购物车list中的每一个购物车，根据购物车中每一个购物项，计算购物总价格
	 * 
	 * 最终累计出所有购物车的总价格,保留两位小数fix2
	 */
	public double calcTotalAll(List<Cart> cartlist) {
		double allTotal = 0.0;
		double total = 0.0;

		for (Cart cart : cartlist) {
			for (CartItem item : cart.getCartitems()) {
				total += item.getAmount() * item.getPrice();
			}
			cart.setTotal(total);
			allTotal += total;
			total = 0;
		}

		return NumberFormat.Fix2(allTotal);
	}

	/*
	 * { List<Account> accounts = hibernateTemplate.findByNamedParam(
	 * "FROM Account a WHERE a.alogin =: alogin AND a.apass=:apass", new
	 * String[] { "alogin", "apass" }, new Object[] { account.getAlogin(),
	 * account.getApass() }); }
	 */

	public List<Cart> loadCartsByUserId(int userId) {
		// 根据用户Id查询用户所有的购物车信息
		return cartDao.loadCartsByUserId(userId);
	}
	
	public List<Cart> loadCartsByUserInfo(UserInfo user) {
		return cartDao.loadCartsByUserInfo(user);
	}

	@Override
	public List<Cart> clearCart(List<Cart> cartlist) {
		
		for(Cart cart :cartlist)
		{
			 cartDao.delete(cart);
		}
		return cartlist;
	}

	@Override
	public List<Order> getOrderList(List<Cart> cartlist, String[] itemIdArray) throws CartException {
		Assert.notNull(itemIdArray, "购物项ID数组不能为空");
		Assert.notNull(cartlist, "购物车列表不能为空");
		
		if(itemIdArray == null || cartlist == null){
			//return null;
			CartException ex = new CartException("没有选中要结算的商品");
			//没有选中项目
			ex.setErrFlag(CartException.EMPTYITEM);
			throw ex;
		}
		
		int count = 0;//共计多少个goood被选中
		List<Order> orderlist = new ArrayList<Order>();
		for(Cart cart : cartlist)
		{
			if(itemIdArray.length == count){
				break;//避免多余循环
			}
			
			Order order = new Order();
			//最高的运费
			double HighestFreight = 0.0f;
			//总价
			double ftotal = 0.0;
			//购物车中的购物项
			Set<CartItem> items = cart.getCartitems();
			for(String str_ItemId : itemIdArray)
			{
				int itemId = Integer.parseInt(str_ItemId);
				Iterator<CartItem> it = items.iterator();
				while(it.hasNext())
				{
					CartItem i = it.next();
					if(i.getItemId().equals(itemId))//找到该购物项
					{
						//找到了这个商品
						count++;//计数加一
						Goods good = goodsDao.findById(i.getGoodsId());
						
						if(good == null || !good.isValid()){
							CartException ex = new CartException("商品[" + i.getFullName() + "]已失效");
							ex.setErrFlag(CartException.INVALID);
							throw ex;
						}
						
						if(good.getFreight() > HighestFreight){
							//记录最高的运费
							HighestFreight = (float) good.getFreight();
						}
						
						OrderSon son = new OrderSon();
						son.setAmount(i.getAmount());
						son.setPrice(i.getPrice());
						son.setProperty(i.getProperty() != null ? i.getProperty() : "");
						son.setGoodsName(i.getItemname());
						
						son.setGoods(good);
						ftotal += son.getAmount() * son.getPrice();
						
						//设置order的shop信息
						order.setShopname(cart.getShop().getShopname());
						order.setShop(cart.getShop());
						//外键
						son.setOrder(order);
						son.setTempIndex(order.getSons().size() + 1);//设置一个临时的顺序，用于排序
						order.getSons().add(son);
					}
				}

				order.setFreight(HighestFreight);//运费
				//总价 = 商品单价*数量 + 最高运费
				double total = NumberFormat.Fix2(ftotal + HighestFreight);
				order.setFtotal(total);
			}
				
			if(order.getSons().size() > 0)
			{
				orderlist.add(order);
			}
		}
		return orderlist;
	}
	
	
	/**
	 * 生成预备订单
	 * @param cartlist 购物车列表
	 * @param itemIdArray 选中的购物项
	 * @return 返回预订单列表
	 * @throws CartException
	 */
	public List<Order> createPreOrderList(String[] cartIdArray, String[] itemIdArray) throws CartException {
		Assert.notNull(cartIdArray, "购物车ID数组不能为空");
		Assert.notNull(itemIdArray, "购物项ID数组不能为空");
		
		if(itemIdArray == null || cartIdArray == null){
			throw new CartException("没有选中要结算的商品",CartException.EMPTYITEM);
		}
		
		List<Integer> cartId_list = new ArrayList<Integer>();
		for(String c_id : cartIdArray){
			cartId_list.add(Integer.parseInt(c_id));
		}
		List<Integer> itemId_list = new ArrayList<Integer>();
		for(String ci_id : itemIdArray){
			itemId_list.add(Integer.parseInt(ci_id));
		}
		
		// 查出所有被勾选的购物车集合
		List<Cart> cartlist = cartDao.findByIds(cartId_list);
		// 查询所有的被勾选的购物项集合
		List<CartItem> itemlist = cartItemDao.findByIds(itemId_list);
		// 订单列表
		List<Order> orderlist = new ArrayList<Order>();
		
		for(Cart cart : cartlist){
			cart.getCartitems().retainAll(itemlist);
			orderlist.add(this.convert2Order(cart));
		}
		return orderlist;
	}
	
	
	/**
	 * 把购物车转换成订单
	 * 从购物车中对比出勾选的购物项
	 * @param cart
	 * @return
	 * @throws CartException
	 */
//	private Order convert2Order(Cart cart,List<CartItem> ci_list) throws CartException
//	{
//		double HighestFreight = 0.0f;//最高的运费
//		double total = 0.0f;//总价格
//		Goods good = null;
//		Order order = new Order();
//		
//		Iterator<CartItem> it = cart.getCartitems().iterator();
//		while(it.hasNext()){
//			CartItem item = it.next();
//			
//			// 如果要形成订单的item在这个ci_list集合中
//			if(ci_list.contains(item)){
//				good = goodsDao.findById(item.getGoodsId());
//				if(good == null || !good.isValid()){
//						throw new CartException("商品[" + item.getFullName() + "]已失效"
//								,CartException.INVALID);
//				}
//				
//				if(good.getFreight() > HighestFreight){
//					HighestFreight = good.getFreight();
//				}
//				OrderSon son = new OrderSon();
//				son.setAmount(item.getAmount());
//				son.setPrice(item.getPrice());
//				son.setProperty(item.getProperty() != null ? item.getProperty() : "");
//				son.setGoodsName(item.getItemname());
//				son.setGoods(good);
//				total += son.getAmount() * good.getCurrentPrice();//累加总价
//				son.setOrder(order);
//				son.setTempIndex(order.getSons().size() + 1);
//				order.getSons().add(son);
//			}
//		}
//		
//		order.setFreight(HighestFreight);
//		double ftotal  = NumberFormat.Fix2(total + HighestFreight);
//		order.setShop(cart.getShop());
//		order.setShopname(cart.getShop().getShopname());
//		// 订单总价 = 商品单价 * 数量 + 最高运费
//		order.setFtotal(ftotal);
//		return order;
//	}
	
	
	/**
	 * 把购物车转换成订单
	 * 从购物车中对比出勾选的购物项
	 * @param cart
	 * @return
	 * @throws CartException
	 */
	private Order convert2Order(Cart cart) throws CartException
	{
		double HighestFreight = 0.0f;//最高的运费
		double total = 0.0f;//总价格
		Goods good = null;
		Order order = new Order();
		
		Iterator<CartItem> it = cart.getCartitems().iterator();
		while(it.hasNext()){
			CartItem item = it.next();
			good = goodsDao.findById(item.getGoodsId());
			if(good == null || !good.isValid()){
					throw new CartException("商品[" + item.getFullName() + "]已失效"
							,CartException.INVALID);
			}
			if(good.getFreight() > HighestFreight){
				HighestFreight = good.getFreight();
			}
			OrderSon son = new OrderSon();
			son.setAmount(item.getAmount());
			son.setPrice(item.getPrice());
			son.setProperty(item.getProperty() != null ? item.getProperty() : "");
			son.setGoodsName(item.getItemname());
			son.setGoods(good);
			total += son.getAmount() * good.getCurrentPrice();//累加总价
			son.setOrder(order);
			son.setTempIndex(order.getSons().size() + 1);
			son.setSonstate(item.getItemId() + "");//先把itemId存在state中
			order.getSons().add(son);
		}
		
		order.setFreight(HighestFreight);
		double ftotal  = NumberFormat.Fix2(total + HighestFreight);
		order.setShop(cart.getShop());
		order.setShopname(cart.getShop().getShopname());
		// 订单总价 = 商品单价 * 数量 + 最高运费
		order.setFtotal(ftotal);
		order.setRemark(cart.getCartId() + "");//先把cartId存在state中 
		return order;
	}
	

	@Override
	public void saveOrUpdatebyList(List<Cart> list) {
		if(list != null)
		{
			List<Cart> temp = new ArrayList<Cart>();
			for(Cart c : list){
				if(c.getCartitems().size() == 0){
					
					//在这里删除了购物车
					temp.add(c);
					cartDao.delete(c);
				}
				else{
					 cartDao.update(c);
				}
			}
			list.removeAll(temp);//统一删除
		}
	}

	@Override
	public void saveOrUpdate(Cart cart) {
		cartDao.saveOrupdate(cart);
	}

	@Override
	public int getItemCount(UserInfo user) {
		return cartDao.getItemCount(user);
	}

}
