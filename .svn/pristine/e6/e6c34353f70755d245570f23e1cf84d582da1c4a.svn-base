package cn.xaut.shop.test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.xaut.common.security.dao.ResourceDao;
import cn.xaut.common.security.utils.ParseResouceXml;
import cn.xaut.shop.pojo.Resource;

public class ResourcesInsertTest {

	private static ResourceDao resoDao = null;

	private static ClassPathXmlApplicationContext context = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext-*.xml");

		resoDao = (ResourceDao) context.getBean("resourceDao");

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// 结束后销毁对象
		resoDao = null;
		context.destroy();
	}
	
	@Test
	public void insertResoures() {
		Resource reso = new Resource();
		reso.setDescription("Junit");
		reso.setResourceName("RESO_Junit");
		reso.setResourceString("/test.action");
		
		if(resoDao.addResource(reso))
		{
			System.out.println("添加资源 -> " + reso.getResourceName());
		}
		
	}

	@Test
	public void SaveResoures() {

		List<Resource> list = ParseResouceXml.read();
		if (list == null)
			return;

		String strResoName = "";
		int nSussess = 0;
		int nFail = 0;
		for (Resource reso : list) {

			strResoName = this.createResourceName(reso.getResourceString());

			Resource exist = resoDao.findResourceByResourceName(strResoName);
			if (exist != null) {
				System.out.println("资源 : " + exist.getResourceName() + " -> "
						+ exist.getResourceString() + "已存在");
			} else {

				reso.setIsSys(0);
				reso.setEnabled(0);
				reso.setResourceName(strResoName);

				// System.out.println(reso.getResourceName());
				// System.out.println(reso.getResourceString());
				// System.out.println(reso.getType());
				// System.out.println(reso.getDescription());
				
				
				if(resoDao.addResource(reso))
				{
					System.out.println("添加资源 -> " + reso.getResourceName());
					nSussess++;
				}
				else
					nFail++;
			}
		}
		System.out.println("共添加资源：" + nSussess + "条，失败 :" + nFail + "条");
	}

	private String createResourceName(String Name) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("RESO_");

		int begin = Name.indexOf("/") + 1;// 找第一个斜杠/
		// System.out.println("begin " + begin);
		int end = Name.indexOf(".", begin);

		if (end >= 0)
			buffer.append(Name.substring(begin, end));
		else
			buffer.append(Name.substring(begin));

		String ResName = buffer.toString(); 
		if(ResName.indexOf("/") > 0)
		{
			System.out.println("HHHH");
			ResName = ResName.replace("/", "_");
		}
		
		return ResName;
	}

	@Test
	public void testUpdate() {

	}

	@Test
	public void loadlist() {

		String test = "RESO_Test";

		Resource reso = resoDao.findResourceByResourceName(test);
		if (reso != null) {
			System.out.println();
			System.out.println("找到了资源");
			System.out.println();
		} else {
			System.out.println();
			System.out.println("没找到资源");
			System.out.println();
		}
	}

	@Test
	public void testQuery() {

	}

	@Test
	public void testDelete() {

	}

}
