package cn.xaut.shop.dao;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.StageGoods;

public interface StageGoodsDao extends CrudRepository<StageGoods, Integer>{
	
	public 	Page<StageGoods>  findItemByKey(Page<StageGoods> page,String key);
	public 	Page<StageGoods>  queryByKey(Page<StageGoods> page,String key);
	public 	Page<StageGoods>  find(Page<StageGoods> page);
	public 	Page<StageGoods>  findItemByName(Page<StageGoods> page,String name);
	public List<StageGoods> getCount(String goodsname);
}
