package cn.xaut.shop.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import cn.xaut.common.security.service.UserSecurityService;
import cn.xaut.shop.pojo.CasUser;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.pojo.UserPoint;
import cn.xaut.shop.util.Struts2Utils;

import com.opensymphony.xwork2.ActionContext;

import edu.yale.its.tp.cas.client.filter.CASFilter;

public class UnifiedLogin extends BaseAction<UserInfo> {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	@Autowired
	private UserSecurityService userSecurityService;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String unifiedLogin(){
		//String usernameTemp = "qq123";
		String usernameTemp= (String) Struts2Utils.getSession().getAttribute(CASFilter.CAS_FILTER_USER);
		
		//String url = "http://202.118.89.129/dlmu_rest_webservice/000102?userid=" + usernameTemp + "&token=1";
		CasUser casUser = userSecurityService.getCasUser(usernameTemp);
		
		UserInfo userTemp=null;
		userTemp = userSecurityService.getUserByAccount(usernameTemp);
		if(userTemp == null){
			userTemp = new UserInfo();
			userTemp.setUsername(usernameTemp);
			userTemp.setPassword("123456");
			userTemp.setRegeditdate(dateFormat.format(now));
			userTemp.setState("0");
			userTemp.setRole("0");
			userTemp.setPoints(pointsRuleService.getBytype("个人", "注册"));
			if(casUser!=null){
				userTemp.setName(casUser.getXm());
			}
			userSecurityService.addUserwithRole(userTemp);
			session.put("userid", userTemp.getUserinfoId());
			session.put("userinfo", userTemp);
		}
		username = userTemp.getUsername();
		password = userTemp.getPassword();

		ActionContext ctx = ActionContext.getContext();       
		HttpServletRequest request =(HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);    
		HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE); 

		try {
			request.getRequestDispatcher("/frontLogin.action?username=" + username.toString() + "&password=" + password.toString()).forward(request,response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return null;
		//return "goLogin";
	}
	
	public void addpoints(Integer points) {
		UserInfo user = (UserInfo) session.get("userinfo");
		UserPoint userPoint = new UserPoint();
		userPoint.setUserinfo(user);
		userPoint.setOperateTime(dateFormat.format(now));
		userPoint.setPoint(points);
		userPoint.setPlusminus("+");
		userPoint.setContent("用户注册");
		userPointService.save(userPoint);// 保存会员积分表
	}
}
