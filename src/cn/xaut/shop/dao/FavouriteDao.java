package cn.xaut.shop.dao;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.Favourite;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.UserInfo;

public interface FavouriteDao extends  CrudRepository<Favourite, Integer>{

	Page<Favourite> queryByUserId(Page<Favourite> page, UserInfo user);
	
	boolean isExits(UserInfo user,Goods good);

}
