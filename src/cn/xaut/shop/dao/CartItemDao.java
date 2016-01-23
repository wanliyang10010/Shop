package cn.xaut.shop.dao;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.CartItem;

public interface CartItemDao extends CrudRepository<CartItem, Integer> {

	Page<CartItem> findAllByPage(Page<CartItem> page);
	
	List<CartItem> findCartItemByCartId(int cartId);

	//public void clearCartItem(Set<CartItem> items);

}
