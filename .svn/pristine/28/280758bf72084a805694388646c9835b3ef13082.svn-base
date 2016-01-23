package cn.xaut.shop.dao;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.UserPoint;

public interface UserPointDao extends CrudRepository<UserPoint,Integer> {	

	public List<UserPoint> getListByUserId(int userid);
	public Page<UserPoint>  getListByUserId(Page<UserPoint> page,int userid);
}
