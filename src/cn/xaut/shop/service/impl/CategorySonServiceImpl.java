package cn.xaut.shop.service.impl;
import java.util.List;
import cn.xaut.shop.pojo.CategorySon;
import cn.xaut.shop.service.CategorySonService;
public class CategorySonServiceImpl extends BaseServiceImpl<CategorySon> implements CategorySonService {

	public CategorySonServiceImpl()
	{
		super();
	}


	
	@SuppressWarnings("unchecked")
	public List<CategorySon> queryById(int id) {
	    List<CategorySon> accounts = hibernateTemplate.findByNamedParam(
				"FROM CategorySon a WHERE a.categoryid =:categoryid",
				new String[] { "categoryid" },
				new Object[] {id});
	    
	   System.out.println(accounts.size());
	   return accounts;
	}
	
	@SuppressWarnings("unchecked")
	public CategorySon queryByMainId(int id) {
	    List<CategorySon> accounts = hibernateTemplate.findByNamedParam(
				"FROM CategorySon a WHERE a.categorysonid =:categorysonid",
				new String[] { "categorysonid" },
				new Object[] {id});
	    
	   System.out.println(accounts.size());
	   return accounts.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public CategorySon queryBySonId(int id) {
	    List<CategorySon> accounts = hibernateTemplate.findByNamedParam(
				"FROM CategorySon a WHERE a.categorysonid =:categorysonid",
				new String[] { "categorysonid" },
				new Object[] {id});
	    
	   System.out.println(accounts.size());
	   return accounts.get(0);
	}
	
	//对json数据进行分解，得到为一个字符串组
	public String[] handle(String str)
	{
		String[] sq=str.split(",");
		String a[]=new String[sq.length];
		for(int i=0;i<sq.length;i++)
		{
			int indexone = sq[i].lastIndexOf(":");
			int j=sq[i].length();
			a[i]=sq[i].substring(indexone+1, j).replace("\"", "");
		}
		return a;
	}
	
	
}
