package cn.xaut.shop.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;

import java.util.Iterator;
import java.util.Map;

public class DecorationFactory {
	public static void mapUrl(String layout, String path) {
		Map<String, String> mapStr = new HashMap<String, String>();

		mapStr.put("商品购买页",
				"<%@ include file='/DecorationProductDetial.jsp' %>");
		mapStr.put("商品详情页", "<%@ include file='formwork/ProductPicture.jsp' %>");
		Iterator iter = mapStr.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			String key = (String) entry.getKey();
			layout = layout.replace(key, (String) entry.getValue());
		}
		System.out.println(layout);
		layout = "<%@ page language='java' import='java.util.*' pageEncoding='utf-8' contentType='text/html; charset=UTF-8' %>"
				+ layout;
		writeStr(layout, path);

	}

	public static void writeStr(String str, String path) {
		FileWriter fw = null;
		File f = new File(path);

		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			OutputStreamWriter out = new OutputStreamWriter(
					new FileOutputStream(f), "UTF-8");
			out.write(str);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 根据商品id，生成对应的jsp保存地址。
	public static String generateUrl(int id) {
		String url = "decoration/" + id + "_layout.jsp";

		return url;
	}

	// 判断某一个店铺的模板是否存在
	public static boolean isExsistUrl(String url) {
		File f = new File(url);
		if (!f.exists()) {
			return false;
		}
		return true;
	}
}
