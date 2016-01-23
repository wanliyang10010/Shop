package cn.xaut.shop.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import cn.xaut.shop.dao.HqlDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.SqlQuery;

@Repository(value="hqlDao")
public class HqlDaoImpl extends HibernateRepository<SqlQuery,Integer> implements HqlDao {
		
	@Override
	public int executeHql (SqlQuery query){
		return batchExecute(query.getCommand(), query.getParamsList().toArray());
	}
	
	@Override
	public List<Object> queryByHql(SqlQuery query){
		return  find(query.getCommand(), query.getParamsList().toArray());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List queryBySql(SqlQuery query) throws ClassNotFoundException {    
		List<Object[]> list = queryBySql(query.getCommand(),query.getFullClassName(),query.getParamsList().toArray());
        return list; 
    }    
    
	@Override
    public int excuteBySql(SqlQuery query){
        return 	excuteBySql(query.getCommand(),query.getParamsList().toArray());
    }  
	
}
