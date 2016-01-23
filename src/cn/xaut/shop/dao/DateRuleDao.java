package cn.xaut.shop.dao;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.DateRule;

public interface DateRuleDao extends CrudRepository<DateRule, Integer>{
	public Page<DateRule> findByKey(Page<DateRule> page,String key);
	public Page<DateRule> find(Page<DateRule> page);
	public Page<DateRule> findByName(Page<DateRule> page,String name);
}
