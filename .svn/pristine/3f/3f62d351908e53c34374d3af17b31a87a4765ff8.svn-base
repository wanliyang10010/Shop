package cn.xaut.shop.dao;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.ShopEvaluation;

public interface ShopEvaluationDao extends CrudRepository<ShopEvaluation,Integer> {	
	public List<ShopEvaluation>  getListByShopId(int shopid);
	public Page<ShopEvaluation>  getListByShopId(Page<ShopEvaluation> page,int shopid);
}
