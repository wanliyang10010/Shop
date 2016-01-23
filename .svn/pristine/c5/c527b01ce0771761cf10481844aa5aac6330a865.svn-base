package cn.xaut.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.GoodsEvaluationDao;
import cn.xaut.shop.dao.OrderDao;
import cn.xaut.shop.dao.ShopDao;
import cn.xaut.shop.dao.ShopEvaluationDao;
import cn.xaut.shop.dao.UserPointDao;
import cn.xaut.shop.pojo.GoodsEvaluation;
import cn.xaut.shop.pojo.OrderSon;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.ShopEvaluation;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.pojo.UserPoint;
import cn.xaut.shop.service.GoodsEvaluationService;
import cn.xaut.shop.service.OrderSonService;
import cn.xaut.shop.service.UserInfoService;

@Service
@Transactional
public class GoodsEvaluationServiceImpl extends BaseServiceRImpl<GoodsEvaluation,Integer> implements GoodsEvaluationService {

	private GoodsEvaluationDao goodsEvaluationDao = null;
	public void setGoodsEvaluationDao(GoodsEvaluationDao goodsEvaluationDao) {
		this.goodsEvaluationDao = goodsEvaluationDao;

	}
	
	@Autowired
	private OrderSonService orderSonService = null;
	
	@Autowired
	private ShopEvaluationDao shopEvaluationDao = null;
	
	@Autowired
	private ShopDao shopDao = null;
	
	@Autowired
	private UserPointDao userPointDao = null;
	
	@Autowired
	private UserInfoService userInfoService = null;
	
	public  List<GoodsEvaluation>  getListByUserIdAndShopId(int shopid) {
		return goodsEvaluationDao.getListByUserIdAndShopId(shopid);
	}
	public List<GoodsEvaluation>  getListByUserIdAndCheckId(int userid) {
		return goodsEvaluationDao.getListByUserIdAndCheckId(userid);
	}
	public List<GoodsEvaluation>  getListByUserId(int userid) {
		return goodsEvaluationDao.getListByUserId(userid);
	}
	public List<GoodsEvaluation>  getGoodsEvaluationByordersonId(int ordersonId) {
		return goodsEvaluationDao.getGoodsEvaluationByordersonId(ordersonId);
	}
	
	
	public Page<GoodsEvaluation> getListByUserIdAndShopId(Page<GoodsEvaluation> page,int shopid) {
		return goodsEvaluationDao.getListByUserIdAndShopId(page,shopid);
	}
	public Page<GoodsEvaluation> getListByUserIdAndCheckId(Page<GoodsEvaluation> page,int userid) {
		return goodsEvaluationDao.getListByUserIdAndCheckId(page,userid);
	}
	public Page<GoodsEvaluation> getListByUserId(Page<GoodsEvaluation> page,int userid) {
		return goodsEvaluationDao.getListByUserId(page,userid);
	}
	
	
	@Override
	public Page<GoodsEvaluation> getListByGoodId(Page<GoodsEvaluation> page,
			int goodid) {
		return goodsEvaluationDao.findByGoodsId(page,goodid);
	}
	public List<GoodsEvaluation> getListByGoodId(int goodid) {
		return goodsEvaluationDao.getListByGoodId(goodid);

	}
	
	public void saveForFirstEvaluation(GoodsEvaluation goodsEvaluation,OrderSon orderSon,
			ShopEvaluation shopEvaluation,Shop shop,UserPoint userPoint,UserInfo userInfo){
		goodsEvaluationDao.save(goodsEvaluation);// 保存商品评价表
		orderSonService.update(orderSon);
		shopEvaluationDao.save(shopEvaluation);// 保存店铺评价表
		shopDao.update(shop);// 更新店铺表，店铺评分部分
		userPointDao.save(userPoint);// 保存会员积分表
		userInfoService.merge(userInfo);
	}
	
	public void updateForReplyfrombuy(GoodsEvaluation goodsEvaluation,OrderSon orderSon){
		goodsEvaluationDao.update(goodsEvaluation);// 更新商品评价表
		orderSonService.update(orderSon);
	}
	
	public void updateForReplyfromSell(GoodsEvaluation goodsEvaluation,OrderSon orderSon){
		goodsEvaluationDao.update(goodsEvaluation);// 更新商品评价表
		orderSonService.update(orderSon);
	}
	
}
