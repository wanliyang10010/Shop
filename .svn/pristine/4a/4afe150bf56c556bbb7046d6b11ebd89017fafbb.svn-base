package cn.xaut.shop.dao;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.GoodsStock;

public interface GoodsStockDao extends  CrudRepository<GoodsStock, Integer>{

	Page<GoodsStock> queryAll(Page<GoodsStock> page,String gid);

	List<GoodsStock> queryCount(String gid, String goodstype);

	List<GoodsStock> GetList(Integer gid);
	
	public GoodsStock findbyGoodstype(Integer goodsid ,String property);
	
}
