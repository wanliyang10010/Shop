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
import cn.xaut.common.security.dao.ResourceDao;
import cn.xaut.common.security.domain.PageSec;
import cn.xaut.common.security.service.AuthorityService;
import cn.xaut.shop.pojo.Authority;
import cn.xaut.shop.pojo.Resource;

@Service("authorityService")
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityDao authorityDao;
	@Autowired
	private ResourceDao resourceDao;
	
	@Override
	public boolean addAuthority(Authority authority) {
		boolean result = authorityDao.addAuthority(authority);
		return result;
	}

	@Override
	public List<Authority> getAllAuthorities() {
		List<Authority> authorities = new ArrayList<Authority>();
		authorities = authorityDao.findAllAuthority();
		return authorities;
	}

	@Override
	public List<Resource> getResourceByAuthorityName(String authorityName) {
		Authority authority = authorityDao.findAuthorityByAuthorityName(authorityName);
		List<Resource> resources = new ArrayList<Resource>();
		
		Set<Resource> setResources = authority.getResources();
		resources.addAll(setResources);
		return resources;
	}

	@Override
	public void updateAuthorityWithResources(Integer authorityId,
			List<Integer> resourceIds) {
		Authority authority = authorityDao.findAuthorityById(authorityId);
		List<Resource> resources = new ArrayList<Resource>();
		Iterator<Integer> iter = resourceIds.iterator();
		while(iter.hasNext()){
			Resource resourceItem = new Resource();
			resourceItem = resourceDao.findResourceById(iter.next());
			resources.add(resourceItem);
		}
		
		//��list���set
		Set<Resource> resourcesSet = new HashSet<Resource>();
		resourcesSet.addAll(resources);
		
		
		//����authority,�޸�authority��resources����
		//1��ɾ��authority��resource�Ĺ�ϵӳ�䣬Authority�����resource��˵�����ط�
		//Hibernate.initialize(authority.getResources());
		/*Set<Resource> resourceRemove = authority.getResources();
		
		Iterator<Resource> iterRomove = resourceRemove.iterator();
		while(iterRomove.hasNext()){
			
			authority.getResources().remove(iterRomove.next());
		}*/
		authority.getResources().clear();
		
		//2�����½�����ϵ
		authority.getResources().addAll(resourcesSet);
		authorityDao.updateAuthority(authority);
		
		Iterator<Resource> iters = resourcesSet.iterator();
		
		while(iters.hasNext()){
			//�޸�resource��authority
			Resource resource = iters.next();
			resource.getAuthorities().add(authority);
			resourceDao.updateResource(resource);
		}
	}

	@Override
	public List<Resource> getResourcesByAuthorityId(Integer authorityId) {
		List<Resource> resources = authorityDao.findResourcesById(authorityId);
		
		return resources;
	}

	@Override
	public List<String> getAllAuthorityName() {
		List<String> authorityNameList = authorityDao.findAllAuthorityName();
		return authorityNameList;
	}

	@Override
	public List<String> getResourceStringsByAuthorityName(String authorityName) {
		List<String> resourceStringsList = authorityDao.findResourceStringsByAuthorityName(authorityName);
		return resourceStringsList;
	}

	@Override
	public PageSec<Authority> queryAuthorityByAuthorityNameForPage(
			String authorityName, int pageSize, int currentPage) {
		
		PageSec<Authority> page = new PageSec<Authority>();
		page = authorityDao.findAuthorityByAuthorityNameForPage(authorityName, pageSize, currentPage);
		return page;
	}

	@Override
	public PageSec<Authority> queryAuthorityByDescriptionForPage(
			String description, int pageSize, int currentPage) {
		
		PageSec<Authority> page = new PageSec<Authority>();
		page = authorityDao.findAuthorityByDescriptionForPage(description, pageSize, currentPage);
		return page;
	}

	@Override
	public PageSec<Authority> queryAllAuthorityForPage(int pageSize,
			int currentPage) {
		
		PageSec<Authority> page = new PageSec<Authority>();
		page = authorityDao.findAllAuthorityForPage(pageSize, currentPage);
		return page;
		
	}

	@Override
	public void deleteAuthorityAnd_Role_ResourceById(Integer authorityId) {
		authorityDao.deleteAuthorityById(authorityId);
	}

	@Override
	public Authority getAuthorityById(Integer id) {
		Authority authority = authorityDao.findAuthorityById(id);
		return authority;
	}

	@Override
	public void updateAuthority(Authority authority) {
		authorityDao.updateAuthority(authority);
	}

	@Override
	public Authority getAuthorityByAuthorityName(String authorityName) {
		Authority authority = authorityDao.findAuthorityByAuthorityName(authorityName);
		return authority;
	}
	
}
