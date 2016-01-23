package cn.xaut.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.ShopEvaluationDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.ShopEvaluation;
import cn.xaut.shop.pojo.UserPoint;

public class ShopEvaluationDaoImpl extends HibernateRepository<ShopEvaluation, Integer>
		implements ShopEvaluationDao {

	public ShopEvaluationDaoImpl() {
		super();
	}

	public List<ShopEvaluation> getListByShopId(int shopid) {
		String sql = "";
		sql = "FROM ShopEvaluation a WHERE a.shop = '"+shopid+"' order by a.evaluationTime desc";
		return find(sql);	
	}

	public Page<ShopEvaluation> getListByShopId(Page<ShopEvaluation> page,int shopid) {
		StringBuffer hqlBuff = new StringBuffer(
				"select a from ShopEvaluation as a where a.shop.shopId= ? order by a.evaluationTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(shopid);		
        Page<ShopEvaluation> p=findPage(page,hqlBuff.toString(), values.toArray());
		return p;
	}
}
