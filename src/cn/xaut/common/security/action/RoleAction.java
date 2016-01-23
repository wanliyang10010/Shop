package cn.xaut.common.security.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xaut.common.security.service.RoleService;
import cn.xaut.shop.pojo.Role;

import com.opensymphony.xwork2.ActionSupport;

@Controller(value="roleAction")
@Scope(value="prototype")
public class RoleAction extends ActionSupport {

	private static final long serialVersionUID = -1545424672841889328L;
	@Autowired
	private Role role;
	@Autowired
	private RoleService roleService;
	
	private String message;
	
	private Map<String,Object> responseJson = new HashMap<String,Object>();

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public String getMessage() {
		return message;
	}
	
	public Map<String, Object> getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}

	public String create(){
		roleService.addRole(role);
		message = role.getRoleName();
		return "createOK";
	}
	
	
	public String checkRoleName(){
		Role roleTemp = roleService.getRoleByRoleName(role.getRoleName());
		String isExsited = "true";
		if(roleTemp != null){
			//ע���û��Ѵ���
			isExsited = "true";
			responseJson.put("isExsited", isExsited);	
		}else{
			isExsited = "false";
			responseJson.put("isExsited", isExsited);
		}
		return SUCCESS;
	}
	
}
