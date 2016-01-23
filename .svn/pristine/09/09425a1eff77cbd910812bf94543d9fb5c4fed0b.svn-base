package cn.xaut.shop.dao;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.PointsItem;

public interface PointsItemDao extends CrudRepository< PointsItem, Integer>{
	public Page<PointsItem> findByKey(Page<PointsItem> page,String key);
	public Page<PointsItem> find(Page<PointsItem> page);
	public Page<PointsItem> findByName(Page<PointsItem> page,String name);
}
