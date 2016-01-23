package cn.xaut.shop.pojo;

import java.io.File;

public class IdentifyPicture {

	private File item;

	private String itemFileName;

	private String itemContentType;

	public File getItem() {
		return item;
	}

	public void setItem(File item) {
		this.item = item;
	}

	public String getItemFileName() {
		return itemFileName;
	}

	public void setItemFileName(String itemFileName) {
		this.itemFileName = itemFileName;
	}

	public String getItemContentType() {
		return itemContentType;
	}

	public void setItemContentType(String itemContentType) {
		this.itemContentType = itemContentType;
	}

}
