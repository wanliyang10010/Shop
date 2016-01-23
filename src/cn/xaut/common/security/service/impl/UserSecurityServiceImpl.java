package cn.xaut.common.security.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xaut.common.security.dao.RoleDao;
import cn.xaut.common.security.dao.UserSecurityDao;
import cn.xaut.common.security.domain.PageSec;
import cn.xaut.common.security.service.UserSecurityService;
import cn.xaut.shop.pojo.CasUser;
import cn.xaut.shop.pojo.Role;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.util.CasUserUtil;

@Service("userSecurityService")
public class UserSecurityServiceImpl implements UserSecurityService {

	@Autowired
	private UserSecurityDao userSecurityDao;
	@Autowired
	private RoleDao roleDao;

	// @Autowired
	// private RoleService roleService = null;

	@Override
	@Transactional
	public boolean addUser(UserInfo user) {
		return userSecurityDao.addUser(user);
	}

	@Override
	@Transactional
	public List<UserInfo> getAllUsers() {
		List<UserInfo> users = userSecurityDao.findAllUsers();
		return users;
	}

	@Override
	@Transactional
	public void updateUserWithRoles(Integer userId, List<Integer> rolesId) {
		// ȡUser
		UserInfo user = userSecurityDao.getUserById(userId);
		// ȡRoles
		List<Role> roles = new ArrayList<Role>();
		Iterator<Integer> iter = rolesId.iterator();
		while (iter.hasNext()) {
			Role roleItem = new Role();
			roleItem = roleDao.findRoleById(iter.next());
			roles.add(roleItem);
		}
		// ��list���set
		Set<Role> rolesSet = new HashSet<Role>();
		rolesSet.addAll(roles);
		Set<Role> roleRemoves = user.getRoles();
		Iterator<Role> iterRemove = roleRemoves.iterator();
		while (iterRemove.hasNext()) {
			Role roleRemove = iterRemove.next();
			roleRemove.getUsers().remove(user);
		}
		/*
		 * //1.2���Ƴ�user��role������ while(iterRemove.hasNext()){
		 * user.getRoles().remove(iterRemove.next()); }
		 */
		// 2�����½�����ϵ
		user.getRoles().addAll(rolesSet);
		userSecurityDao.updateUser(user);
		// ����role
		Iterator<Role> iters = rolesSet.iterator();
		while (iters.hasNext()) {
			Role roleItem = iters.next();
			roleItem.getUsers().add(user);
			roleDao.updateRole(roleItem);
		}

	}

	@Override
	@Transactional
	public String getPasswordByAccount(String account) {
		String password = userSecurityDao.findPasswordByAccount(account);
		return password;
	}

	@Override
	@Transactional
	public UserInfo getUserByAccount(String account) {
		UserInfo user = userSecurityDao.getUserByAccount(account);
		return user;
	}

	@Override
	@Transactional
	public PageSec<UserInfo> queryUserByAccountForPage(String account,
			int pageSize, int currentPage) {

		PageSec<UserInfo> page = new PageSec<UserInfo>();
		page = userSecurityDao.findUserByAccountForPage(account, pageSize,
				currentPage);
		return page;
	}

	@Override
	@Transactional
	public PageSec<UserInfo> queryUserByDescriptionForPage(String description,
			int pageSize, int currentPage) {

		PageSec<UserInfo> page = new PageSec<UserInfo>();
		page = userSecurityDao.findUserByDescriptionForPage(description,
				pageSize, currentPage);
		return page;

	}

	@Override
	@Transactional
	public PageSec<UserInfo> queryAllUserForPage(int pageSize, int currentPage) {

		PageSec<UserInfo> page = new PageSec<UserInfo>();
		page = userSecurityDao.findAllUserForPage(pageSize, currentPage);
		return page;
	}

	@Override
	@Transactional
	public void deleteUserAnd_RoleById(Integer userId) {
		userSecurityDao.deleteUserById(userId);
	}

	@Override
	@Transactional
	public UserInfo getUserById(Integer userId) {
		UserInfo user = userSecurityDao.getUserById(userId);
		return user;
	}

	@Override
	@Transactional
	public List<Role> getRolesByUserId(Integer userId) {
		List<Role> listRoles = new ArrayList<Role>();
		listRoles = userSecurityDao.getRolesById(userId);
		return listRoles;
	}

	@Transactional
	public void upload(File upload, File dstFile) {
		userSecurityDao.upload(upload, dstFile);
	}

	@Override
	@Transactional
	public void updateUser(UserInfo user) {
		userSecurityDao.updateUser(user);
	}

	@Override
	@Transactional
	public boolean addUserwithRole(UserInfo user) {
		userSecurityDao.addUser(user);
		Role role = new Role();
		role = roleDao.findRoleByRoleName("ROLE_User");
		List<Integer> roleIdList = new ArrayList<Integer>();
		roleIdList.add(role.getId());
		this.updateUserWithRoles(user.getUserinfoId(), roleIdList);
		return true;
	}

	@Override
	@Transactional
	public CasUser getCasUser(String userId){
		String json = "";
		CasUser casUser = null; 
		try {
			json = CasUserUtil.getCasUserJsonString(userId, "1");
			JSONObject jsonObject = JSONObject.fromObject(json);
			JSONObject userjsonObject = jsonObject.getJSONObject("user");
			casUser = (CasUser) JSONObject.toBean(userjsonObject,CasUser.class);
		} catch (Exception e) {
			
		}
		return casUser;
	}
}
