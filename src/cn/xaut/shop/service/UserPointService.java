package cn.xaut.shop.service;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.ReturnGoods;
import cn.xaut.shop.pojo.UserPoint;
public interface UserPointService extends BaseServiceR<UserPoint,Integer>{
	public List<UserPoint> getListByUserId(int userid);
	public Page<UserPoint>  getListByUserId(Page<UserPoint> page,int userid);
}

