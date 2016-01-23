package cn.xaut.shop.dao;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.Cart;
import cn.xaut.shop.pojo.UserInfo;

public interface CartDao extends  CrudRepository<Cart, Integer>{

	Page<Cart> findAllByPage(Page<Cart> page);
	
	List<Cart> loadCartsByUserId(int userId);
	
	List<Cart> loadCartsByUserInfo(UserInfo user);
	
	Page<Cart> findPageByUser(Page<Cart> page,UserInfo user);
	
	int getItemCount(UserInfo user);
}
