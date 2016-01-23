package cn.xaut.shop.phoneAction;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.exception.CartException;
import cn.xaut.shop.exception.OrderException;
import cn.xaut.shop.pojo.Cart;
import cn.xaut.shop.pojo.DeliverAddr;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.OrderSon;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.util.NumberFormat;
import cn.xaut.shop.util.Struts2Utils;

@SuppressWarnings("unchecked")
public class OrderActionPhone extends BaseAction<Order> {

	private static final long serialVersionUID = 1L;
	HttpServletRequest req = (HttpServletRequest) request;
	
	// 保存勾选的购物项
	private String[] chkItem;
	// getter()、setter() 方法一定要有
	public String[] getChkItem() {
		return chkItem;
	}
	public void setChkItem(String[] chkItem) {
		this.chkItem = chkItem;
	}

	
	//从购物车结算
	/**
	 * 从购物车结算，确认订单 
	 * @return
	 * @throws CartException 
	 */
	public String comfirmOrders() throws CartException {

		//List<Cart> cartlist = (List<Cart>) session.get("cartlist");
		String sgoodsIdstr=ServletActionContext.getRequest().getParameter("sgoodsIdstr");
		String[] sgoodsstr=sgoodsIdstr.split(",");
		String userid=ServletActionContext.getRequest().getParameter("userid");
	     UserInfo userinfo=userInfoService.findById(Integer.parseInt(userid));
	     List<Cart> cartlist=null;
	     if(userinfo != null)
		  {
			  //用户已经登录，那么按用户Id查询
			   cartlist = cartService.loadCartsByUserId(userinfo.getUserinfoId());
		  }
		List<Order> orders = cartService.getOrderList(cartlist,sgoodsstr);
		// 原则： 能放进request中的不要放在session中
		// request.put("orders", orders);
		  if(orders!=null)
			{
				jsonMap.put("LIST", orders);
//				Set<OrderSon> orderson=orders.get(0).getSons();
//				int ae=orderson.size();
//				OrderSon[] o=(OrderSon[])orderson.toArray();
//				int a=o[0].getAmount();
								
			}else
			{		
				jsonMap.put("isResult", "false");
			}
		return "haveBuyGoods";
	}
	
	
	/**
	 * 保存一组订单
	 * @throws CartException 
	 */
	public String saveOrders() throws CartException {

		
		//选择的收货地址
		String user_id = Struts2Utils.getParameter("user_id");
		String addrid = Struts2Utils.getParameter("addrid");
		String sgoodsIdstr=ServletActionContext.getRequest().getParameter("sgoodsIdstr");
		//String shopid = Struts2Utils.getParameter("shopid");
		//String shopname = Struts2Utils.getParameter("shopname");
		//String goodsid = Struts2Utils.getParameter("goodsid");
		//String goodsname = Struts2Utils.getParameter("goodsname");
		//String price = Struts2Utils.getParameter("price");
		//String amount = Struts2Utils.getParameter("amount");//购买数量
		
		
		
		String[] sgoodsstr=sgoodsIdstr.split(",");
		
		DeliverAddr addr = deliverAddrService.get(Integer.parseInt(addrid));
				
		UserInfo user = userInfoService.getAdmin(Integer.parseInt(user_id));

	    List<Cart> cartlist = cartService.loadCartsByUserId(user.getUserinfoId());
	    List<Order> orderlist = cartService.getOrderList(cartlist,sgoodsstr);
	    //保存订单
	    try {
			orderService.saveOrderList(ServletActionContext.getRequest(),orderlist, user,addr);
		} catch (OrderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // 删除购物项 - 移除购物车
		cartlist = cartItemService.removeItemCosByOrder(cartlist,orderlist);
		
		// 重新计算总价
		cartService.calcTotalAll(cartlist);
		// 更新购物车数据库
		cartService.saveOrUpdatebyList(cartlist);
	
		jsonMap.put("isResult", "true");
		
		return "saveOrders";
	}
	
	
	/**
	 * 创建立即购买订单.(只有一个订单项 <--- "立即购买")
	 * @return
	 */
	public String buyNow() {
		
		//获得form提交的参数
		HttpServletRequest  req =  ServletActionContext.getRequest();
		String shopid = req.getParameter("shopid");
		String shopname = req.getParameter("shopname");
		String goodsid = req.getParameter("goodsid");
		String goodsname = req.getParameter("goodsname");
		String price = req.getParameter("price");
		String amount = req.getParameter("num");//购买数量
		String remark = req.getParameter("remark");//备注信息
		String freight = req.getParameter("freight");//运费
		String discount = req.getParameter("discount");//促销价
		
		//计算
		int Amount = Integer.parseInt(amount);
		double Price = 0.0f;
		if(discount != null && discount.length() > 0){
			Price = Double.parseDouble(discount);
		}
		else{
			Price = Double.parseDouble(price);
		}
		
		//保留2位小数
		double total = NumberFormat.Fix2(Price * Amount);
		//店铺 
		Shop shop = new Shop();
		shop.setShopId(Integer.parseInt(shopid));
		shop.setShopname(shopname);
		//商品
		Goods good = goodsService.get(Integer.parseInt(goodsid));
		
		UserInfo user = (UserInfo) session.get("userinfo");

		//订单
		double dFreight = 0.0f;//设置运费
		try{
			dFreight = Double.parseDouble(freight);
		}catch(Exception e){
			throw new RuntimeException("类型转换失败",e);
		}
		
		model.setUser(user);
		model.setShopname(shopname);
		model.setFreight(dFreight);//运费
		model.setShop(shop);
		model.setShopname(shopname);
		//总价格  =  商品总价 + 运费
		model.setFtotal(total + dFreight);
		
		//订单项
		OrderSon son = new OrderSon();
		son.setAmount(Amount);
		son.setGoods(good);
		son.setGoodsName(remark.length() > 0 ? goodsname += " - " + remark : goodsname);
		son.setGoodsName(goodsname );
		son.setPrice(Price);
		son.setOrder(model);//外键
		
		//订单项添加到订单中
		model.getSons().add(son);
		
		jsonMap.put("order", model);
		return "buyNow";
	}
	

	/**
	 * 立即购买-->确认-->下单
	 */
	public String saveOrder()
	{
		
		//获得form提交的参数
		HttpServletRequest  req =  ServletActionContext.getRequest();
		String addrid = req.getParameter("addrid");
		String userInfoId = req.getParameter("userInfoId");
		String shopid = req.getParameter("shopid");
		String shopname = req.getParameter("shopname");
		String goodsid = req.getParameter("goodsid");
		String goodsname = req.getParameter("goodsname");
		String price = req.getParameter("price");
		String amount = req.getParameter("amount");
		String remark = req.getParameter("remark");

		UserInfo user = userInfoService.getAdmin(Integer.parseInt(userInfoId));		
		DeliverAddr addr = deliverAddrService.get(Integer.parseInt(addrid));
		
		//店铺
		Shop shop = new Shop();
		shop.setShopId(Integer.parseInt(shopid));
		
		//商品
		Goods goods = new Goods();
		goods.setGoodsid(Integer.parseInt(goodsid));
		
		//数量价格
		double Price = Double.parseDouble(price);
		int Amount = Integer.parseInt(amount);
		double total = NumberFormat.Fix2(Price * Amount);
		
		OrderSon son = new OrderSon();
		son.setAmount(Amount);
		son.setPrice(Price);
		son.setGoods(goods);
		son.setGoodsName(goodsname);
		Order order = new Order();
		order.setUser(user);
		order.setBuytime(new Timestamp(System.currentTimeMillis()));
		
		order.setFtotal(total);
		order.setRemark(remark);
		order.setShop(shop);
		order.setShopname(shopname);
		order.setState("0");
		order.setStatemark("已提交");
		order.setAddr(addr.getFinalAddr());//地址
		
		//外键
		order.getSons().add(son);
		son.setOrder(order);
		
		//保存单个订单
		if( ! orderService.saveSingleOrderPhone(order,goodsid,Amount)){
			//下单失败
			jsonMap.put("isResult", "false");
			return "saveOrder";
		}else{
			jsonMap.put("isResult", "true");
			return "saveOrder";
		}
		
	}
	
	//按ID获得指定订单
	public String get() {

		Order order = orderService.get(model.getOrderid());
		request.put("order", order);
		return "updateOrder";
	}
	
	/**
	 * 纠纷相关
	 */
	public String dispute() {
		
		String orderid = ServletActionContext.getRequest().getParameter("ordersonid");
		System.out.println("主表的ID是:" + orderid);
		int id = Integer.parseInt(orderid);
		OrderSon order = orderSonService.get(id);
		request.put("order", order);
		return "disputeOrder";
	}

	// 用户查询订单
	// 已购买的宝贝 ywl
	public String haveBuyGoods() {
		String user_id = Struts2Utils.getParameter("user_id");
		UserInfo user = userInfoService.getAdmin(Integer.parseInt(user_id));
		//UserInfo user = (UserInfo) session.get("userinfo");
		String from = "";
		String to = "";
		page = orderService.getOrderListbyUser(page, from, to, user);
		//request.put("page", page);
		if(page!=null&&page.getTotalItems()>0){
			jsonMap.put("isResult", page);
			return "haveBuyGoods";
		}else{	
			jsonMap.put("isResult", "false");
			return "haveBuyGoods";
		}
		
	}
	
	// 按店铺查询订单
	// 已售出的宝贝 ywl
	public String haveSellGoods() {
		//获取用户id
		String user_id = Struts2Utils.getParameter("user_id");
		List<Shop> shopList = shopService.getListByUserId(Integer.parseInt(user_id));
		Shop shop = shopList.get(0);
		String from = "";
		String to = "";
		page = orderService.getOrderListbyShop(page, from, to, shop);
		//request.put("page", page);
		//return "haveSellGoods";
		if(page!=null&&page.getTotalItems()>0){
			jsonMap.put("isResult", page);
			return "haveSellGoods";
		}else{
			jsonMap.put("isResult", "false");
			return "haveSellGoods";
		}
		
	}
	
	// 立即付款 ywl
	public String payNow() {
		String order_id = Struts2Utils.getParameter("id");//订单表id
		Order order = orderService.getOrder(Integer.parseInt(order_id));
				//get(Integer.parseInt(order_id));	
		
		order.setState("2");
		orderService.update(order);
		//haveBuyGoods();	
		/*request.put("msg_operatingResult", "已支付成功！");		
		//给卖家发送消息
		messageService.sendMessage(messageService,"您有一个订单买家已经付款，请发货！", 
				order.getUser().getUserinfoId(), order.getShop().getUserinfo().getUserinfoId(),
		    "orderAction_haveSellGoods.action","orderId", model.getOrderid());	
		
		redirectUrl=ServletActionContext.getRequest().getParameter("redirectUrl");*/
		jsonMap.put("isResult", "true");
		return "payNow";
	}

	// 取消订单 ywl
	public String cancelOrder() {
		//Order order = orderService.get(model.getOrderid());
		String order_id = Struts2Utils.getParameter("id");//订单表id
		Order order = orderService.getOrder(Integer.parseInt(order_id));
		order.setState("1");
		orderService.update(order);
		//haveBuyGoods();
		//request.put("msg_operatingResult", "已取消订单成功！");
		//redirectUrl=ServletActionContext.getRequest().getParameter("redirectUrl");
		jsonMap.put("isResult", "true");
		return "cancelOrderURL";
	}

	// 卖家修改价格 ywl
	public String saveAlterMoney() {
		Order order = orderService.get(Integer.parseInt(ServletActionContext.getRequest().getParameter("orderid")));
		order.setFtotal(Double.parseDouble(ServletActionContext.getRequest().getParameter("ftotal")));
		orderService.update(order);
		
		//给买家发送消息
		messageService.sendMessage(messageService,"您购买的宝贝卖家已修改价格，请付款！", 
				order.getShop().getUserinfo().getUserinfoId(),order.getUser().getUserinfoId(),
					"orderAction_haveBuyGoods.action","orderId", order.getOrderid());
		return "haveSellAction";
	}
	// 确认发货 ywl
	public String confirmDelivery() {
		//Order order = orderService.get(model.getOrderid());
		String order_id = Struts2Utils.getParameter("id");//订单表id
		Order order = orderService.getOrder(Integer.parseInt(order_id));
		order.setState("3");
		order.setTranscompany(ServletActionContext.getRequest().getParameter("transcompany"));
		order.setTransnumber(ServletActionContext.getRequest().getParameter("transnumber"));
		orderService.update(order);
		//haveSellGoods();
		
		//request.put("msg_operatingResult", "已发货成功！");
		//给买家发送消息
		/*messageService.sendMessage(messageService,"您购买的宝贝卖家已发货，请注意接收！", 
			 order.getShop().getUserinfo().getUserinfoId(),order.getUser().getUserinfoId(),
			"orderAction_haveBuyGoods.action","orderId", model.getOrderid());*/
		jsonMap.put("isResult", "true");
		return "haveSellAction";
	}

	// 确认收货 ywl
	public String confirmGoods() {
		//Order order = orderService.get(model.getOrderid());
		String order_id = Struts2Utils.getParameter("id");//订单表id
		Order order = orderService.getOrder(Integer.parseInt(order_id));
		order.setState("4");
		orderService.update(order);
		Iterator<OrderSon> it=order.getSons().iterator();
		while (it.hasNext()) {
			OrderSon orderSon = orderSonService.get(it.next().getOrdersonId());
			orderSon.setSonstate("40");// 代表已经收货，但是未评价
			orderSonService.update(orderSon);
		}
		//haveBuyGoods();
		/*request.put("msg_operatingResult", "确认收货成功！");
		//给卖家发送消息
		messageService.sendMessage(messageService,"您有一个订单买家已经确认收货，请查看！", 
				order.getUser().getUserinfoId(), order.getShop().getUserinfo().getUserinfoId(),
		    "orderAction_haveSellGoods.action","orderId", model.getOrderid());	
				
		redirectUrl=ServletActionContext.getRequest().getParameter("redirectUrl");*/
		jsonMap.put("isResult", "true");
		return "confirmGoodsURL";
	}
	private Map<String,Object> responseJson = new HashMap<String,Object>();
	public Map<String, Object> getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}
	public String opensale()
	{
		//Shop shop =(Shop)session.get("shop");
		String shopId=Struts2Utils.getParameter("shopId");
		double totalmoney=orderService.getTotalMoeny(Integer.parseInt(shopId),null,null);
		request.put("totalmoney",totalmoney);
		page=orderService.getSaleOrder(page,Integer.parseInt(shopId),null,null);	
		if(page.getTotalItems()!=0)
		{
			Order order=page.getResult().get(0);
			String shopname=order.getShopname();
			responseJson.put("LIST", page.getResult());
			responseJson.put("totalmoney", totalmoney);
			responseJson.put("shopname",shopname);
			boolean isFristPage = page.isFirstPage();
			boolean isLastPage = page.isLastPage();
			responseJson.put("first", isFristPage);
			responseJson.put("next", isLastPage);
		}else
		{		
	
			responseJson.put("isResult", "false");
		}			
		return "listorder";
	}
	//zz 订单统计
	public String searchOrder()
	{
		String fromdate = ServletActionContext.getRequest().getParameter("fromdate");
		String todate = ServletActionContext.getRequest().getParameter("todate");
		String shopId = ServletActionContext.getRequest().getParameter("shopId");
		double totalmoney=orderService.getTotalMoeny(Integer.parseInt(shopId),fromdate,todate);
		request.put("totalmoney",totalmoney);
		page=orderService.getSaleOrder(page,Integer.parseInt(shopId),fromdate,todate);
		if(page!=null&&page.getTotalItems()>0)
		  {
			  request.put("msg", "");   
		  }
		  else
		  {
			  request.put("msg", "未找到符合条件的订单！");   
		  }
		request.put("page",page);
		return "SaleOrder";
	}
	
	
	private String redirectUrl = null;
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	
	public String getOrder(){
		
		Order order = orderService.findById(322);
		jsonMap.put("isResult", order);
		return "getOrder";	
	}
	
	
	// 卖家延长买家的收货时间
	public String sellDelayPurchasesTime() throws IOException {
		String id = Struts2Utils.getParameter("id");
		//String lasttime = req.getParameter("lasttime");		
		Order order = orderService.get(Integer.parseInt(id));
		order.setState("3");
		//order.setLasttime(Timestamp.valueOf(lasttime));
		
		//order.setTranscompany(ServletActionContext.getRequest().getParameter("transcompany"));
		//order.setTransnumber(ServletActionContext.getRequest().getParameter("transnumber"));
		//orderService.update(order);
		//haveSellGoods();
		
		jsonMap.put("isResult", "true");
		return "sellDelayPurchasesTime";
		
	}
}
