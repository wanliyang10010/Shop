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
import cn.xaut.shop.pojo.GoodsType;
import cn.xaut.shop.pojo.OrderSon;
import cn.xaut.shop.pojo.Page;
import cn.xaut.shop.pojo.SaleGoods;
import cn.xaut.shop.pojo.Shop;
/*
 * 
 * 1.基本所有的Action都需要用到request session application 内置对象
 * 
 * 通过他们存数数据，交给前台页面显示，Struts提供了AOP+Ioc的方式，在运行的时候自动注入->实现几个接口就可以了
 * 
 * 2. 前台页面中所有的数据名称，必须要用[对象.属性]方式取值， 这样做耦合性太高，我们可以实现一个接口来解耦
 * 
 * */
import cn.xaut.shop.util.NumberFormat;


@SuppressWarnings("serial")
public class GoodsAction extends BaseAction<Goods> {
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");
	public String Add()
	{
		String Smark = ServletActionContext.getRequest().getParameter("Smark");
		Shop shop =(Shop)session.get("shop");
		model.setShop(shop);
		model.setInfodate(dateFormat.format(now));
		model.setDiscount(null);
		model.setGoodsPicture(null);
		model.setHot("0");
		model.setPoint("0");
		model.setSamount(0);
		model.setState("0");
		if(Smark.equals("1"))
		{
			model.setShand("1");//标记为二手
			model.setState("5");//标记为在售二手商品
		}
		goodsService.save(model);
		session.put("goodsAdd",model);
		return  "addGoods";
	} 
	
	public String ViewGoods()
	{
		return  "viewGoods";
	}
	
	public String query() {
		Shop shop =(Shop)session.get("shop");
		page= goodsService.getShop(page,shop.getShopId());
		if(page!=null&&page.getTotalItems()>0)
		{
			request.put("msg", "");
		} else {
			request.put("msg", "店铺尚未添加商品");
		}
		request.put("page", page);
		return "list";
	}
	
	public String queryById() {
		String sid = ServletActionContext.getRequest().getParameter("shopId");
		page= goodsService.getShop(page,Integer.parseInt(sid));
		if(page!=null&&page.getTotalItems()>0)
		{
			request.put("msg", "");
		} else {
			request.put("msg", "店铺尚未添加商品");
		}
		request.put("page", page);
		return "list";
	}
	
	public String listGoods() {
		String key = ServletActionContext.getRequest().getParameter("keyword");
		String sid = ServletActionContext.getRequest().getParameter("shopId");
		Shop shop = shopService.get(Integer.parseInt(sid));
		request.put("shop", shop);
		page= goodsService.getList(page,key,Integer.parseInt(sid));
		if(page!=null&&page.getTotalItems()>0)
		{
			request.put("msg", "");
		} else {
			request.put("msg", "未找到符合条件的商品请重新查询");
		}
		 request.put("page", page);
		return "list";
	}
	
	public String listDH() {
		String key = ServletActionContext.getRequest().getParameter("keyword");
		String stype= ServletActionContext.getRequest().getParameter("stype");
		String sid = ServletActionContext.getRequest().getParameter("shopId");
		Shop shop = shopService.get(Integer.parseInt(sid));
		request.put("shop", shop);
		page= goodsService.getListDH(page,key,stype,Integer.parseInt(sid));
		if(page!=null&&page.getTotalItems()>0)
		  {
			request.put("msg", "");
		} else {
			request.put("msg", "该店铺尚未添加商品");
		}
		request.put("page", page);
		return "listview";
	}
	
	public String updateGoods() {
		String goodId = ServletActionContext.getRequest().getParameter("goodId");
		Goods good = goodsService.get(Integer.parseInt(goodId));
		if (good.getState().equals("1")) {
			if(good.getShand()!=null&&good.getShand().equals("1"))
			{
				good.setState("5");
			}
			else
			{
				good.setState("0");
			}
		}
		else
		{
			good.setState("1");
		}
		goodsService.update(good);
		jsonMap.put("data", "right");
		return "json";
	}
	
