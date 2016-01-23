package cn.xaut.shop.dao.impl;
import java.util.ArrayList;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.GoodsDetialDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.GoodsDetial;

public class GoodsDetialDaoImpl extends HibernateRepository<GoodsDetial,Integer> implements
GoodsDetialDao{
	public GoodsDetialDaoImpl() {
		super();
	}
	@Override
	public Page<GoodsDetial> find(Page<GoodsDetial> page, Integer goodsId) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsDetial a where a.goodsId=? order by gdetialId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(goodsId);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}
	@Override
	public Page<GoodsDetial> findByKey(Page<GoodsDetial> page, String key,
			String goodsID) {
		key="%"+key+"%";
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsDetial a where a.gtItem.itemname=? and a.goodsId=? order by gdetialId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(key);
		values.add(Integer.parseInt(goodsID));
		return findPage(page,hqlBuff.toString(),values.toArray());
	}
	@Override
	public List<GoodsDetial> findByGoods(Integer goodsid) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsDetial a where itemtype='0' and a.goodsId=? order by gdetialId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(goodsid);
		return find(hqlBuff.toString(),values.toArray());
	}
	@Override
	public List<GoodsDetial> findByType(Integer goodsid) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsDetial a where itemtype='1' and  a.goodsId=? order by a.gtItem.itemname");
		List<Object> values = new ArrayList<Object>();
		values.add(goodsid);
		return find(hqlBuff.toString(),values.toArray());
	}
	@Override
	public List<GoodsDetial> getGoodByItemType(String gtypeID) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsDetial a where a.gtItem.gtitemId= ? order by gdetialId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(Integer.parseInt(gtypeID));
		return find(hqlBuff.toString(),values.toArray());
	}
	@Override
	public List<GoodsDetial> getItemCount(String itemtype, String itemid,String goodsId) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsDetial a where a.goodsId=? and a.itemtype= ? and a.gtItem.gtitemId= ? order by gdetialId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(Integer.parseInt(goodsId));
		values.add(itemtype);
		values.add(Integer.parseInt(itemid));
		return find(hqlBuff.toString(),values.toArray());
	}
	@Override
	public List<GoodsDetial> getTypeCount(String goodsId) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsDetial a where itemtype='1' and  a.goodsId=?");
		List<Object> values = new ArrayList<Object>();
		values.add(Integer.parseInt(goodsId));
		return find(hqlBuff.toString(),values.toArray());
	}

}
