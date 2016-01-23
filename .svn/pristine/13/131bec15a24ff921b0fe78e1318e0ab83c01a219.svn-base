package cn.xaut.shop.dao.impl;
import java.util.ArrayList;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.PointsItemDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.PointsItem;

public class PointsItemDaoImpl extends HibernateRepository<PointsItem,Integer> implements
PointsItemDao{
	public PointsItemDaoImpl() {
		super();
	}

	@Override
	public Page<PointsItem> findByName(Page<PointsItem> page,String name) {
		StringBuffer hqlBuff = new StringBuffer("FROM PointsItem a WHERE a.itemname=?");
		List<Object> values = new ArrayList<Object>();
		values.add(name);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<PointsItem> findByKey(Page<PointsItem> page, String key) {
		StringBuffer hqlBuff = new StringBuffer("FROM PointsItem a WHERE a.itemname like ?");
		List<Object> values = new ArrayList<Object>();
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<PointsItem> find(Page<PointsItem> page) {
		StringBuffer hqlBuff = new StringBuffer("FROM PointsItem");
		List<Object> values = new ArrayList<Object>();
		return findPage(page,hqlBuff.toString(),values.toArray());
	}
}
