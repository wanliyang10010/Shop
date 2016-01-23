package cn.xaut.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.MarginDetailDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.MarginDetail;

public class MarginDetailDaoImpl extends HibernateRepository<MarginDetail, Integer>
		implements MarginDetailDao {

	public MarginDetailDaoImpl() {
		super();
	}

	public List<MarginDetail> getListByShopid(int shopid) {
		String sql = "";		
		sql = "FROM MarginDetail a WHERE a.shop =  '"+shopid+"' order by a.userTime desc";		
		return find(sql);
	}

	@Override
	public Page<MarginDetail> findByShopid(Page<MarginDetail> page, int shopid) {
		StringBuffer hqlBuff = new StringBuffer("FROM MarginDetail a WHERE a.shop.shopId =? order by a.userTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(shopid);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}
}
