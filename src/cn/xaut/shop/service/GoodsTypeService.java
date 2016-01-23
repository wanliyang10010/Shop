package cn.xaut.shop.service;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.GoodsType;
public interface GoodsTypeService extends BaseServiceR<GoodsType,Integer>{
	Page<GoodsType> GetList(Page<GoodsType> page,String key,String shopId);
	Page<GoodsType> Query(Page<GoodsType> page,String shopId);
	List<GoodsType> getListByShopId(Integer shopId);
	GoodsType getGoodsTypeById(Integer gtypeId);
	Integer getTypeCount(String shopId, String typename);
	Integer getTypeCountUpdate(String shopId, String typename,String remark);
}

