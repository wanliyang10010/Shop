package cn.xaut.common.security.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.xaut.common.security.domain.PageSec;
import cn.xaut.common.security.service.UserSecurityService;
import cn.xaut.shop.pojo.UserInfo;

import com.opensymphony.xwork2.ActionSupport;
@Controller("searchDeleteUserAction")
@Scope(value="prototype")
public class SearchDeleteUserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Autowired
	private UserSecurityService userSecurityService;
	PageSec<UserInfo> page = new PageSec<UserInfo>();
	
	private String selectId;
	private String queryItems;
	private String userId;

	public PageSec<UserInfo> getPage() {
		return page;
	}

	public void setPage(PageSec<UserInfo> page) {
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String search(){
		if(!selectId.equals("")){
			
			if(selectId.equals("account")){
				page = userSecurityService.queryUserByAccountForPage(queryItems, page.getPageSize(), page.getCurrentPage());
			}
			
			if(selectId.equals("allUser")){
				page = userSecurityService.queryAllUserForPage(page.getPageSize(), page.getCurrentPage());
			}
			
			// if(selectId.equals("description")){
			//
			// }
			return "list";
			//return "error";
		}
		else{
			return "list";
		}
	}
	
	public String delete(){
		
		//目前先不删除
		//删除用户会带来很多级联的问题
		userSecurityService.deleteUserAnd_RoleById(Integer.parseInt(userId));
		page.setCurrentPage(1);
		page.setPageSize(5);
		String result = search();
		return result;
	}
	

}
