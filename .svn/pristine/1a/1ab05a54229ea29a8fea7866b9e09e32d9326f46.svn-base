package cn.xaut.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.CategoryDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.Category;
import cn.xaut.shop.pojo.UserInfo;

public class CategoryDaoImpl extends HibernateRepository<Category,Integer> implements
   CategoryDao {
	
	public Page<Category> queryByUserid(Page<Category> page, UserInfo user) {

		StringBuffer hqlBuff = new StringBuffer("select f from Category as f where f.user = ?");

		List<Object> values = new ArrayList<Object>();
		values.add(user);

		return findPage(page, hqlBuff.toString(), values.toArray());
	}
	
}
