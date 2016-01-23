package cn.xaut.shop.modules.repository.hibernate3;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.common.paging.domain.PageRequest;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.modules.repository.support.AbstractRepositorySupport;
import cn.xaut.shop.pojo.Goods;

public class HibernateRepository<T, ID extends Serializable> extends AbstractRepositorySupport<T, ID> implements CrudRepository<T, ID> {

	protected SessionFactory sessionFactory;

	public HibernateRepository() {
	}

	public HibernateRepository(Class<T> entityClass) {
		super(entityClass);
	}

	/**
	 * 取得sessionFactory.
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * 采用@Autowired按类型注入SessionFactory, 当有多个SesionFactory的时候在子类重载本函数.
	 */
	@Autowired
	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 取得当前Session.
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 保存新增的对象.
	 */
	public void save(T entity) {
		Assert.notNull(entity, "entity不能为空");
		getSession().save(entity);
		logger.debug("save entity: {}", entity);
	}

	/**
	 * 保存修改的对象.
	 */
	public void update(T entity) {
		Assert.notNull(entity, "entity不能为空");
		getSession().update(entity);
		logger.debug("update entity: {}", entity);
	}
	
	/**
	 * 保存修改session中的对象.  ywl
	 */
	public void merge(T entity) {
		Assert.notNull(entity, "entity不能为空");
		getSession().merge(entity);
		//getSession().update(entity);
		logger.debug("merge entity: {}", entity);
	}
	
	/**
	 * 保存或更新对象
	 * @param entity
	 */
	public void saveOrupdate(T entity)
	{
		Assert.notNull(entity, "entity不能为空");
		getSession().saveOrUpdate(entity);
		logger.debug("saveOrupdate entity: {}", entity);
	}

	/**
	 * 删除对象.
	 * 
	 * @param entity
	 *            对象必须是session中的对象或含id属性的transient对象.
	 */
	public void delete(final T entity) {
		Assert.notNull(entity, "entity不能为空");
		getSession().delete(entity);
		logger.debug("delete entity: {}", entity);
	}

	/**
	 * 按id删除对象.
	 */
	public void deleteById(ID id) {
		Assert.notNull(id, "id不能为空");
		delete(findById(id));
		logger.debug("delete entity {},id is {}", entityClass.getSimpleName(), id);
	}

	/**
	 * 按id获取对象.
	 */
	@SuppressWarnings("unchecked")
	public T findById(ID id) {
		Assert.notNull(id, "id不能为空");
		return (T) getSession().load(entityClass, id);
	}

	/**
	 * 按id列表获取对象列表.
	 */
	public List<T> findByIds(Collection<ID> ids) {
		return find(Restrictions.in(getIdName(), ids));
	}

	public Page<T> findAll(PageRequest pageRequest) {
		String hql = "from " + entityClass.getSimpleName();
		return findPage(pageRequest, hql);
	}

	/**
	 * 按HQL分页查询.
	 * 
	 * @param pageRequest
	 *            分页参数.
	 * @param hql
	 *            hql语句.
	 * @param values
	 *            数量可变的查询参数,按顺序绑定.
	 * 
	 * @return 分页查询结果, 附带结果列表及所有查询输入参数.
	 */
	@SuppressWarnings("unchecked")
	public Page<T> findPage(final PageRequest pageRequest, String hql, final Object... values) {
		Assert.notNull(pageRequest, "pageRequest不能为空");

		Page<T> page = new Page<T>(pageRequest);

		if (pageRequest.isCountTotal()) {
			long totalCount = countHqlResult(hql, values);
			page.setTotalItems(totalCount);
		}
		
		Query q = createQuery(hql, values);

		setPageParameterToQuery(q, pageRequest);

		List<T> result = q.list();
		page.setResult(result);
		return page;
	}

	/**
	 * 按HQL分页查询.
	 * 
	 * @param page
	 *            分页参数.
	 * @param hql
	 *            hql语句.
	 * @param values
	 *            命名参数,按名称绑定.
	 * 
	 * @return 分页查询结果, 附带结果列表及所有查询输入参数.
	 */
	@SuppressWarnings("unchecked")
	public Page<T> findPage(final PageRequest pageRequest, String hql, final Map<String, ?> values) {
		Assert.notNull(pageRequest, "page不能为空");

		Page<T> page = new Page<T>(pageRequest);
        
		if (pageRequest.isCountTotal()) {
			long totalCount = countHqlResult(hql, values);
			page.setTotalItems(totalCount);
		}

		Query q = createQuery(hql, values);
		setPageParameterToQuery(q, pageRequest);

		List<T> result = q.list();
		page.setResult(result);	
		return page;
	}
	@SuppressWarnings("unchecked") 

