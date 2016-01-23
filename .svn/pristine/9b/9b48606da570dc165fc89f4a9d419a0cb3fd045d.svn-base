package cn.xaut.common.security.action;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import cn.xaut.common.security.service.ResourceService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SecurityBaseAction<T> extends ActionSupport  implements ModelDriven<T>,
	RequestAware, SessionAware, ApplicationAware {
	
	private static final long serialVersionUID = 1L;
	@SuppressWarnings({"unchecked" })
	public SecurityBaseAction() {
		try {
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	protected T model = null;
	public T getModel() {
		return model;
	}

	protected Map<String ,Object> jsonMap = new HashMap<String, Object>();
	protected Map<String, Object> request = null;
	protected Map<String, Object> session = null;
	protected Map<String, Object> application = null;
	
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}
	
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session =session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	// -----------------Service----------
	
	protected ResourceService resourceService = null;
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	

}
