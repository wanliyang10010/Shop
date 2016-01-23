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
@Controller("roleMapAuthority")
@Scope(value="prototype")
public class RoleMapAuthority extends ActionSupport implements SessionAware{

	protected Map<String,Object> session = null;
	
	private String roleId;
	private String[] authoritiesId_L;
	private String[] authoritiesId_R;
	
	List<Role> roleList = new ArrayList<Role>();
	List<Authority> authoritiesList_L = new ArrayList<Authority>();
	List<Authority> authoritiesList_R = new ArrayList<Authority>();
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private AuthorityService authorityService;
	
	

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String[] getAuthoritiesId_L() {
		return authoritiesId_L;
	}

	public void setAuthoritiesId_L(String[] authoritiesId_L) {
		this.authoritiesId_L = authoritiesId_L;
	}

	public String[] getAuthoritiesId_R() {
		return authoritiesId_R;
	}

	public void setAuthoritiesId_R(String[] authoritiesId_R) {
		this.authoritiesId_R = authoritiesId_R;
	}

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

	public String update(){
		
		Integer roleId_I = Integer.parseInt(roleId);
		List<Integer> authorityId_L_I = new ArrayList<Integer>();
		for(int i=0;i < authoritiesId_L.length;i++){
			authorityId_L_I.add(Integer.parseInt(authoritiesId_L[i]));
			
		}
		roleService.updateRoleWithAuthorities(roleId_I, authorityId_L_I);
		return SUCCESS;
		
	}
	
	public String leftList(){
		
		roleList = (List<Role>) session.get("roleList");
		//authoritiesList_R = (List<Authority>) session.get("authoritiesList_R");
		authoritiesList_R = authorityService.getAllAuthorities();
		
		authoritiesList_L = roleService.getAuthoritiesById(Integer.parseInt(roleId));
		if((authoritiesList_L != null)&&(authoritiesList_L.size() > 0)){
			for(Authority authorityTemp:authoritiesList_L){
				if(authoritiesList_R.contains(authorityTemp)){
					authoritiesList_R.remove(authorityTemp);
				}
			}
		}else{
			authoritiesList_L = new ArrayList<Authority>();
		}
		
		return "leftList";
		
	}

}
