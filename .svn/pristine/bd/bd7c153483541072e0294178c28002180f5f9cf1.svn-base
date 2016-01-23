package cn.xaut.shop.service;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.StageGoods;
import cn.xaut.shop.pojo.StageOrder;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.pojo.UserPoint;


public interface StageOrderService extends BaseServiceR<StageOrder,Integer>{
	Page<StageOrder> getSaleOrder(Page<StageOrder> page, Integer userid,String fromdate,
			String todate);

	Page<StageOrder> getOrderAdmin(Page<StageOrder> page, String stype,
			String fromdate, String todate);

	StageOrder getOrderCount(String sgoodsId);

	Integer getBygoods(String sgoodsid);

	StageOrder getOrderCheck(String sgoodsId, Integer userinfoId);

	boolean addOrder(StageOrder stageOrder, UserInfoService userInfoService,
			UserInfo user, UserPointService userPointService,
			UserPoint userPoint);

	void updateOrder(StageOrder stageOrder, MessageService messageService,
			UserInfo userinfo);


}
