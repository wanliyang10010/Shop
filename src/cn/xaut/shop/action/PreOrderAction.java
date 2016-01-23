package cn.xaut.shop.action;

import java.util.List;

import cn.xaut.shop.exception.CartException;
import cn.xaut.shop.pojo.Order;

public class PreOrderAction extends BaseAction<Order> {

	private static final long serialVersionUID = -5754403449976789737L;
	
	
	/** 保存勾选的购物项*/
	private String[] chkItem;
	public String[] getChkItem() {
		return chkItem;
	}
	public void setChkItem(String[] chkItem) {
		this.chkItem = chkItem;
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
	
	/**
	 * 列出预订单
	 * @return
	 */
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
	
}
