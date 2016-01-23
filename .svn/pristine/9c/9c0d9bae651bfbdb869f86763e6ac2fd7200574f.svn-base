package cn.xaut.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.UserDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.UserInfo;

@Repository("userDao")
public class UserDaoImpl extends HibernateRepository<UserInfo, Integer>  implements UserDao {
	
	public Page<UserInfo> searchUser(Page<UserInfo> page) {
		// TODO Auto-generated method stub
		
		// pageRequest.setCountTotal(false);
		StringBuffer hqlBuff = new StringBuffer(
				"select a from UserInfo as a where a.username like ? and and userInfo.state in(0,1)  order by a.userinfoId desc");
		List<Object> values = new ArrayList<Object>();
		values.add("%%");
		page = findPage(page, hqlBuff.toString(), values.toArray());
		return page;
	}

	public UserInfo findUserById(Integer id) {
		StringBuffer hqlBuff = new StringBuffer("FROM UserInfo a WHERE a.userinfoId =?");
		List<Object> values = new ArrayList<Object>();
		values.add(id);
		List<UserInfo> list=find(hqlBuff.toString(),values.toArray());
		if(list != null&&list.size()>0)
		   {
			   return list.get(0);
		   }
		   else
		   {
			  return  null;
		   }
	}

	public UserInfo findUserByLoginName(String loginName) {
		StringBuffer hqlBuff = new StringBuffer("FROM UserInfo a WHERE a.username =?");
		List<Object> values = new ArrayList<Object>();
		values.add(loginName);
		List<UserInfo> list=find(hqlBuff.toString(),values.toArray());
		if(list != null&&list.size()>0)
		   {
			   return list.get(0);
		   }
		   else
		   {
			  return  null;
		   }
	}

