package cn.xaut.shop.action;

import java.util.Iterator;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.xaut.common.security.service.UserSecurityService;
import cn.xaut.shop.pojo.Message;
import cn.xaut.shop.pojo.Role;
import cn.xaut.shop.pojo.UserInfo;

public class MessageAction extends BaseAction<Message> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4786531551436536940L;
	private UserSecurityService userSecurityService;

	public String getMessage() {
		page = messageService.getMessage(page, (Integer) session.get("userid"));
		if (page != null && page.getTotalItems() > 0) {
			request.put("msg", "");
		} else {
			request.put("msg", "没有新消息可供查看");
		}
		request.put("page", page);
		session.put("MessageCount", page.getTotalItems());
		return "list";
	}

	public String OpenMessage() {
		String id = ServletActionContext.getRequest().getParameter("messageId");
		messageService.updateMessage(Integer.parseInt(id));
		Integer count = messageService.getMessageCount(Integer.parseInt(session
				.get("userid").toString()));
		session.put("MessageCount", count);
		jsonMap.put("data", "right");
		return "json";
	}

	public String getMessageCountShop() {
		if (session.get("userid") != null) {
				Integer count = messageService.getMessageCount(Integer
						.parseInt(session.get("userid").toString()));
				session.put("MessageCount", count);
				System.out.println("消息数：" + count);
				jsonMap.put("data", "right");
		} else {
			jsonMap.put("data", "right");
		}
		return "json";
	}

	public String getMessageCount() {
		String id = ServletActionContext.getRequest().getParameter("id");
		if (id.equals("0")) {
			Integer count = messageService.getMessageCount(0);
			session.put("MessageCount", count);
			System.out.println("消息数：" + count);
		} else {
				if (session.get("userid") != null&&session.get("role")!=null) {
					    if(!session.get("role").toString().equals("ROLE_User"))
					    {
					    	jsonMap.put("data", "wrong");
					    }else{
						Integer count = messageService.getMessageCount(Integer
								.parseInt(session.get("userid").toString()));
						session.put("MessageCount", count);
						System.out.println("消息数：" + count);	
					    }
			   }
		}
		return "json";
	}

	public String updateAll()
	{
		List<Message> list= messageService.getList((Integer) session.get("userid"));
		if(list!=null&&list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				Message msg=list.get(i);
				messageService.updateMessage(msg.getMessageId());
			}
		}
		jsonMap.put("data", "right");
		return "json";
	}
	
	public String updateAllAdmin()
	{
		List<Message> list= messageService.getList(0);
		if(list!=null&&list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				Message msg=list.get(i);
				messageService.updateMessage(msg.getMessageId());
			}
		}
		jsonMap.put("data", "right");
		return "json";
	}
	
	public String getMessageAdmin() {
		page = messageService.getMessage(page, 0);
		if (page != null && page.getTotalItems() > 0) {
			request.put("msg", "");
		} else {
			request.put("msg", "没有新消息可供查看");
		}
		request.put("page", page);
		session.put("MessageCount", page.getTotalItems());
		return "listAdmin";
	}

	public String OpenMessageAdmin() {
		String id = ServletActionContext.getRequest().getParameter("messageId");
		messageService.updateMessage(Integer.parseInt(id));
		Integer count = messageService.getMessageCount(0);
		session.put("MessageCount", count);
		jsonMap.put("data", "right");
		return "json";

	}

}
