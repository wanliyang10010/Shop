package cn.xaut.shop.dao;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.GoodsTypeItem;
public interface GoodsTypeItemDao extends CrudRepository<GoodsTypeItem, Integer>{

	Page<GoodsTypeItem> findByKey(Page<GoodsTypeItem> page, Integer gtypeId, String key);
	Page<GoodsTypeItem> findAll(Page<GoodsTypeItem> page, Integer gtypeid);
	List<GoodsTypeItem> findByType(Integer typeId);
	public GoodsTypeItem findGoodsTypeItemByGtitemId(Integer gtitemId);
	List<GoodsTypeItem> getItemType(String gtypeId, String itemname);
	List<GoodsTypeItem> getItemTypeUpdate(String gtypeId, String itemname,
			String remark);
	
}
