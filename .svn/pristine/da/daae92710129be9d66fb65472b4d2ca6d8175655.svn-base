package cn.xaut.shop.phoneAction;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.ShopApply;
import cn.xaut.shop.pojo.UploadFile;
import com.google.gson.Gson;
public class ShopFileActionPhone extends BaseAction<ShopApply> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1521663124019393322L;
	private UploadFile uploadFile;
	Gson gson = new Gson();
	public UploadFile getUploadFile() {
		return uploadFile; 
	}
	public void setUploadFile(UploadFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	
//	public List<ShopFile>  getlist(String json)
//	{
//		System.out.println(json);
//		Type listType=new TypeToken<ArrayList<ShopFile>>(){}.getType();//TypeToken内的泛型就是Json数据中的类型
//		List<ShopFile>  list = gson.fromJson(json, listType);
//        return list;
//	}
//	
//	public String save() {
//		String filename=uploadFile.getItemFileName();
//		//String filePath ="/upload/zz/Shop";
//		//String newName1=fileUploadUtil.uploadFile(uploadFile.getItem(),filename,filePath);
//		String newName=fileUploadUtil.uploadFile(uploadFile.getItem(),filename);
//		//System.out.println(newName1);
//		String json=ServletActionContext.getRequest().getParameter("filecontent");
//		model.setName(filename);								   
//		model.setUrl(newName);
//		//List<ShopFile> list=new ArrayList<ShopFile>();
//		List<ShopFile> list = new ArrayList<ShopFile>();
//		if(!json.trim().equals(""))
//		{
//			list=getlist(json);
//			ShopFile  dsf=(ShopFile) list.get(list.size()-1);
//			model.setFileid(dsf.getFileid()+1);
//			list.add(model);
//		}
//		else
//		{
//			int i=1;
//			model.setFileid(i);
//			list.add(model);
//		}
//		json =gson.toJson(list);
//		System.out.println(json);
//		request.put("DFL", list);
//		request.put("json", json);
//		return "listadd";
//	}
//	
//	public String delete()
//	{
//		Integer id=Integer.parseInt(ServletActionContext.getRequest().getParameter("fileid"));
//		String json=ServletActionContext.getRequest().getParameter("filecontent");
//		List<ShopFile> list=getlist(json);
//		if(list!=null&&list.size()>0)
//		{
//			ShopFile  dsf=new ShopFile();
//			for(int i=0;i<list.size();i++)
//			{
//				dsf=list.get(i);
//				if(id==dsf.getFileid())
//				{
//					fileUploadUtil.delete(dsf.getUrl());
//					list.remove(i);
//					break;
//				}
//			}
//		}
//		json = gson.toJson(list);
//		if(json.equals("[]"))
//		{
//			json="";
//		}
//		request.put("DFL", list);
//		request.put("json", json);
//		return "listadd";
//	}
//	
//	public String download()
//	{
//		String fileid=ServletActionContext.getRequest().getParameter("fileId");
//		ShopFile file=shopFileService.get(Integer.parseInt(fileid));
//		String outpath="E:/upload/";
//		try {
//			fileUploadUtil.download(file.getUrl(), outpath, file.getName());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "listfile";
//	}
//	
//		
//	public String listfile()
//	{
//		String ShopId=ServletActionContext.getRequest().getParameter("ShopId");
//		Shop dsp= shopService.get(Integer.parseInt(ShopId));
//		System.out.println(dsp.getContent());
//		List<ShopFile> list=shopFileService.getlist(Integer.parseInt(ShopId));
//		 if(list!=null&&list.size()>0)
//		  {
//			  request.put("msgf", "");
//		  }
//		  else
//		  {
//			  request.put("msgf", "没有符合条件的记录，请重新查询");
//		  }
//		  request.put("Shop", dsp);
//		  request.put("DFL", list);
//		  return "listfile";   
//	}
}
