package cn.xaut.shop.phoneAction;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.MarginDetail;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.util.JSONUtils;
import cn.xaut.shop.util.Struts2Utils;

/*
 * 
 * 1.基本所有的Action都需要用到request session application 内置对象
 * 
 * 通过他们存数数据，交给前台页面显示，Struts提供了AOP+Ioc的方式，在运行的时候自动注入->实现几个接口就可以了
 * 
 * 2. 前台页面中所有的数据名称，必须要用[对象.属性]方式取值， 这样做耦合性太高，我们可以实现一个接口来解耦
 * 
 * */

public class ShopActionPhone extends BaseAction<Shop> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2788046788576336154L;
	Page<Goods> pagegoods=new Page<Goods>();
	private HttpServletRequest req = ServletActionContext.getRequest();

	
	private Integer userid;
 	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	private Map<String,Object> responseJson = new HashMap<String,Object>();
 	public Map<String, Object> getResponseJson() {
 		return responseJson;
 	}
 	public void setResponseJson(Map<String, Object> responseJson) {
 		this.responseJson = responseJson;
 	}
	
 	private String myshopid;
 
	public String getMyshopid() {
		return myshopid;
	}
	public void setMyshopid(String myshopid) {
		this.myshopid = myshopid;
	}
	
	private String mymoney;

	public String getMymoney() {
		return mymoney;
	}
	public void setMymoney(String mymoney) {
		this.mymoney = mymoney;
	}
	
	private String myremark;

	
	public String getMyremark() {
		return myremark;
	}
	public void setMyremark(String myremark) {
		this.myremark = myremark;
	}
	
	

	// 查看时查找记录
	public String searchMyViewList() {
		//UserInfo user = (UserInfo) session.get("userinfo");
		// userid = user.getUserinfoId();
		List<Shop> viewShopList = shopService.getMyViewList(userid, fromdate(), todate());
		if (viewShopList == null || viewShopList.size() == 0) {
			request.put("msg_viewShop", "无相应数据！");
		}
		boolean isFristPage = true;
		boolean isLastPage = true;
		
		responseJson.put("first", isFristPage);
		responseJson.put("next", isLastPage);
		responseJson.put("list", viewShopList);
		//request.put("viewShopList", viewShopList);// viewShopList查看店铺时候的记录
		//session.put("viewShopList", viewShopList);//查看保证金记录的时候跨越店铺和保证金记录表两个action
		return "viewShop";
	}

	// 保证金申请时查找记录
	public String searchMyShopList() {
		//searchMyViewList();
		//int userid = userid;
		//List<Shop> viewShopList = shopService.getMyViewList(userid, fromdate(), todate());
		List<Shop> viewShopList = shopService.getListByUserId(userid);
		responseJson.put("list", viewShopList);
		boolean isFristPage = true;
		boolean isLastPage = true;
		
		responseJson.put("first", isFristPage);
		responseJson.put("next", isLastPage);
		//return "submitMargin";
		return "myShopList";
	}

	// 审核通过，更新店铺表，添加保证金记录表  hx
	public String updateAndSave() {
		//int modelId = Integer.parseInt(req.getParameter("shopId"));
		//Shop model = shopService.get(modelId);
		Shop model = shopService.get(Integer.parseInt(myshopid));
		//int money = model.getMargin()
		//		+ Integer.parseInt(req.getParameter("money"));
		int money = model.getMargin() + Integer.parseInt(mymoney);
		model.setMargin(money);
		model.setMarginstate("1");
		shopService.update(model);// 更新店铺表

		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		MarginDetail modelMarginDetail = new MarginDetail();
		modelMarginDetail.setUserinfo(model.getUserinfo());
		modelMarginDetail.setUserTime(dateFormat.format(now));
		///Shop shop = new Shop();
		//shop.setShopId(model.getShopId());
		modelMarginDetail.setShop(model);
		
		//modelMarginDetail.setMoney(Integer.parseInt(req.getParameter("money")));
		//modelMarginDetail.setRemark(req.getParameter("remark"));
		modelMarginDetail.setMoney(Integer.parseInt(mymoney));
		modelMarginDetail.setRemark(myremark);

		marginDetailService.save(modelMarginDetail);// 添加保证金记录表
		responseJson.put("isResult", "true");
		return "viewMarginRedirect";
	}

	// 保证金查看时查找记录  hx
	public String searchMyShopMarginList() {
		//searchMyViewList();
		List<Shop> viewShopList = shopService.getListByUserId(userid);
		responseJson.put("list", viewShopList);
		boolean isFristPage = true;
		boolean isLastPage = true;
		
		responseJson.put("first", isFristPage);
		responseJson.put("next", isLastPage);
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

	public String list() throws IOException {
		String typekey = Struts2Utils.getParameter("typekey");
		String typekeyvalue = Struts2Utils.getParameter("typekeyvalue");
		if(typekey=="" && typekeyvalue==""){
		page = shopService.queryAll(page);
		if(page.getTotalItems()!=0)
		{ 
			responseJson.put("shops", page);
			boolean isFristPage = page.isFirstPage();
			boolean isLastPage = page.isLastPage();
			
			jsonMap.put("first", isFristPage);
			jsonMap.put("next", isLastPage);
//			String jsonList = JSONUtils.toJSONString(page);
//			Struts2Utils.renderString(jsonList);
		}else
		{
//			jsonMap.put("isResult", "false");
			Struts2Utils.renderTrue();
		 }	
		
					return "listorder";
		}else{
			page = shopService.getList(page,typekey,typekeyvalue);
			 if(page!=null&&page.getTotalItems()>0)
			 { 
				 responseJson.put("shops", page);
					boolean isFristPage = page.isFirstPage();
					boolean isLastPage = page.isLastPage();
					
					jsonMap.put("first", isFristPage);
					jsonMap.put("next", isLastPage);
//					String jsonList = JSONUtils.toJSONString(page);
//					Struts2Utils.renderString(jsonList);
				}else
				{
//					jsonMap.put("isResult", "false");
					Struts2Utils.renderTrue();
				 }	
			return "listorder";
		}
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
	
	public String updateStateShop() {
		int shopid =  Integer.parseInt(Struts2Utils.getParameter("shopid"));
		Shop shop = shopService.get(shopid);
		if (shop.getShopstate().equals("0")) {
			shop.setShopstate("1");
		} else {
			shop.setShopstate("0");
		}
		shopService.update(shop);
		return null;
	}

	public String deleteShop() {
		shopService.delete(model.getShopId());
		return "query";
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
	public String sdetial() throws IOException {
		String sid = Struts2Utils.getParameter("shopid");
		String key = Struts2Utils.getParameter("keyvalue");
//		String sid = "";
//		if(ServletActionContext.getRequest().getParameter("sid")!=null)
//		{
//			sid = ServletActionContext.getRequest().getParameter("sid");
//			String pageNo=ServletActionContext.getRequest().getParameter("page.pageNo");
//			String pageSize=ServletActionContext.getRequest().getParameter("page.pageSize");
//			//System.out.println("no-"+pageNo+"size-"+pageSize);
//			if(pageNo!=null&&pageSize!=null)
//			{
//				pagegoods.setPageNo(Integer.parseInt(pageNo));
//				pagegoods.setPageSize(Integer.parseInt(pageSize));
//			}
//		}
//		else
//		{
//			sid = session.get("shopid").toString();
//		}
//		Shop shop = shopService.get(Integer.parseInt(sid));
//		request.put("shop", shop);
		//System.out.println("no-"+pagegoods.getPageNo()+"size-"+pagegoods.getPageSize());
		if(key ==""){
		pagegoods= goodsService.getShop(pagegoods,Integer.parseInt(sid));
		if(pagegoods!=null&&pagegoods.getTotalItems()>0)
		{ 
			responseJson.put("shopgoods", pagegoods);
//			String jsonList = JSONUtils.toJSONString(pagegoods);
//			System.out.print(jsonList);
//			Struts2Utils.renderString(jsonList);
		}else
		{
			Struts2Utils.renderTrue();
		 }	
		
					return "listorder";
		}
	else{
		pagegoods= goodsService.getList(pagegoods,key,Integer.parseInt(sid));
		if(pagegoods!=null&&pagegoods.getTotalItems()>0)
		{
			responseJson.put("shopgoods", pagegoods);
		} else {
			Struts2Utils.renderTrue();
		}
		return "listorder";
		}
	}
//		if(pagegoods!=null&&pagegoods.getTotalItems()>0)
//		{
//			request.put("msg", "");
//		} else {
//			request.put("msg", "该店铺尚未添加商品");
//		}
//		request.put("page", pagegoods);
//		return "lists";
//	}

	// zz for shopGoods
	public String listG() {
		String key = req.getParameter("keyword");
		String sid = req.getParameter("shopId");
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
		String goodId = Struts2Utils.getParameter("goodid");
		String sid = Struts2Utils.getParameter("shopid");
//		Shop shop = shopService.get(Integer.parseInt(sid));
//		session.put("shopid",shop.getShopId());
//		request.put("shop", shop);
		Goods good = goodsService.get(Integer.parseInt(goodId));
		if (good.getState().equals("0")) {
			good.setState("1");
		}
		else
		{
			good.setState("0");
		}
		goodsService.update(good);
		return null;
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
}
