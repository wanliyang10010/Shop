package cn.xaut.shop.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.MarginDetail;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;

/*
 * 
 * 1.基本所有的Action都需要用到request session application 内置对象
 * 
 * 通过他们存数数据，交给前台页面显示，Struts提供了AOP+Ioc的方式，在运行的时候自动注入->实现几个接口就可以了
 * 
 * 2. 前台页面中所有的数据名称，必须要用[对象.属性]方式取值， 这样做耦合性太高，我们可以实现一个接口来解耦
 * 
 * */

public class ShopAction extends BaseAction<Shop> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2788046788576336154L;
	Page<Goods> pagegoods=new Page<Goods>();
	private HttpServletRequest req = ServletActionContext.getRequest();

	// 查看时查找记录
	public String searchMyViewList() {
		UserInfo user = (UserInfo) session.get("userinfo");
		int userid = user.getUserinfoId();
		List<Shop> viewShopList = shopService.getMyViewList(userid, "2015-01-01", "2115-01-01");
		if (viewShopList == null || viewShopList.size() == 0) {
			request.put("msg_viewShop", "无相应数据！");
		}
		request.put("viewShopList", viewShopList);// viewShopList查看店铺时候的记录
		return "viewShop";
	}

	// 保证金申请时查找记录
	public String searchMyShopList() {
		searchMyViewList();
		return "submitMargin";
	}

	// 支付成功，更新店铺表，添加保证金记录表
	public String updateAndSave() {
		int modelId = Integer.parseInt(req.getParameter("shopId"));
		Shop model = shopService.get(modelId);
		int money = model.getMargin()
				+ Integer.parseInt(req.getParameter("money"));
		model.setMargin(money);
		model.setMarginstate("1");
		//shopService.update(model);// 更新店铺表

		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		MarginDetail modelMarginDetail = new MarginDetail();
		modelMarginDetail.setUserinfo(model.getUserinfo());
		modelMarginDetail.setUserTime(dateFormat.format(now));
		modelMarginDetail.setShop(model);	
		modelMarginDetail.setMoney(Integer.parseInt(req.getParameter("money")));
		modelMarginDetail.setRemark(req.getParameter("remark"));
		//marginDetailService.save(modelMarginDetail);// 添加保证金记录表
		shopService.updateAndSave(model,modelMarginDetail);
		return "viewMarginRedirect";
	}

	// 保证金查看时查找记录
	public String searchMyShopMarginList() {	
		searchMyViewList();	
		return "viewMargin";
	}

	public String save() {
		shopService.save(model);
		return "queryShop";
	}

	public String get() {
		request.put("Shop", shopService.get(model.getShopId()));
		return "updateShop";
	}

	public String query() {
		// 查询的数据，如果能存到request中就不要存储在session中
		// 实现接口后，用request对象就替代上一句了
		request.put("Shops", shopService.query());
		return "queryShop";
	}

	public String list() {		
		page = shopService.findAll(page);
		//page.setResult(shopService.query());
		request.put("page", page);
		return "list";
	}

	public String delete() {
		// 删除指定数据
		shopService.delete(model.getShopId());
		// 删除完毕，查询剩余
		List<Shop> Shops = shopService.query();

		request.put("Shops", Shops);
		return "queryShop";
	}

	public String update() {
		shopService.update(model);
		return "queryShop";
	}
	// zz for shopState
	
	public String updateStateShop() 
	{
	    String shopId=ServletActionContext.getRequest().getParameter("shopId");
		Shop shop = shopService.get(Integer.parseInt(shopId));
		if (shop.getShopstate().equals("0")) {
			shop.setShopstate("1");
		} else {
			shop.setShopstate("0");
		}
		shopService.update(shop);
		jsonMap.put("data", "right");
		return "json";
	}

	public String deleteShop() {
		String shopId = req.getParameter("shopId");
		pagegoods= goodsService.getShop(pagegoods,Integer.parseInt(shopId));
		if(pagegoods!=null&&pagegoods.getTotalItems()>0)
		{
			jsonMap.put("data", "wrong");
		} else {
			shopService.delete(Integer.parseInt(shopId));
			jsonMap.put("data", "right");
		}
		return "json";
	}

	// zz for shopState
	public String listShop() {
		String stype = req.getParameter("stype");
		String key = req.getParameter("keyword");
		System.out.println(stype + key);
		System.out.println("listz");
		page = shopService.getList(page,stype, key);
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

	public String qury() {
		 page = shopService.queryAll(page);
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

	// zz for shopGoods
	public String sdetial() {
		String sid = "";
		if(ServletActionContext.getRequest().getParameter("sid")!=null)
		{
			sid = ServletActionContext.getRequest().getParameter("sid");
			String pageNo=ServletActionContext.getRequest().getParameter("page.pageNo");
			String pageSize=ServletActionContext.getRequest().getParameter("page.pageSize");
			//System.out.println("no-"+pageNo+"size-"+pageSize);
			if(pageNo!=null&&pageSize!=null)
			{
				pagegoods.setPageNo(Integer.parseInt(pageNo));
				pagegoods.setPageSize(Integer.parseInt(pageSize));
			}
		}
		else
		{
			sid = session.get("shopid").toString();
		}
		Shop shop = shopService.get(Integer.parseInt(sid));
		request.put("shop", shop);
		//System.out.println("no-"+pagegoods.getPageNo()+"size-"+pagegoods.getPageSize());
		pagegoods= goodsService.getShop(pagegoods,Integer.parseInt(sid));
		if(pagegoods!=null&&pagegoods.getTotalItems()>0)
		{
			request.put("msg", "");
		} else {
			request.put("msg", "该店铺尚未添加商品");
		}
		request.put("page", pagegoods);
		return "lists";
	}

	// zz for shopGoods
	public String listG() {
		String key = req.getParameter("keyword");
		String sid = req.getParameter("shopId");
		String pageNo=ServletActionContext.getRequest().getParameter("page.pageNo");
		String pageSize=ServletActionContext.getRequest().getParameter("page.pageSize");
		if(pageNo!=null&&pageSize!=null)
		{
			pagegoods.setPageNo(Integer.parseInt(pageNo));
			pagegoods.setPageSize(Integer.parseInt(pageSize));
		}
		Shop shop = shopService.get(Integer.parseInt(sid));
		request.put("shop", shop);
		pagegoods= goodsService.getList(pagegoods,key,Integer.parseInt(sid));
		if(pagegoods!=null&&pagegoods.getTotalItems()>0)
		{
			request.put("msg", "");
		} else {
			request.put("msg", "该店铺尚未添加商品");
		}
		 request.put("page", pagegoods);
		return "lists";
	}

	// zz for shopGoods
	public String updateG() {
		UserInfo userinfo = (UserInfo) session.get("userinfo");
		String goodId = req.getParameter("goodId");
		String sid = req.getParameter("shopId");
		Shop shop = shopService.get(Integer.parseInt(sid));
		session.put("shopid",shop.getShopId());
		request.put("shop", shop);
		Goods good = goodsService.get(Integer.parseInt(goodId));
		if (good.getState().equals("0")) {
			good.setState("2");
		}
		else
		{
			good.setState("0");
		}
		goodsService.updateGoods(good,messageService,userinfo,shop);
//		goodsService.update(good);
//		messageService.sendMessage(messageService,"您店铺的商品已被管理员下架，请点击查看！", userinfo.getUserinfoId(), shop.getUserinfo().getUserinfoId(),
//				"goodsAction_queryById.action", "shopId", shop.getShopId());
		jsonMap.put("data", "right");
		return "json";
	}
	public String fromdate(){
		String fromdate = req.getParameter("fromdate");
		if (fromdate == null || fromdate.equals("")) {
			fromdate = "2015-01-01";
		}
		return fromdate;
	}
	public String todate(){
		String todate = req.getParameter("todate");
		if (todate == null || todate.equals("")) {
			todate = "2115-01-01";
		}
		return todate;
	}
	
	//客服设置首页商品
		public String getGoods()
		{
			String shopId = ServletActionContext.getRequest().getParameter("shop");
			String key = ServletActionContext.getRequest().getParameter("keyword");
			System.out.println("shopId"+shopId);
			String pageNo=ServletActionContext.getRequest().getParameter("page.pageNo");
			String pageSize=ServletActionContext.getRequest().getParameter("page.pageSize");
			if(pageNo!=null&&pageSize!=null)
			{
				pagegoods.setPageNo(Integer.parseInt(pageNo));
				pagegoods.setPageSize(Integer.parseInt(pageSize));
			}
			if(shopId.equals("全部店铺"))
			{
				pagegoods = goodsService.getByShopKey(pagegoods, "0", key);
			}
			else
			{
				pagegoods = goodsService.getByShopKey(pagegoods, shopId, key);
			}
			//page = goodsService.getShop(page, Integer.parseInt(shopId));
			if (pagegoods != null && pagegoods.getTotalItems() > 0) {
				request.put("msg", "");
			} else {
				request.put("msg", "没有符合条件的记录，请重新查询");
			}
			request.put("page", pagegoods);
			List<Shop> list =shopService.getByState();
			request.put("ShopList", list);
			return "TopGoods";
		}
		
		public String getTopGoods()
		{
			String pageNo=ServletActionContext.getRequest().getParameter("page.pageNo");
			String pageSize=ServletActionContext.getRequest().getParameter("page.pageSize");
			if(pageNo!=null&&pageSize!=null)
			{
				pagegoods.setPageNo(Integer.parseInt(pageNo));
				pagegoods.setPageSize(Integer.parseInt(pageSize));
			}
			pagegoods = goodsService.getByState(pagegoods);
			if (pagegoods != null && pagegoods.getTotalItems() > 0) {
				request.put("msg", "");
			} else {
				request.put("msg", "没有符合条件的记录，请重新查询");
			}
			request.put("page", pagegoods);
			List<Shop> list =shopService.getByState();
			request.put("ShopList", list);
			return "TopGoods";
		}
		
		public String setTopGoods()
		{
			String goodsId = ServletActionContext.getRequest().getParameter("goodsId");
			String state = ServletActionContext.getRequest().getParameter("state");
			pagegoods.setPageSize(6);
	    	pagegoods= goodsService.getTop(pagegoods);
	    	if(state.equals("3"))
	    	{
	    	   if (pagegoods != null && pagegoods.getTotalItems()==6) {
		    		jsonMap.put("data", "wrong");
				} else {
					Goods  goods=goodsService.get(Integer.parseInt(goodsId));
					goods.setState(state);
					goodsService.update(goods);
					jsonMap.put("data", "right");
				}
	    	}
	    	else
	    	{
	    		Goods  goods=goodsService.get(Integer.parseInt(goodsId));
				goods.setState(state);
				goodsService.update(goods);
				jsonMap.put("data", "right");
	    	}
		    return "json";
		}
}
