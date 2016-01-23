package cn.xaut.shop.dao;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.PointsRule;

public interface PointsRuleDao extends CrudRepository<PointsRule, Integer>{
	public Page<PointsRule> findByKey(Page<PointsRule> page,String Str,String key);
	public Page<PointsRule> find(Page<PointsRule> page);
	public Page<PointsRule> findByName(Page<PointsRule> page,String type, String rule);
	public List<PointsRule> queryByType(String type, String item);
}
