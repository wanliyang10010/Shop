package cn.xaut.shop.dao.impl;
import java.util.ArrayList;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.MessageDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.Message;

public class MessageDaoImpl extends  HibernateRepository<Message,Integer> implements
MessageDao{
	public MessageDaoImpl() {
		super();
	}

	@Override
	public Page<Message> findByRecevier(Page<Message> page, Integer userId) {
		StringBuffer hqlBuff = new StringBuffer("FROM Message a WHERE a.state='0' and  a.receiver=? order by a.messageId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(userId);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public List<Message> findCount(Integer userId) {
		StringBuffer hqlBuff = new StringBuffer("FROM Message a WHERE a.state='0' and a.receiver=?");
		List<Object> values = new ArrayList<Object>();
		values.add(userId);
		return find(hqlBuff.toString(),values.toArray());
	}

}
