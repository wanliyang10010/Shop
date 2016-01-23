package cn.xaut.shop.service;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.GoodsPicture;
public interface GoodsPictureService extends BaseServiceR<GoodsPicture,Integer>{
	Page<GoodsPicture> queryAll(Page<GoodsPicture> page, Integer goodsId);
	List<GoodsPicture> getPictureList(Integer goodsid);	
	List<GoodsPicture> getList(Integer goodsid);
}