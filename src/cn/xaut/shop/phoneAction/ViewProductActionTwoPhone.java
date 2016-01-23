package cn.xaut.shop.phoneAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import net.sf.json.util.JSONUtils;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.Shop;

public class ViewProductActionTwoPhone extends BaseAction<Shop>{
		
	/**/
	private Map<String,Object> responseJson = new HashMap<String,Object>();
	public Map<String, Object> getResponseJson() {
		return responseJson;
	}
	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}	
    /**/
	private static final long serialVersionUID = 6773477958854687413L;
	
	private Page<Shop> page=new Page<Shop>();
	public Page<Shop> getPage() {
		return page;
	}
	public void setPage(Page<Shop> page) {
		this.page = page;
	}
      
       //店铺查询了所有-已完成
      public String listShopAll() throws IOException
      {    	 
    	  page= shopService.getListAllShop(page);
     	  List<Shop> list = new ArrayList<Shop>();
    	  if(page.getTotalItems()!=0)
    	  {   
    	    list = page.getResult();
    	    boolean isFristPage = page.isFirstPage();
 			boolean isLastPage = page.isLastPage();			
 			responseJson.put("attendlistShop", list);
 			responseJson.put("first", isFristPage);
 			responseJson.put("next", isLastPage);		
    	 }else{   			
 			responseJson.put("attendlistShop", list);
 		 }
		   return "attendlistShop";
       }
	
 
}
