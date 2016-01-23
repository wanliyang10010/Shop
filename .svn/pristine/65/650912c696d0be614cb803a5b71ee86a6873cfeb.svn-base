package cn.xaut.shop.dao;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.Dispute;
public interface DisputeDao extends CrudRepository<Dispute, Integer>{
	public Page<Dispute> findByDate(Page<Dispute> page, String start, String end, String state);
	public Page<Dispute> findByKey(Page<Dispute> page, String key, String stype);
	public List<Dispute> findByOrder(Integer ordersonid);
	
	public List<Dispute> findByUserId(Integer userinfoId);
	public Page<Dispute> queryUncheck(Page<Dispute> page);
	public Page<Dispute> queryAll(Page<Dispute> page);
}
