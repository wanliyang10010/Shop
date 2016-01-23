package cn.xaut.common.security.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xaut.common.security.service.ResourceService;
import cn.xaut.shop.pojo.Resource;
import com.opensymphony.xwork2.ActionSupport;


@Controller(value="returnResourceString")
@Scope(value="prototype")

public class ReturnResourceString extends ActionSupport {

	private static final long serialVersionUID = 5275199893795114505L;

	private List<Resource> resourceStringList= new ArrayList<Resource>();
	
	private Resource resource;
	
	@Autowired
	private ResourceService resourceService;

	public List<Resource> getResourceStringList() {
		return resourceStringList;
	}

	public void setResourceStringList(List<Resource> resourceStringList) {
		this.resourceStringList = resourceStringList;
	}
	
	
	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public String execute(){
		try {
			resourceStringList = resourceService.getResourceStringOfAction();
		} catch (Exception e) {
			e.printStackTrace();
		}
		resource = new Resource();
		resource.setType("action");
		return SUCCESS;
	}

}
