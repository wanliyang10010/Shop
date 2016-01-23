package cn.xaut.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import cn.xaut.shop.pojo.UserInfo;

/**
 * 登录用的过滤器
 * 
 * @author donkey
 */

// 拦截.action的用拦截器，jsp或目录用过滤器
public class AdminLoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		// 获取session中的用户信息，判断是否登录
		HttpServletRequest req = (HttpServletRequest) request;

		UserInfo admin = (UserInfo) req.getSession().getAttribute("userinfo");

		/*
		 * 角色 
		 * userinfo : 
		 * role : 2 客服
		 * role : 3 超级管理员
		 */
		
		
		if (admin != null && admin.getRole().equals("2")) {

			// 跳转到下一个过滤器(如果有)，最后跳转到目标页面
			chain.doFilter(request, response);

		} else {

			// 保留要访问的URL
			String url = req.getRequestURI();
			StringBuffer buffer = new StringBuffer();
			buffer.append(url.substring(url.indexOf("/", 1)));
			String param = req.getQueryString();
			if (param != null) {
				buffer.append("?");
				buffer.append(param);
			}
			String goUrl = buffer.toString();

			// 把用户要去的地址保存在session中
			System.out.println("goUrl --> " + goUrl);
			
			System.out.println("ServletPath -> " + req.getServletPath());
			
			// 非法访问 
			if (admin == null) {
				//未登录情况
				System.out.println("AdminFilter Catched   --->  请管理员登录再操作");
				request.setAttribute("errortip", "该功能属于管理员功能，请使用管理员入口登录");
			}
			else if(!admin.getRole().equals("2"))
			{
				//无权限情况
				System.out.println("AdminFilter Catched   --->  没有访问权限");
				request.setAttribute("errortip", "您没有权限访问该页面");
			}
			
			// 跳至提示页面
			req.getRequestDispatcher("/tips/admintip.jsp").forward(request,response);

		}
	}

	public void init(FilterConfig cfg) throws ServletException {

	}

}
