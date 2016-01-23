package cn.xaut.shop.filter;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;

public class SessionFilter implements Filter {
	/**
	 * 用于检查用户是否登录了系统的过滤器<br>
	 * @author
	 */

	//自定义Session超时状态为 timeout
	public static final String Session_Time_Out = "timeout";
	/** 自定义response状态值**/
	public static final int ReponseState = 911; 
	
	/** 要检查的 session 的名称 */
	private String sessionKey;

	/** 需要排除（不拦截）的URL的正则表达式 */
	private Pattern excepUrlPattern;

	/** 检查不通过时，转发的URL */
	private String forwardUrl;
	
	/** 网站首页地址 */
	private String indexPage;

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		sessionKey = cfg.getInitParameter("sessionKey");
		indexPage = cfg.getInitParameter("indexPage");
		
		String excepUrlRegex = cfg.getInitParameter("excepUrlRegex");
		
		if (!StringUtils.isBlank(excepUrlRegex)) {
			excepUrlPattern = Pattern.compile(excepUrlRegex);
		}

		forwardUrl = cfg.getInitParameter("forwardUrl");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		// 如果 sessionKey 为空，则直接放行
		if (StringUtils.isBlank(sessionKey)) {
			chain.doFilter(req, res);
			return;
		}

		// * 请求 http://127.0.0.1:8080/webApp/home.jsp?&a=1&b=2 时
		// * request.getRequestURL()： http://127.0.0.1:8080/webApp/home.jsp
		// * request.getContextPath()： /webApp
		// * request.getServletPath()：/home.jsp
		// * request.getRequestURI()： /webApp/home.jsp
		// * request.getQueryString()：a=1&b=2
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		// 要请求的地址
		String servletPath = request.getServletPath();
		// 工程项目地址
		String contextPath = request.getContextPath();		
		
		Object sessionObj = request.getSession().getAttribute(sessionKey);
		
		// 如果请求的路径与forwardUrl相同，或请求的路径是排除的URL时，则直接放行
		if (sessionObj !=null || servletPath.equals(forwardUrl)|| excepUrlPattern.matcher(servletPath).matches()) {
			chain.doFilter(req, res);
			return;
		}

		// 如果Session为空，则跳转到指定页面
		if (sessionObj == null) {
			
			System.out.println("Session Filter Catched");
			System.out.println("ServletPath -> " + servletPath);
			
			//登录后返回的页面
			String redirect = "";
			
			//判断发起请求的类型 : http 或者 ajax
			String type = request.getHeader("X-Requested-With");  
			
			if ("XMLHttpRequest".equalsIgnoreCase(type)) {
				
				System.out.println("Ajax 请求");
				
				// AJAX REQUEST PROCESS  
				//设置session过期
				response.setStatus(ReponseState);  
                response.setHeader("sessionstatus", Session_Time_Out);
                response.addHeader("loginPath", contextPath + forwardUrl);
                redirect = request.getHeader("referer");
                if(redirect == null)
                	redirect = contextPath + indexPage;
                request.getSession().setAttribute("goUrl",redirect);
                //response.
                return;
            } else {
            	// NORMAL REQUEST PROCESS
            	System.out.println("Http 请求");
            	redirect = getHttpGoUrl(request);
            }  
			
			
			System.out.println("redirect --> " + redirect);
			
			// 抓住后要前往的地址
			String forword = StringUtils.defaultIfEmpty(forwardUrl, "/");
			
			// 编码重定向地址
			redirect = URLEncoder.encode(redirect,"UTF-8");
			request.getSession().setAttribute("goUrl",redirect);
			// 跳回重新登录
			//request.getRequestDispatcher(directUrl + "?redirect" + redirect).forward(request, response);
			
			// response.sendRedirect(contextPath
			//  + StringUtils.defaultIfEmpty(forwardUrl, "/")
			//	+ "?redirect=" + URLEncoder.encode(redirect, "UTF-8"));
			
			System.out.println("跳回登录页");
			response.sendRedirect(contextPath + forword+ "?redirect=" +redirect);
		} 
	}
	
	/**
	 * http请求action,直接跳去这个action
	 * */
	private String getHttpGoUrl(HttpServletRequest request){
		
		StringBuffer buffer = new StringBuffer();
		String url = request.getServletPath();
		buffer.append(url);
		
		String param = request.getQueryString();//获取get的请求参数
		@SuppressWarnings("unchecked")
		Enumeration<String> emParams = request.getParameterNames();//获取post的请求参数
		if (param != null) {
			buffer.append("?");
			buffer.append(param);
		}
		else
		{
			//post提交参数
			boolean first = true;
			do {
				if (!emParams.hasMoreElements()) {
					break;
				}
				String sParam = (String) emParams.nextElement();
				String[] sValues = request.getParameterValues(sParam);

				String sValue = "";
				for (int i = 0; i < sValues.length; i++) {
					sValue = sValues[i];
					//if (sValue != null && sValue.trim().length() != 0 && first == true)
					if (sValue != null && first == true) {
						// 第一个参数
						first = false;
						buffer.append("?");
						buffer.append(sParam).append("=").append(sValue);
								
					//} else if (sValue != null && sValue.trim().length() != 0 && first == false) {
					} else if (sValue != null && first == false) {
						buffer.append("&").append(sParam).append("=").append(sValue);
					}
				}
			} while (true);
		}
		return buffer.toString();
	}
	

	@Override
	public void destroy() {
	}

}


