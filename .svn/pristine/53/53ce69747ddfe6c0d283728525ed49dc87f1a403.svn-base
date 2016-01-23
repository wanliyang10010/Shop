package cn.xaut.shop.dao.impl;
import java.util.ArrayList;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.GoodsDao;
import cn.xaut.shop.dao.GoodsStockDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.GoodsStock;
import cn.xaut.shop.pojo.GoodsType;

public class GoodsStockDaoImpl extends HibernateRepository<GoodsStock,Integer> implements GoodsStockDao{

	@Override
	public Page<GoodsStock> queryAll(Page<GoodsStock> page,String gid) {
                                  
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsStock a where a.goodsId=? order by a.goodstockId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(Integer.parseInt(gid));
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public List<GoodsStock> queryCount(String gid, String goodstype) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsStock a where a.goodsId=? and a.goodstype =? order by a.goodstockId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(Integer.parseInt(gid));
		values.add(goodstype);
		return find(hqlBuff.toString(),values.toArray());
	}

	@Override
	public List<GoodsStock> GetList(Integer gid) {
		// TODO Auto-generated method stub
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsStock a where a.goodsId=? order by a.goodstype desc");
		List<Object> values = new ArrayList<Object>();
		values.add(gid);
		return find(hqlBuff.toString(),values.toArray());
	}

	@Override
	public GoodsStock findbyGoodstype(Integer goodsid, String property) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsStock gs WHERE gs.goodsId = ? AND gs.goodstype = ?");
		List<Object> values = new ArrayList<Object>();
		values.add(goodsid);
		values.add(property);
		List<GoodsStock> list = find(hqlBuff.toString(),values.toArray());
		if(list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

	
}
