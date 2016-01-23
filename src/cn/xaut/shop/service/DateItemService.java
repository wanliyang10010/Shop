package cn.xaut.shop.service;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.DateItem;


public interface DateItemService extends BaseServiceR<DateItem,Integer>{

	Page<DateItem> getList(Page<DateItem> page,String key);
	Page<DateItem> queryAll(Page<DateItem> page);
	Page<DateItem> findItem(Page<DateItem> page,String itemname);

}
