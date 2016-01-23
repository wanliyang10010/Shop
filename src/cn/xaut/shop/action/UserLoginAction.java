package cn.xaut.shop.action;



import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import cn.xaut.common.security.service.UserSecurityService;
import cn.xaut.shop.pojo.Role;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.util.Struts2Utils;

public class UserLoginAction extends BaseAction<UserInfo>{
	
	private static final long serialVersionUID = 1L;
	public static boolean isarrive = false;
	
	@Autowired
	private UserSecurityService userSecurityService;
	public String login(){
		
		if (UserLoginAction.isarrive) {
			
			HttpSession session = Struts2Utils.getSession();
			session.invalidate();
			return "time";
		}
		
		UserInfo user = (UserInfo) session.get("user");
		
		session.put("userinfo", user);
		session.put("userid", user.getUserinfoId());
		
		List<Role> roles = userSecurityService.getRolesByUserId(user.getUserinfoId());
		if((roles != null)&&!(roles.isEmpty())){
			Iterator<Role> iter = roles.iterator();
			while(iter.hasNext()){
				Role role = iter.next();
				session.put("role", role.getRoleName());//张祯添加用于判断当前用户角色色
				if("ROLE_SuperAdmin".equals(role.getRoleName())){
					//返回配置管理员登录页面
					return "goConfigureManagement";
				}else if("ROLE_User".equals(role.getRoleName())){
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
