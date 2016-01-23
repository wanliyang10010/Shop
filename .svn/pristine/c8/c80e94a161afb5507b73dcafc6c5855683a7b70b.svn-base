package cn.xaut.shop.service;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.GoodsDetial;
public interface GoodsDetialService extends BaseServiceR<GoodsDetial,Integer>{
	Page<GoodsDetial> queryAll(Page<GoodsDetial> page, Integer goodsId);
	Page<GoodsDetial> GetList(Page<GoodsDetial> page, String key, String goodsID);
	List<GoodsDetial> getList(Integer goodsid);
	List<GoodsDetial> getListType(Integer goodsid);
	Integer getGoodByItemType(String gtypeID);
	Integer getItemCount(String itemtype, String itemid, String goodsId);
	boolean getTypeCount(String goodsId, String itemtype);
}

