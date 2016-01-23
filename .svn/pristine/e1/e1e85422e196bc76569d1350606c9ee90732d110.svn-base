package cn.xaut.shop.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.ExpressDao;
import cn.xaut.shop.pojo.Express;
import cn.xaut.shop.service.ExpressService;

@Service
@Transactional
public class ExpressServiceImpl extends BaseServiceRImpl<Express,Integer> implements ExpressService {

	private ExpressDao expressDao = null;
	public void setExpressDao(ExpressDao expressDao) {
		this.expressDao = expressDao;
	}
	

	public Page<Express>  getViewList(Page<Express> page,String fromdate,String todate)
	{
		return expressDao.getViewList(page,fromdate,todate);
	}
	public Page<Express>  getAlterList(Page<Express> page,int userid,String fromdate,String todate)
	{
		return expressDao.getAlterList(page,userid,fromdate,todate);
	}
}
