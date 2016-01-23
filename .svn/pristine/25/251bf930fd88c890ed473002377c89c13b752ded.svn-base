package cn.xaut.shop.dao;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.Goods;

public interface GoodsDao extends  CrudRepository<Goods, Integer>{
	Page<Goods> findByKey(Page<Goods> page,String key);
	Page<Goods> findByKeyShopId(Page<Goods> page,String key,Integer sid);
	Page<Goods> findHotByShopId(Page<Goods> page,int sid);
	Page<Goods> queryByShopId(Page<Goods> page,int sid);
	Page<Goods> findAllHot(Page<Goods> page);
	Page<Goods> queryAllHot(Page<Goods> page);
	Page<Goods> findDHByShopId(Page<Goods> page,String key, String stype,Integer sid);
	Page<Goods> findByPrice(Page<Goods> page,String p,String keyword);
	Page<Goods> queryDiscount(Page<Goods> page);
	Page<Goods> queryShopDiscount(Page<Goods> page, String date, Integer shopId);
	List<Goods>  findByGoodsId(Integer goodsid);
	Page<Goods> querySale(Page<Goods> page,String keyword);
	Page<Goods> queryType(Page<Goods> page, String type);
	//dwj查询所有商品
    Page<Goods> findByAllGood(Page<Goods> page);
	//dwj关键字list查询
	public List<Goods> findGoodsInfoKeyWord (String keyWord);
	//dwjSET集合
	public List<Goods> getShopSet(Integer sid);

	/**
	 * 减库存,没有商品类型的的情况
	 */
	public int minGoodAmount(Integer goodsid , final Integer amount);
	
	/**
	 * 减少库存，有商品类型的情况
	 * @param property 商品类型值
	 */
	public int minGoodAmountProperty(int goodsid,final int amount,final String property);
	
	/**
	 * 取消订单，还原库存
	 * @param goodsid 商品ID
	 * @param amount 还原的商品数量
	 * @return
	 */
	public int rollBackGoodAmount(Integer goodsid , final Integer amount);
	
	/**
	 * 取消定单后的库存还原
	 * @param property 商品类别信息
	 * */
	public int rollBackGoodAmountProperty(int goodsid, int amount,String property); 
	
	/**
	 * 增加销售数量
	 * @param goodsId 商品ID
	 * @param sellAmount 销售数量
	 */
	public int increaseSellAmount(Integer goodsId , final Integer sellAmount);
	
	/**
	 * 减少销售数量 ywl
	 * @param goodsId 商品ID
	 * @param sellAmount 销售数量
	 */
	public int decreaseSellAmount(Integer goodsId , final Integer sellAmount);
	
	List<Goods> getGoodsList(Integer shopid, String key);
	
	//根据Goods的goodsid活动goods
	public Goods findGoodsByGoodsId(Integer goodsid);
	List<Goods> findGoodsByTypeId(String gtypeID);
	Page<Goods> findByShopKey(Page<Goods> page, String shopId, String key);
	Page<Goods> findByState(Page<Goods> page);
	Page<Goods> findTop(Page<Goods> page);
	Page<Goods> queryViewShopId(Page<Goods> page, Integer sid);
	List<Goods> getGoodsTypeList(Integer shopid, String typeid, String key);
	List<Goods>  getType(Integer typeid, Integer goodsid);
	Page<Goods> findShandByKey(Page<Goods> page, String keyword);
	Page<Goods> findShand(Page<Goods> page);
	Page<Goods> findShandByType(Page<Goods> page, String keyword, String type); 
}
