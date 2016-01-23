package cn.xaut.shop.service.impl;
import java.util.List;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.StageGoodsDao;
import cn.xaut.shop.pojo.StageGoods;
import cn.xaut.shop.pojo.StageOrder;
import cn.xaut.shop.service.StageGoodsService;
public class StageGoodsServiceImpl extends BaseServiceRImpl<StageGoods,Integer> implements StageGoodsService{

	private StageGoodsDao stageGoodsDao = null;
	public void setStageGoodsDao(StageGoodsDao stageGoodsDao) {
		this.stageGoodsDao = stageGoodsDao;
	}

	@Override
	 public Page<StageGoods> findItem(Page<StageGoods> page,String itemname) {
		return stageGoodsDao.findItemByName(page,itemname);
	}


	@Override
	public Page<StageGoods> getList(Page<StageGoods> page, String key) {
		key="%"+key+"%";
		return stageGoodsDao.queryByKey(page, key);
	}


	@Override
	public Page<StageGoods> queryAll(Page<StageGoods> page) {
		return stageGoodsDao.find(page);
	}

	@Override
	public Page<StageGoods> getGoods(Page<StageGoods> page, String key) {
		key="%"+key+"%";
		return stageGoodsDao.findItemByKey(page, key);
	}

	@Override
	public Integer getBygoodsname(String goodsname) {
		// TODO Auto-generated method stub
		List<StageGoods> list=stageGoodsDao.getCount(goodsname);
		if(list!=null&&list.size()>0)
		{
			return list.size();
		}
		else
		{
			return 0;
		}
	}
}
