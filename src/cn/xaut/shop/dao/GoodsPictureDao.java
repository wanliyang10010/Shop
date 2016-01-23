package cn.xaut.shop.dao;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.GoodsPicture;

public interface GoodsPictureDao extends  CrudRepository<GoodsPicture, Integer>{

	Page<GoodsPicture> find(Page<GoodsPicture> page, Integer goodsId);

	List<GoodsPicture> findByType(Integer goodsid);

	List<GoodsPicture> findByGoodsId(Integer goodsid);
	
}
