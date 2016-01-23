package cn.xaut.shop.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.xaut.shop.pojo.Message;
import cn.xaut.shop.service.MessageService;



public class sendMessage {
	private static MessageService messageService = null;
	private static ClassPathXmlApplicationContext context = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		messageService = (MessageService) context.getBean("messageService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// 结束后销毁对象
		messageService = null;
		context.destroy();
	}

	@Test
	public void testAdd() {
		Message message=new Message();
		message.setText("test");
		message.setUrl("test");
		messageService.sendMessage(messageService,"text", 0, 0, "test", "test", 0);
	}

}
