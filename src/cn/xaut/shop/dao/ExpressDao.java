package cn.xaut.shop.dao;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.Express;

public interface ExpressDao extends CrudRepository<Express,Integer> {	
	public Page<Express> getViewList(Page<Express> page,String fromdate, String todate);
	public Page<Express> getAlterList(Page<Express> page,int userid,String fromdate, String todate);
}
