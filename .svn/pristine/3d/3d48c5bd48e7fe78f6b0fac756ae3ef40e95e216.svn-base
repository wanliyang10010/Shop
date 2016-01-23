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

import com.opensymphony.xwork2.ActionSupport;
@Controller(value="userMapRole")
@Scope(value="prototype")
public class UserMapRole extends ActionSupport implements SessionAware{
	
	protected Map<String,Object> session = null;
	
	private String userId;
	private String[] rolesId_L;
	private String[] rolesId_R;
	
	List<Role> rolesList_L = new ArrayList<Role>();
	List<Role> rolesList_R = new ArrayList<Role>();
	List<UserInfo> userList = new ArrayList<UserInfo>(); 
	
	@Autowired
	private UserSecurityService userSecurityService;
	
	@Autowired
	private RoleService roleService;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String[] getRolesId_L() {
		return rolesId_L;
	}
	public void setRolesId_L(String[] rolesId_L) {
		this.rolesId_L = rolesId_L;
	}
	public String[] getRolesId_R() {
		return rolesId_R;
	}
	public void setRolesId_R(String[] rolesId_R) {
		this.rolesId_R = rolesId_R;
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
	
	public List<UserInfo> getUserList() {
		return userList;
	}
	public void setUserList(List<UserInfo> userList) {
		this.userList = userList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
	
	public String update(){
		Integer userId_I = Integer.parseInt(userId);
		List<Integer> rolesId_L_I = new ArrayList<Integer>();
		
		for(int i=0;i < rolesId_L.length;i++){
			rolesId_L_I.add(Integer.parseInt(rolesId_L[i]));	
		}
		userSecurityService.updateUserWithRoles(userId_I, rolesId_L_I);
		
		return SUCCESS;
	}
	
	public String leftList(){
		userList = (List<UserInfo>) session.get("userList");
		/*List<Role> roleList_temp = (List<Role>) session.get("rolesList_R");
		rolesList_R = (List<Role>) session.get("rolesList_R");*/
		rolesList_R = roleService.getAllRoles();
		
		rolesList_L = userSecurityService.getRolesByUserId(Integer.parseInt(userId));
		
		if((rolesList_L != null)&&(rolesList_L.size() > 0)){
			for(Role roletemp:rolesList_L){
				if(rolesList_R.contains(roletemp)){
					rolesList_R.remove(roletemp);
				}
			}
		}else{
			rolesList_L = new ArrayList<Role>();
		}
		
		
		return "leftList";
		
	}
}
