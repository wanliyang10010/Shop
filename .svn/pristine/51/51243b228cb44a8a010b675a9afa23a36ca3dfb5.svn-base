package cn.xaut.shop.action;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.pojo.DeliverAddr;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.StageGoods;
import cn.xaut.shop.pojo.StageOrder;
import cn.xaut.shop.pojo.UploadFile;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.pojo.UserPoint;

public class StageOrderAction extends BaseAction<StageOrder>{
	Timestamp ts = new Timestamp(System.currentTimeMillis());
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");
	public String AddOrder()
	{
		String sgoodsId = ServletActionContext.getRequest().getParameter("sgoodsId");
		StageGoods stageGoods=stageGoodsService.get(Integer.parseInt(sgoodsId));
		UserInfo user = (UserInfo)session.get("userinfo");
        if(user.getPoints()>=stageGoods.getPoints())
        {
        	String addrid = ServletActionContext.getRequest().getParameter("addrid");
            DeliverAddr addr = deliverAddrService.get(Integer.parseInt(addrid));
            StageOrder stageOrder =new StageOrder();
            stageOrder.setAddr(addr.getFinalAddr());
            stageOrder.setBuytime(ts);
            stageOrder.setGoodsname(stageGoods.getGoodsname());
            stageOrder.setStagegoods(stageGoods);
            stageOrder.setUser(user);
            stageOrder.setRemark("已提交");
            SimpleDateFormat dateFormateNew = new SimpleDateFormat(
    				"yyyy-MM-dd HH:mm:ss");
    		user.setPoints(user.getPoints()-stageGoods.getPoints());
    		UserPoint userPoint = new UserPoint();
    		userPoint.setUserinfo(user);
    		userPoint.setOperateTime(dateFormateNew.format(now));
    		userPoint.setPoint(stageGoods.getPoints());
    		userPoint.setPlusminus("-");
    		userPoint.setContent("兑换商品");
    		//userPointService.save(userPoint);// 保存会员积分表
    		//userInfoService.update(user);
    		session.put("userinfo", user);
        	if(stageOrderService.addOrder(stageOrder,userInfoService,user,userPointService,userPoint))
        	{
        			jsonMap.put("data", "right");
        	}
        		else
        		{
        			jsonMap.put("data", "wrong");
        		}
//        	if(stageOrder.getStageorderId()!=null&&stageOrder.getStageorderId()>0)
//    		{
//        		updatePoints(stageGoods);
//    			jsonMap.put("data", "right");
//    		}
//    		else
//    		{
//    			jsonMap.put("data", "wrong");
//    		}
        }
        else
        {
        	jsonMap.put("data", "not");
        }
		return "json";
	}
	
	public String checkOrder()
	{
		String sgoodsId = ServletActionContext.getRequest().getParameter("sgoodsId");
		UserInfo user = (UserInfo)session.get("userinfo");
		StageOrder stageorder=stageOrderService.getOrderCheck(sgoodsId,user.getUserinfoId());
		if(stageorder!=null&&stageorder.getStageorderId()>0)
		{
			if(stageorder.getBuytime().getYear()==ts.getYear()&&stageorder.getBuytime().getMonth()==ts.getMonth())
			{
			    jsonMap.put("data", "wrong");
			}
			else
			{
				jsonMap.put("data", "right");
			}
		}
		else
		{
			jsonMap.put("data", "right");
		}
		return "json";
	}
	
	
	
	public void updatePoints(StageGoods stageGoods)
	{
		SimpleDateFormat dateFormateNew = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		UserInfo user = (UserInfo)session.get("userinfo");
		user.setPoints(user.getPoints()-stageGoods.getPoints());
		UserPoint userPoint = new UserPoint();
		userPoint.setUserinfo(user);
		userPoint.setOperateTime(dateFormateNew.format(now));
		userPoint.setPoint(stageGoods.getPoints());
		userPoint.setPlusminus("-");
		userPoint.setContent("兑换商品");
		userPointService.save(userPoint);// 保存会员积分表
		userInfoService.update(user);
		session.put("userinfo", user);
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
	
	public String trans()
	{
		UserInfo userinfo = (UserInfo) session.get("userinfo");
		String sorderid = ServletActionContext.getRequest().getParameter("sorderid");
		String transcompany = ServletActionContext.getRequest().getParameter("transcompany");
		String transnumber = ServletActionContext.getRequest().getParameter("transnumber");
		StageOrder stageOrder =stageOrderService.get(Integer.parseInt(sorderid));
		stageOrder.setTranscompany(transcompany);
		stageOrder.setTransnumber(transnumber);
		stageOrder.setRemark("已发货");
        stageOrderService.updateOrder(stageOrder,messageService,userinfo);
//        stageOrderService.update(stageOrder);
//        messageService.sendMessage(messageService,"您的一件积分兑换商品已经发货！", userinfo.getUserinfoId(), stageOrder.getUser().getUserinfoId(),
//				"stageOrderAction_opensale.action", null, null);
    	jsonMap.put("data", "right");
		return "json";
	}
}

