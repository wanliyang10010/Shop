package cn.xaut.shop.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

public class UnauthorizedOperationFilter implements Filter {

	/** 页面中区别用户的token标致 */
	private static final String token = "authorizedToken";
	/** 自定义response状态值 **/
	public static final int ReponseState = 999;
	/** 状态:未授权的操作 */
	public static final String UNAUTHORIZED = "unauthorized";

	/** 检查不通过时，转发的URL */
	private String forwardUrl = "/error/havelogouted.jsp";// 默认值

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		
		// 工程项目地址
		String contextPath = request.getContextPath();	
		String key = request.getParameter(token);
		
		if(key == null || key.trim().equals("")){
			chain.doFilter(request, response);// 放行
		} else {
			//存在权限标致
			String str_userid = session.getAttribute("userid").toString();
			
			if (key.trim().equals(str_userid)) {
				// 属于该用户放行
				chain.doFilter(request, response);
			} else {
				// 不是该用户操作的页面，跳转至错误提醒页面
				
				//判断发起请求的类型 : http 或者 ajax
				String type = request.getHeader("X-Requested-With");  
				
				if ("XMLHttpRequest".equalsIgnoreCase(type)) {
					
					System.out.println("UnauthorizedFilter --> Ajax请求");
					// AJAX REQUEST PROCESS  
					//设置session过期
					response.setStatus(ReponseState);  
		            response.setHeader("sessionstatus", UNAUTHORIZED);
		            response.addHeader("loginPath", contextPath + forwardUrl);
		        } else {
		        	// NORMAL REQUEST PROCESS
		        	System.out.println("UnauthorizedFilter --> Http 请求");
		        	response.sendRedirect(contextPath+ forwardUrl);
		        }
				return;
			}
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {

		if (StringUtils.isNotEmpty(cfg.getInitParameter("forwardUrl"))){
			forwardUrl = cfg.getInitParameter("forwardUrl");
		}
	}

}
