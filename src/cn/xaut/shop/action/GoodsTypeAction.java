package cn.xaut.shop.action;


import java.util.List;

import org.apache.struts2.ServletActionContext;
/*
 * 
 * 1.基本所有的Action都需要用到request session application 内置对象
 * 
 * 通过他们存数数据，交给前台页面显示，Struts提供了AOP+Ioc的方式，在运行的时候自动注入->实现几个接口就可以了
 * 
 * 2. 前台页面中所有的数据名称，必须要用[对象.属性]方式取值， 这样做耦合性太高，我们可以实现一个接口来解耦
 * 
 * */
import cn.xaut.shop.pojo.GoodsType;
import cn.xaut.shop.pojo.Shop;

@SuppressWarnings("serial")
public class GoodsTypeAction extends BaseAction<GoodsType> {
    public String checkname()
    {
    	String shopId=ServletActionContext.getRequest().getParameter("shopId");
    	String typename=ServletActionContext.getRequest().getParameter("typename");
    	if(goodsTypeService.getTypeCount(shopId,typename)>0)
    	{
    		jsonMap.put("data", "wrong");
    		} else {
    			jsonMap.put("data", "right");
    		}
    		return "json";
    } 
    
    public String checkupdate()
    {
    	String shopId=ServletActionContext.getRequest().getParameter("shopId");
    	String typename=ServletActionContext.getRequest().getParameter("typename");
    	String gtypeId=ServletActionContext.getRequest().getParameter("gtypeId");
    	if(goodsTypeService.getTypeCount(shopId,typename)>0)
    	{
    		GoodsType goodsType=goodsTypeService.get(Integer.parseInt(gtypeId));
    		if(goodsType.getTypename().equals(typename))
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
		String shopId=ServletActionContext.getRequest().getParameter("shopId");
		goodsTypeService.save(model);
		session.put("shopId", shopId);
		return "query";
	}
	
	public String update()
	{   String GtypeID=ServletActionContext.getRequest().getParameter("gtypeId");
	    String shopId=ServletActionContext.getRequest().getParameter("shopId");
	    model.setGtypeId(Integer.parseInt(GtypeID));
		goodsTypeService.update(model);
		session.put("shopId", shopId);
		return "query";
	}

	public String delete()
	{
		String GtypeID=ServletActionContext.getRequest().getParameter("gtypeId");
		//String shopId=ServletActionContext.getRequest().getParameter("shopId");
		if(goodsService.getByType(GtypeID)>0)
    	{
    		jsonMap.put("data", "wrong");
    		} else {
    			goodsTypeService.delete(Integer.parseInt(GtypeID));
    			jsonMap.put("data", "right");
    		}
		return "json";
	}
	
	public String list()
	{
		String key=ServletActionContext.getRequest().getParameter("keyword");
		String shopId=ServletActionContext.getRequest().getParameter("shopId");
		page=goodsTypeService.GetList(page, key,shopId);
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
	
	public String query()
	{
		String shopId=session.get("shopId").toString();
		System.out.println(shopId);
		page=goodsTypeService.Query(page,shopId);
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
	
	public String getlist()
	{
		String shopId=ServletActionContext.getRequest().getParameter("shopId");
		System.out.println(shopId);
		page=goodsTypeService.Query(page,shopId);
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
	
	public String queryall()
	{
		
		return "list";
	}
	
	public String typeItem()
	{
		String gtid=ServletActionContext.getRequest().getParameter("gtypeId");
		GoodsType goodstype=goodsTypeService.get(Integer.parseInt(gtid));
		System.out.println(goodstype.getTypename());
		session.put("goodstype",goodstype);
		return "item";
	}
	
	public String getListByShop()
	{
		Shop shop =(Shop)session.get("shop");
		List<GoodsType> list=goodsTypeService.getListByShopId(shop.getShopId());
		session.put("goodstypeList",list);
		//session.put("goodstypeList",null);
		return "itemList";
	}
}
