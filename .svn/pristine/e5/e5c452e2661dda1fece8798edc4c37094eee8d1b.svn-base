package cn.xaut.shop.service.impl;


import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.xaut.shop.service.BaseService;

//不进行类型检查
@SuppressWarnings("unchecked")
public class BaseServiceImpl<T> implements BaseService<T> {

	protected HibernateTemplate hibernateTemplate = null;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// 真实要操作的类 - 确定的类
	//如果获取这个类呢  --> 构造方法
	private Class<T> clazz = null;
	
	public BaseServiceImpl()
	{
		//this.getClass获得子类类型，然后获取当前类类型的父类
		//要获得父类的参数类型，所以使用ParameterizedType
		ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	public void save(T t) {
		hibernateTemplate.save(t);
		hibernateTemplate.flush();
	}

	public void update(T t) {
		hibernateTemplate.update(t);
	}

	public T get(int id) {
		return hibernateTemplate.get(clazz, id);
	}


	public List<T> query() {
		// 需要获取类名
		return hibernateTemplate.find("FROM " + clazz.getSimpleName());
	}

	public void delete(int id) {
		Object obj = hibernateTemplate.get(clazz, id);
		if (obj != null) {
			hibernateTemplate.delete(obj);
		}
	}
	

	public T add(T t) {
		// TODO Auto-generated method stub
		Integer id= (Integer) hibernateTemplate.save(t);
		System.out.println(id);
		return t;
	}


}
