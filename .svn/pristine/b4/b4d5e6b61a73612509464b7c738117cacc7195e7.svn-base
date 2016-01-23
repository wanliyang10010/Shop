package cn.xaut.shop.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.ShopApplyDao;
import cn.xaut.shop.dao.ShopDao;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.ShopApply;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.service.ShopApplyService;

@Service
@Transactional
public class ShopApplyServiceImpl extends BaseServiceRImpl<ShopApply,Integer> implements
		ShopApplyService {
	
	private ShopApplyDao shopApplyDao = null;
	public void setShopApplyDao(ShopApplyDao shopApplyDao) {
		this.shopApplyDao = shopApplyDao;
	}
	@Autowired
	private ShopDao shopDao=null;
	
	public boolean isApply(int userid){
		return shopApplyDao.isApply(userid);
	}
	@Override
	public ShopApply getCheckShopName(ShopApply shopApply) {		
		return shopApplyDao.getCheckShopName(shopApply);
	}

	@Override
	public Page<ShopApply> getAllCheckList(Page<ShopApply> page,String fromdate, String todate,int id)
	{
		return shopApplyDao.getAllCheckList(page, fromdate,todate,id);
	}	

	@Override
	public List<ShopApply> getMyAlterList(int userid,String fromdate, String todate,
			String state) {
		return shopApplyDao.getMyAlterList(userid,fromdate,todate,state);
	}

	@Override
	public List<ShopApply> getMyViewList(int userid,String fromdate, String todate) {
		return shopApplyDao.getMyViewList(userid,fromdate,todate);
	}
	@Override
	public Page<ShopApply> getMyViewList(Page<ShopApply> page,String fromdate, String todate,UserInfo user,int id)
	{
		return shopApplyDao.getMyViewList(page, fromdate,todate,user,id);
	}	
	@Override
	public Page<ShopApply> getAllCheckListNoDate(Page<ShopApply> page, int id) {
		return shopApplyDao.getAllCheckListNoDate(page, id);
	}

	@Override
	public List<ShopApply> getMyViewListNoDate(int userid) {
		return shopApplyDao.getMyViewListNoDate(userid);
	}
	
	public void updateAndSave(ShopApply shopApply,Shop shop){
		shopApplyDao.update(shopApply);// 更新店铺申请表
		shopDao.save(shop);// 添加店铺表
	}
	
	
}
