package cn.xaut.shop.action;
import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.GoodsPicture;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UploadFile;

@SuppressWarnings("serial")
public class GoodsPictureAction extends BaseAction<GoodsPicture> {
	private UploadFile uploadFile;
	public UploadFile getUploadFile() {
		return uploadFile; 
	}

	public void setUploadFile(UploadFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	public String query() 
	{
		Goods goods=(Goods)session.get("goodsAdd");
		page=goodsPictureService.queryAll(page,goods.getGoodsid());
		if(page!=null&&page.getTotalItems()>0)
		  {
			  request.put("msg", "");
		  }
		  else
		  {
			  request.put("msg", "该商品尚未添加商品图片！");
		  }
		request.put("page", page);
		return "list";
	}
	
	public String listfile()
	{
		String goodsID=ServletActionContext.getRequest().getParameter("goodId");
		Goods goods=goodsService.get(Integer.parseInt(goodsID));
		session.put("goodsAdd",goods);
		page=goodsPictureService.queryAll(page,Integer.parseInt(goodsID));
		if(page!=null&&page.getTotalItems()>0)
		  {
			  request.put("msg", "");
		  }
		  else
		  {
			  request.put("msg", "该商品尚未添加商品图片！");
		  }
		request.put("page", page);
		return "list";
	}
	
	public String save() {
		Goods goods=(Goods)session.get("goodsAdd");
		Shop shop= (Shop)session.get("shop");
		String filename=uploadFile.getItemFileName();
		String filePath ="/upload/shop/shop"+shop.getShopId()+"/goods"+goods.getGoodsid();
		//String newName1=fileUploadUtil.uploadFile(uploadFile.getItem(),filename,filePath);
		String newName=fileUploadUtil.uploadFile(uploadFile.getItem(),filename,filePath);
		model.setName(filename);								   
		model.setUrl(filePath+"/"+newName);
		model.setGid(goods.getGoodsid());
		model.setType("0");
		goodsPictureService.save(model);
		return "query";
	}
	
	public String updateGoods()
	{
		Integer id=Integer.parseInt(ServletActionContext.getRequest().getParameter("fileid"));
		GoodsPicture goodsPicture=goodsPictureService.get(id);
		Goods goods=(Goods)session.get("goodsAdd");
		goods.setGoodsPicture(goodsPicture);
		goodsService.update(goods);
		jsonMap.put("data", "right");
		return "json";
	}
	
	
	public String updatePicture()
	{
		Integer id=Integer.parseInt(ServletActionContext.getRequest().getParameter("fileid"));
		GoodsPicture goodsPicture=goodsPictureService.get(id);
		if(goodsPicture.getType().equals("0"))
		{
			goodsPicture.setType("1");
		}
		else
		{
			goodsPicture.setType("0");
		}
		goodsPictureService.update(goodsPicture);
		jsonMap.put("data", "right");
		return "json";
	}
	
	public String delete()
	{
		Integer id=Integer.parseInt(ServletActionContext.getRequest().getParameter("fileid"));
		GoodsPicture goodsPicture=goodsPictureService.get(id);
		fileUploadUtil.delete(goodsPicture.getUrl());
		goodsPictureService.delete(id);
		jsonMap.put("data", "right");
		return "json";
	}
	
	
	
	public String updateGoodsAdmin()
	{
		Integer id=Integer.parseInt(ServletActionContext.getRequest().getParameter("fileid"));
		GoodsPicture goodsPicture=goodsPictureService.get(id);
		Goods goods=(Goods)session.get("goodsAdd");
		goods.setGoodsPicture(goodsPicture);
		goodsService.update(goods);
		jsonMap.put("data", "right");
		return "json";
		
	}
	
	
	public String updatePictureAdmin()
	{
		Integer id=Integer.parseInt(ServletActionContext.getRequest().getParameter("fileid"));
		GoodsPicture goodsPicture=goodsPictureService.get(id);
		if(goodsPicture.getType().equals("0"))
		{
			goodsPicture.setType("1");
		}
		else
		{
			goodsPicture.setType("0");
		}
		goodsPictureService.update(goodsPicture);
		jsonMap.put("data", "right");
		return "json";
	}
	
	public String deleteAdmin()
	{
		Integer id=Integer.parseInt(ServletActionContext.getRequest().getParameter("fileid"));
		GoodsPicture goodsPicture=goodsPictureService.get(id);
		fileUploadUtil.delete(goodsPicture.getUrl());
		goodsPictureService.delete(id);
		jsonMap.put("data", "right");
		return "json";
	}
	
	public String listfileAdmin()
	{
		String goodsID=ServletActionContext.getRequest().getParameter("goodId");
		Goods goods=goodsService.get(Integer.parseInt(goodsID));
		session.put("goodsAdd",goods);
		page=goodsPictureService.queryAll(page,Integer.parseInt(goodsID));
		if(page!=null&&page.getTotalItems()>0)
		  {
			  request.put("msg", "");
		  }
		  else
		  {
			  request.put("msg", "该商品尚未添加商品图片！");
		  }
		request.put("page", page);
		return "listAdmin";
	}
	
	
	public String queryAdmin() 
	{
		Goods goods=(Goods)session.get("goodsAdd");
		page=goodsPictureService.queryAll(page,goods.getGoodsid());
		if(page!=null&&page.getTotalItems()>0)
		  {
			  request.put("msg", "");
		  }
		  else
		  {
			  request.put("msg", "该商品尚未添加商品图片！");
		  }
		request.put("page", page);
		return "listAdmin";
	}
	
}
