package cn.xaut.shop.dao;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.Product;

public interface ProductDao extends CrudRepository<Product,Integer> {

	Page<Product> findAllByPage(Page<Product> page);

}
