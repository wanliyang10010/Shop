package cn.xaut.shop.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.common.paging.domain.PageRequest;
import cn.xaut.shop.dao.ProlongApplyDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.ProlongApply;

@SuppressWarnings("unchecked")
public class ProlongApplyDaoImpl extends HibernateRepository<ProlongApply, Integer>
		implements ProlongApplyDao {
	
	public ProlongApplyDaoImpl() {
		super();
	}

	public List<ProlongApply> getMyCheckList(int shopId,String fromdate, String todate,
			String state) {
		String sql = "";
		sql = "FROM ProlongApply a WHERE a.applyTime between '"+fromdate+"' and '"+ addOneday(todate) +"' and a.state = '"+state+"' and a.shop = '" 
				+shopId+"' order by a.applyTime desc";
		return find(sql);		
	}
	public List<ProlongApply> getMyAlterList(int userid,String fromdate,String todate,String state) {
		String sql = "";
		sql = "FROM ProlongApply a WHERE a.applyTime between '"+fromdate+"' and '"+ addOneday(todate) +"' and a.state = '"+state+"' and a.userinfo = '" 
				+userid+"' order by a.applyTime desc";		
		return find(sql);		
	}
	
	public List<ProlongApply> getMyViewList(int userid,String fromdate, String todate) {
		String sql = "";		
		sql = "FROM ProlongApply a WHERE a.applyTime between '"+fromdate+"' and '"+ addOneday(todate) +"' and a.userinfo ='" +userid+"' order by a.applyTime desc";
		return find(sql);		
	}
	public List<ProlongApply> getMyViewListSell(int shopId,String fromdate, String todate) {
		String sql = "";		
		sql = "FROM ProlongApply a WHERE a.applyTime between '"+fromdate+"' and '"+ addOneday(todate) +"' and  a.shop=  '" +shopId+"'  order by a.applyTime desc";
		return find(sql);		
	}
	
		public Page<ProlongApply> getMyCheckList(Page<ProlongApply> page,int shopId,String fromdate, String todate,String state,int id) {
			StringBuffer hqlBuff = new StringBuffer(
					"select a from ProlongApply as a where a.applyTime between  ? and  ? " +
					" and a.shop.shopId = ? and a.state = ? order by a.applyTime desc");
			List<Object> values = new ArrayList<Object>();
			values.add(fromdate);
			values.add(addOneday(todate));
			values.add(shopId);
			values.add(state);

	        Page<ProlongApply> p=findPage(page,id,hqlBuff.toString(), values.toArray());
			return p;
		}
		public Page<ProlongApply> getMyAlterList(Page<ProlongApply> page,int userid,String fromdate, String todate,String state,int id) {
			StringBuffer hqlBuff = new StringBuffer(
					"select a from ProlongApply as a where a.applyTime between  ? and  ? " +
					" and a.userinfo.userinfoId = ? and a.state = ? order by a.applyTime desc");
			List<Object> values = new ArrayList<Object>();
			values.add(fromdate);
			values.add(addOneday(todate));
			values.add(userid);
			values.add(state);

	        Page<ProlongApply> p=findPage(page,id,hqlBuff.toString(), values.toArray());
			return p;
		}
		public Page<ProlongApply> getMyViewList(Page<ProlongApply> page,int userid,String fromdate, String todate,int id) {
			StringBuffer hqlBuff = new StringBuffer(
					"select a from ProlongApply as a where a.applyTime between  ? and  ? " +
					" and a.userinfo.userinfoId = ?  order by a.applyTime desc");
			List<Object> values = new ArrayList<Object>();
			values.add(fromdate);
			values.add(addOneday(todate));
			values.add(userid);

	        Page<ProlongApply> p=findPage(page,id,hqlBuff.toString(), values.toArray());
			return p;
		}
		public Page<ProlongApply> getMyViewListSell(Page<ProlongApply> page,int shopId,String fromdate, String todate,int id) {
			StringBuffer hqlBuff = new StringBuffer(
					"select a from ProlongApply as a where a.applyTime between  ? and  ? " +
					" and a.shop.shopId= ?  order by a.applyTime desc");
			List<Object> values = new ArrayList<Object>();
			values.add(fromdate);
			values.add(addOneday(todate));
			values.add(shopId);

	        Page<ProlongApply> p=findPage(page,id,hqlBuff.toString(), values.toArray());
			return p;
		}
	

	@Override
	public Page<ProlongApply> getMyCheckListPhone(PageRequest pageRequest,
			int shopId, String state) {
		
		StringBuffer hqlBuff = new StringBuffer("select u from ProlongApply as u where u.state = ? and u.shop.shopId = ? order by u.applyTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(state);
		values.add(shopId);
		Page<ProlongApply> page  = findPage(pageRequest, hqlBuff.toString(), values.toArray());		
		
		return page;
	}

	@Override
	public Page<ProlongApply> getMyAlterListPhone(PageRequest pageRequest,
			int id, String state) {
		StringBuffer hqlBuff = new StringBuffer("select u from ProlongApply as u where u.state = ? and u.userinfo.userinfoId = ? order by u.applyTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(state);
		values.add(id);
		Page<ProlongApply> page  = findPage(pageRequest, hqlBuff.toString(), values.toArray());		
		
		return page;
	}

	@Override
	public Page<ProlongApply> getMyViewListPhone(PageRequest pageRequest,
			int id) {
		StringBuffer hqlBuff = new StringBuffer("select u from ProlongApply as u where u.userinfo.userinfoId = ? or u.checkuserinfo.userinfoId = ? order by u.applyTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(id);
		values.add(id);
		Page<ProlongApply> page  = findPage(pageRequest, hqlBuff.toString(), values.toArray());		
		
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
