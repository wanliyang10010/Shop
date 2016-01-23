package cn.xaut.shop.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.GoodsDetial;
import cn.xaut.shop.pojo.GoodsEvaluation;
import cn.xaut.shop.pojo.GoodsPicture;
import cn.xaut.shop.pojo.GoodsStock;
import cn.xaut.shop.pojo.MarginItem;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.util.DecorationFactory;

public class ViewProductAction extends BaseAction<Goods>{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 6773477958854687413L;
	  Page<Shop> pageShop=new Page<Shop>();
	  Page<GoodsEvaluation> pageEva=new Page<GoodsEvaluation>();
	  //这个listShop在这里没有，已经配置到ViewProductActionShopSearch类中去呢
       public String listShop()
       {
    	   String keyword=ServletActionContext.getRequest().getParameter("keyword");
    	   //System.out.println("pageshop------"+pageShop.getPageSize());
    	   //System.out.println("page------"+page.getPageSize());
    	   if(page.getPageSize()==5)
    	   {
    		   pageShop.setPageSize(12);
    	   }
    	   else
    	   {
    		   pageShop.setPageSize(page.getPageSize());
    	   }
		   pageShop= shopService.getListV(pageShop,keyword);
		   if(pageShop!=null&&pageShop.getTotalItems()>0)
		   {
			   request.put("msgs", "");
		   }
		   else
		   {
			   request.put("msgs", "未查找到符合条件的店铺");
		   }
		   request.put("page", pageShop);
		   return "listShop";
       }
       
     
       
       public String listGoods()
       {
    	   String keyword=ServletActionContext.getRequest().getParameter("keyword");
    	   String sortype=ServletActionContext.getRequest().getParameter("sortype");
    	   if(page.getPageSize()==5)
    	   {
    		   page.setPageSize(12);
    	   }
		   page= goodsService.getList(page,keyword);
		   if(page!=null&&page.getTotalItems()>0)
		   {
			   request.put("msg", "");
		   }
		   else
		   {
			   request.put("msg", "未查找到符合条件的商品");
		   }
		   request.put("sortype", sortype);
    	   request.put("page", page);
    	   return "list";
       }
       
       public String listShand()
       {
    	   String keyword=ServletActionContext.getRequest().getParameter("keyword");
    	   String sortype=ServletActionContext.getRequest().getParameter("sortype");
    	   if(page.getPageSize()==5)
    	   {
    		   page.setPageSize(12);
    	   }
		   page= goodsService.getListShand(page,keyword);
		   if(page!=null&&page.getTotalItems()>0)
		   {
			   request.put("msg", "");
		   }
		   else
		   {
			   request.put("msg", "未查找到符合条件的商品");
		   }
		   request.put("sortype", sortype);
    	   request.put("page", page);
    	   List<MarginItem> listItem=marginItemService.query();
    	   request.put("listItem", listItem);
    	   return "listShand";
       }
       
       public String listShandByKey()
       {
    	   String keyword=ServletActionContext.getRequest().getParameter("keyword");
    	   String type=ServletActionContext.getRequest().getParameter("typeitem");
    	   if(page.getPageSize()==5)
    	   {
    		   page.setPageSize(12);
    	   }
		   page= goodsService.getListShandByKey(page,keyword,type);
		   if(page!=null&&page.getTotalItems()>0)
		   {
			   request.put("msg", "");
		   }
		   else
		   {
			   request.put("msg", "未查找到符合条件的商品");
		   }
    	   request.put("page", page);
    	   List<MarginItem> listItem=marginItemService.query();
    	   request.put("listItem", listItem);
    	   return "listShand";
       }
       
       public String getShand()
       {
    	   if(page.getPageSize()==5)
    	   {
    		   page.setPageSize(12);
    	   }
		   page= goodsService.getShand(page);
		   if(page!=null&&page.getTotalItems()>0)
		   {
			   request.put("msg", "");
		   }
		   else
		   {
			   request.put("msg", "未查找到符合条件的商品");
		   }
    	   request.put("page", page);
    	   List<MarginItem> listItem=marginItemService.query();
    	   request.put("listItem", listItem);
    	   return "listShand";
       }
       
       
       public String queryGoods()
       {
    	   if(page.getPageSize()==5)
    	   {
    		   page.setPageSize(12);
    	   }
		   page= goodsService.getList(page,"");
		   if(page!=null&&page.getTotalItems()>0)
		   {
			   request.put("msg", "");
		   }
		   else
		   {
			   request.put("msg", "未查找到符合条件的商品");
		   }
    	   request.put("page", page);
    	   return "list";
       }
       
