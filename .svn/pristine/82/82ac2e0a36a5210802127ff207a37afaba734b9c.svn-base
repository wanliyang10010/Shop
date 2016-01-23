package cn.xaut.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.DateItemDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.DateItem;

public class DateItemDaoImpl extends  HibernateRepository<DateItem,Integer> implements
DateItemDao{
	public DateItemDaoImpl() {
		super();
	}

	@Override
	public Page<DateItem> findItemByName(Page<DateItem> page,String name) {
		StringBuffer hqlBuff = new StringBuffer("FROM DateItem a WHERE a.itemname =?");
		List<Object> values = new ArrayList<Object>();
		values.add(name);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<DateItem> findItemByKey(Page<DateItem> page, String key) {
		StringBuffer hqlBuff = new StringBuffer("FROM DateItem a WHERE a.itemname like ?");
		List<Object> values = new ArrayList<Object>();
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<DateItem> find(Page<DateItem> page) {
		StringBuffer hqlBuff = new StringBuffer("FROM DateItem");
		List<Object> values = new ArrayList<Object>();
		return findPage(page,hqlBuff.toString(),values.toArray());
	}
}
