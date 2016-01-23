package cn.xaut.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.FavouriteShopDao;
import cn.xaut.shop.pojo.FavouriteShop;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.service.FavouriteShopService;

@Service
@Transactional
public class FavouriteShopServiceImpl extends BaseServiceRImpl<FavouriteShop,Integer> implements
		FavouriteShopService {
	
	private FavouriteShopDao favouriteShopDao = null;
	@Autowired
	public void setFavouriteShopDao(FavouriteShopDao favouriteShopDao) {
		this.favouriteShopDao = favouriteShopDao;
	}

	@Override
	public Page<FavouriteShop> queryByUserId(Page<FavouriteShop> page,
			UserInfo user) {
		return favouriteShopDao.queryByUserId(page, user);
	}

	@Override
	public boolean isExits(UserInfo user, Shop shop) {
		return favouriteShopDao.isExits(user, shop);
	}
}
