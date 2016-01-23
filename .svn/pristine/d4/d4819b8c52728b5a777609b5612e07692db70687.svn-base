package cn.xaut.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SetCharacterEncodingFilter implements Filter{

	protected FilterConfig filterConfig;
	protected String encodingName;
	protected boolean enable;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub		
	}

	public SetCharacterEncodingFilter() {
		this.encodingName="UTF-8";
		this.enable=false;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if(this.enable){
			request.setCharacterEncoding(this.encodingName);
		}
		chain.doFilter(request,response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig=filterConfig;
		this.encodingName=this.filterConfig.getInitParameter("encoding");
		String strIgnoreFlag=this.filterConfig.getInitParameter("enable");
		if(strIgnoreFlag.equalsIgnoreCase("true")){
			this.enable=true;
		}else{
			this.enable=false;
		}
	}
}