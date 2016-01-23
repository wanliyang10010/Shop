package cn.xaut.shop.action;
import org.apache.struts2.ServletActionContext;
import cn.xaut.shop.pojo.PointsRule;

public class PointsRuleAction  extends BaseAction< PointsRule>{
   /**
	 * 
	 */
	private static final long serialVersionUID = 3531480769127603421L;

public String add()
   {
	   page= pointsRuleService.findItem(page,model.getType(),model.getRule());
	   if(page!=null&&page.getTotalItems()>0)
		  {
			  request.put("msgjudge", "该项已存在，不能重复添加"); 
			  request.put("page", page);
			  return "list";   
		  }
		  else
		  {
			  pointsRuleService.save(model);
			   
		  }
		  return "query"; 
   }
   
   public String update()
   {
	   PointsRule pointsRule=pointsRuleService.get(model.getPointsId());
	   pointsRule.setCount(model.getCount());
	   pointsRuleService.update(pointsRule);
	   return "query";   
   }
   
   public String list()
   {
	  String stype=ServletActionContext.getRequest().getParameter("stype");
	  String key=ServletActionContext.getRequest().getParameter("keyword");
	  page=pointsRuleService.getList(page,stype,key);
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
   
   public String getlistItem()
   {
	  page=pointsRuleService.queryAll(page);
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
		 int id =model.getPointsId();
		 pointsRuleService.delete(id);
		 //list();
		 return "query";   
   }
}
