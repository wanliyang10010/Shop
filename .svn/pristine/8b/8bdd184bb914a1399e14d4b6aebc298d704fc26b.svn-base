package cn.xaut.shop.service.impl;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.PointsRuleDao;
import cn.xaut.shop.pojo.PointsRule;
import cn.xaut.shop.service.PointsRuleService;

public class PointsRuleServiceImpl extends BaseServiceRImpl<PointsRule,Integer> implements PointsRuleService {
	private PointsRuleDao pointsRuleDao = null;
	public void setPointsRuleDao(PointsRuleDao pointsRuleDao) {
		this.pointsRuleDao = pointsRuleDao;
	}
	
	@Override
	public Page<PointsRule> findItem(Page<PointsRule> page,String type, String rule) {
		return pointsRuleDao.findByName(page,type, rule);
	}

	@Override
	public Page<PointsRule> getList(Page<PointsRule> page, String str, String key) {
		return pointsRuleDao.findByKey(page,str, key);
	}

	@Override
	public Page<PointsRule> queryAll(Page<PointsRule> page) {
		return pointsRuleDao.find(page);
	}

	@Override
	public Integer getBytype(String type, String item) {
		List<PointsRule> list=pointsRuleDao.queryByType(type,item);
		if(list!=null&&list.size()>0)
		{
			PointsRule pointsRule=list.get(0);
			return Integer.parseInt(pointsRule.getCount());
		}
		return 0;
	}

}
