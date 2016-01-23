package cn.xaut.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.CartDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.Cart;
import cn.xaut.shop.pojo.CartItem;
import cn.xaut.shop.pojo.UserInfo;

public class CartDaoImpl extends HibernateRepository<Cart, Integer> implements
		CartDao {

	@Override
	public Page<Cart> findAllByPage(Page<Cart> page) {
		StringBuffer hqlBuff = new StringBuffer("FROM Cart");
		List<Object> values = new ArrayList<Object>();
		return findPage(page, hqlBuff.toString(), values.toArray());
	}

	@Override
	public List<Cart> loadCartsByUserId(int userId) {

		// "FROM Cart c WHERE c.userInfo.userinfoId =:userId","userId", userId);
		StringBuffer hqlBuff = new StringBuffer("FROM Cart c WHERE c.userInfo.userinfoId = ? ");
		List<Object> values = new ArrayList<Object>();
		values.add(userId);

		return find(hqlBuff.toString(), values.toArray());
	}

	@Override
	public List<Cart> loadCartsByUserInfo(UserInfo user) {
		// "FROM Cart c WHERE c.userInfo =:user","user", user
		StringBuffer hqlBuff = new StringBuffer("FROM Cart c WHERE c.userInfo = ? ");
		List<Object> values = new ArrayList<Object>();
		values.add(user);
		return find(hqlBuff.toString(), values.toArray());
	}

	@Override
	public Page<Cart> findPageByUser(Page<Cart> page, UserInfo user) {

		StringBuffer hqlBuff = new StringBuffer("FROM Cart c WHERE c.userInfo = ? ");
		List<Object> values = new ArrayList<Object>();
		values.add(user);
		return findPage(page, hqlBuff.toString(), values.toArray());
	}

	@Override
	public int getItemCount(UserInfo user) {
		StringBuffer hqlBuff = new StringBuffer("FROM Cart c WHERE c.userInfo = ? ");
		List<Object> values = new ArrayList<Object>();
		values.add(user);
		
		List<Cart> list = find(hqlBuff.toString(), values.toArray());
		if(list != null){
			int count = 0;
			for(Cart cart : list){
				if(cart.getCartitems() != null){
					Set<CartItem> items = cart.getCartitems();
					if(items.size() > 0){
						for(CartItem item : items){
							count += item.getAmount();
						}
					}
				}
			}
			return count;
		}
		return 0;
	}

}
