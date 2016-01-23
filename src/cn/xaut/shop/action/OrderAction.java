package cn.xaut.shop.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.aspectj.weaver.patterns.ArgsAnnotationPointcut;

import cn.xaut.shop.exception.CartException;
import cn.xaut.shop.exception.OrderException;
import cn.xaut.shop.pojo.Cart;
import cn.xaut.shop.pojo.DeliverAddr;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.OrderSon;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.util.NumberFormat;

@SuppressWarnings("unchecked")
public class OrderAction extends BaseAction<Order> {

	private static final long serialVersionUID = 1L;

	/** 保存勾选的购物项*/
	private String[] chkItem;
	public String[] getChkItem() {
		return chkItem;
	}
	public void setChkItem(String[] chkItem) {
		this.chkItem = chkItem;
	}

	/** 勾选的购物车ID数组*/
	private String[] checkedCart;
	public String[] getCheckedCart() {
		return checkedCart;
	}
	public void setCheckedCart(String[] checkedCart) {
		this.checkedCart = checkedCart;
	}
	
	/** 勾选的购物项所在购物车的ID的数组*/
	/*这个跟上面的数组是一样的，提交过来的方式不一样而已*/
	private String cartIdlist;
	public String[] getCartIdArr() {
		if(cartIdlist != null){
			System.out.println(cartIdlist.split(","));
			return cartIdlist.split(",");
		}
		return null;
	}
	public void setCartIdlist(String cartIdlist) {
		this.cartIdlist = cartIdlist;
	}

	/** 下单时的备注信息 Remark*/
	private String[] remarks;
	public String[] getRemarks() {
		return remarks;
	}
	public void setRemarks(String[] remarks) {
		this.remarks = remarks;
	}

	/**跳转页面时用到的商品ID*/
	private String gid;
	public String getGid() {
		return gid;
	}

	/**
	 * 购物车 --> 结算 --> 确认订单
	 * 
	 * @return
	 */
	public String comfirmOrders() {
		try{
			
			UserInfo user = (UserInfo) session.get("userinfo");
			List<Cart> cartlist = (List<Cart>) session.get("cartlist");
			if (cartlist == null) {
				cartlist = cartService.loadCartsByUserId(user.getUserinfoId());
			}
			List<Order> orderlist = cartService.getOrderList(cartlist, getChkItem());
			session.put("orderlist", orderlist);
			jsonMap.put("data", "ok");
			
		}catch(CartException ex){
			jsonMap.put("data", "fail");
			jsonMap.put("dataMsg", ex.getMessage());
		}
		
		return "json";
	}
	
	
	/**
	 * 购物车中勾选项目 --> 点击结算 --> 生成要确认的订单
	 * @return
	 */
	public String createPerOrders() {
		try{
			List<Order> orderlist = cartService.createPreOrderList(getCheckedCart(),getChkItem());
			
			request.put("orderlist", orderlist);
			
			jsonMap.put("data", "ok");
			
		}catch(CartException ex){
			jsonMap.put("data", "fail");
			jsonMap.put("dataMsg", ex.getMessage());
		}
		return "json";
	}
	
	
	public String goConfirmOrder(){
		return "confirmOrders";
	}
	
	/**
	 * 列出预订单
	 * @return
	 */
	/*
	public String listPreOrder(){
		try {
			
			if(getChkItem() == null || getCartIdArr() == null){
				request.put("errMsg", "请勾选要结算的商品");
				//返回购物车
				return "returnCart";
			}
			
			List<Order> orderlist = cartService.createPreOrderList(getCartIdArr(),getChkItem());
			request.put("orderlist", orderlist);
			return "preOrders";
		} catch (CartException e) {
			// 出现意外，先让他去购物车吧
			request.put("errMsg", e.getMessage());
			return "returnCart";
		}
	}
	*/

