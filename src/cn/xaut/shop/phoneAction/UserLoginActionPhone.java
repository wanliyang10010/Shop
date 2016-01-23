package cn.xaut.shop.phoneAction;



import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.xaut.common.security.service.UserSecurityService;
import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.Role;
import cn.xaut.shop.pojo.UserInfo;

import com.opensymphony.xwork2.ActionSupport;

public class UserLoginActionPhone extends BaseAction<UserInfo>{
	@Autowired
	private UserSecurityService userSecurityService;
	public String login(){
		UserInfo user = (UserInfo) session.get("user");
		List<Role> roles = userSecurityService.getRolesByUserId(user.getUserinfoId());
		if((roles != null)&&!(roles.isEmpty())){
			Iterator<Role> iter = roles.iterator();
			while(iter.hasNext()){
				Role role = iter.next();
				if("ROLE_User".equals(role.getRoleName())){
					//返回用户登录界面
					return "goUserlogin";
				}else if("ROLE_SuperUser".equals(role.getRoleName())){
					//返回超级管理员页面
					return "goSuperAdmin";
				} else if("ROLE_Admin".equals(role.getRoleName())){
					//返回客服页面
					return "goCustomService";
				}
			}
			request.put("msg","非系统用户，请勿登录");
			return "goError";
		}else{
			request.put("msg","非系统用户，请勿登录");
			return "goError";
		}
		
	}
	
}
