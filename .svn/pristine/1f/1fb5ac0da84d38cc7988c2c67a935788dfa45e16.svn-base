package cn.xaut.shop.phoneAction;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.Discount;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.Shop;

public class DiscountActionPhone extends BaseAction<Discount>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2241756734121505107L;
	private Map<String,Object> responseJson = new HashMap<String,Object>();
	public Map<String, Object> getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}
	public String add() {
		String productid = ServletActionContext.getRequest().getParameter("goodId");
		String shopid = ServletActionContext.getRequest().getParameter("shopId");
		String price = ServletActionContext.getRequest().getParameter("price");
		String startday = ServletActionContext.getRequest().getParameter("startday");
		String endday = ServletActionContext.getRequest().getParameter("endday");
		Shop shop = shopService.get(Integer.parseInt(shopid));
		request.put("shop", shop);
		Goods good = goodsService.get(Integer.parseInt(productid));
		model.setEndday(endday + " 00:00:00");
		model.setPrice(Double.parseDouble(price));
		model.setGoods(good);
		model.setShop(shop);
		model.setStartday(startday + " 00:00:00");
		model.setState("0");
		discountService.save(model);
		good.setDiscount(model);
	    goodsService.update(good);
	    responseJson.put("isResult", "false");
		return "jsonsuccess";
	}

	public String query()
	{
		Goods good = (Goods)session.get("goods");
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
		return "Discount";
	}
	
	public String update() {
		String productid = ServletActionContext.getRequest().getParameter("goodId");
		String discountid = ServletActionContext.getRequest().getParameter("discountid");
		String shopid = ServletActionContext.getRequest().getParameter("shopId");
		String price = ServletActionContext.getRequest().getParameter("price");
		String startday = ServletActionContext.getRequest().getParameter("startday");
		String endday = ServletActionContext.getRequest().getParameter("endday");
		Shop shop = shopService.get(Integer.parseInt(shopid));
		request.put("shop", shop);
		Discount discount=discountService.get(Integer.parseInt(discountid));
		discount.setStartday(startday + " 00:00:00");
		discount.setEndday(endday + " 00:00:00");
		discount.setPrice(Double.parseDouble(price));
		discountService.update(discount);
		Goods good = goodsService.get(Integer.parseInt(productid));
		 responseJson.put("isResult", "false");
			return "jsonsuccess";
	}

	public String delete() {
		String shopid = ServletActionContext.getRequest().getParameter("shopId");
		Shop shop = shopService.get(Integer.parseInt(shopid));
		request.put("shop", shop);
		String productid = ServletActionContext.getRequest().getParameter("goodId");
		Goods good = goodsService.get(Integer.parseInt(productid));
	    good.setDiscount(null);
	    goodsService.update(good);
		String discountid = ServletActionContext.getRequest().getParameter("discountid");
		discountService.delete(Integer.parseInt(discountid));
		session.put("dhshopid", shopid);
		return "jsonsuccess";
	}
}
