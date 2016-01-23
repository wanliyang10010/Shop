package cn.xaut.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.CartItemDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.CartItem;
import cn.xaut.shop.pojo.UserInfo;

public class CartItemDaoImpl extends HibernateRepository<CartItem,Integer> implements
		CartItemDao {

	public CartItemDaoImpl() {
		super();
	}

	@Override
	public Page<CartItem> findAllByPage(Page<CartItem> page) {

		// pageRequest.setCountTotal(false);
		StringBuffer hqlBuff = new StringBuffer("FROM CartItem");
		List<Object> values = new ArrayList<Object>();

		return findPage(page, hqlBuff.toString(), values.toArray());
	}

	@Override
	public List<CartItem> findCartItemByCartId(int cartId) {

		// "FROM Cart_item ci WHERE ci.cart_id =:cid", "cid", cartId
		StringBuffer hqlBuff = new StringBuffer("FROM CartItem c WHERE c.cart_id = ?");
		List<Object> values = new ArrayList<Object>();
		values.add(cartId);

		return find(hqlBuff.toString(),values.toArray());
	}

//	@Override
//	public void clearCartItem(Set<CartItem> items) {
//		
//		if(items != null && items.size() > 0)
//		{
//			for(CartItem item : items)
//			{
//				delete(item);
//			}
//		}
//	}
	
	

}
