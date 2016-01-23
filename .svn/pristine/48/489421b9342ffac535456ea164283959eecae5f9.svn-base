package cn.xaut.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.DeliverAddrDao;
import cn.xaut.shop.exception.MsgException;
import cn.xaut.shop.pojo.DeliverAddr;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.service.DeliverAddrService;

@Service
@Transactional 
public class DeliverAddrServiceImpl implements DeliverAddrService {

	private DeliverAddrDao addrDao = null;
	public void setAddrDao(DeliverAddrDao addrDao) {
		this.addrDao = addrDao;
	}

	@Override
	public void deleteById(Integer id) {
		addrDao.deleteById(id);
	}

	@Override
	public DeliverAddr get(Integer id) {
		return addrDao.findById(id);
	}

	@Override
	public Page<DeliverAddr> getDeliverAddr(Page<DeliverAddr> page,
			UserInfo user) {
		return addrDao.getDeliverAddrPage(page, user);
	}

	@Override
	public void addNewAddr(DeliverAddr addr, UserInfo user) throws MsgException {
		
		addr.setUser(user);// 一定要设置地址的用户
		int count = addrDao.getUserDeliverCounts(user);
		if (count >= 5) {
			throw new MsgException("收货地址不能超过5个");
		} else {
			
			if(addr.getIsdefault() == null || addr.getIsdefault().equalsIgnoreCase("")){
				addr.setIsdefault("0");
			}
			if(addrDao.isExisted(addr)){
				throw new MsgException("该收货地址已存在");
			}else{
				addrDao.saveDeliverAddr(addr);
			}
		}
	}
	@Override
	public void addNewAddrphone(DeliverAddr addr, UserInfo user) throws MsgException {

		addr.setUser(user);// 一定要设置地址的用户
		int count = addrDao.getUserDeliverCounts(user);

		if (count >= 5) {
			throw new MsgException("收货地址不能超过5个");
		} else {
			//String flag = addr.getIsdefault() == null  ?  "0" : "1";
			//addr.setIsdefault(flag);
			// 改变收货地址
			addrDao.saveDeliverAddr(addr);
		}
	}

	@Override
	public void changeDefaultAddr(DeliverAddr addr,UserInfo user) {
		//需要用户信息来进行查询
		addr.setUser(user);
		addrDao.changeDefaultAddr(addr);
	}
	

	@Override
	public void update(DeliverAddr addr, UserInfo user) {
		if(addr.getIsdefault() == null || addr.getIsdefault().equalsIgnoreCase("")){
			addr.setIsdefault("0");
		}
		addr.setUser(user);
		addrDao.updateDeliverAddr(addr);
	}
	@Override
	public void updatephone(DeliverAddr addr, UserInfo user) {
		// TODO Auto-generated method stub
		//addr.setIsdefault(addr.getIsdefault() == null || addr.getIsdefault() == "0"  ? "0" : "1"); 
		addr.setUser(user);
		
		addrDao.updateDeliverAddr(addr);
	}
	
	public List<DeliverAddr> getTop5List(UserInfo user)
	{
		return addrDao.getTop5List(user);
	}

	@Override
	public boolean isExisted(DeliverAddr addr) {
		return addrDao.isExisted(addr);
	}
	
}
