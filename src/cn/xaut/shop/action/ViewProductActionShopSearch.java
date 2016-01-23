package cn.xaut.shop.action;

import org.apache.struts2.ServletActionContext;
import cn.xaut.shop.pojo.Shop;


public class ViewProductActionShopSearch extends BaseAction<Shop>{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 6773477958854687413L;
	 
       public String listShop()
       {
    	   String keyword=ServletActionContext.getRequest().getParameter("keyword");
    	   //System.out.println("pageshop------"+pageShop.getPageSize());
    	   //System.out.println("page------"+page.getPageSize());
    	   if(page.getPageSize()==5)
    	   {
    		   page.setPageSize(12);
    	   }
    	   else
    	   {
    		   page.setPageSize(page.getPageSize());
    	   }
    	   page= shopService.getListV(page,keyword);
		   if(page!=null&&page.getTotalItems()>0)
		   {
			   request.put("msgs", "");
		   }
		   else
		   {
			   request.put("msgs", "未查找到符合条件的店铺");
		   }
		   request.put("page", page);
		   return "listShop";
       }
       
       public String queryShop()
       {
    	   if(page.getPageSize()==5)
    	   {
    		   page.setPageSize(12);
    	   }
    	   else
    	   {
    		   page.setPageSize(page.getPageSize());
    	   }
    	   page= shopService.getListV(page,"");
		   if(page!=null&&page.getTotalItems()>0)
		   {
			   request.put("msgs", "");
		   }
		   else
		   {
			   request.put("msgs", "未查找到符合条件的店铺");
		   }
		   request.put("page", page);
		   return "listShop";
       }
}
