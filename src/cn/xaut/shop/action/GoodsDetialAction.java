package cn.xaut.shop.action;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.GoodsDetial;
import cn.xaut.shop.pojo.GoodsTypeItem;

@SuppressWarnings("serial")
public class GoodsDetialAction extends BaseAction<GoodsDetial> {

	public String listitem()
	{
		String typeId=ServletActionContext.getRequest().getParameter("typeId");
		List<GoodsTypeItem> list=goodsTypeItemService.getListBytype(Integer.parseInt(typeId));
		session.put("GoodsTypeItemList", list);
		//session.put("GoodsTypeItemList", null);
		String goodsID=ServletActionContext.getRequest().getParameter("goodId");
		Goods goods=goodsService.get(Integer.parseInt(goodsID));
		session.put("goodsAdd",goods);
		page=goodsDetialService.queryAll(page,Integer.parseInt(goodsID));
		if(page!=null&&page.getTotalItems()>0)
		  {
			  request.put("msg", "");
		  }
		  else
		  {
			  request.put("msg", "没有符合条件的记录");
		  }
		request.put("page", page);
		return "list";
	}
		 
	public String add()
	{
		String itemtype=ServletActionContext.getRequest().getParameter("itemtype");
    	String itemid=ServletActionContext.getRequest().getParameter("itemid");
    	String goodsId=ServletActionContext.getRequest().getParameter("goodsId");
    	String itemvalue=ServletActionContext.getRequest().getParameter("itemvalue");
    	
    	if(goodsDetialService.getItemCount(itemtype,itemid,goodsId)>0)
    	{
    		jsonMap.put("data", "wrong");
    		} else {
    			if(goodsDetialService.getTypeCount(goodsId,itemtype))
    			{
    				GoodsDetial	goodsDetial=new GoodsDetial();
    				GoodsTypeItem gtItem=goodsTypeItemService.get(Integer.parseInt(itemid));
    				goodsDetial.setGoodsId(Integer.parseInt(goodsId));
    				goodsDetial.setItemtype(itemtype);
    				goodsDetial.setItemvalue(itemvalue.replace(",", "，"));
    				goodsDetial.setGtItem(gtItem);
    				goodsDetialService.save(goodsDetial);
    				jsonMap.put("data", "right");
    			}
    			else
    			{
    				jsonMap.put("data", "full");
    			}
    		}
		return "json";
	}
	
	public String update()
	{   String gdetialId=ServletActionContext.getRequest().getParameter("gdetialId");
	    GoodsDetial gdetial=goodsDetialService.get(Integer.parseInt(gdetialId));
	    String itemvalue=ServletActionContext.getRequest().getParameter("itemvalue");
	    gdetial.setItemvalue(itemvalue.replace(",", "，"));
	    goodsDetialService.update(gdetial);
		return "query";
	}
	
	public String delete()
	{
		String GtypeID=ServletActionContext.getRequest().getParameter("gdetialId");
		goodsDetialService.delete(Integer.parseInt(GtypeID));
		return "query";
	}
	
	public String list()
	{
		String key=ServletActionContext.getRequest().getParameter("keyword");
		String goodsID=ServletActionContext.getRequest().getParameter("goodsId");
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
