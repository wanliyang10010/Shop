package cn.xaut.shop.test;

import java.io.UnsupportedEncodingException;

public class ZOtherTest {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

		/*
		String username = URLEncoder.encode("AAAAAA文档", "utf-8");
		System.out.println(username);
		
		String ht = URLDecoder.decode(username,"utf-8");
		System.out.println(ht);
		*/
		
		String url = "http://localhost:8080/Shop/xxxx.action";
		String str = new String(url);
		int index = 0;
		
		for(int i = 0 ; i < 4;i++){
			index = str.indexOf("/",1);
			str = str.substring(index == 0? 1 : index);
		}
		System.out.println(str);
		
	}

}
