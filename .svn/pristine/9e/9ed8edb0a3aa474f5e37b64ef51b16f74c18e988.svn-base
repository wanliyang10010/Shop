package cn.xaut.shop.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.MessageDao;
import cn.xaut.shop.pojo.Message;
import cn.xaut.shop.service.MessageService;

@Service
@Transactional
public class MessageServiceImpl extends BaseServiceRImpl<Message,Integer> implements
MessageService {
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private MessageDao messageDao = null;
	@Autowired
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	
	@Override
	public void updateMessage(Integer id) {
		Message message=messageDao.findById(id);
		message.setState("1");
		messageDao.update(message);
	}
	@Override
	public Page<Message> getMessage(Page<Message> page, Integer UserId) {
		return messageDao.findByRecevier(page,UserId);
	}
	@Override
	public Integer getMessageCount(Integer UserId) {
		List<Message> list=messageDao.findCount(UserId);
		if(list!=null&&list.size()>0)
		{
			return list.size();
		}
		else
		{
			return 0;
		}
	}
	//messageService 引用action中的messageService（照抄）
	//text 消息提醒显示的内容
	//sender  发送人ID
	//receiver  接收人ID(发送给管理的消息，这个字段暂时写为0，其他为接收人ID)；
	//url  跳转的地址(可以是action和jsp)
	//跳转页面需要id参数的配置一下两个字段(只可以传递一个主业务的参数)
	//idtype id参数名  为url？后跟的参数名
	//idvalue  id参数值 
	@Override
	public void sendMessage(MessageService messageService,String text, Integer sender, Integer receiver,
			String url, String idtype, Integer idvalue) {
		Message message=new Message();
		message.setText(text);
		message.setSender(sender);
		message.setReceiver(receiver);
		message.setUrl(url);
		message.setIdtype(idtype);
		message.setIdvalue(idvalue);
		message.setState("0");
		messageService.save(message);
		System.out.println(message.getMessageId()+message.getText());
	}

	@Override
	public List<Message> getList(Integer UserId) {
		// TODO Auto-generated method stub
		return messageDao.findCount(UserId);
		
	}
}
