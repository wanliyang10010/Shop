package cn.xaut.shop.dao.impl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.ShopDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.GoodsType;
import cn.xaut.shop.pojo.Shop;
public class ShopDaoImpl extends HibernateRepository<Shop,Integer> implements
ShopDao{
	public ShopDaoImpl() {
		super();
	}

	@Override
	public Page<Shop> find(Page<Shop> page) {
		StringBuffer hqlBuff = new StringBuffer("FROM Shop");
		List<Object> values = new ArrayList<Object>();
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<Shop> findByKey(Page<Shop> page,String stype, String key) {
		String sql="";
		String key1=key;
		key="%"+key+"%";
		switch (stype)
		{  
		   case "店铺名": sql="FROM Shop a WHERE a.shopname like ?";
		         break;

		   case "店铺类别":sql="FROM Shop a WHERE a.shopcategory like ?";
	         break;
			   
		   case "商品类别":sql="FROM Shop a WHERE a.productcategory like ?";
	         break;
			   
		   case "状态":sql="FROM Shop a WHERE a.shopstate=?";
		             key=key1;
	         break;
		}
		StringBuffer hqlBuff = new StringBuffer(sql);
		List<Object> values = new ArrayList<Object>();
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public List<Shop> findByUserId(Integer userid) {
		StringBuffer hqlBuff = new StringBuffer("FROM Shop a WHERE a.userinfo.userinfoId= ? order by a.regeditdate asc");
		List<Object> values = new ArrayList<Object>();
		values.add(userid);
		return find(hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<Shop> QueryByKey(Page<Shop> page, String key) {
		key="%"+key+"%";
		StringBuffer hqlBuff = new StringBuffer("FROM Shop a WHERE  a.shopstate='1' and a.shopname like ?");
		List<Object> values = new ArrayList<Object>();
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	public List<Shop> getMyViewList(int userid,String fromdate, String todate) {
		String sql = "";	
		sql = "FROM Shop a WHERE  a.regeditdate between " + "'"+fromdate+"'"+
				" and " +"'"+ addOneday(todate) +"'"+ " and a.userinfo = '" 
				+userid+"' order by a.regeditdate desc";
		return find(sql);

	}
	//鏍规嵁userid鏌ヨ搴楅摵淇℃伅
	public Shop checkShopidByUserId(final int userid) {
			   List<Shop> accounts=getListByUserId(userid);
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
		

	public List<Shop> getListByUserId(int userid) {
		String sql = "";		
		sql = "FROM Shop a WHERE a.userinfo = '"+userid+"'order by a.regeditdate asc";
		return find(sql);
	
	}

	//dwj
	@Override
	public Page<Shop> findByAllShop(Page<Shop> page) {
	// TODO Auto-generated method stub
	   StringBuffer hqlBuff = new StringBuffer("FROM Shop a WHERE a.shopstate='1' order by a.shopId");
	   List<Object> values = new ArrayList<Object>();
		return findPage(page,hqlBuff.toString(),values.toArray());
	}
	//dwj
	@Override
	public List<Shop> findShopInfoKeyWord(String keyWord) {
	// TODO Auto-generated method stub
		keyWord="%"+keyWord+"%";
		StringBuffer hqlBuff = new StringBuffer("FROM Shop a WHERE  a.shopstate='1' and a.shopname like ? order by a.shopId");
		List<Object> values = new ArrayList<Object>();
		values.add(keyWord);
		return find(hqlBuff.toString(),values.toArray());
	}
	@Override
	public Shop findShopByshopId(Integer shopId) {
		StringBuffer hqlBuff = new StringBuffer("FROM Shop a WHERE a.shopId = ?");
		List<Object> values = new ArrayList<Object>();
		values.add(shopId);
		List<Shop> list=find(hqlBuff.toString(),values.toArray());
		if(list != null&&list.size()>0)
	   {
		   return list.get(0);
	   }
	   else
	   {
		  return  null;
	   }
	}
	public static String addOneday(String today){   
        SimpleDateFormat f =  new SimpleDateFormat("yyyy-MM-dd");   
        try   {   
            Date  d  =  new Date(f.parse(today).getTime()+24*3600*1000);     
              return  f.format(d);   
        }   
        catch(Exception ex) {   
            return   "输入格式错误";     
        }   
    }
	@Override
	public List<Shop> findBySate() {
		// TODO Auto-generated method stub
		StringBuffer hqlBuff = new StringBuffer("FROM Shop a WHERE  a.shopstate='1' order by a.shopId");
		List<Object> values = new ArrayList<Object>();
		return find(hqlBuff.toString(),values.toArray());
	}

}
