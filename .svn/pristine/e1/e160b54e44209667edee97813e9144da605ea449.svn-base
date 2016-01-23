package cn.xaut.shop.service.impl;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.GoodsDetialDao;
import cn.xaut.shop.pojo.GoodsDetial;
import cn.xaut.shop.service.GoodsDetialService;
public class GoodsDetialServiceImpl extends BaseServiceRImpl<GoodsDetial,Integer> implements  GoodsDetialService {
	private GoodsDetialDao goodsDetialDao = null;
	public void setGoodsDetialDao(GoodsDetialDao goodsDetialDao) {
		this.goodsDetialDao = goodsDetialDao;
	}
	@Override
	public Page<GoodsDetial> queryAll(Page<GoodsDetial> page, Integer goodsId) {
		return goodsDetialDao.find(page, goodsId);
	}
	@Override
	public Page<GoodsDetial> GetList(Page<GoodsDetial> page, String key,
			String goodsID) {
		return goodsDetialDao.findByKey(page, key,goodsID);
	}
	@Override
	public List<GoodsDetial> getList(Integer goodsid) {
		// TODO Auto-generated method stub
		return goodsDetialDao.findByGoods(goodsid);
	}
	@Override
	public List<GoodsDetial> getListType(Integer goodsid) {
		// TODO Auto-generated method stub
		return goodsDetialDao.findByType(goodsid);
	}
	@Override
	public Integer getGoodByItemType(String gtypeID) {
		List<GoodsDetial> list=goodsDetialDao.getGoodByItemType(gtypeID);
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
	public Integer getItemCount(String itemtype, String itemid,String goodsId) {
		List<GoodsDetial> list=goodsDetialDao.getItemCount(itemtype,itemid,goodsId);
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
	public boolean getTypeCount(String goodsId,String itemtype) {
		// TODO Auto-generated method stub
		if(itemtype.equals("1"))
		{
			List<GoodsDetial> list=goodsDetialDao.getTypeCount(goodsId);
			if(list!=null&&list.size()<2)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		else
		{
			return true;
		}
		
	}
}
