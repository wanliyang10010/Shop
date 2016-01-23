package cn.xaut.shop.service.impl;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.UserPointDao;
import cn.xaut.shop.pojo.UserPoint;
import cn.xaut.shop.service.UserPointService;

public class UserPointServiceImpl extends BaseServiceRImpl<UserPoint,Integer> implements UserPointService {

	private UserPointDao userPointDao = null;

	public void setUserPointDao(UserPointDao userPointDao) {
		this.userPointDao = userPointDao;
	}
	public List<UserPoint> getListByUserId(int userid) {
		return userPointDao.getListByUserId(userid);
	}
	@Override
	public Page<UserPoint> getListByUserId(Page<UserPoint> page,int userid)
	{
		return userPointDao.getListByUserId(page,userid);
	}
}
