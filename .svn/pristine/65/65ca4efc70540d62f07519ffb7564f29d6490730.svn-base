package cn.xaut.shop.dao;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.GoodsType;
public interface GoodsTypeDao extends CrudRepository<GoodsType, Integer>{
	Page<GoodsType> findByKey(Page<GoodsType> page,String key,String shopId);
	Page<GoodsType> findAll(Page<GoodsType> page,String shopId);
	List<GoodsType> findByShopId(Integer shopId);
	GoodsType findGoodsTypeBygtypeId(Integer gtypeId);
	List<GoodsType> getTypeCount(String shopId, String typename);
	List<GoodsType> getTypeCountUpdate(String shopId, String typename,String remark);
}
