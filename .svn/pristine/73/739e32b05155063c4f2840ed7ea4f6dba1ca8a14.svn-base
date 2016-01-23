package cn.xaut.common.security.core;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/*
 *�ù���������Ҫ���þ���ͨ��spring�����IOC���securityMetadataSource;
 *securityMetadataSource�൱�ڱ������Զ����MyIncocationSecurityMetadataSourceService.
 *��MyInvocationSecurityMetadataSourceService�������Ǵ���ݿ���ȡȨ�޺���Դ��װ�䵽HashMap�У�
 *��Spring securityʹ�ã�����Ȩ��У�顣
 * */
//@Service("myFilterSecurityInterceptor")
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor
		implements Filter {
	
	private FilterInvocationSecurityMetadataSource securityMetadataSource;
	//���������������Ѿ���AbstractSecurityInterceptor�ж�����
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		FilterInvocation fi = new FilterInvocation(request,response,chain);
		invoke(fi);
	}
	
	public void invoke(FilterInvocation fi) throws IOException, ServletException{
		InterceptorStatusToken token = super.beforeInvocation(fi);
		try{
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		}finally{
			super.afterInvocation(token, null);
		}
	}

	
	@Override
	public Class<?> getSecureObjectClass() {
		
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		
		return this.securityMetadataSource;
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	//get����
	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
		return securityMetadataSource;
	}
	//set����
	public void setSecurityMetadataSource(
			FilterInvocationSecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}
	
	

}
