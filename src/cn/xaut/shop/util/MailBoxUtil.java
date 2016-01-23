package cn.xaut.shop.util;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class MailBoxUtil {

	// 注意 : path中可能出现空格，并转换成%20 所以tomcat安装路径中不能有中文，不能用空格
	private static String path;
	private static Document document = null;
	private static SendMail mailconfig = null;

	private MailBoxUtil() {
		// 工具类构造发放要私有
	}

	static {
		try {
			// 路径使用类加载器,不能使用路径"src/xxx.xml"
			path = MailBoxUtil.class.getClassLoader().getResource("MailBoxConfig.xml").toURI().getPath();
			SAXReader reader = new SAXReader();

			document = reader.read(path);
			Element root = document.getRootElement();
			
			mailconfig = new SendMail();
			mailconfig.setMailServerHost(root.element("mailServerHost").getTextTrim());
			mailconfig.setMailServerPort(root.element("mailServerPort").getTextTrim());
			mailconfig.setValidate(Boolean.parseBoolean(root.element("validate").getTextTrim()));
			mailconfig.setUserName(root.element("userName").getTextTrim());
			mailconfig.setPassword(root.element("password").getTextTrim());
			mailconfig.setFromAddress(root.element("fromAddress").getTextTrim());
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(new Exception("MailBoxConfig.xml读取出错"));
		}
	}
	
	public static SendMail getConfig()
	{
		return mailconfig;
	}
}