	//ywl 带消息定位的分页
	public Page<T> findPage(final PageRequest pageRequest,int id, String hql, final Object... values) {
		Assert.notNull(pageRequest, "pageRequest不能为空");
		Page<T> page = new Page<T>(pageRequest);
		if (pageRequest.isCountTotal()) {
			long totalCount = countHqlResult(hql, values);
			page.setTotalItems(totalCount);
		}		
		Query q = createQuery(hql, values);
		setPageParameterToQuery(q, pageRequest);
		List<T> result = q.list();
		page.setResult(result);
		if((id!=-1)&&(page.getPageNo()==1)){
			 T t=(T) getSession().load(entityClass, id);						
				 if(page.getTotalItems()>page.getPageSize()){
					 for(int i=0;i<page.getPageSize();i++){
					 if(page.getResult().get(i).equals(t)){
						 return page;	
						}						
					 }
					 page.getResult().remove(page.getPageSize()-1);
					 page.getResult().add(0, t);
				 }										      		 		   	
		}		
		return page;
	}
	/**
	 * 设置分页参数到Query对象,辅助函数.
	 */
	protected Query setPageParameterToQuery(final Query q, final PageRequest pageRequest) {
		q.setFirstResult(pageRequest.getOffset());
		q.setMaxResults(pageRequest.getPageSize());
		return q;
	}
	
	/**
	 * 执行count查询获得本次Hql查询所能获得的对象总数.
	 * 
	 * 本函数只能自动处理简单的hql语句,复杂的hql查询请另行编写count语句查询.
	 */
	protected long countHqlResult(final String hql, final Object... values) {
		String countHql = prepareCountHql(hql);

		try {
			Long count = findUnique(countHql, values);
			return count;
		} catch (Exception e) {
			throw new RuntimeException("hql can't be auto count, hql is:" + countHql, e);
		}
	}

	/**
	 * 执行count查询获得本次Hql查询所能获得的对象总数.
	 * 
	 * 本函数只能自动处理简单的hql语句,复杂的hql查询请另行编写count语句查询.
	 */
	protected long countHqlResult(final String hql, final Map<String, ?> values) {
		String countHql = prepareCountHql(hql);

		try {
			Long count = findUnique(countHql, values);
			return count;
		} catch (Exception e) {
			throw new RuntimeException("hql can't be auto count, hql is:" + countHql, e);
		}
	}

	private String prepareCountHql(String orgHql) {
		String countHql = "select count (*) " + removeSelect(removeOrders(orgHql));
		return countHql;
	}

	private static String removeSelect(String hql) {
		int beginPos = hql.toLowerCase().indexOf("from");
		return hql.substring(beginPos);
	}

