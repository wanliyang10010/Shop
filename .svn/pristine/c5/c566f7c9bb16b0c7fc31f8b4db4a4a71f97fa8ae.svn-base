package cn.xaut.shop.test;

import java.util.List;

import cn.xaut.common.security.utils.ParseResouceXml;
import cn.xaut.shop.pojo.Resource;

public class XmlUtilTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Resource> RES = ParseResouceXml.read();
		
		if(RES != null)
		{
			for(Resource res : RES)
			{
				//System.out.println(res.getType());
				//System.out.println(res.getResourceString());
				System.out.println(res.getDescription());
			}
		}
		else
		{
			System.out.println("list empty");
		}
	}
}
