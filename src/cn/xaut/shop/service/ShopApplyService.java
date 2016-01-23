package cn.xaut.shop.service;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.ShopApply;
import cn.xaut.shop.pojo.UserInfo;
public interface ShopApplyService extends BaseServiceR<ShopApply,Integer>{
	
	public boolean isApply(int userid);
	public ShopApply getCheckShopName(ShopApply shopApply);
	Page<ShopApply> getAllCheckList(Page<ShopApply> page,String fromdate, String todate,int id);
	public List< ShopApply>  getMyAlterList(int userid,String fromdate,String todate,String state);
	public List< ShopApply>  getMyViewList(int userid,String fromdate,String todate);
	Page<ShopApply> getMyViewList(Page<ShopApply> page,String fromdate, String todate,UserInfo user,int id);
	Page<ShopApply> getAllCheckListNoDate(Page<ShopApply> page,int id);
	public List< ShopApply>  getMyViewListNoDate(int userid);
	public void updateAndSave(ShopApply shopApply,Shop shop);
}

