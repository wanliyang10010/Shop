package cn.xaut.shop.service;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.common.security.service.RoleService;
import cn.xaut.common.security.service.UserSecurityService;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.pojo.UserPoint;


public interface UserInfoService extends BaseServiceR<UserInfo, Integer> {

	public UserInfo getCheck(String username);

	public UserInfo login(String username, String pwd);

	public Page<UserInfo> getList(Page<UserInfo> page, String stype, String key);
	
	public Page<UserInfo> getListUser(Page<UserInfo> page, String stype, String key);

	public Page<UserInfo> queryAll(Page<UserInfo> page);
	
	public Page<UserInfo> queryAllUser(Page<UserInfo> page);

	public UserInfo loginBack(String username, String password);

	public UserInfo getCheckAdmin(String username);

	public Page<UserInfo> queryAllAdmin(Page<UserInfo> page);

	public Page<UserInfo> getListAdmin(Page<UserInfo> page, String key);
	
	public Page<UserInfo> getListAdminUserRole(Page<UserInfo> page, String key);

	public UserInfo getAdmin(Integer integer);

	public UserInfo loginAdmin(String username, String password);
	public UserInfo conlogin(String username, String password);
	
	/**
	 * 根据用户得到密码 - 为权限验证使用
	 * @param username
	 * @return
	 */
	public String getPasswordByUsername(String username);
	
	/**
	 * 按用户名查询Page<UserInfo>.这里的Page是Hxx的权限中的Page
	 * @param username
	 * @return
	 */
	public cn.xaut.common.security.domain.PageSec<UserInfo> queryUserByAccountForPage(String username,int pageSize,int currentPage);
	
	public cn.xaut.common.security.domain.PageSec<UserInfo> queryAllUserForPage(int pageSize, int currentPage);
	
	public UserInfo getUser(String username);
	
	public UserInfo getUserInfoByUserInfoId(Integer userInfoId);
	
	public Page<UserInfo> queryAllAdminUseRole(Page<UserInfo> page);

	public UserInfo saveRegedit(UserInfo model, RoleService roleService,
			UserSecurityService userSecurityService,
			UserPointService userPointService, UserPoint points);
	
	
	
	
}
