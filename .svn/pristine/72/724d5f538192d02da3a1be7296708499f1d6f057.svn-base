package cn.xaut.shop.phoneAction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import org.apache.struts2.ServletActionContext;
import cn.xaut.shop.util.JSONUtils;
import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.PointsItem;
import cn.xaut.shop.util.Struts2Utils;

public class PointsItemActionPhone extends BaseAction<PointsItem> {
	 private Map<String,Object> responseJson = new HashMap<String,Object>();
	 public Map<String, Object> getResponseJson() {
		return responseJson;
	 }	 
	 public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	 }
	 
	 private static final long serialVersionUID = 2765048276566985149L;

	 public String add() throws Exception {
		   page=pointsItemService.findItem(page,model.getItemname());
		   if(page!=null&&page.getTotalItems()>0) {
			      
			   String jsonList = JSONUtils.toJSONString(page);
			   Struts2Utils.renderString(jsonList);  
			   }
			else{
				pointsItemService.save(model);
				Struts2Utils.renderTrue();
			     }  
		       return null;
	    }
	   
	   public String update() throws Exception {
            if(model!=null) {
			pointsItemService.update(model);
			Struts2Utils.renderTrue();
			return null; 
            }            
            else{
            	return null;
            }
	    }
	   
	   public String list() throws Exception {
		  String key= ServletActionContext.getRequest().getParameter("keyword");
		  page=pointsItemService.getList(page,key);
		  if(page!=null&&page.getTotalItems()>0){		  
			  responseJson.put("ListPointsItem", page);
			  boolean isFristPage = page.isFirstPage();
			  boolean isLastPage = page.isLastPage();
			  responseJson.put("first", isFristPage);
			  responseJson.put("next", isLastPage);
		   }
		  else{
			  String ListPointsItem="0";
			  responseJson.put("ListPointsItem",ListPointsItem);
			  
		      }
		   return "ListPointsItem";   
	   }
	   
	   public String qury() throws Exception {	   
		 page=pointsItemService.queryAll(page);
		 if(page!=null&&page.getTotalItems()>0) {
			  String jsonList = JSONUtils.toJSONString(page);
			  Struts2Utils.renderString(jsonList);
			  boolean isFristPage = page.isFirstPage();
			  boolean isLastPage = page.isLastPage();
			  responseJson.put("first", isFristPage);
			  responseJson.put("next", isLastPage);
		   }
		 else {
			  Struts2Utils.renderTrue();
		       }
		    return null;   
	    }
	   
	  public String delete() throws Exception {
		     String id= Struts2Utils.getParameter("id");
		     pointsItemService.delete(Integer.parseInt(id));
			    return null;   
	   }
	   
	   public String getlistItem() throws Exception	{
		   List< PointsItem> list=pointsItemService.query();
		   request.put("PointsItemList", list);
			  return "list"; 
	   }
	   
	   public String getlist() throws Exception	{
		   List< PointsItem> list=pointsItemService.query();		  
		   responseJson.put("PointsItemList", list);		   
	          return "PointsItemList";
	    }
}
