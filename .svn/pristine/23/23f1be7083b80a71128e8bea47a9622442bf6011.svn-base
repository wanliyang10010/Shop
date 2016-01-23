package cn.xaut.shop.dao.impl;
import java.util.ArrayList;
import java.util.List;

import cn.xaut.shop.dao.DiscountDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.Discount;
public class DiscountDaoImpl extends HibernateRepository<Discount,Integer>  implements
DiscountDao{
	public DiscountDaoImpl() {
		super();
	}
	@Override
	public List<Discount> findByGoodsId(Integer sid) {
		StringBuffer hqlBuff = new StringBuffer("FROM Discount a WHERE a.state='0' and a.goods.goodsid=?");
		List<Object> values = new ArrayList<Object>();
		values.add(sid);
		return find(hqlBuff.toString(),values.toArray());
	}

	@Override
	public List<Discount> findByDate(String date) {
		StringBuffer hqlBuff = new StringBuffer("FROM Discount a WHERE a.state='0'and a.startday<=? and a.endday>=?");
		List<Object> values = new ArrayList<Object>();
		values.add(date);
		values.add(date);
		return find(hqlBuff.toString(),values.toArray());
	}
}