       public String listSale()
       {
    	   String keyword=ServletActionContext.getRequest().getParameter("keyword");
    	   String sortype=ServletActionContext.getRequest().getParameter("sortype");
    	   if(page.getPageSize()==5)
    	   {
    		   page.setPageSize(12);
    	   }
		   page= goodsService.getListSale(page,keyword);
		   if(page!=null&&page.getTotalItems()>0)
		   {
			   request.put("msg", "");
		   }
		   else
		   {
			   request.put("msg", "未查找到符合条件的商品");
		   }
		   request.put("sortype", sortype);
    	   request.put("page", page);
    	   return "list";
       }
       
       public String listpricel()
       {
    	   String keyword=ServletActionContext.getRequest().getParameter("keyword");
    	   String sortype=ServletActionContext.getRequest().getParameter("sortype");
    	   if(page.getPageSize()==5)
    	   {
    		   page.setPageSize(12);
    	   }
    	   page= goodsService.getListPrice(page,"low",keyword);
    	   if(page!=null&&page.getTotalItems()>0)
		   {
			   request.put("msg", "");
		   }
		   else
		   {
			   request.put("msg", "未查找到符合条件的商品");
		   }
    	   request.put("sortype", sortype);
    	   request.put("page", page);
    	   return "list";
       }
       
       public String listpriceh()
       {
    	   String keyword=ServletActionContext.getRequest().getParameter("keyword");
    	   String sortype=ServletActionContext.getRequest().getParameter("sortype");
    	   if(page.getPageSize()==5)
    	   {
    		   page.setPageSize(12);
    	   }
    	   page= goodsService.getListPrice(page,"hight",keyword);
    	   if(page!=null&&page.getTotalItems()>0)
		   {
			   request.put("msg", "");
		   }
		   else
		   {
			   request.put("msg", "未查找到符合条件的商品");
		   }
    	   request.put("sortype", sortype);
    	   request.put("page", page);
    	   return "list";
       }
       

       public String productH()
       {
    	   if(page.getPageSize()==5)
    	   {
    		   page.setPageSize(12);
    	   }
    	   page= goodsService.getListH(page);
    	   if(page!=null&&page.getTotalItems()>0)
		   {
			   request.put("msg", "");
		   }
		   else
		   {
			   request.put("msg", "未查找到符合条件的商品");
		   }
    	   request.put("page", page);
    	   return "listh";
       }
       
       public String productD()
       {
    	   if(page.getPageSize()==5)
    	   {
    		   page.setPageSize(12);
    	   }
    	   page= goodsService.getListD(page);
    	   if(page!=null&&page.getTotalItems()>0)
		   {
			   request.put("msg", "");
		   }
		   else
		   {
			   request.put("msg", "未查找到符合条件的商品");
		   }
    	   request.put("page", page);
		   return "listd";
       }
       
       
       public String productSH()
       {
    	   String sid=ServletActionContext.getRequest().getParameter("sid");
    	   Shop shop= shopService.get(Integer.parseInt(sid));
    	   if(shop.getShopstate().equals("1"))
   		   {
    		   if(page.getPageSize()==5)
        	   {
        		   page.setPageSize(12);
        	   }
    		   page= goodsService.getListSH(page,Integer.parseInt(sid));
    		   if(page!=null&&page.getTotalItems()>0)
       		   {
    			   request.put("msg", "");
    		   }
    		   else
    		   {
    			   request.put("msg", "未查找到符合条件的商品");
    		   }
   		}
   		else
   		{
   			request.put("msg", "该店铺已被冻结");
   		}
    	   request.put("page", page);
    	   return "shop";
       }
       
       public String productSD()
       {
    		Date now = new Date();
    		SimpleDateFormat dateFormat = new SimpleDateFormat(
    				"yyyy/MM/dd HH:mm:ss");
    	   String sid=ServletActionContext.getRequest().getParameter("sid");
    	   Shop shop= shopService.get(Integer.parseInt(sid));
    	   if(shop.getShopstate().equals("1"))
   		   {
    		   if(page.getPageSize()==5)
        	   {
        		   page.setPageSize(12);
        	   }
    		   page= goodsService.getListSD(page,dateFormat.format(now),Integer.parseInt(sid));
    		   if(page!=null&&page.getTotalItems()>0)
    		   {
    			   request.put("msg", "");
    		   }
    		   else
    		   {
    			   request.put("msg", "未查找到符合条件的商品");
    		   }
   		}
   		else
   		{
   			request.put("msg", "该店铺已被冻结");
   		}
    	   request.put("page", page);
		   return "shop";
       }
       
