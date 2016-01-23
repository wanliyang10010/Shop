package cn.xaut.shop.modules.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.common.paging.domain.PageRequest;


public interface CrudRepository<T, ID extends Serializable> extends Repository<T, ID> {

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

	/**
	 * 获得总记录数
	 * @return
	 */
	Long count();

	/**
	 * 判断对象的属性值在数据库内是否唯一
	 * @param propertyName
	 * @param newValue
	 * @param oldValue
	 * @return
	 */
	boolean isPropertyUnique(final String propertyName, final Object newValue, final Object oldValue);
	
	//-------------------下面兼容原先的方法------------------------
	
	/**
     * 删除实体
     * @param entity
     */
	void delete(T entity);
	
	/**
	 * 保存或更新对象
	 * @param entity
	 */
	void saveOrupdate(T entity);
	
	T add(T t);

}