	@Override
	public List<UserInfo> findByUser(String username,String pwd) {
		StringBuffer hqlBuff = new StringBuffer("FROM UserInfo a WHERE a.role='0' and a.username =? AND a.password=?");
		List<Object> values = new ArrayList<Object>();
		values.add(username);
		values.add(pwd);
		return find(hqlBuff.toString(),values.toArray());
	}
	@Override
	public List<UserInfo> conlogin(String username,String pwd) {
		StringBuffer hqlBuff = new StringBuffer("FROM UserInfo a WHERE a.username =? AND a.password=?");
		List<Object> values = new ArrayList<Object>();
		values.add(username);
		values.add(pwd);
		return find(hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<UserInfo>  findByKey(Page<UserInfo> page,String stype, String key) {
		String sql="";
		String key1=key;
		key="%"+key+"%";
		switch (stype)
		{  
		   case "用户名": sql="SELECT DISTINCT userInfo FROM UserInfo userInfo,Role role WHERE userInfo.username like ? and userInfo.state in(0,1) and  role.roleName='ROLE_User' and userInfo in elements(role.users) ";
		         break;
			   
		   case "姓名":sql="SELECT DISTINCT userInfo FROM UserInfo userInfo,Role role WHERE userInfo.name like ? and userInfo.state in(0,1)  and   role.roleName='ROLE_User' and userInfo in elements(role.users)";
	         break;
			   
		   case "联系方式":sql="SELECT DISTINCT userInfo FROM UserInfo userInfo,Role role WHERE userInfo.telephone like ? and userInfo.state in(0,1) and  role.roleName='ROLE_User' and userInfo in elements(role.users)";
	         break;
			   
		   case "邮箱":sql="SELECT DISTINCT userInfo FROM UserInfo userInfo,Role role WHERE userInfo.mail like ?and userInfo.state in(0,1) and  role.roleName='ROLE_User' and userInfo in elements(role.users)";
	         break;
			   
		   case "状态":sql="SELECT DISTINCT userInfo FROM UserInfo userInfo,Role role WHERE userInfo.state in(0,1) and  role.roleName='ROLE_User' and userInfo in elements(role.users)";
		             key=key1;
	         break;
		}
		sql=sql+" order by userInfo.userinfoId desc";
		StringBuffer hqlBuff = new StringBuffer(sql);
		List<Object> values = new ArrayList<Object>();
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<UserInfo> find(Page<UserInfo> page) {
		StringBuffer hqlBuff = new StringBuffer("SELECT DISTINCT userInfo FROM UserInfo userInfo,Role role WHERE userInfo.state in(0,1) and role.roleName='ROLE_User' and userInfo in elements(role.users) order by userInfo.userinfoId desc");
		List<Object> values = new ArrayList<Object>();
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public List<UserInfo> findSuperUser(String username, String password) {
		StringBuffer hqlBuff = new StringBuffer("FROM UserInfo a WHERE a.role='3' and a.username =? AND a.password=?");
		//StringBuffer hqlBuff = new StringBuffer("FROM UserInfo a WHERE a.username =? AND a.password=?");
		List<Object> values = new ArrayList<Object>();
		values.add(username);
		values.add(password);
		return find(hqlBuff.toString(),values.toArray());
	}

	@Override
	public UserInfo findAdminByLoginName(String username) {
		StringBuffer hqlBuff = new StringBuffer("FROM UserInfo a WHERE a.role='2' and  a.username =?");
		List<Object> values = new ArrayList<Object>();
		values.add(username);
		List<UserInfo> list=find(hqlBuff.toString(),values.toArray());
		if(list != null&&list.size()>0)
		   {
			   return list.get(0);
		   }
		   else
		   {
			  return  null;
		   }
	}

	@Override
	public Page<UserInfo> findAdmin(Page<UserInfo> page) {
		StringBuffer hqlBuff = new StringBuffer("FROM UserInfo a where a.role='2' order by a.userinfoId desc");
		List<Object> values = new ArrayList<Object>();
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	
	
	
	@Override
	public Page<UserInfo> findAllAdminUseRole(Page<UserInfo> page) {
		StringBuffer hqlBuff = new StringBuffer("SELECT DISTINCT userInfo FROM UserInfo userInfo,Role role WHERE role.roleName='ROLE_Admin' and userInfo in elements(role.users) order by userInfo.userinfoId desc");
		List<Object> values = new ArrayList<Object>();		
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<UserInfo> findAdminByKey(Page<UserInfo> page, String key) {
		key="%"+key+"%";
		StringBuffer hqlBuff = new StringBuffer("FROM UserInfo a WHERE a.role='2' and a.username like ? order by a.userinfoId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}
	
	

	@Override
	public Page<UserInfo> findAdminByKeyUseRole(Page<UserInfo> page, String key) {
		key="%"+key+"%";
		StringBuffer hqlBuff = new StringBuffer("SELECT DISTINCT userInfo FROM UserInfo userInfo,Role role  WHERE userInfo.username like ? and  role.roleName='ROLE_Admin' and userInfo in elements(role.users)");
		List<Object> values = new ArrayList<Object>();
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public UserInfo findAdminById(Integer id) {
		StringBuffer hqlBuff = new StringBuffer("FROM UserInfo a WHERE a.userinfoId =?");
		List<Object> values = new ArrayList<Object>();
		values.add(id);
		List<UserInfo> list=find(hqlBuff.toString(),values.toArray());
		if(list != null&&list.size()>0)
		   {
			   return list.get(0);
		   }
		   else
		   {
			  return  null;
		   }
	}

	@Override
	public List<UserInfo> findAdminByName(String username, String password) {
		StringBuffer hqlBuff = new StringBuffer("FROM UserInfo a WHERE a.role='2' and a.username =? AND a.password=?");
		//StringBuffer hqlBuff = new StringBuffer("FROM UserInfo a WHERE a.username =? AND a.password=?");
		List<Object> values = new ArrayList<Object>();
		values.add(username);
		values.add(password);
		return find(hqlBuff.toString(),values.toArray());
	}
	
	/*-----------------------------------*/
	/*下面的函数是为了与权限保持一致为新添加的*/
	/*-----------------------------------*/
	
	@Override
	public cn.xaut.common.security.domain.PageSec<UserInfo> queryUserByAccountForPage(
			String username, int pageSize, int currentPage) {
		
		String hql = "SELECT DISTINCT user FROM UserInfo user where user.username like '%" + username + "%'";
		int allRow = getAllRowCount(hql);//�ܼ�¼��
		int totalPage = cn.xaut.common.security.domain.PageSec.countTotalPage(pageSize, allRow);//��ҳ��
		if(currentPage > totalPage){
			currentPage = totalPage;
		}
		int offset = cn.xaut.common.security.domain.PageSec.countOffset(pageSize, currentPage);//��ǰҳ��ʼ��¼
		int length = pageSize;//ÿҳ��¼��
		int currentPage1 = cn.xaut.common.security.domain.PageSec.countCurrentPage(currentPage);
		List<UserInfo> authorities = queryForPage(hql, offset, length);//"һҳ"�ļ�¼
		cn.xaut.common.security.domain.PageSec<UserInfo> page = new cn.xaut.common.security.domain.PageSec<UserInfo>();
		page.setAllRow(allRow);
		page.setCurrentPage(currentPage1);
		page.setPageSize(pageSize);
		page.setTotalPage(totalPage);
		page.setList(authorities);
		page.init();
		return page;

	}

	@Override
	public cn.xaut.common.security.domain.PageSec<UserInfo> queryAllUserForPage(
			int pageSize, int currentPage) {
		
		String hql = "SELECT DISTINCT user FROM UserInfo user";
		int allRow = getAllRowCount(hql);//�ܼ�¼��
		int totalPage = cn.xaut.common.security.domain.PageSec.countTotalPage(pageSize, allRow);//��ҳ��
		if(currentPage > totalPage){
			currentPage = totalPage;
		}
		int offset = cn.xaut.common.security.domain.PageSec.countOffset(pageSize, currentPage);//��ǰҳ��ʼ��¼
		int length = pageSize;//ÿҳ��¼��
		int currentPage1 = cn.xaut.common.security.domain.PageSec.countCurrentPage(currentPage);
		List<UserInfo> authorities = queryForPage(hql, offset, length);//"һҳ"�ļ�¼
		cn.xaut.common.security.domain.PageSec<UserInfo> page = new cn.xaut.common.security.domain.PageSec<UserInfo>();
		page.setAllRow(allRow);
		page.setCurrentPage(currentPage1);
		page.setPageSize(pageSize);
		page.setTotalPage(totalPage);
		page.setList(authorities);
		page.init();
		return page;
	}
	
	@SuppressWarnings("unchecked")
	public int getAllRowCount(String hql) {
		Query query = getSession().createQuery(hql);
		List<UserInfo> users = query.list();
		return users.size();
	}
	
	@SuppressWarnings("unchecked")
	public List<UserInfo> queryForPage(String hql, int offset, int length) {
		Query query = getSession().createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(length);
		List<UserInfo> users = query.list();
		return users;
	}

	@Override
	public UserInfo findUserByUsername(String username) {
		StringBuffer hqlBuff = new StringBuffer("FROM UserInfo a WHERE a.username =?");
		List<Object> values = new ArrayList<Object>();
		values.add(username);
		List<UserInfo> list=find(hqlBuff.toString(),values.toArray());
		if(list != null&&list.size()>0)
		   {
			   return list.get(0);
		   }
		   else
		   {
			  return  null;
		   }
	}

	
	
}
