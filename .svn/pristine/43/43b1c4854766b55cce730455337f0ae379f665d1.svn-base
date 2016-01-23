package cn.xaut.shop.service.impl;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.FavouriteDao;
import cn.xaut.shop.pojo.Favourite;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.service.FavouriteService;

public class FavouriteServiceImpl extends BaseServiceRImpl<Favourite,Integer> implements FavouriteService {
	
	private FavouriteDao favouriteDao = null;
	public void setFavouriteDao(FavouriteDao favouriteDao) {
		this.favouriteDao = favouriteDao;
	}

	public Page<Favourite> queryByUserId(Page<Favourite> page,UserInfo user) {
		return favouriteDao.queryByUserId(page, user);
	}

	@Override
	public boolean isExits(UserInfo user, Goods good) {
		return favouriteDao.isExits(user,good);
	}
}
