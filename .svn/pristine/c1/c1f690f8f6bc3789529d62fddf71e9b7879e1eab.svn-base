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


public class CustomLoginHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	public static final String SPRING_SECURITY_FORM_ACCOUNT_KEY = "username";
	private String accountParameter = SPRING_SECURITY_FORM_ACCOUNT_KEY;

	@Autowired
	private UserInfoService userInfoService;
	//@Autowired
	//private SendNewsService newsService;
	//@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Enter CustomLoginHandler");
		
		String username =  obtainAccount(request).trim();
		
		UserInfo user = userInfoService.getUser(username);

    	HttpSession session = request.getSession();
    	//session.invalidate();
    	//session = request.getSession(true);
		session.setAttribute("user",user);
		//session.setAttribute("userinfo", user);
		//session.setAttribute("userid", user.getUserinfoId());
		
		super.onAuthenticationSuccess(request, response, authentication);	
	}
	
	protected String obtainAccount(HttpServletRequest request){
		Object obj = request.getParameter(accountParameter);  
        return null == obj ? "" : obj.toString();  
	}
	

}
