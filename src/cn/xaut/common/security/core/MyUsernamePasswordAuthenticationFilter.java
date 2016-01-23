package cn.xaut.common.security.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import cn.xaut.common.security.service.UserSecurityService;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.service.UserInfoService;

public class MyUsernamePasswordAuthenticationFilter extends
		UsernamePasswordAuthenticationFilter {

	public static final String SPRING_SECURITY_FORM_ACCOUNT_KEY = "username";
	public static final String SPRING_SECURITY_FORM_PASSWORD_KEY = "password";

	private String accountParameter = SPRING_SECURITY_FORM_ACCOUNT_KEY;
	private String passwordParameter = SPRING_SECURITY_FORM_PASSWORD_KEY;
	
	@Autowired
	private UserSecurityService userSecurityService;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {

		String username = obtainAccount(request).trim();
		String password = obtainPassword(request).trim();
		UserInfo user = new UserInfo();
		user = userSecurityService.getUserByAccount(username);
		
		HttpSession session = request.getSession();
		session = request.getSession(false);
        
        //���û�����session������¼�ɹ�����ʾ����ҳ
        session.setAttribute("login_account",username);
		/*
		System.out.println("MyLoginAuthenticationFilter--->username:"
				+ username + "---password:" + password);

		UserInfo user = userService.login(username, password);
		
		HttpSession session = request.getSession();
		// false��?�����µ�session��ֱ�ӻ�ȡ��ǰ��session
		session = request.getSession(false);

		session.setAttribute("login_account", username);
		
		if (user != null && !user.getUserinfoId().equals("")) {
			if (user.getState().equals("0")) {
				// 登录成功
				
				System.out.println("LoginAuthenticationFilter--->登录成功");
				if (session.getAttribute("showCheckCode") == "1" 
						|| session.getAttribute("showCheckCode") == null)
				{
					session.setAttribute("showCheckCode", "0");
				}
				
			} else {
				
				System.out.println("LoginAuthenticationFilter--->账户冻结");
				session.setAttribute("showCheckCode", "1");
				session.setAttribute("SECURITY_LOGIN_EXCEPTION", "您的账户已被管理员冻结，请联系管理人员");
			}
		} else {
			System.out.println("LoginAuthenticationFilter--->输入密码不正确");
			session.setAttribute("showCheckCode", "1");
			session.setAttribute("SECURITY_LOGIN_EXCEPTION", "用户名或密码不正确");
		}
		
		*/
		
		
		if (user == null) {

			//System.out.println("LoginAuthenticationFilter--->用户不存在");
			session.setAttribute("showCheckCode", "1");
			session.setAttribute("SECURITY_LOGIN_EXCEPTION", "该用户不存在");
			throw new AuthenticationServiceException("该用户不存在");

		} else if (user.getPassword() == null || user.getPassword().equals("")) {

			//System.out.println("LoginAuthenticationFilter--->数据库中密码为空");
			session.setAttribute("showCheckCode", "1");
			session.setAttribute("SECURITY_LOGIN_EXCEPTION", "该用户不存在");
			throw new AuthenticationServiceException("该用户不存在");

		} else if (!(user.getPassword().equals(password))) {

			//System.out.println("LoginAuthenticationFilter--->输入密码不正确");
			session.setAttribute("showCheckCode", "1");
			session.setAttribute("SECURITY_LOGIN_EXCEPTION", "用户名或密码不正确");

		} else {

			//System.out.println("LoginAuthenticationFilter--->用户名密码正确");
			if (session.getAttribute("showCheckCode") == "1"
					|| session.getAttribute("showCheckCode") == null) {
				session.setAttribute("showCheckCode", "0");
			}
		}
		
		
		
		UsernamePasswordAuthenticationToken authRequest 
			= new UsernamePasswordAuthenticationToken(username, password);
				
		setDetails(request, authRequest);
		// ����UserDetailsService��loadUserByUsername �ٴη�װAuthentication
		return this.getAuthenticationManager().authenticate(authRequest);
	}


	protected String obtainAccount(HttpServletRequest request) {
		Object obj = request.getParameter(accountParameter);
		return null == obj ? "" : obj.toString();
	}

	protected String obtainPassword(HttpServletRequest request) {
		Object obj = request.getParameter(passwordParameter);
		return null == obj ? "" : obj.toString();
	}

	public void setAccountParameter(String accountParameter) {
		this.accountParameter = accountParameter;
	}

	public void setPasswordParameter(String passwordParameter) {
		this.passwordParameter = passwordParameter;
	}

}
