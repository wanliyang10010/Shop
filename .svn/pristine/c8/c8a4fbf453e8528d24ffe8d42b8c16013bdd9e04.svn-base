package cn.xaut.shop.phoneAction;

import org.apache.struts2.ServletActionContext;
import java.util.HashMap;
import java.util.Map;
import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.MarginRule;
import cn.xaut.shop.util.JSONUtils;
import cn.xaut.shop.util.Struts2Utils;



public class MarginRuleActionPhone extends BaseAction<MarginRule> {
	private Map<String, Object> responseJson = new HashMap<String, Object>();

	public Map<String, Object> getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}
	
	private static final long serialVersionUID = 1L;
	
	private String shopcategory;
	private String productcategory;
	


    public String getShopcategory() {
		return shopcategory;
	}

	public void setShopcategory(String shopcategory) {
		this.shopcategory = shopcategory;
	}

	public String getProductcategory() {
		return productcategory;
	}

	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}

   
   
  
   public String getlistItem()
   {
	  page=marginRuleService.queryAll(page);
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
   
  
   //得到店铺所需要的保证金数额，没有找到默认为0   ywl hx
   public String getShopMargin()
   {
	
	   String minmoney=marginRuleService.getShopMargin(shopcategory,productcategory);	
	   	 if(minmoney=="")
		 {
			 minmoney="0";
		 }

		 jsonMap.put("minmoney", minmoney);
		 return "json";   
   }

	public String add() throws Exception {
		page = marginRuleService.findItem(page, model.getType(), model.getProduct());
//		String typeId = Struts2Utils.getParameter("lc");
		if (page != null && page.getTotalItems() > 0) {
			String jsonList = JSONUtils.toJSONString(page);
			Struts2Utils.renderString(jsonList);
		} else {
			marginRuleService.save(model);
			Struts2Utils.renderTrue();
		}
		return null;
	}


	public String update() throws Exception {
		if (model != null) {
			marginRuleService.update(model);
			Struts2Utils.renderTrue();
			return null;
		} else {
			return null;
		}
	}


	public String list() throws Exception {
		String typekey = "个人一般店铺";
		String typekeyvalue = Struts2Utils.getParameter("typekeyvalue");
		page = marginRuleService.getList(page,typekey, typekeyvalue);
		if (page.getTotalItems() != 0) {
			responseJson.put("MarginRule", page);
		} else {
			String MarginRule = "0";
			responseJson.put("MarginRule", MarginRule);
		}
		return "MarginRule";
	}
	


	public String qury() throws Exception {
		page = marginRuleService.queryAll(page);
		if (page != null && page.getTotalItems() > 0) {
			String jsonList = JSONUtils.toJSONString(page);
			Struts2Utils.renderString(jsonList);
		} else {
			Struts2Utils.renderTrue();
		}
		return null;
	}



	public String delete() throws Exception{
		String id = Struts2Utils.getParameter("id");
		marginRuleService.delete(Integer.parseInt(id));
		return null;
	}

	

}
