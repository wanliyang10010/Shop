package cn.xaut.shop.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.CartDao;
import cn.xaut.shop.dao.CartItemDao;
import cn.xaut.shop.dao.DeliverAddrDao;
import cn.xaut.shop.dao.GoodsDao;
import cn.xaut.shop.dao.GoodsStockDao;
import cn.xaut.shop.dao.OrderDao;
import cn.xaut.shop.dao.ShopDao;
import cn.xaut.shop.exception.CartException;
import cn.xaut.shop.exception.OrderException;
import cn.xaut.shop.pojo.Cart;
import cn.xaut.shop.pojo.CartItem;
import cn.xaut.shop.pojo.DeliverAddr;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.GoodsStock;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.OrderSon;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.service.OrderService;
import cn.xaut.shop.service.OrderSonService;
import cn.xaut.shop.util.NumberFormat;

@Service
@Transactional
public class OrderServiceImpl extends BaseServiceRImpl<Order, Integer>
		implements OrderService {

	/*
	 * Date now = new Date(); SimpleDateFormat dateFormat = new
	 * SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 */

	private OrderDao orderDao = null;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Autowired
	private GoodsDao goodsDao = null;
	@Autowired
	private ShopDao shopDao = null;
	@Autowired
	private GoodsStockDao goodsStockDao = null;
	@Autowired
	private DeliverAddrDao addrDao = null;
	@Autowired
	private CartDao cartDao = null;
	@Autowired
	private CartItemDao cartItemDao = null;

	@Autowired
	private OrderSonService orderSonService = null;
	
	@Override
	public Page<Order> getOrderListbyUser(Page<Order> page, String fromdate,
			String todate, UserInfo user) {
		return orderDao.getOrderList(page, fromdate, todate, user);
	}

	@Override
	public Page<Order> getOrderListbyShop(Page<Order> page, String fromdate,
			String todate, Shop shop) {
		return orderDao.getOrderList(page, fromdate, todate, shop);
	}

	@Override
	public OrderSon saveOrderList(HttpServletRequest req,
			List<Order> orderlist, UserInfo user, DeliverAddr addr)
			throws OrderException {
		Assert.notNull(orderlist, "订单列表不能为空");

		OrderSon failedSon = null;// 提交失败的商品子项

		if (orderlist != null) {
			// 判断定单总金额
			Order failOrder = null;
			if ((failOrder = this.checkOrderTotalMoney(orderlist)) != null) {
				OrderException ex = new OrderException("店铺["
						+ failOrder.getShopname() + "]单笔订单超过系统最大订单金额，不能提交订单.");
				ex.setErrFlag(OrderException.MAXMONEY);
				throw ex;
			}

			// 判断库存
			failedSon = checkStockbyList(orderlist);
			if (failedSon == null) {
				// 不存在数量不足的情况,那么进行订单提交操作
				for (Order order : orderlist) {
					String remark = req.getParameter(
							"remark_" + order.getShop().getShopId()).toString();
					order.setRemark(remark);

					Set<OrderSon> sons = order.getSons();

					// 仅仅减库存,不加销量
					for (OrderSon son : sons) {
						if (son.isPropertyValid())
							goodsDao.minGoodAmountProperty(son.getGoods()
									.getGoodsid(), son.getAmount(), son
									.getProperty());
						else
							goodsDao.minGoodAmount(son.getGoods().getGoodsid(),
									son.getAmount());
					}

					// 保存订单
					order.setUser(user);
					order.setState("0");
					order.setStatemark("已提交");
					order.setBuytime(new Timestamp(System.currentTimeMillis()));
					order.setAddr(addr.getFinalAddr());// 收货地址

					orderDao.save(order);
				}
			}
		}
		// 返回保存失败的orderSon
		return failedSon;
	}

	@Override
	public void saveOrderbylist(Map<String, String[]> request, UserInfo user)
			throws OrderException {

		String[] cartIdArray = request.get("cartIds");
		String[] cartItemIdArray = request.get("itemIds");

		List<Integer> itemId_list = new ArrayList<Integer>();
		for (String itId : cartItemIdArray) {
			itemId_list.add(Integer.parseInt(itId));
		}

		String str_addrid = request.get("addrid")[0];
		DeliverAddr addr = addrDao.findById(Integer.parseInt(str_addrid));

		List<Order> orderlist = new ArrayList<Order>();
		for (String cartId : cartIdArray) {
			Order order = this.makeOneOrder(request, cartId, user);
			order.setAddr(addr.getFinalAddr());
			orderlist.add(order);
		}
		saveOrderAndClearCartItems(orderlist, itemId_list);
	}

	/**
	 * 保存订单，并且清除购物项
	 * 
	 * @param orderlist
	 *            订单list
	 * @param itemId_list
	 *            购物项Id的list
	 */
	private void saveOrderAndClearCartItems(List<Order> orderlist,
			List<Integer> itemId_list) {

		// 加载要清除的购物项list
		List<CartItem> item_delete_list = cartItemDao.findByIds(itemId_list);
		Iterator<Order> it = orderlist.iterator();

		while (it.hasNext()) {
			Order order = it.next();

			Set<OrderSon> sons = order.getSons();
			Iterator<OrderSon> itson = sons.iterator();
			while (itson.hasNext()) {
				// 减少库存
				OrderSon son = itson.next();
				if (son.isPropertyValid()) {
					goodsDao.minGoodAmountProperty(son.getGoods().getGoodsid(),
							son.getAmount(), son.getProperty());
				} else {
					goodsDao.minGoodAmount(son.getGoods().getGoodsid(),
							son.getAmount());
				}
			}

			cleanCart(Integer.parseInt(order.getStatemark()), item_delete_list);
			order.setStatemark("已提交");// 再把这个标致清空
			orderDao.save(order);
		}
	}

	/**
	 * 清除购物车中已结算的项目
	 * 
	 * @param cartId
	 *            购物车Id
	 * @param itemIds
	 *            被结算的购物项的Id
	 */
	private void cleanCart(Integer cartId, List<CartItem> deleteItems) {

		Cart cart = cartDao.findById(cartId);
		try {
			if (cart != null) {
				if (deleteItems != null && deleteItems.size() > 0) {
					cart.getCartitems().removeAll(deleteItems);
					if (cart.getCartitems().size() > 0) {
						// 重新计算剩余下来的总价
						double total = 0.0f;
						for (CartItem item : cart.getCartitems()) {
							total += item.getAmount() * item.getPrice();
						}
						cart.setTotal(total);
						cartDao.saveOrupdate(cart);
					} else {
						cartDao.delete(cart);
					}
				}
			}
		} catch (Exception ex) {
			// 表示购物车已经清理过了...
			// 先这样处理吧
		}
	}

	private Order makeOneOrder(Map<String, String[]> request, String cartId,
			UserInfo user) throws OrderException {

		Order order = new Order();

		String str_shopid = request.get("shopid_" + cartId)[0];
		String str_total = request.get("total_" + cartId)[0];
		String str_freight = request.get("freight_" + cartId)[0];
		String str_remark = request.get("remark_" + cartId)[0];
		Shop shop = shopDao.findById(Integer.parseInt(str_shopid));
		double ftotal = Double.parseDouble(str_total);
		if (ftotal > Order.MAXMONEY) {
			throw new OrderException("店铺[" + shop.getShopname()
					+ "]单笔订单超过系统最大订单金额，不能提交订单.", OrderException.MAXMONEY);
		}

		// 找到所有子项ID
		String[] itemIds = request.get("itemIds_" + cartId);
		for (String itId : itemIds) {

			String prefix = "item_" + cartId + "_" + itId + "_";

			String str_itemName = request.get(prefix + "itemName")[0];
			String str_gid = request.get(prefix + "gid")[0];
			String str_property = request.get(prefix + "property")[0];
			String str_price = request.get(prefix + "price")[0];
			String str_amount = request.get(prefix + "amount")[0];

			Goods g = goodsDao.findById(Integer.parseInt(str_gid));
			if (g == null || !g.isValid()) {
				throw new OrderException("商品[" + str_itemName + "]已失效",
						OrderException.INVALID);
			}

			if (isGoodsStockEnough(g, g.getGoodsname(), str_property,
					Integer.parseInt(str_amount))) {
				OrderSon son = new OrderSon();
				son.setAmount(Integer.parseInt(str_amount));
				son.setGoods(g);
				son.setGoodsName(g.getGoodsname());
				son.setOrder(order);
				son.setPrice(Double.parseDouble(str_price));
				son.setProperty(str_property);
				order.getSons().add(son);
			}
		}

		order.setBuytime(new Timestamp(System.currentTimeMillis()));
		order.setState(Order.SUBMIT);
		order.setUser(user);
		order.setShop(shop);
		order.setShopname(shop.getShopname());
		order.setStatemark(cartId);// 用这个mark先记录一下cartId吧
		order.setFtotal(ftotal);
		order.setFreight(Double.parseDouble(str_freight));
		order.setRemark(str_remark);

		return order;
	}

	/**
	 * 判断库存数量是否够
	 * 
	 * @param g
	 *            要买的商品
	 * @param _want2buy
	 *            要买的数量
	 * @return true 满足，false 不满足
	 * @throws CartException
	 * @throws OrderException
	 */
	private boolean isGoodsStockEnough(Goods good, String itemName,
			String itemProperty, int _want2buy) throws OrderException {

		// 商品有效的情况下
		if (StringUtils.isNotEmpty(itemProperty)) {
			// 有属性的商品
			GoodsStock stock = goodsStockDao.findbyGoodstype(good.getGoodsid(),
					itemProperty);
			if (stock == null) {
				throw new OrderException("商品[" + itemName + "-" + itemProperty
						+ "]已失效", OrderException.INVALID);
			}
			if (_want2buy > stock.getAmount()) {
				throw new OrderException("商品[" + itemName + "-" + itemProperty
						+ "]库存不足", OrderException.GREATER);
			}

		} else {
			// 普通商品
			if (_want2buy > good.getAmount()) {
				throw new OrderException("商品[" + itemName + "]库存不足",
						OrderException.GREATER);
			}
		}
		return true;
	}

	/**
	 * 判断库存
	 * 
	 * @throws CartException
	 */
	private OrderSon checkStockbyList(List<Order> orderlist)
			throws OrderException {
		OrderSon failson = null;
		boolean b_failed = false;
		// Goods good = null;
		// 判断库存
		for (Order o : orderlist) {

			Set<OrderSon> sons = o.getSons();
			for (OrderSon son : sons) {
				// 先判断本条订单中所有商品库存数量够不够，
				// 有一个商品数量不足，那么不进行本次订单提交的所有操作

				// 重新从数据库中查询,保证数据是最新的
				Goods g = goodsDao.findById(son.getGoods().getGoodsid());

				if (!g.isValid()) {
					// 商品下架
					OrderException ex = new OrderException(son.getGoodsName()
							+ "商品已失效");
					ex.setErrFlag(CartException.INVALID);
					throw ex;
				}

				int _want2buy = son.getAmount();
				int _kucun = 0;

				if (son.isPropertyValid()) {
					GoodsStock stock = goodsStockDao.findbyGoodstype(son
							.getGoods().getGoodsid(), son.getProperty());
					if (stock == null) {
						OrderException ex = new OrderException(
								son.getGoodsName() + "商品已失效");
						ex.setErrFlag(CartException.INVALID);
						throw ex;
					}
					_kucun = stock.getAmount();

				} else {
					_kucun = g.getAmount();
				}

				if (_want2buy > _kucun) {
					// 要买的大于库存
					failson = son;
					b_failed = true;
					break;
				}
			}
			if (b_failed) {
				// 如果失败了，就不继续判断了，直接退出
				break;
			}
		}
		return failson;
	}

	private Order checkOrderTotalMoney(Order order) {

		double total = 0.0f;
		Set<OrderSon> sons = order.getSons();
		for (OrderSon son : sons) {
			total += son.getPrice() * son.getAmount();
		}
		if (!(total < Order.MAXMONEY)) {
			return order;
		}
		return null;
	}

	private Order checkOrderTotalMoney(List<Order> orderlist) {

		for (Order order : orderlist) {
			if (this.checkOrderTotalMoney(order) != null) {
				return order;
			}
		}
		return null;
	}

	public Integer saveOneOrder(UserInfo user, int shopid, int goodsid,
			int amount, String property, String remark, int addrid) {
		Goods good = goodsDao.findById(goodsid);
		if (!good.isValid()) {
			return 0;
		}
		Shop shop = shopDao.findById(shopid);
		DeliverAddr addr = addrDao.findById(addrid);

		// 商品当前价格 X 数量 + 运费
		if ((good.getCurrentPrice() * amount + good.getFreight()) >= Order.MAXMONEY) {
			return -2;// 大于最大金额
		}

		Order order = new Order();
		OrderSon son = new OrderSon();

		son.setGoods(good);
		son.setAmount(amount);
		son.setPrice(good.getDiscount() != null ? good.getDiscount().getPrice()
				: good.getPrice());
		son.setGoodsName(good.getGoodsname());
		son.setProperty(property != null ? property : "");// 商品类别信息
		son.setOrder(order);

		order.getSons().add(son);// 订单子项项加入订单中
		order.setShop(shop);
		order.setShopname(shop.getShopname());
		order.setFreight(good.getFreight());// 运费
		// 总价格 = 商品总价 + 运费，保留2位小数
		order.setFtotal(NumberFormat.Fix2(son.getPrice() * amount
				+ good.getFreight()));
		;
		order.setAddr(addr.getFinalAddr());
		order.setRemark(remark != null ? remark : "");
		order.setBuytime(new Timestamp(System.currentTimeMillis()));
		order.setState("0");
		order.setStatemark("已提交");
		order.setUser(user);

		boolean b_Enough = true;// 默认库存充足
		// 减少库存
		if (property != null && property.length() > 0) {
			// 商品有类型属性的时候
			GoodsStock stock = goodsStockDao.findbyGoodstype(goodsid, property);
			if (stock.getAmount() >= amount) {
				goodsDao.minGoodAmountProperty(goodsid, amount, property);
			} else {
				b_Enough = false;// 库存不足
			}
		} else {
			// 普通商品没有类型属性信息
			if (good.getAmount() >= amount) {
				goodsDao.minGoodAmount(goodsid, amount);
			} else {
				b_Enough = false;// 库存不足
			}
		}

		if (b_Enough) {
			orderDao.save(order);// 保存订单
			return order.getOrderid();// 返回ORDER_ID
		}
		return -1;// 库存不足
	}

	@Override
	public boolean saveSingleOrder(HttpServletRequest req, UserInfo user,
			DeliverAddr addr) {

		String goodsid = req.getParameter("goodsid");
		String shopid = req.getParameter("shopid");
		String remark = req.getParameter("remark");// 订单备注
		String amount = req.getParameter("amount");// 选购数量
		double freight = 0.0f;// 运费
		double price = 0.0f;// 商品售价

		// 店铺
		Shop shop = shopDao.findById(Integer.parseInt(shopid));
		// 商品
		Goods good = goodsDao.findById(Integer.parseInt(goodsid));
		if (good.getDiscount() != null && good.getDiscount().getPrice() > 0) {
			price = good.getDiscount().getPrice();// 促销价
		} else {
			price = good.getPrice();// 原价
		}

		freight = good.getFreight();
		int Amount = Integer.parseInt(amount);
		// 总金额 = 单价*数量 + 运费
		double total = NumberFormat.Fix2(price * Amount + freight);

		OrderSon son = new OrderSon();
		son.setAmount(Amount);
		son.setPrice(price);
		son.setGoods(good);
		son.setGoodsName(good.getGoodsname());

		Order order = new Order();
		order.setUser(user);
		order.setBuytime(new Timestamp(System.currentTimeMillis()));
		order.setFreight(freight);// 不知道会不会转换不不准确
		order.setFtotal(total);
		order.setRemark(remark);
		order.setShop(shop);
		order.setShopname(shop.getShopname());
		order.setState("0");
		order.setStatemark("已提交");
		order.setAddr(addr.getFinalAddr());// 收货地址

		// 外键
		order.getSons().add(son);
		son.setOrder(order);

		if (Amount > good.getAmount()) {
			// 选购数量大于库存
			return false;
		} else {
			// 减少库存
			goodsDao.minGoodAmount(Integer.parseInt(goodsid), Amount);
			// 保存订单
			save(order);
		}
		return true;
	}

	@Override
	public boolean saveSingleOrderPhone(Order order, String goodsid, int Amount) {

		if (goodsDao.minGoodAmount(Integer.parseInt(goodsid), Amount) <= 0) {
			return false;
		}
		// 保存
		save(order);
		return true;
	}

	@Override
	public double getTotalMoeny(Integer shopid, String fromdate, String todate) {
		double totalmoney = 0;
		List<Order> list = orderDao.getSaleList(shopid, fromdate, todate);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Order order = list.get(i);
				totalmoney = totalmoney + order.getFtotal();
			}
		}
		return totalmoney;
	}

	@Override
	public Page<Order> getSaleOrder(Page<Order> page, Integer shopid,
			String fromdate, String todate) {
		return orderDao.getSalePage(page, shopid, fromdate, todate);
	}

	@Override
	public Order getOrder(int id) {
		// TODO Auto-generated method stub
		return orderDao.getOrder(id);
	}

	@Override
	public void updatePayOrder(Order order) {
		// 增加销量
		Set<OrderSon> sons = order.getSons();
		for (OrderSon s : sons) {
			goodsDao.increaseSellAmount(s.getGoods().getGoodsid(),
					s.getAmount());
		}
		order.setState(Order.PAY);
		orderDao.update(order);
	}

	@Override
	public List<Order> findByUserId(String userinfoId) {
		return orderDao.getSaleList(userinfoId);
	}

	@Override
	public Order preOrder(UserInfo user, int sid, int gid, int amount,
			String property) {

		Shop shop = shopDao.findById(sid);
		Goods good = goodsDao.findById(gid);
		GoodsStock stock = null;
		if (property != null && property.length() > 0)
			stock = goodsStockDao.findById(Integer.parseInt(property));

		Order order = new Order();

		OrderSon son = new OrderSon();
		son.setGoods(good);
		son.setAmount(amount);
		son.setPrice(good.getDiscount() != null ? good.getDiscount().getPrice()
				: good.getPrice());
		son.setGoodsName(good.getGoodsname());
		son.setProperty(stock != null ? stock.getGoodstype() : "");
		son.setOrder(order);

		order.setUser(user);
		order.getSons().add(son);// 订单子项项加入订单中
		order.setShop(shop);
		order.setShopname(shop.getShopname());
		order.setFreight(good.getFreight());// 运费
		// 总价格 = 商品总价 + 运费，保留2位小数
		order.setFtotal(NumberFormat.Fix2(son.getPrice() * amount
				+ good.getFreight()));

		return order;
	}

	@Override
	public void updateCancelOrder(Order order) {
		// 增加库存
		Set<OrderSon> sons = order.getSons();
		for (OrderSon s : sons) {
			if ((s.isPropertyValid())) {
				try {
					goodsDao.rollBackGoodAmountProperty(s.getGoods()
							.getGoodsid(), s.getAmount(), s.getProperty());
				} catch (Exception ex) {
					ex.printStackTrace();
					System.out.println("商品恢复库存失败 --> " + s.getGoodsName());
				}
			} else {
				goodsDao.rollBackGoodAmount(s.getGoods().getGoodsid(),
						s.getAmount());
			}
		}
		// state=1 已取消订单
		order.setState(Order.CANCEL);
		orderDao.update(order);
	}

	@Override
	public void returnGoods(Order order) {
		// 增加库存
		// 减少销量
		Set<OrderSon> sons = order.getSons();
		for (OrderSon s : sons) {
			if ((s.getProperty() != null) && (s.getProperty().length() > 0)) {
				goodsDao.rollBackGoodAmountProperty(s.getGoods().getGoodsid(),
						s.getAmount(), s.getProperty());
			} else {
				goodsDao.rollBackGoodAmount(s.getGoods().getGoodsid(),
						s.getAmount());
			}

			goodsDao.decreaseSellAmount(s.getGoods().getGoodsid(),
					s.getAmount());
			s.setSonstate("1");// 代表已经退货
		}

		// state=5已退货
		order.setState("5");
		orderDao.update(order);
	}
	
	public void updateConfirmGoods(Order order){
		orderDao.update(order);
		Iterator<OrderSon> it = order.getSons().iterator();
		while (it.hasNext()) {
			OrderSon orderSon = orderSonService.get(it.next().getOrdersonId());
			orderSon.setSonstate("40");// 代表已经收货，但是未评价
			orderSonService.update(orderSon);
		}
	}
}
