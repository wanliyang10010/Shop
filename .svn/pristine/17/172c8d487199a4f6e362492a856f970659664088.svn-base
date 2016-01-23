package cn.xaut.shop.dao.impl;
import java.util.ArrayList;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.GoodsDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.Goods;

public class GoodsDaoImpl extends HibernateRepository<Goods,Integer> implements GoodsDao{
	
	@Override
	public Page<Goods> findByKey(Page<Goods> page, String key) {
		key="%"+key+"%";
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a where a.state in(0,3,5) and a.shop.shopstate='1' and a.goodsname like ? order by a.goodsid desc");
		List<Object> values = new ArrayList<Object>();
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<Goods> findHotByShopId(Page<Goods> page, int sid) {
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a where a.state in(0,3,5) and a.hot='1' and a.shop.shopstate='1' and a.shop.shopId=? order by a.samount desc");
		List<Object> values = new ArrayList<Object>();
		values.add(sid);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}
	
	@Override 
	public Page<Goods> queryByShopId(Page<Goods> page, int sid) {
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a where a.state in(0,1,2,3,5) and a.shop.shopId=? and a.shop.shopstate='1' order by a.goodsid desc");
		List<Object> values = new ArrayList<Object>();
		values.add(sid);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<Goods> queryAllHot(Page<Goods> page) {
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a where a.state in(0,3,5)  and a.shop.shopstate='1' and   a.hot='1' order by a.samount desc");
		List<Object> values = new ArrayList<Object>();
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<Goods> findDHByShopId(Page<Goods> page, String key, String stype,
			Integer sid) {
		String sql="";
		key="%"+key+"%";
		switch (stype)
		{  
		   case "所有商品": sql="FROM Goods a WHERE a.state in(0,3,5) and   a.shop.shopId=? and a.shop.shopstate='1' and  a.goodsname like ? order by a.goodsid desc";
		         break;

		   case "特价商品":sql="FROM Goods a WHERE a.state in(0,3,5) and a.shop.shopstate='1' and  a.shop.shopId=? and a.discount.discountId>0 and a.goodsname like ? order by a.goodsid desc";
	         break;
			   
		   case "热卖商品":sql="FROM Goods a WHERE a.state in(0,3,5) and a.shop.shopstate='1' and  a.shop.shopId=? and a.hot='1' and a.goodsname like ? order by a.goodsid desc";
	         break;
	         
		   case "二手商品":sql="FROM Goods a WHERE a.state ='5'  and a.shop.shopstate='1' and  a.shop.shopId=? and  a.goodsname like ? order by a.goodsid desc";
	         break;
		}
		StringBuffer hqlBuff = new StringBuffer(sql);
		List<Object> values = new ArrayList<Object>();
		values.add(sid);
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<Goods> findByPrice(Page<Goods> page, String p, String keyword) {
		String sql="";
		keyword="%"+keyword+"%";
		if(p.equals("low"))
		{
			sql="FROM Goods a where  a.state in(0,3,5) and a.shop.shopstate='1' and a.goodsname like ? Order By a.price asc";
		}
		else
		{
			sql="FROM Goods a where  a.state in(0,3,5) and a.shop.shopstate='1' and a.goodsname like ? Order By a.price desc";
		}
		StringBuffer hqlBuff = new StringBuffer(sql);
		List<Object> values = new ArrayList<Object>();
		values.add(keyword);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}
	
	@Override
	public Page<Goods> findByKeyShopId(Page<Goods> page, String key, Integer sid) {
		key="%"+key+"%";
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a where a.state in(0,1,2,3,5) and a.shop.shopId=?  and a.shop.shopstate='1' and a.goodsname like ? order by a.goodsid desc");
		List<Object> values = new ArrayList<Object>();
		values.add(sid);
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}
	
	@Override
	public Page<Goods> findAllHot(Page<Goods> page) {
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a where a.hot='1' and a.state in(0,3,5) and a.shop.shopstate='1' order by a.samount desc");
		List<Object> values = new ArrayList<Object>();
		return findPage(page,hqlBuff.toString(),values.toArray());
	}
	
	@Override
	public Page<Goods> queryDiscount(Page<Goods> page) {
		//date=date.replace("/", "-");
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a WHERE a.state in(0,3,5) and a.shop.shopstate='1' and a.discount.discountId>0 order by a.samount desc");
		List<Object> values = new ArrayList<Object>();
		//values.add(date);
		//values.add(date);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}
	
	@Override
	public Page<Goods> queryShopDiscount(Page<Goods> page, String date,
			Integer shopId) {
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a WHERE a.state in(0,3,5) and a.shop.shopstate='1'  and a.shop.shopId =? and a.discount.discountId>0 order by a.samount desc");
		List<Object> values = new ArrayList<Object>();
		values.add(shopId);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}
	
	@Override
	public List<Goods> findByGoodsId(Integer goodsid) {
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a WHERE a.state in(0,3,5) and a.shop.shopstate='1'  and goodsid=? order by a.goodsid desc");
		List<Object> values = new ArrayList<Object>();
		values.add(goodsid);
		return find(hqlBuff.toString(),values.toArray());
	}
	
	@Override
	public Page<Goods> querySale(Page<Goods> page, String keyword) {
		keyword="%"+keyword+"%";
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a where  a.shop.shopstate='1' and a.state in(0,3,5) and a.goodsname like ?  order by a.samount desc");
		List<Object> values = new ArrayList<Object>();
		values.add(keyword);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}
	
	@Override
	public Page<Goods> queryType(Page<Goods> page, String type) {
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a where  a.shop.shopstate='1' and a.state in(0,3,5) and a.shop.productcategory=? order by a.samount desc");
		List<Object> values = new ArrayList<Object>();
		values.add(type);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}
	
	@Override
	public List<Goods> getGoodsList(Integer shopid, String key) {
		key="%"+key+"%";
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a where  a.state in(0,1,2,3,5) and a.shop.shopId=? and a.goodsname like ? order by a.samount desc");
		List<Object> values = new ArrayList<Object>();
		values.add(shopid);
		values.add(key);
		return find(hqlBuff.toString(),values.toArray());
	}

	//dwj查询所有商品
		@Override
		public Page<Goods> findByAllGood(Page<Goods> page) {
			// TODO Auto-generated method stub
			StringBuffer hqlBuff = new StringBuffer("FROM Goods a where a.state in(0,3,5)  and a.shop.shopstate='1' order by a.goodsid desc");
			List<Object> values = new ArrayList<Object>();
			return findPage(page,hqlBuff.toString(),values.toArray());
		}
		//dwj关键字查商品
		@Override
		public List<Goods> findGoodsInfoKeyWord(String keyWord) {
			// TODO Auto-generated method stub
			keyWord="%"+keyWord+"%";
			StringBuffer hqlBuff = new StringBuffer("FROM Goods a WHERE a.state in(0,3,5) and a.shop.shopstate='1'  and a.goodsname like ? order by a.goodsid desc");
			List<Object> values = new ArrayList<Object>();
			values.add(keyWord);
			return find(hqlBuff.toString(),values.toArray());
		}
		//dwjSET集合
		@Override
		public List<Goods> getShopSet(Integer sid) {
			// TODO Auto-generated method stub
			StringBuffer hqlBuff = new StringBuffer("FROM Goods a where a.state in(0,1,2,3,5) and a.shop.shopId=? and a.shop.shopstate='1' order order by a.goodsid desc");
			List<Object> values = new ArrayList<Object>();
			values.add(sid);
			return find(hqlBuff.toString(),values.toArray());
		}
	
		
	@Override
	public Goods findGoodsByGoodsId(Integer goodsid) {
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a WHERE a.state in(0,1,2,3,5) and  a.goodsid = ? order by a.goodsid desc");
		List<Object> values = new ArrayList<Object>();
		values.add(goodsid);
		List<Goods> list=find(hqlBuff.toString(),values.toArray());
		if(list != null&&list.size()>0)
	   {
		   return list.get(0);
	   }
	   else
	   {
		  return  null;
	   }
	}

	@Override
	public List<Goods> findGoodsByTypeId(String gtypeID) {
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a where a.state in(0,1,2,3,5) and a.typeid=? order by a.goodsid desc");
		List<Object> values = new ArrayList<Object>();
		values.add(Integer.parseInt(gtypeID));
		return find(hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<Goods> findByShopKey(Page<Goods> page, String shopId, String key) {
		key="%"+key+"%";
		StringBuffer hqlBuff=null;
		List<Object> values = new ArrayList<Object>();
		if(shopId.equals("0"))
		{
			hqlBuff = new StringBuffer("FROM Goods a where a.state in(0,3,5)  and a.goodsname like ? order by a.state desc");
		}
		else
		{
			hqlBuff = new StringBuffer("FROM Goods a where a.state in(0,3,5) and a.shop.shopId=? and a.goodsname like ? order by a.state desc");
			values.add(Integer.parseInt(shopId));
		}
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<Goods> findByState(Page<Goods> page) {
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a where a.state in(0,3,5)  order by a.state desc");
		List<Object> values = new ArrayList<Object>();
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<Goods> findTop(Page<Goods> page) {
		// TODO Auto-generated method stub
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a where a.state ='3' order by a.goodsid desc");
		List<Object> values = new ArrayList<Object>();
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public int minGoodAmount(Integer goodsid,final Integer amount) {
		
		StringBuffer hqlBuff = new StringBuffer("UPDATE Goods g SET ");
		hqlBuff.append("g.amount = g.amount - ? ");
		//这里不进行销量增加，在确认付款之后增加销量
		//hqlBuff.append(", g.samount = g.samount + ?");
		hqlBuff.append("WHERE  g.goodsid = ?");
		
		List<Object> values = new ArrayList<Object>();
		
		values.add(amount);
		//values.add(amount);//不进行销量增加
		values.add(goodsid);
		
		return batchExecute(hqlBuff.toString(),values.toArray());
	}
	
	@Override
	public int minGoodAmountProperty(int goodsid,final int amount,final String property)
	{
		StringBuffer hqlBuff = new StringBuffer("UPDATE Goods g SET ");
		hqlBuff.append("g.amount = g.amount - ? ");
		hqlBuff.append("WHERE g.goodsid = ?");
		
		List<Object> values = new ArrayList<Object>();
		values.add(amount);
		values.add(goodsid);

		//先执行一个...
		batchExecute(hqlBuff.toString(),values.toArray());
		
		StringBuffer hqlBuff2 = new StringBuffer("UPDATE GoodsStock s SET ");
		hqlBuff2.append("s.amount = s.amount - ? ");
		hqlBuff2.append("WHERE s.goodsId = ? AND s.goodstype = ?");
		values.add(property);
		//再执行另一个...
		return batchExecute(hqlBuff2.toString(),values.toArray());
	}
	

	@Override
	public int rollBackGoodAmount(Integer goodsid, Integer amount) {
		
		StringBuffer hqlBuff = new StringBuffer("UPDATE Goods g SET ");
		hqlBuff.append("g.amount = g.amount + ? ");
		hqlBuff.append("WHERE g.goodsid = ?");
		
		List<Object> values = new ArrayList<Object>();
		values.add(amount);
		values.add(goodsid);
		
		return batchExecute(hqlBuff.toString(),values.toArray());
	}
	
	@Override
	public int rollBackGoodAmountProperty(int goodsid, int amount,String property) {
		
		StringBuffer hqlBuff = new StringBuffer("UPDATE Goods g SET ");
		hqlBuff.append("g.amount = g.amount + ? ");
		hqlBuff.append("WHERE g.goodsid = ?");
		
		List<Object> values = new ArrayList<Object>();
		values.add(amount);
		values.add(goodsid);
		
		batchExecute(hqlBuff.toString(),values.toArray());
		
		StringBuffer hqlBuff2 = new StringBuffer("UPDATE GoodsStock s SET ");
		hqlBuff2.append("s.amount = s.amount + ?");
		hqlBuff2.append("WHERE s.goodsId = ? AND s.goodstype = ?");
		values.add(property);
		
		return batchExecute(hqlBuff2.toString(),values.toArray());
	}
	
	

	@Override
	public int increaseSellAmount(Integer goodsId, Integer sellAmount) {
		// TODO Auto-generated method stub
		
		StringBuffer hqlBuff = new StringBuffer("UPDATE Goods g SET  ");
		//销量增加
		hqlBuff.append("g.samount = g.samount + ? ");
		hqlBuff.append("WHERE g.goodsid = ?");
		
		List<Object> values = new ArrayList<Object>();
		values.add(sellAmount);
		values.add(goodsId);
		
		return batchExecute(hqlBuff.toString(),values.toArray());
	}
	
	@Override
	public int decreaseSellAmount(Integer goodsId, Integer sellAmount) {
		// TODO Auto-generated method stub
		
		StringBuffer hqlBuff = new StringBuffer("UPDATE Goods g SET  ");
		//销量减少
		hqlBuff.append("g.samount = g.samount - ? ");
		hqlBuff.append("WHERE g.goodsid = ?");
		
		List<Object> values = new ArrayList<Object>();
		values.add(sellAmount);
		values.add(goodsId);
		
		return batchExecute(hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<Goods> queryViewShopId(Page<Goods> page, Integer sid) {
		// TODO Auto-generated method stub
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a where a.state in(0,3,5) and a.shop.shopId=? and a.shop.shopstate='1' order by a.samount desc");
		List<Object> values = new ArrayList<Object>();
		values.add(sid);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public List<Goods> getGoodsTypeList(Integer shopid, String typeid,
			String key) {
		key="%"+key+"%";
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a where a.shop.shopId=? and  a.typeid=? and a.goodsname like ? order by a.samount desc");
		List<Object> values = new ArrayList<Object>();
		values.add(shopid);
		values.add(Integer.parseInt(typeid));
		values.add(key);
		return find(hqlBuff.toString(),values.toArray());
	}

	@Override
	public List<Goods>  getType(Integer typeid, Integer goodsid) {
		// TODO Auto-generated method stub
				StringBuffer hqlBuff = new StringBuffer("FROM Goods a where a.state in(0,3,5) and a.typeid=? and a.goodsid!=?  order by a.samount desc");
				List<Object> values = new ArrayList<Object>();
				values.add(typeid);
				values.add(goodsid);
				return find(hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<Goods> findShandByKey(Page<Goods> page, String key) {
		key="%"+key+"%";
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a where a.state ='5' and a.shop.shopstate='1' and a.goodsname like ? order by a.goodsid desc");
		List<Object> values = new ArrayList<Object>();
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<Goods> findShand(Page<Goods> page) {
		// TODO Auto-generated method stub
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a where a.state ='5' and a.shop.shopstate='1'  order by a.goodsid desc");
		List<Object> values = new ArrayList<Object>();
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<Goods> findShandByType(Page<Goods> page, String key,
			String type) {
		// TODO Auto-generated method stub
		key="%"+key+"%";
		StringBuffer hqlBuff = new StringBuffer("FROM Goods a where a.state ='5' and a.shop.productcategory=? and a.shop.shopstate='1' and a.goodsname like ? order by a.goodsid desc");
		List<Object> values = new ArrayList<Object>();
		values.add(type);
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	
}
