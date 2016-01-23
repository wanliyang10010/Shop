package cn.xaut.shop.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.xaut.shop.pojo.Cart;
import cn.xaut.shop.pojo.CartItem;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.service.CartService;

public class CartSerciceImplTest {

	private static CartService cartService = null;

	private static ClassPathXmlApplicationContext context = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		cartService = (CartService) context.getBean("cartService");

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// 结束后销毁对象
		cartService = null;
		context.destroy();
	}

	@Test
	public void testSave() {
		Cart model = new Cart();
		Shop shop = new Shop();
		shop.setShopId(24);
		model.setShop(shop);
		model.setRemark("JUnit");
		cartService.save(model);
	}

	@Test
	public void testUpdate() {

		Cart model = cartService.get(22);
		String date = (new Date()).toString();
		Timestamp time = Timestamp.valueOf(date);
		model.setCreateTime(time);
		cartService.update(model);
	}

	@Test
	public void testGet() {
		Cart cart = cartService.get(58);
		System.out.println(cart.getTotal());
		System.out.println(cart.getUserInfo().getUsername());
	}

	@Test
	public void loadCartlist() {
		for (Cart model : cartService.loadCartsByUserId(34)) {
			
			System.out.println("购物车id :" + model.getCartId() + "总价: "
					+ model.getTotal());
		}
	}
	
	@Test
	public void loadCartlist2() {
		
		UserInfo user = new UserInfo();
		user.setUserinfoId(34);
		for (Cart model : cartService.loadCartsByUserInfo(user)) {
			
			System.out.println("购物车id :" + model.getCartId() + "总价: "
					+ model.getTotal());
		}
	}

	@Test
	public void testQuery() {
		for (Cart model : cartService.query()) {
			System.out.println(model.getRemark());
		}
	}

	@Test
	public void testDelete() {
		cartService.delete(2015010102);
	}
	
	//测试级联cascade="all-delete-orphan"
	@Test
	public void testRemoveCascade()
	{
		Cart cart = cartService.get(245);
		CartItem rm = null;
		Set<CartItem> sets = cart.getCartitems();
		System.out.println();
		for(CartItem item:sets)
		{
			System.out.println(item.getItemname());
			System.out.println("ItemId -> "+item.getItemId());
			rm = item;
		}
		System.out.println("==========remove=========");
		
		sets.remove(rm);
		
		cartService.calcTotal(cart);
		
		System.out.println("==========update=========");
		
		cartService.update(cart);
	}

}
