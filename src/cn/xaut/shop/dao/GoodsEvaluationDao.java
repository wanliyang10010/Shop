package cn.xaut.shop.dao;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.GoodsEvaluation;

public interface GoodsEvaluationDao extends CrudRepository< GoodsEvaluation, Integer> {

	Page<GoodsEvaluation> findByGoodsId(Page<GoodsEvaluation> page, int goodid);
	public List<GoodsEvaluation>  getListByUserIdAndShopId(int shopid);
	public List<GoodsEvaluation>  getListByUserIdAndCheckId(int userid);
	public List<GoodsEvaluation>  getListByUserId(int userid);
	public List<GoodsEvaluation> getGoodsEvaluationByordersonId(int ordersonId);
	
	public Page<GoodsEvaluation> getListByUserIdAndShopId(Page<GoodsEvaluation> page, int shopid);
	public Page<GoodsEvaluation> getListByUserIdAndCheckId(Page<GoodsEvaluation> page, int userid);
	public Page<GoodsEvaluation> getListByUserId(Page<GoodsEvaluation> page, int userid);
		
	public List<GoodsEvaluation> getListByGoodId(int goodid);
	
}
