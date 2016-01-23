package cn.xaut.shop.phoneAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.GoodsDetial;
import cn.xaut.shop.pojo.GoodsTypeItem;

@SuppressWarnings("serial")
public class GoodsDetialActionPhone extends BaseAction<GoodsDetial> {
	private Map<String,Object> responseJson = new HashMap<String,Object>();
 	public Map<String, Object> getResponseJson() {
 		return responseJson;
 	}
 	public void setResponseJson(Map<String, Object> responseJson) {
 		this.responseJson = responseJson;
 	}
	private String myTypeId;
	private String myGoodId;
	private String mygtitemId;
	
	
	public String getMyTypeId() {
		return myTypeId;
	}

	public void setMyTypeId(String myTypeId) {
		this.myTypeId = myTypeId;
	}

	public String getMyGoodId() {
		return myGoodId;
	}

	public void setMyGoodId(String myGoodId) {
		this.myGoodId = myGoodId;
	}

	public String getMygtitemId() {
		return mygtitemId;
	}
	public void setMygtitemId(String mygtitemId) {
		this.mygtitemId = mygtitemId;
	}
	//hx
	public String listitem()
	{
		//String typeId=ServletActionContext.getRequest().getParameter("typeId");
		//List<GoodsTypeItem> list=goodsTypeItemService.getListBytype(Integer.parseInt(typeId));
		List<GoodsTypeItem> list=goodsTypeItemService.getListBytype(Integer.parseInt(myTypeId));
		//session.put("GoodsTypeItemList", list);
		responseJson.put("GoodsTypeItemList", list);
		//String goodsID=ServletActionContext.getRequest().getParameter("goodId");
		//Goods goods=goodsService.get(Integer.parseInt(myGoodId));
		Goods goods=goodsService.getGoodsByGoodsId(Integer.parseInt(myGoodId));
		//session.put("goodsAdd",goods);
		responseJson.put("goodsAdd",goods);
		page=goodsDetialService.queryAll(page,Integer.parseInt(myGoodId));
		boolean isFristPage = true;
		boolean isLastPage = true;
		List<GoodsDetial> goodsDetiallist = new ArrayList<GoodsDetial>();
		if(page!=null&&page.getTotalItems()>0)
		  {
			 // request.put("msg", "");
			isFristPage = page.isFirstPage();
			isLastPage = page.isLastPage();
			goodsDetiallist = page.getResult();
		  }
		/*
		  else
		  {
			  request.put("msg", "没有符合条件的记录，请重新查询");
		  }*/
		//request.put("page", page);
		
		
		responseJson.put("first", isFristPage);
		responseJson.put("next", isLastPage);
		responseJson.put("list", goodsDetiallist);
		return "list";
	}
	
	//hx 添加
	public String add()
	{
		//String gtitemId=ServletActionContext.getRequest().getParameter("itemid");
		//GoodsTypeItem gtItem=goodsTypeItemService.get(Integer.parseInt(gtitemId));
		GoodsTypeItem gtItem=goodsTypeItemService.getGoodsTypeItemByGtitemId(Integer.parseInt(mygtitemId));
		
		model.setGtItem(gtItem);
		goodsDetialService.save(model);
		responseJson.put("isResult", "true");
		return "query";
	}
	//hx 更新
	public String update()
	{   //String gdetialId=ServletActionContext.getRequest().getParameter("gdetialId");
	    //model.setGdetialId(Integer.parseInt(gdetialId));
	    //String gtitemId=ServletActionContext.getRequest().getParameter("itemid");
		//GoodsTypeItem gtItem=goodsTypeItemService.get(Integer.parseInt(mygtitemId));
		GoodsTypeItem gtItem=goodsTypeItemService.getGoodsTypeItemByGtitemId(Integer.parseInt(mygtitemId));
		model.setGtItem(gtItem);
	    goodsDetialService.update(model);
	    responseJson.put("isResult", "true");
		return "update";
	}
	
	public String delete()
	{
		//String GtypeID=ServletActionContext.getRequest().getParameter("gdetialId");
		goodsDetialService.delete(model.getGdetialId());
		responseJson.put("isResult", "true");
		return "delete";
	}
	
	public String list()
	{
		String key=ServletActionContext.getRequest().getParameter("keyword");
		//String goodsID=ServletActionContext.getRequest().getParameter("goodsId");
		Goods goods=(Goods)session.get("goodsAdd");
		page=goodsDetialService.GetList(page, key,goods.getGoodsid().toString());
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
		//String goodsID=ServletActionContext.getRequest().getParameter("goodsId");
		Goods goods=(Goods)session.get("goodsAdd");
		page=goodsDetialService.queryAll(page,goods.getGoodsid());
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
