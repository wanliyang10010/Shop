package cn.xaut.shop.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * 登录用的过滤器
 * 
 * @author donkey
 */

// 拦截.action的用拦截器，jsp或目录用过滤器
public class UserLoginFilter implements Filter {
	
	private final String LOGINACTION = "/frontLogin.action";

	public void destroy() {

	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		
		// 获取session中的用户信息，判断是否登录
		HttpServletRequest req = (HttpServletRequest) request;
		
//		String beforeUrl = req.getHeader("referer");
//		if(beforeUrl == null){
//			beforeUrl = "/MyShop.jsp";
//		}
//		
//		String goStr = new String(beforeUrl);
//		int index = 0;
//		for(int i = 0 ; i < 4;i++){
//			index = goStr.indexOf("/",0);
//			goStr = goStr.substring(index == 0? 1 : index);
//		}
//		System.out.println("referer -> " + goStr);

		String strServletPath = req.getServletPath();
		
		if (strServletPath.contains(LOGINACTION) || req.getSession().getAttribute("userinfo") != null) {
			// 跳转到下一个过滤器(如果有)，最后跳转到目标页面
			chain.doFilter(request, response);
		} else {
			
			System.out.println("LoginFilter Catched");
			System.out.println("servletPath -> " + req.getServletPath()); 
			
			// 非法访问
			request.setAttribute("error", "请先登录再进行操作");
			// 保留要访问的URL
			// req.getRequestURI();//获取相对地址--->/MyShop/users/confirm.jsp
			// req.getRequestURL();//获取完整地址--->http://......
			// req.getQueryString();//获取请求参数

			String url = req.getRequestURI();
			StringBuffer buffer = new StringBuffer();
			// 从位置1开始 找第一个斜杠/
			buffer.append(url.substring(url.indexOf("/", 1)));
			String param = req.getQueryString();//获取get的请求参数
			
			@SuppressWarnings("unchecked")
			Enumeration<String> emParams = request.getParameterNames();//获取post的请求参数
			if (param != null) {
				buffer.append("?");
				buffer.append(param);
			}
			else
			{
				//else部分20151104添加
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
							//不是第一个参数了
							buffer.append("&").append(sParam).append("=").append(sValue);
						}
					}
				} while (true);
			}
			
			String goUrl = buffer.toString();
			
			// 把用户要去的地址保存在session中
			req.getSession().setAttribute("goUrl", goUrl);
			
//			System.out.println("goUrl --> " + goUrl);
			System.out.println("goUrl --> " + goUrl);
			
			//responseJson.put("isResult", isResult);	
//			PrintWriter pw = resp.getWriter();
//	        JSONObject json = new JSONObject();//将map对象转换成json类型数据
//	        json.put("gogogo", goStr);
	        //pw.write(json.toString());
			//pw.flush();
			//pw.close();	
			
			// 跳回重新登录
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
	public void init(FilterConfig cfg) throws ServletException {
		
	}

}
