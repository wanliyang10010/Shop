package cn.xaut.common.security.dao.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.xaut.common.security.dao.UserSecurityDao;
import cn.xaut.common.security.domain.PageSec;
import cn.xaut.shop.pojo.Role;
import cn.xaut.shop.pojo.UserInfo;

@Repository(value="userSecurityDao")
public class UserSecurityDaoImpl implements UserSecurityDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	//��ȡ�͵�ǰ�̰߳󶨵�Session
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public boolean addUser(UserInfo user) {
		Integer id = (Integer) getSession().save(user);
		if(id < 0){
			return false;
		}
		return true;
	}

	@Override
	public void deleteUserById(Integer id) {
		
		/**修改了原来的代码，没有直接删除 进行了更新*/
		
		/*String hql = "DELETE User user WHERE user.id = ?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, id);
		int result = query.executeUpdate();
		if(result <= 0){
			return false;
		}
		return true;*/
		UserInfo user = (UserInfo) getSession().get(UserInfo.class, id);
		
		//�����role��˵user�Ǳ��ط�
		Set<Role> roles = user.getRoles();
		Iterator<Role> iter = roles.iterator();
		while(iter.hasNext()){
			Role role = iter.next();
			role.getUsers().remove(user);
		}
		
		//不能直接删除用户，目前置为冻结
		//getSession().delete(user);
		user.setState("1");
		getSession().update(user);
	}

	@Override
	public boolean deleteUserByAccount(String account) {
		
		//不能直接删除用户
		//String hql = "DELETE User user WHERE user.username = ?";
		String hql = "Update UserInfo u Set u.state = '1' WHERE u.username = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, account);
		int result = query.executeUpdate();
		if(result <= 0){
			return false;
		}
		return true;
	}

	@Override
	public UserInfo getUserById(Integer id) {
		UserInfo user = (UserInfo) getSession().get(UserInfo.class, id);
		return user;
	}

	@Override
	public UserInfo getUserByAccount(String account) {
		
		//1������Query����
		String hql = "FROM UserInfo user WHERE user.username = ? order by user.userinfoId asc";
		Query query = getSession().createQuery(hql);
		//2���󶨲���
		query.setString(0, account);
		//3��ִ�в�ѯ
		//UserInfo user = (UserInfo) query.uniqueResult();
		List<UserInfo> list =query.list();
		UserInfo user=new UserInfo();
		if(list!=null&&list.size()>0)
		{
			 user= (UserInfo)list.get(0);
		}		//.uniqueResult();
		else
		{
			user=null;
		}
		return user;
	}
	@Override
	public List<Role> getRolesById(Integer id) {
		
		String hql ="SELECT DISTINCT user FROM UserInfo user ,Role role WHERE user.userinfoId=? and user in elements(role.users) order by user.userinfoId asc";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, id);
		//UserInfo user = (UserInfo) query.uniqueResult();
		List<UserInfo> list =query.list();
		UserInfo user=new UserInfo();
		if(list!=null&&list.size()>0)
		{
			 user= (UserInfo)list.get(0);
		}		//.uniqueResult();
		else
		{
			user=null;
		}
		//Setת����List
		List<Role> listRoles = new ArrayList<Role>();
		try {
			if(user.getRoles() != null)
			{
				Set<Role> setRoles = user.getRoles();
				listRoles = new ArrayList<Role>();
				listRoles.addAll(setRoles);
			}
			
		} catch (Exception e) {
			System.out.println("user.getRoles() ��ָ���쳣����ʱ�����?");
			e.printStackTrace();
		}
		return listRoles;
	}

	@Override
	public List<Role> getRolesByAccount(String account) {
		
		String hql ="SELECT DISTINCT user FROM UserInfo user ,Role role WHERE user.username=? and user in elements(role.users) order by user.userinfoId asc";
		Query query = getSession().createQuery(hql);
		query.setString(0, account);
		
		//UserInfo user = (UserInfo) query.uniqueResult();
		List<UserInfo> list =query.list();
		UserInfo user=new UserInfo();
		if(list!=null&&list.size()>0)
		{
			 user= (UserInfo)list.get(0);
		}		//.uniqueResult();
		else
		{
			user=null;
		}
		Set<Role> setRoles = user.getRoles();
		List<Role> listRoles = new ArrayList<Role>();
		listRoles.addAll(setRoles);
		return listRoles;
	}

	@Override
	public String findPasswordByAccount(String account) {
		String hql = "SELECT DISTINCT user FROM UserInfo user WHERE user.username=? order by user.userinfoId asc";
		Query query = getSession().createQuery(hql);
		query.setString(0, account);
		//UserInfo user = (UserInfo) query.uniqueResult();
		List<UserInfo> list =query.list();
		UserInfo user=new UserInfo();
		if(list!=null&&list.size()>0)
		{
			 user= (UserInfo)list.get(0);
		}		//.uniqueResult();
		else
		{
			user=null;
		}
		String password = user.getPassword();
		return password;
	}

	@Override
	public List<UserInfo> findAllUsers() {
		String hql = "SELECT DISTINCT user FROM UserInfo user";
		Query query = getSession().createQuery(hql);
		List<UserInfo> users = query.list();
		return users;
	}

	@Override
	public void updateUser(UserInfo user) {
		getSession().update(user);
	}

	@Override
	public List<UserInfo> queryForPage(String hql, int offset, int length) {
		Query query = getSession().createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(length);
		List<UserInfo> users = query.list();
		return users;
	}

	@Override
	public int getAllRowCount(String hql) {
		Query query = getSession().createQuery(hql);
		List<UserInfo> users = query.list();
		return users.size();
	}
	
	/* 合并 */
	@Override
	public void upload(File upload, File dstFile) {
		InputStream in=null;
		OutputStream out=null;
		try {
			in=new BufferedInputStream(new FileInputStream(upload));
			out=new BufferedOutputStream(new FileOutputStream(dstFile));
			byte[] buffer=new byte[1024*1024];
			int len=0;	
			while((len=in.read(buffer))!=-1){
				out.write(buffer,0,len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public PageSec<UserInfo> findUserByAccountForPage(String account, int pageSize,
			int currentPage) {
		String hql = "SELECT DISTINCT user FROM UserInfo user where user.username like '%" + account + "%'";
		int allRow = getAllRowCount(hql);//�ܼ�¼��
		int totalPage = PageSec.countTotalPage(pageSize, allRow);//��ҳ��
		if(currentPage > totalPage){
			currentPage = totalPage;
		}
		int offset = PageSec.countOffset(pageSize, currentPage);//��ǰҳ��ʼ��¼
		int length = pageSize;//ÿҳ��¼��
		int currentPage1 = PageSec.countCurrentPage(currentPage);
		List<UserInfo> authorities = queryForPage(hql, offset, length);//"һҳ"�ļ�¼
		//�ѷ�ҳ��Ϣ���浽Page��Bean��
		PageSec<UserInfo> page = new PageSec<UserInfo>();
		page.setAllRow(allRow);
		page.setCurrentPage(currentPage1);
		page.setPageSize(pageSize);
		page.setTotalPage(totalPage);
		page.setList(authorities);
		page.init();
		return page;	
	}

	@Override
	public PageSec<UserInfo> findUserByDescriptionForPage(String description,
			int pageSize, int currentPage) {
		String hql = "SELECT DISTINCT user FROM UserInfo user where user.description like '%" + description + "%'";
		int allRow = getAllRowCount(hql);//�ܼ�¼��
		int totalPage = PageSec.countTotalPage(pageSize, allRow);//��ҳ��
		if(currentPage > totalPage){
			currentPage = totalPage;
		}
		int offset = PageSec.countOffset(pageSize, currentPage);//��ǰҳ��ʼ��¼
		int length = pageSize;//ÿҳ��¼��
		int currentPage1 = PageSec.countCurrentPage(currentPage);
		List<UserInfo> authorities = queryForPage(hql, offset, length);//"һҳ"�ļ�¼
		//�ѷ�ҳ��Ϣ���浽Page��Bean��
		PageSec<UserInfo> page = new PageSec<UserInfo>();
		page.setAllRow(allRow);
		page.setCurrentPage(currentPage1);
		page.setPageSize(pageSize);
		page.setTotalPage(totalPage);
		page.setList(authorities);
		page.init();
		return page;
	}

	@Override
	public PageSec<UserInfo> findAllUserForPage(int pageSize, int currentPage) {
		String hql = "SELECT DISTINCT user FROM UserInfo user";
		int allRow = getAllRowCount(hql);//�ܼ�¼��
		int totalPage = PageSec.countTotalPage(pageSize, allRow);//��ҳ��
		if(currentPage > totalPage){
			currentPage = totalPage;
		}
		int offset = PageSec.countOffset(pageSize, currentPage);//��ǰҳ��ʼ��¼
		int length = pageSize;//ÿҳ��¼��
		int currentPage1 = PageSec.countCurrentPage(currentPage);
		List<UserInfo> authorities = queryForPage(hql, offset, length);//"һҳ"�ļ�¼
		//�ѷ�ҳ��Ϣ���浽Page��Bean��
		PageSec<UserInfo> page = new PageSec<UserInfo>();
		page.setAllRow(allRow);
		page.setCurrentPage(currentPage1);
		page.setPageSize(pageSize);
		page.setTotalPage(totalPage);
		page.setList(authorities);
		page.init();
		return page;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
