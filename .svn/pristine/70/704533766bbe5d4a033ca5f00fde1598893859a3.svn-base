package cn.xaut.shop.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.xaut.shop.dao.GoodsDao;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.service.GoodsService;

/**测试商品修改库存 及 下架*/
public class GoodsSerciceTest {

	/**测试商品修改库存 及 下架*/
	private static GoodsService goodsService = null;
	private static GoodsDao goodsDao = null;

	private static ClassPathXmlApplicationContext context = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		//goodsService = (GoodsService) context.getBean("goodsService");
		goodsDao = (GoodsDao) context.getBean("goodsDao");

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// 结束后销毁对象
		goodsService = null;
		goodsDao = null;
		context.destroy();
	}

//	@Test
//	public void testSave() {
//		Cart model = new Cart();
//		Shop shop = new Shop();
//		shop.setShopId(24);
//		model.setShop(shop);
//		model.setRemark("JUnit");
//		cartService.save(model);
//	}

	/**
	 * 测试修改库存
	 */
	@Test
	public void testUpdateAmount() {

		Goods model = goodsDao.findById(234);
		
		System.out.println("库存" + model.getAmount());
		
		goodsDao.minGoodAmount(234, 1);
	}


}
