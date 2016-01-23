package cn.xaut.shop.service;

import java.util.List;

import cn.xaut.shop.pojo.SqlQuery;


public interface HqlService extends BaseServiceR<SqlQuery,Integer> {

	
	/**
	 * 执行查询或者删除语句
	 * @param result
	 * @return
	 */
	public int executeHql (SqlQuery query);
	
	/**
	 * 执行查询语句
	 * @param result
	 * @return
	 */
	public List<Object> queryByHql(SqlQuery query) throws ClassNotFoundException ;
	
	/**
	 * 执行Sql查询语句
	 * @param result
	 * @return
	 */
	public int executeSql(SqlQuery query);

	/**
	 * 执行Sql查询语句
	 * @param result
	 * @return
	 */
	public List<Object> queryBySql(SqlQuery query) throws ClassNotFoundException ;
	
	
}
