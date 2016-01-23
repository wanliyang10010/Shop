package cn.xaut.common.config;

import java.io.FileOutputStream;
import java.util.Properties;

import cn.xaut.shop.action.UserInfoAction;

public class AppConfig {
	private Properties config = new Properties();

	public AppConfig() {

	}
	public AppConfig(String name) {
		try {
			config.load(AppConfig.class.getClassLoader().getResourceAsStream(
					name));
		} catch (Exception e) {
			UserInfoAction.isarrive = true;
			System.out.println("文件不存在！");
			e.printStackTrace();
		}

	}

	public String getValue(String itemname) {
		return config.getProperty(itemname);
	}

	public void setValue(String itemname, String itemvalue) {
		config.setProperty(itemname, itemvalue);
	}

	public void saveFile(String filename) {
		FileOutputStream output;
		try {
			// this.getClass().getClassLoader().getResource(filename).getPath()
			output = new FileOutputStream(this.getClass().getClassLoader()
					.getResource(filename).getPath());
			config.store(output, "最新的");
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
