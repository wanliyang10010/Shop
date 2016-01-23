package cn.xaut.shop.action;
import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.pojo.StageGoods;
import cn.xaut.shop.pojo.UploadFile;

public class StageGoodsAction extends BaseAction<StageGoods>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5921026780852613639L;
	private UploadFile uploadFile;
	public UploadFile getUploadFile() {
		return uploadFile; 
	}

	public void setUploadFile(UploadFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	public String save() {
		String filename=uploadFile.getItemFileName();
		String filePath ="/stagegoods";
		//String newName1=fileUploadUtil.uploadFile(uploadFile.getItem(),filename,filePath);
		String newName=fileUploadUtil.uploadFile(uploadFile.getItem(),filename,filePath);						   
		model.setUrl(filePath+"/"+newName);
		model.setState("0");
		stageGoodsService.save(model);
		System.out.println(model.getSgoodsId());
		return "query";
		
	}
	
	public String query() 
	{
//		 if(page.getPageSize()==5)
//	  	   {
//	  		   page.setPageSize(12);
//	  	   }
		page = stageGoodsService.queryAll(page);
		if(page!=null&&page.getTotalItems()>0)
		  {
			  request.put("msg", "");
		  }
		  else
		  {
			  request.put("msg", "未找到符合要求的积分商品！");
		  }
		request.put("page", page);
		return "list";
	}
	
	public String update()
	{
		String sgoodsid= ServletActionContext.getRequest().getParameter("sgoodsId");
		StageGoods  stageGoods=stageGoodsService.get(Integer.parseInt(sgoodsid));
		stageGoods.setGoodsname(model.getGoodsname());
		stageGoods.setPoints(model.getPoints());
		stageGoods.setRemark(model.getRemark());
        if(uploadFile!=null&&uploadFile.getItemFileName()!=null&&!uploadFile.getItemFileName().equals(""))
        {
        	String filename=uploadFile.getItemFileName();
        	fileUploadUtil.delete(stageGoods.getUrl());
    		String filePath ="/stagegoods";
    		String newName=fileUploadUtil.uploadFile(uploadFile.getItem(),filename,filePath);
    		stageGoods.setUrl(filePath+"/"+newName);
        }
        stageGoodsService.update(stageGoods);
		return "query";
	}
	
	public String updateState()
	{
		String sgoodsid= ServletActionContext.getRequest().getParameter("sgoodsId");
		StageGoods  stageGoods=stageGoodsService.get(Integer.parseInt(sgoodsid));
		if(stageGoods.getState().equals("0"))
		{
			stageGoods.setState("1");
		}
		else
		{
			stageGoods.setState("0");
		}
		stageGoodsService.update(stageGoods);
		return "query";
	}
	
	public String getlist()
	{
		String keyword= ServletActionContext.getRequest().getParameter("keyword");
//		 if(page.getPageSize()==5)
//	  	   {
//	  		   page.setPageSize(12);
//	  	   }
		page = stageGoodsService.getList(page, keyword);
		if(page!=null&&page.getTotalItems()>0)
		  {
			  request.put("msg", "");
		  }
		  else
		  {
			  request.put("msg", "未找到符合要求的积分商品！");
		  }
		request.put("page", page);
		return "list";
	}
	
	public String getGoods()
	{
		String keyword= ServletActionContext.getRequest().getParameter("keyword");
	  if(page.getPageSize()==5)
  	   {
  		   page.setPageSize(12);
  	   }
		page = stageGoodsService.getGoods(page, keyword);
		if(page!=null&&page.getTotalItems()>0)
		  {
			  request.put("msg", "");
		  }
		  else
		  {
			  request.put("msg", "未找到符合要求的积分商品！");
		  }
		request.put("page", page);
		return "listGoods";
	}
	
	public String opengoods()
	{
		String sgoodsid= ServletActionContext.getRequest().getParameter("gid");
		StageGoods  stageGoods=stageGoodsService.get(Integer.parseInt(sgoodsid));
		request.put("stagegoods", stageGoods);
		return "viewGoods";
	}
	
	public String delete()
	{
		String sgoodsid= ServletActionContext.getRequest().getParameter("stagegoodsid");
		if(stageOrderService.getBygoods(sgoodsid)>0)
		{
			jsonMap.put("data", "wrong");
		}
		else
		{
			stageGoodsService.delete(Integer.parseInt(sgoodsid));
			jsonMap.put("data", "right");
		}
		return "json";
	}
	
	public String judge()
	{
		String goodsname= ServletActionContext.getRequest().getParameter("goodsname");
		if(stageGoodsService.getBygoodsname(goodsname)>0)
		{
			jsonMap.put("data", "wrong");
		}
		else
		{
			jsonMap.put("data", "right");
		}
		return "json";
	}
}

