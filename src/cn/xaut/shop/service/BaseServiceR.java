package cn.xaut.shop.service;

import java.util.Collection;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.common.paging.domain.PageRequest;


public interface BaseServiceR<T,ID> {

	/**
     * 保存实体
     * @param entity
     */
	void save(T entity);

	/**
     * 编辑实体
     * @param entity
     */
	void update(T entity);
	
	void merge(T entity);
	
	public T get(int id);

	public List<T> query();

	public void delete(int id);
	
	public void delete(T t);
	
	public T add(T t);
	
	//   上面是旧方法，要保持不变。下面是补充方法
	

	/**
     * 通过ID删除实体
     * @param entity
     */
	void deleteById(ID id);

	/**
     * 通过ID获得实体
     * @param entity
     * @return
     */
	T findById(ID id);

	/**
	 * 按id列表获取对象列表.
	 * @param ids
	 * @return
	 */
	List<T> findByIds(Collection<ID> ids);

	/**
     * 获得所有的实体
     * @param entity
     * @return
     */
	List<T> findAll();

	/**
	 * 无条件的分页查询
	 * @param request
	 * @return
	 */
	Page<T> findAll(PageRequest pageRequest);

	/**
	 * 通过属性得到唯一的实体,匹配条件为相等
	 * @param propertyName
	 * @param value
	 * @return
	 */
    T findUniqueBy(String propertyName , Object value);

	/**
	 * 通过属性得到匹配的实体,匹配条件为相等
	 * @param propertyName
	 * @param value
	 * @return
	 */
	List<T> findBy(String propertyName , Object value);

}
