package cn.xaut.shop.service.impl;

import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.GoodsTypeItemDao;
import cn.xaut.shop.pojo.GoodsTypeItem;
import cn.xaut.shop.service.GoodsTypeItemService;
public class GoodsTypeItemServiceImpl extends BaseServiceRImpl<GoodsTypeItem,Integer> implements  GoodsTypeItemService {
	private GoodsTypeItemDao goodsTypeItemDao = null;
	public void setGoodsTypeItemDao(GoodsTypeItemDao goodsTypeItemDao) {
		this.goodsTypeItemDao = goodsTypeItemDao;
	}
	@Override
	public Page<GoodsTypeItem> GetList(Page<GoodsTypeItem> page,Integer gtypeId, String key) {
		return goodsTypeItemDao.findByKey(page,gtypeId, key);
	}
	@Override
	public List<GoodsTypeItem> getListBytype(Integer typeId) {
		return goodsTypeItemDao.findByType(typeId);
	}
	@Override
	public Page<GoodsTypeItem> Query(Page<GoodsTypeItem> page, Integer gtypeid) {
		return goodsTypeItemDao.findAll(page,gtypeid);
	}
	@Override
	public GoodsTypeItem getGoodsTypeItemByGtitemId(Integer gtitemId) {
		return goodsTypeItemDao.findGoodsTypeItemByGtitemId(gtitemId);
	}
	@Override
	public Integer getTypeCount(String gtypeId, String itemname) {
		List<GoodsTypeItem> list=goodsTypeItemDao.getItemType(gtypeId,itemname);
		if(list!=null&&list.size()>0)
		{
			return list.size();
		}
		else
		{
			return 0;
		}
	}
	@Override
	public GoodsTypeItem getTypeCountUpdate(String gtypeId, String itemname) {
		List<GoodsTypeItem> list=goodsTypeItemDao.getItemType(gtypeId,itemname);
		if(list!=null&&list.size()>0)
		{
			return list.get(0);
		}
		else
		{
			return null;
		}
	}
	
	

}
