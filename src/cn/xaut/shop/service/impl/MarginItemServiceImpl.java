package cn.xaut.shop.service.impl;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.MarginItemDao;
import cn.xaut.shop.pojo.MarginItem;
import cn.xaut.shop.service.MarginItemService;

public class MarginItemServiceImpl extends BaseServiceRImpl<MarginItem,Integer> implements MarginItemService{

	private MarginItemDao marginItemDao = null;
	public void setMarginItemDao(MarginItemDao marginItemDao) {
		this.marginItemDao = marginItemDao;
	}

	
	 public Page<MarginItem> findItem(Page<MarginItem> page,String itemname) {
		 return marginItemDao.findName(page,itemname);
		}


	@Override
	public Page<MarginItem> getList(Page<MarginItem> page, String key) {
		key="%"+key+"%";
		return marginItemDao.findByKey(page, key);
	}


	@Override
	public Page<MarginItem> queryAll(Page<MarginItem> page) {
		return marginItemDao.find(page);
	}
}
