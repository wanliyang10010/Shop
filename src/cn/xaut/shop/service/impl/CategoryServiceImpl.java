package cn.xaut.shop.service.impl;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.CategoryDao;
import cn.xaut.shop.pojo.Category;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.service.CategoryService;

public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	public CategoryServiceImpl()
	{
		super();
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> queryByChot() {
		return hibernateTemplate.findByNamedParam("FROM Category c WHERE c.chot=:chot","chot", "true");
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> queryByUserid(int id) {
	    List<Category> accounts = hibernateTemplate.findByNamedParam(
				"FROM Category a WHERE a.userid =:userid",
				new String[] { "userid" },
				new Object[] { id});
	    
	   System.out.println(accounts.size());

	   return accounts;
	}
	
	
	//分页
	private CategoryDao categoryDao = null;
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	public Page<Category> queryByUserid(Page<Category> page,UserInfo user) {
		return categoryDao.queryByUserid(page, user);
	}
	
	
	
	@SuppressWarnings("unchecked")
	public Category queryById(int id) {
	    List<Category> accounts = hibernateTemplate.findByNamedParam(
				"FROM Category a WHERE a.cid =:cid",
				new String[] { "cid" },
				new Object[] { id});
	    
	   System.out.println(accounts.size());
	   
	   if(accounts != null&&accounts.size()>0)
	   {
		   return accounts.get(0);
	   }
	   else
	   {
		  return  null;
	   }
	}
	
	public List<Category> getList(String key) {
		return  null;
	}
	
}
