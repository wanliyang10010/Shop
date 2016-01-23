package cn.xaut.shop.service;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.Product;

public interface ProductService extends BaseServiceR<Product,Integer>{
	
	Page<Product> findAllByPage(Page<Product> page);
}
