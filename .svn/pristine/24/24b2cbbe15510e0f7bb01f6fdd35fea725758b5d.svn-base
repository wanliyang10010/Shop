package cn.xaut.shop.dao;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.FavouriteShop;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;

public interface FavouriteShopDao extends CrudRepository<FavouriteShop,Integer> {

	Page<FavouriteShop> queryByUserId(Page<FavouriteShop> page, UserInfo user);
	
	boolean isExits(UserInfo user,Shop shop);

}
