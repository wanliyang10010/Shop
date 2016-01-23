package cn.xaut.shop.action;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import cn.xaut.shop.pojo. MarginItem;

public class MarginItemAction extends BaseAction<MarginItem>{
	   /**
	 * 
	 */
	private static final long serialVersionUID = 5093031375657804447L;
	public String add()
	   {
		   page=marginItemService.findItem(page,model.getItemname());
		   if(page!=null&&page.getTotalItems()>0)
			  {
				  request.put("msgjudge", "该项已存在，不能重复添加"); 
				  request.put("page", page);
				  return "list";   
			  }
			  else
			  {
				  marginItemService.save(model);  
			  }  
			  return "query";
	   }
	   
	   public String update()
	   {
			String id= ServletActionContext.getRequest().getParameter("itemId");
			model.setMitemid(Integer.parseInt(id));
			marginItemService.update(model);
			return "query";    
	   }
	   
	   public String list()
	   {
		  String key= ServletActionContext.getRequest().getParameter("keyword");
		  page=marginItemService.getList(page,key);
		  if(page!=null&&page.getTotalItems()>0)
		  {
			  request.put("msg", "");
		  }
		  else
		  {
			  request.put("msg", "没有符合条件的记录，请重新查询");
		  }
		request.put("page", page);
		  return "list";   
	   }
	   
	   public String qury()
	   {
		  page=marginItemService.queryAll(page);
		  if(page!=null&&page.getTotalItems()>0)
		  {
			  request.put("msg", "");
		  }
		  else
		  {
			  request.put("msg", "没有符合条件的记录，请重新查询");
		  }
		request.put("page", page);
		  return "list";   
	   }
	   
	   public String delete()
	   {
		     String id= ServletActionContext.getRequest().getParameter("itemId");
			 marginItemService.delete(Integer.parseInt(id));
			 return "query";   
	   }
	   
	   public String getlistItem()
	   {
		  List<MarginItem> list=marginItemService.query();
		  request.put("MarginItemList", list);
		  return "list";   
	   }
	   
	   public String getlist()
	   {
		  List<MarginItem> list=marginItemService.query();
		  //System.out.println(list.size());
		  session.put("MarginItemList", list);
		  return "listRule";   
	   }
}