/*
 * 
 * login.jsp 的 <form> 表单中新增一个隐藏表单域： 
 * <input type="hidden" name="redirect" value="${param.redirect }">
 * 
 * LoginServlet.java 的 service 的方法中新增如下代码： 
 * String redirect = request.getParamter("redirect");
 *  if(loginSuccess){ if(redirect == null
 *    || redirect.length() == 0)
 *  { // 跳转到项目主页（home.jsp） }else{ //
 * 跳转到登录前访问的页面（java.net.URLDecoder.decode(s, "UTF-8")） } }
 */




/**
 * 在web.xml中添加下面的配置
 * 
<!—检查用户是否登录了系统的过滤器配置  开始 -->
<filter>
 <filter-name>SessionFilter</filter-name>
 <filter-class>com.hmw.filter.SessionFilter</filter-class>
 <init-param>
     <description>将当前登录的用户的信息保存在 session 中时使用的key，如果没有配置此参数，则该过滤器不起作用</description>
     <param-name>sessionKey</param-name>
     <param-value>userInfo</param-value>
 </init-param>
 <init-param>
     <description>
         如果用户未登录（即在 session 中 key 为 sessionKey 的属性不存在或为空），则将请求重定向到该 url。
         该 url 不包含web应用的 ContextPath。
         如果不配置此参数，则在用户未登录系统的情况下，直接重定向到web应用的根路径（/）
     </description>
     <param-name>redirectUrl</param-name>
     <param-value>/login.jsp</param-value>
 </init-param>
 <init-param>
     <description>
         不需要进行拦截的 url 的正则表达式，即：如果当前请求的 url 的 servletPath 能匹配该正则表达式，则直接放行（即使未登录系统）。
         此参数的值一般为 loginServlet 和 registServlet 等。
         另外，参数 redirectUrl 的值不用包含在该正则表达式中，因为 redirectUrl 对应的 url 会被自动放行。
         还有一点需要说明的是，该参数的值不包含web应用的 ContextPath。
     </description>
     <param-name>excepUrlRegex</param-name>
     <!-- 不拦截 /servlets/loginServlet 和 /servlets/registServlet -->
     <param-value>/servlets/(login|regist)Servlet</param-value>
 </init-param>
</filter>
 
<filter-mapping>
 <filter-name>SessionFilter</filter-name>
 <url-pattern>/servlets/*</url-pattern>
</filter-mapping>
<filter-mapping>
 <filter-name>SessionFilter</filter-name>
 <url-pattern>/jsp/*</url-pattern>
</filter-mapping>
<!—检查用户是否登录了系统的过滤器配置  结束 -->

 * */
