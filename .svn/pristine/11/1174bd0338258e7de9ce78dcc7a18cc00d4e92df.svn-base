package cn.xaut.shop.phoneAction;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;


import cn.xaut.common.security.service.RoleService;
import cn.xaut.common.security.service.UserSecurityService;
import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.Role;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.pojo.UserPoint;
import cn.xaut.shop.util.Struts2Utils;
import edu.yale.its.tp.cas.client.filter.CASFilter;

public class UnifiedLoginphone extends BaseAction<UserInfo> {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	

	@Autowired
	private RoleService roleService;
	@Autowired
	private UserSecurityService userSecurityService;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String unifiedLogin(){
		String usernameTemp="";
		usernameTemp= (String) Struts2Utils.getSession().getAttribute(CASFilter.CAS_FILTER_USER);
		UserInfo userTemp = userSecurityService.getUserByAccount(usernameTemp);
		if(userTemp == null){
			userTemp = new UserInfo();
			userTemp.setUsername(usernameTemp);
			userTemp.setPassword("123456");
			userTemp.setRegeditdate(dateFormat.format(now));
			userTemp.setState("0");
			userTemp.setRole("0");
			Integer points = pointsRuleService.getBytype("个人", "注册");
			userTemp.setPoints(points);

			userInfoService.save(userTemp);

			// 角色部分-2015-09-08
			Role role = roleService.getRoleByRoleName("ROLE_User");
			List<Integer> roleIdList = new ArrayList<Integer>();
			roleIdList.add(role.getId());
			userSecurityService.updateUserWithRoles(userTemp.getUserinfoId(), roleIdList);
			//角色部分结束
			
			session.put("userid", userTemp.getUserinfoId());
			session.put("userinfo", userTemp);
			addpoints(points);
		}
		username = userTemp.getUsername();
		password = userTemp.getPassword();
		ActionContext ctx = ActionContext.getContext();       
		HttpServletRequest request =(HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);    
		HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);; 
		
		try {
			request.getRequestDispatcher("/frontLogin.action?username=" + username.toString() + "&password=" + password.toString()).forward(request,response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//response.senRedirect("/frontLogin.action?account=" + account.toString() + "&password=" + password.toString());
		return null;
	}
	
	public void addpoints(Integer points) {
		UserInfo user = (UserInfo) session.get("userinfo");
		UserPoint userPoint = new UserPoint();
		userPoint.setUserinfo(user);
		userPoint.setOperateTime(dateFormat.format(now));
		userPoint.setPoint(points);
		userPoint.setPlusminus("+");
		userPoint.setContent("用户注册");
		userPointService.save(userPoint);// 保存会员积分表
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
}
