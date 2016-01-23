package cn.xaut.shop.service;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.GoodsDetial;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;
public interface GoodsService extends BaseServiceR<Goods,Integer>{
	//根据ID查询出具体一条记录
	public Goods queryGoodsByid(int gid);
	public List<Goods> queryGoodsByCid(final int cid);
	// 根据商品ID,查询商品
    public List<Goods> queryGoodsByGid(int gid);
    public Page<Goods> getListPrice(Page<Goods> page,String p,String keyword);
    public Page<Goods> getList(Page<Goods> page,String keyword, Integer sid);
    public Page<Goods> getListDH(Page<Goods> page,String key,String stype, Integer sid);
	public Page<Goods> getShop(Page<Goods> page,Integer sid);
	public Page<Goods> getListSH(Page<Goods> page,int sid);
	public Page<Goods> getList(Page<Goods> page,String keyword);
	public Page<Goods> getListH(Page<Goods> page);
	public Page<Goods> getListD(Page<Goods> page);
	public Page<Goods> getListSD(Page<Goods> page, String format, Integer shopId);
	public List<Goods> getById(Integer goodsid);
	public Page<Goods> getListSale(Page<Goods> page,String key);
	public Page<Goods> getListType(Page<Goods> page, String type);
	public List<Goods> getGoodsMoeny(Integer shopid,  String key);
	public Page<Goods> getSaleGoods(Page<Goods> page, Integer shopid,String key);
	public double getTotal(List<Goods> list);
	//dwj查询所有商品
	public Page<Goods> getListAllGood(Page<Goods> page);
	//关键字list查询
	List<Goods> findGoodsInfoKeyWord (String keyWord);
	//dwjSET集合
	public List<Goods> getShopSet(Integer sid);
	
	public Goods getGoodsByGoodsId(Integer goodsid);
	public Integer getByType(String gtypeID);
	public Page<Goods> getByShopKey(Page<Goods> page, String shopId, String key);
	public Page<Goods> getByState(Page<Goods> page);
	public Page<Goods> getTop(Page<Goods> page);
	public Page<Goods> ViewShop(Page<Goods> page, Integer sid);
	public List<Goods> getGoodsTypeMoeny(Integer parseInt, String typeid, String key);
	public void updateGoods(Goods good, MessageService messageService,
			UserInfo userinfo, Shop shop);
	public List<Goods> getByType(Integer goodsid, Integer typeid);
	public Page<Goods> getListShand(Page<Goods> page, String keyword);
	public Page<Goods> getShand(Page<Goods> page);
	public Page<Goods> getListShandByKey(Page<Goods> page, String keyword,
			String type);

	

}