	public String sdetialDH() {
		String sid = "";
		if(ServletActionContext.getRequest().getParameter("sid")!=null)
		{
			sid = ServletActionContext.getRequest().getParameter("sid");
		}
		else
		{
			sid = session.get("dhshopid").toString();
		}
		Shop shop = shopService.get(Integer.parseInt(sid));
		request.put("shop", shop);
		page= goodsService.getShop(page,Integer.parseInt(sid));
		if(page!=null&&page.getTotalItems()>0)
		{
			request.put("msg", "");
		} else {
			request.put("msg", "该店铺尚未添加商品或没有找到符合要求的商品项");
		}
		 request.put("page", page);
		return "listview";
	}
	
	public String updateH() {
		String goodId = ServletActionContext.getRequest()
				.getParameter("goodId");
		String sid = ServletActionContext.getRequest().getParameter("shopId");
		Shop shop = shopService.get(Integer.parseInt(sid));
		session.put("dhshopid",shop.getShopId());
		request.put("shop", shop);
		Goods good = goodsService.get(Integer.parseInt(goodId));
		if (good.getHot().equals("0")) {
			good.setHot("1");
		} else {
			good.setHot("0");
		}
		goodsService.update(good);
		return "listdh";
	}
	public String updateD() {
		String goodId = ServletActionContext.getRequest()
				.getParameter("goodId");
		String sid = ServletActionContext.getRequest().getParameter("shopId");
		Shop shop = shopService.get(Integer.parseInt(sid));
		session.put("dhshopid",shop.getShopId());
		request.put("shop", shop);
		Goods good = goodsService.get(Integer.parseInt(goodId));
		if (good.getDiscount()!=null) {
			Discount dis = discountService.getModel(Integer.parseInt(goodId));
			dis.setState("1");
			discountService.update(dis);
		}
		goodsService.update(good);
		return "listdh";
	}

	public String AddDis() {
		String goodId = ServletActionContext.getRequest().getParameter("gid");
		Goods good = goodsService.get(Integer.parseInt(goodId));
		Discount dis = good.getDiscount();
		if(dis!=null&&dis.getDiscountId()>0)
		{
			String end=dis.getEndday();
			String start=dis.getStartday();
			dis.setEndday(end.substring(0, 10));
			dis.setStartday(start.substring(0, 10));
		}
		request.put("discount", dis);
		request.put("good", good);
		return "listd";
	}

	
	
	public String update()
	{
		String goodsid = ServletActionContext.getRequest().getParameter("goodsid");
		String goodsname = ServletActionContext.getRequest().getParameter("goodsname");
		String price= ServletActionContext.getRequest().getParameter("price");
		String freight= ServletActionContext.getRequest().getParameter("freight");
		String amount = ServletActionContext.getRequest().getParameter("amount");
		Goods  goods=goodsService.get(Integer.parseInt(goodsid));
		goods.setGoodsname(goodsname);
		goods.setPrice(Double.parseDouble(price));
		goods.setFreight(Double.parseDouble(freight));
		goods.setAmount(Integer.parseInt(amount));
		if(goods.getDiscount()!=null&&goods.getDiscount().getDiscountId()>0)
		{
			if(goods.getDiscount().getPrice()>=Float.parseFloat(price))
			{
				jsonMap.put("data", "wrong");
			}
			else
			{
				goodsService.update(goods);
				jsonMap.put("data", "right");
			}
		}
		else
		{
			goodsService.update(goods);
			jsonMap.put("data", "right");
		}
		return "json";
	}
	
	public String deleteGoods()
	{
		String goodsid = ServletActionContext.getRequest().getParameter("goodsid");
		if(orderSonService.getByGoodsIdAll(goodsid)>0)
		{
			jsonMap.put("data", "wrong");
		}
		else
		{
			Goods goods=goodsService.get(Integer.parseInt(goodsid));
			goods.setState("4");
			goodsService.update(goods);
			jsonMap.put("data", "right");
		}
		return "json";
	}
	
