package cn.xaut.shop.phoneAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.GoodsType;
import cn.xaut.shop.pojo.GoodsTypeItem;
/*
 * 
 * 1.基本所有的Action都需要用到request session application 内置对象
 * 
 * 通过他们存数数据，交给前台页面显示，Struts提供了AOP+Ioc的方式，在运行的时候自动注入->实现几个接口就可以了
 * 
 * 2. 前台页面中所有的数据名称，必须要用[对象.属性]方式取值， 这样做耦合性太高，我们可以实现一个接口来解耦
 * 
 * */


@SuppressWarnings("serial")
public class GoodsTypeItemActionPhone extends BaseAction<GoodsTypeItem> {
	private Map<String,Object> responseJson = new HashMap<String,Object>();
 	public Map<String, Object> getResponseJson() {
 		return responseJson;
 	}
 	public void setResponseJson(Map<String, Object> responseJson) {
 		this.responseJson = responseJson;
 	}
 	
 	
	
	//hx
	public String add()
	{
		goodsTypeItemService.save(model);
		responseJson.put("success","true");
		return SUCCESS;
	}
	//hx
	public String update()
	{   //String gtItemID=ServletActionContext.getRequest().getParameter("gtItemId");
	    //.setGtitemId(Integer.parseInt(gtItemID));
		goodsTypeItemService.update(model);
		responseJson.put("isResult","true");
		return "update";
	}
	
	public String delete()
	{
		String GtypeID=ServletActionContext.getRequest().getParameter("gtItemId");
		goodsTypeItemService.delete(Integer.parseInt(GtypeID));
		return "query";
	}
	
	
	//hx
	public String list()
	{
		
		
		page=goodsTypeItemService.Query(page,model.getGtypeId());
		List<GoodsTypeItem> list = new ArrayList<GoodsTypeItem>();
		if(page!=null&&page.getTotalItems()>0)
		  {
			  //request.put("msg", "");
			list = page.getResult();

			 // request.put("msg", "");
			boolean isFristPage = page.isFirstPage();
			boolean isLastPage = page.isLastPage();
			
			responseJson.put("first", isFristPage);
			responseJson.put("next", isLastPage);
		  }
		/*
		  else
		  {
			  request.put("msg", "没有符合条件的记录，请重新查询");
		  }*/
		
		responseJson.put("list", list);
		return "list";	
	}
	
	public String getItem()
	{
		String typeId=ServletActionContext.getRequest().getParameter("typeId");
		List<GoodsTypeItem> list=goodsTypeItemService.getListBytype(Integer.parseInt(typeId));
		session.put("GoodsTypeItemList", list);
		return "listItem";
	}
	
	public String query()
	{
		GoodsType goodstype=(GoodsType)session.get("goodstype");
		page=goodsTypeItemService.Query(page,goodstype.getGtypeId());
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
}
