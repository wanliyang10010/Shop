package cn.xaut.shop.action;

import java.util.List;

import org.apache.log4j.Logger;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import cn.xaut.shop.exception.MsgException;
import cn.xaut.shop.pojo.DeliverAddr;
import cn.xaut.shop.pojo.UserInfo;

public class DeliverAddrAction extends BaseAction<DeliverAddr> {

	private static final long serialVersionUID = -7761981356984533933L;
	public static Logger logger = Logger.getLogger(DeliverAddrAction.class);

	// 添加地址
	public String add() {

		UserInfo user = (UserInfo) session.get("userinfo");
		try {
			deliverAddrService.addNewAddr(model, user);
		} catch (MsgException e) {
			request.put("error", e.getMessage());
		}
		
		return "query";
	}

	public String isExits() {

		if (model.getDeliveraddrId() == null) {
			if (deliverAddrService.isExisted(model)) {
				jsonMap.put("data", "yes");
			} else {
				jsonMap.put("data", "no");
			}
		} else {
			jsonMap.put("data", "no");
		}
		return "json";
	}

	/**
	 * 查询我的全部收货地址
	 * 
	 * @return
	 */
	public String list() {
		// 查询的数据，如果能存到request中就不要存储在session中
		UserInfo user = (UserInfo) session.get("userinfo");
		page = deliverAddrService.getDeliverAddr(page, user);
		request.put("page", page);
		int total = 5;// 这个应该由配置文件读取
		int rest = (int) (total - page.getTotalItems());
		String msg = "已保存了" + page.getTotalItems() + "条地址，还能保存" + rest + "条地址";
		request.put("msg", msg);
		request.put("rest", rest);

		return "list";
	}

	public String changeDefaultAddr() {
		UserInfo user = (UserInfo) session.get("userinfo");
		// 此时model只有id是有值的
		deliverAddrService.changeDefaultAddr(model, user);
		jsonMap.put("data", "change");
		return "json";
	}

	public String get() {
		model = deliverAddrService.get(model.getDeliveraddrId());
		jsonMap.put("data", "get");
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "handler",
				"hibernateLazyInitializer" });
		JSON json = JSONSerializer.toJSON(model, jsonConfig);
		// JSONObject joson = JSONObject.fromObject(bean);
		jsonMap.put("model", json.toString());

		return "json";
	}

	public String update(){
		UserInfo user = (UserInfo) session.get("userinfo");
		deliverAddrService.update(model, user);
		return "query";
	}

	public String delete() {
		logger.debug("删除地址 id --> " + model.getDeliveraddrId());
		deliverAddrService.deleteById((model.getDeliveraddrId()));
		jsonMap.put("data", "delete");
		return "json";
	}

	// 获取top5收货地址
	public void toplist() {
		UserInfo user = (UserInfo) session.get("userinfo");
		List<DeliverAddr> list = deliverAddrService.getTop5List(user);
		request.put("list", list);
	}

	public String showMyAddr() {
		return "list";
	}

}
