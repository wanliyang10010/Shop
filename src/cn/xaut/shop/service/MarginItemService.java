package cn.xaut.shop.service;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.MarginItem;
public interface MarginItemService extends BaseServiceR<MarginItem,Integer>{
	Page<MarginItem> getList(Page<MarginItem> page,String key);
	Page<MarginItem> queryAll(Page<MarginItem> page);
	Page<MarginItem> findItem(Page<MarginItem> page,String itemname);
} 
