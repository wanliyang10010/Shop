package cn.xaut.shop.service.impl;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.GoodsTypeDao;
import cn.xaut.shop.pojo.GoodsType;
import cn.xaut.shop.service.GoodsTypeService;
public class GoodsTypeServiceImpl extends BaseServiceRImpl<GoodsType,Integer> implements  GoodsTypeService {
	private GoodsTypeDao goodsTypeDao = null;
	public void setGoodsTypeDao(GoodsTypeDao goodsTypeDao) {
		this.goodsTypeDao = goodsTypeDao;
	}
	@Override
	public Page<GoodsType> GetList(Page<GoodsType> page, String key,String shopId) {
		return goodsTypeDao.findByKey(page, key,shopId);
	}
	@Override
	public Page<GoodsType> Query(Page<GoodsType> page,String shopId) {
		return goodsTypeDao.findAll(page,shopId);
	}
	@Override
	public List<GoodsType> getListByShopId(Integer shopId) {
		return goodsTypeDao.findByShopId(shopId);
	}
	@Override
	public GoodsType getGoodsTypeById(Integer gtypeId) {
		return goodsTypeDao.findGoodsTypeBygtypeId(gtypeId);
	}
	@Override
	public Integer getTypeCount(String shopId, String typename) {
		List<GoodsType> list=goodsTypeDao.getTypeCount(shopId,typename);
		if(list!=null&&list.size()>0)
		{
			return 1;
		}
		else
		{
			return 0;
		}
		
	}
	@Override
	public Integer getTypeCountUpdate(String shopId, String typename,String remark) {
		List<GoodsType> list=goodsTypeDao.getTypeCountUpdate(shopId,typename,remark);
		if(list!=null&&list.size()>0)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	

}
