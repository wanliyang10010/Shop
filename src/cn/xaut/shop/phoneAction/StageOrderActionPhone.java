package cn.xaut.shop.phoneAction;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.DeliverAddr;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.StageGoods;
import cn.xaut.shop.pojo.StageOrder;
import cn.xaut.shop.pojo.UploadFile;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.pojo.UserPoint;

public class StageOrderActionPhone extends BaseAction<StageOrder>{
	Timestamp ts = new Timestamp(System.currentTimeMillis());
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");
	public String AddOrder()
	{
		String sgoodsId = ServletActionContext.getRequest().getParameter("sgoodsId");
		StageGoods stageGoods=stageGoodsService.get(Integer.parseInt(sgoodsId));
		//UserInfo user = (UserInfo)session.get("userinfo");
		String userid=ServletActionContext.getRequest().getParameter("userid");
		     UserInfo userinfo=userInfoService.findById(Integer.parseInt(userid));   
		if(userinfo.getPoints()>=stageGoods.getPoints())
        {
        	String addrid = ServletActionContext.getRequest().getParameter("addrid");
            DeliverAddr addr = deliverAddrService.get(Integer.parseInt(addrid));
            StageOrder stageOrder =new StageOrder();
            stageOrder.setAddr(addr.getFinalAddr());
            stageOrder.setBuytime(ts);
            stageOrder.setGoodsname(stageGoods.getGoodsname());
            stageOrder.setStagegoods(stageGoods);
            stageOrder.setUser(userinfo);
            stageOrder.setRemark("已提交");
            stageOrderService.add(stageOrder);
        	if(stageOrder.getStageorderId()!=null&&stageOrder.getStageorderId()>0)
    		{
        		updatePoints(stageGoods,userinfo);
    			jsonMap.put("data", "right");
    		}
    		else
    		{
    			jsonMap.put("data", "wrong");
    		}
        }
        else
        {
        	jsonMap.put("data", "not");
        }
		return "json";
	}
	
	public void updatePoints(StageGoods stageGoods, UserInfo user)
	{
		//UserInfo user = (UserInfo)session.get("userinfo");
		user.setPoints(user.getPoints()-stageGoods.getPoints());
		userInfoService.update(user);
	//	session.put("userinfo", user);
		UserPoint userPoint = new UserPoint();
		userPoint.setUserinfo(user);
		userPoint.setOperateTime(dateFormat.format(now));
		userPoint.setPoint(stageGoods.getPoints());
		userPoint.setPlusminus("-");
		userPoint.setContent("兑换商品");
		userPointService.save(userPoint);// 保存会员积分表
	}
	public String searchOrder()
	{
		UserInfo user = (UserInfo)session.get("userinfo");
		String fromdate = ServletActionContext.getRequest().getParameter("fromdate");
		String todate = ServletActionContext.getRequest().getParameter("todate");
		page=stageOrderService.getSaleOrder(page,user.getUserinfoId(),fromdate,todate);
		if(page!=null&&page.getTotalItems()>0)
		  {
			  request.put("msg", "");   
		  }
		  else
		  {
			  request.put("msg", "未找到符合条件的订单！");   
		  }
		request.put("page",page);
		return "SaleOrder";
	}
	
	public String opensale()
	{
		UserInfo user = (UserInfo)session.get("userinfo");
		page=stageOrderService.getSaleOrder(page,user.getUserinfoId(),null,null);
		if(page!=null&&page.getTotalItems()>0)
		  {
			  request.put("msg", "");   
		  }
		  else
		  {
			  request.put("msg", "未找到符合条件的订单！");   
		  }
		request.put("page",page);
		return "SaleOrder";
	}
	private Map<String,Object> responseJson = new HashMap<String,Object>();
	public Map<String, Object> getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}
	public String searchAdmin()
	{
		String fromdate = ServletActionContext.getRequest().getParameter("fromdate");
		String todate = ServletActionContext.getRequest().getParameter("todate");
		String stype= ServletActionContext.getRequest().getParameter("stype");
		page=stageOrderService.getOrderAdmin(page,stype,fromdate,todate);
		if(page!=null&&page.getTotalItems()>0)
		  {
			  request.put("msg", "");   
		  }
		  else
		  {
			  request.put("msg", "未找到符合条件的订单！");   
		  }
		request.put("page",page);
		return "list";
	}
	
	public String openAdmin()
	{
		page=stageOrderService.getOrderAdmin(page,"全部订单",null,null);
		if(page!=null&&page.getTotalItems()!=0)
		{
			responseJson.put("LIST", page.getResult());
			boolean isFristPage = page.isFirstPage();
			boolean isLastPage = page.isLastPage();
			
			responseJson.put("first", isFristPage);
			responseJson.put("next", isLastPage);
		}else
		{		
			responseJson.put("isResult", "false");
		}			
		return "list";
	}
	
	public String trans()
	{
		String sorderid = ServletActionContext.getRequest().getParameter("sorderid");
		String transcompany = ServletActionContext.getRequest().getParameter("transcompany");
		String transnumber = ServletActionContext.getRequest().getParameter("transnumber");
		StageOrder stageOrder =stageOrderService.get(Integer.parseInt(sorderid));
		stageOrder.setTranscompany(transcompany);
		stageOrder.setTransnumber(transnumber);
		stageOrder.setRemark("已发货");
        stageOrderService.update(stageOrder);
    	jsonMap.put("data", "right");
		return "json";
	}
}

