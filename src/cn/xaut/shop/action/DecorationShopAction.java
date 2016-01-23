package cn.xaut.shop.action;

import java.io.PrintWriter;
import org.apache.struts2.ServletActionContext;
import net.sf.json.JSONObject;
import cn.xaut.shop.pojo.DateRule;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.util.DecorationFactory;


public class DecorationShopAction extends BaseAction<DateRule> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1081855991935332217L;
	@Override
	public DateRule getModel() {
		return null;
	}

	public String list() throws Exception {
		Shop shop =(Shop)session.get("shop");
		request.put("shopid",shop.getShopId());
		return "list";
	}

	public String listPage() throws Exception {
		//String goodid=ServletActionContext.getRequest().getParameter("goodsid");
		ServletActionContext.getRequest().setAttribute("inputid", 1);
		return "listpage";
	}
//保存布局操作
	public String save() throws Exception {
		String layout = ServletActionContext.getRequest().getParameter("layout");
		//将布局格式写到html文件中,这时候已经将布局对应到具体的JSP页面上。
		//设计一个试图解析器，根据店铺id，进行选择对应的JSP页面上。
		String shopid = ServletActionContext.getRequest().getParameter("shopid");
		String outurl=DecorationFactory.generateUrl(Integer.parseInt(shopid));
		String path=ServletActionContext.getServletContext().getRealPath(outurl);
		DecorationFactory.mapUrl(layout,path);
		
		String isResult="true";	
		PrintWriter pw=ServletActionContext.getResponse().getWriter();
        JSONObject json = new JSONObject();//将map对象转换成json类型数据
        json.put("isResult", isResult);
        pw.write(json.toString());
		pw.flush();
		pw.close();
		return null;
	}


}

