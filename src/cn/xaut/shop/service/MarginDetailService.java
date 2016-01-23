package cn.xaut.shop.service;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.MarginDetail;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;

public interface MarginDetailService extends BaseServiceR<MarginDetail,Integer>{
	public List< MarginDetail>  getListByShopid( int shopid);
	public Page<MarginDetail> getByShopid(Page<MarginDetail> page, int shopid);
	public void savePunish(MarginDetail model, ShopService shopService,
			Shop shop, MessageService messageService, UserInfo userinfo);
	
}
