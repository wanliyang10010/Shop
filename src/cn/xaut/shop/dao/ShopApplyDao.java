package cn.xaut.shop.dao;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.ShopApply;
import cn.xaut.shop.pojo.UserInfo;

public interface ShopApplyDao extends CrudRepository<ShopApply,Integer> {	
	boolean isApply(int userid);
	ShopApply getCheckShopName(ShopApply shopApply);
	Page<ShopApply> getAllCheckList(Page<ShopApply> page,String fromdate, String todate,int id);	
	List<ShopApply> getMyAlterList(int userid,String fromdate, String todate,
			String state);
	List<ShopApply> getMyViewList(int userid,String fromdate, String todate);
	Page<ShopApply> getMyViewList(Page<ShopApply> page,String fromdate, String todate,UserInfo user,int id);
	Page<ShopApply> getAllCheckListNoDate(Page<ShopApply>page,int id);
	List<ShopApply> getMyViewListNoDate(int userid);
}
