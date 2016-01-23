package cn.xaut.shop.test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.DeliverAddr;
import cn.xaut.shop.pojo.Favourite;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.Product;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.service.DeliverAddrService;
import cn.xaut.shop.service.FavouriteService;
import cn.xaut.shop.service.GoodsService;
import cn.xaut.shop.service.UserInfoService;

public class MyAddrDaoImplTest {

	private static DeliverAddrService addrService = null;
	private static UserInfoService userService = null;


	private static ClassPathXmlApplicationContext context = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		
		addrService = (DeliverAddrService) context.getBean("deliverAddrService");
		userService = (UserInfoService) context.getBean("userInfoService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// 结束后销毁对象
		addrService = null;
		context.destroy();
	}

	
	@Test
	public void testChange() {
		
		UserInfo user = userService.get(34);
		
		DeliverAddr addr =  addrService.get(12);
		
		//UserInfo user = addr.getUser();
		
		//addrService.update(addr, user);
		
		addr.setUser(user);
		
		addrService.changeDefaultAddr(addr,user);

	}
	
	@Test
	public void testUpdate2() {
		
		UserInfo user = userService.get(34);
		
		DeliverAddr addr =  addrService.get(1);
		
		//addr.setIsdefault("1");
		
		addrService.update(addr, user);

	}
	
	@Test
	public void testExits()
	{
//		UserInfo user = userService.get(34);
//		Goods g = goodsService.get(2);
//		if(favouriteService.isExits(user, g))
//		{
//			System.out.println("找到了");
//		}
//		else
//		{
//			System.out.println("没找到");
//		}
	}

	@Test
	public void testGet() {

//		List<Favourite> list = favouriteService.query();
//
//		if (list != null) {
//			for (Favourite f : list) {
//				System.out.println("\r\n" + "状态 ： --> " + f.getState() + "\r\n");
//			}
//		} else {
//			System.out.println("List Empey");
//		}

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
