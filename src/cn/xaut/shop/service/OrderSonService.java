package cn.xaut.shop.service;

import java.util.List;

import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.OrderSon;

public interface OrderSonService extends BaseService<OrderSon>{

	public OrderSon getCheckByid(int id);
	
	public List<OrderSon> queryOrderById(int id);
	
	public Goods queryOrderBygid(int gid);
	
	public Goods queryOrderBygname(String gname);
	
	public List<OrderSon> queryOrderSonByShopname(String shopname);
	
	public List<OrderSon> queryOrderSonById(int id);

	public String getByGoodsId(Integer goodsid);

	public Integer getByGoodsIdAll(String goodsid);
	
}