       public String shop()
       {
    	 String sid=ServletActionContext.getRequest().getParameter("shopid");
    	 Shop shop= shopService.get(Integer.parseInt(sid));
    	 session.put("shopView", shop);
    	 if(shop.getShopstate().equals("1"))
   		 {
    		 if(page.getPageSize()==5)
      	   {
      		   page.setPageSize(12);
      	   }
    		page= goodsService.ViewShop(page,Integer.parseInt(sid));
    		if(page!=null&&page.getTotalItems()>0)
   		   {
   			   request.put("msg", "");
   			} else {
   				request.put("msg", "该店铺尚未添加商品");
   			}
   		}
   		else
   		{
   			request.put("msg", "该店铺已被冻结");
   		}
    	   request.put("page", page);
    	   return "shop";
       }
       
       public String evalution()
       {
    	   String gid=ServletActionContext.getRequest().getParameter("gid");
     	   Goods goods=goodsService.get(Integer.parseInt(gid));
     	   pageEva.setPageSize(page.getPageSize());
     	   pageEva.setPageNo(page.getPageNo());
     	   pageEva = goodsEvaluationService.getListByGoodId(pageEva,(Integer.parseInt(gid)));
     	   if(pageEva!=null&&pageEva.getTotalItems()>0)
 		   {
 			   request.put("msg", "");
 		   }
 		   else
 		   {
 			   request.put("msg", "该商品尚未有人评论");
 		   }
     	   request.put("goods", goods);
     	   request.put("tag", "evaluation");
     	   request.put("page", pageEva);
     	  return "productDetial";
       }
       
       public String detailorEva()
       {
    	  String gid=ServletActionContext.getRequest().getParameter("gid");
    	  String viewtag=ServletActionContext.getRequest().getParameter("viewtag");
    	  List<Goods> list=goodsService.getById(Integer.parseInt(gid));
    	  if(list!=null&&list.size()>0)
    	  {
    		  Goods goods=list.get(0);
    		  request.put("goods", goods);
    		  Shop shop= goods.getShop();
       	      request.put("shop", shop);
       	   List<GoodsPicture> listp=goodsPictureService.getList(Integer.parseInt(gid));
  	      request.put("GPictureListAll", listp);
		       List<GoodsPicture> listPicture=goodsPictureService.getPictureList(Integer.parseInt(gid));
  	      request.put("GPictureList", listPicture);
  	      List<GoodsStock> listItem=goodsStockService.getList(Integer.parseInt(gid));
  	      request.put("StockList", listItem);
  	      List<GoodsDetial> listDetial=goodsDetialService.getList(Integer.parseInt(gid));
	          request.put("GItemList", listDetial);
	          List<Goods> listGoods=goodsService.getByType(goods.getGoodsid(),goods.getTypeid());
    	      request.put("GoodList", listGoods);
       	      pageEva.setPageSize(page.getPageSize());
        	  pageEva.setPageNo(page.getPageNo());
        	  pageEva = goodsEvaluationService.getListByGoodId(pageEva,(Integer.parseInt(gid)));
        	   if(pageEva!=null&&pageEva.getTotalItems()>0)
    		   {
    			   request.put("msg1", "");
    		   }
    		   else
    		   {
    			   request.put("msg1", "该商品尚未有人评论");
    		   }
        	   request.put("page", pageEva);
       	      if(viewtag=="evaluation")
       	      {
	           	   request.put("tag", "evaluation");
       	      }
       	      else
       	      {
      	          request.put("tag", "detial");
       	      }
       	      request.put("msg", "");
    	  }
    	  else
    	  {
    		  request.put("msg", "该商品已下架");
    	  }
    	  return "product";
       }
       //打开商品
       public String product()
       {
    	  String gid=ServletActionContext.getRequest().getParameter("gid");
    	  List<Goods> list=goodsService.getById(Integer.parseInt(gid));
    	  if(list!=null&&list.size()>0)
    	  {
    		  Goods goods=list.get(0);
    		  request.put("goods", goods);
    		  List<GoodsPicture> listp=goodsPictureService.getList(Integer.parseInt(gid));
       	      request.put("GPictureListAll", listp);
    		  List<GoodsPicture> listPicture=goodsPictureService.getPictureList(Integer.parseInt(gid));
       	      request.put("GPictureList", listPicture);
       	      Shop shop= goods.getShop();
       	      request.put("shop", shop);
       	      List<GoodsStock> listItem=goodsStockService.getList(Integer.parseInt(gid));
       	      request.put("StockList", listItem);
       	      List<GoodsDetial> listDetial=goodsDetialService.getList(Integer.parseInt(gid));
    	      request.put("GItemList", listDetial);
    	      List<Goods> listGoods=goodsService.getByType(goods.getGoodsid(),goods.getTypeid());
    	      request.put("GoodList", listGoods);
    	      pageEva.setPageSize(page.getPageSize());
        	  pageEva.setPageNo(page.getPageNo());
        	  pageEva = goodsEvaluationService.getListByGoodId(pageEva,(Integer.parseInt(gid)));
        	   if(pageEva!=null&&pageEva.getTotalItems()>0)
    		   {
    			   request.put("msg", "");
    		   }
    		   else
    		   {
    			   request.put("msg", "该商品尚未有人评论");
    		   }
        	   request.put("tag", "detial");
        	   request.put("page", pageEva);
       	       request.put("msg", "");
    	  }
    	  else
    	  {
    		  request.put("msg", "该商品已下架");
    	  }
    	  return "product";
       }
       
