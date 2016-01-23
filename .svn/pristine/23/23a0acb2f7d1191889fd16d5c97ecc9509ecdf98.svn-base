package cn.xaut.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import cn.xaut.common.paging.domain.Page;
import cn.xaut.common.paging.domain.PageRequest;
import cn.xaut.shop.dao.OrderDao;
import cn.xaut.shop.dao.ProlongApplyDao;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.ProlongApply;
import cn.xaut.shop.service.ProlongApplyService;

@Service
@Transactional
public class ProlongApplyServiceImpl extends BaseServiceRImpl<ProlongApply,Integer> implements ProlongApplyService {

	private ProlongApplyDao prolongApplyDao = null;
	public void setProlongApplyDao(ProlongApplyDao prolongApplyDao) {
		this.prolongApplyDao = prolongApplyDao;
	}
	
	@Autowired
	private OrderDao orderDao = null;
	
	public List<ProlongApply> getMyCheckList(int shopId,String fromdate, String todate,
			String state) {
		return prolongApplyDao.getMyCheckList(shopId,fromdate,todate,state);
	}
	public List<ProlongApply> getMyAlterList(int userid,String fromdate,String todate,String state) {
		return prolongApplyDao.getMyAlterList(userid,fromdate,todate,state);
	}
	public List<ProlongApply> getMyViewList(int userid,String fromdate, String todate) {
		return prolongApplyDao.getMyViewList(userid,fromdate, todate);
	}
	public List<ProlongApply> getMyViewListSell(int shopId,String fromdate, String todate) {
		return prolongApplyDao.getMyViewListSell(shopId,fromdate, todate);
	}
	
	public Page<ProlongApply>  getMyCheckList(Page<ProlongApply> page,int shopId,String fromdate,String todate,String state,int id)
	{
		return prolongApplyDao.getMyCheckList(page,shopId,fromdate,todate,state,id);
	}
	public Page<ProlongApply>  getMyAlterList(Page<ProlongApply> page,int userid,String fromdate,String todate,String state,int id)
	{
		return prolongApplyDao.getMyAlterList(page,userid,fromdate,todate,state,id);
	}
	public Page<ProlongApply>  getMyViewList(Page<ProlongApply> page,int userid,String fromdate,String todate,int id)
	{
		return prolongApplyDao.getMyViewList(page,userid,fromdate,todate,id);
	}
	public Page<ProlongApply>  getMyViewListSell(Page<ProlongApply> page,int shopId,String fromdate,String todate,int id)
	{
		return prolongApplyDao.getMyViewListSell(page,shopId,fromdate,todate,id);
	}
	
	public int addAndUpdate(ProlongApply prolongApply,Order order){
		int prolongApplyid=prolongApplyDao.add(prolongApply).getProlongapplyId();//添加延长收货时间申请表
		orderDao.update(order);
		return prolongApplyid;
	}
	
	public void updateAndUpdatePass(ProlongApply prolongApply,Order order){
		prolongApplyDao.update(prolongApply);//更新延长收货时间申请表
		orderDao.update(order);
	}
	
	public void updateAndUpdateNotpass(ProlongApply prolongApply,Order order){
		prolongApplyDao.update(prolongApply);//更新延长收货时间申请表
		orderDao.update(order);
	}
	
	public void updateAndUpdateAlter(ProlongApply prolongApply,Order order){
		prolongApplyDao.update(prolongApply);//更新延长收货时间申请表
		orderDao.update(order);
	}
	
	public void deleteAndUpdate(int id,Order order){
		prolongApplyDao.deleteById(id);
		orderDao.update(order);
	}
	
	@Override
	public Page<ProlongApply> getMyCheckListPhone(PageRequest pageRequest, int shopId,String state) {
		
		return prolongApplyDao.getMyCheckListPhone(pageRequest, shopId, state);
	}
	
	@Override
	public Page<ProlongApply> getMyAlterListPhone(PageRequest pageRequest,
			int id, String state) {
		return prolongApplyDao.getMyAlterListPhone(pageRequest, id, state);
	}
	@Override
	public Page<ProlongApply> getMyViewListPhone(PageRequest pageRequest,
			int id) {
		return prolongApplyDao.getMyViewListPhone(pageRequest, id);
	}
	
	
}
