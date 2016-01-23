package cn.xaut.common.security.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xaut.common.security.service.AuthorityService;
import cn.xaut.shop.pojo.Authority;

import com.opensymphony.xwork2.ActionSupport;

@Controller(value = "authorityAction")
@Scope(value = "prototype")
public class AuthorityAction extends ActionSupport {

	private static final long serialVersionUID = -5017900123264500113L;

	@Autowired
	private Authority authority;
	@Autowired
	private AuthorityService authorityService;

	private String message;
	private Map<String, Object> responseJson = new HashMap<String, Object>();

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public AuthorityService getAuthorityService() {
		return authorityService;
	}

	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
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

	public String create() {
		authorityService.addAuthority(authority);
		message = authority.getAuthorityName();
		return "createOK";
	}

	public String checkAuthorityName() {
		Authority authorityTemp = authorityService
				.getAuthorityByAuthorityName(authority.getAuthorityName());
		String isExsited = "true";
		if (authorityTemp != null) {
			// ע���û��Ѵ���
			isExsited = "true";
			responseJson.put("isExsited", isExsited);
		} else {
			isExsited = "false";
			responseJson.put("isExsited", isExsited);
		}
		return SUCCESS;
	}

}
