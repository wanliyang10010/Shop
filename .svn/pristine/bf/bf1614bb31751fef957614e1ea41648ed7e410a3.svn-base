package cn.xaut.shop.service;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.GoodsEvaluation;
import cn.xaut.shop.pojo.OrderSon;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.ShopEvaluation;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.pojo.UserPoint;
public interface GoodsEvaluationService extends BaseServiceR<GoodsEvaluation,Integer>{
	public List< GoodsEvaluation>  getListByUserIdAndShopId(int shopid);
	public List< GoodsEvaluation>  getListByUserIdAndCheckId(int userid);
	public List< GoodsEvaluation>  getListByUserId(int userid);
	public List<GoodsEvaluation> getGoodsEvaluationByordersonId(int ordersonId);
	
	public Page<GoodsEvaluation> getListByUserIdAndShopId(Page<GoodsEvaluation> page, int shopid);
	public Page<GoodsEvaluation> getListByUserIdAndCheckId(Page<GoodsEvaluation> page, int userid);
	public Page<GoodsEvaluation> getListByUserId(Page<GoodsEvaluation> page, int userid);
	
	public Page<GoodsEvaluation> getListByGoodId(Page<GoodsEvaluation> pageEva, int goodid);
	
	public void saveForFirstEvaluation(GoodsEvaluation goodsEvaluation,OrderSon orderSon,
			ShopEvaluation shopEvaluation,Shop shop,UserPoint userPoint,UserInfo userInfo);
	public void updateForReplyfrombuy(GoodsEvaluation goodsEvaluation,OrderSon orderSon);
	public void updateForReplyfromSell(GoodsEvaluation goodsEvaluation,OrderSon orderSon);
}
