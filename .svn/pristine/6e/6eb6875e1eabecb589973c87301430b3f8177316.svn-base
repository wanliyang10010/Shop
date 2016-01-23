package cn.xaut.common.security.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.service.UserInfoService;


public class CustomEndLoginHandler extends
		SavedRequestAwareAuthenticationSuccessHandler {
	
	public static final String SPRING_SECURITY_FORM_ACCOUNT_KEY = "username";
	private String accountParameter = SPRING_SECURITY_FORM_ACCOUNT_KEY;

	@Autowired
	private UserInfoService userInfoService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
		
		String username =  obtainAccount(request).trim();
		UserInfo user = userInfoService.getUser(username);
				//.getUserByAccount(account);

    	HttpSession session = request.getSession();
    	

		
		
		session.setAttribute("user",user);
		
		super.onAuthenticationSuccess(request, response, authentication);
		//后台登录成功的处理
	}
	
	
	protected String obtainAccount(HttpServletRequest request){
		Object obj = request.getParameter(accountParameter);  
        return null == obj ? "" : obj.toString();  
	}

}
