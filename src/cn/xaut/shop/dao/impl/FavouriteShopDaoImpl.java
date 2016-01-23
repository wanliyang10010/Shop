package cn.xaut.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.FavouriteShopDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.FavouriteShop;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;

public class FavouriteShopDaoImpl extends HibernateRepository<FavouriteShop,Integer> implements
		FavouriteShopDao {

	public FavouriteShopDaoImpl() {
		super();
	}

	public Page<FavouriteShop> queryByUserId(Page<FavouriteShop> page, UserInfo user) {

		StringBuffer hqlBuff = new StringBuffer("select f from FavouriteShop as f where f.user = ?");

		List<Object> values = new ArrayList<Object>();
		values.add(user);

		return findPage(page, hqlBuff.toString(), values.toArray());
	}

	@Override
	public boolean isExits(UserInfo user ,Shop shop) {
		
		StringBuffer hqlBuff = new StringBuffer("SELECT f FROM FavouriteShop as f WHERE f.user = ? AND f.shop = ?");
		List<Object> values = new ArrayList<Object>();
		
		values.add(user);
		values.add(shop);
		
		List<FavouriteShop> list = find(hqlBuff.toString(), values.toArray());
		
		return list.size() > 0 ? true:false;
	}

}
