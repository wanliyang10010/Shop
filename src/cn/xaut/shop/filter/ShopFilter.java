package cn.xaut.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;

/**
 * 店铺用的过滤器
 * 
 * @author ywl
 */

public class ShopFilter implements Filter {

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
	
		//<!--过滤资源后缀参数-->
        String includeStrings = config.getInitParameter("includeStrings");    
        //<!--没有登陆转向页面-->    
        String redirectPath = config.getInitParameter("redirectPath");
        //<!-- 过滤器是否有效-->
        String disabletestfilter = config.getInitParameter("disabletestfilter");   
		
		//<!--过滤无效-->  
        if (disabletestfilter.toUpperCase().equals("Y")) {    
        	chain.doFilter(request, response);  
        	return;
        }  
        
        String[] includeList = includeStrings.split(";");  
        
        //<!--只对指定过滤参数后缀进行过滤-->  
        if (!this.isContains(req.getRequestURI(), includeList)) {
        	chain.doFilter(request, response);  
        	return;  
        } 
       
		UserInfo user = (UserInfo) req.getSession().getAttribute("userinfo");
		Shop shop = (Shop) req.getSession().getAttribute("shop");//shopstate:1:激活，0：冻结
		/*
		 * 角色 
		 * userinfo : 
		 * role : 0 普通用户
		 * role : 2 客服
		 * role : 3 超级管理员
		 */		
		if (shop !=null && shop.getShopstate().equals("1")) {
			// 跳转到下一个过滤器(如果有)，最后跳转到目标页面
			chain.doFilter(request, response);
		} else {			
			// 非法访问
			if (user == null) {
				//未登录情况
				request.setAttribute("error", "请先登录再进行操作");
				
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
				// 把用户要去的地址保存在session中
				req.getSession().setAttribute("goUrl", goUrl);
				// 跳回重新登录
				req.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			else if(shop == null || !shop.getShopstate().equals("1"))
			{
				//无权限情况
				request.setAttribute("errortip", "您没有权限访问该页面");
				// 跳至提示页面
				req.getRequestDispatcher(redirectPath).forward(request,response);
			}			
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;  
	}
}