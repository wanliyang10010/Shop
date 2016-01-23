package cn.xaut.shop.dao;

import java.util.List;

import org.hibernate.HibernateException;

import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.SqlQuery;

public interface HqlDao extends  CrudRepository<SqlQuery, Integer>{

	/**
	 * 执行Hql查询或者删除语句
	 * @param result
	 * @return
	 */
	public int executeHql (SqlQuery result);
	
	/**
	 * 执行Hql查询语句
	 * @param result
	 * @return
	 */
	public List<Object> queryByHql(SqlQuery result);
	
	/**
	 * 执行Sql查询语句
	 * @throws ClassNotFoundException 
	 * @throws  
	 * */
	public List queryBySql(SqlQuery query) throws ClassNotFoundException;
	
	/**
	 * 执行sql更新或删除语句
	 * @param sql
	 * @return
	 */
	public int excuteBySql(SqlQuery query);

}
