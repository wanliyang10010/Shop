package cn.xaut.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.common.paging.domain.PageRequest;
import cn.xaut.shop.dao.OrderDao;
import cn.xaut.shop.dao.ReturnGoodsDao;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.ReturnGoods;
import cn.xaut.shop.service.OrderService;
import cn.xaut.shop.service.ReturnGoodsService;

@Service
@Transactional
public class ReturnGoodsServiceImpl extends BaseServiceRImpl<ReturnGoods,Integer> implements ReturnGoodsService {

	private ReturnGoodsDao returnGoodsDao = null;
	public void setReturnGoodsDao(ReturnGoodsDao returnGoodsDao) {
		this.returnGoodsDao = returnGoodsDao;
	}
	
	@Autowired
	private OrderDao orderDao = null;
	
	@Autowired
	private OrderService orderService = null;
	
	public List<ReturnGoods> getMyCheckList(int shopId,String fromdate, String todate,
			String state) {
		return returnGoodsDao.getMyCheckList(shopId,fromdate,todate,state);
	}
	public List<ReturnGoods> getMyAlterList(int userid,String fromdate, String todate,
			String state) {
		return returnGoodsDao.getMyAlterList(userid,fromdate,todate,state);
	}
	public List<ReturnGoods> getMyConfirmList(int userid,String fromdate, String todate,
			String state) {
		return returnGoodsDao.getMyConfirmList(userid,fromdate,todate,state);
	}
	public List<ReturnGoods> getMyViewList(int userid,String fromdate, String todate) {
		return returnGoodsDao.getMyViewList(userid,fromdate,todate);
	}
	public List<ReturnGoods> getMyViewListSell(int shopId,String fromdate, String todate) {
		return returnGoodsDao.getMyViewList(shopId,fromdate,todate);
	}
	
	public Page<ReturnGoods>  getMyCheckList(Page<ReturnGoods> page,int shopId,String fromdate,String todate,String state,int id)
	{
		return returnGoodsDao.getMyCheckList(page,shopId,fromdate,todate,state,id);
	}
	public Page<ReturnGoods>  getMyAlterList(Page<ReturnGoods> page,int userid,String fromdate,String todate,String state,int id)
	{
		return returnGoodsDao.getMyAlterList(page,userid,fromdate,todate,state,id);
	}
	public Page<ReturnGoods>  getMyConfirmList(Page<ReturnGoods> page,int userid,String fromdate,String todate,String state,int id)
	{
		return returnGoodsDao.getMyConfirmList(page,userid,fromdate,todate,state,id);
	}
	public Page<ReturnGoods>  getMyViewList(Page<ReturnGoods> page,int userid,String fromdate,String todate,int id)
	{
		return returnGoodsDao.getMyViewList(page,userid,fromdate,todate,id);
	}
	public Page<ReturnGoods>  getMyViewListSell(Page<ReturnGoods> page,int shopId,String fromdate,String todate,int id)
	{
		return returnGoodsDao.getMyViewListSell(page,shopId,fromdate,todate,id);
	}
	
	public int addAndUpdate(ReturnGoods returnGoods,Order order){
		int returnGoodsid=returnGoodsDao.add(returnGoods).getReturngoodsId();
		orderDao.update(order);
		return returnGoodsid;
	}
	
	public void updateAndUpdatePass(ReturnGoods returnGoods,Order order){
		returnGoodsDao.update(returnGoods);
		orderDao.update(order);
	}
	
	public void updateAndUpdateNotpass(ReturnGoods returnGoods,Order order){
		returnGoodsDao.update(returnGoods);
		orderDao.update(order);
	}
	
	public void updateAndUpdateAlter(ReturnGoods returnGoods,Order order){
		returnGoodsDao.update(returnGoods);
		orderDao.update(order);
	}
	
	public void deleteAndUpdate(int id,Order order){
		returnGoodsDao.deleteById(id);
		orderDao.update(order);
	}	
	
	public void updateAndUpdateTransInfo(ReturnGoods returnGoods,Order order){
		returnGoodsDao.update(returnGoods);
		orderDao.update(order);
	}
	
	public void updateAndUpdateConfirm(ReturnGoods returnGoods,Order order){
		returnGoodsDao.update(returnGoods);
		orderService.returnGoods(order);
	}
	
	
	@Override
	public Page<ReturnGoods> getMyCheckListPhone(PageRequest pageRequest,
			int shopId, String state) {
		return returnGoodsDao.getMyCheckListPhone(pageRequest, shopId, state);
	}
	@Override
	public Page<ReturnGoods> getMyAlterListPhone(PageRequest pageRequest,
			int id, String state) {
		
		return returnGoodsDao.getMyAlterListPhone(pageRequest, id, state);
	}
	@Override
	public Page<ReturnGoods> getMyConfirmListPhone(PageRequest pageRequest,
			int id, String state) {
		
		return returnGoodsDao.getMyConfirmListPhone(pageRequest, id, state);
	}
	@Override
	public Page<ReturnGoods> getMyViewListPhone(PageRequest pageRequest, int id) {
		
		return returnGoodsDao.getMyViewListPhone(pageRequest, id);
	}
}
