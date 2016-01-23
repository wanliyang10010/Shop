package cn.xaut.shop.service;
import java.util.List;
import cn.xaut.shop.pojo.Discount;
import cn.xaut.shop.pojo.Goods;
public interface DiscountService extends BaseServiceR<Discount,Integer>{
	public Discount getModel(Integer goodsid);
	public List<Discount> getListD(String date);
	public List<Discount> getListSD(String date, int sid);
	public Discount saveDiscount(Discount model, GoodsService goodsService,
			Goods good);
	public void deleteDiscount(Integer id, GoodsService goodsService,
			Goods good);
}
