package cn.xaut.shop.dao;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.modules.repository.CrudRepository;
import cn.xaut.shop.pojo.Message;
public interface MessageDao extends CrudRepository<Message, Integer>{
	Page<Message> findByRecevier(Page<Message> page, Integer userId);

	List<Message> findCount(Integer userId);
}
