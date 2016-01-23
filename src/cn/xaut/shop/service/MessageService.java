package cn.xaut.shop.service;

import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.Message;
public interface MessageService extends BaseServiceR<Message,Integer>{
	Page<Message>  getMessage(Page<Message> page,Integer UserId);
	void sendMessage(MessageService messageService,String text,Integer sender,Integer receiver,String url,String idtype,Integer idvalue);
	void updateMessage(Integer id);
	Integer  getMessageCount(Integer UserId);
	List<Message> getList(Integer UserId);
}
