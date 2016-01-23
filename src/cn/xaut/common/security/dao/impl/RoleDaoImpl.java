package cn.xaut.common.security.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.xaut.common.security.dao.RoleDao;
import cn.xaut.common.security.domain.PageSec;
import cn.xaut.shop.pojo.Authority;
import cn.xaut.shop.pojo.Role;
import cn.xaut.shop.pojo.UserInfo;

@Repository(value="roleDao")
public class RoleDaoImpl implements RoleDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//��ȡ�͵�ǰ�̰߳󶨵�Session
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public boolean addRole(Role role) {
		Integer id = (Integer) getSession().save(role);
		if(id < 0){
			return false;
		}
		return true;
	}
	
	@Override
	public Role findRoleById(Integer id) {
		String hql ="SELECT role FROM Role role WHERE role.id=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, id);
		Role role = (Role) query.uniqueResult();
		return role;
	}

	@Override
	public void deleteRoleById(Integer id) {
		/*String hql = "DELETE role FORM Role role.id = ?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, id);
		Integer result = query.executeUpdate();
		if(result <=0){
			return false;
		}
		return true;*/
		Role role= (Role) getSession().get(Role.class,id);
		//���authority��˵role�Ǳ��ط������Ƴ�authorities
		Set<Authority> authorities = role.getAuthorities();
		Iterator<Authority> iter =  authorities.iterator();
		while(iter.hasNext()){
			Authority authorityItem = iter.next();
			authorityItem.getRoles().remove(role);
		}
		
		//���user��˵��role�����ط�
		//���ڿ���ɾ����,����role,��user�Ĺ�ϵӳ��,��authority��ϵӳ��
		getSession().delete(role);
		
	}

	

	@Override
	public List<UserInfo> findUsersById(Integer id) {
		String hql="SELECT DISTINCT role FROM Role role,UserInfo user WHERE role.id=? and role in elements(user.roles) ";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, id);
		Role role = (Role) query.uniqueResult();
		Set<UserInfo> setUsers = role.getUsers();
		List<UserInfo> listUser = new ArrayList<UserInfo>();
		listUser.addAll(setUsers);
		return listUser;
	}

	@Override
	public List<Authority> findAuthoritiesById(Integer id) {
		String hql = "SELECT DISTINCT role FROM Role role,Authority authority WHERE role.id = ? and role in elements(authority.roles)";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, id);
		Role role = (Role) query.uniqueResult();
		List<Authority> listAuthorities = null;
		try {
			
			listAuthorities = new ArrayList<Authority>();
			if(role != null)
			{
				Set<Authority> setAuthorities = role.getAuthorities();
				listAuthorities.addAll(setAuthorities);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("role.getAuthorities() ��ָ���쳣��ʱ�����?");
			e.printStackTrace();
		}
		return listAuthorities;
	}

	@Override
	public List<Role> findAllRoles() {
		String hql = "SELECT DISTINCT role FROM Role role";
		Query query = getSession().createQuery(hql);
		List<Role> roles = query.list();
		return roles;
	}

	@Override
	public void updateRole(Role role) {
		getSession().update(role);
	}

	@Override
	public List<Role> queryForPage(String hql, int offset, int length) {
		Query query = getSession().createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(length);
		List<Role> roles = query.list();
		return roles;
	}

	@Override
	public int getAllRowCount(String hql) {
		Query query = getSession().createQuery(hql);
		List<Role> roles = query.list();
		return roles.size();
	}

	@Override
	public Role findRoleByRoleName(String roleName) {
		String hql = "SELECT DISTINCT role FROM Role role WHERE role.roleName = :roleName";
		Query query = getSession().createQuery(hql);
		query.setString("roleName", roleName);
		Role role = (Role) query.uniqueResult();
		return role;
	}

	@Override
	public PageSec<Role> findRoleByRoleNameForPage(String roleName, int pageSize,
			int currentPage) {
		String hql = "SELECT DISTINCT role FROM Role role where role.roleName like '%" + roleName + "%'";
		int allRow = getAllRowCount(hql);//�ܼ�¼��
		int totalPage = PageSec.countTotalPage(pageSize, allRow);//��ҳ��
		if(currentPage > totalPage){
			currentPage = totalPage;
		}
		int offset = PageSec.countOffset(pageSize, currentPage);//��ǰҳ��ʼ��¼
		int length = pageSize;//ÿҳ��¼��
		int currentPage1 = PageSec.countCurrentPage(currentPage);
		List<Role> roles = queryForPage(hql, offset, length);//"һҳ"�ļ�¼
		//�ѷ�ҳ��Ϣ���浽Page��Bean��
		PageSec<Role> page = new PageSec<Role>();
		page.setAllRow(allRow);
		page.setCurrentPage(currentPage1);
		page.setPageSize(pageSize);
		page.setTotalPage(totalPage);
		page.setList(roles);
		page.init();
		return page;
	}

	@Override
	public PageSec<Role> findRoleByDescriptionForPage(String description,
			int pageSize, int currentPage) {
		String hql = "SELECT DISTINCT role FROM Role role where role.description like '%" + description + "%'";
		int allRow = getAllRowCount(hql);//�ܼ�¼��
		int totalPage = PageSec.countTotalPage(pageSize, allRow);//��ҳ��
		if(currentPage > totalPage){
			currentPage = totalPage;
		}
		int offset = PageSec.countOffset(pageSize, currentPage);//��ǰҳ��ʼ��¼
		int length = pageSize;//ÿҳ��¼��
		int currentPage1 = PageSec.countCurrentPage(currentPage);
		List<Role> roles = queryForPage(hql, offset, length);//"һҳ"�ļ�¼
		//�ѷ�ҳ��Ϣ���浽Page��Bean��
		PageSec<Role> page = new PageSec<Role>();
		page.setAllRow(allRow);
		page.setCurrentPage(currentPage1);
		page.setPageSize(pageSize);
		page.setTotalPage(totalPage);
		page.setList(roles);
		page.init();
		return page;
	}

	@Override
	public PageSec<Role> findAllRoleForPage(int pageSize, int currentPage) {
		String hql = "SELECT DISTINCT role FROM Role role";
		int allRow = getAllRowCount(hql);//�ܼ�¼��
		int totalPage = PageSec.countTotalPage(pageSize, allRow);//��ҳ��
		if(currentPage > totalPage){
			currentPage = totalPage;
		}
		int offset = PageSec.countOffset(pageSize, currentPage);//��ǰҳ��ʼ��¼
		int length = pageSize;//ÿҳ��¼��
		int currentPage1 = PageSec.countCurrentPage(currentPage);
		List<Role> roles = queryForPage(hql, offset, length);//"һҳ"�ļ�¼
		//�ѷ�ҳ��Ϣ���浽Page��Bean��
		PageSec<Role> page = new PageSec<Role>();
		page.setAllRow(allRow);
		page.setCurrentPage(currentPage1);
		page.setPageSize(pageSize);
		page.setTotalPage(totalPage);
		page.setList(roles);
		page.init();
		return page;
	}
	
	
	
	
	
	
	

	

	
	
	
	
	
	
	

}
