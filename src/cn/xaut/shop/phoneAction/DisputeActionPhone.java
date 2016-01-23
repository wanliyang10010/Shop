package cn.xaut.shop.phoneAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.Dispute;
import cn.xaut.shop.pojo.DisputeFile;
import cn.xaut.shop.pojo.OrderSon;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.util.Struts2Utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DisputeActionPhone extends BaseAction<Dispute> {
	private Map<String,Object> responseJson = new HashMap<String,Object>();
	private Integer userinfoId;
	
	public Integer getUserinfoId() {
		return userinfoId;
	}
	public void setUserinfoId(Integer userinfoId) {
		this.userinfoId = userinfoId;
	}
	private Integer ordersonId;
	private HttpServletRequest req = ServletActionContext.getRequest();
	public Integer getOrdersonId() {
		return ordersonId;
	}
	public void setOrdersonId(Integer ordersonId) {
		this.ordersonId = ordersonId;
	}
	public Map<String, Object> getResponseJson() {
		return responseJson;
	}
	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}
	public static HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -2751434195504573665L;
	DisputeFileActionPhone disputeFile = new DisputeFileActionPhone();
	Gson gson = new Gson();
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public List<DisputeFile> getlist(String json) {
		System.out.println(json);
		Type listType = new TypeToken<ArrayList<DisputeFile>>() {
		}.getType();// TypeToken内的泛型就是Json数据中的类型
		List<DisputeFile> list = gson.fromJson(json, listType);
		return list;
	}

	public String add() {
		//System.out.println(userinfoId);
		UserInfo userinfo = userInfoService.getAdmin(userinfoId);
		OrderSon orderson = orderSonService.get(ordersonId);
		String reason = req.getParameter("reason");
		String dtype = req.getParameter("dtype");
		model.setDtype(dtype);
		model.setInfodate(dateFormat.format(now));
		model.setState("0");
		model.setAccuser(userinfo.getUsername());
		model.setSccused(orderson.getOrder().getShopname());//shopName
		model.setOrderson(orderson.getGoodsName());//goodsNmae
		model.setContent(reason);
		model.setUserInfo(userinfo);
		model.setShop(orderson.getOrder().getShop());
		model.setOrder(orderson);
		disputeService.save(model);
		orderson.setIsdispute("1");
		orderSonService.update(orderson);
		jsonMap.put("isResult", "addDisputeInfo");
		return "addDisputeInfoPhone";
	}

	public void addFile(String json,Dispute dispute)
	{
		List<DisputeFile> list = new ArrayList<DisputeFile>();
		if (!json.trim().equals("")) {
			list = getlist(json);
		}
		if (list != null && list.size() > 0) {
			DisputeFile disputefile = new DisputeFile();
			for (int i = 0; i < list.size(); i++) {
				disputefile=list.get(i);
				disputefile.setDispute(dispute);
				disputeFileService.save(disputefile);
			}
			session.remove("file");
		}
	}
	
	public String searchDate() {
		String dtstart = ServletActionContext.getRequest()
				.getParameter("dtstart").replace("-", "/");
		String dtend = ServletActionContext.getRequest().getParameter("dtend")
				.replace("-", "/");
		dtend = dtend + " 23:59:59";
		String state = ServletActionContext.getRequest().getParameter("state");
		System.out.println(dtstart + dtend);
		page = disputeService.getbetween(page, dtstart, dtend, state);
		if (page != null && page.getTotalItems() > 0) {
			request.put("msg", "");
		} else {
			request.put("msg", "没有符合条件的记录，请重新查询");
		}
		request.put("page", page);
		return "list";
	}

	public String search() throws IOException{
		String stype = "店铺名";//Struts2Utils.getRequest().getParameter("stype");
	    String key = Struts2Utils.getRequest().getParameter("keyword");
		page = disputeService.getlist(page,key,stype);
		if (page != null && page.getTotalItems() > 0) {
			responseJson.put("ListDispute", page);
			boolean isFristPage = page.isFirstPage();
			boolean isLastPage = page.isLastPage();
			responseJson.put("first", isFristPage);
			responseJson.put("next", isLastPage);
		//request.put("msg", "");
	} else {
			//request.put("msg", "没有符合条件的记录，请重新查询");
			String ListDispute ="0";
		    responseJson.put("ListDispute",ListDispute);
		}
		//request.put("page", page);
		//return "list";
		return "ListDispute";
	}
   
	public String check() throws IOException {
		
		String disputeid = req.getParameter("disputeid");
		//Integer disputeId=Integer.parseInt(disputeid);
		String result = Struts2Utils.getParameter("result");
		String userinfoId = Struts2Utils.getParameter("userinfoId");
		UserInfo userinfo=userInfoService.findById(Integer.parseInt(userinfoId));
		Dispute dispute = disputeService.get(Integer.parseInt(disputeid));
		dispute.setResult(result);
		dispute.setState("1");
		//dispute.setAdmin(userinfoId);
		dispute.setAdmin(userinfo);
		dispute.setCheckdate(dateFormat.format(now));
		disputeService.update(dispute);
        getResponse().setContentType("text/html;charset=UTF-8");
		PrintWriter pw=getResponse().getWriter();
        JSONObject json = new JSONObject();//将map对象转换成json类型数据
        json.put("isResult1", "false");
        pw.write(json.toString());
		pw.flush();
		pw.close();
	    //Struts2Utils.renderTrue();
//		messageService.sendMessage(messageService,"您的一条投诉信息已经处理，请查看！",userinfoId, //userinfo.getUserinfoId(), 
//				dispute.getUserInfo().getUserinfoId(),"disputeAction_viewdispute.action", 
//				"ordersonid", dispute.getOrder().getOrdersonId());
		//session.put("ordersonid",dispute.getOrder().getOrdersonId());
		//return "check";
		return null;
	}

	public String disputeinfo() {
		String ordersonId = ServletActionContext.getRequest().getParameter(
				"ordersonid");
		OrderSon orderson = orderSonService.get(Integer.parseInt(ordersonId));
		session.put("orderson", orderson);
		return "info";
	}

	public String disputeAdmin() {
		String ordersonid = "";
		if (ServletActionContext.getRequest().getParameter("ordersonid") != null) {
			ordersonid = ServletActionContext.getRequest().getParameter(
					"ordersonid");
		} else {
			ordersonid = session.get("ordersonid").toString();
		}
		Dispute dispute = disputeService.getByOrder(Integer
				.parseInt(ordersonid));
		if (dispute != null &&dispute.getDisputeid()>0 ) {
			if(dispute.getState().equals("0")){
				dispute.setResult("申诉正在处理中，请耐心等候！");
			}
			List<DisputeFile> list = disputeFileService.getlist(dispute
					.getDisputeid());
			if (list != null && list.size() > 0) {
				request.put("msgf", "");
			} else {
				request.put("msgf", "该申诉未上传附件");
			}
			request.put("DisputeFileList", list);
		}
		request.put("dispute", dispute);
		return "viewAdmin";
	}
	
	public String viewdispute() {

		Dispute dispute = disputeService.getByOrder(ordersonId);
		if (dispute != null &&dispute.getDisputeid()>0 ) {
			if(dispute.getState().equals("0")){
				dispute.setResult("申诉正在处理中，请耐心等候！");
			}
			jsonMap.put("dispute", dispute);
			//jsonMap.put("isResult", "true");
			return "viewdisputePhone";
		}
		else
		{
			jsonMap.put("isResult", "false");
			return "viewdisputePhone";
	}
}
	}
