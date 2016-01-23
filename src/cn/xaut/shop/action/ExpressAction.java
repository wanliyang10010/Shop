package cn.xaut.shop.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import cn.xaut.shop.pojo.Express;
import cn.xaut.shop.pojo.UserInfo;

public class ExpressAction extends BaseAction<Express> {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest req = ServletActionContext.getRequest();

	public String save() {
		UserInfo user = (UserInfo) session.get("userinfo");
		Date now = new Date();
		model.setUserinfo(user);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.setApplyTime(dateFormat.format(now));
		model.setState("0");
		expressService.save(model);	
		return "viewExpressRedirect";
	}

	// 查看时查找记录
	public String searchViewList() {
		page = expressService.getViewList(page,fromdate(), todate());
		if (page == null || page.getTotalItems() == 0) {
			request.put("msg_searchViewList", "暂无数据！");
		}
		request.put("page", page);	
	    return "viewExpress";
	}
	
	public String searchAlterList() {
		UserInfo user = (UserInfo) session.get("userinfo");
		int userid = user.getUserinfoId();
		page = expressService.getAlterList(page,userid, fromdate(), todate());
		if (page == null || page.getTotalItems() == 0) {
			request.put("msg_searchAlterList", "暂无数据！");
		}
		request.put("page", page);
	    return "alterExpress";
	}
	
	public String delete() {
		int id = model.getExpressId();
		Express model2=expressService.get(id);
		if(!model2.getState().equals("0")){
			return "reOperation";
		}
		
		model2.setState("1");
		expressService.update(model2);
		
		request.put("msg_alterover", "删除成功！");
		return "alterExpressRedirect";
	}
	
	public String fromdate(){
		String fromdate = req.getParameter("fromdate");
		if (fromdate == null || fromdate.equals("")) {
			fromdate = "2015-01-01";
		}
		return fromdate;
	}
	public String todate(){
		String todate = req.getParameter("todate");
		if (todate == null || todate.equals("")) {
			todate = "2115-01-01";
		}
		return todate;
	}
}
