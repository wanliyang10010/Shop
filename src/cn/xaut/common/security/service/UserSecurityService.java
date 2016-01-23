package cn.xaut.common.security.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import cn.xaut.common.security.domain.PageSec;
import cn.xaut.shop.pojo.CasUser;
import cn.xaut.shop.pojo.Role;
import cn.xaut.shop.pojo.UserInfo;

public interface UserSecurityService {

	@Transactional
	public abstract boolean addUser(UserInfo user);

	@Transactional
	public abstract List<UserInfo> getAllUsers();

	@Transactional
	public abstract void updateUserWithRoles(Integer userId,
			List<Integer> rolesId);

	@Transactional
	public abstract String getPasswordByAccount(String account);

	@Transactional
	public abstract UserInfo getUserByAccount(String account);

	@Transactional
	public abstract PageSec<UserInfo> queryUserByAccountForPage(String account,
			int pageSize, int currentPage);

	@Transactional
	public abstract PageSec<UserInfo> queryUserByDescriptionForPage(
			String description, int pageSize, int currentPage);

	@Transactional
	public abstract PageSec<UserInfo> queryAllUserForPage(int pageSize,
			int currentPage);

	@Transactional
	public abstract void deleteUserAnd_RoleById(Integer userId);

	@Transactional
	public abstract UserInfo getUserById(Integer userId);

	@Transactional
	public abstract List<Role> getRolesByUserId(Integer userId);

	@Transactional
	public abstract void updateUser(UserInfo user);
	
	@Transactional
	public abstract boolean addUserwithRole(UserInfo userTemp);

	@Transactional
	public abstract CasUser getCasUser(String userId);

}