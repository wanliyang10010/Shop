package cn.xaut.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.UserPointDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.UserPoint;

public class UserPointDaoImpl extends HibernateRepository<UserPoint, Integer>
		implements UserPointDao {

	public UserPointDaoImpl() {
		super();
	}

	public List<UserPoint> getListByUserId(int userid) {
		String sql = "";
		sql = "FROM UserPoint a WHERE a.userinfo = '"+userid+"' order by a.operateTime desc";
		return find(sql);
	}
	
	public Page<UserPoint> getListByUserId(Page<UserPoint> page,int userid) {
		StringBuffer hqlBuff = new StringBuffer(
				"select a from UserPoint as a where a.userinfo.userinfoId= ? order by a.operateTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(userid);		
        Page<UserPoint> p=findPage(page,hqlBuff.toString(), values.toArray());
		return p;
	}
}
