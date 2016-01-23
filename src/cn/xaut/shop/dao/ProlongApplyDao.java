package cn.xaut.shop.dao;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.common.paging.domain.PageRequest;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.ProlongApply;

public interface ProlongApplyDao extends CrudRepository<ProlongApply,Integer> {	
	public List<ProlongApply>  getMyCheckList(int userid,String fromdate,String todate,String state);
	public List<ProlongApply>  getMyAlterList(int userid,String fromdate,String todate,String state);
	public List<ProlongApply>  getMyViewList(int userid,String fromdate,String todate);	
	public List<ProlongApply>  getMyViewListSell(int shopId,String fromdate,String todate);
	
	public Page<ProlongApply>  getMyCheckList(Page<ProlongApply> page,int shopId,String fromdate,String todate,String state,int id);	
	public Page<ProlongApply>  getMyAlterList(Page<ProlongApply> page,int userid,String fromdate,String todate,String state,int id);
	public Page<ProlongApply>  getMyViewList(Page<ProlongApply> page,int userid,String fromdate,String todate,int id);
	public Page<ProlongApply>  getMyViewListSell(Page<ProlongApply> page,int shopId,String fromdate,String todate,int id);
	/**
	 * 卖家审核延长收货时间时，审核查询方法
	 * @param pageRequest
	 * @param userid
	 * @param state
	 * @return
	 */
	public Page<ProlongApply> getMyCheckListPhone(PageRequest pageRequest,int shopId,String state);
	
	/**
	 * 买家修改延长收货时间时，修改查询方法
	 * @param pageRequest
	 * @param shopid
	 * @param state
	 * @return
	 */
	public Page<ProlongApply> getMyAlterListPhone(PageRequest pageRequest,int id,String state);
	
	/**
	 * 查看延长收货时间时，查看查询方法
	 * @param pageRequest
	 * @param shopid
	 * @return
	 */
	public Page<ProlongApply> getMyViewListPhone(PageRequest pageRequest,int id);
}
