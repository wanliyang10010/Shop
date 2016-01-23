package cn.xaut.shop.phoneAction;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import org.springframework.beans.factory.annotation.Autowired;
import cn.xaut.shop.util.Struts2Utils;
import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.Role;
import cn.xaut.shop.pojo.UserInfo;

import cn.xaut.common.security.service.RoleService;
import cn.xaut.common.security.service.UserSecurityService;

public class SuperUserActionPhone extends BaseAction<UserInfo>{
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
			UserInfo userInfo = userInfoService
					.get((Integer) session.get("userid"));
			System.out.println("message---"+userInfo.getRole());
			userInfo.setPassword(model.getPassword());
			//userInfo.setRole("3");
			userInfoService.update(userInfo);
			return "PwdResetBack";
		}
		
		public String clearBack()
		{
			session.remove("userid");
			session.remove("userinfo");
			return "clearBack";
		}
		
		//登录
		public String loginBack() {
			
			if(AdminUserActionPhone.isarrive)
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
		/*
		public String loginAdmin() {
			
			if(AdminUserAction.isarrive)
			{
				return "time";
			}
			
			UserInfo user = userInfoService.loginAdmin(model.getUsername(),model.getPassword());
			System.out.println(model.getUsername()+"--"+model.getPassword());
			if (user != null && !user.getUserinfoId().equals("")) {
				session.put("userinfo", user);
				session.put("userid", user.getUserinfoId());
				return "loginAdmin";
			} else {
				request.put("msg", "登陆失败。用户名或密码不正确，请重新输入");
				return "loginfailedAdmin";
			}
		}
		*/
		
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
		
//		   public String add()
//		   {      
//			   UserInfo userinfo=userInfoService.getCheckAdmin(model.getUsername());
//			      if(userinfo!=null&&userinfo.getUserinfoId()>0)
//				  {
//					  request.put("msgjudge", "该用户已存在，不能重复添加"); 
//					  request.put("page", page);
//					  return "list";   
//				  }
//				  else
//				  {
//					  Date now = new Date();
//						SimpleDateFormat dateFormat = new SimpleDateFormat(
//								"yyyy/MM/dd HH:mm:ss");
//					  model.setRegeditdate(dateFormat.format(now));
//					  model.setState("0");
//					  model.setRole("2");
//					  userInfoService.save(model);
//					// 角色部分-2015-09-08
//					Role role = roleService.getRoleByRoleName("ROLE_Admin");
//					List<Integer> roleIdList = new ArrayList<Integer>();
//					roleIdList.add(role.getId());
//					userSecurityService.updateUserWithRoles(model.getUserinfoId(), roleIdList);
//					//角色部分结束
//				  }
//				  return "query";   
//		   }
		public String add() throws Exception
		   {   
			   String isResult = "true";
			   String isExsited = "true";
			   JSONObject json = new JSONObject();
			   PrintWriter pw=Struts2Utils.getResponse().getWriter();
			  
			   UserInfo userinfo=userInfoService.getCheckAdmin(model.getUsername());
			   if(userinfo!=null&&userinfo.getUserinfoId()>0)
				  {
				      
				   json.put("isResult", "regist");
			        json.put("isResult1", "regists");
					json.put("isExsited", "ture"); 
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
					  
					  isResult="true";
					  isExsited = "false";//表明该用户不存在可以注册
						
				        json.put("isExsited", "false");
				        json.put("isResult", "regist");
				        json.put("isResult1", "regists");
				  }
			    pw.write(json.toString());
				pw.flush();
				pw.close();		
				return null;
		   }
		   
		 //更新用户
//		    public String updateState() {
//		    	String id= ServletActionContext.getRequest().getParameter("itemId");
//			    UserInfo userInfo=userInfoService.get(Integer.parseInt(id));
//				if(userInfo.getState().equals("0"))
//				{
//					userInfo.setState("1");
//				}
//				else
//				{
//					userInfo.setState("0");
//				}
//				userInfoService.update(userInfo);
//				return "query";
//			}
		public String updateState() throws Exception{
	    	//String id= ServletActionContext.getRequest().getParameter("itemId");
	    	String id = Struts2Utils.getParameter("id");
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
			//return "query";
			Struts2Utils.renderTrue();
			return null;
		}
		   
//		   public String update()
//		   {
//			    String id= ServletActionContext.getRequest().getParameter("itemId");
//			    UserInfo userinfo=userInfoService.get(Integer.parseInt(id));
//			    userinfo.setPassword(model.getPassword());
//				userInfoService.update(userinfo);
//				return "query";   
//		   }
		public String update() throws Exception 
		   {
//		    	if(model!=null){
//		    		String id= ServletActionContext.getRequest().getParameter("itemId");
//		    		UserInfo userinfo=userInfoService.get(Integer.parseInt(id));
//		    		userinfo.setPassword(model.getPassword());
//		    		userInfoService.update(userinfo);
//					Struts2Utils.renderTrue();
//				}
//				return null;
			    String id= ServletActionContext.getRequest().getParameter("userinfoId");
			    UserInfo userinfo=userInfoService.get(Integer.parseInt(id));
			    userinfo.setPassword(model.getPassword());
			   
				userInfoService.update(userinfo);
				Struts2Utils.renderTrue();
				return null;   
		   }
		   
		   
		   
//		   public String list()
//		   {
//			  String key= ServletActionContext.getRequest().getParameter("keyword");
//			  page=userInfoService.getListAdmin(page,key);
//			  if(page!=null&&page.getTotalItems()>0)
//			  {
//				  request.put("msg", "");
//			  }
//			  else
//			  {
//				  request.put("msg", "没有符合条件的记录，请重新查询");
//			  }
//			request.put("page", page);
//			  return "list";   
//		   }
		public String list() throws Exception{
			  /*List<UserInfo> list = new ArrayList<UserInfo>();
			  System.out.println("fcfc");
			  String key= ServletActionContext.getRequest().getParameter("keyword");*/
			  //String key = "";
			  //page=userInfoService.getListAdmin(page,key);
			page=userInfoService.queryAllAdminUseRole(page);
//			  list = page.getResult();
//			  if(page!=null&&page.getTotalItems()>0)
//			  {
//				  request.put("msg", "");				  
//			  }
//			  else
//			  {
//				  request.put("msg", "没有符合条件的记录，请重新查询");
//				  
//			  }
//			  responseJson.put("list", list);
//			  return "json";   
			  if(page!=null&&page.getTotalItems()!=0)
				{ 
				  	
					//String jsonList = JSONUtils.toJSONString(page);
					//Struts2Utils.renderString(jsonList);
					responseJson.put("item", page.getResult());
					//responseJson.put("isResult", "true");
					boolean isFristPage = page.isFirstPage();
					  boolean isLastPage = page.isLastPage();
					  responseJson.put("first", isFristPage);
					  responseJson.put("next", isLastPage);
					
				}else
				{
					responseJson.put("isResult", "false");
				 }
				
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
		   
//		   public String delete()
//		   {
//				 String id= ServletActionContext.getRequest().getParameter("itemId");
//				 userInfoService.delete(Integer.parseInt(id));
//				 return "query";   
//		   }
		   public String delete()throws Exception
		   {
				 String id= ServletActionContext.getRequest().getParameter("id");
				 userInfoService.delete(Integer.parseInt(id));
				 Struts2Utils.renderTrue();
					return null;    
		   }
		   public String list1() throws Exception{
//				  List<UserInfo> list = new ArrayList<UserInfo>();
//				  System.out.println("fcfc");
//				  String key= ServletActionContext.getRequest().getParameter("keyword");
			   String key= ServletActionContext.getRequest().getParameter("keyword");
//				  String key = "";
				  //page=userInfoService.getListAdmin(page,key);
			   page=userInfoService.getListAdminUserRole(page,key);
//				  list = page.getResult();
//				  if(page!=null&&page.getTotalItems()>0)
//				  {
//					  request.put("msg", "");				  
//				  }
//				  else
//				  {
//					  request.put("msg", "没有符合条件的记录，请重新查询");
//					  
//				  }
//				  responseJson.put("list", list);
//				  return "json";   
//				  if(page.getTotalItems()!=0)
//					{ 
//						String jsonList = JSONUtils.toJSONString(page);
//						Struts2Utils.renderString(jsonList);
//					}else
//					{
//						Struts2Utils.renderTrue();
//					 }
//					
//								return null;
				  if(page!=null&&page.getTotalItems()>0)
				  {
					  responseJson.put("ListDateItem", page);
				  }
				  else
				  {
					  String ListDateItem="0";
		  		      responseJson.put("ListDateItem",ListDateItem);	
				  }
				  return "ListDateItem";
					
				
			   }
}
