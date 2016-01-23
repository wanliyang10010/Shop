package cn.xaut.shop.service.impl;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.PointsItemDao;
import cn.xaut.shop.pojo.PointsItem;
import cn.xaut.shop.service.PointsItemService;

public class PointsItemServiceImpl extends BaseServiceRImpl<PointsItem,Integer> implements PointsItemService{
	private PointsItemDao pointsItemDao = null;
	public void setPointsItemDao(PointsItemDao pointsItemDao) {
		this.pointsItemDao = pointsItemDao;
	}

	 public  Page<PointsItem> findItem(Page<PointsItem> page,String itemname) {
		 return pointsItemDao.findByName(page,itemname);
		}


	@Override
	public Page<PointsItem> getList(Page<PointsItem> page, String key) {
		key="%"+key+"%";
		return pointsItemDao.findByKey(page, key);
	}


	@Override
	public Page<PointsItem> queryAll(Page<PointsItem> page) {
		Page<PointsItem> pages = pointsItemDao.find(page);
		   if(pages != null&&pages.getTotalItems()>0)
		   {
			   return pages;
		   }
		   else
		   {
			  return  null;
		   }
	}
}
