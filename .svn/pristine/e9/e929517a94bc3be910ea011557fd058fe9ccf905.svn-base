package cn.xaut.common.security.action;

import java.util.ArrayList;
import java.util.HashMap;
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

@Controller("authorityMapResource")
@Scope(value="prototype")

public class AuthorityMapResource extends ActionSupport implements SessionAware{
	

	private static final long serialVersionUID = -7894775095368207382L;

	protected Map<String,Object> session = null;
	
	@Autowired
	private AuthorityService authorityService;
	@Autowired
	private ResourceService resourceService;
	
	private String authorityId;
	private String[] resourceId_L;
	private String[] resourceId_R;
	
	
	List<Authority> authoritiesList = new ArrayList<Authority>(); 
	List<Resource> resourcesList_L = new ArrayList<Resource>();
	List<Resource> resourcesList_R = new ArrayList<Resource>();
	
	private Map<String,Object> responseJson = new HashMap<String,Object>();
	

	public String getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

	public String[] getResourceId_L() {
		return resourceId_L;
	}

	public void setResourceId_L(String[] resourceId_L) {
		this.resourceId_L = resourceId_L;
	}

	public String[] getResourceId_R() {
		return resourceId_R;
	}

	public void setResourceId_R(String[] resourceId_R) {
		this.resourceId_R = resourceId_R;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<Authority> getAuthoritiesList() {
		return authoritiesList;
	}

	public void setAuthoritiesList(List<Authority> authoritiesList) {
		this.authoritiesList = authoritiesList;
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

	public Map<String, Object> getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}

	public String update(){
		Integer authorityId_I = Integer.parseInt(authorityId);
		List<Integer> resourceId_L_I = new ArrayList<Integer>();	
		for(int i=0;i < resourceId_L.length;i++){
			resourceId_L_I.add(Integer.parseInt(resourceId_L[i]));
			
		}
		authorityService.updateAuthorityWithResources(authorityId_I, resourceId_L_I);
		return SUCCESS;	
	}
	
	
	public String leftList(){
		authoritiesList = (List<Authority>) session.get("authoritiesList");
		//resourcesList_R = (List<Resource>) session.get("resourcesList_R");
		resourcesList_R = resourceService.getAllResource();
		resourcesList_L = authorityService.getResourcesByAuthorityId(Integer.parseInt(authorityId));
		if((resourcesList_L != null)&&(resourcesList_L.size() > 0)){
			for(Resource resourceTemp:resourcesList_L){
				if(resourcesList_R.contains(resourceTemp)){
					resourcesList_R.remove(resourceTemp);
				}
			}
		}else{
			resourcesList_L = new ArrayList<Resource>();
		}
		/*responseJson.put("resourcesList_L", resourcesList_L);
		responseJson.put("resourcesList_R", resourcesList_R);*/
		return "leftList";
	}
	
}
