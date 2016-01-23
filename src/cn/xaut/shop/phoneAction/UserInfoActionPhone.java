package cn.xaut.shop.phoneAction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.HashMap;
import cn.xaut.shop.util.Struts2Utils;
import cn.xaut.common.security.service.RoleService;
import cn.xaut.common.security.service.UserSecurityService;
import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.Role;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.pojo.UserPoint;
import cn.xaut.shop.util.SendMail;

public class UserInfoActionPhone<T> extends BaseAction<UserInfo> {
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
	@Autowired
	public static boolean isarrive = false;
	private static final long serialVersionUID = 1L;
	private Random random = new Random();
	private HttpServletRequest req = ServletActionContext.getRequest();
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	// 这个记录一个地址，用户做某些操作的时候因为未登录而被拦截，记录需要返回的地址
	// donglei
	private String goUrl = null;

	public String getGoUrl() {
		return goUrl;
	}

	public void setGoUrl(String goUrl) {
		this.goUrl = goUrl;
	}
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserSecurityService userSecurityService;

	//注册
	public String save() {
		model.setUsername(Struts2Utils.getParameter("username"));
		model.setPassword(Struts2Utils.getParameter("password"));
		model.setRegeditdate(dateFormat.format(now));
		model.setState("0");
		model.setRole("0");
		Integer points = pointsRuleService.getBytype("个人", "注册");
		model.setPoints(points);

		userInfoService.save(model);

		// 角色部分-2015-09-08
		Role role = roleService.getRoleByRoleName("ROLE_User");
		List<Integer> roleIdList = new ArrayList<Integer>();
		roleIdList.add(role.getId());
		userSecurityService.updateUserWithRoles(model.getUserinfoId(), roleIdList);
		//角色部分结束
		
		responseJson.put("userinfo", model);
//		session.put("userid", model.getUserinfoId());
//		session.put("userinfo", model);
		addpoints(points,model);
		return "list";
	}

	public  void addpoints(Integer points,UserInfo model) {
		UserInfo user = (UserInfo) model;
		UserPoint userPoint = new UserPoint();
		userPoint.setUserinfo(user);
		userPoint.setOperateTime(dateFormat.format(now));
		userPoint.setPoint(points);
		userPoint.setPlusminus("+");
		userPoint.setContent("用户注册");
		userPointService.save(userPoint);// 保存会员积分表
	}

	public String getUser() {
		int id = Integer.parseInt(session.get("userid").toString());
		System.out.println(id);
		UserInfo temp = userInfoService.get(id);
		request.put("username", temp.getUsername());
		request.put("userid", temp.getUserinfoId());
		request.put("mail", temp.getMail());
		request.put("telephone", temp.getTelephone());
		return "getUser";

	}
    
	public String viewmessage() {
		//UserInfo userInfo = (UserInfo) session.get("userinfo");
		int userid = Integer.parseInt(req.getParameter("userid"));
		UserInfo userInfo = userInfoService
				.getUserInfoByUserInfoId(userid);
		responseJson.put("userinfo", userInfo);
		return "viewmessage";
	}
    //cc
	public String updateM() {
		int userid = Integer.parseInt(req.getParameter("userid"));
		UserInfo userInfo = userInfoService
				.getUserInfoByUserInfoId(userid);
		userInfo.setAddress(model.getAddress());
		userInfo.setBdate(model.getBdate());
		userInfo.setMail(model.getMail());
		userInfo.setName(model.getName());
		userInfo.setSex(model.getSex());
		userInfo.setTelephone(model.getTelephone());
		userInfoService.update(userInfo);
		responseJson.put("userinfo", userInfo);
//		session.put("userinfo", userInfo);
		return "updateuser";
	}

	public String updateOK() {
		return "success";
	}

	public String updatePWD() {
		String userid = Struts2Utils.getParameter("userid");
		UserInfo userInfo = userInfoService.get(Integer.parseInt(userid));
		userInfo.setPassword(Struts2Utils.getParameter("password"));
		userInfoService.update(userInfo);
		return null;
	}

	public String clear() {
		session.remove("userid");
		session.remove("userinfo");
		session.remove("shop");
		return "login";
	}

