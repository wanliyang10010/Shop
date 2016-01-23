package cn.xaut.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.ProductDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.Product;

public class ProductDaoImpl extends HibernateRepository<Product,Integer> implements
		ProductDao {

	public ProductDaoImpl() {
		super();
	}

	@Override
	public Page<Product> findAllByPage(Page<Product> page) {

		// pageRequest.setCountTotal(false);
		StringBuffer hqlBuff = new StringBuffer("FROM Product");
		List<Object> values = new ArrayList<Object>();
//		values.add("");

		return findPage(page, hqlBuff.toString(), values.toArray());
	}

}
