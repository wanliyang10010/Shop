package cn.xaut.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.StageOrderDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.StageOrder;

public class StageOrderDaoImpl extends  HibernateRepository<StageOrder,Integer> implements
StageOrderDao{
	public StageOrderDaoImpl() {
		super();
	}

	@Override
	public Page<StageOrder> getSalePage(Page<StageOrder> page,Integer userid, String fromdate,
			String todate) {
		StringBuffer hqlBuff = new StringBuffer(
				"select o from StageOrder as o WHERE o.user.userinfoId=?");
		List<Object> values = new ArrayList<Object>();
		values.add(userid);
		if (fromdate != null && fromdate.length() > 0) {
			hqlBuff.append("and  o.buytime >= ?");
			values.add(java.sql.Timestamp.valueOf(fromdate+" 00:00:00"));
		}
		if (todate != null && todate.length() > 0) {
			hqlBuff.append("and o.buytime <=?");
			values.add(java.sql.Timestamp.valueOf(todate+" 23:59:59"));
		}
		hqlBuff.append("order by o.buytime desc");
		return findPage(page, hqlBuff.toString(), values.toArray());
	}

	@Override
	public Page<StageOrder> getAdminPage(Page<StageOrder> page, String stype,
			String fromdate, String todate) {
		StringBuffer hqlBuff=null;
		if(stype.equals("全部订单"))
		{
			hqlBuff = new StringBuffer(
					"select o from StageOrder as o WHERE o.remark like '%%'");
		} 
		else if(stype.equals("已发货"))
		{
			hqlBuff = new StringBuffer(
					"select o from StageOrder as o WHERE o.remark = '已发货'");
		}
		else if(stype.equals("未发货"))
		{
			hqlBuff = new StringBuffer(
					"select o from StageOrder as o WHERE o.remark = '已提交'");
		}
		List<Object> values = new ArrayList<Object>();
		System.out.println("开始"+fromdate+"结束"+todate);
		if (fromdate != null && fromdate.length() > 0) {
			hqlBuff.append("and  o.buytime > ?");
			values.add(java.sql.Timestamp.valueOf(fromdate+" 00:00:00"));
		}
		if (todate != null && todate.length() > 0) {
			hqlBuff.append("and o.buytime < ?");
			values.add(java.sql.Timestamp.valueOf(todate+" 23:59:59"));
		}
		hqlBuff.append("order by o.buytime desc");
		return findPage(page, hqlBuff.toString(), values.toArray());
	}

	@Override
	public List<StageOrder> getOrderCount(String sgoodsId) {
		StringBuffer hqlBuff = new StringBuffer(
				"select o from StageOrder as o WHERE o.stagegoods.sgoodsId=? order by o.stageorderId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(Integer.parseInt(sgoodsId));
		return find(hqlBuff.toString(), values.toArray());
	}

	@Override
	public List<StageOrder> getOrderCheck(String sgoodsId, Integer userinfoId) {
		// TODO Auto-generated method stub
		StringBuffer hqlBuff = new StringBuffer(
				"select o from StageOrder as o WHERE o.stagegoods.sgoodsId=? and o.user.userinfoId=? order by o.stageorderId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(Integer.parseInt(sgoodsId));
		values.add(userinfoId);
		return find(hqlBuff.toString(), values.toArray());
	}
}
