package cn.xaut.shop.service.impl;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.DateItemDao;
import cn.xaut.shop.pojo.DateItem;
import cn.xaut.shop.service.DateItemService;
public class DateItemServiceImpl extends BaseServiceRImpl<DateItem,Integer> implements DateItemService{

	private DateItemDao dateItemDao = null;
	public void setDateItemDao(DateItemDao dateItemDao) {
		this.dateItemDao = dateItemDao;
	}

	@Override
	 public Page<DateItem> findItem(Page<DateItem> page,String itemname) {
		return dateItemDao.findItemByName(page,itemname);
	}


	@Override
	public Page<DateItem> getList(Page<DateItem> page, String key) {
		key="%"+key+"%";
		return dateItemDao.findItemByKey(page, key);
	}


	@Override
	public Page<DateItem> queryAll(Page<DateItem> page) {
		return dateItemDao.find(page);
	}
}