	/**
	 * 保存一组订单
	 */
	/*
	public String saveOrders() {

		List<Order> orderlist = (List<Order>) session.get("orderlist");
		if (orderlist == null) {
			jsonMap.put("data", "timeout");//超时了，重新回购物车结算
			return "json";
		}

		HttpServletRequest req = ServletActionContext.getRequest();
		// 选择的收货地址
		String addrid = req.getParameter("addrid");
		if (addrid == null || "0".equals(addrid) || "-1".equals(addrid)) {
			// 收货地址有错误
			jsonMap.put("data", "fail");// 提交失败
			jsonMap.put("dataMsg", "请选择有效的收货地址");
			return "json";
		}

		// 获取地址信息
		DeliverAddr addr = deliverAddrService.get(Integer.parseInt(addrid));
		UserInfo user = (UserInfo) session.get("userinfo");

		try {
			
			// 保存订单
			OrderSon failedSon = orderService.saveOrderList(req, orderlist,user, addr);

			if (failedSon != null) {
				// 提交订单失败
				jsonMap.put("data", "fail");// 提交失败
				StringBuffer buff = new StringBuffer();
				buff.append("[");
				buff.append(failedSon.getGoodsName());
				if (failedSon.isPropertyValid())
					buff.append(failedSon.getProperty());// 商品类别 --> 可用
				buff.append("]");
				buff.append("库存数量不足，不能提交订单.");
				jsonMap.put("dataMsg", buff.toString());
				
			} else {

				/// --------- 提交订单成功，删除购物车中的购物项 --------- 
				// 拿到session中的cartlist购物车list
				List<Cart> cartlist = (List<Cart>) session.get("cartlist");
				
				// 删除购物项 - 移除购物车
				cartlist = cartItemService.removeItemCosByOrder(cartlist,orderlist);

				// 重新计算总价
				cartService.calcTotalAll(cartlist);
				
				// 更新购物车数据库
				cartService.saveOrUpdatebyList(cartlist);
				
				// 再存回session中
				session.put("cartlist", cartlist);
				session.remove("orderlist");// 从session中移除orderlist

				jsonMap.put("data", "ok");
				// return "userOrderlist";// 提交订单成功，要去哪里呢？
			}

		} catch (OrderException e) {
			// 商品下架或失效
			// 单笔订单超过最大金额限制
			jsonMap.put("data", "fail");// 提交失败
			jsonMap.put("dataMsg", e.getMessage());
		} catch (Exception e) {
			jsonMap.put("data", "fail");// 提交失败
			jsonMap.put("dataMsg", "商品信息出错");
		}

		return "json";
	}
	*/

	/**
	 * 创建立即购买订单.(只有一个订单项 <--- "立即购买")
	 * 
	 * @return
	 */
	public String buyNow() {
		UserInfo user = (UserInfo) session.get("userinfo");

		// 获得form提交的参数
		HttpServletRequest req = ServletActionContext.getRequest();
		String shopid = req.getParameter("shopid");
		String goodsid = req.getParameter("goodsId");
		String amount = req.getParameter("amount");// 购买数量
		String property = req.getParameter("property");// 购买的商品类型信息

		// 修补：不能选购自己出售的商品
		Shop shop = shopService.get(Integer.parseInt(shopid));
		if (shop != null
				&& shop.getUserinfo().getUserinfoId()
						.equals(user.getUserinfoId())) {
			this.gid = goodsid;
			return "goodPage";
		}

		model = orderService.preOrder(user, Integer.parseInt(shopid),
				Integer.parseInt(goodsid), Integer.parseInt(amount), property);

		request.put("order", model);
		return "buyNow";
	}

