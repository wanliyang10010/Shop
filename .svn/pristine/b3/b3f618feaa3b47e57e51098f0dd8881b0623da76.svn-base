package cn.xaut.shop.dao.impl;
import java.util.ArrayList;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.GoodsTypeItemDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.GoodsType;
import cn.xaut.shop.pojo.GoodsTypeItem;

public class GoodsTypeItemDaoImpl extends HibernateRepository<GoodsTypeItem,Integer> implements
GoodsTypeItemDao{
	public GoodsTypeItemDaoImpl() {
		super();
	}

	@Override
	public Page<GoodsTypeItem> findByKey(Page<GoodsTypeItem> page,Integer gtypeId, String key) {
		key="%"+key+"%";
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsTypeItem a WHERE a.itemname like ? and a.gtypeId = ? order by gtitemId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(key);
		values.add(gtypeId);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<GoodsTypeItem> findAll(Page<GoodsTypeItem> page,Integer gtypeid) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsTypeItem a WHERE a.gtypeId = ? order by gtitemId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(gtypeid);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public List<GoodsTypeItem> findByType(Integer typeId) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsTypeItem a WHERE a.gtypeId = ? order by gtitemId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(typeId);
		return find(hqlBuff.toString(),values.toArray());
	}

	@Override
	public GoodsTypeItem findGoodsTypeItemByGtitemId(Integer gtitemId) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsTypeItem a WHERE a.gtitemId = ? order by gtitemId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(gtitemId);
		List<GoodsTypeItem> list=find(hqlBuff.toString(),values.toArray());
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
	public List<GoodsTypeItem> getItemType(String gtypeId, String itemname) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsTypeItem a WHERE a.gtypeId = ? and a.itemname= ? order by gtitemId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(Integer.parseInt(gtypeId));
		values.add(itemname);
		return find(hqlBuff.toString(),values.toArray());
	}

	@Override
	public List<GoodsTypeItem> getItemTypeUpdate(String gtypeId,
			String itemname, String remark) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsTypeItem a WHERE a.gtypeId = ? and a.itemname= ? and a.remark= ? order by gtitemId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(Integer.parseInt(gtypeId));
		values.add(itemname);
		values.add(remark);
		return find(hqlBuff.toString(),values.toArray());
	}
	
}
