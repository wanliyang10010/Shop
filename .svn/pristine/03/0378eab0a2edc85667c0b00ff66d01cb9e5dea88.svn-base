package cn.xaut.shop.dao;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.MarginDetail;

public interface MarginDetailDao extends CrudRepository<MarginDetail,Integer> {	
	public List<MarginDetail>  getListByShopid(int shopid);
	public Page<MarginDetail>  findByShopid(Page<MarginDetail> page,int shopid);
}