	public String savePhone() {
		model.setUsername(Struts2Utils.getParameter("username"));
		model.setTelephone(Struts2Utils.getParameter("username"));
		model.setPassword(Struts2Utils.getParameter("password"));
		model.setRegeditdate(dateFormat.format(now));
		model.setState("0");
		model.setRole("0");
		Integer points = pointsRuleService.getBytype("个人", "注册");
		model.setPoints(points);
		userInfoService.save(model);
		// 角色部分
		Role role = roleService.getRoleByRoleName("ROLE_User");
		List<Integer> roleIdList = new ArrayList<Integer>();
		roleIdList.add(role.getId());
		userSecurityService.updateUserWithRoles(model.getUserinfoId(), roleIdList);
		//角色部分结束
		responseJson.put("userinfo", model);
//		session.put("userid", model.getUserinfoId());
//		session.put("userinfo", model);
		addpoints(points,model);
		return "list";
	}

	public String saveMail() {
		model.setUsername(Struts2Utils.getParameter("username"));
		model.setMail(Struts2Utils.getParameter("username"));
		model.setPassword(Struts2Utils.getParameter("password"));
		model.setRegeditdate(dateFormat.format(now));
		model.setState("0");
		model.setRole("0");
		Integer points = pointsRuleService.getBytype("个人", "注册");
		model.setPoints(points);
		userInfoService.save(model);
		responseJson.put("userinfo", model);
		// 角色部分
				Role role = roleService.getRoleByRoleName("ROLE_User");
				List<Integer> roleIdList = new ArrayList<Integer>();
				roleIdList.add(role.getId());
				userSecurityService.updateUserWithRoles(model.getUserinfoId(), roleIdList);
				//角色部分结束
//		session.put("userid", model.getUserinfoId());
//		session.put("userinfo", model);
		addpoints(points,model);
		return "list";
	}

	public String checkuser() {
		String username = Struts2Utils.getParameter("username");
		UserInfo user = userInfoService.getCheck(username);
		if (user != null && !user.getUserinfoId().equals("")) {
			responseJson.put("msg", "该用户名已注册");
		} else {
			responseJson.put("msg", "该用户名可用");
		}
		return "list";
	}

	public String checkPhoneuser() {
		String username = Struts2Utils.getParameter("username");
		UserInfo user = userInfoService.getCheck(username);
		if (user != null && !user.getUserinfoId().equals("")) {
//			System.out.println(user.getUsername());
			responseJson.put("msg", "该号码已注册");
		} else {
			responseJson.put("msg", "该号码可用");
		}
		return "list";
	}

	public String checkMailuser() {
		String username = Struts2Utils.getParameter("username");
		model.setMail(username);
		UserInfo user = userInfoService.getCheck(username);
		if (user != null && !user.getUserinfoId().equals("")) {
//			System.out.println(user.getUsername());
			responseJson.put("msg", "该邮箱已注册");
		} else {
			responseJson.put("msg", "该邮箱可用");
		}
		return "list";
	}
	//登录
	public String login() {

		if (UserInfoActionPhone.isarrive) {
			return "time";
		}   
		String username=model.getUsername();
		String password=model.getPassword();
		String role=req.getParameter("logintype");
		String rolesd = null;
		UserInfo user = userInfoService.conlogin(username,password);
		if (user != null ) {
			if( !user.getUserinfoId().equals("")){
				List<Role> roles = userSecurityService.getRolesByUserId(user.getUserinfoId());
				if (user.getState().equals("0")) {
					for(int i=0;i<roles.size();i++){
						rolesd=(roles.get(i)).getRoleName();
							if(role.equals(rolesd)){
							jsonMap.put("user", user);
							Integer userid=user.getUserinfoId();
							Shop shop=getShop(userid);
							jsonMap.put("shop", shop);
							//Integer count=messageService.getMessageCount(user.getUserinfoId());
							//session.put("MessageCount", count);
							// 是正常登录
								jsonMap.put("isExsited", "true");
								jsonMap.put("isResult", "regist");
								jsonMap.put("isResult1", "regists");
							return "loginsuccess";
							}
							else{
								jsonMap.put("islogin", "norole");
								return "loginsuccess";
							}
					}
				} else {
					//request.put("msg", "您的账户已被管理员冻结，请联系管理人员");
					jsonMap.put("isExsited", "false");
					jsonMap.put("isResult", "regist");
					jsonMap.put("isResult1", "regists");
					return "failed";
				}
		}else {
			//request.put("msg", "登陆失败。用户名或密码不正确，请重新输入");
			jsonMap.put("isExsited", "err");
			jsonMap.put("isResult", "regist");
			jsonMap.put("isResult1", "regists");
			return "failed";
			}
	}
	else {
		jsonMap.put("isExsited", "err");
		jsonMap.put("isResult", "regist");
		jsonMap.put("isResult1", "regists");
		return "failed";
	}
	return "loginsuccess";   
}
	
