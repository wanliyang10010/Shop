package cn.xaut.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.Assert;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.OrderDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;

public class OrderDaoImpl extends HibernateRepository<Order, Integer> implements
		OrderDao {

	@Override
	public Page<Order> queryHistoryOrderByUser(Page<Order> page, UserInfo user) {
		// TODO Auto-generated method stub

		// pageRequest.setCountTotal(false);
		StringBuffer hqlBuff = new StringBuffer(
				"select o from Order as o where o.user = ?");
		List<Object> values = new ArrayList<Object>();
		values.add(user);

		page = findPage(page, hqlBuff.toString(), values.toArray());

		// hqlBuff = new
		// StringBuffer("select count(*) from UserInfo as u where u.username like ?");
		// values = new ArrayList<Object>();
		// values.add("%%");
		// Long totalCount = super.findUnique(hqlBuff.toString(),
		// values.toArray());
		// page.setTotalItems(totalCount);

		return page;
	}

	@Override
	public Page<Order> getOrderList(Page<Order> page, String fromdate,
			String todate, UserInfo user) {

		// pageRequest.setCountTotal(false);
		StringBuffer hqlBuff = new StringBuffer(
				"select o from Order as o WHERE o.user = ? and  o.statemark!='10' and  o.statemark!='11'  order by o.orderid desc");
		List<Object> values = new ArrayList<Object>();
		values.add(user);

		if (fromdate != null && fromdate.length() > 0) {
			hqlBuff.append(" And buytime > ? ");
			values.add(fromdate);
		}
		if (todate != null && todate.length() > 0) {
			hqlBuff.append(" And buytime < ? ");
			values.add(todate);
		}

		page = findPage(page, hqlBuff.toString(), values.toArray());

		// hqlBuff = new
		// StringBuffer("select count(*) from UserInfo as u where u.username like ?");
		// values = new ArrayList<Object>();
		// values.add("%%");
		// Long totalCount = super.findUnique(hqlBuff.toString(),
		// values.toArray());
		// page.setTotalItems(totalCount);

		return page;

	}

	@Override
	public Page<Order> getOrderList(Page<Order> page, String fromdate,
			String todate, Shop shop) {

		// pageRequest.setCountTotal(false);
		StringBuffer hqlBuff = new StringBuffer(
				"select o from Order as o WHERE o.shop = ? and o.statemark!='01' and  o.statemark!='11' order by o.orderid desc");
		List<Object> values = new ArrayList<Object>();
		values.add(shop);
		if (fromdate != null && fromdate.length() > 0) {
			hqlBuff.append(" And buytime > ? ");
			values.add(fromdate);
		}
		if (todate != null && todate.length() > 0) {
			hqlBuff.append(" And buytime < ? ");
			values.add(todate);
		}
		page = findPage(page, hqlBuff.toString(), values.toArray());
       
		// hqlBuff = new
		// StringBuffer("select count(*) from UserInfo as u where u.username like ?");
		// values = new ArrayList<Object>();
		// values.add("%%");
		// Long totalCount = super.findUnique(hqlBuff.toString(),
		// values.toArray());
		// page.setTotalItems(totalCount);

		return page;

	}

	@Override
	public void saveOrderList(List<Order> orderlist) {
		// TODO Auto-generated method stub
		Assert.notNull(orderlist, "orderlist不能为空");
		for (Order order : orderlist) {
			save(order);
		}
	}

	@Override
	public List<Order> getSaleList(Integer shopid, String fromdate,
			String todate) {
		
		StringBuffer hqlBuff = new StringBuffer(
				"select o from Order as o WHERE o.shop.shopId = ? and o.state in(4,40,41,42,43)");
		List<Object> values = new ArrayList<Object>();
		values.add(shopid);
		if (fromdate != null && fromdate.length() > 0) {
			hqlBuff.append(" And o.buytime > ? ");
			values.add(java.sql.Timestamp.valueOf(fromdate+" 00:00:00"));
		}
		if (todate != null && todate.length() > 0) {
			hqlBuff.append(" And o.buytime < ? ");
			values.add(java.sql.Timestamp.valueOf(todate+" 23:59:59"));
		}
		hqlBuff.append(" order by o.orderid desc ");
		System.out.println("zzzzzz"+hqlBuff.toString());
		return  find(hqlBuff.toString(), values.toArray());
	}

	@Override
	public Page<Order> getSalePage(Page<Order> page, Integer shopid,
			String fromdate, String todate) {
		StringBuffer hqlBuff = new StringBuffer(
				"select o from Order as o WHERE o.shop.shopId = ? and o.state in(4,40,41,42,43)");
		List<Object> values = new ArrayList<Object>();
		values.add(shopid);
		if (fromdate != null && fromdate.length() > 0) {
			hqlBuff.append(" And o.buytime > ? ");
			values.add(java.sql.Timestamp.valueOf(fromdate+" 00:00:00"));
		}
		if (todate != null && todate.length() > 0) {
			hqlBuff.append(" And o.buytime < ? ");
			values.add(java.sql.Timestamp.valueOf(todate+" 23:59:59"));
		}
		hqlBuff.append(" order by o.orderid desc ");
		return findPage(page, hqlBuff.toString(), values.toArray());
	}

	@Override
	public Order getOrder(int id) {
		StringBuffer hqlBuff = new StringBuffer(
				"select o from Order as o WHERE o.orderid = ?");
		List<Object> values = new ArrayList<Object>();
		values.add(id);
		return  findUnique(hqlBuff.toString(), values.toArray());
	}

	@Override
	public List<Order> getSaleList(String userinfoId) {
		StringBuffer hqlBuff = new StringBuffer(
				"select o from Order as o WHERE o.user.userinfoId = ? order by o.orderid desc");
		List<Object> values = new ArrayList<Object>();
		values.add(Integer.parseInt(userinfoId));
		return  find(hqlBuff.toString(), values.toArray());
	}
	
}
