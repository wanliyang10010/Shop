package cn.xaut.shop.service.impl;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.ShopEvaluationDao;
import cn.xaut.shop.pojo.ShopEvaluation;
import cn.xaut.shop.service.ShopEvaluationService;

public class ShopEvaluationServiceImpl extends BaseServiceRImpl<ShopEvaluation,Integer> implements ShopEvaluationService {

	private ShopEvaluationDao shopEvaluationDao = null;

	public void setShopEvaluationDao(ShopEvaluationDao shopEvaluationDao) {
		this.shopEvaluationDao = shopEvaluationDao;
	}
	public List<ShopEvaluation> getListByShopId(int shopid) {
		return shopEvaluationDao.getListByShopId(shopid);
	}	
	public Page<ShopEvaluation> getListByShopId(Page<ShopEvaluation> page,int shopid) {
		return shopEvaluationDao.getListByShopId(page,shopid);
	}
}
