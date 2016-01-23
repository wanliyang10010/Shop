package cn.xaut.shop.dao;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.MarginItem;

public interface MarginItemDao extends CrudRepository<MarginItem, Integer>{
	public Page<MarginItem> findByKey(Page<MarginItem> page,String key);
	public Page<MarginItem> find(Page<MarginItem> page);
	public Page<MarginItem> findName(Page<MarginItem> page,String itemname);
}
