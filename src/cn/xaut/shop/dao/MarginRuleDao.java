package cn.xaut.shop.dao;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.MarginRule;

public interface MarginRuleDao extends CrudRepository<MarginRule, Integer>{
	public Page<MarginRule> findByKey(Page<MarginRule> page,String Str,String key);
	public Page<MarginRule> find(Page<MarginRule> page);
	public Page<MarginRule> findByName(Page<MarginRule> page,String type,String name);
	public String getShopMargin(String shopcategory,String productcategory);
}
