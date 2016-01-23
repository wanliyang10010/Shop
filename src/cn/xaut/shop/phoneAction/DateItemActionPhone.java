package cn.xaut.shop.phoneAction;
import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.JSONUtil;


import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.util.JSONUtils;
import cn.xaut.shop.util.Struts2Utils;
import net.sf.json.JSONObject;
import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.DateItem;


public class DateItemActionPhone extends BaseAction<DateItem>{
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
	
	private static final long serialVersionUID = 3285141425637096839L;
	   public String add() throws Exception { 
		      String isResult = "true";
		      page=dateItemService.findItem(page,model.getItemname());
		      if(page!=null&&page.getTotalItems()>0)
			  {
		    	  
		    	  String jsonList = JSONUtils.toJSONString(page);
				  Struts2Utils.renderString(jsonList); 
			  }
		      else 
			  {
				  dateItemService.save(model);
				  Struts2Utils.renderTrue();
			  }
		      return null;
	   }
	   
	   public String update() throws Exception
	   {
			if (model!= null) {
				
				dateItemService.update(model);
				Struts2Utils.renderTrue();
				return null;
			}else
			{
				return null;
			}  
//		   page=dateItemService.findItem(page,model.getItemname());
//		   if(page!= null){
//			   dateItemService.update(model);
//			   Struts2Utils.renderTrue();
//			return null;   
//	   }else
//	   {
//		   return null;
//	   }
	 }
	   
	   public String list() throws IOException
	   {
		  String key= ServletActionContext.getRequest().getParameter("keyword");
		  page=dateItemService.getList(page,key);  
		  if(page!=null&&page.getTotalItems()>0)
		  {
			
			  responseJson.put("ListDateItem", page.getResult());
			  boolean isFristPage = page.isFirstPage();
			  boolean isLastPage = page.isLastPage();
			  responseJson.put("first", isFristPage);
			  responseJson.put("next", isLastPage);
		  }
		  else
		  {
			  String ListDateItem="0";
   		    responseJson.put("ListDateItem",ListDateItem);	 
		  }
		  return "ListDateItem";   
	   }
	   
	   public String qury() throws Exception
	   {
		  page=dateItemService.queryAll(page);
		  if(page!=null&&page.getTotalItems()>0)
		  {
			  String jsonList = JSONUtils.toJSONString(page);
			  Struts2Utils.renderString(jsonList);
		  }
		  else
		  {
			  Struts2Utils.renderTrue();
		  }
		  return null;   
	   }
	   
	   public String delete() throws Exception
	   {
		     String id= Struts2Utils.getParameter("id");
		     dateItemService.deleteById(Integer.valueOf(id));
			 return null;   
	   }
	   
	   public String getlistItem() throws Exception
	   {
		  List<DateItem> list=dateItemService.query();
       
       
		  request.put("DateItemList", list);
		  return "list";   
	   }
	   
	   public String getlist() throws Exception
	   {
		  List<DateItem> list=dateItemService.query();
		 // session.put("DateItemList", list);
		  responseJson.put("DateItemList",list);
		  return "DateItemList";   
	   }
	}

