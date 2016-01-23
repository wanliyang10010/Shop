package cn.xaut.shop.action;
import java.util.List;

import org.apache.struts2.ServletActionContext;
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
public class GoodsTypeItemAction extends BaseAction<GoodsTypeItem> {
	public String checkname()
    {
    	String gtypeId=ServletActionContext.getRequest().getParameter("gtypeId");
    	String itemname=ServletActionContext.getRequest().getParameter("itemname");
    	if(goodsTypeItemService.getTypeCount(gtypeId,itemname)>0)
    	{
    		jsonMap.put("data", "wrong");
    		} else {
    			jsonMap.put("data", "right");
    		}
    		return "json";
    } 
    
    public String checkupdate()
    {
    	String gtypeId=ServletActionContext.getRequest().getParameter("gtypeId");
    	String itemname=ServletActionContext.getRequest().getParameter("itemname");
    	String gtItemId=ServletActionContext.getRequest().getParameter("gtItemId");
    	GoodsTypeItem goodsTypeItem=goodsTypeItemService.getTypeCountUpdate(gtypeId,itemname);
    	if(goodsTypeItem!=null&&goodsTypeItem.getGtitemId()>0)
    	{
    		System.out.println(goodsTypeItem.getGtitemId()+"=="+gtItemId);
	    		if(goodsTypeItem.getGtitemId().toString().equals(gtItemId))
	    		{
	    			jsonMap.put("data", "right");
	    		}
	    		else
	    		{
	    			jsonMap.put("data", "wrong");
	    		}
    		
    		} else {
    			jsonMap.put("data", "right");
    		}
    		return "json";
    } 
    
	public String add()
	{
		goodsTypeItemService.save(model);
		return "query";
	}
	
	public String update()
	{   String gtItemID=ServletActionContext.getRequest().getParameter("gtItemId");
	    model.setGtitemId(Integer.parseInt(gtItemID));
		goodsTypeItemService.update(model);
		return "query";
	}
	
	public String delete()
	{
		String gtItemId=ServletActionContext.getRequest().getParameter("gtItemId");
		if(goodsDetialService.getGoodByItemType(gtItemId)>0)
		{
			jsonMap.put("data", "wrong");
		} else {
			goodsTypeItemService.delete(Integer.parseInt(gtItemId));
			jsonMap.put("data", "right");
		}
	   return "json";
	}
	
	public String list()
	{
		String key=ServletActionContext.getRequest().getParameter("keyword");
		GoodsType goodstype=(GoodsType)session.get("goodstype");
		page=goodsTypeItemService.GetList(page,goodstype.getGtypeId(),key);
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
	
	public String getItem()
	{
		String typeId=ServletActionContext.getRequest().getParameter("typeId");
		List<GoodsTypeItem> list=goodsTypeItemService.getListBytype(Integer.parseInt(typeId));
		session.put("GoodsTypeItemList", list);
		return "listItem";
	}
	
	public String query()
	{
		String key=ServletActionContext.getRequest().getParameter("keyword");
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
