package cn.xaut.common.security.dao;

import java.util.List;

import cn.xaut.common.security.domain.PageSec;
import cn.xaut.shop.pojo.Authority;
import cn.xaut.shop.pojo.Resource;
import cn.xaut.shop.pojo.Role;

public interface AuthorityDao {

	/*
	 * ���authorityʵ�壬��Ӹ�ʵ��
	 */
	public boolean addAuthority(Authority authority);

	/*
	 * ���Id��ö�Ӧ��Authorityʵ��
	 */
	public Authority findAuthorityById(Integer id);

	/*
	 * ���authorityName��ö�Ӧ��Authorityʵ��
	 */
	public Authority findAuthorityByAuthorityName(String authorityName);

	/*
	 * ���Idɾ���Ӧ��Authorityʵ��
	 */
	public void deleteAuthorityById(Integer id);

	/*
	 * ���id��ȡӵ�и�Ȩ�޵�����role����������Щrole��ɵ�List
	 */
	public List<Role> findRolesById(Integer id);

	/*
	 * ���id��ȡ��Ȩ����ӵ�е�����resource����������Щresource��ɵ�List
	 */
	public List<Resource> findResourcesById(Integer authorityId);

	/*
	 * ��ѯ����authority��Ȩ�ޣ��������֣�����authorityName��ɵ�List
	 */
	public List<String> findAllAuthorityName();

	/*
	 * ���Ȩ��authorityName������,�鴦��Ȩ�޶�Ӧ����Դ��resourceString��url��,
	 * ����resourceString��ɵ�List
	 */
	public List<String> findResourceStringsByAuthorityName(String authorityName);

	/*
	 * ��ѯ����authority,����authority��ɵ�List
	 */
	public List<Authority> findAllAuthority();

	/*
	 * �ı�authority��ݺ���Ҫ����authority�����
	 */
	public void updateAuthority(Authority authority);

	/* ��ҳ��ѯAuthority */
	/**
	 * ��ҳ��ѯ
	 * 
	 * @param hql
	 *            ��ѯ������
	 * @param offset
	 *            ��ʼ��¼
	 * @param length
	 *            һ�β�ѯ������¼
	 * @return
	 */
	public List<Authority> queryForPage(String hql, int offset, int length);

	/**
	 * ��ѯ���м�¼��
	 * 
	 * @param hql
	 *            ��ѯ������
	 * @return �ܼ�¼��
	 */
	public int getAllRowCount(String hql);

	public PageSec<Authority> findAuthorityByAuthorityNameForPage(
			String authorityName, int pageSize, int currentPage);

	public PageSec<Authority> findAuthorityByDescriptionForPage(
			String description, int pageSize, int currentPage);

	public PageSec<Authority> findAllAuthorityForPage(int pageSize, int currentPage);

}
