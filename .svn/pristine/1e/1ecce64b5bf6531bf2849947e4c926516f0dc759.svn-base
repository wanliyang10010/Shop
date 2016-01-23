package cn.xaut.common.security.dao;

import java.util.List;

import cn.xaut.common.security.domain.PageSec;
import cn.xaut.shop.pojo.Authority;
import cn.xaut.shop.pojo.Role;
import cn.xaut.shop.pojo.UserInfo;

public interface RoleDao {

	/*
	 *���Roleʵ��,���һ��Role
	 * */
	public boolean addRole(Role role); 
	
	/*
	 * ���id��ȡRoleʵ��
	 * */
	public Role findRoleById(Integer id);
	
	/*
	 * ���idɾ��Roleʵ��
	 * */
	public void deleteRoleById(Integer id);
	
	/*
	 * ���id��ȡӵ�иý�ɫ������user,��������Щuser��ɵ�List
	 * */
	public List<UserInfo> findUsersById(Integer id);
	
	/*
	 * ���id��ȡ�ý�ɫ��ӵ�е�authority,��������Щauthority��ɵ�List
	 * */
	public List<Authority> findAuthoritiesById(Integer id);
	
	
	/*
	 * �������Role,����Role��ɵ�List
	 * */
	public List<Role> findAllRoles();
	
	/*
	 * ����Role
	 * */
	public void updateRole(Role role);
	
	
	
	/* ��ҳ��ѯRole */
	/**
     * ��ҳ��ѯ
     * @param hql ��ѯ������
     * @param offset ��ʼ��¼
     * @param length һ�β�ѯ������¼
     * @return
     */
    public List<Role> queryForPage(String hql,int offset,int length);
    
    /**
     * ��ѯ���м�¼��
     * @param hql ��ѯ������
     * @return �ܼ�¼��
     */
    public int getAllRowCount(String hql);
    
    /*  ���roleName���role */
    public Role findRoleByRoleName(String roleName);
    
    public PageSec<Role> findRoleByRoleNameForPage(String roleName,int pageSize, int currentPage);
    
    public PageSec<Role> findRoleByDescriptionForPage(String description,int pageSize, int currentPage);
    
    public PageSec<Role> findAllRoleForPage(int pageSize, int currentPage);
	
}
