package cn.xaut.common.security.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xaut.common.security.service.AuthorityService;
import cn.xaut.common.security.service.RoleService;
import cn.xaut.shop.pojo.Authority;
import cn.xaut.shop.pojo.Role;

import com.opensymphony.xwork2.ActionSupport;

@Controller("returnRoleAndAuthorityAction")
@Scope(value="prototype")
public class ReturnRoleAndAuthorityAction extends ActionSupport  implements SessionAware{
	

	private static final long serialVersionUID = -1608048427513834636L;

	protected Map<String,Object> session = null;
	
	List<Role> roleList = new ArrayList<Role>();
	List<Authority> authoritiesList_L = new ArrayList<Authority>();
	List<Authority> authoritiesList_R = new ArrayList<Authority>();
	
	
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private AuthorityService authorityService;
	
	

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<Authority> getAuthoritiesList_L() {
		return authoritiesList_L;
	}

	public void setAuthoritiesList_L(List<Authority> authoritiesList_L) {
		this.authoritiesList_L = authoritiesList_L;
	}

	public List<Authority> getAuthoritiesList_R() {
		return authoritiesList_R;
	}

	public void setAuthoritiesList_R(List<Authority> authoritiesList_R) {
		this.authoritiesList_R = authoritiesList_R;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	public String returnRoleAndAuthorities(){
		roleList = roleService.getAllRoles();
		
		authoritiesList_R = authorityService.getAllAuthorities();
		
		session.put("roleList", roleList);
		//session.put("authoritiesList_R", authoritiesList_R);
		
		return SUCCESS;	
	}
	
}
