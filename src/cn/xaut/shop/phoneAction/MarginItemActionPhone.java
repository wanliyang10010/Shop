package cn.xaut.shop.phoneAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.MarginItem;
import cn.xaut.shop.util.JSONUtils;
import cn.xaut.shop.util.Struts2Utils;

public class MarginItemActionPhone extends BaseAction<MarginItem> {
	
	private Map<String, Object> responseJson = new HashMap<String, Object>();

	public Map<String, Object> getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}

	private static final long serialVersionUID = 5093031375657804447L;

	public String add() throws Exception {
		page = marginItemService.findItem(page, model.getItemname());
		if (page != null && page.getTotalItems() > 0) {
			String jsonList = JSONUtils.toJSONString(page);
			Struts2Utils.renderString(jsonList);
		} else {
			marginItemService.save(model);
			Struts2Utils.renderTrue();
		}
		return null;
	}

	public String update() throws Exception {
		if (model != null) {
			marginItemService.update(model);
			Struts2Utils.renderTrue();
			return null;
		} else {
			return null;
		}
	}

	// public String list()
	// {
	// String key= ServletActionContext.getRequest().getParameter("keyword");
	// page=marginItemService.getList(page,key);
	// if(page!=null&&page.getTotalItems()>0)
	// {
	// request.put("msg", "");
	// }
	// else
	// {
	// request.put("msg", "没有符合条件的记录，请重新查询");
	// }
	// request.put("page", page);
	// return "list";
	// }
	//
	public String list() throws Exception {
		String key = ServletActionContext.getRequest().getParameter("keyword");
		page = marginItemService.getList(page, key);
		if (page.getTotalItems() != 0) {
			responseJson.put("MarginItemList", page);
		} else {
			String MarginItemList = "0";
			responseJson.put("MarginItemList", MarginItemList);
		}
		return "MarginItemList";
	}

	public String qury() throws Exception {
		page = marginItemService.queryAll(page);
		if (page.getTotalItems() != 0) {
			String jsonList = JSONUtils.toJSONString(page);
			Struts2Utils.renderString(jsonList);
		} else {
			Struts2Utils.renderTrue();
		}
		return null;
	}

	public String delete() throws Exception{
		// String id = ServletActionContext.getRequest().getParameter("itemId");
		// marginItemService.delete(Integer.parseInt(id));
		// return "query";
		String id = Struts2Utils.getParameter("id");
		marginItemService.delete(Integer.parseInt(id));
		return null;
	}

	public String getlistItem() {
		List<MarginItem> list = marginItemService.query();
		request.put("MarginItemList", list);
		return "list";
	}

	public String getlist() {
		List<MarginItem> list = marginItemService.query();
		// System.out.println(list.size());
		responseJson.put("MarginItemList", list);
		return "MarginItemList";
	}
}
