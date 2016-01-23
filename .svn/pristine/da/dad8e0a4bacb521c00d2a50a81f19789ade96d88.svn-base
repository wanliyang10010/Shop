package cn.xaut.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xaut.shop.dao.BaseDao;
import cn.xaut.shop.dao.HqlDao;
import cn.xaut.shop.pojo.SqlQuery;
import cn.xaut.shop.service.HqlService;

@Service
@Transactional
public class HqlServiceImpl extends BaseServiceRImpl<SqlQuery,Integer> implements HqlService {
	
	@Autowired
	private HqlDao hqlDao = null;

	@Override
	public int executeHql(SqlQuery query) {
		// TODO Auto-generated method stub
		return hqlDao.executeHql(query);
	}

	@Override
	public List<Object> queryByHql(SqlQuery query) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		List list = hqlDao.queryByHql(query);
		return query.getResultList(list); 
	}
	
	@Override
	public int executeSql(SqlQuery query) {
		// TODO Auto-generated method stub
		return hqlDao.excuteBySql(query);
	}

	@Override
	public List<Object> queryBySql(SqlQuery query) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		return hqlDao.queryBySql(query); 
	}
	
}
