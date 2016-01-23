package cn.xaut.shop.service;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.Favourite;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.UserInfo;

public interface FavouriteService extends BaseServiceR<Favourite,Integer> {

	/**
	 * 根据用户id查询收藏商品
	 * 
	 * @param userinfo
	 * @return 分页
	 */
	public Page<Favourite> queryByUserId(Page<Favourite> page, UserInfo user);
	
	/**
	 * 是否已收藏该商品
	 * @param product_id 商品Id
	 * @return true-已收藏
	 */
	boolean isExits(UserInfo user,Goods good);
	
	

}
