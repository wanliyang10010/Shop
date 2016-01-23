package cn.xaut.shop.dao;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.DeliverAddr;
import cn.xaut.shop.pojo.UserInfo;


public interface DeliverAddrDao extends CrudRepository<DeliverAddr, Integer>{
	
	/**
	 * 分页取回用户收货地址
	 * @param page
	 * @param user
	 * @return
	 */
	Page<DeliverAddr> getDeliverAddrPage(Page<DeliverAddr> page, UserInfo user);

	/**
	 * 列表取回用户收货s地址
	 * @param user
	 * @return
	 */
	List<DeliverAddr> getDeliverAddrList(UserInfo user);
	
	/**
	 * 更新默认收货地址
	 * @param newDefault
	 * @param old
	 */
	void changeDefaultAddr(DeliverAddr newDefault);
	
	
	/**
	 * 查询用户已有收获地址的数量
	 * @param user
	 * @return
	 */
	int getUserDeliverCounts(UserInfo user);
	
	/**
	 * 保存收货地址
	 * @param addr
	 */
	void saveDeliverAddr(DeliverAddr addr);
	
	/**
	 * 更新收货地址，可能引起m默认地址变化
	 * @param addr
	 */
	void updateDeliverAddr(DeliverAddr addr);
	
	/**
	 * 获取用户top5收货地址 
	 * @param user
	 * @return
	 */
	List<DeliverAddr> getTop5List(UserInfo user);

	boolean isExisted(DeliverAddr addr);
}
