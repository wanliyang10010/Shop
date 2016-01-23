package cn.xaut.common.security.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xaut.common.security.service.AuthorityService;
import cn.xaut.common.security.service.ResourceService;
import cn.xaut.shop.pojo.Authority;
import cn.xaut.shop.pojo.Resource;

import com.opensymphony.xwork2.ActionSupport;
@Controller("returnAuthorityNameAction")
@Scope(value="prototype")
public class ReturnAuthorityNameAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = -3676685111479376977L;

	protected Map<String,Object> session = null;
	
	List<Authority> authoritiesList = new ArrayList<Authority>(); 
	List<Resource> resourcesList_L = new ArrayList<Resource>();
	List<Resource> resourcesList_R = new ArrayList<Resource>();
	
	
	@Autowired
	private AuthorityService authorityService;
	@Autowired
	private ResourceService resourceService;
	
	
	public List<Authority> getAuthoritiesList() {
		return authoritiesList;
	}
	public void setAuthoritiesList(List<Authority> authoritiesList) {
		this.authoritiesList = authoritiesList;
	}
	public AuthorityService getAuthorityService() {
		return authorityService;
	}
	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}
	
	public List<Resource> getResourcesList_L() {
		return resourcesList_L;
	}
	public void setResourcesList_L(List<Resource> resourcesList_L) {
		this.resourcesList_L = resourcesList_L;
	}
	public List<Resource> getResourcesList_R() {
		return resourcesList_R;
	}
	public void setResourcesList_R(List<Resource> resourcesList_R) {
		this.resourcesList_R = resourcesList_R;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	
	public String returnAuthorityName(){
		authoritiesList = authorityService.getAllAuthorities();
		resourcesList_R = resourceService.getAllResource();
		
		session.put("authoritiesList", authoritiesList);
		
		return SUCCESS;
	}
	
}
