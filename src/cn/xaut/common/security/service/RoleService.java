package cn.xaut.common.security.service;

import java.util.List;

import cn.xaut.common.security.domain.PageSec;
import cn.xaut.shop.pojo.Authority;
import cn.xaut.shop.pojo.Role;


public interface RoleService {
	
	public boolean addRole(Role role);
	
	public List<Role> getAllRoles();
	
	public void updateRoleWithAuthorities(Integer roleId_I,List<Integer> authorityId_L_I);
	
	/**
     * ��ҳ��ѯ
     * @param currentPage ��ǰ�ڼ�ҳ
     * @param pageSize ÿҳ��С
     * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
     */
    public PageSec<Role> queryRoleByRoleNameForPage(String roleName,int pageSize,int currentPage);
	
    /**
     * ��ҳ��ѯ
     * @param currentPage ��ǰ�ڼ�ҳ
     * @param pageSize ÿҳ��С
     * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
     */
    public PageSec<Role> queryRoleByDescriptionForPage(String description,int pageSize,int currentPage);
    
    /**
     * ��ҳ��ѯ
     * @param currentPage ��ǰ�ڼ�ҳ
     * @param pageSize ÿҳ��С
     * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
     */
    public PageSec<Role> queryAllRoleForPage(int pageSize,int currentPage);
    
    /* ���role��Id 1��ɾ��role; 2��role��anthority�Ĺ���;3��ɾ��role��user�Ĺ��� */
    public void deleteRoleAnd_User_AuthorityById(Integer roleid);
    
    /* ���roleId���role���� */
    public Role getRoleById(Integer roleId);
    
    /* ���½�ɫ */
    public void updataRole(Role role);
    
    /* ���roleId��ѯauthority��lis */
    public List<Authority> getAuthoritiesById(Integer authorityId);
    
    /*  ���roleName ���role  */
    public Role getRoleByRoleName(String roleName);


}
