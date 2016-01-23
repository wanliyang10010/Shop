package cn.xaut.shop.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Map;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import cn.xaut.shop.util.Struts2Utils;
import cn.xaut.shop.util.JSONUtils;
import cn.xaut.common.security.service.RoleService;
import cn.xaut.common.security.service.UserSecurityService;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.Role;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.pojo.UserPoint;
import cn.xaut.shop.util.SendMail;

public class UserInfoAction extends BaseAction<UserInfo> {
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
	private static final long serialVersionUID = 1L;
	private Random random = new Random();
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
		model.setRegeditdate(dateFormat.format(now));
		model.setState("0");
		model.setRole("0");
		Integer points = pointsRuleService.getBytype("个人", "注册");
		model.setPoints(points);
		//userInfoService.save(model);
		model=userInfoService.saveRegedit(model,roleService,userSecurityService,userPointService,getPoints(points));
		// 角色部分-2015-09-08
		//Role role = roleService.getRoleByRoleName("ROLE_User");
		//List<Integer> roleIdList = new ArrayList<Integer>();
		//roleIdList.add(role.getId());
		//userSecurityService.updateUserWithRoles(model.getUserinfoId(), roleIdList);
		//角色部分结束
		Integer count = messageService.getMessageCount(model.getUserinfoId());
		session.put("MessageCount", count);
		session.put("userid", model.getUserinfoId());
		session.put("userinfo", model);
		//addpoints(points);
		return "UserAdd";
	}
	
	public UserPoint getPoints(Integer points)
	{
		SimpleDateFormat dateFormateNew = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		UserPoint userPoint = new UserPoint();
		userPoint.setOperateTime(dateFormateNew.format(now));
		userPoint.setPoint(points);
		userPoint.setPlusminus("+");
		userPoint.setContent("用户注册");
		return userPoint;
	}
	
	public void addpoints(Integer points) {		
		SimpleDateFormat dateFormateNew = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		UserInfo user = (UserInfo) session.get("userinfo");
		UserPoint userPoint = new UserPoint();
		userPoint.setUserinfo(user);
		userPoint.setOperateTime(dateFormateNew.format(now));
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
		UserInfo userInfo = (UserInfo) session.get("userinfo");
		request.put("userinfo", userInfo);
		return "viewmessage";
	}

	public String updateM() {
		UserInfo userInfo = userInfoService
				.get((Integer) session.get("userid"));
		userInfo.setAddress(model.getAddress());
		userInfo.setBdate(model.getBdate());
		userInfo.setMail(model.getMail());
		userInfo.setName(model.getName());
		userInfo.setSex(model.getSex());
		userInfo.setTelephone(model.getTelephone());
		userInfoService.update(userInfo);
		session.put("userinfo", userInfo);
		return "updateuser";
	}

	public String updateOK() {
		return "success";
	}

	public String updatePWD() {
		String userid = ServletActionContext.getRequest().getParameter(
				"userinfoId");
		String password = ServletActionContext.getRequest().getParameter(
				"password");
		System.out.println( userid+password);
		UserInfo userInfo = userInfoService.get(Integer.parseInt(userid));
		userInfo.setPassword(password);
		userInfoService.update(userInfo);
		jsonMap.put("data", "right");
	    return "json";
	}
	

	public String clear() {
		
		ServletActionContext.getRequest().getSession().invalidate();
		
//		session.clear();
//		session.remove("userid");
//		session.remove("userinfo");
//		session.remove("shop");
		return "login";
	}

	//通过手机号码注册
	public String savePhone() {
		model.setTelephone(model.getUsername());
		model.setRegeditdate(dateFormat.format(now));
		model.setState("0");
		model.setRole("0");
		Integer points = pointsRuleService.getBytype("个人", "注册");
		model.setPoints(points);
		//userInfoService.save(model);
		model=userInfoService.saveRegedit(model,roleService,userSecurityService,userPointService,getPoints(points));
		// 角色部分-2015-09-08
		//Role role = roleService.getRoleByRoleName("ROLE_User");
		//List<Integer> roleIdList = new ArrayList<Integer>();
		//roleIdList.add(role.getId());
		//userSecurityService.updateUserWithRoles(model.getUserinfoId(), roleIdList);
		//角色部分结束
		Integer count = messageService.getMessageCount(model.getUserinfoId());
		session.put("MessageCount", count);
		session.put("userid", model.getUserinfoId());
		session.put("userinfo", model);
		//addpoints(points);
		return "UserAdd";

	}

	//通过邮箱注册
	public String saveMail() {
		model.setMail(model.getUsername());
		model.setRegeditdate(dateFormat.format(now));
		model.setState("0");
		model.setRole("0");
		Integer points = pointsRuleService.getBytype("个人", "注册");
		model.setPoints(points);
		//userInfoService.save(model);
		model=userInfoService.saveRegedit(model,roleService,userSecurityService,userPointService,getPoints(points));
		// 角色部分-2015-09-08
		//Role role = roleService.getRoleByRoleName("ROLE_User");
		//List<Integer> roleIdList = new ArrayList<Integer>();
		//roleIdList.add(role.getId());
		//userSecurityService.updateUserWithRoles(model.getUserinfoId(), roleIdList);
		//角色部分结束
		Integer count = messageService.getMessageCount(model
				.getUserinfoId());
		session.put("MessageCount", count);
		session.put("userid", model.getUserinfoId());
		session.put("userinfo", model);
		//addpoints(points);
		return "UserAdd";
	}

	public String checkuser() {
		UserInfo user = userInfoService.getCheck(model.getUsername());
		if (user != null && !user.getUserinfoId().equals("")) {
			System.out.println(user.getUsername());
			request.put("msg", "该用户名已注册");
		} else {
			request.put("msg", "该用户名可用");
		}
		return "checkUser";
	}

	public String checkPhoneuser() {
		String phone = ServletActionContext.getRequest()
				.getParameter("Phone");
		UserInfo user = userInfoService.getCheck(phone);
		if (user != null && !user.getUserinfoId().equals("")) {
			System.out.println(user.getUsername());
			jsonMap.put("data", "wrong");
		} else {
			jsonMap.put("data", "right");
		}
		return "json";
	}

	public String checkMailuser() {
		String mail = ServletActionContext.getRequest()
				.getParameter("Mail");
		UserInfo user = userInfoService.getCheck(mail);
		if (user != null && !user.getUserinfoId().equals("")) {
			System.out.println(user.getUsername());
			jsonMap.put("data", "wrong");
		} else {
			jsonMap.put("data", "right");
		}
		return "json";
	}
	//登录
	public String login() throws UnsupportedEncodingException {
		if (UserInfoAction.isarrive) {
			return "time";
		}
		UserInfo user = (UserInfo) session.get("user");
		System.out.println(model.getUsername() + "--" + model.getPassword());
		if (user != null && !user.getUserinfoId().equals("")) {
			if (user.getState().equals("0")) {
				// 登录成功
				
				//session.put("userinfo", user);
				//session.put("userid", user.getUserinfoId());
				
				List<Shop> list = shopService.getListByUserId(user.getUserinfoId());
				if(list != null && list.size() > 0){
					session.put("ShopList", list);
					System.out.println("shop count" + list.size());
					session.put("shop", list.get(0));
				}
				Integer count = messageService.getMessageCount(user
						.getUserinfoId());
				session.put("MessageCount", count);

				//如果需要重定向
				if (session.get("goUrl") != null) {
					goUrl = URLDecoder.decode(session.get("goUrl").toString(),"UTF-8");
					session.remove("goUrl");// 这里移除掉，免得又跳转
					System.out.println("Back 2 Url ---> " + goUrl);
					return "back2url";
				}
				return "success";
			} else {
				request.put("msg", "您的账户已被管理员冻结，请联系管理人员");
				return "failed";
			}
		} else {
			request.put("msg", "登陆失败。用户名或密码不正确，请重新输入");
			return "failed";
		}
	}
	
	public String shopChange()
	{
		String sid = ServletActionContext.getRequest().getParameter("shopId");
		Shop shop = shopService.get(Integer.parseInt(sid));
		session.remove(shop);
		session.put("shop", shop);
		jsonMap.put("data", "right");
		return "json";
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
	
	public List<Shop> getShop() {
		System.out.println("user" + session.get("userid").toString());
		List<Shop> list = shopService.getListByUserId(Integer.parseInt(session
				.get("userid").toString()));
		if (list != null && list.size() > 0) {
			return list;
		}
		else
		{
			return null;
		}
	}

	// 获得实体
	public String get() {
		System.out.println(model.getUserinfoId());
		UserInfo temp = userInfoService.get(model.getUserinfoId());
		request.put("user", temp);
		return "updateuser";
	}

	// 获得全部数据
	public String list() {

		String stype = ServletActionContext.getRequest().getParameter("stype");
		String key = ServletActionContext.getRequest().getParameter("keyword");
		page = userInfoService.getList(page, stype, key);
		if (page != null && page.getTotalItems() > 0) {
			request.put("msg", "");
		} else {
			request.put("msg", "没有符合条件的记录，请重新查询");
		}
		request.put("page", page);
		return "list";
	}

	
	//hx
	public String listUser(){
		String stype = ServletActionContext.getRequest().getParameter("stype");
		String key = ServletActionContext.getRequest().getParameter("keyword");
		page = userInfoService.getListUser(page, stype, key);
		if (page != null && page.getTotalItems() > 0) {
			request.put("msg", "");
		} else {
			request.put("msg", "没有符合条件的记录，请重新查询");
		}
		request.put("page", page);
		return "list";
	}

	// 获得删除用户
 	public String delete() {
 		String userinfoId = ServletActionContext.getRequest().getParameter("userinfoId");
 		List<Shop> listS =shopService.getListByUserId(Integer.parseInt(userinfoId));
 		List<Order> list=orderService.findByUserId(userinfoId);
 		if(list!=null&&list.size()>0&&listS!=null&&listS.size()>0)
 		{
 			jsonMap.put("data", "wrong");
 		}
 		else
 		{
 			UserInfo userInfo = userInfoService.get(Integer.parseInt(userinfoId));
 			userInfo.setState("3");
 			userInfoService.update(userInfo);
 			jsonMap.put("data", "right");
 		}
		return "json";
	}

	public String qury() {
		page = userInfoService.queryAll(page);
		if (page != null && page.getTotalItems() > 0) {
			request.put("msg", "");
		} else {
			request.put("msg", "没有符合条件的记录，请重新查询");
		}
		request.put("page", page);
		return "list";
	}

	
	//hx
	public String queryUser(){
		page = userInfoService.queryAllUser(page);
		if (page != null && page.getTotalItems() > 0) {
			request.put("msg", "");
		} else {
			request.put("msg", "没有符合条件的记录，请重新查询");
		}
		request.put("page", page);
		return "list";
	}


	// 更新用户
	public String updateState() {
		String userinfoId = ServletActionContext.getRequest().getParameter("userinfoId");
		UserInfo userInfo = userInfoService.get(Integer.parseInt(userinfoId));
		if (userInfo.getState().equals("0")) {
			userInfo.setState("1");
		} else {
			userInfo.setState("0");
		}
		userInfoService.update(userInfo);
		jsonMap.put("data", "right");
		return "json";
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
		String phone = ServletActionContext.getRequest()
				.getParameter("Phone");
		String ran = getRandom();
		session.put("RandomKey", phone+"/"+ran);
		jsonMap.put("data", ran);
		return "json";
	}

	public String checkPWDuser() {
		String phone="";
		String mail="";
		System.out.println(model.getUsername());
		UserInfo user = userInfoService.getCheck(model.getUsername());
		if (user != null && !user.getUserinfoId().equals("")) {
			request.put("msg_id", user.getUserinfoId());
			if(user.getName()!=null&&user.getBdate()!=null)
			{
				session.put("Rname", user.getName());
				session.put("Rbdate", user.getBdate());
			}
			else
			{
				request.put("msg_detial","该用户尚未填写用户名和出生日期信息");
			}
			if(user.getTelephone()!=null&&user.getTelephone().length()==11)
			{
				phone=user.getTelephone().substring(0, 2)+"****"+user.getTelephone().substring(7);
			}
			else
			{
				phone="该账户手机号码信息不完整";
			}
			request.put("msg_phone", phone);
			
			if(user.getMail()!=null){
			Integer num=user.getMail().indexOf("@");
			 mail=user.getMail().substring(0, 1)+"****"+user.getMail().substring(num);
			}
			else
			{
				mail="该账户未填写邮箱信息";
			}
			request.put("msg_mail", mail);
			request.put("msg", "");

		} else {
			request.put("msg", "该用户名不存在");
		}
		return "checkPWDUser";
	}

	public String RPhone() {
		//String userid=ServletActionContext.getRequest().getParameter("userinfoId");
		String ran = getRandom();
		jsonMap.put("data", ran);
		return "json";
	}

	public boolean sendMail(String address, String subject, String content) {
		SendMail mail = new SendMail();
		mail.setToAddress(address); // 接受者邮箱
		mail.setSubject(subject);// 标题
		mail.setContent(content); // 内容
		return mailSender.sendTextMail(mail);
	}

	public String RMail() {
		String userid=ServletActionContext.getRequest()
				.getParameter("userinfoId");
		UserInfo userinfo = userInfoService.get(Integer.parseInt(userid));
		String subject = "密码找回";
		String ran = getRandom();
		String content = "感谢您的使用，请在密码找回页面输入：" + ran;
		String address = userinfo.getMail();
		if (sendMail(address, subject, content)) {
			jsonMap.put("data", "right");
		} else {
			jsonMap.put("data", "wrong");
		}
		return "json";
	}

	public String Mail() {
		String address = ServletActionContext.getRequest()
				.getParameter("Mail");
		String subject = "新用户注册";
		String ran = getRandom();
		String content = "感谢您的使用，请在邮箱注册页面输入：" + ran;
		if (sendMail(address, subject, content)) {
			jsonMap.put("data", "right");
			
		} else {
			jsonMap.put("data", "wrong");
		}
		return "json";
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
		if(session.get("RandomKey")!=null)
		{
			if (session.get("RandomKey").toString().equals(random)) {
				jsonMap.put("data", "right");
			} else {
				jsonMap.put("data", "wrong");
			}
		}
		else
		{
			jsonMap.put("data", "null");
		}
		return "json";
	}

	public String MessageR() {
		String userid = ServletActionContext.getRequest().getParameter(
				"userinfoid");
		UserInfo userinfo = userInfoService.get(Integer.parseInt(userid));
		request.put("userinfo", userinfo);
		return "MesReset";
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
	
	  public String PwdChange()
	   {
			 return "pwdchange";   
	   }
	  
	  public String finaljudge() {
		  String username = ServletActionContext.getRequest().getParameter("username");
			UserInfo user = userInfoService.getCheck(username);
			if (user != null && !user.getUserinfoId().equals("")) {
				jsonMap.put("data", "wrong");
			} else {
				jsonMap.put("data", "right");
			}
			return "json";
		}
	  
}
