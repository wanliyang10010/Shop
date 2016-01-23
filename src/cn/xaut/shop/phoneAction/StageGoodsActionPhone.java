package cn.xaut.shop.phoneAction;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.StageGoods;
import cn.xaut.shop.pojo.UploadFile;

public class StageGoodsActionPhone extends BaseAction<StageGoods>{
	
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
	private Map<String,Object> responseJson = new HashMap<String,Object>();
	public Map<String, Object> getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}
	public String query() 
	{
		 if(page.getPageSize()==5)
	  	   {
	  		   page.setPageSize(12);
	  	   }
		page = stageGoodsService.queryAll(page);
		if(page.getTotalItems()!=0)
		{
			responseJson.put("LIST", page.getResult());
			boolean isFristPage = page.isFirstPage();
			boolean isLastPage = page.isLastPage();
			
			responseJson.put("first", isFristPage);
			responseJson.put("next", isLastPage);
		}else
		{		
			responseJson.put("isResult", "false");
		}		
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
		 if(page.getPageSize()==5)
	  	   {
	  		   page.setPageSize(12);
	  	   }
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
		page = stageGoodsService.getGoods(page, "");
		if(page.getTotalItems()!=0)
		{
			responseJson.put("LIST", page.getResult());
			boolean isFristPage = page.isFirstPage();
			boolean isLastPage = page.isLastPage();
			
			responseJson.put("first", isFristPage);
			responseJson.put("next", isLastPage);
		}else
		{		
			responseJson.put("isResult", "false");
		}		
		return "list";
	}
	
	public String opengoods()
	{
		String sgoodsid= ServletActionContext.getRequest().getParameter("gid");
		StageGoods  stageGoods=stageGoodsService.get(Integer.parseInt(sgoodsid));
		request.put("stagegoods", stageGoods);
		return "viewGoods";
	}
}

