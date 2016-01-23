package cn.xaut.shop.service;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.FavouriteShop;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;


public interface FavouriteShopService extends BaseServiceR<FavouriteShop,Integer>{

	/**
	 * 根据用户id查询收藏的店铺
	 * 
	 * @param userinfo
	 * @return 分页
	 */
	public Page<FavouriteShop> queryByUserId(Page<FavouriteShop> page, UserInfo user);
	
	/**
	 * 是否已收藏该店铺
	 * 
	 * @param  用户
	 * @param  店铺
	 * @return true-已收藏
	 */
	boolean isExits(UserInfo user,Shop shop);
}