	public String loginFailure(){
		String showCheckCode = (String) session.get("showCheckCode");
		String SECURITY_LOGIN_EXCEPTION = "";
		//account = (String) session.get("login_account");
		if(!(showCheckCode.equals("0"))){
			SECURITY_LOGIN_EXCEPTION = (String) session.get("SECURITY_LOGIN_EXCEPTION");
			//msg = SECURITY_LOGIN_EXCEPTION;
			request.put("msg",SECURITY_LOGIN_EXCEPTION);
		}
		return "failure";
	}
	
	public Shop getShop(Integer userid)
	{
	 //System.out.println("user"+session.get("userid").toString());
	  List<Shop> list=shopService.getListByUserId(userid);
	  System.out.println("shop count"+list.size());
	  if(list!=null&&list.size()>0)
	  {
		  return list.get(0);
	  }
      return null;
	}
	// 获得实体
	public String get() {
		System.out.println(model.getUserinfoId());
		UserInfo temp = userInfoService.get(model.getUserinfoId());
		responseJson.put("user", temp);
		return "list";
	}

	// 获得全部数据
//	public String list() {
//
//		String stype = ServletActionContext.getRequest().getParameter("stype");
//		String key = ServletActionContext.getRequest().getParameter("keyword");
//		page = userInfoService.getList(page, stype, key);
//		if (page != null && page.getTotalItems() > 0) {
//			request.put("msg", "");
//		} else {
//			request.put("msg", "没有符合条件的记录，请重新查询");
//		}
//		request.put("page", page);
//		return "list";
//	}
		public String list() throws Exception{
		
		String stype="用户名";
		String key= ServletActionContext.getRequest().getParameter("keyword");
		 //page = userInfoService.getList(page,stype,key);
		page = userInfoService.getListUser(page, stype, key);
//		 if(page!=null&&page.getTotalItems()>0)
//		  {
//			  request.put("msg", "");
//		  }
//		  else
//		  {
//			  request.put("msg", "没有符合条件的记录，请重新查询");
//		  }
//		request.put("page", page);
//		return "list";
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

	// 获得删除用户
	public String delete() {
		userInfoService.delete(model.getUserinfoId());
		return "query";
	}

//	public String qury() {
//		page = userInfoService.queryAll(page);
//		if (page != null && page.getTotalItems() > 0) {
//			request.put("msg", "");
//		} else {
//			request.put("msg", "没有符合条件的记录，请重新查询");
//		}
//		request.put("page", page);
//		return "list";
//	}
	public String qury() throws Exception
	{
		 //page = userInfoService.queryAll(page);
		page = userInfoService.queryAllUser(page);
		 if(page!=null&&page.getTotalItems()!=0)
			{  
			    responseJson.put("item", page);
//				responseJson.put("isResult", "true");
//				String jsonList = JSONUtils.toJSONString(page);
//				Struts2Utils.renderString(jsonList);
				boolean isFristPage = page.isFirstPage();
				boolean isLastPage = page.isLastPage();
				
				responseJson.put("first", isFristPage);
				responseJson.put("next", isLastPage);
			}else
			{
				responseJson.put("isResult", "false");
			 }
			return "list";
						
//		 if(page!=null&&page.getTotalItems()>0)
//		  {
//			  request.put("msg", "");
//		  }
//		  else
//		  {
//			  request.put("msg", "没有符合条件的记录，请重新查询");
//		  }
//		request.put("page", page);
//		return "list";
	}

	// 更新用户
//	public String updateState() {
//		UserInfo userInfo = userInfoService.get(model.getUserinfoId());
//		if (userInfo.getState().equals("0")) {
//			userInfo.setState("1");
//		} else {
//			userInfo.setState("0");
//		}
//		userInfoService.update(userInfo);
//		// List<UserInfo> list = new ArrayList<UserInfo>();
//		// list.add(userInfo);
//		// request.put("UIL", list);
//		return "query";
//	}
	
	
	public String updateState() throws Exception{
    	String id = Struts2Utils.getParameter("id");
    	UserInfo userInfo = userInfoService.get(Integer.valueOf(id));
		if(userInfo.getState().equals("0"))
		{
			userInfo.setState("1");
		}
		else
		{
			userInfo.setState("0");
		}
		userInfoService.update(userInfo);
		//List<UserInfo> list = new ArrayList<UserInfo>();
		//list.add(userInfo);
		//request.put("UIL", list);
		Struts2Utils.renderTrue();
		return null;
	}


	public String updateR() {
		UserInfo userInfo = userInfoService.get(model.getUserinfoId());
		userInfo.setAddress(model.getAddress());
		userInfo.setBdate(model.getBdate());
		userInfo.setMail(model.getMail());
		userInfo.setName(model.getName());
		userInfo.setTelephone(model.getTelephone());
		userInfoService.update(userInfo);
		session.put("userinfo", userInfo);
		session.put("userid", userInfo.getUserinfoId());
		return "updateuser";
	}

	public String getRandom() {
		String num = "";
		for (int i = 0; i < 6; i++) {
			num = num + random.nextInt(9);
		}
		session.put("RandomKey", num);
		return num;
	}

	public String sendPhone() {
		String ran = getRandom();
		System.out.println(ran);
		responseJson.put("RandomKey", ran);
//		request.put("msg", "该号码可用");
		return "list";
	}

	public String checkPWDuser() {
		String username = Struts2Utils.getParameter("username");
//		System.out.println(model.getUsername());
		UserInfo user = userInfoService.getCheck(username);
		if (user != null && !user.getUserinfoId().equals("")) {
			responseJson.put("msg_id", user.getUserinfoId());
			responseJson.put("Rname", user.getName());
			responseJson.put("Rbdate", user.getBdate());
			responseJson.put("msg_phone", user.getTelephone());
			responseJson.put("msg_mail", user.getMail());
			responseJson.put("msg", "");

		} else {
			responseJson.put("msg", "该用户名不存在");
//			request.put("msg", "该用户名不存在");
		}
		return "list";
	}

	public String RPhone() {
		String ran = getRandom();
		System.out.println(ran);
		request.put("msgp", "发送成功！");
		request.put("item",
				ServletActionContext.getRequest().getParameter("item"));
		return checkPWDuser();
	}

	public boolean sendMail(String address, String subject, String content) {
		SendMail mail = new SendMail();
		mail.setToAddress(address); // 接受者邮箱密码
		mail.setSubject(subject);// 标题
		mail.setContent(content); // 内容
		return mailSender.sendTextMail(mail);
	}

	public String RMail() {
		String subject = "密码找回";
		String ran = getRandom();
		String content = "感谢您的使用，请在密码找回页面输入：" + ran;
		String address = Struts2Utils.getParameter("mail");
		if (sendMail(address, subject, content)) {
			responseJson.put("msgm", "发送成功！");
			responseJson.put("RandomKey", ran);
		} else {
			responseJson.put("msgm", "发送失败！");
		}
//		request.put("item",
//				ServletActionContext.getRequest().getParameter("item"));
		return "list";
	}

	public String Mail() {
		String address = Struts2Utils.getParameter("mail");
		String subject = "新用户注册";
		String ran = getRandom();
		String content = "感谢您的使用，请在邮箱注册页面输入：" + ran;
		if (sendMail(address, subject, content)) {
			responseJson.put("msgm", "发送成功！");
			responseJson.put("RandomKey", ran);
		} else {
			responseJson.put("msgm", "发送失败！");
		}
//		request.put("msg", "该邮箱可用");
		return "list";
	}

	public String judgeMessage() {
		String name = ServletActionContext.getRequest().getParameter("name");
		String bdate = ServletActionContext.getRequest().getParameter("bdate");
		String Rname = session.get("Rname").toString();
		String Rbdate = session.get("Rbdate").toString();
		System.out.println(name + "----" + Rname);
		System.out.println(bdate + "----" + Rbdate);
		if (Rname.equals(name) && Rbdate.equals(bdate)) {
			jsonMap.put("data", "right");
		} else {
			jsonMap.put("data", "wrong");
		}
		return "json";
	}

	public String JudgeRandom() {
		String random = ServletActionContext.getRequest()
				.getParameter("Random");
		System.out.println(random);
		if (session.get("RandomKey").toString().equals(random)) {
			jsonMap.put("data", "right");
		} else {
			jsonMap.put("data", "wrong");
		}
		return "json";
	}

	public String MessageR() {
		int userid = Integer.parseInt(req.getParameter("userid"));
		UserInfo userInfo = userInfoService
				.getUserInfoByUserInfoId(userid);
		responseJson.put("userinfo", userInfo);
		return "MessageR";
	}

	public String checkPWD() {
		UserInfo userInfo = userInfoService
				.get((Integer) session.get("userid"));
		String paswsword = ServletActionContext.getRequest().getParameter(
				"oldpassword");
		if (userInfo.getPassword().equals(paswsword)) {
			request.put("msg", "请输入新密码！");

		} else {
			request.put("msg", "密码错误，请重新输入！");
		}
		return "checkPWD";
	}
}
