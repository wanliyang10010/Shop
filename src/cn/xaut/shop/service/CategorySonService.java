package cn.xaut.shop.service;
import java.util.List;
import cn.xaut.shop.pojo.CategorySon;
public interface CategorySonService extends BaseService<CategorySon>{
	
	public List<CategorySon> queryById(int id);

	public CategorySon queryByMainId(int id);
	
	public String[] handle(String str);
	
	public CategorySon queryBySonId(int id);
}
