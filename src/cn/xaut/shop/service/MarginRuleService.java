package cn.xaut.shop.service;
import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.MarginRule;
public interface MarginRuleService extends BaseServiceR<MarginRule,Integer>{
   Page<MarginRule> getList(Page<MarginRule> page,String str,String key);
   Page<MarginRule> queryAll(Page<MarginRule> page);
   Page<MarginRule> findItem(Page<MarginRule> page,String type, String product);
   String getShopMargin(String shopcategory,String productcategory);
}
