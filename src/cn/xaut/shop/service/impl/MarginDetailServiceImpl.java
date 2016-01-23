package cn.xaut.shop.service.impl;

import java.util.List;
import cn.xaut.shop.dao.MarginDetailDao;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.MarginDetail;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.service.MarginDetailService;
import cn.xaut.shop.service.MessageService;
import cn.xaut.shop.service.ShopService;


public class MarginDetailServiceImpl extends BaseServiceRImpl<MarginDetail,Integer> implements MarginDetailService {

	private MarginDetailDao marginDetailDao = null;

	public void setMarginDetailDao(MarginDetailDao marginDetailDao) {
		this.marginDetailDao = marginDetailDao;
	}

	public List<MarginDetail> getListByShopid(int shopid) {
		return marginDetailDao.getListByShopid(shopid);

	}

	@Override
	public Page<MarginDetail> getByShopid(Page<MarginDetail> page, int shopid) {
		
		return marginDetailDao.findByShopid(page,shopid);
	}

	@Override
	public void savePunish(MarginDetail model, ShopService shopService,
			Shop shop, MessageService messageService,UserInfo userinfo) {
		// TODO Auto-generated method stub
		model=marginDetailDao.add(model);
		shopService.update(shop);
		messageService.sendMessage(messageService,"您的店铺由于违规操作受到处罚，请查看！", userinfo.getUserinfoId(),shop.getUserinfo().getUserinfoId(),
					"marginDetailAction_queryByShopid.action", "shopId", shop.getShopId());
	}
}
