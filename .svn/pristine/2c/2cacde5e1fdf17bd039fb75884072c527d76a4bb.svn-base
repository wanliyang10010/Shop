package cn.xaut.shop.dao.impl;
import java.util.ArrayList;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.PointsRuleDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.PointsRule;

public class PointsRuleDaoImpl extends HibernateRepository<PointsRule,Integer> implements
PointsRuleDao{
	public PointsRuleDaoImpl() {
		super();
	}

	@Override
	public Page<PointsRule> findByName(Page<PointsRule> page,String type, String rule) {
		StringBuffer hqlBuff = new StringBuffer("FROM PointsRule a WHERE a.type=? and a.rule= ?");
		List<Object> values = new ArrayList<Object>();
		values.add(type);
		values.add(rule);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<PointsRule> findByKey(Page<PointsRule> page, String str, String key) {
		String sql="";
		key="%"+key+"%";
		System.out.println(str);
		if(str.equals("用户类型"))
		{
			sql="FROM PointsRule a WHERE a.type like ?";
		}
		else
		{
			sql="FROM PointsRule a WHERE a.rule like ?";
		}
		StringBuffer hqlBuff = new StringBuffer(sql);
		List<Object> values = new ArrayList<Object>();
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<PointsRule> find(Page<PointsRule> page) {
		StringBuffer hqlBuff = new StringBuffer("FROM PointsRule");
		List<Object> values = new ArrayList<Object>();
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public List<PointsRule> queryByType(String type, String item) {
		StringBuffer hqlBuff = new StringBuffer("FROM PointsRule a WHERE a.type=? and a.rule= ?");
		List<Object> values = new ArrayList<Object>();
		values.add(type);
		values.add(item);
		return find(hqlBuff.toString(),values.toArray());
	}
}
