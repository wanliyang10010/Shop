package cn.xaut.shop.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.MarginDetailDao;
import cn.xaut.shop.dao.ShopDao;
import cn.xaut.shop.pojo.MarginDetail;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.service.ShopService;

@Service
@Transactional
public class ShopServiceImpl extends BaseServiceRImpl<Shop,Integer> implements ShopService {

	private ShopDao shopDao = null;
	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}

	@Autowired
	private MarginDetailDao marginDetailDao=null;
	
	@Override
	public Page<Shop> getList(Page<Shop> page,String stype, String key) {
		return  shopDao.findByKey(page,stype, key);
	}
	public List<Shop> getMyViewList(int userid,String fromdate, String todate) {
		return shopDao.getMyViewList(userid,fromdate,todate);
	}
	//根据userid查询店铺信息
	public Shop checkShopidByUserId(final int userid) {
	   List<Shop> accounts=getListByUserId(userid);
	   System.out.println(accounts.size());
	   if(accounts != null&&accounts.size()>0)
	   {
		   return accounts.get(0);
	   }
	   else
	   {
		  return  null;
	   }
	}
		
		@Override
		public Page<Shop> getListV(Page<Shop> page,String key) {
			return shopDao.QueryByKey(page,key);
		}

		public List<Shop> getListByUserId(int userid) {
			return shopDao.findByUserId(userid);
		}
		@Override
		public Page<Shop> queryAll(Page<Shop> page) {
			return shopDao.find(page);
		}
		 //dwj查询所有店铺
		@Override
		public Page<Shop> getListAllShop(Page<Shop> page) {
			// TODO Auto-generated method stub
			return shopDao.findByAllShop(page);
		}
		//dwj关键字查询
		@Override
		public List<Shop> findShopInfoKeyWord(String keyWord) {
			// TODO Auto-generated method stub
			return shopDao.findShopInfoKeyWord(keyWord);
		}

		@Override
		public Shop findShopByshopId(Integer shopId) {
			return shopDao.findShopByshopId(shopId);
			
		}

		@Override
		public List<Shop> getByState() {
			// TODO Auto-generated method stub
			return shopDao.findBySate();
		}
		
		public void updateAndSave(Shop shop,MarginDetail marginDetail){
			shopDao.update(shop);// 更新店铺表
			marginDetailDao.save(marginDetail);// 添加保证金记录表
		}
}
