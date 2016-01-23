package cn.xaut.common.security.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xaut.common.security.service.UserSecurityService;
import cn.xaut.shop.pojo.Role;
import cn.xaut.shop.pojo.UserInfo;

import com.opensymphony.xwork2.ActionSupport;

@Controller(value="myLoginAction")
@Scope(value="prototype")
public class MyLoginAction extends ActionSupport implements SessionAware{
	/*@Autowired
	private UserDetailsService userDetailsManager;
	@Autowired
	private AuthenticationManager authenticationManager;
	//private User user;
*/	private String account;
	private String password;
	
	private String msg;
	
	@Autowired
	private UserSecurityService userSecurityService;
	
	protected Map<String,Object> session = null;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String execute(){
		String showCheckCode = (String) session.get("showCheckCode");
		String SECURITY_LOGIN_EXCEPTION = "";
		account = (String) session.get("login_account");
		if(!(showCheckCode.equals("0"))){
			SECURITY_LOGIN_EXCEPTION = (String) session.get("SECURITY_LOGIN_EXCEPTION");
			msg = SECURITY_LOGIN_EXCEPTION;
		}

		return "failure";
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	/*public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/
	
	public String goIndexAdmin(){
		UserInfo user = (UserInfo) session.get("user");
		List<Role> roles = userSecurityService.getRolesByUserId(user.getUserinfoId());
		if((roles != null)&&!(roles.isEmpty())){
			Iterator<Role> iter = roles.iterator();
			while(iter.hasNext()){
				Role role = iter.next();
				if("ROLE_SuperAdmin".equals(role.getRoleName())){
					//返回配置管理员主页
					return "goIndexAdmin";
				}
			}
			msg = "该用户没有配置管理员的权限，请勿登录";
			return "failure";
		}else{
			msg = "该用户没有配置管理员的权限，请勿登录";
			return "failure";
		}
	}
	

}
