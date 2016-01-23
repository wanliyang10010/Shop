package cn.xaut.shop.service;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.MarginDetail;
import cn.xaut.shop.pojo.Shop;
public interface ShopService extends BaseServiceR<Shop,Integer> {

	public Page<Shop> getList(Page<Shop> page,String stype, String key);
	public Page<Shop> queryAll(Page<Shop> page);
	public Page<Shop> getListV(Page<Shop> pageShop, String key);
	public List<Shop>  getMyViewList(int userid,String fromdate,String todate);
	public List<Shop> getListByUserId(int userid);
	//查询店铺ID
	public Shop checkShopidByUserId(int userid);
	//dwj查询所有店铺
    public Page<Shop> getListAllShop(Page<Shop> page);
    //dwj关键字查
    List<Shop> findShopInfoKeyWord (String keyWord);
    public Shop findShopByshopId(Integer shopId);
	public List<Shop> getByState();
	public void updateAndSave(Shop shop,MarginDetail marginDetail);
}
