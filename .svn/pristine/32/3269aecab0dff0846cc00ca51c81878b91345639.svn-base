package cn.xaut.shop.service;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.exception.MsgException;
import cn.xaut.shop.pojo.DeliverAddr;
import cn.xaut.shop.pojo.UserInfo;

public interface DeliverAddrService{
	
	/**
	 * 按Id删除
	 * @param id
	 */
	void deleteById(Integer id);
	
	/**
	 * 按Id获取
	 * @param id
	 */
	DeliverAddr get(Integer id);
	
	/**
	 * 分页获取用户的收货地址
	 * @param page
	 * @param user
	 * @return
	 */
	Page<DeliverAddr> getDeliverAddr(Page<DeliverAddr> page ,UserInfo user);
	
	
	/**
	 * 保存新的收货地址.若设置了设为默认地址，则更新默认地址
	 * @param addr
	 * @param user
	 * @throws MsgException
	 */
	void addNewAddr(DeliverAddr addr,UserInfo user) throws MsgException;
	
	/**
	 * 更换默认收货地址
	 * @param addr
	 */
	void changeDefaultAddr(DeliverAddr addr,UserInfo user);
	
	//void changeDefaultAddr(DeliverAddr addr);
	
	/**
	 * 更新地址
	 * @param addr
	 * @param user
	 */
	void update(DeliverAddr addr,UserInfo user);
	
	/**
	 * 获取用户top5收货地址
	 * @param user
	 * @return
	 */
	List<DeliverAddr> getTop5List(UserInfo user);


	void updatephone(DeliverAddr addr, UserInfo user);

	void addNewAddrphone(DeliverAddr addr, UserInfo user) throws MsgException;

	boolean isExisted(DeliverAddr addr);
	
}
