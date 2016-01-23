package cn.xaut.shop.phoneAction;
import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.Message;

public class MessageActionPhone extends BaseAction<Message>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4786531551436536940L;

	public String getMessage()
	{
		page=messageService.getMessage(page,(Integer)session.get("userid"));
		 if(page!=null&&page.getTotalItems()>0)
		  {
			  request.put("msg", "");
		  }
		  else
		  {
			  request.put("msg", "没有新消息可供查看");
		  }
		request.put("page", page);
		session.put("MessageCount", page.getTotalItems());
		return "list";
   }
	
  public String OpenMessage()
  {
	  String id=ServletActionContext.getRequest().getParameter("messageId");
	  messageService.updateMessage(Integer.parseInt(id));
	  Integer count=messageService.getMessageCount(Integer.parseInt(session.get("userid").toString()));
	  session.put("MessageCount", count);
	  jsonMap.put("data", "right");
	  return "json";
  }
  
  public String getMessageAdmin()
	{
		page=messageService.getMessage(page,0);
		 if(page!=null&&page.getTotalItems()>0)
		  {
			  request.put("msg", "");
		  }
		  else
		  {
			  request.put("msg", "没有新消息可供查看");
		  }
		request.put("page", page);
		return "listAdmin";
 }
	
public String OpenMessageAdmin()
{
	  String id=ServletActionContext.getRequest().getParameter("messageId");
	  messageService.updateMessage(Integer.parseInt(id));
	  Integer count=messageService.getMessageCount(0);
	  session.put("MessageCount", count);
      jsonMap.put("data", "right");
	  return "json";
	  
}

}
