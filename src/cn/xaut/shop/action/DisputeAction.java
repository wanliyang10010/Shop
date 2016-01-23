package cn.xaut.shop.action;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.pojo.Dispute;
import cn.xaut.shop.pojo.DisputeFile;
import cn.xaut.shop.pojo.OrderSon;
import cn.xaut.shop.pojo.UserInfo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DisputeAction extends BaseAction<Dispute> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2751434195504573665L;
	DisputeFileAction disputeFile = new DisputeFileAction();
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
		UserInfo userinfo = (UserInfo) session.get("userinfo");
		OrderSon orderson = (OrderSon) session.get("orderson");
		
		String reason = ServletActionContext.getRequest().getParameter(
				"reason");
		String json = ServletActionContext.getRequest().getParameter(
				"filecontent");
		model.setInfodate(dateFormat.format(now));
		model.setState("0");
		model.setAccuser(userinfo.getUsername());
		model.setSccused(orderson.getOrder().getShopname());//shopName
		model.setOrderson(orderson.getGoodsName());//goodsNmae
		model.setContent(reason);
		model.setUserInfo(userinfo);
		model.setShop(orderson.getOrder().getShop());
		model.setOrder(orderson);
		List<DisputeFile> list = new ArrayList<DisputeFile>();
		if (!json.trim().equals("")) {
			list = getlist(json);
		}
		model=disputeService.saveDispute(model,messageService,disputeFileService,list,orderSonService,orderson);
//		disputeService.save(model);
//		messageService.sendMessage(messageService,"新收到一条投诉信息需处理！", userinfo.getUserinfoId(), 0,
//				"disputeFileAction_listfile.action", "disputeId", model.getDisputeid());
//		addFile(json,model);
//		orderson.setIsdispute("1");
//		orderSonService.update(orderson);
		session.remove("file");
		session.put("ordersonid", orderson.getOrdersonId());
		request.put("msg", "上传成功");
		return "add";
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
	
	public String query()
	{
		page = disputeService.queryAll(page);
		if (page != null && page.getTotalItems() > 0) {
			request.put("msg", "");
		} else {
			request.put("msg", "没有符合条件的记录，请重新查询");
			//page = disputeService.queryAll(page);
		}
		request.put("page", page);
		return "list";
	}
	
	public String searchDate() {
		String dtstart = ServletActionContext.getRequest()
				.getParameter("dtstart").replace("-", "/");
		String dtend = ServletActionContext.getRequest().getParameter("dtend")
				.replace("-", "/");
		dtstart=dtstart+" 00:00:00";
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

	public String search() {
		String stype = ServletActionContext.getRequest().getParameter("stype");
		String key = ServletActionContext.getRequest().getParameter("keyword");
		page = disputeService.getlist(page, key, stype);
		if (page != null && page.getTotalItems() > 0) {
			request.put("msg", "");
		} else {
			request.put("msg", "没有符合条件的记录，请重新查询");
		}
		request.put("page", page);
		return "list";
	}

	public String check() {
		String disputeId = ServletActionContext.getRequest().getParameter(
				"disputeId");
		String result = ServletActionContext.getRequest()
				.getParameter("result");
		UserInfo userinfo = (UserInfo) session.get("userinfo");
		Dispute dispute = disputeService.get(Integer.parseInt(disputeId));
		dispute.setResult(result);
		dispute.setState("1");
		dispute.setAdmin(userinfo);
		dispute.setCheckdate(dateFormat.format(now));
		//disputeService.update(dispute);
		disputeService.updateDispute(dispute,messageService);
//		messageService.sendMessage(messageService,"您的一条投诉信息已经处理，请查看！", userinfo.getUserinfoId(), 
//				dispute.getUserInfo().getUserinfoId(),"disputeAction_viewdispute.action", 
//				"ordersonid", dispute.getOrder().getOrdersonId());
		session.put("ordersonid",dispute.getOrder().getOrdersonId());
		return "check";
	}

	public String disputeinfo() {
		String ordersonId = ServletActionContext.getRequest().getParameter(
				"ordersonid");
		OrderSon orderson = orderSonService.get(Integer.parseInt(ordersonId));
		if(orderson.getIsdispute()!=null&&orderson.getIsdispute().equals("1"))
		{
			Dispute dispute = disputeService.getByOrder(Integer
					.parseInt(ordersonId));
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
			return "view";
		}
		else
		{
			session.put("orderson", orderson);
			return "info";
		}
		
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
		return "view";
	}
}
