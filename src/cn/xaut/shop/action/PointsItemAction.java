package cn.xaut.shop.action;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import cn.xaut.shop.pojo.PointsItem;


public class PointsItemAction extends BaseAction<PointsItem>{
	   /**
	 * 
	 */
	private static final long serialVersionUID = 2765048276566985149L;

	public String add()
	   {
		   page=pointsItemService.findItem(page,model.getItemname());
		   if(page!=null&&page.getTotalItems()>0)
			  {
				  request.put("msgjudge", "该项已存在，不能重复添加"); 
				  request.put("page", page);
				  return "list";   
			  }
			  else
			  {
				  pointsItemService.save(model); 
			  }  
			  return "query";
	   }
	   
	   public String update()
	   {
			String id= ServletActionContext.getRequest().getParameter("itemId");
			model.setPitemid(Integer.parseInt(id));
			pointsItemService.update(model);
			return "query";   
	   }
	   
	   public String list()
	   {
		  String key= ServletActionContext.getRequest().getParameter("keyword");
		  page=pointsItemService.getList(page,key);
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
		 page=pointsItemService.queryAll(page);
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
		     pointsItemService.delete(Integer.parseInt(id));
			 return "query";   
	   }
	   
	   public String getlistItem()
	   {
		   List< PointsItem> list=pointsItemService.query();
		  request.put("PointsItemList", list);
		  return "list";   
	   }
	   
	   public String getlist()
	   {
		   List< PointsItem> list=pointsItemService.query();
		  session.put("PointsItemList", list);
		  System.out.println(list.size());
		  return "listRule";   
	   }
}
