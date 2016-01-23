package cn.xaut.shop.dao;
import java.util.List;

import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.Discount;
public interface DiscountDao extends CrudRepository<Discount, Integer>{
	public List<Discount> findByGoodsId(Integer gid);
	public List<Discount> findByDate(String date);
}
