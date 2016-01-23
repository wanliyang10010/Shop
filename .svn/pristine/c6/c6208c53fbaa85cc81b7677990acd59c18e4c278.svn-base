package cn.xaut.shop.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

public class CasUserUtil {

	private static final String resource = "casuser.properties";

	private static String baseUrl = "";
	private static String queryUrl = "";

	private static Properties properties = null;
	private static InputStream inputStream = null;

	static {
		try {
			properties = new Properties();
			inputStream = CasUserUtil.class.getClassLoader().getResourceAsStream(resource);
			properties.load(inputStream);
			baseUrl = properties.getProperty("baseUrl");
			queryUrl = properties.getProperty("queryUrl");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			inputStream = null;// 垃圾回收站上收拾
		}
	}
	
	public static String getCasUserJsonString(String userId,String token) throws Exception  
    {
		try {
			//String url = "http://202.118.89.129/dlmu_rest_webservice/000102?userid=" + userId + "&token=1";
			StringBuilder builder = new StringBuilder();
			String str_url = baseUrl + queryUrl + "?userid=" + userId + "&token=" + token;
			URL url = new URL(str_url);
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			BufferedReader in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf-8"));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				builder.append(inputLine);
			}
			in.close();
			return builder.toString();
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }  
}
