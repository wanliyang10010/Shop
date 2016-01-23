package cn.xaut.shop.dao.impl;
import java.util.ArrayList;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.MarginRuleDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.MarginRule;
import cn.xaut.shop.pojo.ShopApply;

public class MarginRuleDaoImpl extends HibernateRepository<MarginRule,Integer> implements
MarginRuleDao{
	public MarginRuleDaoImpl() {
		super();
	}
	
	@Override
	public Page<MarginRule> findByName(Page<MarginRule> page,String type,String name) {
		StringBuffer hqlBuff = new StringBuffer("FROM MarginRule a WHERE a.type=? and a.product=?");
		List<Object> values = new ArrayList<Object>();
		values.add(type);
		values.add(name);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<MarginRule> findByKey(Page<MarginRule> page,String str, String key) {
		String sql="";
		key="%"+key+"%";
		if(str.equals("商铺类别"))
		{
			sql="FROM MarginRule a WHERE a.type like ?";
		}
		else
		{
			sql="FROM MarginRule a WHERE a.product like ?";
		}
		StringBuffer hqlBuff = new StringBuffer(sql);
		List<Object> values = new ArrayList<Object>();
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<MarginRule> find(Page<MarginRule> page) {
		StringBuffer hqlBuff = new StringBuffer("FROM MarginRule");
		List<Object> values = new ArrayList<Object>();
		return findPage(page,hqlBuff.toString(),values.toArray());
	}
	//ywl
	public  String getShopMargin(String shopcategory,String productcategory) {

		StringBuffer hqlBuff = new StringBuffer(
				"select a from MarginRule as a where a.type =? and a.product=?");
		List<Object> values = new ArrayList<Object>();
		values.add(shopcategory);
		values.add(productcategory);

		List<MarginRule> list = find(hqlBuff.toString(), values.toArray());
		if (list != null && list.size() > 0) {
			return list.get(0).getMoney();
		} else {
			return "";
		}
	}
}
