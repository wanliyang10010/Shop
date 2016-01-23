package cn.xaut.shop.action;
import org.apache.struts2.ServletActionContext;
import cn.xaut.shop.pojo.MarginRule;

public class MarginRuleAction extends BaseAction<MarginRule>  {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public String add()
   {
	   page=marginRuleService.findItem(page,model.getType(),model.getProduct());
	   if(page!=null&&page.getTotalItems()>0)
		  {
			  request.put("msgjudge", "该项已存在，不能重复添加"); 
			  request.put("page", page);
			  return "list";   
		  }
		  else
		  {
			  marginRuleService.save(model);
			    
		  }
		  return "query";   
   }
   
   public String update()
   { 
	    MarginRule marginRule=marginRuleService.get(model.getMarginruleId());
	    marginRule.setMoney(model.getMoney());
		marginRuleService.update(marginRule);
		return "query";     
   }
   
   public String list()
   {
	  String stype= ServletActionContext.getRequest().getParameter("stype");
	  String key= ServletActionContext.getRequest().getParameter("keyword");
	  page=marginRuleService.getList(page,stype,key);
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
	  page=marginRuleService.queryAll(page);
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
		 int id =model.getMarginruleId();
		 marginRuleService.delete(id);
		 return "query";   
   }
   //得到店铺所需要的保证金数额，没有找到默认为0   ywl
   public String getShopMargin()
   {
	      String shopcategory= ServletActionContext.getRequest().getParameter("shopcategory");
		  String productcategory= ServletActionContext.getRequest().getParameter("productcategory");
		 String minmoney=marginRuleService.getShopMargin(shopcategory,productcategory);	
		 if(minmoney=="")
		 {
			 minmoney="0";
		 }
		 System.out.println(minmoney);
		 jsonMap.put("data", minmoney);
		 return "json";   
   }
}
