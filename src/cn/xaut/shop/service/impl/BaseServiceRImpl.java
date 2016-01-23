package cn.xaut.shop.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.common.paging.domain.PageRequest;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.service.BaseServiceR;

@Service
@Transactional
public class BaseServiceRImpl<T, ID> implements BaseServiceR<T, Integer> {

	protected CrudRepository<T, Integer> baseDao = null;

	@Autowired
	public void setBaseDao(CrudRepository<T, Integer> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void save(T entity) {
		baseDao.save(entity);
	}

	@Override
	public void update(T entity) {
		baseDao.update(entity);
	}
	
	@Override
	public void merge(T entity) {
		baseDao.merge(entity);
	}
	
	@Override
	public T get(int id) {
		return baseDao.findById(id);
	}

	@Override
	public List<T> query() {
		return baseDao.findAll();
	}

	@Override
	public void delete(int id) {
		baseDao.deleteById(id);
	}
	
	@Override
	public void delete(T t)
	{
		baseDao.delete(t);
	}

	@Override
	public void deleteById(Integer id) {
		baseDao.deleteById(id);
	}

	@Override
	public T findById(Integer id) {
		return baseDao.findById(id);
	}

	@Override
	public List<T> findByIds(Collection<Integer> ids) {
		return baseDao.findByIds(ids);
	}

	@Override
	public List<T> findAll() {
		return baseDao.findAll();
	}

	@Override
	public Page<T> findAll(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return baseDao.findAll(pageRequest);
	}

	@Override
	public T findUniqueBy(String propertyName, Object value) {
		return baseDao.findUniqueBy(propertyName, value);
	}

	@Override
	public List<T> findBy(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return baseDao.findBy(propertyName, value);
	}
	
	@Override
	public T add(T t) {
		return baseDao.add(t);
	}

}
