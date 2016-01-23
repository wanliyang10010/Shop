package cn.xaut.shop.phoneAction;
import org.apache.struts2.ServletActionContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.DateRule;
import cn.xaut.shop.util.JSONUtils;
import cn.xaut.shop.util.Struts2Utils;

public class DateRuleActionPhone extends BaseAction<DateRule> {
	   /**
	 * 
	 */
	private Map<String,Object> responseJson = new HashMap<String,Object>();
	public Map<String, Object> getResponseJson() {
		return responseJson;
	}
	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}	
	private static final long serialVersionUID = -8326375157023559791L;

	public String add() throws Exception 
	   {
		     page=dateRuleService.findItem(page,model.getRule());
		     if(page!=null&&page.getTotalItems()>0)
			  {
		    	  String jsonList = JSONUtils.toJSONString(page);
				  Struts2Utils.renderString(jsonList); 
			  }
			  else
			  {
				  dateRuleService.save(model);
				  Struts2Utils.renderTrue();
				   
			  }
			  return null; 
	   }
	   
	public String update() throws Exception{
		if (model != null) {
			
			dateRuleService.update(model);
			Struts2Utils.renderTrue();
			return null;
		}else
		{
			return null;
		}
	}
	   
	   public String getlistItem() throws Exception
	   {
		  page=dateRuleService.queryAll(page);
		  if(page!=null&&page.getTotalItems()>0)
		  { 
			  String jsonList = JSONUtils.toJSONString(page);
			  Struts2Utils.renderString(jsonList);	 
		  }
		  else
		  {
			  dateRuleService.save(model);
			  Struts2Utils.renderTrue();
		  }
		  return null;   
	   }
	   
	   public String list()
	   {
		  String key= ServletActionContext.getRequest().getParameter("keyword");
		  page=dateRuleService.getList(page,key);
		  if(page!=null&&page.getTotalItems()>0)
		  {
			  responseJson.put("ListDateRule", page);
			  boolean isFristPage = page.isFirstPage();
			  boolean isLastPage = page.isLastPage();
			  responseJson.put("first", isFristPage);
			  responseJson.put("next", isLastPage);
		  }
		  else
		  {
			  String ListDateRule="0";
   		      responseJson.put("ListDateRule",ListDateRule);	
		  }
		  return "ListDateRule";   
	   }
	   
	   public String delete()
	   {
		     String id= Struts2Utils.getParameter("id");
			 dateRuleService.deleteById(Integer.valueOf(id));
			 return null;   
	   }
	}


