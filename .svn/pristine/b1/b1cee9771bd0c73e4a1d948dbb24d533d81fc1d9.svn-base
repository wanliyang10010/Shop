package cn.xaut.shop.dao.impl;
import java.util.ArrayList;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.GoodsPictureDao;
import cn.xaut.shop.modules.repository.hibernate3.HibernateRepository;
import cn.xaut.shop.pojo.GoodsPicture;

public class GoodsPictureDaoImpl extends HibernateRepository<GoodsPicture,Integer> implements
GoodsPictureDao{

	@Override
	public Page<GoodsPicture> find(Page<GoodsPicture> page, Integer goodsId) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsPicture a where a.gid=? order by a.fileid desc");
		List<Object> values = new ArrayList<Object>();
		values.add(goodsId);
		return findPage(page,hqlBuff.toString(),values.toArray());
	}

	@Override
	public List<GoodsPicture> findByType(Integer goodsid) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsPicture a where a.type='1' and a.gid=? order by a.fileid desc");
		List<Object> values = new ArrayList<Object>();
		values.add(goodsid);
		return find(hqlBuff.toString(),values.toArray());
	}

	@Override
	public List<GoodsPicture> findByGoodsId(Integer goodsid) {
		StringBuffer hqlBuff = new StringBuffer("FROM GoodsPicture a where a.gid=? order by a.fileid desc");
		List<Object> values = new ArrayList<Object>();
		values.add(goodsid);
		return find(hqlBuff.toString(),values.toArray());
	}

}
