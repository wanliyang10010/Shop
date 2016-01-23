package cn.xaut.shop.test;

import java.io.File;
import java.io.FilenameFilter;

public class PicturesTest {
	
	public static void main(String [] args)
	{
		//获取指定位置目录
		File file = new File("D:/logo");
		String [] name = file.list(new FilenameFilter() {
			
			public boolean accept(File dir, String name) {
//				System.out.println(dir);
//				System.out.println(name);
				
				//判读后缀名
				
				return name.endsWith("gif");
				//返回false表示被过滤掉
			}
		});
		System.out.println(name.length);
		for(String str : name)
		{
			System.out.println(str);
		}
	}

}
