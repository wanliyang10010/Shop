package cn.xaut.common.security.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xaut.common.security.dao.AuthorityDao;
import cn.xaut.common.security.dao.RoleDao;
import cn.xaut.common.security.domain.PageSec;
import cn.xaut.common.security.service.RoleService;
import cn.xaut.shop.pojo.Authority;
import cn.xaut.shop.pojo.Role;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	@Autowired
	private AuthorityDao authorityDao;
	
	@Override
	@Transactional
	public boolean addRole(Role role) {
		boolean result = roleDao.addRole(role);
		return result;
	}
	
	@Override
	@Transactional
	public List<Role> getAllRoles() {
		List<Role> roles = roleDao.findAllRoles();
		return roles;
	}
	
	@Override
	@Transactional
	public void updateRoleWithAuthorities(Integer roleId_I,
			List<Integer> authorityId_L_I) {
		//ȡrole
		Role role = roleDao.findRoleById(roleId_I);
		//ȡAuthorities
		List<Authority> authorities = new ArrayList<Authority>();
		Iterator<Integer> iter = authorityId_L_I.iterator();
		while(iter.hasNext()){
			Authority authorityItem = new Authority();
			authorityItem = authorityDao.findAuthorityById(iter.next());
			authorities.add(authorityItem);
		}
		//��list���set
		Set<Authority> authoritiesSet = new HashSet<Authority>();
		authoritiesSet.addAll(authorities);
		//����role
		//1�����Ƴ�role��authority�Ĺ�����ϵ
		//���authority��˵role�Ǳ��ط������Ƴ�authorities
		Set<Authority> authoritiesRemove = role.getAuthorities();
		Iterator<Authority> iterRemove =  authoritiesRemove.iterator();
		while(iterRemove.hasNext()){
			Authority authorityItemRemove = iterRemove.next();
			authorityItemRemove.getRoles().remove(role);
		}
		
		//2���ؽ���ϵ
		role.getAuthorities().addAll(authoritiesSet);
		roleDao.updateRole(role);
		//����authorities
		Iterator<Authority> iters = authoritiesSet.iterator();
		while(iters.hasNext()){
			Authority authorityItem = iters.next();
			authorityItem.getRoles().add(role);
			authorityDao.updateAuthority(authorityItem);
		}
	}

	/**
     * ��ҳ��ѯ
     * @param currentPage ��ǰ�ڼ�ҳ
     * @param pageSize ÿҳ��С
     * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
     */
	@Override
	@Transactional
	public PageSec<Role> queryRoleByRoleNameForPage(String roleName,int pageSize, int currentPage) {
		
		
		PageSec<Role> page = new PageSec<Role>();
		page = roleDao.findRoleByRoleNameForPage(roleName, pageSize, currentPage);
		return page;
	}

	/**
     * ��ҳ��ѯ
     * @param currentPage ��ǰ�ڼ�ҳ
     * @param pageSize ÿҳ��С
     * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
     */
	@Override
	@Transactional
	public PageSec<Role> queryRoleByDescriptionForPage(String description,int pageSize, int currentPage) {
		
		PageSec<Role> page = new PageSec<Role>();
		page = roleDao.findRoleByDescriptionForPage(description, pageSize, currentPage);
		return page;
	}

	/**
     * ��ҳ��ѯ
     * @param currentPage ��ǰ�ڼ�ҳ
     * @param pageSize ÿҳ��С
     * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
     */
	@Override
	@Transactional
	public PageSec<Role> queryAllRoleForPage(int pageSize, int currentPage) {
		
		PageSec<Role> page = new PageSec<Role>();
		page = roleDao.findAllRoleForPage(pageSize, currentPage);
		return page;
		
	}

	@Override
	@Transactional
	public void deleteRoleAnd_User_AuthorityById(Integer roleid) {
		roleDao.deleteRoleById(roleid);
	}

	@Override
	@Transactional
	public Role getRoleById(Integer roleId) {
		Role role = roleDao.findRoleById(roleId);
		return role;
	}

	@Override
	@Transactional
	public void updataRole(Role role) {
		roleDao.updateRole(role);
	}

	@Override
	@Transactional
	public List<Authority> getAuthoritiesById(Integer authorityId) {
		List<Authority> authorityList = roleDao.findAuthoritiesById(authorityId);
		return authorityList;
	}

	@Override
	@Transactional
	public Role getRoleByRoleName(String roleName) {
		Role role = roleDao.findRoleByRoleName(roleName);
		return role;
	}
	
	
	
	
	
	
	
	
	

}
