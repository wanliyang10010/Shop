package cn.xaut.shop.phoneAction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.Discount;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.ShopApply;
import cn.xaut.shop.service.ShopService;
/*
 * 
 * 1.基本所有的Action都需要用到request session application 内置对象
 * 
 * 通过他们存数数据，交给前台页面显示，Struts提供了AOP+Ioc的方式，在运行的时候自动注入->实现几个接口就可以了
 * 
 * 2. 前台页面中所有的数据名称，必须要用[对象.属性]方式取值， 这样做耦合性太高，我们可以实现一个接口来解耦
 * 
 * */
import cn.xaut.shop.util.Struts2Utils;


@SuppressWarnings("serial")
public class GoodsActionPhone extends BaseAction<Goods> {
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");
	@Autowired
	private ShopService shopservice;
	
	private String myUserId;
	private String myShopId;
	private String mygoodsid;
	
	
	
	
	public String getMygoodsid() {
		return mygoodsid;
	}
	public void setMygoodsid(String mygoodsid) {
		this.mygoodsid = mygoodsid;
	}
	public String getMyShopId() {
		return myShopId;
	}
	public void setMyShopId(String myShopId) {
		this.myShopId = myShopId;
	}
	public String getMyUserId() {
		return myUserId;
	}
	public void setMyUserId(String myUserId) {
		this.myUserId = myUserId;
	}

	private Map<String,Object> responseJson = new HashMap<String,Object>();
 	public Map<String, Object> getResponseJson() {
 		return responseJson;
 	}
 	public void setResponseJson(Map<String, Object> responseJson) {
 		this.responseJson = responseJson;
 	}

	//添加商品  hx
	public String Add()
	{
		//Shop shop =(Shop)session.get("shop");
		Shop shop = shopservice.checkShopidByUserId(Integer.parseInt(myUserId));
		model.setShop(shop);
		model.setInfodate(dateFormat.format(now));
		model.setDiscount(null);
		model.setGoodsPicture(null);
		model.setHot("0");
		model.setPoint("0");
		model.setSamount(0);
		model.setState("0");
		goodsService.save(model);
		//session.put("goodsAdd",model);
		responseJson.put("isResult", "true");
		return  "addGoods";
	} 
	
	public String ViewGoods()
	{
		return  "viewGoods";
	}

/*
 * wangchao
 */
	public String queryList(){
	//	Shop shop =(Shop)session.get("shop");
		String shopId=Struts2Utils.getParameter("shopId");
		page= goodsService.getShop(page,Integer.parseInt(shopId));
		if(page.getTotalItems()!=0)
		{
			responseJson.put("LIST", page.getResult());
			boolean isFristPage = page.isFirstPage();
			boolean isLastPage = page.isLastPage();
			
			responseJson.put("first", isFristPage);
			responseJson.put("next", isLastPage);
		}else
		{		
			responseJson.put("isResult", "false");
		}		
		return "list";
	}
	
	//商品管理的商品查询 hx
	/*
	 * 参数：shopId
	 * */
	
	public String query() {
		page= goodsService.getShop(page,Integer.parseInt(myShopId));
		Shop shop = new Shop();
		shop = shopservice.findById(Integer.parseInt(myShopId));
		boolean isFristPage = true;
		boolean isLastPage = true;
		List<Goods> goodsList = new ArrayList<Goods>();
		if(page!=null&&page.getTotalItems()>0)
		{
			//request.put("msg", "");
			isFristPage = page.isFirstPage();
			isLastPage = page.isLastPage();
			goodsList = page.getResult();
		} else {
			//request.put("msg", "店铺尚未添加商品");
			
		}
		//request.put("page", page);
		responseJson.put("first", isFristPage);
		responseJson.put("next", isLastPage);
		responseJson.put("list", goodsList);
		responseJson.put("shop", shop);
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
	
	//更改状态 hx
	public String updateGoods() {
		
		//String goodId = ServletActionContext.getRequest().getParameter("goodId");
		Goods good = goodsService.get(Integer.parseInt(mygoodsid));
		if (good.getState().equals("0")) {
			good.setState("1");
		}
		else
		{
			good.setState("0");
		}
		goodsService.update(good);
		responseJson.put("isResult", "true");
		return "queryGoods";
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
			request.put("msg", "该店铺尚未添加商品");
		}
		 request.put("page", page);
		return "listview";
	}
	//更改是否热卖 hx
	public String updateH() {
		//String goodId = ServletActionContext.getRequest()
		//		.getParameter("goodId");
		//String sid = ServletActionContext.getRequest().getParameter("shopId");
		//Shop shop = shopService.get(Integer.parseInt(sid));
		//session.put("dhshopid",shop.getShopId());
		//request.put("shop", shop);
		Goods good = goodsService.get(Integer.parseInt(mygoodsid));
		if (good.getHot().equals("0")) {
			good.setHot("1");
		} else {
			good.setHot("0");
		}
		goodsService.update(good);
		responseJson.put("isResult", "true");
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
	//更新商品  hx
	public String update()
	{
		//String goodsid = ServletActionContext.getRequest().getParameter("goodsid");
		//String goodsname = ServletActionContext.getRequest().getParameter("goodsname");
		//String price= ServletActionContext.getRequest().getParameter("price");
		//String freight= ServletActionContext.getRequest().getParameter("freight");
		//String amount = ServletActionContext.getRequest().getParameter("amount");
		
		Goods  goods=goodsService.get(model.getGoodsid());
		goods.setGoodsname(model.getGoodsname());
		goods.setPrice(model.getPrice());
		goods.setFreight(model.getFreight());
		goods.setAmount(model.getAmount());
		goodsService.update(goods);
		//jsonMap.put("data", "right");
		responseJson.put("isResult", "true");
		return "json";
	}
	
	
	public String querySale()
	{
		//Shop shop =(Shop)session.get("shop");
		String shopid = ServletActionContext.getRequest().getParameter("shopId");
		List<Goods> list=goodsService.getGoodsMoeny(Integer.parseInt(shopid), "");
        if(list!=null&&list.size()>0)
        {
        	for(int i=0;i<list.size();i++)
        	{
        		Goods goods=list.get(i);
        		goods.setPrice(orderSonService.getByGoodsId(goods.getGoodsid()));
        	}
        }
        double totalmoney=goodsService.getTotal(list);
//		request.put("totalmoney",totalmoney);
//		request.put("GoodsList",list);
		
		if(list!=null&&list.size()>0)
		{
			responseJson.put("LIST",list);
			responseJson.put("totalmoney",totalmoney);
		}else
		{		
			responseJson.put("isResult", "false");
		}		
		
		return "list";
	}
	
	public String searchGoods()
	{
		String key= ServletActionContext.getRequest().getParameter("keyword");
		String shopId = ServletActionContext.getRequest().getParameter("shopId");
		List<Goods> list=goodsService.getGoodsMoeny(Integer.parseInt(shopId), key);
        if(list!=null&&list.size()>0)
        {
        	for(int i=0;i<list.size();i++)
        	{
        		Goods goods=list.get(i);
        		goods.setPrice(orderSonService.getByGoodsId(goods.getGoodsid()));
        	}
        }
        double totalmoney=goodsService.getTotal(list);
		request.put("totalmoney",totalmoney);
		request.put("GoodsList",list);
		return "SaleGoods";
	}
}
