package cn.xaut.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.ProductDao;
import cn.xaut.shop.pojo.Product;
import cn.xaut.shop.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl extends BaseServiceRImpl<Product,Integer> implements ProductService {
	

	private ProductDao productDao = null;
	@Autowired
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	public Page<Product> findAllByPage(Page<Product> page) {
		return productDao.findAllByPage(page);
	}

	
}
