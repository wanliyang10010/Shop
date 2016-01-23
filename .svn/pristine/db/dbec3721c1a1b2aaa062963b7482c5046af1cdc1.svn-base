package cn.xaut.shop.service.impl;

import java.util.ArrayList;
import java.util.List;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.dao.GoodsDao;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.Order;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.service.GoodsService;
import cn.xaut.shop.service.MessageService;
public class GoodsServiceImpl extends BaseServiceRImpl<Goods,Integer> implements  GoodsService {
	private GoodsDao goodsDao = null;
	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	public List<Goods> queryGoodsByCid(final int cid) {
		return null;
	}
	
	
	public Goods getCheck(Goods goods) {
		return  null;
	}
	
	
	//根据商品的ID查询出具体一条数据
	public List<Goods> queryGoodsByGid(final int gid) {
		return  null;
	}

	
	//根据用户id查询历史购入商品
	public List<Goods> queryGoodsByGuserid(final int guserid) {
		return  null;
	}
	
	public Goods queryGoodsByid(int id) {
		return  null;
	}
	
	@Override
	public Page<Goods> getListPrice(Page<Goods> page,String p,String keyword) {
		 return goodsDao.findByPrice(page, p, keyword);
	}

	public List<Goods> search(String sql,String keyword) 
	{
		return  null;
	}

	public Page<Goods> getList(Page<Goods> page,String keyword) {
		return goodsDao.findByKey(page, keyword);
	}
	
	public Page<Goods> getList(Page<Goods> page,String keyword,Integer sid) {
		return goodsDao.findByKeyShopId(page, keyword,sid);
	}

	@Override
	public Page<Goods> getShop(Page<Goods> page,Integer sid) {
		return goodsDao.queryByShopId(page,sid);
	}

	@Override
	public Page<Goods> getListDH(Page<Goods> page,String key, String stype,Integer sid) {
		return goodsDao.findDHByShopId(page, key, stype, sid);
	}

	@Override
	public Page<Goods> getListSH(Page<Goods> page,int sid) {
		return goodsDao.findHotByShopId(page, sid);
	}


	@Override
	public Page<Goods> getListH(Page<Goods> page) {
		return goodsDao.queryAllHot(page);
	}


	@Override
	public Page<Goods> getListD(Page<Goods> page) {
		return goodsDao.queryDiscount(page);
	}


	@Override
	public Page<Goods> getListSD(Page<Goods> page, String date, Integer shopId) {
		return goodsDao.queryShopDiscount(page,date,shopId);
	}


	@Override
	public List<Goods>  getById(Integer goodsid) {
		// TODO Auto-generated method stub
		return  goodsDao.findByGoodsId(goodsid);
	}


	@Override
	public Page<Goods> getListSale(Page<Goods> page,String key) {
		return goodsDao.querySale(page,key);
	}

	@Override
	public Page<Goods> getListType(Page<Goods> page, String type) {
		return goodsDao.queryType(page,type);
	}

	public List<Goods>  getGoodsMoeny(Integer shopid, String key) {
			return goodsDao.getGoodsList(shopid,key);
	}

	@Override
	public Page<Goods> getSaleGoods(Page<Goods> page, Integer shopid, String key) {
		return goodsDao.findByKeyShopId(page,key,shopid);
	}

	@Override
	public double getTotal(List<Goods> list) {
		double totalmoney=0;
		if(list!=null&&list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				Goods goods=list.get(i);
				totalmoney=totalmoney+goods.getPrice();
			}
		}
		return totalmoney;
	}

	 //dwj查询所有商品
	@Override
	public Page<Goods> getListAllGood(Page<Goods> page) {
		// TODO Auto-generated method stub
		return goodsDao.findByAllGood(page);
	}
	//dwj关键字查询
	@Override
	public List<Goods> findGoodsInfoKeyWord(String keyWord) {
		// TODO Auto-generated method stub
		return goodsDao.findGoodsInfoKeyWord(keyWord);
	}
	//list集合id查询
	@Override
	public List<Goods> getShopSet(Integer sid) {
		// TODO Auto-generated method stub
		return goodsDao.getShopSet(sid);
	}
	//通过good的 goodsid获得goods
	public Goods getGoodsByGoodsId(Integer goodsid){
		return goodsDao.findGoodsByGoodsId(goodsid);
	}

	@Override
	public Integer getByType(String gtypeID) {
		List<Goods> list=goodsDao.findGoodsByTypeId(gtypeID);
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
	public Page<Goods> getByShopKey(Page<Goods> page, String shopId, String key) {
		// TODO Auto-generated method stub
		return goodsDao.findByShopKey(page,shopId,key);
	}

	@Override
	public Page<Goods> getByState(Page<Goods> page) {
		// TODO Auto-generated method stub
		return goodsDao.findByState(page);
	}

	@Override
	public Page<Goods> getTop(Page<Goods> page) {
		// TODO Auto-generated method stub
		return goodsDao.findTop(page);
	}

	@Override
	public Page<Goods> ViewShop(Page<Goods> page, Integer sid) {
		// TODO Auto-generated method stub
		return goodsDao.queryViewShopId(page,sid);
	}

	@Override
	public List<Goods> getGoodsTypeMoeny(Integer shopid, String typeid, String key) {
		return goodsDao.getGoodsTypeList(shopid,typeid,key);
	}

	@Override
	public void updateGoods(Goods good, MessageService messageService,
			UserInfo userinfo, Shop shop) {
		// TODO Auto-generated method stub
		goodsDao.update(good);
		messageService.sendMessage(messageService,"您店铺的商品已被管理员下架，请点击查看！", userinfo.getUserinfoId(), shop.getUserinfo().getUserinfoId(),
				"goodsAction_queryById.action", "shopId", shop.getShopId());
	}

	@Override
	public List<Goods>  getByType(Integer goodsid, Integer typeid) {
		// TODO Auto-generated method stub
		List<Goods> list=goodsDao.getType(typeid,goodsid);
		List<Goods> listnew= new ArrayList<Goods>();
		if(list!=null&&list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
			Goods goods=list.get(i);
				if(i<4)
				{
					listnew.add(goods);
				}
				else
				{
					return listnew;
				}
			}
		}
		return listnew;
	}

	@Override
	public Page<Goods> getListShand(Page<Goods> page, String keyword) {
		// TODO Auto-generated method stub
		 return goodsDao.findShandByKey(page, keyword);
	}

	@Override
	public Page<Goods> getShand(Page<Goods> page) {
		// TODO Auto-generated method stub
		return goodsDao.findShand(page);
	}

	@Override
	public Page<Goods> getListShandByKey(Page<Goods> page, String keyword,
			String type) {
		// TODO Auto-generated method stub
		return goodsDao.findShandByType(page, keyword,type);
	}
}