	public String checkStock()
	{
		String goodsid = ServletActionContext.getRequest().getParameter("goodsid");
		List<GoodsStock> listItem=goodsStockService.getList(Integer.parseInt(goodsid));
		if(listItem!=null&&listItem.size()>0)
		{
			jsonMap.put("data", "right");
		}
		else
		{
			jsonMap.put("data", "wrong");
		}
		return "json";
	}
	
	public String querySale()
	{
		Shop shop =(Shop)session.get("shop");
		List<Goods> list=goodsService.getGoodsMoeny(shop.getShopId(), "");
		List<GoodsType> listType=goodsTypeService.getListByShopId(shop.getShopId());
		session.put("goodstypeList", listType);
		List<SaleGoods> listSale=new ArrayList<SaleGoods>();
		 if(list!=null&&list.size()>0)
	        {
	        	Goods goods=new Goods();
	        	for(int i=0;i<list.size();i++)
	        	{
	        		SaleGoods saleGoods=new SaleGoods();
	        		goods=list.get(i);
	        		saleGoods.setGoodsname(goods.getGoodsname());
	        		saleGoods.setSamount(goods.getSamount());
	        		String result=orderSonService.getByGoodsId(goods.getGoodsid());
	        		String[] index=result.split(",");
	        		saleGoods.setPrice(NumberFormat.Fix2(Double.parseDouble(index[0])));
	        		saleGoods.setAmount(goods.getAmount());
	        		saleGoods.setPoint(index[1]);
	        		listSale.add(saleGoods);
	        	}
	        }
		 else
		 {
			 request.put("msg", "未查询到符合要求的数据，请重新查询");
		 }
	        double totalmoney=getTotal(listSale);
			request.put("totalmoney",totalmoney);
			request.put("GoodsList",listSale);
			return "SaleGoods";
	}
	
	public String searchGoods()
	{
		String key= ServletActionContext.getRequest().getParameter("keyword");
		String shopId = ServletActionContext.getRequest().getParameter("shopId");
		String typeid = ServletActionContext.getRequest().getParameter("typeid");
		List<SaleGoods> listSale=new ArrayList<SaleGoods>();
		List<Goods> list=new ArrayList<Goods>();
		if(typeid.equals("0"))
		{
			list=goodsService.getGoodsMoeny(Integer.parseInt(shopId), key);
		} 
		else
		{
			list=goodsService.getGoodsTypeMoeny(Integer.parseInt(shopId), typeid,key);
		}
        if(list!=null&&list.size()>0)
        {
        	Goods goods=new Goods();
        	for(int i=0;i<list.size();i++)
        	{
        		SaleGoods saleGoods=new SaleGoods();
        		goods=list.get(i);
        		saleGoods.setGoodsname(goods.getGoodsname());
        		saleGoods.setSamount(goods.getSamount());
        		String result=orderSonService.getByGoodsId(goods.getGoodsid());
        		String[] index=result.split(",");
        		saleGoods.setPrice(NumberFormat.Fix2(Double.parseDouble(index[0])));
        		saleGoods.setAmount(goods.getAmount());
        		saleGoods.setPoint(index[1]);
        		listSale.add(saleGoods);
        	}
        }
        else
		 {
			 request.put("msg", "未查询到符合要求的数据，请重新查询");
		 }
        double totalmoney=getTotal(listSale);
		request.put("totalmoney",totalmoney);
		request.put("GoodsList",listSale);
		return "SaleGoods";
	}
	
	public double getTotal(List<SaleGoods> list) {
		double totalmoney=0;
		if(list!=null&&list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				SaleGoods saleGoods=list.get(i);
				totalmoney=totalmoney+saleGoods.getPrice();
			}
		}
		return totalmoney;
	}

	
}
