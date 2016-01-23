package cn.xaut.shop.action;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import cn.xaut.common.security.service.RoleService;
import cn.xaut.common.security.service.UserSecurityService;
import cn.xaut.shop.pojo.Role;
import cn.xaut.shop.pojo.UserInfo;

public class SuperUserAction extends BaseAction<UserInfo>{
	private Map<String,Object> responseJson = new HashMap<String,Object>();
	public Map<String, Object> getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}
	/**
	 * 
	 */
	public static boolean isarrive = false;
	private static final long serialVersionUID = 1454044296114474715L;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserSecurityService userSecurityService;
	
	//登录
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
//			UserInfo userInfo = userInfoService
//					.get((Integer) session.get("userid"));
//			System.out.println("message---"+userInfo.getRole());
//			userInfo.setPassword(model.getPassword());
//			//userInfo.setRole("3");
//			userInfoService.update(userInfo);
//			return "PwdResetBack";
			String userid = ServletActionContext.getRequest().getParameter(
					"userinfoId");
			String password = ServletActionContext.getRequest().getParameter(
					"password");
			UserInfo userInfo = userInfoService.get(Integer.parseInt(userid));
			userInfo.setPassword(password);
			userInfoService.update(userInfo);
			jsonMap.put("data", "right");
		    return "json";
		}
		
		public String clearBack()
		{
			session.remove("userid");
			session.remove("userinfo");
			return "clearBack";
		}
		
		//登录
		public String loginBack() {
			
			if(AdminUserAction.isarrive)
			{
				return "time";
			}
			
			//UserInfo user = userInfoService.loginBack(model.getUsername(),model.getPassword());
			//System.out.println(model.getUsername()+"--"+model.getPassword());
			UserInfo user = (UserInfo) session.get("user");
			if (user != null && !user.getUserinfoId().equals("")) {
				session.put("userinfo", user);
				session.put("userid", user.getUserinfoId());
				return "loginBack";
			} else {
				request.put("msg", "登陆失败。用户名或密码不正确，请重新输入");
				return "loginfailed";
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
		
		   public String add()
		   {      
			   String username= ServletActionContext.getRequest().getParameter("username");
			   String password= ServletActionContext.getRequest().getParameter("password");
			   UserInfo userinfo=userInfoService.getUser(username);
			      if(userinfo!=null&&userinfo.getUserinfoId()>0)
				  {
			    	  jsonMap.put("data", "wrong");
				  }
				  else
				  {
					  UserInfo userinfoAdd=new UserInfo();
					  Date now = new Date();
						SimpleDateFormat dateFormat = new SimpleDateFormat(
								"yyyy/MM/dd HH:mm:ss");
						userinfoAdd.setUsername(username);
						userinfoAdd.setPassword(password);
						userinfoAdd.setRegeditdate(dateFormat.format(now));
						userinfoAdd.setState("0");
						userinfoAdd.setRole("2");
					  userInfoService.save(userinfoAdd);
					// 角色部分-2015-09-08
					Role role = roleService.getRoleByRoleName("ROLE_Admin");
					List<Integer> roleIdList = new ArrayList<Integer>();
					roleIdList.add(role.getId());
					userSecurityService.updateUserWithRoles(userinfoAdd.getUserinfoId(), roleIdList);
					//角色部分结束
					jsonMap.put("data", "right");
				  }
			      
				  return "json"; 
		   }

		   
		 //更新用户
		    public String updateState() {
		    	String id= ServletActionContext.getRequest().getParameter("itemId");
			    UserInfo userInfo=userInfoService.get(Integer.parseInt(id));
				if(userInfo.getState().equals("0"))
				{
					userInfo.setState("1");
				}
				else
				{
					userInfo.setState("0");
				}
				userInfoService.update(userInfo);
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

		   
		   /* 新添加的方法 代替list方法 */
		   public String listAdmin(){
			   
			   String key= ServletActionContext.getRequest().getParameter("keyword");
				  page=userInfoService.getListAdminUserRole(page,key);
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
		   
 		   /* 新添加的方法 代替qury方法 */
		   public String queryAdmin(){
			   page=userInfoService.queryAllAdminUseRole(page);
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

}
