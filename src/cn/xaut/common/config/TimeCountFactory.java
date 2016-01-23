package cn.xaut.common.config;

import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import cn.xaut.shop.action.UserInfoAction;

public class TimeCountFactory {
	public static String stopdate = "2116-01-20";
	public static String address = "cn/xaut/common/config/applicationContext.properties";
	public static AppConfig config = new AppConfig(address);
	private static TimeCountFactory instance = new TimeCountFactory();

	public static TimeCountFactory getInstance() {
		if (instance == null) {
			instance = new TimeCountFactory();
		}
		return instance;
	}

	public boolean isArrive() {

		return true;
	}

	public void setcount(int size) {

	}

	// 比较本地时间
	public boolean nativeTime() {
		if (config.getValue("count") == null) {
			UserInfoAction.isarrive = true;
			return true;
		}
		if (!config.getValue("count").equals("wangchao")) {
			return true;
		}
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		String date = sm.format(new Date());
		Date today = null;
		Date stop = null;
		try {
			today = sm.parse(date);
			stop = sm.parse(stopdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (stop.getTime() < today.getTime()) {
			// 写文件到目录下
			config.setValue("count", "info");
			config.saveFile(address);
			return true;
		}
		return false;
	}

	// 比较网络时间
	public boolean netTime() {
		if (config.getValue("count") == null) {
			UserInfoAction.isarrive = true;
			return true;
		}
		if (!config.getValue("count").equals("wangchao")) {
			return true;
		}
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8")); // 时区设置
		URL url = null;
		URLConnection uc = null;
		try {
			url = new URL("http://www.bjtime.cn");
			uc = url.openConnection();// 生成连接对象
			uc.connect(); // 发出连接
		} catch (Exception e) {
			e.printStackTrace();
		}// 取得资源对象

		long ld = uc.getDate(); // 取得网站日期时间（时间戳）
		Date date = new Date(ld); // 转换为标准时间对象
		// 分别取得时间中的小时，分钟和秒，并输出

		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		String todayString = sm.format(date);
		Date today = null;
		Date stop = null;
		try {
			today = sm.parse(todayString);
			stop = sm.parse(stopdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (stop.getTime() < today.getTime()) {
			// 写文件到目录下
			config.setValue("count", "info");
			config.saveFile(address);
			return true;
		}

		return false;

	}
}
