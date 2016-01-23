package cn.xaut.shop.dao;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.GoodsDetial;

public interface GoodsDetialDao extends  CrudRepository<GoodsDetial, Integer>{
	Page<GoodsDetial> find(Page<GoodsDetial> page,Integer goodsId);

	Page<GoodsDetial> findByKey(Page<GoodsDetial> page, String key,
			String goodsID);

	List<GoodsDetial> findByGoods(Integer goodsid);

	List<GoodsDetial> findByType(Integer goodsid);

	List<GoodsDetial> getGoodByItemType(String gtypeID);

	List<GoodsDetial> getItemCount(String itemtype, String itemid, String goodsId);

	List<GoodsDetial> getTypeCount(String goodsId);
}
