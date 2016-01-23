package cn.xaut.shop.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.Product;
import cn.xaut.shop.service.ProductService;
import cn.xaut.shop.service.UserInfoService;

public class ProductServiceImplTest {

	private static UserInfoService userService = null;
	private static ProductService productService = null;

	private static ClassPathXmlApplicationContext context = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext-*.xml");

		userService = (UserInfoService) context.getBean("userInfoService");
		productService = (ProductService) context.getBean("productService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// 结束后销毁对象
		userService = null;
		productService = null;

		context.destroy();
	}

	@Test
	public void testSave() {
		// Favourite model = new Favourite();
		// Product p = productService.get(3);
		// System.out.println("商品 ： " + p.getProductName());
		//
		// UserInfo user = userService.get(34);
		//
		// model.setProduct(p);
		// model.setUser(user);
		// model.setState("JUnit");
		// favouriteService.save(model);
	}

	@Test
	public void testUpdate() {

	}

	@Test
	public void testGetPage() {

		Page<Product> page = new Page<Product>();

		page = productService.findAllByPage(page);

		if (page.getResult() != null) {
			for (Product p : page.getResult()) {
				System.out
						.println("\r\n" + "商品 ： --> " + p.getProductName() + "\r\n");
			}
		} else {
			System.out.println("List Empey");
		}

	}

	@Test
	public void loadlist() {

//		Page<Favourite> page = new Page<Favourite>();
//
//		// page.setCountTotal(false);
//
//		UserInfo user = userService.get(34);
//
//		page = favouriteService.queryByUserId(page, user);
//
//		System.out.println("page -> " + page.getResult().size());
//
//		List<Favourite> t = page.getResult();
//		for (Favourite model : t) {
//			System.out.println("收藏 :" + model.getState());
//		}
	}

	@Test
	public void testQuery() {

	}

	@Test
	public void testDelete() {

	}

}
