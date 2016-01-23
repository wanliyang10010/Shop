package cn.xaut.shop.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import cn.xaut.shop.pojo.Discount;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.GoodsDetial;
import cn.xaut.shop.pojo.GoodsStock;
import cn.xaut.shop.pojo.Page;
import cn.xaut.shop.pojo.SaleGoods;
import cn.xaut.shop.pojo.Shop;

@SuppressWarnings("serial")
public class GoodsStockAction extends BaseAction<GoodsStock> {
	public String getItem()
	{
		String gid = ServletActionContext.getRequest().getParameter("goodsId");
		Goods goods=goodsService.get(Integer.parseInt(gid));
		request.put("goods", goods);
		List<GoodsDetial> listItem=goodsDetialService.getListType(Integer.parseInt(gid));
 	    request.put("GDetialList", listItem);
 	    page=goodsStockService.queryAll(page,gid);
		return "stock";
	}
	
	public String AddStock()
	{
		String gid = ServletActionContext.getRequest().getParameter("goodsId");
		String goodstype = ServletActionContext.getRequest().getParameter("goodstype");
		String amount = ServletActionContext.getRequest().getParameter("amount");
		if(goodsStockService.queryCount(gid,goodstype))
		{
			Goods goods=goodsService.get(Integer.parseInt(gid));
			GoodsStock goodsStock=new GoodsStock();
			goodsStock.setGoodsId(Integer.parseInt(gid));
			goodsStock.setAmount(Integer.parseInt(amount));
			goodsStock.setGoodstype(goodstype);
			goods.setAmount(goodsStockService.queryStockAll(gid)+goodsStock.getAmount());
			//goodsStockService.add(goodsStock);
			//goodsService.update(goods);
			goodsStockService.addStock(goodsStock,goodsService,goods);
			jsonMap.put("data", "right");
		}
		else
		{
			jsonMap.put("data", "wrong");
			
		}
	    return "json";
	}
	
	public String updateStock()
	{
		String gstockid = ServletActionContext.getRequest().getParameter("gstockid");
		String amount = ServletActionContext.getRequest().getParameter("amount");
		GoodsStock goodsStock=goodsStockService.get(Integer.parseInt(gstockid));
		Goods goods=goodsService.get(goodsStock.getGoodsId());
		goods.setAmount(goodsStockService.queryStockAll(goodsStock.getGoodsId().toString()
				)-goodsStock.getAmount()+Integer.parseInt(amount));
		goodsStock.setAmount(Integer.parseInt(amount));
		goodsStockService.updateStock(goodsStock,goodsService,goods);
		//goodsStockService.update(goodsStock);
		//goodsService.update(goods);
		jsonMap.put("data", "right");
	    return "json";
	}
	
	public String deleteStock()
	{
		String gstockid = ServletActionContext.getRequest().getParameter("gstockid");
		GoodsStock goodsStock=goodsStockService.get(Integer.parseInt(gstockid));
		Goods goods=goodsService.get(goodsStock.getGoodsId());
		goodsStockService.deleteStock(goodsStock,goodsService,goods);
		//goodsStockService.delete(Integer.parseInt(gstockid));
		//goods.setAmount(goodsStockService.queryStockAll(goodsStock.getGoodsId().toString()));
		//goodsService.update(goods);
		jsonMap.put("data", "right");
	    return "json";
	}
	
	public String GetAmount()
	{
		return "json";
	}
}
