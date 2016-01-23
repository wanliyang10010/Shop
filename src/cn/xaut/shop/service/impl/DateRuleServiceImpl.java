package cn.xaut.shop.service.impl;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.DateRuleDao;
import cn.xaut.shop.pojo.DateRule;
import cn.xaut.shop.service.DateRuleService;

public class DateRuleServiceImpl extends BaseServiceRImpl<DateRule,Integer> implements  DateRuleService {
	private DateRuleDao dateRuleDao = null;
	public void setDateRuleDao(DateRuleDao dateRuleDao) {
		this.dateRuleDao = dateRuleDao;
	}
	
	@Override
	public Page<DateRule> findItem(Page<DateRule> page,String rule) {
		return dateRuleDao.findByName(page,rule);
	}

	@Override
	public Page<DateRule> getList(Page<DateRule> page, String key) {
		key="%"+key+"%";
		return dateRuleDao.findByKey(page, key);
	}

	@Override
	public Page<DateRule> queryAll(Page<DateRule> page) {
		return dateRuleDao.find(page);
	}

}
