package cn.xaut.shop.dao;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.StageOrder;

public interface StageOrderDao extends CrudRepository<StageOrder, Integer>{
	public Page<StageOrder> getSalePage(Page<StageOrder> page, Integer userid,String fromdate,
			String todate);

	public Page<StageOrder> getAdminPage(Page<StageOrder> page, String stype,
			String fromdate, String todate);

	public List<StageOrder> getOrderCount(String sgoodsId);

	public List<StageOrder> getOrderCheck(String sgoodsId, Integer userinfoId);
}
