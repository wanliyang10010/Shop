package cn.xaut.shop.phoneAction;
import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.PointsRule;
import cn.xaut.shop.util.JSONUtils;
import cn.xaut.shop.util.Struts2Utils;

  public class PointsRuleActionPhone  extends BaseAction< PointsRule>{
	private Map<String,Object> responseJson = new HashMap<String,Object>();
	public Map<String, Object> getResponseJson() {
		return responseJson;
	 }
	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	 }
	private static final long serialVersionUID = 3531480769127603421L;

    public String add() throws Exception {
	   page= pointsRuleService.findItem(page,model.getType(),model.getRule());
	   if(page!=null&&page.getTotalItems()>0) {		   
		   String jsonList = JSONUtils.toJSONString(page);
		   Struts2Utils.renderString(jsonList); 
		  }
		else{		  
		    pointsRuleService.save(model);
			Struts2Utils.renderTrue();			   
		  } 
	       return null;		  
    }

    public String qury() throws Exception {	   
	    page=pointsRuleService.queryAll(page);
	    if(page!=null&&page.getTotalItems()>0) {
		  String jsonList = JSONUtils.toJSONString(page);
		  Struts2Utils.renderString(jsonList);			 
	      }
	    else {
		  Struts2Utils.renderTrue();
	       }
	  return null;   
   }
    
   public String update() throws Exception  {
	   PointsRule pointsRule=pointsRuleService.get(model.getPointsId());
	   pointsRule.setCount(model.getCount());
	   pointsRuleService.update(pointsRule);
	   Struts2Utils.renderTrue();
	   return null;   
    }
   
   public String list() throws Exception  {
	   String str="用户类型";
	   String key=ServletActionContext.getRequest().getParameter("keyword");
	   page=pointsRuleService.getList(page,str,key);
	   if(page!=null&&page.getTotalItems()>0) {	  		  
		   responseJson.put("ListPointsRule", page);
		  
	  }
	  else
	  {		  
		  String ListPointsRule="0";
		  responseJson.put("ListPointsRule",ListPointsRule);
	  }
	  return "ListPointsRule";   
    } 
   
    public String getlistItem() throws Exception {
	   page=pointsRuleService.queryAll(page);
	   if(page!=null&&page.getTotalItems()>0) {
		  String jsonList = JSONUtils.toJSONString(page);
		  Struts2Utils.renderString(jsonList);
	   }
	    else
	   {
		  Struts2Utils.renderTrue();
	    }
	  return null;   
    } 
   
    public String delete() throws Exception {		 
	   String id= Struts2Utils.getParameter("id");
	   pointsRuleService.delete(Integer.parseInt(id));		  		   
       return null; 
    } 
}
