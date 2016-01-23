package cn.xaut.shop.phoneAction;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.MarginDetail;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;
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
@SuppressWarnings("unchecked")
public class MarginDetailActionPhone extends BaseAction<MarginDetail> {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest req = ServletActionContext.getRequest();
	private String userinfoId;
	private String myshopId;
	

	public String getUserinfoId() {
		return userinfoId;
	}
	public void setUserinfoId(String userinfoId) {
		this.userinfoId = userinfoId;
	}
	
	public String getMyshopId() {
		return myshopId;
	}

	public void setMyshopId(String myshopId) {
		this.myshopId = myshopId;
	}

	/**/
	private Map<String,Object> responseJson = new HashMap<String,Object>();	
	public Map<String, Object> getResponseJson() {
		return responseJson;
	}
	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}

	public String queryByShopid() {

		//int shopid = Integer.parseInt(req.getParameter("shopId"));
		//List<MarginDetail> marginDetailList = marginDetailService.getListByShopid(shopid);
		List<MarginDetail> marginDetailList = marginDetailService.getListByShopid(Integer.parseInt(myshopId));
		if (marginDetailList == null || marginDetailList.size() == 0) {
			//request.put("msg_viewMargin", "没有该店铺的保证金记录！");
			responseJson.put("msg_viewMargin", "没有该店铺的保证金记录！");
			responseJson.put("marginDetailList", marginDetailList);
			
		}else{
			responseJson.put("marginDetailList", marginDetailList);
		}
		boolean isFristPage = true;
		boolean isLastPage = true;
		
		responseJson.put("first", isFristPage);
		responseJson.put("next", isLastPage);
		//List<Shop> listShop = (List<Shop>) session.get("viewShopList");
		//request.put("viewShopList", listShop);//查看保证金记录的时候跨越店铺和保证金记录表两个action
		//request.put("marginDetailList", marginDetailList);// marginDetailList保证金记录
		
		//return "viewMargin";//改为下面语句
		return "marginDetailForShop";//得到自己店铺的保证金页面，实现ajax局部刷新
	}

//	public String save() {
//		marginDetailService.save(model);
//		return "queryMarginDetail";
//	}
//
//	public String get() {
//		request.put("MarginDetail",
//				marginDetailService.get(model.getMarginDetailId()));
//		return "updateMarginDetail";
//	}

//	public String query() {
//		// 查询的数据，如果能存到request中就不要存储在session中
//		// 实现接口后，用request对象就替代上一句了
//		request.put("MarginDetails", marginDetailService.query());
//		return "queryMarginDetail";
//	}

//	public String delete() {
//		// 删除指定数据
//		marginDetailService.delete(model.getMarginDetailId());
//		// 删除完毕，查询剩余
//		List<MarginDetail> MarginDetails = marginDetailService.query();
//
//		request.put("MarginDetails", MarginDetails);
//		return "queryMarginDetail";
//	}

//	public String update() {
//		marginDetailService.update(model);
//		return "queryMarginDetail";
//	}

	// zz for marginpunish
	public String submargin() {
	//	UserInfo userinfo = (UserInfo) session.get("userinfo");
		
		
	
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		int shopid = Integer.parseInt(req.getParameter("shopId"));// ywl
		Shop shop = shopService.get(shopid);// ywl
		shop.setMargin(shop.getMargin() - model.getMoney());
		UserInfo userinfo=userInfoService.getAdmin(shop.getUserinfo().getUserinfoId());
		//System.out.println(userinfo.getUserinfoId()+userinfo.getUsername());
		model.setUserTime(dateFormat.format(now).replace("/", "-"));
		model.setMoney(-model.getMoney());
	    model.setUserinfo(userinfo);// ywl
		model.setShop(shop);
			marginDetailService.save(model);//ywl新增加
			shopService.update(shop);
//		messageService.sendMessage(messageService,"您的店铺由于违规操作受到处罚，请查看！", userinfo.getUserinfoId(),shop.getUserinfo().getUserinfoId(),
//					"marginDetailAction_queryByShopid.action", "shopId", shopid);
		session.put("shopIdV", shopid);// ywl
		return "subMargin";
	}

	public String viewDeital() throws Exception {
		int shopid;
		if (req.getParameter("shopId") != null) {
			shopid = Integer.parseInt(req.getParameter("shopId"));
		} else {
			shopid = Integer.parseInt(session.get("shopIdV").toString());
		}
		Shop shop = shopService.get(shopid);
		
		page = marginDetailService.getByShopid(page,shopid);
	    if (page!= null&&page.getTotalItems()>0) {	
	    	boolean isFristPage = page.isFirstPage();
			boolean isLastPage = page.isLastPage();
			
			responseJson.put("first", isFristPage);
			responseJson.put("next", isLastPage);
	    	 responseJson.put("LIST", page.getResult());// CheckShopList
		} 
	    else
	    {
	    	 responseJson.put("isResult", "false");
	    }
	   
	    responseJson.put("shop", shop);
		return "viewDeital";
	}

	public String marginsub() {
		int shopid = Integer.parseInt(req.getParameter("shopId"));
		Shop shop = shopService.get(shopid);
		request.put("shop", shop);
		return "Marginsub";
	}
	
	public String returnshopnameAndmargin() throws Exception{
		//int shopid = Integer.parseInt(Struts2Utils.getParameter("shopId"));
		
		int shopid = Integer.parseInt(req.getParameter("shopId"));
		//int shopid =123;
		Shop shop = shopService.get(shopid);
		responseJson.put("shop", shop);
  		//responseJson.put("shopname", shop.getShopname());
  		//responseJson.put("margin", shop.getMargin());
  		return "returnshopnameAndmargin";
  		
  	}
}
