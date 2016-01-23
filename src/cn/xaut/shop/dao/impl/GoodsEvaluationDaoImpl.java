package cn.xaut.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.GoodsEvaluationDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.GoodsEvaluation;
import cn.xaut.shop.pojo.UserPoint;

public class GoodsEvaluationDaoImpl extends HibernateRepository<GoodsEvaluation,Integer> implements
GoodsEvaluationDao{
	public GoodsEvaluationDaoImpl() {
		super();
	}
	@Override
	public Page<GoodsEvaluation> findByGoodsId(Page<GoodsEvaluation> page,
			int goodid) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsEvaluation a WHERE  a.goods.goodsid =? order by a.evaluationTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(goodid);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}
	
	public List<GoodsEvaluation>  getListByUserIdAndShopId(int shopid) {
		String sql = "";
		sql = "FROM GoodsEvaluation a WHERE  a.shop = '"+shopid+"' and userinfo is not null order by a.evaluationTime desc";
		return find(sql);	
	}
	public List<GoodsEvaluation>  getListByUserIdAndCheckId(int userid) {
		String sql = "";
		sql = "FROM GoodsEvaluation a WHERE  a.userinfo = '"+userid+"' and checkuserinfo is not null order by a.evaluationTime desc";
		return find(sql);	
	}
	public List<GoodsEvaluation>  getListByUserId(int userid) {
		String sql = "";
		sql = "FROM GoodsEvaluation a WHERE  a.userinfo = '"+userid+"' order by a.evaluationTime desc";
		return find(sql);	
	}

	public List<GoodsEvaluation>  getGoodsEvaluationByordersonId(int ordersonId) {
		String sql = "";
		sql = "FROM GoodsEvaluation a WHERE  a.orderSon = '"+ordersonId+"' order by a.evaluationTime desc";
		return find(sql);	
	}
	
	public Page<GoodsEvaluation> getListByUserIdAndShopId(Page<GoodsEvaluation> page,int shopid) {
		StringBuffer hqlBuff = new StringBuffer(
				"select a from GoodsEvaluation as a where a.shop.shopId= ? and userinfo is not null order by a.evaluationTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(shopid);		
        Page<GoodsEvaluation> p=findPage(page,hqlBuff.toString(), values.toArray());
		return p;
	}
	
	public Page<GoodsEvaluation> getListByUserIdAndCheckId(Page<GoodsEvaluation> page,int userid) {
		StringBuffer hqlBuff = new StringBuffer(
				"select a from GoodsEvaluation as a where a.userinfo.userinfoId= ?  and checkuserinfo is not null order by a.evaluationTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(userid);		
        Page<GoodsEvaluation> p=findPage(page,hqlBuff.toString(), values.toArray());
		return p;
	}
	
	public Page<GoodsEvaluation> getListByUserId(Page<GoodsEvaluation> page,int userid) {
		StringBuffer hqlBuff = new StringBuffer(
				"select a from GoodsEvaluation as a where a.userinfo.userinfoId= ? order by a.evaluationTime desc");
		List<Object> values = new ArrayList<Object>();
		values.add(userid);		
        Page<GoodsEvaluation> p=findPage(page,hqlBuff.toString(), values.toArray());
		return p;
	}
	
	
	@Override
	public List<GoodsEvaluation> getListByGoodId(int goodid) {
		String sql = "";
		sql = "FROM GoodsEvaluation a WHERE  a.goods.gid = '"+goodid+"'  order by a.evaluationTime desc";
		return find(sql);
		
	}
}
