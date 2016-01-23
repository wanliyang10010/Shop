package cn.xaut.shop.service;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.common.paging.domain.PageRequest;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.ProlongApply;
import cn.xaut.shop.pojo.ReturnGoods;

public interface ReturnGoodsService extends BaseServiceR<ReturnGoods,Integer>{
	public List< ReturnGoods>  getMyCheckList(int shopId,String fromdate,String todate,String state);
	public List< ReturnGoods>  getMyAlterList(int userid,String fromdate,String todate,String state);
	public List< ReturnGoods>  getMyConfirmList(int userid,String fromdate,String todate,String state);
	public List< ReturnGoods>  getMyViewList(int userid,String fromdate,String todate);
	public List< ReturnGoods>  getMyViewListSell(int shopId,String fromdate,String todate);
	
	public Page<ReturnGoods>  getMyCheckList(Page<ReturnGoods> page,int shopId,String fromdate,String todate,String state,int id);
	public Page<ReturnGoods>  getMyAlterList(Page<ReturnGoods> page,int userid,String fromdate,String todate,String state,int id);
	public Page<ReturnGoods>  getMyConfirmList(Page<ReturnGoods> page,int userid,String fromdate,String todate,String state,int id);
	public Page<ReturnGoods>  getMyViewList(Page<ReturnGoods> page,int userid,String fromdate,String todate,int id);
	public Page<ReturnGoods>  getMyViewListSell(Page<ReturnGoods> page,int shopId,String fromdate,String todate,int id);
	public int addAndUpdate(ReturnGoods returnGoods,Order order);
	public void updateAndUpdatePass(ReturnGoods returnGoods,Order order);
	public void updateAndUpdateNotpass(ReturnGoods returnGoods,Order order);
	public void updateAndUpdateAlter(ReturnGoods returnGoods,Order order);
	public void deleteAndUpdate(int id,Order order);
	public void updateAndUpdateTransInfo(ReturnGoods returnGoods,Order order);
	public void updateAndUpdateConfirm(ReturnGoods returnGoods,Order order);
	
	/**
	 * 卖家审核退货申请，审核查询方法
	 * @param pageRequest
	 * @param userid
	 * @param state
	 * @return
	 */
	public Page<ReturnGoods> getMyCheckListPhone(PageRequest pageRequest,int shopId,String state);
	
	/**
	 *  买家修改退货申请，修改查询方法
	 * @param pageRequest
	 * @param shopId
	 * @param state
	 * @return
	 */
	public Page<ReturnGoods> getMyAlterListPhone(PageRequest pageRequest,int id,String state);
	/**
	 *  买家确认退货申请，确认查询方法
	 * @param pageRequest
	 * @param shopId
	 * @param state
	 * @return
	 */
	public Page<ReturnGoods> getMyConfirmListPhone(PageRequest pageRequest,int id,String state);
	
	/**
	 *  查看退货申请，查看查询方法
	 * @param pageRequest
	 * @param shopId
	 * @return
	 */
	public Page<ReturnGoods> getMyViewListPhone(PageRequest pageRequest,int id);
}
