package cn.xaut.shop.dao;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.DateItem;

public interface DateItemDao extends CrudRepository<DateItem, Integer>{
	
	public 	Page<DateItem>  findItemByKey(Page<DateItem> page,String key);
	public 	Page<DateItem>  find(Page<DateItem> page);
	public 	Page<DateItem>  findItemByName(Page<DateItem> page,String name);
}
