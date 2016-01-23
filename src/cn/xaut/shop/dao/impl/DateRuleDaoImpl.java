package cn.xaut.shop.dao.impl;
import java.util.ArrayList;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.DateRuleDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.DateRule;

public class DateRuleDaoImpl extends  HibernateRepository<DateRule,Integer>  implements
DateRuleDao{
	public DateRuleDaoImpl() {
		super();
	}

	@Override
	public Page<DateRule> findByName(Page<DateRule> page,String name) {
		StringBuffer hqlBuff = new StringBuffer("FROM DateRule a where a.rule=?");
		List<Object> values = new ArrayList<Object>();
		values.add(name);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}



	@Override
	public Page<DateRule> findByKey(Page<DateRule> page, String key) {
		StringBuffer hqlBuff = new StringBuffer("FROM DateRule a where a.rule like ?");
		List<Object> values = new ArrayList<Object>();
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}



	@Override
	public Page<DateRule> find(Page<DateRule> page) {
		StringBuffer hqlBuff = new StringBuffer("FROM DateRule");
		List<Object> values = new ArrayList<Object>();
		return findPage(page,hqlBuff.toString(),values.toArray());
	}
}
