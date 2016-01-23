package cn.xaut.shop.service;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.GoodsTypeItem;
public interface GoodsTypeItemService extends BaseServiceR<GoodsTypeItem,Integer>{
	Page<GoodsTypeItem> GetList(Page<GoodsTypeItem> page, Integer gtypeId, String key);
	Page<GoodsTypeItem> Query(Page<GoodsTypeItem> page, Integer integer);
	List<GoodsTypeItem> getListBytype(Integer typeId);	
	public GoodsTypeItem getGoodsTypeItemByGtitemId(Integer gtitemId);
	Integer getTypeCount(String gtypeId, String itemname);
	GoodsTypeItem getTypeCountUpdate(String gtypeId, String itemname);
}

