package cn.xaut.common.security.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xaut.common.security.domain.PageSec;
import cn.xaut.common.security.service.AuthorityService;
import cn.xaut.shop.pojo.Authority;

import com.opensymphony.xwork2.ActionSupport;

@Controller("searchDeleteAuthorityAction")
@Scope(value = "prototype")
public class SearchDeleteAuthorityAction extends ActionSupport implements SessionAware {
		
	protected Map<String, Object> session = null;

	@Autowired
	private AuthorityService authorityService;
	private PageSec<Authority> page = new PageSec<Authority>();
	private Authority authority;

	private String selectId;
	private String queryItems;

	private String authorityId;

	public PageSec<Authority> getPage() {
		return page;
	}

	public void setPage(PageSec<Authority> page) {
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

	public String getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public String search() {
		if (!selectId.equals("")) {
			if (selectId.equals("authorityName")) {
				page = authorityService.queryAuthorityByAuthorityNameForPage(
						queryItems, page.getPageSize(), page.getCurrentPage());
				return "list";
			}
			if (selectId.equals("description")) {
				page = authorityService.queryAuthorityByDescriptionForPage(
						queryItems, page.getPageSize(), page.getCurrentPage());
				return "list";
			}
			if (selectId.equals("allAuthority")) {
				page = authorityService.queryAllAuthorityForPage(
						page.getPageSize(), page.getCurrentPage());
				return "list";
			}
			return "error";
		} else {
			return "list";
		}
	}

	public String delete() {
		authorityService.deleteAuthorityAnd_Role_ResourceById(Integer
				.parseInt(authorityId));
		// page.setCurrentPage(1);
		// page.setPageSize(5);
		String result = search();
		return result;
	}

	public String alter() {
		session.put("selectId", selectId);
		session.put("queryItems", queryItems);
		session.put("page", page);
		authority = authorityService.getAuthorityById(Integer
				.parseInt(authorityId));
		return "alter";
	}

	@SuppressWarnings("unchecked")
	public String update() {
		authorityService.updateAuthority(authority);
		/*
		 * setSelectId("allAuthority"); page.setCurrentPage(1);
		 * page.setPageSize(5);
		 */
		selectId = (String) session.get("selectId");
		queryItems = (String) session.get("queryItems");
		page = (PageSec<Authority>) session.get("page");
		String result = search();
		return result;
	}

	@SuppressWarnings("unchecked")
	public String back() {
		selectId = (String) session.get("selectId");
		queryItems = (String) session.get("queryItems");
		page = (PageSec<Authority>) session.get("page");
		String result = search();
		return result;
	}

}
