package cn.xaut.shop.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.exception.OrderException;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.UserInfo;

@SuppressWarnings("unchecked")
public class SubmitOrderAction extends BaseAction<Order> {

	private static final long serialVersionUID = 1688873547354426976L;
	
	
	// 重复提交了
	public String reSubmit(){
		request.put("errMsg", "系统检测到您在做重复提交订单操作");
		return "doAgain";
	}

	/**
	 * 保存一组订单
	 */
	public String saveOrderbylist() {
		try {
			
			HttpServletRequest req = ServletActionContext.getRequest();
			UserInfo user = (UserInfo) session.get("userinfo");
			
			// 保存订单
			orderService.saveOrderbylist(req.getParameterMap(),user);
			/** --------- 没有发生异常 表示提价表单成功了 --------- **/
			jsonMap.put("data", "ok");

		} catch (OrderException e) {
			// 提交订单失败
			jsonMap.put("data", "fail");// 提交失败
			jsonMap.put("dataMsg", e.getMessage());
		} catch (Exception e) {
			jsonMap.put("data", "fail");// 提交失败
			jsonMap.put("dataMsg", "商品信息出错");
		}
		return "json";
	}
	
	
}