	/**
	 * 立即购买-->确认-->下单
	 */
	public String saveOneOrder() {
		UserInfo user = (UserInfo) session.get("userinfo");
		// 获得form提交的参数
		HttpServletRequest req = ServletActionContext.getRequest();

		int goodsid = Integer.parseInt(req.getParameter("goodsid"));
		int shopid = Integer.parseInt(req.getParameter("shopid"));
		int amount = Integer.parseInt(req.getParameter("amount"));// 选购数量
		String property = req.getParameter("property");// 选择的商品类型信息
		String remark = req.getParameter("remark");// 订单备注
		String str_addrid = req.getParameter("addrid");

		if (str_addrid == null || "0".equals(str_addrid)) {
			// 没有选择有效的收货地址
			jsonMap.put("data", "fail");// 失败
			jsonMap.put("dataMsg", "请选择有效的收货地址");
			return "json";
		}

		// 保存订单
		Integer flag = orderService.saveOneOrder(user, shopid, goodsid, amount,
				property, remark, Integer.parseInt(str_addrid));
		
		if (!(flag > 0)) {
			
			// 保存失败
			jsonMap.put("data", "fail");
			if (flag == 0) {
				jsonMap.put("dataMsg", "该商品已失效,无法提交订单");
			} else if(flag == -1){
				jsonMap.put("dataMsg", "库存数量不足，无法提交订单");
			} else if(flag == -2){
				jsonMap.put("dataMsg", "单笔订单金额超过系统最大限制");
			}
			// return "orderFailed";
			return "json";
		}

		// 保存成功
		jsonMap.put("data", "ok");
		jsonMap.put("orderid", flag);
		// return "userOrderlist";
		return "json";
	}

	// 与ywl的付款对接的地址
	private String strGoPayUrl = "";

	public String getStrGoPayUrl() {
		return strGoPayUrl;
	}

	public String jumptoPay() throws UnsupportedEncodingException {
		HttpServletRequest req = ServletActionContext.getRequest();
		String orderid = req.getParameter("orderid");
		// String ctx = req.getParameter("ctx");
		if (orderid != null) {
			Order order = orderService.findById(Integer.parseInt(orderid));
			StringBuffer buff = new StringBuffer();
			buff.append("orderid=" + order.getOrderid());

			String TAG = URLEncoder.encode(order.getUser().getUsername(),
					"utf-8");
			// buff.append("&username=" + order.getUser().getUsername());
			buff.append("&username=" + TAG);

			buff.append("&buytime=" + order.getBuytime());

			// buff.append("&shopname=" + order.getShopname());
			TAG = URLEncoder.encode(order.getShopname(), "utf-8");
			buff.append("&shopname=" + TAG);

			buff.append("&ftotal=" + order.getFtotal());
			if (order.getRemark() != null) {
				TAG = URLEncoder.encode(order.getRemark(), "utf-8");
				// buff.append("&remark=" + order.getRemark());
				buff.append("&remark=" + TAG);
			}
			// buff.append();
			strGoPayUrl = buff.toString();

			return "bank";// 去银行付款页面
		} else {
			return "userOrderlist";// 去所有订单页面
		}

	}


	// 按ID获得指定订单
	public String get() {
		Order order = orderService.get(model.getOrderid());
		request.put("order", order);
		return "updateOrder";
	}

	/**
	 * 纠纷相关
	 */
	public String dispute() {

		String orderid = ServletActionContext.getRequest().getParameter(
				"ordersonid");
		System.out.println("主表的ID是:" + orderid);
		int id = Integer.parseInt(orderid);
		OrderSon order = orderSonService.get(id);
		request.put("order", order);
		return "disputeOrder";
	}

	// 用户查询订单
	// 买进宝贝订单 ywl
	public String haveBuyGoods() {
		UserInfo user = (UserInfo) session.get("userinfo");
		String from = "";
		String to = "";
		page = orderService.getOrderListbyUser(page, from, to, user);
		request.put("page", page);
		return "haveBuyGoods";
	}

	// 按店铺查询订单
	// 卖出宝贝订单 ywl
	public String haveSellGoods() {
		Shop shop = (Shop) session.get("shop");
		String from = "";
		String to = "";
		page = orderService.getOrderListbyShop(page, from, to, shop);
		request.put("page", page);
		return "haveSellGoods";
	}

