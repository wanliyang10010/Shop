package cn.xaut.shop.phoneAction;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.OrderSon;

/*
 * 
 * 1.基本所有的Action都需要用到request session application 内置对象
 * 
 * 通过他们存数数据，交给前台页面显示，Struts提供了AOP+Ioc的方式，在运行的时候自动注入->实现几个接口就可以了
 * 
 * 2. 前台页面中所有的数据名称，必须要用[对象.属性]方式取值， 这样做耦合性太高，我们可以实现一个接口来解耦
 * 
 * */

public class OrderSonActionPhone extends BaseAction<OrderSon> {

	private static final long serialVersionUID = 3280838084229322870L;

	/**
	 * 纠纷相关
	 * @author zz
	 * @return
	 */
	public String dispute()
	{
		String orderid = ServletActionContext.getRequest().getParameter("ordersonid");
		System.out.println("主表的ID是:" + orderid);
		int id = Integer.parseInt(orderid);
		OrderSon order = orderSonService.get(id);
		request.put("order", order);
		return "disputeOrder";
	}


	public String viewOrder()
	{
		String ordersonid = ServletActionContext.getRequest().getParameter("ordersonid");
		OrderSon  orderson=orderSonService.get(Integer.parseInt(ordersonid));
		Order  order=orderService.get(orderson.getOrder().getOrderid());
		request.put("order",order);
		request.put("orderson",orderson);
		return "viewOrder";
	}

}
