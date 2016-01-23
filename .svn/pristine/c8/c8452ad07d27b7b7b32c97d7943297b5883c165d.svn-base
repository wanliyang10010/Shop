package cn.xaut.shop.dao;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.Category;
import cn.xaut.shop.pojo.UserInfo;

public interface CategoryDao extends  CrudRepository<Category, Integer>{

	Page<Category> queryByUserid(Page<Category> page, UserInfo user);
}