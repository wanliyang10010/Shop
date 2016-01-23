package cn.xaut.shop.dao.impl;
import java.util.ArrayList;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.DisputeDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.Dispute;
public class DisputeDaoImpl extends HibernateRepository<Dispute,Integer>  implements
DisputeDao{
	public DisputeDaoImpl() {
		super();
	}

	@Override
	public Page<Dispute> findByDate(Page<Dispute> page,String start, String end, String state) {
		String sql="";
		switch (state)
		{  
		   case "全部申诉": sql="FROM Dispute a WHERE a.infodate>= ? and a.infodate<= ? order by a.disputeid desc";
		         break;

		   case "已处理":sql="FROM Dispute a WHERE  a.state='1' and a.infodate>= ? and a.infodate<= ? order by a.disputeid desc";
	         break;
			   
		   case "未处理":sql="FROM Dispute a WHERE  a.state='0' and a.infodate>= ? and a.infodate<= ? order by a.disputeid desc";
	         break;

		}
		StringBuffer hqlBuff = new StringBuffer(sql);
		List<Object> values = new ArrayList<Object>();
		values.add(start);
		values.add(end);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<Dispute> findByKey(Page<Dispute> page,String key, String stype) {
		String sql="";
		String key1=key;
		key="%"+key+"%";
		switch (stype)
		{  
		   case "用户名": sql="FROM Dispute a WHERE a.accuser like ? order by a.disputeid desc";
		         break;

		   case "店铺名":sql="FROM Dispute a WHERE a.sccused like ? order by a.disputeid desc";
	         break;
			   
		   case "申诉类别":sql="FROM Dispute a WHERE a.dtype like ? order by a.disputeid desc";
	         break;
			   
		   case "状态":sql="FROM Dispute a WHERE a.state=? order by a.disputeid desc";
		             key=key1;
	         break;
		}
		StringBuffer hqlBuff = new StringBuffer(sql);
		List<Object> values = new ArrayList<Object>();
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public List<Dispute> findByOrder(Integer ordersonid) {
		StringBuffer hqlBuff = new StringBuffer("FROM Dispute a WHERE  a.order.ordersonId=? ");
		List<Object> values = new ArrayList<Object>();
		values.add(ordersonid);
		return find(hqlBuff.toString(),values.toArray());
	}

	@Override
	public List<Dispute> findByUserId(Integer userinfoId) {
		StringBuffer hqlBuff = new StringBuffer("FROM Dispute a WHERE  a.userinfo.userinfoId=? ");
		List<Object> values = new ArrayList<Object>();
		values.add(userinfoId);
		return find(hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<Dispute> queryUncheck(Page<Dispute> page) {
		StringBuffer hqlBuff = new StringBuffer("FROM Dispute a WHERE  a.state='0' order by a.disputeid desc");
		List<Object> values = new ArrayList<Object>();
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<Dispute> queryAll(Page<Dispute> page) {
		// TODO Auto-generated method stub
		StringBuffer hqlBuff = new StringBuffer("FROM Dispute a order by a.disputeid desc");
		List<Object> values = new ArrayList<Object>();
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	

} 
