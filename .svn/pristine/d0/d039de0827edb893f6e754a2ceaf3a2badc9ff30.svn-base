package cn.xaut.shop.dao.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.DeliverAddrDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.DeliverAddr;
import cn.xaut.shop.pojo.UserInfo;

@Repository
public class DeliverAddrDaoImpl extends HibernateRepository<DeliverAddr,Integer> implements DeliverAddrDao {

	@Override
	public Page<DeliverAddr> getDeliverAddrPage(Page<DeliverAddr> page ,UserInfo user) {
		
		page.setCountTotal(false);
		StringBuffer hqlBuff = new StringBuffer("FROM DeliverAddr d WHERE d.user = ? ORDER BY d.isdefault DESC");
		List<Object> values = new ArrayList<Object>();
		values.add(user);
		
		page = findPage(page, hqlBuff.toString(), values.toArray());
		
		hqlBuff = new StringBuffer("SELECT COUNT(*) FROM DeliverAddr as d where d.user = ?");
		// values = new ArrayList<Object>();
		// values.add("%%");
		
		Long totalCount = super.findUnique(hqlBuff.toString(), values.toArray());
		page.setTotalItems(totalCount);
		
		return page; 
	}


	@Override
	public List<DeliverAddr> getDeliverAddrList(UserInfo user) {
		
		StringBuffer hqlBuff = new StringBuffer("FROM DeliverAddr d WHERE d.user = ?  ORDER BY d.isdefault DESC");
		List<Object> values = new ArrayList<Object>();
		values.add(user);
		
		return find(hqlBuff.toString(), values.toArray());
	}
	
	/**
	 * 获得默认收货地址
	 * @param user
	 * @return
	 */
	private DeliverAddr getDefaultAddr(UserInfo user)
	{
		StringBuffer hqlBuff = new StringBuffer("FROM DeliverAddr d WHERE d.user = ? AND d.isdefault = '1'");
		List<Object> values = new ArrayList<Object>();
		values.add(user);
		
		return findUnique(hqlBuff.toString(), values.toArray());
	}
	
	/**
	 * 更新isdefault字段.使用HQL
	 * @param addr
	 */
	private void updateDefault(DeliverAddr addr)
	{
		StringBuffer hqlBuff = new StringBuffer("update DeliverAddr d set d.isdefault = ? WHERE d.deliveraddrId = ?");
		List<Object> values = new ArrayList<Object>();
		values.add(addr.getIsdefault());System.out.println("default ->" + addr.getIsdefault());
		values.add(addr.getDeliveraddrId());System.out.println(" id ->" + addr.getDeliveraddrId());
		batchExecute(hqlBuff.toString(),values.toArray());
	}
	
	@Override
	public void changeDefaultAddr(DeliverAddr newDefault) {
		
		newDefault.setIsdefault("1");//设为默认
		
		DeliverAddr old = this.getDefaultAddr(newDefault.getUser());
		if(old != null ){
			//进行更新
			old.setIsdefault("0");//设置为非默认
			updateDefault(old);
		}
		updateDefault(newDefault);
	}


	@Override
	public int getUserDeliverCounts(UserInfo user) {
		
		StringBuffer hqlBuff = new StringBuffer("SELECT COUNT(*) FROM DeliverAddr as d where d.user = ?");
		List<Object> values = new ArrayList<Object>();
		values.add(user);
		Long count = findUnique(hqlBuff.toString(), values.toArray());
		return count.intValue();
	}


	@Override
	public void saveDeliverAddr(DeliverAddr addr) {
		
		if(addr.getIsdefault().equals("1")){
			//如果新地址设为默认地址，那么可能改变默认地址
			DeliverAddr oldDefault = this.getDefaultAddr(addr.getUser());
			if(oldDefault != null)
			{
				oldDefault.setIsdefault("0");
				this.update(oldDefault);
			}
		}
		this.save(addr);
	}


	@Override
	public void updateDeliverAddr(DeliverAddr addr) {
		boolean updateFlag = false;
		if(addr.getIsdefault().equals("1")){
			DeliverAddr defaultAddr = getDefaultAddr(addr.getUser());
			if(defaultAddr != null && !defaultAddr.getDeliveraddrId().equals(addr.getDeliveraddrId())){
				//不相等，表示不是同一条记录.要进行默认地址更换
				defaultAddr.setIsdefault("0");
				update(defaultAddr);
			}
			else{
				//相等...//不同实体拥有了相同Id
				super.getSession().merge(addr);
				updateFlag = true;
			}
		}
		if(!updateFlag)
			update(addr);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DeliverAddr> getTop5List(UserInfo user)
	{
		int top = 5;
		
		String hql = "FROM DeliverAddr as d where d.user.userinfoId = " 
				+ user.getUserinfoId() + "  ORDER BY d.isdefault DESC ";
		Query query = super.getSession().createQuery(hql);
		query.setMaxResults(top);//最大获取top条
		return query.list();
	}


	@Override
	public boolean isExisted(DeliverAddr addr) {
		
		if(addr.getDeliveraddrId() != null){
			return false;
		}
		
		List<Object> values = new ArrayList<Object>();
		StringBuffer buffer = new StringBuffer("FROM DeliverAddr as d where 1 = 1 ");
		if(!StringUtils.isEmpty(addr.getAddr())){
			buffer.append(" and addr = ? ");
			values.add(addr.getAddr());
		}
		
		if(!StringUtils.isEmpty(addr.getArea())){
			buffer.append(" and area = ? ");
			values.add(addr.getArea());
		}
		if(!StringUtils.isEmpty(addr.getPhone())){
			buffer.append(" and phone = ? ");
			values.add(addr.getPhone());
		}
		if(!StringUtils.isEmpty(addr.getPostcode())){
			buffer.append(" and postcode = ? ");
			values.add(addr.getPostcode());
		}
		if(!StringUtils.isEmpty(addr.getRecevername())){
			buffer.append(" and recevername = ? ");
			values.add(addr.getRecevername());
		}
		
		if(countHqlResult(buffer.toString(), values.toArray()) > 0){
			return true;
		} else {
			return false;
		}
	}
}
