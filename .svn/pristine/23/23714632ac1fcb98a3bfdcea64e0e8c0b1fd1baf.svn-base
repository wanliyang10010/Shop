package cn.xaut.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.UserDao;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.service.PageService;

@Service
@Transactional
public class PageServiceImpl extends BaseServiceRImpl<UserInfo, Integer> implements PageService {

	private UserDao userDao = null;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public Page<UserInfo> searchUser(Page<UserInfo> page) {
		return userDao.searchUser(page);
	}

	@Override
	public UserInfo findUserById(Integer id) {
		return userDao.findUserById(id);
	}

	@Override
	public UserInfo findUserByLoginName(String loginName) {
		return userDao.findUserByLoginName(loginName);
	}
}
