package cn.xaut.shop.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
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
@SuppressWarnings("unchecked")
public class MarginDetailAction extends BaseAction<MarginDetail> {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest req = ServletActionContext.getRequest();

	public String queryByShopid() {
		UserInfo user = (UserInfo) session.get("userinfo");
		int userid = user.getUserinfoId();
		List<Shop> viewShopList = shopService.getMyViewList(userid, "2015-01-01", "2115-01-01");
		if (viewShopList == null || viewShopList.size() == 0) {
			request.put("msg_viewShop", "无相应数据！");
		}
		int id=viewShopList.get(0).getShopId();
		page = marginDetailService.getByShopid(page,id);
		if (page == null || page.getTotalItems() == 0) {			
			request.put("msg_viewMargin", "没有该店铺的保证金记录！");
		}
		request.put("viewShopList", viewShopList);//查看保证金记录的时候跨越店铺和保证金记录表两个action
		request.put("page",page);// viewShopProgressList得到店铺审核进展记录
		return "viewMargin";
	}

	// zz for marginpunish
	public String submargin() {
		UserInfo userinfo = (UserInfo) session.get("userinfo");
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		int shopid = Integer.parseInt(req.getParameter("shopId"));// ywl
		Shop shop = shopService.get(shopid);// ywl
		if(shop.getMargin() - model.getMoney()>0)
		{
			shop.setMargin(shop.getMargin() - model.getMoney());
		}
		else
		{
			shop.setMargin(0);
			shop.setMarginstate("0");
		}
		
		model.setUserTime(dateFormat.format(now).replace("/", "-"));
		model.setMoney(-model.getMoney());
		model.setUserinfo((UserInfo) session.get("userinfo"));// ywl
		model.setShop(shop);
		marginDetailService.savePunish(model,shopService,shop,messageService,userinfo);
//		marginDetailService.save(model);//ywl新增加	
//		shopService.update(shop);
//		messageService.sendMessage(messageService,"您的店铺由于违规操作受到处罚，请查看！", userinfo.getUserinfoId(),shop.getUserinfo().getUserinfoId(),
//					"marginDetailAction_queryByShopid.action", "shopId", shopid);
		session.put("shopIdV", shopid);// ywl
		return "subMargin";
	}

	public String viewDeital() {
		int shopid;
		if (req.getParameter("shopId") != null) {
			shopid = Integer.parseInt(req.getParameter("shopId"));
		} else {
			shopid = Integer.parseInt(session.get("shopIdV").toString());
		}
		Shop shop = shopService.get(shopid);
		request.put("shop", shop);
		page = marginDetailService.getByShopid(page,shopid);
	    if (page!= null&&page.getTotalItems()>0) {			
		   request.put("msg", "");
		} 
	    else
	    {
	    	request.put("msg", "没有该店铺的保证金记录！");
	    }
		request.put("page", page);// CheckShopList
		return "MarginDetial";
	}

	public String marginsub() {
		int shopid = Integer.parseInt(req.getParameter("shopId"));
		Shop shop = shopService.get(shopid);
		request.put("shop", shop);
		return "Marginsub";
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