	private static String removeOrders(String hql) {
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 获得总记录数
	 */
	public Long count() {
		return (Long) createCriteria().setProjection(Projections.rowCount()).uniqueResult();
	}

	/**
	 * 获取全部对象.
	 */
	public List<T> findAll() {
		return find();
	}

	/**
	 * 获取全部对象, 支持按属性行序.
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll(String orderByProperty, boolean isAsc) {
		Criteria c = createCriteria();
		if (isAsc) {
			c.addOrder(Order.asc(orderByProperty));
		} else {
			c.addOrder(Order.desc(orderByProperty));
		}
		return c.list();
	}

	/**
	 * 按属性查找对象列表, 匹配方式为相等.
	 */
	public List<T> findBy(final String propertyName, final Object value) {
		Assert.hasText(propertyName, "propertyName不能为空");
		Criterion criterion = Restrictions.eq(propertyName, value);
		return find(criterion);
	}

	/**
	 * 按属性查找唯一对象, 匹配方式为相等.
	 */
	@SuppressWarnings("unchecked")
	public T findUniqueBy(final String propertyName, final Object value) {
		Assert.hasText(propertyName, "propertyName不能为空");
		Criterion criterion = Restrictions.eq(propertyName, value);
		return (T) createCriteria(criterion).uniqueResult();
	}

	/**
	 * 根据查询HQL与参数列表创建Query对象. 与find()函数可进行更加灵活的操作.
	 * 
	 * @param values
	 *            数量可变的参数,按顺序绑定.
	 */
	public Query createQuery(final String queryString, final Object... values) {
		Assert.hasText(queryString, "queryString不能为空");
		Query query = getSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}

	/**
	 * 根据查询HQL与参数列表创建Query对象. 与find()函数可进行更加灵活的操作.
	 * 
	 * @param values
	 *            命名参数,按名称绑定.
	 */
	public Query createQuery(final String queryString, final Map<String, ?> values) {
		Assert.hasText(queryString, "queryString不能为空");
		Query query = getSession().createQuery(queryString);
		if (values != null) {
			query.setProperties(values);
		}
		return query;
	}

	/**
	 * 按HQL查询对象列表.
	 * 
	 * @param values
	 *            数量可变的参数,按顺序绑定.
	 */
	@SuppressWarnings("unchecked")
	public <X> List<X> find(final String hql, final Object... values) {
		return createQuery(hql, values).list();
	}

	/**
	 * 按HQL查询对象列表.
	 * 
	 * @param values
	 *            命名参数,按名称绑定.
	 */
	@SuppressWarnings("unchecked")
	public <X> List<X> find(final String hql, final Map<String, ?> values) {
		return createQuery(hql, values).list();
	}

	/**
	 * 按HQL查询唯一对象.
	 * 
	 * @param values
	 *            数量可变的参数,按顺序绑定.
	 */
	@SuppressWarnings("unchecked")
	public <X> X findUnique(final String hql, final Object... values) {
		return (X) createQuery(hql, values).uniqueResult();
	}

	/**
	 * 按HQL查询唯一对象.
	 * 
	 * @param values
	 *            命名参数,按名称绑定.
	 */
	@SuppressWarnings("unchecked")
	public <X> X findUnique(final String hql, final Map<String, ?> values) {
		return (X) createQuery(hql, values).uniqueResult();
	}

	/**
	 * 根据Criterion条件创建Criteria. 与find()函数可进行更加灵活的操作.
	 * 
	 * @param criterions
	 *            数量可变的Criterion.
	 */
	public Criteria createCriteria(final Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}

	/**
	 * 按Criteria查询对象列表.
	 * 
	 * @param criterions
	 *            数量可变的Criterion.
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(final Criterion... criterions) {
		return createCriteria(criterions).list();
	}

	/**
	 * 按Criteria查询唯一对象.
	 * 
	 * @param criterions
	 *            数量可变的Criterion.
	 */
	@SuppressWarnings("unchecked")
	public T findUnique(final Criterion... criterions) {
		return (T) createCriteria(criterions).uniqueResult();
	}

	/**
	 * 初始化对象. 使用load()方法得到的仅是对象Proxy, 在传到View层前需要进行初始化. 如果传入entity, 则只初始化entity的直接属性,但不会初始化延迟加载的关联集合和属性. 如需初始化关联属性,需执行: Hibernate.initialize(user.getRoles())，初始化User的直接属性和关联集合. Hibernate.initialize(user.getDescription())，初始化User的直接属性和延迟加载的Description属性.
	 */
	public void initProxyObject(Object proxy) {
		Hibernate.initialize(proxy);
	}

	/**
	 * Flush当前Session.
	 */
	public void flush() {
		getSession().flush();
	}

	/**
	 * 为Query添加distinct transformer. 预加载关联对象的HQL会引起主对象重复, 需要进行distinct处理.
	 */
	public Query distinct(Query query) {
		query.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return query;
	}

	/**
	 * 为Criteria添加distinct transformer. 预加载关联对象的HQL会引起主对象重复, 需要进行distinct处理.
	 */
	public Criteria distinct(Criteria criteria) {
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return criteria;
	}

	/**
	 * 取得对象的主键名.
	 */
	public String getIdName() {
		ClassMetadata meta = getSessionFactory().getClassMetadata(entityClass);
		return meta.getIdentifierPropertyName();
	}

	/**
	 * 判断对象的属性值在数据库内是否唯一.
	 * 
	 * 在修改对象的情景下,如果属性新修改的值(value)等于属性原来的值(orgValue)则不作比较.
	 */
	public boolean isPropertyUnique(final String propertyName, final Object newValue, final Object oldValue) {
		if (newValue == null || newValue.equals(oldValue)) {
			return true;
		}
		Object object = findUniqueBy(propertyName, newValue);
		return (object == null);
	}

	/**
	 * 执行HQL进行批量修改/删除操作.
	 * 
	 * @param values
	 *            数量可变的参数,按顺序绑定.
	 * @return 更新记录数.
	 */
	public int batchExecute(final String hql, final Object... values) {
		return createQuery(hql, values).executeUpdate();
	}

	/**
	 * 执行HQL进行批量修改/删除操作.
	 * 
	 * @param values
	 *            命名参数,按名称绑定.
	 * @return 更新记录数.
	 */
	public int batchExecute(final String hql, final Map<String, ?> values) {
		return createQuery(hql, values).executeUpdate();
	}
	
	public T add(T t) {
		// TODO Auto-generated method stub
		Integer id= (Integer) getSession().save(t);
		//System.out.println(id);
		return t;
	}
	
	/*----------------author donglei -----  excute-Sql-Command-----------------------*/
	/***
	 * 按照Sql语句执行查询
	 * @param sql
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws HibernateException 
	 */
	@SuppressWarnings("unchecked")
	public List queryBySql(final String sql,final String clazz,final Object... values) throws HibernateException, ClassNotFoundException {
		List<Object> list =  createSqlQuery(sql,values).addEntity(Class.forName(clazz)).list();
        return list;
    }    
    
	/**
	 * Sql更新或删除记录
	 * @param sql
	 * @param values
	 * @return 影响的数量
	 */
    public int excuteBySql(final String sql,final Object... values){    
        return createSqlQuery(sql,values).executeUpdate();    
    }
	
    /**
     * 创建查询query对象，填充查询参数
     * @param sql
     * @param values
     * @return
     */
	public SQLQuery createSqlQuery(final String sql,final Object... values){
		SQLQuery query = this.getSession().createSQLQuery(sql); 
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}
}
