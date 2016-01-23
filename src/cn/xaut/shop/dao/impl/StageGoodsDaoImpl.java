package cn.xaut.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.StageGoodsDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.StageGoods;

public class StageGoodsDaoImpl extends  HibernateRepository<StageGoods,Integer> implements
StageGoodsDao{
	public StageGoodsDaoImpl() {
		super();
	}

	@Override
	public Page<StageGoods> findItemByName(Page<StageGoods> page,String name) {
		StringBuffer hqlBuff = new StringBuffer("FROM StageGoods a WHERE a.itemname =? order by a.sgoodsId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(name);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<StageGoods> findItemByKey(Page<StageGoods> page, String key) {
		StringBuffer hqlBuff = new StringBuffer("FROM StageGoods a WHERE a.state='0' and a.goodsname like ? order by a.sgoodsId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<StageGoods> find(Page<StageGoods> page) {
		StringBuffer hqlBuff = new StringBuffer("FROM StageGoods a order by a.sgoodsId desc");
		List<Object> values = new ArrayList<Object>();
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public Page<StageGoods> queryByKey(Page<StageGoods> page, String key) {
		StringBuffer hqlBuff = new StringBuffer("FROM StageGoods a WHERE a.goodsname like ? order by a.sgoodsId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(key);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public List<StageGoods> getCount(String goodsname) {
		// TODO Auto-generated method stub
		StringBuffer hqlBuff = new StringBuffer("FROM StageGoods a WHERE a.goodsname = ? order by a.sgoodsId desc");
		List<Object> values = new ArrayList<Object>();
		values.add(goodsname);
		return find(hqlBuff.toString(),values.toArray());
	}
}
