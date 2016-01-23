package cn.xaut.shop.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.ShopApplyDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.ShopApply;
import cn.xaut.shop.pojo.UserInfo;

public class ShopApplyDaoImpl extends HibernateRepository<ShopApply, Integer>
		implements ShopApplyDao {

	public ShopApplyDaoImpl() {
		super();
	}
	
	public boolean isApply(int userid){
		String sql = "";
		sql = "FROM ShopApply a WHERE a.userinfo = '" + userid+"'";
		return find(sql).isEmpty()?false:true;//不空证明申请过店铺
	}
	
	public ShopApply getCheckShopName(ShopApply shopApply) {

		StringBuffer hqlBuff = new StringBuffer(
				"select a from ShopApply as a where a.shopname =?");
		List<Object> values = new ArrayList<Object>();
		values.add(shopApply.getShopname());

		List<ShopApply> list = find(hqlBuff.toString(), values.toArray());
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
/*	public Page<ShopApply> getAllCheckList(Page<ShopApply> page,String fromdate, String todate) {

		StringBuffer hqlBuff = new StringBuffer(
				"select a from ShopApply as a where a.applyTime between  ? and  ? and a.state='0' order by a.applyTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(fromdate);
		values.add(todate);
        Page<ShopApply> p=findPage(page, hqlBuff.toString(), values.toArray());
		return p;
	}*/
	public Page<ShopApply> getAllCheckList(Page<ShopApply> page,String fromdate, String todate,int id) {

		StringBuffer hqlBuff = new StringBuffer(
				"select a from ShopApply as a where a.applyTime between  ? and  ? and a.state='0' order by a.applyTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(fromdate);
		values.add(addOneday(todate));
        Page<ShopApply> p=findPage(page,id, hqlBuff.toString(), values.toArray());
		return p;
	}
	
	
	@Override
	public Page<ShopApply> getAllCheckListNoDate(Page<ShopApply> page, int id) {
		StringBuffer hqlBuff = new StringBuffer(
				"select a from ShopApply as a where  a.state='0'");
		List<Object> values = new ArrayList<Object>();
		
        Page<ShopApply> p=findPage(page,id, hqlBuff.toString(), values.toArray());
		return p;
	}

	public List<ShopApply> getMyAlterList(int userid, String fromdate,
			String todate, String state) {
		String sql = "";
		sql = "FROM ShopApply a WHERE a.applyTime between " + "'" + fromdate
				+ "'" + " and " + "'" + addOneday(todate) + "'" + " and a.state = '"
				+ state + "' and a.userinfo = '" + userid
				+ "' order by a.applyTime desc";
		return find(sql);
	}

	public List<ShopApply> getMyViewList(int userid, String fromdate,
			String todate) {
		String sql = "";
		sql = "FROM ShopApply a WHERE a.applyTime between " + "'" + fromdate
				+ "'" + " and " + "'" + todate + "'" + " and (a.userinfo = '"
				+ userid + "' or a.checkuserinfo =  '" + userid
				+ "') order by a.applyTime desc";
		return find(sql);
	}
	
	public Page<ShopApply> getMyViewList(Page<ShopApply> page,String fromdate, String todate,UserInfo user,int id) {

		StringBuffer hqlBuff = new StringBuffer(
				"select a from ShopApply as a where a.applyTime between  ? and  ? " +
				" and (a.userinfo = ? or a.checkuserinfo = ?) " +
				"order by a.applyTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(fromdate);
		values.add(addOneday(todate));
		values.add(user);
		values.add(user);
        Page<ShopApply> p=findPage(page,id,hqlBuff.toString(), values.toArray());
		return p;
	}
	@Override
	public List<ShopApply> getMyViewListNoDate(int userid) {
		String sql = "";
		sql = "FROM ShopApply a WHERE (a.userinfo = '"
				+ userid + "' or a.checkuserinfo =  '" + userid
				+ "')";
		return find(sql);
	}
	
	public static String addOneday(String today){   
        SimpleDateFormat f =  new SimpleDateFormat("yyyy-MM-dd");   
        try   {   
            Date  d  =  new Date(f.parse(today).getTime()+24*3600*1000);     
              return  f.format(d);   
        }   
        catch(Exception ex) {   
            return   "输入格式错误";     
        }   
    }
	
	
}
