package cn.xaut.shop.action;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import cn.xaut.shop.pojo.DateItem;

public class DateItemAction extends BaseAction<DateItem>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3285141425637096839L;
	   public String add()
	   {      
		      page=dateItemService.findItem(page,model.getItemname());
		      if(page!=null&&page.getTotalItems()>0)
			  {
				  request.put("msgjudge", "该项已存在，不能重复添加"); 
				  request.put("page", page);
				  return "list";   
			  }
			  else
			  {
				  dateItemService.save(model);
			  }
			  return "query";   
	   }
	   
	   public String update()
	   {
		    String id= ServletActionContext.getRequest().getParameter("itemId");
			model.setDitemid(Integer.parseInt(id));
			dateItemService.update(model);
			return "query";   
	   }
	   
	   public String list()
	   {
		  String key= ServletActionContext.getRequest().getParameter("keyword");
		  page=dateItemService.getList(page,key);
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
		  page=dateItemService.queryAll(page);
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
			 dateItemService.delete(Integer.parseInt(id));
			 return "query";   
	   }
	   
	   public String getlistItem()
	   {
		  List<DateItem> list=dateItemService.query();
		  request.put("DateItemList", list);
		  return "list";   
	   }
	   
	   public String getlist()
	   {
		  List<DateItem> list=dateItemService.query();
		  session.put("DateItemList", list);
		  return "listRule";   
	   }
	}