	// 立即付款 ywl
	public String payNow() {

		Order order = orderService.get(model.getOrderid());
		// 订单付款
		if (order.getState().equals("2")
				|| !order.getFtotal().equals(
						Double.parseDouble(ServletActionContext.getRequest()
								.getParameter("ftotal")))) {
			return "reOperation";
		}

		orderService.updatePayOrder(order);

		request.put("msg_operatingResult", "已支付成功！");
		// 给卖家发送消息
		messageService.sendMessage(messageService, "您有一个订单买家已经付款，请发货！", order
				.getUser().getUserinfoId(), order.getShop().getUserinfo()
				.getUserinfoId(), "orderAction_haveSellGoods.action",
				"orderId", model.getOrderid());

		redirectUrl = ServletActionContext.getRequest().getParameter(
				"redirectUrl");
		return "payNowURL";
	}

	// 取消订单 ywl
	public String cancelOrder() {
		Order order = orderService.get(model.getOrderid());
		if (order.getState().equals(Order.CANCEL)) {
			return "reOperation";
		}

		orderService.updateCancelOrder(order);
		request.put("msg_operatingResult", "已取消订单成功！");
		redirectUrl = ServletActionContext.getRequest().getParameter(
				"redirectUrl");
		return "cancelOrderURL";
	}

	// 买家删除订单 ywl
	public String deleteOrder() {
		Order order = orderService.get(model.getOrderid());
		if (order.getStatemark().equals("10")
				|| order.getStatemark().equals("11")) {
			return "reOperation";
		}
		String statemark = order.getStatemark().trim();
		if (statemark.equals("已提交")) {
			order.setStatemark("10");// 买家删除订单
		}
		if (statemark.equals("01")) {// 卖家删除订单
			order.setStatemark("11");// 买卖家删除订单
		}
		orderService.update(order);
		request.put("msg_operatingResult", "已删除订单成功！");
		redirectUrl = ServletActionContext.getRequest().getParameter(
				"redirectUrl");
		return "deleteOrderURL";
	}

	// 卖家删除订单 ywl
	public String deleteOrderSell() {
		Order order = orderService.get(model.getOrderid());
		if (order.getStatemark().equals("01")
				|| order.getStatemark().equals("11")) {
			return "reOperation";
		}
		String statemark = order.getStatemark().trim();
		if (statemark.equals("已提交")) {
			order.setStatemark("01");// 卖家删除订单
		}
		if (statemark.equals("10")) {
			order.setStatemark("11");
		}
		orderService.update(order);
		request.put("msg_operatingResult", "已删除订单成功！");
		redirectUrl = ServletActionContext.getRequest().getParameter(
				"redirectUrl");
		return "deleteOrderURL";
	}

	// 卖家修改价格 ywl
	public String saveAlterMoney() {
		Order order = orderService.get(Integer.parseInt(ServletActionContext
				.getRequest().getParameter("orderid")));
		if (!order.getState().equals(Order.SUBMIT)) {
			jsonMap.put("data", "no");
			return "json";
		}
		order.setFtotal(Double.parseDouble(ServletActionContext.getRequest()
				.getParameter("ftotal")));
		orderService.update(order);

		// 给买家发送消息
		messageService.sendMessage(messageService, "您购买的宝贝卖家已修改价格，请付款！", order
				.getShop().getUserinfo().getUserinfoId(), order.getUser()
				.getUserinfoId(), "orderAction_haveBuyGoods.action", "orderId",
				order.getOrderid());
		return "json";
	}
	
	// 跳转到确认发货界面 ywl
	public String confirmdeliveryJSP() {
		String orderid=ServletActionContext.getRequest().getParameter("orderid");
		Order order = orderService.get(Integer.parseInt(orderid));
		request.put("order", order);
		return "confirmDeliveryJSP";
	}


