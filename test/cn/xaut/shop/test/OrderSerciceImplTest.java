package cn.xaut.shop.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.OrderSon;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.service.OrderService;
import cn.xaut.shop.service.UserInfoService;

public class OrderSerciceImplTest {

	private static OrderService orderService = null;
	private static UserInfoService userService = null;

	private static ClassPathXmlApplicationContext context = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		orderService = (OrderService) context.getBean("orderService");
		userService = (UserInfoService) context.getBean("userInfoService");

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// 结束后销毁对象
		orderService = null;
		context.destroy();
	}

	@Test
	public void testSave() {
		Order model = new Order();
		
		OrderSon son = new OrderSon();
		Goods good = new Goods();
		good.setGoodsid(93);
		
		UserInfo user = userService.get(65);
		
		Shop shop = new Shop();
		shop.setShopId(165);
		
		model.setShop(shop);
		model.setUser(user);
		model.setShopname("JUnit");
		
		son.setAmount(10);
		son.setGoods(good);
		
		son.setOrder(model);
		
		son.setGoodsName("YWL");
		son.setPrice(10.5d);
		
		model.getSons().add(son);
		
		orderService.save(model);
	}
//
//	@Test
//	public void testUpdate() {
//
//		Order model = orderService.get(2015010102);
//		model.setUsername("update111");
//		orderService.update(model);
//	}
//
//	@Test
//	public void testGet() {
//		Order model = orderService.get(2015010102);
//		System.out.println(model.getUsername());
//	}
//
//	@Test
//	public void testQuery() {
//		for (Order model : orderService.query()) {
//			System.out.println(model.getUsername());
//		}
//	}
//
//	@Test
//	public void testDelete() {
//		orderService.delete(2015010102);
//	}

}
