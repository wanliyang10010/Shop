package cn.xaut.shop.service;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.GoodsStock;
import cn.xaut.shop.pojo.Order;
public interface GoodsStockService extends BaseServiceR<GoodsStock,Integer>{

	Page<GoodsStock> queryAll(Page<GoodsStock> page, String gid);

	boolean queryCount(String gid, String goodstype);

	List<GoodsStock> getList(Integer gid);

	Integer queryStockAll(String gid);

	void addStock(GoodsStock goodsStock, GoodsService goodsService, Goods goods);

	void updateStock(GoodsStock goodsStock, GoodsService goodsService,
			Goods goods);

	void deleteStock(GoodsStock goodsStock, GoodsService goodsService,
			Goods goods);


}

