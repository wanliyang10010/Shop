package cn.xaut.shop.dao;


import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.UserInfo;

public interface UserDao extends CrudRepository<UserInfo, Integer> {

	Page<UserInfo> searchUser(Page<UserInfo> page);

	UserInfo findUserById(Integer id);

	UserInfo findUserByLoginName(String loginName);
	
	List<UserInfo> findByUser(String username,String pwd);
	List<UserInfo> conlogin(String username,String pwd);
	
	Page<UserInfo> findByKey(Page<UserInfo> page,String stype, String key);
	
	Page<UserInfo> find(Page<UserInfo> page);

	List<UserInfo> findSuperUser(String username, String password);

	UserInfo findAdminByLoginName(String username);

	Page<UserInfo> findAdmin(Page<UserInfo> page);
	
	Page<UserInfo> findAllAdminUseRole(Page<UserInfo> page);

	Page<UserInfo> findAdminByKey(Page<UserInfo> page, String key);
	
	Page<UserInfo> findAdminByKeyUseRole(Page<UserInfo> page, String key);

	UserInfo findAdminById(Integer id);

	List<UserInfo> findAdminByName(String username, String password);
	
	public cn.xaut.common.security.domain.PageSec<UserInfo> queryUserByAccountForPage(String username,int pageSize,int currentPage);
	
	public cn.xaut.common.security.domain.PageSec<UserInfo> queryAllUserForPage(int pageSize, int currentPage);

	UserInfo findUserByUsername(String username);
}
