package cn.xaut.common.security.dao;

import java.io.File;
import java.util.List;

import cn.xaut.common.security.domain.PageSec;
import cn.xaut.shop.pojo.Role;
import cn.xaut.shop.pojo.UserInfo;

public interface UserSecurityDao {
	//����һ��User
	public boolean addUser(UserInfo user);
	/*
	 * ���idɾ��һ��user
	 * */
	public void deleteUserById(Integer id);
	/*
	 * ���accountɾ��һ��user
	 * */
	public boolean deleteUserByAccount(String account);
	
	/*
	 * ���Id���Userʵ��
	 * */
	public UserInfo getUserById(Integer id);
	/*
	 * ����û������û�ʵ�壨��Ϊע���ʱ�򣬾��ܱ�֤�û����Ψһ�����Ի�õ�ʵ��϶���Ψһ�ģ�
	 * */
	public UserInfo getUserByAccount(String account);
	
	/*
	 * ���Id��ø��û���ӵ�е�role�ļ��ϣ�Ȼ�󷵻�����Щrole��ɵ�List
	 * */
	public List<Role> getRolesById(Integer id);
	
	/*
	 * ���account��ø��û���ӵ�е�role�ļ��ϣ�Ȼ�󷵻�����Щrole��ɵ�List
	 * */
	public List<Role> getRolesByAccount(String account);
	
	/*
	 * ����û���account��,��ȡ�õ�����
	 * */
	public String findPasswordByAccount(String account);
	
	public List<UserInfo> findAllUsers();
	
	public void updateUser(UserInfo user);
	
	/* ��ҳ��ѯUser */
	/**
     * ��ҳ��ѯ
     * @param hql ��ѯ������
     * @param offset ��ʼ��¼
     * @param length һ�β�ѯ������¼
     * @return
     */
    public List<UserInfo> queryForPage(String hql,int offset,int length);
    
    /**
     * ��ѯ���м�¼��
     * @param hql ��ѯ������
     * @return �ܼ�¼��
     */
    public int getAllRowCount(String hql);
    
    /* 合并 上传图片 */
    void upload(File upload, File dstFile);
    
    public PageSec<UserInfo> findUserByAccountForPage(String account, int pageSize,
			int currentPage);
    
    public PageSec<UserInfo> findUserByDescriptionForPage(String description,
			int pageSize, int currentPage);
    
    public PageSec<UserInfo> findAllUserForPage(int pageSize, int currentPage);
    
   

}
