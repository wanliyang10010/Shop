package cn.xaut.common.security.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xaut.common.security.service.RoleService;
import cn.xaut.common.security.service.UserSecurityService;
import cn.xaut.shop.pojo.Role;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.service.UserInfoService;

import com.opensymphony.xwork2.ActionSupport;

@Controller(value="returnUserAndRoleAction")
@Scope(value="prototype")

public class ReturnUserAndRoleAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = -8536347971983695659L;

	protected Map<String,Object> session = null;
	
	List<UserInfo> userList = new ArrayList<UserInfo>(); 
	List<Role> rolesList_L = new ArrayList<Role>();
	List<Role> rolesList_R = new ArrayList<Role>();
	
	@Autowired
	private UserSecurityService userSecurityService;
	@Autowired
	private RoleService roleService;
	
	
	public List<UserInfo> getUserList() {
		return userList;
	}

	public void setUserList(List<UserInfo> userList) {
		this.userList = userList;
	}

	public List<Role> getRolesList_L() {
		return rolesList_L;
	}

	public void setRolesList_L(List<Role> rolesList_L) {
		this.rolesList_L = rolesList_L;
	}

	public List<Role> getRolesList_R() {
		return rolesList_R;
	}

	public void setRolesList_R(List<Role> rolesList_R) {
		this.rolesList_R = rolesList_R;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
	public String returnUserAndRoles(){
		
		userList = userSecurityService.getAllUsers();
		rolesList_R = roleService.getAllRoles();
		
		session.put("userList", userList);
		//session.put("rolesList_R", rolesList_R);
		
		return SUCCESS;
	}

	
	
}
