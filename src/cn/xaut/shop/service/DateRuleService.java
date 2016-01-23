package cn.xaut.shop.service;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.DateRule;

public interface DateRuleService extends BaseServiceR<DateRule,Integer>{
	Page<DateRule> getList(Page<DateRule> page,String key);
	Page<DateRule> queryAll(Page<DateRule> page);
	Page<DateRule> findItem(Page<DateRule> page,String rule);
}
