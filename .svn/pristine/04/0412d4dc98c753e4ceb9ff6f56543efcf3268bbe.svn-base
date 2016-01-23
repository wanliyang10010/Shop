package cn.xaut.common.security.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import cn.xaut.common.security.service.AuthorityService;
import cn.xaut.common.security.service.UrlMatcher;
import cn.xaut.common.security.service.impl.AntUrlPathMatcher;


/*
 * ����ĵĵط��������ṩĳ����Դ��Ӧ��Ȩ�޶��壬��getAttributes�������صĽ�� 
 * �����ڳ�ʼ��ʱ��Ӧ��ȡ��������Դ�����Ӧ��ɫ�Ķ��塣
 * */
//@Service("securityMetadataSource")
public class MyInvocationSecurityMetadataSourceService implements
		FilterInvocationSecurityMetadataSource {
	
	//1����һ��
	
	//2������Spring Security3.0.1�д��ڸýӿڣ�������ȡ���ˣ����������Լ�д��һ����
	//��jar�����к��ʵ����滻
	//@Autowired
	private UrlMatcher urlMatcher = new AntUrlPathMatcher();
	//@Autowired
	private static Map<String,Collection<ConfigAttribute>> resourceMap = null;
	
	//@Autowired
	private AuthorityService authorityService;
	
	public MyInvocationSecurityMetadataSourceService(AuthorityService authorityService){
		this.authorityService = authorityService;
		loadResourceDefine();
	}
	
	private void loadResourceDefine(){

		resourceMap = new HashMap<String,Collection<ConfigAttribute>>();

		List<String> authorityNames = authorityService.getAllAuthorityName();
		/*
		Iterator<String> iter = authorityNames.iterator();
		System.out.println("权限名：");
		while(iter.hasNext()){
			System.out.println("<"+iter.next()+">");
		}*/
		
		
		for(String authorityName : authorityNames){
			ConfigAttribute ca = new SecurityConfig(authorityName);
			//��ȡ��Ȩ�������ӵ�е�Ȩ�޵�Ȩ�����ӣ�resourceString---������Ϊurl����
			//������resouceString��ɵ�List
			/*List<String> resourceStrings = authorityDao.findResourceStringsByAuthorityName(authorityName);*/
			List<String> resourceStrings = authorityService.getResourceStringsByAuthorityName(authorityName);
			
			
			//����
			/*Iterator<String> iter1 = resourceStrings.iterator();
			System.out.println("资源链接名：");
			while(iter1.hasNext()){
				System.out.println("<"+iter1.next()+">");
			}*/
			
			
			for(String resourceString : resourceStrings){
				String url = resourceString;
				/*
				 * �ж���Դ�ļ�(������ΪresourceString------url)��Ȩ����authorityName���Ķ�Ӧ��ϵ������Ѿ�������ص���Դurl��
				 * ��Ҫͨ���urlΪkey��ȡ��Ȩ�޼��ϣ���Ȩ�����ӵ�Ȩ�޼����С�
				 * */
				if(resourceMap.containsKey(url)){
					Collection<ConfigAttribute> value = resourceMap.get(url);
					value.add(ca);
					resourceMap.put(url, value);
				}else{
					Collection<ConfigAttribute>  atts = new ArrayList<ConfigAttribute>();
					atts.add(ca);
					resourceMap.put(url, atts);
				}
			}
		}
		
		//System.out.println("资源权限Map为：" + resourceMap);
	}
	
	
	/*
	 * ���URL�ҵ����Ȩ������
	 * */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		// ObjectΪһ��URL,���û������URL
		String url = ((FilterInvocation)object).getRequestUrl();
		//����
		System.out.println("该用户请求的url为：" + url);
		int firstQuestionMarkIndex = url.indexOf("?");
		if(firstQuestionMarkIndex != -1){
			url = url.substring(0, firstQuestionMarkIndex);
		}
		Iterator<String> ite =  resourceMap.keySet().iterator();
		while(ite.hasNext()){
			String resultURL = ite.next();
			if(urlMatcher.pathMatchesUrl(url, resultURL)){
				//����
			System.out.println("该url匹配的权限为："+ resourceMap.get(resultURL));
				return resourceMap.get(resultURL);
			}
		}
		//����
		//System.out.println("该url没有匹配的权限");
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

	public AuthorityService getAuthorityService() {
		return authorityService;
	}

	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}

}
