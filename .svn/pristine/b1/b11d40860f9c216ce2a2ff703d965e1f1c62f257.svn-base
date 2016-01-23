package cn.xaut.common.security.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.xaut.common.security.dao.AuthorityDao;
import cn.xaut.common.security.domain.PageSec;
import cn.xaut.shop.pojo.Authority;
import cn.xaut.shop.pojo.Resource;
import cn.xaut.shop.pojo.Role;

@Repository("authorityDao")
public class AuthorityDaoImpl implements AuthorityDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	//��ȡ�͵�ǰ�̰߳󶨵�Session
	private Session getSession(){
		return sessionFactory.getCurrentSession();
		//return sessionFactory.openSession();
	}
	
	@Override
	public boolean addAuthority(Authority authority) {
		Integer id = (Integer) getSession().save(authority);
		if(id < 0){
			return false;
		}
		return true;
	}

	@Override
	public Authority findAuthorityById(Integer id) {
		String hql = "SELECT DISTINCT authority FROM Authority authority WHERE authority.id = ?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, id);
		Authority authority = (Authority) query.uniqueResult();
		return authority;
	}

	@Override
	public void deleteAuthorityById(Integer id) {
		/*String hql = "DELETE authority FROM Authority authority WHERE authority.id =?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, id);
		Integer result = query.executeUpdate();
		if(result <= 0){
			return false;
		}
		return true;*/
		Authority authority = (Authority) getSession().get(Authority.class, id);
		//Authority�����Role�����ط��������resourceҲ�����ط�������ɾ��authority,hibernate�Ͱ�������1��ɾ��authority
		//2��ɾ��authority��role�Ĺ�����ϵ��3��ɾ��authority��resource�Ĺ�����ϵ
		getSession().delete(authority);
	}

	@Override
	public List<Role> findRolesById(Integer id) {
		String hql ="SELECT DISTINCT authority FROM Authority authority,Role role WHERE authority.id = ? and authority in elements(role.authorities)";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, id);
		Authority authority = (Authority) query.uniqueResult();
		Set<Role> setRoles = authority.getRoles();
		List<Role> listRoles = new ArrayList<Role>();
		listRoles.addAll(setRoles);
		return listRoles;
	}

	@Override
	public List<Resource> findResourcesById(Integer authorityId) {
		String hql = "SELECT DISTINCT authority FROM Authority authority,Resource resource WHERE authority.id = ? and authority in elements(resource.authorities)";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, authorityId);
		Authority authority = (Authority) query.uniqueResult();
		Set<Resource> setResources = new HashSet<Resource>();
		List<Resource> listResources = null;
		try {
			/*Hibernate.initialize();*/
			
			listResources = new ArrayList<Resource>();
			if(authority != null)
			{
				setResources = authority.getResources();
				listResources.addAll(setResources);
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("authority.getResources() ��ָ���쳣��ʱ�����?");
			e.printStackTrace();
		}
		return listResources;
	}


	@Override
	public List<String> findAllAuthorityName() {
		String hql = "SELECT DISTINCT authority FROM Authority authority";
		
		
		Query query = getSession().createQuery(hql);
		List<Authority> authorities = query.list();
		Iterator<Authority> iter = authorities.iterator();
		List<String> authorityNames = new ArrayList<String>();
		while(iter.hasNext()){
			authorityNames.add(iter.next().getAuthorityName());
		}
		System.out.println("authorityNames:"+authorityNames);
		return authorityNames;
	}


	@Override
	public List<String> findResourceStringsByAuthorityName(String authorityName) {
		String hql = "SELECT DISTINCT authority FROM Authority authority WHERE authorityName = :authorityName";
		Query query = getSession().createQuery(hql);
		query.setString("authorityName", authorityName);
		Authority authority = (Authority) query.uniqueResult();
		Set<Resource> resources = authority.getResources();
		List<String> ResourceStrings = new ArrayList<String>();
		Iterator it = resources.iterator();
		while(it.hasNext()){
			ResourceStrings.add(((Resource)(it.next())).getResourceString());
		}
		return ResourceStrings;
	}


	@Override
	public List<Authority> findAllAuthority() {
		String hql = "SELECT DISTINCT authority FROM Authority authority";
		Query query = getSession().createQuery(hql);
		List<Authority> authorities = new ArrayList<Authority>();
		authorities = (List<Authority>)query.list();
		return authorities;
	}


	@Override
	public Authority findAuthorityByAuthorityName(String authorityName) {
		String hql="SELECT authority FROM Authority authority WHERE authority.authorityName =?";
		Query query = getSession().createQuery(hql);
		query.setString(0, authorityName);
		Authority authority = (Authority) query.uniqueResult();
		return authority;
	}


	@Override
	public void updateAuthority(Authority authority) {
		getSession().update(authority);
	}

	@Override
	public List<Authority> queryForPage(String hql, int offset, int length) {
		Query query = getSession().createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(length);
		List<Authority> authorities = query.list();
		return authorities;
	}

	@Override
	public int getAllRowCount(String hql) {
		Query query = getSession().createQuery(hql);
		List<Authority> authorities = query.list();
		return authorities.size();
	}


	@Override
	public PageSec<Authority> findAuthorityByAuthorityNameForPage(
			String authorityName, int pageSize, int currentPage) {
		String hql = "SELECT DISTINCT authority FROM Authority authority where authority.authorityName like '%" + authorityName + "%'";
		int allRow = getAllRowCount(hql);//�ܼ�¼��
		int totalPage = PageSec.countTotalPage(pageSize, allRow);//��ҳ��
		if(currentPage > totalPage){
			currentPage = totalPage;
		}
		int offset = PageSec.countOffset(pageSize, currentPage);//��ǰҳ��ʼ��¼
		int length = pageSize;//ÿҳ��¼��
		int currentPage1 = PageSec.countCurrentPage(currentPage);
		List<Authority> authorities = queryForPage(hql, offset, length);//"һҳ"�ļ�¼
		//�ѷ�ҳ��Ϣ���浽Page��Bean��
		PageSec<Authority> page = new PageSec<Authority>();
		page.setAllRow(allRow);
		page.setCurrentPage(currentPage1);
		page.setPageSize(pageSize);
		page.setTotalPage(totalPage);
		page.setList(authorities);
		page.init();
		return page;
	}


	@Override
	public PageSec<Authority> findAuthorityByDescriptionForPage(
			String description, int pageSize, int currentPage) {
		String hql = "SELECT DISTINCT authority FROM Authority authority where authority.description like '%" + description + "%'";
		int allRow = getAllRowCount(hql);//�ܼ�¼��
		int totalPage = PageSec.countTotalPage(pageSize, allRow);//��ҳ��
		if(currentPage > totalPage){
			currentPage = totalPage;
		}
		int offset = PageSec.countOffset(pageSize, currentPage);//��ǰҳ��ʼ��¼
		int length = pageSize;//ÿҳ��¼��
		int currentPage1 = PageSec.countCurrentPage(currentPage);
		List<Authority> authorities = queryForPage(hql, offset, length);//"һҳ"�ļ�¼
		//�ѷ�ҳ��Ϣ���浽Page��Bean��
		PageSec<Authority> page = new PageSec<Authority>();
		page.setAllRow(allRow);
		page.setCurrentPage(currentPage1);
		page.setPageSize(pageSize);
		page.setTotalPage(totalPage);
		page.setList(authorities);
		page.init();
		return page;
	}


	@Override
	public PageSec<Authority> findAllAuthorityForPage(int pageSize, int currentPage) {
		String hql = "SELECT DISTINCT authority FROM Authority authority";
		int allRow = getAllRowCount(hql);//�ܼ�¼��
		int totalPage = PageSec.countTotalPage(pageSize, allRow);//��ҳ��
		if(currentPage > totalPage){
			currentPage = totalPage;
		}
		int offset = PageSec.countOffset(pageSize, currentPage);//��ǰҳ��ʼ��¼
		int length = pageSize;//ÿҳ��¼��
		int currentPage1 = PageSec.countCurrentPage(currentPage);
		List<Authority> authorities = queryForPage(hql, offset, length);//"һҳ"�ļ�¼
		//�ѷ�ҳ��Ϣ���浽Page��Bean��
		PageSec<Authority> page = new PageSec<Authority>();
		page.setAllRow(allRow);
		page.setCurrentPage(currentPage1);
		page.setPageSize(pageSize);
		page.setTotalPage(totalPage);
		page.setList(authorities);
		page.init();
		return page;
	}
	
}
