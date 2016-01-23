package cn.xaut.shop.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xaut.shop.dao.CartDao;
import cn.xaut.shop.dao.CartItemDao;
import cn.xaut.shop.dao.GoodsDao;
import cn.xaut.shop.dao.GoodsStockDao;
import cn.xaut.shop.exception.CartException;
import cn.xaut.shop.pojo.Cart;
import cn.xaut.shop.pojo.CartItem;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.GoodsStock;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.OrderSon;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.service.CartItemService;
import cn.xaut.shop.util.NumberFormat;

@Service
@Transactional
public class CartItemServiceImpl extends BaseServiceRImpl<CartItem, Integer>
		implements CartItemService {

	private CartItemDao cartItemDao = null;

	public void setCartItemDao(CartItemDao cartItemDao) {
		this.cartItemDao = cartItemDao;
	}

	@Autowired
	private CartDao cartDao = null;

	@Autowired
	private GoodsDao goodsDao = null;

	@Autowired
	private GoodsStockDao goodsStockDao = null;

	/**
	 * 先从list中取出购物车， 遍历购物车中的cartitem集合， 找到要删除的product
	 */
	public Cart updateRemoveCartItem(List<Cart> cartlist, CartItem ci) {

		Cart targetCart = null;
		Set<CartItem> items = null;
		boolean isFind = false;

		for (Cart tempCart : cartlist) {
			if (isFind) {
				break;
			}
			items = tempCart.getCartitems();
			for (CartItem item : items) {
				if (item.getItemId().equals(ci.getItemId())) {
					isFind = true;
					items.remove(item); // 删除购物项
					targetCart = tempCart;// 标记这个购物车
					break;
				}
			}
		}

		this.saveOrupdateCart(cartlist, targetCart);

		return targetCart;
	}

	/**
	 * 从购物车列表中移除已经空了的购物车，并在数据库中删除
	 * 
	 * @param cartlist
	 *            购物车list
	 * @param targetCart
	 *            发生改变的购物车
	 */
	public void saveOrupdateCart(List<Cart> cartlist, Cart targetCart) {
		// 购物车空了-删除购物车，没有空则更新购物车
		if (targetCart.getCartitems().size() == 0) {
			cartlist.remove(targetCart);// 移除list
			cartDao.delete(targetCart);// 删除
		} else {
			double total = 0.0f;
			Set<CartItem> tempItems = targetCart.getCartitems();
			for (CartItem item : tempItems) {
				total += item.getPrice() * item.getAmount();
			}
			targetCart.setTotal(NumberFormat.Fix2(total));
			cartDao.saveOrupdate(targetCart); // 保存更新
		}
	}

	public List<CartItem> findCartItemByCartId(int cartId) {
		return cartItemDao.findCartItemByCartId(cartId);
	}

	public Cart addCartItem(List<Cart> cartlist, CartItem ci,Shop shop, UserInfo user) {

		Goods g = goodsDao.findById(ci.getGoodsId());
		GoodsStock stock = null;

		ci.setItemname(g.getGoodsname());
		ci.setGoodsPicUrl(g.getGoodsPicture() == null ? "" : g.getGoodsPicture().getUrl());
		ci.setPrice(g.getCurrentPrice());// 当前价格 - 最新价
		
		if(ci.isPropertyValid()){
			// 带有属性子项的商品
			stock = goodsStockDao.findById(Integer.parseInt(ci.getProperty()));
			ci.setProperty(stock.getGoodstype());
		}

		// 循环判断是否有重复的购物项 :
		// 1.判断是否有重复的店铺购物车
		// 2.判断是否含有相同商品
		// 3.判断重复商品是否商品类别也相同
		boolean isHaveGoods = false;

		// 要加入的购物车--目标购物车
		Cart targetCart = null;

		// 遍历购物车list，比对是否有该店铺的购物车
		for (Cart oldcart : cartlist) {
			if (oldcart.getShop().getShopId().equals(shop.getShopId())) {
				// 包含该店铺的购物车
				targetCart = oldcart;
				break;
			}
		}

		if (targetCart != null) {
			// 含有该店铺的购物车
			// 判断该购物车中的购物项是否包含该商品
			Set<CartItem> cartitems = targetCart.getCartitems();
			for (CartItem olditem : cartitems) {

				// 商品ID相同 && 商品类别属性相同，才认为是同一个商品
				if (olditem.getGoodsId().equals(ci.getGoodsId())) {
					/** 已经找到ID相同的商品了，继续判断有没有商品类别 **/

					// 商品ID相同 就先更新一下价格、商品名称
					olditem.setPrice(ci.getPrice());
					olditem.setItemname(ci.getItemname());

					int kc_amount = 0;// 库存数量
					int buyAmount = olditem.getAmount()+ ci.getAmount();// 够买的数量

					if (stock != null) {
						// 有类别的商品，判断商品类别相同不？
						if (ci.getProperty().equals(olditem.getProperty())) {
							// 商品类别也相同，那么才是同一个购物项
							kc_amount = stock.getAmount();
							olditem.setAmount(buyAmount > kc_amount ? kc_amount: buyAmount);
							isHaveGoods = true;
							break;
						}
					} else {
						// 没有类别的商品，现在已经可以判断是相同购物项了
						kc_amount = g.getAmount();
						// 最大只能设置为 库存数量
						olditem.setAmount(buyAmount > kc_amount ? kc_amount: buyAmount);
						isHaveGoods = true;
						break;
					}
				}
			}
			if (!isHaveGoods) {
				// 该店内的购物车不含这个商品（购物项）,那么直接添加到这个购物车里面
				// 设置购物车的引用-为了外键
				ci.setCart(targetCart);
				// 没有重复项目，新增到购物车集合中
				cartitems.add(ci);
			}
		} else {
			// 不包含该店铺的购物车，那么就创建一个购物车
			// 这个购物车属于该店铺 和 该用户;这里的用户可能是null
			targetCart = new Cart();
			targetCart.setUserInfo(user);
			targetCart.setShop(shop);

			// 添加新的购物项
			targetCart.getCartitems().add(ci);
			ci.setCart(targetCart);//外键

			// 新购物车添加到购物车list中
			cartlist.add(targetCart);
		}

		this.updateCartTotal(targetCart);
		// 返回修改后的购物车
		return targetCart;
	}

	@Override
	public Cart updateMinusAmount(List<Cart> cartlist, CartItem item)throws CartException {
			
		// 判断是否找到了要修改的购物项
		boolean isFind = false;
		Cart targetCart = null;

		// 遍历购物车list，比对是否有该店铺的购物车
		for (Cart oldcart : cartlist) {
			if (isFind) {
				break;// 避免多余循环
			}
			
			Set<CartItem> items = oldcart.getCartitems();
			for (CartItem i : items) {
				if (i.getItemId().equals(item.getItemId())) {

					this.updateItemAmount(i, -1);
					
					targetCart = oldcart;
					isFind = true;
					break;
				}
			}
		}
		//更新购物车
		updateCartTotal(targetCart);
		return targetCart;
	}
	
	/**
	 * 更新购物车总价并保存
	 * @param cart 发生变化的购物车
	 */
	private void updateCartTotal(Cart cart){
		
		double total = 0.0f;
		Set<CartItem> set = cart.getCartitems();
		for(CartItem item : set){
			total += item.getPrice() * item.getAmount();
		}
		cart.setTotal(NumberFormat.Fix2(total));
		cartDao.saveOrupdate(cart);
	}
	
	/**
	 * 更新购物项数量.(只做数量变，没有更新数据库)
	 * @param i 要更新的购物项
	 * @param offset 改变的数量，正数进行加，负数进行减
	 * @throws CartException 
	 */
	private void updateItemAmount(CartItem ci,int offset) throws CartException{
		
		// 判断商品
		Goods g = goodsDao.findById(ci.getGoodsId());
		if (g == null || !g.isValid()) {
			throw new CartException("该商品已失效",CartException.INVALID);
		}

		// 判断商品属性
		GoodsStock stock = goodsStockDao.findbyGoodstype(ci.getGoodsId(),ci.getProperty());
		if (ci.isPropertyValid() && stock == null) {
			throw new CartException("该商品已失效",CartException.INVALID);
		}
		
		ci.setItemname(g.getGoodsname());
		ci.setPrice(g.getCurrentPrice());
		
		int after = ci.getAmount() + offset;//改变数量
		if (stock != null) {
			// 有商品属性的
			if (after > stock.getAmount()) {
				ci.setAmount(stock.getAmount());
				CartException ex = new CartException("库存紧缺",CartException.GREATER);
				ex.setObject(ci);
				throw ex;
			} else {
				ci.setAmount(after);
			}
		} else {
			// 没有商品属性的
			if (after > g.getAmount()) {
				ci.setAmount(g.getAmount());
				CartException ex = new CartException("库存紧缺",CartException.GREATER);
				ex.setObject(ci);
				throw ex;
			} else {
				ci.setAmount(after);
			}
		}
		
	}

	@Override
	public Cart updatePlusAmount(List<Cart> cartlist, CartItem item) throws CartException {
		// 要修改的购物车--目标购物车
		Cart targetCart = null;
		// 遍历购物车list，比对是否有该店铺的购物车
		for (Cart oldcart : cartlist) {
			if (targetCart != null) {
				break;// 避免多余循环
			}
			Set<CartItem> items = oldcart.getCartitems();
			for (CartItem i : items) {
				if (i.getItemId().equals(item.getItemId())) {
					targetCart = oldcart;
					this.updateItemAmount(i, 1);
				}
			}
		}
		
		cartDao.saveOrupdate(targetCart);
		
		return targetCart;
	}

	@Override
	public List<Cart> removeItemCosByOrder(List<Cart> cartlist,
			List<Order> orderlist) {
		// 注释：Order 与 Cart 通过店铺(ID)1:1对应

		// int _shopCount = 0;//店铺数量 和 订单数量是相等的
		for (Cart cart : cartlist) {
			int shopid = cart.getShop().getShopId();

			for (Order order : orderlist) {
				if (order.getShop().getShopId().equals(shopid)) {
					// 找到了这个购物车
					// 订单子项,与购物车子项对比
					Set<OrderSon> sons = order.getSons();
					for (OrderSon son : sons) {
						// tempSet用来暂存，最后一次性全部删掉
						Set<CartItem> tempSet = new HashSet<CartItem>();
						Set<CartItem> items = cart.getCartitems();
						boolean flag = false;

						for (CartItem item : items) {
							if (item.getGoodsId().equals(
									son.getGoods().getGoodsid())) {
								// gid相同已经基本确定找到了，再根据property对比一下
								if (item.isPropertyValid()) {
									// 如果购物项有是有属性的
									if (son.isPropertyValid()
											&& item.getProperty().equals(
													son.getProperty())) {
										// 并且购物项属性与订单子项属性相同,那么找到了要删除的项目
										tempSet.add(item);
										flag = true;
									}
								} else {
									// 没有商品属性的,那基本上就确认是这个购物项了
									tempSet.add(item);
									flag = true;
									// break;//退出内层循环
								}
							}
						}// for items

						if (flag) {
							if (items.removeAll(tempSet)) {
								System.out.println("remove -> "
										+ tempSet.size());
							}
						}
					}// for sons
				}
			}// for order
		}// for cart
			// PS:空购物车没有在这里删除，在CartServiceImpl.saveOrUpdatebyList(List<Cart>)删除了

		return cartlist;
	}

	public List<Cart> removeItemCosByOrder(List<Cart> cartlist, Order order) {
		List<Order> list = new ArrayList<Order>();
		list.add(order);
		return removeItemCosByOrder(cartlist, list);
	}
}
