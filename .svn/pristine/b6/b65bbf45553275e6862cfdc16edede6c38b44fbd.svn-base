package cn.xaut.shop.service.impl;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.StageOrderDao;
import cn.xaut.shop.pojo.StageGoods;
import cn.xaut.shop.pojo.StageOrder;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.pojo.UserPoint;
import cn.xaut.shop.service.MessageService;
import cn.xaut.shop.service.StageOrderService;
import cn.xaut.shop.service.UserInfoService;
import cn.xaut.shop.service.UserPointService;
public class StageOrderServiceImpl extends BaseServiceRImpl<StageOrder,Integer> implements StageOrderService{

	private StageOrderDao stageOrderDao = null;
	public void setStageOrderDao(StageOrderDao stageOrderDao) {
		this.stageOrderDao = stageOrderDao;
	}
	@Override
	public Page<StageOrder> getSaleOrder(Page<StageOrder> page,Integer userid,
			String fromdate, String todate) {
		return stageOrderDao.getSalePage(page,userid,fromdate,todate);
	}
	@Override
	public Page<StageOrder> getOrderAdmin(Page<StageOrder> page, String stype,
			String fromdate, String todate) {
		return stageOrderDao.getAdminPage(page,stype,fromdate,todate);
	}
	@Override
	public StageOrder getOrderCount(String sgoodsId) {
		List<StageOrder> list=stageOrderDao.getOrderCount(sgoodsId);
		if(list!=null&&list.size()>0)
		{
			return list.get(0);
		}
		else
		{
			return null;
		}
	}
	@Override
	public Integer getBygoods(String sgoodsid) {
		// TODO Auto-generated method stub
		List<StageOrder> list=stageOrderDao.getOrderCount(sgoodsid);
		if(list!=null&&list.size()>0)
		{
			return list.size();
		}
		else
		{
			return 0;
		}
	}
	@Override
	public StageOrder getOrderCheck(String sgoodsId, Integer userinfoId) {
		// TODO Auto-generated method stub
		List<StageOrder> list=stageOrderDao.getOrderCheck(sgoodsId,userinfoId);
		if(list!=null&&list.size()>0)
		{
			return list.get(0);
		}
		else
		{
			return null;
		}
	}
	@Override
	public boolean addOrder(StageOrder stageOrder,
			UserInfoService userInfoService, UserInfo user,
			UserPointService userPointService, UserPoint userPoint) {
		// TODO Auto-generated method stub
		stageOrderDao.add(stageOrder);
		userPointService.save(userPoint);// 保存会员积分表
		userInfoService.update(user);
		return true;
	}
	@Override
	public void updateOrder(StageOrder stageOrder,
			MessageService messageService, UserInfo userinfo) {
		// TODO Auto-generated method stub
		stageOrderDao.update(stageOrder);
		messageService.sendMessage(messageService,"您的一件积分兑换商品已经发货！", userinfo.getUserinfoId(), stageOrder.getUser().getUserinfoId(),
				"stageOrderAction_opensale.action", null, null);
	}
}
