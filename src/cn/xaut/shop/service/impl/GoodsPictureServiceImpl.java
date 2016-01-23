package cn.xaut.shop.service.impl;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.GoodsPictureDao;
import cn.xaut.shop.pojo.GoodsPicture;
import cn.xaut.shop.service.GoodsPictureService;

public class GoodsPictureServiceImpl extends BaseServiceRImpl<GoodsPicture,Integer> implements  GoodsPictureService{

	private GoodsPictureDao goodsPictureDao = null;
	public void setGoodsPictureDao(GoodsPictureDao goodsPictureDao) {
		this.goodsPictureDao = goodsPictureDao;
	}
	@Override
	public Page<GoodsPicture> queryAll(Page<GoodsPicture> page, Integer goodsId) {
		return goodsPictureDao.find(page,goodsId);
	}
	@Override
	public List<GoodsPicture> getPictureList(Integer goodsid) {
		return goodsPictureDao.findByType(goodsid);
	}
	@Override
	public List<GoodsPicture> getList(Integer goodsid) {
		return goodsPictureDao.findByGoodsId(goodsid);
	}
	
}