	// 确认发货 ywl
	public String confirmDelivery() {
		Order order = orderService.get(model.getOrderid());

		if (order.getState().equals("3")) {
			return "reOperation";
		}
		order.setState("3");
		order.setTranscompany(ServletActionContext.getRequest().getParameter(
				"transcompany"));
		order.setTransnumber(ServletActionContext.getRequest().getParameter(
				"transnumber"));
		orderService.update(order);

		request.put("msg_operatingResult", "已发货成功！");
		// 给买家发送消息
		messageService.sendMessage(messageService, "您购买的宝贝卖家已发货，请注意接收！", order
				.getShop().getUserinfo().getUserinfoId(), order.getUser()
				.getUserinfoId(), "orderAction_haveBuyGoods.action", "orderId",
				model.getOrderid());
		return "haveSellAction";
	}
	
	
	// 查看物流信息 ywl
		public String viewtrans() {
			String orderid=ServletActionContext.getRequest().getParameter("orderid");
			Order order = orderService.get(Integer.parseInt(orderid));
			request.put("order", order);
			return "viewTrans";
		}
	// 延长收货时间 ywl
	public String prolongTime() {
		String orderid=ServletActionContext.getRequest().getParameter("orderid");
		Order order = orderService.get(Integer.parseInt(orderid));
		request.put("order", order);
		return "prolongTime";
	}
		
	// 确认收货 ywl
	public String confirmGoods() {
		Order order = orderService.get(model.getOrderid());

		if (order.getState().equals("4")) {
			return "reOperation";
		}

		order.setState("4");
		//orderService.update(order);
//		Iterator<OrderSon> it = order.getSons().iterator();
//		while (it.hasNext()) {
//			OrderSon orderSon = orderSonService.get(it.next().getOrdersonId());
//			orderSon.setSonstate("40");// 代表已经收货，但是未评价
//			orderSonService.update(orderSon);
//		}
		orderService.updateConfirmGoods(order);
		request.put("msg_operatingResult", "确认收货成功！");
		// 给卖家发送消息
		messageService.sendMessage(messageService, "您有一个订单买家已经确认收货，请查看！", order
				.getUser().getUserinfoId(), order.getShop().getUserinfo()
				.getUserinfoId(), "orderAction_haveSellGoods.action",
				"orderId", model.getOrderid());

		redirectUrl = ServletActionContext.getRequest().getParameter(
				"redirectUrl");
		return "confirmGoodsURL";
	}

	public String opensale() {
		Shop shop = (Shop) session.get("shop");
		double total = orderService.getTotalMoeny(shop.getShopId(), null, null);
		double totalmoney = NumberFormat.Fix2(total);
		request.put("totalmoney", totalmoney);
		page = orderService.getSaleOrder(page, shop.getShopId(), null, null);
		if (page != null && page.getTotalItems() > 0) {
			request.put("msg", "");
		} else {
			request.put("msg", "未找到符合条件的订单！");
		}
		request.put("page", page);
		return "SaleOrder";
	}

	// zz 订单统计
	public String searchOrder() {
		String fromdate = ServletActionContext.getRequest().getParameter(
				"fromdate");
		String todate = ServletActionContext.getRequest()
				.getParameter("todate");
		String shopId = ServletActionContext.getRequest()
				.getParameter("shopId");
		double totalmoney = orderService.getTotalMoeny(
				Integer.parseInt(shopId), fromdate, todate);
		request.put("totalmoney", totalmoney);
		page = orderService.getSaleOrder(page, Integer.parseInt(shopId),
				fromdate, todate);
		if (page != null && page.getTotalItems() > 0) {
			request.put("msg", "");
		} else {
			request.put("msg", "未找到符合条件的订单！");
		}
		request.put("page", page);
		return "SaleOrder";
	}

	private String redirectUrl = null;

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
}
