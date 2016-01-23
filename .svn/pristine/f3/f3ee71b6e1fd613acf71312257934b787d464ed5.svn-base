package cn.xaut.shop.phoneAction;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.GoodsType;
import cn.xaut.shop.pojo.Shop;

@SuppressWarnings("serial")
public class GoodsTypeActionPhone extends BaseAction<GoodsType> {
	private Map<String,Object> responseJson = new HashMap<String,Object>();
 	public Map<String, Object> getResponseJson() {
 		return responseJson;
 	}
 	public void setResponseJson(Map<String, Object> responseJson) {
 		this.responseJson = responseJson;
 	}
 	
 	private Integer userid;
 	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	private String myShopId;

	public String getMyShopId() {
		return myShopId;
	}
	public void setMyShopId(String myShopId) {
		this.myShopId = myShopId;
	}
	//hx
	public String getShop(){
	
		List<Shop> shopList = new ArrayList<Shop>();
		shopList = shopService.getListByUserId(userid);
		responseJson.put("shop", shopList.get(0));
		/*
		page=goodsTypeService.Query(page);
		List<GoodsType> list = new ArrayList<GoodsType>();
		if(page!=null&&page.getTotalItems()>0)
		{
			list = page.getResult();
			boolean isFristPage = page.isFirstPage();
			boolean isLastPage = page.isLastPage();
			
			responseJson.put("first", isFristPage);
			responseJson.put("next", isLastPage);
		}
		responseJson.put("check", list);
		*/
		return "getShop";
	}

	public String add()
	{
		goodsTypeService.save(model);
		responseJson.put("success","true");
		return SUCCESS;
	}
	//hx 暂未修改
	public String update()
	{   //String GtypeID=ServletActionContext.getRequest().getParameter("gtypeId");
	    //model.setGtypeId(Integer.parseInt(GtypeID));
		goodsTypeService.update(model);
		responseJson.put("success","true");
		return "update";
	}
	
	public String delete()
	{
		String GtypeID=ServletActionContext.getRequest().getParameter("gtypeId");
		goodsTypeService.delete(Integer.parseInt(GtypeID));
		return "query";
	}
	//zz 添加店铺ID参数，注销该函数
	public String list()
	{
		String key=ServletActionContext.getRequest().getParameter("keyword");
//		page=goodsTypeService.GetList(page, key);
//		if(page!=null&&page.getTotalItems()>0)
//		  {
//			  request.put("msg", "");
//		  }
//		  else
//		  {
//			  request.put("msg", "没有符合条件的记录，请重新查询");
//		  }
//		request.put("page", page);
		return "list";
	}
	
	//hx
	//zz 添加店铺ID参数，注销该函数
	public String query()
	{
		
//		page=goodsTypeService.Query(page);
//		List<GoodsType> list = new ArrayList<GoodsType>();
//		if(page!=null&&page.getTotalItems()>0)
//		{
//			list = page.getResult();
//
//			 // request.put("msg", "");
//			boolean isFristPage = page.isFirstPage();
//			boolean isLastPage = page.isLastPage();
//			
//			responseJson.put("first", isFristPage);
////			responseJson.put("next", isLastPage);
//		}
		/*
		else
		{
			  request.put("msg", "没有符合条件的记录，请重新查询");
		}*/
		
//		responseJson.put("list", list);
		//request.put("page", page);
		return "list";
	}
	
	//hx  
	public String typeItem()
	{
		//String gtid=ServletActionContext.getRequest().getParameter("gtypeId");
		//这个方法无效，没有办法获取到值
		//GoodsType goodstype=goodsTypeService.get(model.getGtypeId());
		GoodsType goodstype = goodsTypeService.getGoodsTypeById(model.getGtypeId());
		responseJson.put("goodstype", goodstype);
		//session.put("goodstype",goodstype);
		return "item";
	}
	
	//根据店铺id(shopId)查询GoodsType的List  hx
	public String getListByShop()
	{
		//Shop shop =(Shop)session.get("shop");
		//List<GoodsType> list=goodsTypeService.getListByShopId(shop.getShopId());
		List<GoodsType> list=goodsTypeService.getListByShopId(Integer.parseInt(myShopId));
		responseJson.put("goodstypeList", list);
		//session.put("goodstypeList",list);
		return "itemList";
	}
}
