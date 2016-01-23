package cn.xaut.shop.phoneAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.GoodsDetial;
import cn.xaut.shop.pojo.GoodsEvaluation;
import cn.xaut.shop.pojo.GoodsPicture;
import cn.xaut.shop.pojo.Shop;

public class ViewProductActionPhone extends BaseAction<Goods>{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 6773477958854687413L;
	/**/
	private Map<String,Object> responseJson = new HashMap<String,Object>();
	public Map<String, Object> getResponseJson() {
		return responseJson;
	}
	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}	
    /**/	  
	private Page<Goods> page=new Page<Goods>();	   
	public Page<Goods> getPage() {
		return page;
	}
	public void setPage(Page<Goods> page) {
		this.page = page;
	}
	private String keyword;//定义了回显的数据，使用了get\set方法	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	Page<GoodsEvaluation> pageEva=new Page<GoodsEvaluation>();	    
    public Page<GoodsEvaluation> getPageEva() {
	    return pageEva;
	}
	public void setPageEva(Page<GoodsEvaluation> pageEva) {
		this.pageEva = pageEva;
	}
	
	
	//商品查询了所有-已完成
    public String listGoodAll() throws IOException{ 
 	  page= goodsService.getListAllGood(page);
 	  List<Goods> list = new ArrayList<Goods>();
		  if(page.getTotalItems()!=0)
		  {   
			list = page.getResult();
			boolean isFristPage = page.isFirstPage();
			boolean isLastPage = page.isLastPage();			
			responseJson.put("attendViewActivity", list);
			responseJson.put("first", isFristPage);
			responseJson.put("next", isLastPage);		
		  }else{   			
			responseJson.put("attendViewActivity", list);
		 }
		    return "attendViewActivity"; 
    }
    
    //搜索商品-关键字搜索商品
    public String listGoods() throws IOException
    {
 	   String keyword=ServletActionContext.getRequest().getParameter("keyword"); 
 	   List<Goods> list = new ArrayList<Goods>();  		  
 	   list=goodsService.findGoodsInfoKeyWord(keyword);     	  
 	   if(list.size()>0){
 		   responseJson.put("ListGoods", list);	
 	   }else{ //list大小为0时返回界面"0";
 		   String ListGoods="0";
 		   responseJson.put("ListGoods", ListGoods);	
 	   }   	   			   		       	  
 	   return "ListGoods";
    }
         
    //搜索店铺-关键字搜索商品
    public String listShop()
    {
 	   String keyShopWord=ServletActionContext.getRequest().getParameter("keyShopWord"); 
 	   List<Shop> list = new ArrayList<Shop>();  		  
 	   list=shopService.findShopInfoKeyWord(keyShopWord);    	  
 	   if(list.size()>0){
 		   responseJson.put("ListShop", list);	
 	   }else{ //list大小为0时返回界面"0";
 		   String ListShop="0";
 		   responseJson.put("ListShop", ListShop);	
 	   }   	   			   		       	  
 	   return "ListShop";
    }
    
    //商品详情
    public String product()
    {
 	  String gid=ServletActionContext.getRequest().getParameter("id");
  	  List<Goods> list=goodsService.getById(Integer.parseInt(gid));
  	  //Goods goods=list.get(0); 
  	  //responseJson.put("goods", goods);////
  	  if(list!=null&&list.size()>0)
  	  {
  		  Goods goods=list.get(0);    		
  		  responseJson.put("goods", goods);////
  		  List<GoodsPicture> listPicture=goodsPictureService.getPictureList(Integer.parseInt(gid));       	     
     	  responseJson.put("GPictureList", listPicture);/////
     	  Shop shop= goods.getShop();
     	  responseJson.put("shop", shop);/////
     	  List<GoodsDetial> listItem=goodsDetialService.getListType(Integer.parseInt(gid));
     	  responseJson.put("GDetialList", listItem); ////       	     
  	  }else{
  		 responseJson.put("msgEmpty", "该商品已下架");///
  	  }
  	  return "product";    	
    }
    
    //店铺详情
    public String shop()
    {
 	 String sid=ServletActionContext.getRequest().getParameter("id");
 	 Shop shop= shopService.get(Integer.parseInt(sid));
 	 responseJson.put("shopView", shop);
 	 if(shop.getShopstate().equals("1"))
	 { 
 		page= goodsService.getShop(page,Integer.parseInt(sid));
 		List<Goods> list = new ArrayList<Goods>();
 		if(page!=null&&page.getTotalItems()>0)
		   {
 			list = page.getResult();
 			//boolean isFristPage = pageShop.isFirstPage();
  			//boolean isLastPage = pageShop.isLastPage();			
  			responseJson.put("listShop", list);
  			//responseJson.put("first", isFristPage);
  			//responseJson.put("next", isLastPage);
			} else {
				//request.put("msg", "该店铺尚未添加商品");
				String ListShopNot="该店铺尚未添加商品";
	 		    responseJson.put("ListShopNot", ListShopNot);
			}
		}else{
			//request.put("msg", "该店铺已被冻结");
			String ListShopEnd="该店铺已被冻结";
		    responseJson.put("ListShopEnd", ListShopEnd);
		}
 	   return "shop";
    }
    
    //特价商品
    public String productD() throws IOException
    {     	  
 	   page= goodsService.getListD(page);
 	   List<Goods> list = new ArrayList<Goods>();
 	   if(page!=null&&page.getTotalItems()>0)
		   {
 		   list = page.getResult();
	   		   boolean isFristPage = page.isFirstPage();
			   boolean isLastPage = page.isLastPage();			
			   responseJson.put("productBargainGoods", list);
			   responseJson.put("first", isFristPage);
			   responseJson.put("next", isLastPage);
		   }else{
			   responseJson.put("productBargainGoods", list);
		   }    	  
 	   return "productBargainGoods"; 	
    }
   
    //热卖商品
    public String productH()
    {    	  
 	   page= goodsService.getListH(page);
 	   List<Goods> list = new ArrayList<Goods>();
 	   if(page!=null&&page.getTotalItems()>0)
		   {
 		   list = page.getResult();
	   		   boolean isFristPage = page.isFirstPage();
			   boolean isLastPage = page.isLastPage();			
			   responseJson.put("productBestSeller", list);
			   responseJson.put("first", isFristPage);
			   responseJson.put("next", isLastPage);
		   }else{
			   responseJson.put("productBestSeller", list);
		   }    	  
 	   return "productBestSeller"; 
    }
    
    //商品评论
    public String goodsDetialComment()
    {
 	   String gid=ServletActionContext.getRequest().getParameter("id");
 	   Goods goods= goodsService.get(Integer.parseInt(gid));
 	   responseJson.put("goods", goods);
 	   //pageEva.setPageSize(page.getPageSize());
 	   pageEva = goodsEvaluationService.getListByGoodId(pageEva,(Integer.parseInt(gid)));
 	   List<GoodsEvaluation> list = new ArrayList<GoodsEvaluation>();
 	   if(pageEva!=null&&pageEva.getTotalItems()>0)
		   {
 		   list = pageEva.getResult();
	   		   //boolean isFristPage = pageEva.isFirstPage();
			   //boolean isLastPage = pageEva.isLastPage();			
			   responseJson.put("productDetialComment", list);
			   //responseJson.put("first", isFristPage);
			   //responseJson.put("next", isLastPage);
		   }
		   else
		   {
			   String noBabyComment="该商品尚未有人评论";
			   responseJson.put("noBabyComment", noBabyComment);
		   }
 	   //request.put("tag", "evaluation");
 	   //request.put("page", pageEva);
 	   return "productDetialComment";
 	       	   
    }
	
	
	
	
    
}
