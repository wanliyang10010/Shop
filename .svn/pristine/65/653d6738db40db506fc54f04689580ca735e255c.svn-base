package cn.xaut.common.security.service;

import java.util.List;

import cn.xaut.common.security.domain.PageSec;
import cn.xaut.shop.pojo.Authority;
import cn.xaut.shop.pojo.Resource;

public interface AuthorityService {

	public boolean addAuthority(Authority authority);

	public List<Authority> getAllAuthorities();

	public List<Resource> getResourceByAuthorityName(String authorityName);

	/*
	 * ����authority��resource��ӳ���ϵ��һ��authorityId��List��resourceIds
	 */
	public void updateAuthorityWithResources(Integer authorityId,
			List<Integer> resourceIds);

	/*
	 * ���authorityId����ȡ��authority��ӵ�е�������Դ
	 */
	public List<Resource> getResourcesByAuthorityId(Integer authorityId);

	List<String> getAllAuthorityName();

	List<String> getResourceStringsByAuthorityName(String authorityName);

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param authorityName
	 *            Ȩ�����
	 * @param currentPage
	 *            ��ǰ�ڼ�ҳ
	 * @param pageSize
	 *            ÿҳ��С
	 * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
	 */
	public PageSec<Authority> queryAuthorityByAuthorityNameForPage(
			String authorityName, int pageSize, int currentPage);

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param description
	 *            Ȩ������
	 * @param currentPage
	 *            ��ǰ�ڼ�ҳ
	 * @param pageSize
	 *            ÿҳ��С
	 * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
	 */
	public PageSec<Authority> queryAuthorityByDescriptionForPage(
			String description, int pageSize, int currentPage);

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param currentPage
	 *            ��ǰ�ڼ�ҳ
	 * @param pageSize
	 *            ÿҳ��С
	 * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
	 */
	public PageSec<Authority> queryAllAuthorityForPage(int pageSize,
			int currentPage);

	/*
	 * ɾ��authority��ɾ��authority��role�Ĺ�����ϵ��ɾ��authority��resource�Ĺ�����ϵ
	 */
	public void deleteAuthorityAnd_Role_ResourceById(Integer authorityId);

	/* ���authorityId���authority */
	public Authority getAuthorityById(Integer id);

	/* ����authority */
	public void updateAuthority(Authority authority);

	/* ���authorityName��ȡauthority */
	public Authority getAuthorityByAuthorityName(String authorityName);

}
