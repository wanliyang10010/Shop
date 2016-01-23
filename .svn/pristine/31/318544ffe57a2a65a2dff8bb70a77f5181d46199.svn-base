package cn.xaut.common.security.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xaut.common.security.service.ResourceService;
import cn.xaut.shop.pojo.Resource;

import com.opensymphony.xwork2.ActionSupport;

@Controller(value = "resourceAction")
@Scope(value = "prototype")
public class ResourceAction extends ActionSupport {

	@Autowired
	private Resource resource;

	@Autowired
	private ResourceService resourceService;
	private Map<String, Object> responseJson = new HashMap<String, Object>();
	private List<Resource> resourceStringList = new ArrayList<Resource>();

	private String message;

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public String getMessage() {
		return message;
	}

	/*
	 * public ResourceService getResourceService() { return resourceService; }
	 * 
	 * public void setResourceService(ResourceService resourceService) {
	 * this.resourceService = resourceService; }
	 */

	public Map<String, Object> getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}

	public void setResourceStringList(List<Resource> resourceStringList) {
		this.resourceStringList = resourceStringList;
	}

	public List<Resource> getResourceStringList() {
		return resourceStringList;
	}

	public String create() {
		resourceService.addResource(resource);
		message = resource.getResourceName();
		return "createOK";
	}

	public String checkResourceName() {
		Resource resourceTemp = resourceService
				.getResourceByResourceName(resource.getResourceName());
		String isExsited = "true";
		if (resourceTemp != null) {
			// ע���û��Ѵ���
			isExsited = "true";
			responseJson.put("isExsited", isExsited);
		} else {
			isExsited = "false";
			responseJson.put("isExsited", isExsited);
		}
		return SUCCESS;
	}

	public String ResourceStringList() {
		if ((resource.getType()).equals("action")) {
			resourceStringList = resourceService.getResourceStringOfAction();
		}
		if ((resource.getType()).equals("url")) {
			resourceStringList = resourceService.getResourceStringOfUrl();
		}
		// responseJson.put("resourceStringList", resourceStringList);
		return "resourceStringOK";
	}
	
	/**
	 * 添加所有资源,donglei
	 */
	// public String addAllResouces()
	// {
	// resourceService.insertAllResources();
	// return "resourceStringOK";
	// }
}
