package cn.xaut.shop.service.impl;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.MarginRuleDao;
import cn.xaut.shop.pojo.MarginRule;
import cn.xaut.shop.service.MarginRuleService;

public class MarginRuleServiceImpl extends BaseServiceRImpl<MarginRule,Integer> implements MarginRuleService {

	private MarginRuleDao marginRuleDao = null;
	public void setMarginRuleDao(MarginRuleDao marginRuleDao) {
		this.marginRuleDao = marginRuleDao;
	}
	
	@Override
	public Page<MarginRule> findItem(Page<MarginRule> page,String type, String product) {
		return marginRuleDao.findByName(page,type, product);
	}
	@Override
	public Page<MarginRule> getList(Page<MarginRule> page, String str,String key) {
		return marginRuleDao.findByKey(page,str, key);
	}
	@Override
	public Page<MarginRule> queryAll(Page<MarginRule> page) {
		return marginRuleDao.find(page);
	}
	@Override
	public  String getShopMargin(String shopcategory,String productcategory) {
		return marginRuleDao.getShopMargin(shopcategory,productcategory);
	}

}
