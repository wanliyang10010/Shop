package cn.xaut.common.security.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xaut.common.security.domain.PageSec;
import cn.xaut.common.security.service.ResourceService;
import cn.xaut.shop.pojo.Resource;

import com.opensymphony.xwork2.ActionSupport;
@Controller("searchDeleteResourceAction")
@Scope(value="prototype")
public class SearchDeleteResourceAction extends ActionSupport implements SessionAware{
	
	protected Map<String,Object> session = null;
	@Autowired
	private ResourceService resourceService;
	public PageSec<Resource> page = new PageSec<Resource>();
	private Resource resource;
	
	private String selectId;
	private String queryItems;
	
	private String resourceId;
	
	private List<Resource> resourceStringList= new ArrayList<Resource>();

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

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	
	public PageSec<Resource> getPage() {
		return page;
	}

	public void setPage(PageSec<Resource> page) {
		this.page = page;
	}

	
	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	

	public List<Resource> getResourceStringList() {
		return resourceStringList;
	}

	public void setResourceStringList(List<Resource> resourceStringList) {
		this.resourceStringList = resourceStringList;
	}
	
	
	

	public String search(){
		if(!selectId.equals("")){
			if(selectId.equals("resourceName")){
				page = resourceService.queryResourceByResourceNameForPage(queryItems, page.getPageSize(), page.getCurrentPage());
				return "list";
			}
			if(selectId.equals("resourceString")){
				page = resourceService.queryResourceByResourceStringForPage(queryItems, page.getPageSize(), page.getCurrentPage());
				return "list";
			}
			if(selectId.equals("description")){
				page = resourceService.queryResourceByDescriptionForPage(queryItems, page.getPageSize(), page.getCurrentPage());
				return "list";
			}
			if(selectId.equals("allResource")){
				page = resourceService.queryAllResourceForPage(page.getPageSize(), page.getCurrentPage());
				return "list";
			}
			return "error";
		}else{
			return "list";
		}
	}
	
	public String delete(){
		resourceService.deleteResourceAnd_AuthorityById(Integer.parseInt(resourceId));
		//page.setCurrentPage(1);
		//page.setPageSize(5);
		String result = search();
		/*if((page.getAllRow()) > 0 &&((page.getAllRow())%(page.getPageSize()))==0){
			page.setCurrentPage(page.getCurrentPage() - 1);
			result = search();
		}*/
		return result;
	}
	
	public String alter(){
		session.put("selectId", selectId);
		session.put("queryItems", queryItems);
		session.put("page",page);
		resource = resourceService.getResourceById(Integer.parseInt(resourceId));
		try {
			resourceStringList = resourceService.getResourceStringOfAction();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "alter";
	}
	
	@SuppressWarnings("unchecked")
	public String update(){
		resourceService.updateResource(resource);
		selectId = (String) session.get("selectId");
		queryItems = (String) session.get("queryItems");
		page = (PageSec<Resource>) session.get("page");
		String result = search();
		return result;
	}
	@SuppressWarnings("unchecked")
	public String back(){
		selectId = (String) session.get("selectId");
		queryItems = (String) session.get("queryItems");
		page = (PageSec<Resource>) session.get("page");
		String result = search();
		return result;
	}
	
	public String ResourceStringList(){
		if((resource.getType()).equals("action")){
			resourceStringList = resourceService.getResourceStringOfAction();	
		}
		if((resource.getType()).equals("url")){
			resourceStringList = resourceService.getResourceStringOfUrl();
		}
		return "resourceStringOK";
	}

}
