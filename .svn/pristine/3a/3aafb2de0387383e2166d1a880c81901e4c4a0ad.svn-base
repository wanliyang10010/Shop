package cn.xaut.shop.service.impl;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.OrderSon;
import cn.xaut.shop.service.OrderSonService;
import cn.xaut.shop.util.NumberFormat;
public class OrderSonServiceImpl extends BaseServiceImpl<OrderSon> implements OrderSonService {

	public OrderSonServiceImpl()
	{
		super();
	}
	
	@SuppressWarnings("unchecked")
	public OrderSon getCheckByid(int id) {
	    List<OrderSon> accounts = hibernateTemplate.findByNamedParam(
				"FROM OrderSon a WHERE a.ordersonid =:ordersonid",
				new String[] { "ordersonid" },
				new Object[] { id});
	   System.out.println(accounts.size());
	   if(accounts != null&&accounts.size()>0)
	   {
		   return accounts.get(0);
	   }
	   else
	   {
		  return  null;
	   }
	}
	
	@SuppressWarnings("unchecked")
	public List<OrderSon> queryOrderById(int id) {
	    List<OrderSon> accounts = hibernateTemplate.findByNamedParam(
				"FROM OrderSon a WHERE a.orderid =:orderid",
				new String[] { "orderid" },
				new Object[] { id});
	    
	   System.out.println(accounts.size());
	   return accounts;
	}
	
	
	@SuppressWarnings("unchecked")
	public Goods queryOrderBygid(int gid) {
	    List<Goods> accounts = hibernateTemplate.findByNamedParam(
				"FROM Goods a WHERE a.gid =:gid",
				new String[] { "gid" },
				new Object[] { gid});
	    
	   System.out.println(accounts.size());
	   
	   if(accounts != null&&accounts.size()>0)
	   {
		   return accounts.get(0);
	   }
	   else
	   {
		  return  null;
	   }
	}
	
	
	@SuppressWarnings("unchecked")
	public Goods queryOrderBygname(String gname) {
	    List<Goods> accounts = hibernateTemplate.findByNamedParam(
				"FROM Goods a WHERE a.gname =:gname",
				new String[] { "gname" },
				new Object[] { gname});
	    
	   System.out.println(accounts.size());
	   
	   if(accounts != null&&accounts.size()>0)
	   {
		   return accounts.get(0);
	   }
	   else
	   {
		  return  null;
	   }
	}
	
	
	@SuppressWarnings("unchecked")
	public List<OrderSon> queryOrderSonByShopname(String shopname) {
	    List<OrderSon> accounts = hibernateTemplate.findByNamedParam(
				"FROM OrderSon a WHERE a.shopname =:shopname",
				new String[] { "shopname" },
				new Object[] { shopname});
	    
	   System.out.println(accounts.size());
	   return accounts;
	}
	
	@SuppressWarnings("unchecked")
	public List<OrderSon> queryOrderSonById(int orderid) {
	    List<OrderSon> accounts = hibernateTemplate.findByNamedParam(
				"FROM OrderSon a WHERE a.orderid =:orderid",
				new String[] { "orderid" },
				new Object[] { orderid});
	    
	   System.out.println(accounts.size());
	   return accounts;
	}

	@Override
	public String getByGoodsId(Integer goodsid) {
		double money=0;
		Integer count=0;
		 List<OrderSon> accounts = hibernateTemplate.findByNamedParam(
					"FROM OrderSon a WHERE a.goods.goodsid =:goodsid",
					new String[] { "goodsid" },
					new Object[] { goodsid});
		   if(accounts!=null&accounts.size()>0)
		   {
			   for(int i=0;i<accounts.size();i++)
			   {
				   OrderSon orderSon=accounts.get(i);
				   if(orderSon.getSonstate()!=null)
				   {
					   String state=orderSon.getSonstate();
					   if(Integer.parseInt(state)>=40)
					   {
						   //System.out.print(money+"+"+orderSon.getPrice()*orderSon.getAmount());
						   money=money+NumberFormat.Fix2(orderSon.getPrice()*orderSon.getAmount());
						   //System.out.println("="+money);
						   count=count+orderSon.getAmount();
					   }
				   }
			   }
		   }
		   return money+","+count;
	}

	@Override
	public Integer getByGoodsIdAll(String goodsid) {
		List<OrderSon> accounts = hibernateTemplate.findByNamedParam(
				"FROM OrderSon a WHERE a.goods.goodsid =:goodsid",
				new String[] { "goodsid" },
				new Object[] { Integer.parseInt(goodsid)});
	   if(accounts!=null&accounts.size()>0)
	   {
		   return 1;
	   }
	   else
	   {
		   return 0;
	   }
	}
}
