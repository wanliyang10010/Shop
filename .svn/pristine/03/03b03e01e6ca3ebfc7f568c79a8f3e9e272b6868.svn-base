package cn.xaut.shop.service.impl;

import java.util.List;

import cn.xaut.shop.dao.DiscountDao;
import cn.xaut.shop.pojo.Discount;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.service.DiscountService;
import cn.xaut.shop.service.GoodsService;

public class DiscountServiceImpl extends BaseServiceRImpl<Discount,Integer> implements DiscountService{
	private DiscountDao discountDao = null;
	public void setDiscountDao(DiscountDao discountDao) {
		this.discountDao = discountDao;
	}
	
	@Override
	public Discount getModel(Integer goodsid) {
		   List<Discount> accounts = discountDao.findByGoodsId(goodsid);
		   if(accounts != null&&accounts.size()>0)
		   {
			   return accounts.get(0);
		   }
		   else
		   {
			  return  null;
		   }
	}

	@Override
	public List<Discount> getListD(String date) {
		    date=date.replace("/", "-");
		   List<Discount> accounts =discountDao.findByDate(date);
		   if(accounts != null&&accounts.size()>0)
		   {
			   return accounts;
		   }
		   else
		   {
			  return  null;
		   }
	}

	@Override
	public List<Discount> getListSD(String date, int sid) {
		   List<Discount> accounts = getListD(date);
		   if(accounts != null&&accounts.size()>0)
		   {
			   for(int i=0;i<accounts.size();i++)
			   {
				   Discount dis=accounts.get(i);
				   if(dis.getShop().getShopId()!=sid)
				   {
					   accounts.remove(i);
				   }
			   }
			   return accounts;
		   }
		   else
		   {
			  return  null;
		   }
	}

	@Override
	public Discount saveDiscount(Discount model, GoodsService goodsService,
			Goods good) {
		// TODO Auto-generated method stub
		model=discountDao.add(model);
		good.setDiscount(model);
		goodsService.update(good);
		return null;
	}

	@Override
	public void deleteDiscount(Integer id, GoodsService goodsService,
			Goods good) {
		// TODO Auto-generated method stub
		goodsService.update(good);
		discountDao.deleteById(id);
	}


}
