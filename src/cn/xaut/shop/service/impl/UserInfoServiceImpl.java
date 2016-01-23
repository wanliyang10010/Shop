package cn.xaut.shop.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.common.security.service.RoleService;
import cn.xaut.common.security.service.UserSecurityService;
import cn.xaut.shop.dao.UserDao;
import cn.xaut.shop.pojo.Role;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.pojo.UserPoint;
import cn.xaut.shop.service.UserInfoService;
import cn.xaut.shop.service.UserPointService;

@Service("userService")
@Transactional
public class UserInfoServiceImpl extends BaseServiceRImpl<UserInfo,Integer> implements UserInfoService{
	
	@Autowired
	private UserDao userDao = null;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public UserInfo getCheck(String username) {
	    return userDao.findUserByLoginName(username);
	}
	
	public UserInfo login(String username,String pwd) {
	  List<UserInfo> accounts = userDao.findByUser(username, pwd);
	   System.out.println(accounts.size());
	   if(accounts != null&&accounts.size()>0)
	   {
		   return accounts.get(0);
	   }
	   else
	   {
		  return  null;
	   }

	}
	public UserInfo conlogin(String username,String pwd) {
		  List<UserInfo> accounts = userDao.conlogin(username, pwd);
		   System.out.println(accounts.size());
		   if(accounts != null&&accounts.size()>0)
		   {
			   return accounts.get(0);
		   }
		   else
		   {
			  return  null;
		   }

		}

	public Page<UserInfo> getList(Page<UserInfo> page,String stype, String key) {
		return userDao.findByKey(page,stype, key);
	}

	

	@Override
	public Page<UserInfo> getListUser(Page<UserInfo> page, String stype,
			String key) {
		Page<UserInfo> newPage = userDao.findByKey(page,stype, key);
		
		return newPage;
	}

	@Override
	public Page<UserInfo> queryAll(Page<UserInfo> page) {
		return userDao.find(page);
	}

	@Override
	public Page<UserInfo> queryAllUser(Page<UserInfo> page) {
		
		Page<UserInfo> newPage = userDao.find(page);
		return newPage;
	}

	@Override
	public UserInfo loginBack(String username, String password) {
		 List<UserInfo> accounts = userDao.findSuperUser(username, password);
		   System.out.println(accounts.size());
		   if(accounts != null&&accounts.size()>0)
		   {
			   return accounts.get(0);
		   }
		   else
		   {
			  return  null;
		   }
	}


	@Override
	public UserInfo getCheckAdmin(String username) {
		return userDao.findAdminByLoginName(username);
	}


	@Override
	public Page<UserInfo> queryAllAdmin(Page<UserInfo> page) {
		return userDao.findAdmin(page);
	}
	
	

	@Override
	public Page<UserInfo> queryAllAdminUseRole(Page<UserInfo> page) {
		Page<UserInfo> newPage = userDao.findAllAdminUseRole(page);
		return newPage;
	}
	

	@Override
	public Page<UserInfo> getListAdmin(Page<UserInfo> page, String key) {
		return userDao.findAdminByKey(page, key);
	}

	

	@Override
	public Page<UserInfo> getListAdminUserRole(Page<UserInfo> page, String key) {
		Page<UserInfo> newPage = userDao.findAdminByKeyUseRole(page, key);
		return newPage;
	}

	@Override
	public UserInfo getAdmin(Integer id) {
		return userDao.findAdminById(id);
	}


	@Override
	public UserInfo loginAdmin(String username, String password) {
		List<UserInfo> accounts = userDao.findAdminByName(username, password);
		   System.out.println(accounts.size());
		   if(accounts != null&&accounts.size()>0)
		   {
			   return accounts.get(0);
		   }
		   else
		   {
			  return  null;
		   }
	}
	
	@Override
	public String getPasswordByUsername(String username) {
		
		UserInfo user =  userDao. findUserByLoginName(username);
		if(user != null){
			return user.getPassword();
		}
		return null;
	}

	@Override
	public cn.xaut.common.security.domain.PageSec<UserInfo> queryUserByAccountForPage(String username,int pageSize,int currentPage) {
		
		
		return null;
	}

	@Override
	public cn.xaut.common.security.domain.PageSec<UserInfo> queryAllUserForPage(int pageSize, int currentPage) {
			
		
		return null;
	}

	@Override
	public UserInfo getUser(String username) {
		// TODO Auto-generated method stub
		return userDao.findUserByUsername(username);
	}

	@Override
	public UserInfo getUserInfoByUserInfoId(Integer userInfoId) {
		// TODO Auto-generated method stub
		return userDao.findUserById(userInfoId);
	}

	@Transactional
	@Override
	public UserInfo saveRegedit(UserInfo model, RoleService roleService,
			UserSecurityService userSecurityService,
			UserPointService userPointService, UserPoint points) {
		// TODO Auto-generated method stub
		UserInfo user=userDao.add(model);
		Role role = roleService.getRoleByRoleName("ROLE_User");
		List<Integer> roleIdList = new ArrayList<Integer>();
		roleIdList.add(role.getId());
		userSecurityService.updateUserWithRoles(user.getUserinfoId(), roleIdList);
		points.setUserinfo(user);
		userPointService.add(points);
		return user;
	}
	
	
}