       public String goodsDetial()
       {
    	   String gid=ServletActionContext.getRequest().getParameter("goodsid");
    	   Goods goods= goodsService.get(Integer.parseInt(gid));
    	   request.put("goods", goods);
    	   List<GoodsPicture> list=goodsPictureService.getList(Integer.parseInt(gid));
    	   request.put("GPictureList", list);
    	   List<GoodsDetial> listDetial=goodsDetialService.getList(Integer.parseInt(gid));
    	   request.put("GItemList", listDetial);
    	   request.put("tag", "detial");
    	   return "productDetial";
       }
       
       public String type()
       {
    	   String type=ServletActionContext.getRequest().getParameter("type");
    	   if(page.getPageSize()==5)
    	   {
    		   page.setPageSize(12);
    	   }
		   page= goodsService.getListType(page,type);
		   if(page!=null&&page.getTotalItems()>0)
		   {
			   request.put("msg", "");
		   }
		   else
		   {
			   request.put("msg", "未查找到符合条件的商品");
		   }
    	   request.put("page", page);
    	   List<MarginItem> listItem=marginItemService.query();
    	   request.put("listItem", listItem);
    	   return "listType";
       }

       
       public String MyShop()
       {
    	   page.setPageSize(3);
    	   page= goodsService.getListH(page);
    	   request.put("pageHot", page);
    	   page= goodsService.getListD(page);
    	   request.put("pageDiscount", page);
    	   page.setPageSize(2);
    	   page= goodsService.getListSale(page,"");
    	   request.put("pageSale", page);
    	   page.setPageSize(6);
    	   page= goodsService.getTop(page);
    	   request.put("pageTop", page);
    	   List<MarginItem> listItem=marginItemService.query();
    	   request.put("listItem", listItem);
    	   return "MyShop";
       }
       //布局分配
       
       //和商品图片页对应的Java代码 productPicture.jsp
       public void decoration_Picture(){
    	   String gid=ServletActionContext.getRequest().getParameter("gid");
    	   Goods goods= goodsService.get(Integer.parseInt(gid));
	 	   request.put("goods", goods);
	 	   List<GoodsPicture> list=goodsPictureService.getList(Integer.parseInt(gid));
	 	   request.put("GPictureList", list);
	 	   List<GoodsDetial> listDetial=goodsDetialService.getList(Integer.parseInt(gid));
	 	   request.put("GItemList", listDetial);
	 	   request.put("tag", "detial");
       }
       
       //和商品详情页对应的Java代码 productDetail.jsp
       public void decoration_Detail()
       {
    	   String gid=ServletActionContext.getRequest().getParameter("gid");
    	  List<Goods> list=goodsService.getById(Integer.parseInt(gid));
    	  if(list!=null&&list.size()>0)
    	  {
    		  Goods goods=list.get(0);
    		  request.put("goods", goods);
    		  List<GoodsPicture> listPicture=goodsPictureService.getPictureList(Integer.parseInt(gid));
       	      System.out.println(list.size());
       	      request.put("GPictureList", listPicture);
       	      Shop shop= goods.getShop();
       	      request.put("shop", shop);
       	      List<GoodsDetial> listItem=goodsDetialService.getListType(Integer.parseInt(gid));
       	      request.put("GDetialList", listItem);
       	      request.put("msg", "");
    	  }
    	  else
    	  {
    		  request.put("msg", "该商品已下架");
    	  }
       }
       //页面管理的跳转    
       public String decoration(){
    	   
    	   //String goodsid=ServletActionContext.getRequest().getParameter("gid");
    	   String shopid=ServletActionContext.getRequest().getParameter("sid");
    	   String outurl = DecorationFactory.generateUrl(Integer.parseInt(shopid));
    	   String path=ServletActionContext.getServletContext().getRealPath(outurl);
		   if(DecorationFactory.isExsistUrl(path)){
			   ServletActionContext.getRequest().setAttribute("inputid", shopid);
		   }else{
			   ServletActionContext.getRequest().setAttribute("inputid", "1");
		   }
		   decoration_Picture();
		   decoration_Detail();
		   return "listpage";
		}

}
