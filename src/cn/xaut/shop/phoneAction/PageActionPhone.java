package cn.xaut.shop.phoneAction;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.UserInfo;

public class PageActionPhone extends BaseAction<UserInfo> {

	private static final long serialVersionUID = 6558070072978821855L;

	private Page<UserInfo> page = new Page<UserInfo>();
	
	
	/**
	 * 查询全部
	 * @return
	 */
	public String list() {
		page = pageService.searchUser(page);
		request.put("page", page);
		return "list";
	}


	public String input() {
		
		if(null == model.getUserinfoId()){
			return "save";
		}else {
			return "update";	
		}
	}
	
	public String save() {
		
		// String loginName = Struts2Utils.getParameter("loginName");
		// String password = Struts2Utils.getParameter("password");
		// User user = new User();
		
		System.out.println(model.getUsername());
		System.out.println(model.getPassword());
		
//		user.setLoginName(loginName);
//		user.setPassword(password);
		userInfoService.save(model);
		
		return "list";
	}

	public String update(){
		
//		String id = Struts2Utils.getParameter("id");
//		String loginName = Struts2Utils.getParameter("loginName");
//		String password = Struts2Utils.getParameter("password");
		
//		UserInfo user = pageService.findUserById(model.getUserinfoId());
//		
//		user.setUsername(model.getUsername());
//		user.setPassword(model.getPassword());
		
		
		
		pageService.update(model);
		
		return "list";
	}
	
	public String delete(){
		
		pageService.delete(model.getUserinfoId());
		return "list";
	}

	public Page<UserInfo> getPage() {
		return page;
	}
}
