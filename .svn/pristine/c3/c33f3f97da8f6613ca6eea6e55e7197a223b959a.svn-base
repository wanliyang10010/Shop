package cn.xaut.shop.service;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.Category;
import cn.xaut.shop.pojo.UserInfo;

public interface CategoryService extends BaseService<Category>{

	// 查询热点或者非热点类别
	public List<Category> queryByChot();
	
	public Category queryById(int id);

	List<Category> getList(String key);
	
	List<Category> queryByUserid(int id);
	
	public  Page<Category> queryByUserid(Page<Category> page, UserInfo user);
}
