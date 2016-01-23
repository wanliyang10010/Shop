package cn.xaut.shop.modules.repository.support;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.xaut.shop.modules.repository.Repository;

public abstract class AbstractRepositorySupport<T, ID extends Serializable>
		implements Repository<T, ID> {

	protected Class<T> entityClass;

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("unchecked")
	public AbstractRepositorySupport() {
		Type genericType = this.getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) ((ParameterizedType) genericType)
				.getActualTypeArguments()[0];
	}

	public AbstractRepositorySupport(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
