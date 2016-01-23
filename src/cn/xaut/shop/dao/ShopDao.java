package cn.xaut.shop.dao;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.Shop;
public interface ShopDao extends CrudRepository<Shop, Integer>{
   List<Shop>  findByUserId(Integer userid);
   Page<Shop>  find(Page<Shop> page);
   Page<Shop>  findByKey(Page<Shop> page,String stype, String key);
   Page<Shop>  QueryByKey(Page<Shop> page, String key);
	public List<Shop>  getMyViewList(int userid,String fromdate,String todate);
	public List<Shop> getListByUserId(int userid);
	public Shop checkShopidByUserId(int userid);
	//dwj查询所有店铺
    Page<Shop> findByAllShop(Page<Shop> page);
    //dwj关键字list查询
  	public List<Shop> findShopInfoKeyWord (String keyWord);
  	public Shop findShopByshopId(Integer shopId);
	List<Shop> findBySate();
}
