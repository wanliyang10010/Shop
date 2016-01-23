package cn.xaut.shop.dao.impl;
import java.util.ArrayList;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.GoodsTypeDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.GoodsType;
import cn.xaut.shop.pojo.UserInfo;

public class GoodsTypeDaoImpl extends HibernateRepository<GoodsType,Integer> implements
GoodsTypeDao{
	public GoodsTypeDaoImpl() {
		super();
	}

	@Override
	public Page<GoodsType> findByKey(Page<GoodsType> page, String key,String shopId) {
		key="%"+key+"%";
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsType a WHERE a.shopId = ? and a.typename like ? order by a.gtypeId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(Integer.parseInt(shopId));
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<GoodsType> findAll(Page<GoodsType> page,String shopId) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsType a WHERE a.shopId = ? order by a.gtypeId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(Integer.parseInt(shopId));
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public List<GoodsType> findByShopId(Integer shopId) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsType a WHERE a.shopId = ? order by a.gtypeId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(shopId);
		return find(hqlBuff.toString(),values.toArray());
	}

	@Override
	public GoodsType findGoodsTypeBygtypeId(Integer gtypeId) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsType a WHERE a.gtypeId = ? order by a.gtypeId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(gtypeId);
		List<GoodsType> list=find(hqlBuff.toString(),values.toArray());
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
	public List<GoodsType> getTypeCount(String shopId, String typename) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsType a WHERE a.shopId = ? and a.typename = ? order by gtypeId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(Integer.parseInt(shopId));
		values.add(typename);
		return find(hqlBuff.toString(),values.toArray());
	}

	@Override
	public List<GoodsType> getTypeCountUpdate(String shopId, String typename,
			String remark) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsType a WHERE a.shopId = ? and a.typename = ? and a.remark= ? order by gtypeId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(Integer.parseInt(shopId));
		values.add(typename);
		values.add(remark);
		return find(hqlBuff.toString(),values.toArray());
	}
	
}
