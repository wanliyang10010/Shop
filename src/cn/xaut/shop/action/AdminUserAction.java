package cn.xaut.shop.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import cn.xaut.common.security.service.RoleService;
import cn.xaut.common.security.service.UserSecurityService;
import cn.xaut.shop.pojo.Role;
import cn.xaut.shop.pojo.UserInfo;

public class AdminUserAction extends BaseAction<UserInfo>{
	/**
	 * 
	 */
	public static boolean isarrive = false;
	private static final long serialVersionUID = -8929560443468375664L;
	
	@Autowired
	private RoleService roleService;

	@Autowired
	private UserSecurityService userSecurityService;
	
	public String save() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		
		model.setRegeditdate(dateFormat.format(now));
		model.setState("0");
		model.setRole("2");
		userInfoService.save(model);
		
		// 角色部分-2015-09-08
		Role role = roleService.getRoleByRoleName("ROLE_User");
		List<Integer> roleIdList = new ArrayList<Integer>();
		roleIdList.add(role.getId());
		userSecurityService.updateUserWithRoles(model.getUserinfoId(), roleIdList);
		//角色部分结束
		
		session.put("userid", model.getUserinfoId());
		session.put("userinfo", model);
		return "UserAdd";
	}
	
	public String checkuser() {
		UserInfo user = userInfoService.getCheckAdmin(model.getUsername());
		if (user != null && !user.getUserinfoId().equals("")) {
			System.out.println(user.getUsername());
			request.put("msg", "该用户名已注册");
		} else {
			request.put("msg", "该用户名可用");
		}
		return "checkUser";
	}
	
	//超级管理员修改个人信息等函数
		public String MessageRBack()
		{
			String userid= ServletActionContext.getRequest().getParameter("userinfoid");
			UserInfo userinfo=userInfoService.get(Integer.parseInt(userid));
			request.put("userinfo", userinfo);
			return "MesResetBack";
		}
		
		public String checkPWDBack() {
			UserInfo userInfo=userInfoService.get((Integer) session.get("userid"));
			String paswsword= ServletActionContext.getRequest().getParameter("oldpassword");
			if (userInfo.getPassword().equals(paswsword)) {
				jsonMap.put("data", "right");
			}
			else
			{
				jsonMap.put("data", "wrong");
			}
			return "json";
		}
		
		public String viewmessageBack()
		{
			UserInfo userInfo=(UserInfo)session.get("userinfo");
			request.put("userinfo", userInfo);
			return "viewmessageBack";
		}
		
		public String updatePWDBack()
		{
			String userid = ServletActionContext.getRequest().getParameter(
					"userinfoId");
			String password = ServletActionContext.getRequest().getParameter(
					"password");
			UserInfo userInfo = userInfoService.get(Integer.parseInt(userid));
			userInfo.setPassword(password);
			userInfoService.update(userInfo);
			jsonMap.put("data", "right");
		    return "json";
//			UserInfo userInfo = userInfoService
//					.get((Integer) session.get("userid"));
//			System.out.println("message---"+userInfo.getRole());
//			userInfo.setPassword(model.getPassword());
//			//userInfo.setRole("3");
//			userInfoService.update(userInfo);
//			return "PwdResetBack";
		}
		
		public String clearBack()
		{
			session.remove("userid");
			session.remove("userinfo");
			return "clearBack";
		}
		
		
		/*public String loginBack() {
			
			if(AdminUserAction.isarrive)
			{
				return "time";
			}
			
			UserInfo user = userInfoService.loginBack(model.getUsername(),model.getPassword());
			if (user != null && !user.getUserinfoId().equals("")) {
				System.out.println(user.getUsername()+"--"+user.getState());
				if(user.getState().equals("1"))
				{
					System.out.println("状态"+user.getState());
					request.put("msg", "登陆失败。该账户已被管理员禁用！");
					return "loginfailed";
				}
				else{
				session.put("userinfo", user);
				session.put("userid", user.getUserinfoId());
				return "loginBack";
				}
			} else {
				request.put("msg", "登陆失败。用户名或密码不正确，请重新输入");
				return "loginfailed";
			}
		}*/
		//登录
		public String loginAdmin() {
			
			if(AdminUserAction.isarrive)
			{
				return "time";
			}
			
			//UserInfo user = userInfoService.loginAdmin(model.getUsername(),model.getPassword());
			//System.out.println(model.getUsername()+"--"+model.getPassword());
			UserInfo user = (UserInfo) session.get("user");
			if (user != null && !user.getUserinfoId().equals("")) {
				if(user.getState().equals("1"))
				{
					System.out.println("状态"+user.getState());
					request.put("msg", "登陆失败。该账户已被管理员禁用！");
					return "loginfailedAdmin";
				}
				else{
				session.put("userinfo", user);
				session.put("userid", user.getUserinfoId());
				Integer count=messageService.getMessageCount(0);
				session.put("MessageCount", count);
				return "loginAdmin";
				}
			} else {
				request.put("msg", "登陆失败。用户名或密码不正确，请重新输入");
				return "loginfailedAdmin";
			}
		}
		
		public String updateRBack() {
			UserInfo userInfo = userInfoService.getAdmin((Integer) session.get("userid"));
			System.out.println("message---"+userInfo.getRole());
			userInfo.setAddress(model.getAddress());
			userInfo.setBdate(model.getBdate());
			userInfo.setMail(model.getMail());
			userInfo.setName(model.getName());
			userInfo.setTelephone(model.getTelephone());
			//userInfo.setState("0");
			//userInfo.setRole("3");
			userInfoService.update(userInfo);
			session.put("userinfo", userInfo);
			session.put("userid", userInfo.getUserinfoId());
			return "updateuserBack";
		}
		
		public String updateUser() {
			UserInfo userInfo = userInfoService.get(model.getUserinfoId());
			userInfo.setAddress(model.getAddress());
			userInfo.setBdate(model.getBdate());
			userInfo.setMail(model.getMail());
			userInfo.setName(model.getName());
			userInfo.setTelephone(model.getTelephone());
			userInfoService.update(userInfo);
			jsonMap.put("data", "right");
			return "json";
		}

		
		//管理员添加客服
		   public String add()
		   {      
			   UserInfo userinfo=userInfoService.getCheckAdmin(model.getUsername());
			      if(userinfo!=null&&userinfo.getUserinfoId()>0)
				  {
					  request.put("msgjudge", "该项已存在，不能重复添加"); 
					  request.put("page", page);
					  return "list";   
				  }
				  else
				  {
					  Date now = new Date();
						SimpleDateFormat dateFormat = new SimpleDateFormat(
								"yyyy/MM/dd HH:mm:ss");
					  model.setRegeditdate(dateFormat.format(now));
					  model.setState("0");
					  model.setRole("2");
					  userInfoService.save(model);
					// 角色部分-2015-09-08
					Role role = roleService.getRoleByRoleName("ROLE_Admin");
					List<Integer> roleIdList = new ArrayList<Integer>();
					roleIdList.add(role.getId());
					userSecurityService.updateUserWithRoles(model.getUserinfoId(), roleIdList);
					//角色部分结束
					
				  }
				  return "query";   
		   }
		   
		   public String update()
		   {
			    String id= ServletActionContext.getRequest().getParameter("itemId");
			    UserInfo userinfo=userInfoService.get(Integer.parseInt(id));
			    userinfo.setPassword(model.getPassword());
				userInfoService.update(userinfo);
				return "query";   
		   }
		   
		   public String list()
		   {
			  String key= ServletActionContext.getRequest().getParameter("keyword");
			  page=userInfoService.getListAdmin(page,key);
			  if(page!=null&&page.getTotalItems()>0)
			  {
				  request.put("msg", "");
			  }
			  else
			  {
				  request.put("msg", "没有符合条件的记录，请重新查询");
			  }
			request.put("page", page);
			  return "list";   
		   }
		   
		   public String qury()
		   {
			  page=userInfoService.queryAllAdmin(page);
			  if(page!=null&&page.getTotalItems()>0)
			  {
				  request.put("msg", "");
			  }
			  else
			  {
				  request.put("msg", "没有符合条件的记录，请重新查询");
			  }
			request.put("page", page);
			  return "list";   
		   }
		   
		   public String delete()
		   {
				 String id= ServletActionContext.getRequest().getParameter("itemId");
				 userInfoService.delete(Integer.parseInt(id));
				 return "query";   
		   }
		   
		   public String resetPWD()
			{
			   String userinfoId= ServletActionContext.getRequest().getParameter("userinfoId");
			   String password= ServletActionContext.getRequest().getParameter("password");
			   UserInfo userinfo=userInfoService.get(Integer.parseInt(userinfoId));
			   userinfo.setPassword(password);
			   userInfoService.update(userinfo);
			   jsonMap.put("data", "right");
			   return "json";
			}
		   
		   public String PwdChange()
		   {
				 return "pwdchange";   
		   }
}
