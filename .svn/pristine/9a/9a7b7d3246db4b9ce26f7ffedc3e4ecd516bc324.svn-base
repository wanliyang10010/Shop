package cn.xaut.shop.phoneAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.exception.MsgException;
import cn.xaut.shop.pojo.DeliverAddr;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.util.Struts2Utils;

public class DeliverAddrActionPhone extends BaseAction<DeliverAddr> {

	private static final long serialVersionUID = -7761981356984533933L;

	private UserInfo userinfo;
	private Integer userinfoId;
	private Integer deliveraddrId;
	public Integer getDeliveraddrId() {
		return deliveraddrId;
	}
	HttpServletRequest req = (HttpServletRequest) request;
	public void setDeliveraddrId(Integer deliveraddrId) {
		this.deliveraddrId = deliveraddrId;
	}

	public Integer getUserinfoId() {
		return userinfoId;
	}

	public void setUserinfoId(Integer userinfoId) {
		this.userinfoId = userinfoId;
	}

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	// 添加地址
	public String add() {
		try {
			//UserInfo user = (UserInfo) session.get("userinfo");
			UserInfo userinfo=userInfoService.getAdmin(userinfoId);
			deliverAddrService.addNewAddrphone(model, userinfo);
			jsonMap.put("isResult", "add");
		} catch (MsgException e) {
			// 获取异常信息并返回
			//jsonMap.put("msg", e.getMessage());
			jsonMap.put("isResult", "false");
		}

		return "addDeliverAddr";
	}

	/**
	 * 查询我的全部收货地址
	 * 
	 * @return
	 */
	public String list() {
		UserInfo userinfo=userInfoService.getAdmin(userinfoId);
		page = deliverAddrService.getDeliverAddr(page, userinfo);
		if(page.getTotalItems()==0){
			jsonMap.put("isResult", "false");
		}
		jsonMap.put("page", page);
		boolean isFirstPage=page.isFirstPage();
		boolean isLastPage=	page.isLastPage();
		jsonMap.put("jsonList1", isFirstPage);
		jsonMap.put("jsonList2", isLastPage);
		//int total = 5;// 这个应该由配置文件读取
		//int rest = (int) (total - page.getTotalItems());
		//String msg = "已保存了" + page.getTotalItems() + "条地址，还能保存" + rest + "条地址";
		//request.put("msg", msg);
		//jsonMap.put("rest", "rest");
		
		return "listDeliverAddr";

	}

	public String changeDefaultAddr() {
		UserInfo user = (UserInfo) session.get("userinfo");
		// 此时model只有一个id是有值的
		deliverAddrService.changeDefaultAddr(model, user);

		jsonMap.put("data", "change");
		
		return "json";
	}

	public String get() {
		
		model = deliverAddrService.get(model.getDeliveraddrId());

		jsonMap.put("data", "get");
		
		JsonConfig jsonConfig = new JsonConfig();
	    jsonConfig.setExcludes(new String[]{"handler","hibernateLazyInitializer"});
	    JSON json = JSONSerializer.toJSON(model, jsonConfig);
	   
	    
	    //JSONObject joson = JSONObject.fromObject(bean);
	   
	   
	    
	    jsonMap.put("model",json.toString());	    

		return "json";
	}

	public String update() {

		//UserInfo user = (UserInfo) session.get("userinfo");
		//System.out.println("addr update  id -> " + model.getDeliveraddrId());
		UserInfo userinfo=userInfoService.getAdmin(userinfoId);
		deliverAddrService.updatephone(model, userinfo);
		jsonMap.put("isResult", "update");
		return "updateDeliverAddr";
	}
	
	public String delete() {

		System.out.println("删除地址 id --> " + model.getDeliveraddrId());

		deliverAddrService.deleteById(model.getDeliveraddrId());

		jsonMap.put("isResult", "delete");
		
		return "deleteDeliverAddr";
	}
	
	//获取top5收货地址
	public void toplist()
	{
		UserInfo user = (UserInfo) session.get("userinfo");
		List<DeliverAddr> list = deliverAddrService.getTop5List(user);
		request.put("list", list);
	}
	
	public String getDefault()
	{
		//UserInfo user = (UserInfo) session.get("userinfo");
		//String userId = req.getParameter("userInfoId");
		String userId = Struts2Utils.getParameter("userInfoId");
		//String userId = req.get
		//String userId = "166";
		UserInfo user = userInfoService.getAdmin(Integer.parseInt(userId));
		List<DeliverAddr> list = deliverAddrService.getTop5List(user);
		model = list.get(0);		
        jsonMap.put("isResult", model);
		
		return "deliverAdrr";
	}
	
	public String list5()
	{
		//UserInfo user = (UserInfo) session.get("userinfo");
		String userId = Struts2Utils.getParameter("userInfoId");
		UserInfo user = userInfoService.getAdmin(Integer.parseInt(userId));
		List<DeliverAddr> list = deliverAddrService.getTop5List(user);
		//request.put("list", list);
		if(list!=null&list.size()>0)
		{
			jsonMap.put("isResult", list);
		}else{
			jsonMap.put("isResult", "true");
		}

			return "deliverAdrr5";
	}

}
