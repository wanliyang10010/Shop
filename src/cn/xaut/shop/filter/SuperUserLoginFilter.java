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
import javax.servlet.http.HttpServletResponseWrapper;

import cn.xaut.shop.pojo.UserInfo;

/**
 * 网站管理员用的过滤器
 * 
 * @author donkey
 */

public class SuperUserLoginFilter implements Filter {

	public FilterConfig config;
	
	public void destroy() {
		this.config = null;  
	}
	
	public static boolean isContains(String container, String[] regx) {  
        boolean result = false;  
  
        for (int i = 0; i < regx.length; i++) {  
            if (container.indexOf(regx[i]) != -1) {  
                return true;  
            }  
        }  
        return result;  
    }  

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) response);  
		
		//<!--登录登陆页面-->
		String logonStrings = config.getInitParameter("logonStrings");        
		//<!--过滤资源后缀参数-->
        String includeStrings = config.getInitParameter("includeStrings");    
        //<!--没有登陆转向页面-->
        String redirectPath = req.getContextPath() + config.getInitParameter("redirectPath"); 
        //<!-- 过滤器是否有效-->
        String disabletestfilter = config.getInitParameter("disabletestfilter");   
		
		//<!--过滤无效-->  
        if (disabletestfilter.toUpperCase().equals("Y")) {    
        	chain.doFilter(request, response);  
        	return;  
        }  
        
        
        String[] logonList = logonStrings.split(";");  
        String[] includeList = includeStrings.split(";");  
        
        //<!--只对指定过滤参数后缀进行过滤-->  
        if (!this.isContains(req.getRequestURI(), includeList)) {
        	chain.doFilter(request, response);  
        	return;  
        } 
        
        //<!--对登录页面不进行过滤--> 
        if (this.isContains(req.getRequestURI(), logonList)) { 
        	chain.doFilter(request, response);  
        	return;  
        }
        
		UserInfo admin = (UserInfo) req.getSession().getAttribute("userinfo");
		/*
		 * 角色 
		 * userinfo : 
		 * role : 2 客服
		 * role : 3 超级管理员
		 */
		
		if (admin != null && admin.getRole().equals("3")) {

			// 跳转到下一个过滤器(如果有)，最后跳转到目标页面
			chain.doFilter(request, response);
		} else {

			// 要访问的URL
			String url = req.getRequestURI();
			StringBuffer buffer = new StringBuffer();
			buffer.append(url.substring(url.indexOf("/", 1)));
			String param = req.getQueryString();
			if (param != null) {
				buffer.append("?");
				buffer.append(param);
			}
			String goUrl = buffer.toString();
			System.out.println("goUrl --> " + goUrl);
			System.out.println("ServletPath -> " + req.getServletPath());
			
			// 非法访问
			if (admin == null) {
				//未登录情况
				System.out.println("AdminFilter Catched   --->  请管理员登录再操作");
				request.setAttribute("errortip", "该功能属于后台管理员功能，请使用后台管理员入口登录");
			}
			else if(!admin.getRole().equals("3"))
			{
				//无权限情况
				System.out.println("AdminFilter Catched 管理员功能  --->  没有访问权限");
				request.setAttribute("errortip", "您没有权限访问该页面");
			}

			// 跳至提示页面
			//wrapper.sendRedirect(redirectPath);
			System.out.println("跳转地址 -> " + redirectPath);
			req.getRequestDispatcher(redirectPath).forward(request,response);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;  
	}

}


/**
 * 使用方法 
 * <filter>  
    <filter-name>SessionFilter</filter-name>  
    <filter-class>com.action.login.SessionFilter</filter-class>  
    <init-param>  
        <param-name>logonStrings</param-name><!-- 对登录页面不进行过滤 -->  
        <param-value>/project/index.jsp;login.do</param-value>  
    </init-param>  
    <init-param>  
        <param-name>includeStrings</param-name><!-- 只对指定过滤参数后缀进行过滤 -->  
        <param-value>.do;.jsp</param-value>  
    </init-param>  
    <init-param>  
        <param-name>redirectPath</param-name><!-- 未通过跳转到登录界面 -->  
        <param-value>/index.jsp</param-value>  
    </init-param>  
    <init-param>  
        <param-name>disabletestfilter</param-name><!-- Y:过滤无效 -->  
        <param-value>N</param-value>  
    </init-param>  
</filter>  
<filter-mapping>  
    <filter-name>SessionFilter</filter-name>  
    <url-pattern>/*</url-pattern>  
</filter-mapping>  

*/
