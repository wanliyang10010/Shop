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

import cn.xaut.common.security.dao.ResourceDao;
import cn.xaut.common.security.domain.PageSec;
import cn.xaut.shop.pojo.Authority;
import cn.xaut.shop.pojo.Resource;


@Repository("resourceDao")
public class ResourceDaoImpl implements ResourceDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	//��ȡ�͵�ǰ�̰߳󶨵�Session
	private Session getSession(){
		return sessionFactory.getCurrentSession();
		//return sessionFactory.openSession();
	}
	
	@Override
	public boolean addResource(Resource resource) {
		Integer id = (Integer) getSession().save(resource);
		if(id < 0){
			return false;
		}
		return true;
	}

	@Override
	public Resource findResourceById(Integer id) {
		String hql = "SELECT DISTINCT resource FROM Resource resource WHERE resource.id = ? order by  resource.resourceName desc";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, id);
		Resource resource = (Resource) query.uniqueResult();
		return resource;
	}

	@Override
	public void deleteResourceById(Integer id) {
		/*String hql = "DELETE resource RROM Resource resource WHERE resource.id =?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, id);
		Integer result = query.executeUpdate();
		if(result <= 0){
			return false;
		}
		return true;*/
		Resource resource = (Resource)getSession().get(Resource.class, id);
		//�����Authority��˵��Resource�Ǳ��ط�
		Set<Authority> authorities = resource.getAuthorities();
		Iterator<Authority> iter = authorities.iterator();
		while(iter.hasNext()){
			Authority authority = iter.next();
			authority.getResources().remove(resource);
		}
		//����ϵ�󣬾Ϳ���ɾ����
		getSession().delete(resource);
	}

	@Override
	public List<Authority> findAuthoritiesById(Integer id) {
		String hql = "SELECT DISTINCT resource FROM Resource resource,Authority authority WHERE resource.id=? and resource in elements(authority.resources) order by  resource.resourceName desc";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, id);
		Resource resource = (Resource) query.uniqueResult();
		Set<Authority> setAuthorities = resource.getAuthorities();
		List<Authority> listAuthorities = new ArrayList<Authority>();
		listAuthorities.addAll(setAuthorities);
		return listAuthorities;
	}

	@Override
	public List<Resource> findAllResource() {
		String hql = "SELECT DISTINCT resource FROM Resource resource order by  resource.resourceName desc";
		Query query = getSession().createQuery(hql);
		List<Resource> resources = (List<Resource>)query.list();
		return resources;
	}

	@Override
	public void updateResource(Resource resource) {
		getSession().update(resource);
		
	}

	@Override
	public List<Resource> queryForPage(String hql, int offset, int length) {
		Query query = getSession().createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(length);
		List<Resource> resources = query.list();
		return resources;
	}

	@Override
	public int getAllRowCount(String hql) {
		Query query = getSession().createQuery(hql);
		List<Resource> resources = query.list();
		return resources.size();
	}

	@Override
	public Resource findResourceByResourceName(String resourceName) {
		String hql = "SELECT DISTINCT resource FROM Resource resource WHERE resource.resourceName = :resourceName order by  resource.resourceName desc";
		Query query = getSession().createQuery(hql);
		query.setString("resourceName", resourceName);
		Resource resource = (Resource) query.uniqueResult();
		return resource;
	}

	@Override
	public PageSec<Resource> findResourceByResourceNameForPage(
			String resourceName, int pageSize, int currentPage) {
		String hql = "SELECT DISTINCT resource FROM Resource resource where resource.resourceName like '%" + resourceName + "%' order by  resource.resourceName desc";
		int allRow = getAllRowCount(hql);//�ܼ�¼��
		int totalPage = PageSec.countTotalPage(pageSize, allRow);//��ҳ��
		int offset = PageSec.countOffset(pageSize, currentPage);//��ǰҳ��ʼ��¼
		int length = pageSize;//ÿҳ��¼��
		int currentPage1 = PageSec.countCurrentPage(currentPage);
		List<Resource> resources = queryForPage(hql, offset, length);//"һҳ"�ļ�¼
		//�ѷ�ҳ��Ϣ���浽Page��Bean��
		PageSec<Resource> page = new PageSec<Resource>();
		page.setAllRow(allRow);
		page.setCurrentPage(currentPage1);
		page.setPageSize(pageSize);
		page.setTotalPage(totalPage);
		page.setList(resources);
		page.init();
		return page;	
	}

	@Override
	public PageSec<Resource> findResourceByResourceStringForPage(
			String resourceString, int pageSize, int currentPage) {
		String hql = "SELECT DISTINCT resource FROM Resource resource where resource.resourceString like '%" + resourceString + "%' order by  resource.resourceName desc";
		int allRow = getAllRowCount(hql);//�ܼ�¼��
		int totalPage = PageSec.countTotalPage(pageSize, allRow);//��ҳ��
		
		if(currentPage > totalPage){
			currentPage = totalPage;
		}
		
		int offset = PageSec.countOffset(pageSize, currentPage);//��ǰҳ��ʼ��¼
		int length = pageSize;//ÿҳ��¼��
		int currentPage1 = PageSec.countCurrentPage(currentPage);
		List<Resource> resources = queryForPage(hql, offset, length);//"һҳ"�ļ�¼
		//�ѷ�ҳ��Ϣ���浽Page��Bean��
		PageSec<Resource> page = new PageSec<Resource>();
		page.setAllRow(allRow);
		page.setCurrentPage(currentPage1);
		page.setPageSize(pageSize);
		page.setTotalPage(totalPage);
		page.setList(resources);
		page.init();
		return page;
	}

	@Override
	public PageSec<Resource> findResourceByDescriptionForPage(String description,
			int pageSize, int currentPage) {
		String hql = "SELECT DISTINCT resource FROM Resource resource where resource.description like '%" + description + "%' order by  resource.resourceName desc";
		int allRow = getAllRowCount(hql);//�ܼ�¼��
		int totalPage = PageSec.countTotalPage(pageSize, allRow);//��ҳ��
		
		if(currentPage > totalPage){
			currentPage = totalPage;
		}
		
		int offset = PageSec.countOffset(pageSize, currentPage);//��ǰҳ��ʼ��¼
		int length = pageSize;//ÿҳ��¼��
		int currentPage1 = PageSec.countCurrentPage(currentPage);
		List<Resource> resources = queryForPage(hql, offset, length);//"һҳ"�ļ�¼
		//�ѷ�ҳ��Ϣ���浽Page��Bean��
		PageSec<Resource> page = new PageSec<Resource>();
		page.setAllRow(allRow);
		page.setCurrentPage(currentPage1);
		page.setPageSize(pageSize);
		page.setTotalPage(totalPage);
		page.setList(resources);
		page.init();
		return page;
	}

	@Override
	public PageSec<Resource> findAllResourceForPage(int pageSize, int currentPage) {
		String hql = "SELECT DISTINCT resource FROM Resource resource order by  resource.resourceName desc";
		int allRow = getAllRowCount(hql);//�ܼ�¼��
		int totalPage = PageSec.countTotalPage(pageSize, allRow);//��ҳ��
		
		if(currentPage > totalPage){
			currentPage = totalPage;
		}
		
		int offset = PageSec.countOffset(pageSize, currentPage);//��ǰҳ��ʼ��¼
		int length = pageSize;//ÿҳ��¼��
		int currentPage1 = PageSec.countCurrentPage(currentPage);
		List<Resource> resources = queryForPage(hql, offset, length);//"һҳ"�ļ�¼
		//�ѷ�ҳ��Ϣ���浽Page��Bean��
		PageSec<Resource> page = new PageSec<Resource>();
		page.setAllRow(allRow);
		page.setCurrentPage(currentPage1);
		page.setPageSize(pageSize);
		page.setTotalPage(totalPage);
		page.setList(resources);
		page.init();
		return page;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
