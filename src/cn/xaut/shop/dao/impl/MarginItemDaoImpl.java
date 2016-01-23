package cn.xaut.shop.dao.impl;
import java.util.ArrayList;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.MarginItemDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.MarginItem;

public class MarginItemDaoImpl extends HibernateRepository<MarginItem,Integer>  implements
MarginItemDao{
	public MarginItemDaoImpl() {
		super();
	}

	@Override
	public Page<MarginItem> findName(Page<MarginItem> page,String itemname) {
		StringBuffer hqlBuff = new StringBuffer("FROM MarginItem a WHERE a.itemname=? order by a.mitemid desc");
		List<Object> values = new ArrayList<Object>();
		values.add(itemname);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<MarginItem> findByKey(Page<MarginItem> page, String key) {
		StringBuffer hqlBuff = new StringBuffer("FROM MarginItem a WHERE a.itemname like ? order by a.mitemid desc");
		List<Object> values = new ArrayList<Object>();
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<MarginItem> find(Page<MarginItem> page) {
		StringBuffer hqlBuff = new StringBuffer("FROM MarginItem a order by a.mitemid desc");
		List<Object> values = new ArrayList<Object>();
		return findPage(page,hqlBuff.toString(),values.toArray());
	}
}
