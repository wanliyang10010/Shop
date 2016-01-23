package cn.xaut.shop.service.impl;

import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.GoodsDao;
import cn.xaut.shop.dao.GoodsStockDao;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.GoodsStock;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.service.GoodsService;
import cn.xaut.shop.service.GoodsStockService;
public class GoodsStockServiceImpl extends BaseServiceRImpl<GoodsStock,Integer> implements  GoodsStockService {
	private GoodsStockDao goodsStockDao = null;
	public void setGoodsStockDao(GoodsStockDao goodsStockDao) {
		this.goodsStockDao = goodsStockDao;
	}
	@Override
	public Page<GoodsStock> queryAll(Page<GoodsStock> page,String gid) {
		// TODO Auto-generated method stub
		return goodsStockDao.queryAll(page,gid);
	}
	@Override
	public boolean queryCount(String gid, String goodstype) {
		// TODO Auto-generated method stub
		List<GoodsStock> list=goodsStockDao.queryCount(gid,goodstype);
		if(list!=null&&list.size()>0)
		{
			System.out.println(list.size());
			return false;
		}
		else
		{
			return true;
		}
	}
	@Override
	public List<GoodsStock> getList(Integer gid) {
		// TODO Auto-generated method stub
		return goodsStockDao.GetList(gid);
	}
	@Override
	public Integer queryStockAll(String gid) {
		List<GoodsStock> list=goodsStockDao.GetList(Integer.parseInt(gid));
		if(list!=null&&list.size()>0)
		{
			Integer count=0;
			for(int i=0;i<list.size();i++)
			{
				GoodsStock goodsStock=list.get(i);
				count=count+goodsStock.getAmount();
			}
			return count;
		}
		else
		{
			return 0;
		}
	}
	@Override
	public void addStock(GoodsStock goodsStock, GoodsService goodsService,
			Goods goods) {
		// TODO Auto-generated method stub
		goodsStockDao.add(goodsStock);
		goodsService.update(goods);
	}
	@Override
	public void updateStock(GoodsStock goodsStock, GoodsService goodsService,
			Goods goods) {
		// TODO Auto-generated method stub
		goodsStockDao.update(goodsStock);
		goodsService.update(goods);
	}
	@Override
	public void deleteStock(GoodsStock goodsStock, GoodsService goodsService,
			Goods goods) {
		// TODO Auto-generated method stub
		goodsStockDao.delete(goodsStock);
		goods.setAmount(queryStockAll(goodsStock.getGoodsId().toString()));
		goodsService.update(goods);
	}

	
}
