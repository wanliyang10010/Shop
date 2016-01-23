package cn.xaut.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.FavouriteDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.Favourite;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.UserInfo;

public class FavouriteDaoImpl extends HibernateRepository<Favourite,Integer> implements
		FavouriteDao {

	public Page<Favourite> queryByUserId(Page<Favourite> page, UserInfo user) {

		StringBuffer hqlBuff = new StringBuffer("select f from Favourite as f where f.user = ?");

		List<Object> values = new ArrayList<Object>();
		values.add(user);


		return findPage(page, hqlBuff.toString(), values.toArray());
	}

	@Override
	public boolean isExits(UserInfo user ,Goods good) {
		
		StringBuffer hqlBuff = new StringBuffer("SELECT f FROM Favourite as f WHERE f.user = ? AND f.good = ?");
		List<Object> values = new ArrayList<Object>();
		
		values.add(user);
		values.add(good);
		
		List<Favourite> list = find(hqlBuff.toString(), values.toArray());
		
		return list.size() > 0 ? true:false;
	}

}
