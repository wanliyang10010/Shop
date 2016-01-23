package cn.xaut.common.security.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xaut.common.security.domain.PageSec;
import cn.xaut.common.security.service.RoleService;
import cn.xaut.shop.pojo.Role;

import com.opensymphony.xwork2.ActionSupport;
@Controller(value="searchRoleAction")
@Scope(value="prototype")
public class SearchRoleAction extends ActionSupport implements SessionAware{

	protected Map<String,Object> session = null;
	
	@Autowired
	private RoleService roleService;
	private PageSec<Role> page = new PageSec<Role>();
	private Role role;
	
	private String selectId;
	private String queryItems;
	
	private String roleId;
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public PageSec getPage() {
		return page;
	}
	public void setPage(PageSec page) {
		this.page = page;
	}
	public String getSelectId() {
		return selectId;
	}
	public void setSelectId(String selectId) {
		this.selectId = selectId;
	}
	public String getQueryItems() {
		return queryItems;
	}
	public void setQueryItems(String queryItems) {
		this.queryItems = queryItems;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String search(){
		
		if(!selectId.equals("")){
			if(selectId.equals("roleName")){
				page = roleService.queryRoleByRoleNameForPage(queryItems,page.getPageSize(),page.getCurrentPage());
				return "list";
			}
			if(selectId.equals("description")){
				page = roleService.queryRoleByDescriptionForPage(queryItems,page.getPageSize(),page.getCurrentPage());
				return "list";
			}
			if(selectId.equals("allRole")){
				page = roleService.queryAllRoleForPage(page.getPageSize(), page.getCurrentPage());
				return "list";
			}
			return "error";
		}else{
			return "list";
		}
	}
	public String delete(){
		roleService.deleteRoleAnd_User_AuthorityById(Integer.parseInt(roleId));
		//page.setCurrentPage(1);
		//page.setPageSize(5);
		String result = search();
		return result;
	}
	
	public String alter(){
		session.put("selectId", selectId);
		session.put("queryItems", queryItems);
		session.put("page",page);
		role = roleService.getRoleById(Integer.parseInt(roleId));
		return "alter";
	}
	@SuppressWarnings("unchecked")
	public String update(){
		roleService.updataRole(role);
		/*setSelectId("allRole");
		page.setCurrentPage(1);
		page.setPageSize(5);*/
		selectId = (String) session.get("selectId");
		queryItems = (String) session.get("queryItems");
		page =  (PageSec<Role>) session.get("page");
		String result = search();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public String back(){
		selectId = (String) session.get("selectId");
		queryItems = (String) session.get("queryItems");
		page =  (PageSec<Role>) session.get("page");
		String result = search();
		return result;
	}
	
	
	
}
