package cn.xaut.shop.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.common.paging.domain.PageRequest;
import cn.xaut.shop.dao.ReturnGoodsDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.ProlongApply;
import cn.xaut.shop.pojo.ReturnGoods;

public class ReturnGoodsDaoImpl extends HibernateRepository<ReturnGoods, Integer>
		implements ReturnGoodsDao {

	public ReturnGoodsDaoImpl() {
		super();
	}
	public List<ReturnGoods> getMyCheckList(int shopId,String fromdate, String todate,
			String state) {
		String sql = "";
		sql = "FROM ReturnGoods a WHERE a.applyTime between " + "'"+fromdate+"'"+
				" and " +"'"+ addOneday(todate) +"'"+ " and a.state = '"+state+"' and a.shop = '" 
						+shopId+"' order by a.applyTime desc";
		return find(sql);
	}
	public List<ReturnGoods> getMyAlterList(int userid,String fromdate, String todate,
			String state) {
		String sql = "";
		sql = "FROM ReturnGoods a WHERE a.applyTime between " + "'"+fromdate+"'"+
				" and " +"'"+ addOneday(todate) +"'"+ " and a.state = '"+state+"' and a.userinfo = '" 
				+userid+"' order by a.applyTime desc";
		return find(sql);
	}
	public List<ReturnGoods> getMyConfirmList(int userid,String fromdate, String todate,
			String state) {
		String sql = "";
		sql = "FROM ReturnGoods a WHERE a.applyTime between " + "'"+fromdate+"'"+
				" and " +"'"+ addOneday(todate) +"'"+ " and a.state = '"+state+"' and a.checkuserinfo = '" 
				+userid+"' order by a.applyTime desc";
		return find(sql);
	}
	public List<ReturnGoods> getMyViewList(int userid,String fromdate, String todate) {
		String sql = "";
		sql = "FROM ReturnGoods a WHERE a.applyTime between " + "'"+fromdate+"'"+
				" and " +"'"+ addOneday(todate) +"'"+ " and a.userinfo = '" +userid+"' order by a.applyTime desc";
		return find(sql);
	}
	public List<ReturnGoods> getMyViewListSell(int shopId,String fromdate, String todate) {
		String sql = "";
		sql = "FROM ReturnGoods a WHERE a.applyTime between " + "'"+fromdate+"'"+
				" and " +"'"+ addOneday(todate) +"'"+ " and a.shop=  '" +shopId+"' order by a.applyTime desc";
		return find(sql);
	}
	
	public Page<ReturnGoods> getMyCheckList(Page<ReturnGoods> page,int shopId,String fromdate, String todate,String state,int id) {
		StringBuffer hqlBuff = new StringBuffer(
				"select a from ReturnGoods as a where a.applyTime between  ? and  ? " +
				" and a.shop.shopId = ? and a.state = ? order by a.applyTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(fromdate);
		values.add(addOneday(todate));
		values.add(shopId);
		values.add(state);

        Page<ReturnGoods> p=findPage(page,id,hqlBuff.toString(), values.toArray());
		return p;
	}
	public Page<ReturnGoods> getMyAlterList(Page<ReturnGoods> page,int userid,String fromdate, String todate,String state,int id) {
		StringBuffer hqlBuff = new StringBuffer(
				"select a from ReturnGoods as a where a.applyTime between  ? and  ? " +
				" and a.userinfo.userinfoId = ? and a.state = ? order by a.applyTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(fromdate);
		values.add(addOneday(todate));
		values.add(userid);
		values.add(state);

        Page<ReturnGoods> p=findPage(page,id,hqlBuff.toString(), values.toArray());
		return p;
	}
	public Page<ReturnGoods> getMyConfirmList(Page<ReturnGoods> page,int userid,String fromdate, String todate,String state,int id) {
		StringBuffer hqlBuff = new StringBuffer(
				"select a from ReturnGoods as a where a.applyTime between  ? and  ? " +
				" and a.checkuserinfo.userinfoId = ? and a.state = ? order by a.applyTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(fromdate);
		values.add(addOneday(todate));
		values.add(userid);
		values.add(state);

        Page<ReturnGoods> p=findPage(page,id,hqlBuff.toString(), values.toArray());
		return p;
	}
	
	public Page<ReturnGoods> getMyViewList(Page<ReturnGoods> page,int userid,String fromdate, String todate,int id) {
		StringBuffer hqlBuff = new StringBuffer(
				"select a from ReturnGoods as a where a.applyTime between  ? and  ? " +
				" and a.userinfo.userinfoId = ?  order by a.applyTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(fromdate);
		values.add(addOneday(todate));
		values.add(userid);
        Page<ReturnGoods> p=findPage(page,id,hqlBuff.toString(), values.toArray());
		return p;
	}
	public Page<ReturnGoods> getMyViewListSell(Page<ReturnGoods> page,int shopId,String fromdate, String todate,int id) {
		StringBuffer hqlBuff = new StringBuffer(
				"select a from ReturnGoods as a where a.applyTime between  ? and  ? " +
				" and a.shop.shopId= ?  order by a.applyTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(fromdate);
		values.add(addOneday(todate));
		values.add(shopId);
        Page<ReturnGoods> p=findPage(page,id,hqlBuff.toString(), values.toArray());
		return p;
	}
	
	
	@Override
	public Page<ReturnGoods> getMyCheckListPhone(PageRequest pageRequest,
			int shopId, String state) {
		StringBuffer hqlBuff = new StringBuffer("select u from ReturnGoods as u where u.state = ? and u.shop = ? order by u.applyTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(state);
		values.add(shopId);
		Page<ReturnGoods> page  = findPage(pageRequest, hqlBuff.toString(), values.toArray());		
		
		return page;
	}
	@Override
	public Page<ReturnGoods> getMyAlterListPhone(PageRequest pageRequest,
			int id, String state) {
		StringBuffer hqlBuff = new StringBuffer("select u from ReturnGoods as u where u.state = ? and u.userinfo = ? order by u.applyTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(state);
		values.add(id);
		Page<ReturnGoods> page  = findPage(pageRequest, hqlBuff.toString(), values.toArray());		
		
		return page;
	}
	@Override
	public Page<ReturnGoods> getMyConfirmListPhone(PageRequest pageRequest,
			int id, String state) {
		StringBuffer hqlBuff = new StringBuffer("select u from ReturnGoods as u where u.state = ? and u.userinfo = ? order by u.applyTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(state);
		values.add(id);
		Page<ReturnGoods> page  = findPage(pageRequest, hqlBuff.toString(), values.toArray());		
		
		return page;
	}
	@Override
	public Page<ReturnGoods> getMyViewListPhone(PageRequest pageRequest, int id) {
		StringBuffer hqlBuff = new StringBuffer("select u from ReturnGoods as u where  u where u.userinfo = ? or a.checkuserinfo= ? order by u.applyTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(id);
		values.add(id);
		Page<ReturnGoods> page  = findPage(pageRequest, hqlBuff.toString(), values.toArray());		
		
		return page;
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
