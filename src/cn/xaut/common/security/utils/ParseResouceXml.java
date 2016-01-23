package cn.xaut.common.security.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.xaut.shop.pojo.Resource;

public class ParseResouceXml {
	
	private ParseResouceXml()
	{
		// 工具类构造发放要私有
	}
	
	// 注意 : path中可能出现空格，并转换成%20 所以tomcat安装路径中不能有中文，不能用空格
	private static String path;
	private static Document document = null;
	
	static {
		try {
			path = ParseResouceXml.class.getClassLoader().getResource("resource.xml")
					.toURI().getPath();
			
			SAXReader reader = new SAXReader();
			// 路径使用类加载器,不能使用路径"src/users.xml"
			document = reader.read(path);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(new Exception("Resource.xml读取出错"));
			//throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Resource> read()
	{
		Element root = document.getRootElement();
		//System.out.println(root);
		
		//将解析出来的resources下的resource放在list中
		List<Element> resourceList =  (List<Element>) root.elements("resource");
		//System.out.println(resourceList);
		
		//创建sourceList存放每一个resource中的资源
		List<Resource> returnResourceList = new ArrayList<Resource>();
		//将resource中的各项解析出来，通过Resource存放到sourceList中
		
		Iterator<Element> iter = resourceList.iterator();
		while(iter.hasNext()){
			
			Element elementItem = iter.next();
			String type = elementItem.element("type").getTextTrim();
			String resourceString = elementItem.element("resourceString").getTextTrim();
			String description = "";
			if(elementItem.element("description") != null)
			{
				description = elementItem.element("description").getTextTrim();
			}
			
			
			Resource resourceItem = new Resource();
			resourceItem.setType(type);
			resourceItem.setResourceString(resourceString);
			resourceItem.setDescription(description);
			returnResourceList.add(resourceItem);
		}
		return returnResourceList;
	}
}
