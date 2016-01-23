package cn.xaut.shop.action;
import org.apache.struts2.ServletActionContext;
import cn.xaut.shop.pojo.DateRule;

public class DateRuleAction extends BaseAction<DateRule> {
	   /**
	 * 
	 */
	private static final long serialVersionUID = -8326375157023559791L;

	public String add()
	   {
		     page=dateRuleService.findItem(page,model.getRule());
		     if(page!=null&&page.getTotalItems()>0)
			  {
				  request.put("msgjudge", "该项已存在，不能重复添加"); 
				  request.put("page", page);
				  return "list";   
			  }
			  else
			  {
				  dateRuleService.save(model);
				   
			  }
			  return "query"; 
	   }
	   
	   public String update()
	   {
		   DateRule dateRule=dateRuleService.get(model.getDateId());
		   dateRule.setCount(model.getCount());
		   dateRuleService.update(dateRule);
		   return "query";   
	   }
	   
	   public String getlistItem()
	   {
		  page=dateRuleService.queryAll(page);
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
	   
	   public String list()
	   {
		  String key= ServletActionContext.getRequest().getParameter("keyword");
		  page=dateRuleService.getList(page,key);
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
			 int id =model.getDateId();
			 dateRuleService.delete(id);
			 return "query";   
	   }
	}


