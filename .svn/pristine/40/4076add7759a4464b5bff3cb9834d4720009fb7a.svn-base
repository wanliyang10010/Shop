package cn.xaut.shop.phoneAction;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.Dispute;
import cn.xaut.shop.pojo.DisputeFile;
import cn.xaut.shop.pojo.UploadFile;
import cn.xaut.shop.util.Struts2Utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
public class DisputeFileActionPhone extends BaseAction<DisputeFile> {
	private Map<String,Object> responseJson = new HashMap<String,Object>();
	public Map<String, Object> getResponseJson() {
		return responseJson;
	}
	public void setResponseJson(Map<String, Object> responseJson) {
		this.responseJson = responseJson;
	}	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6145376568796009335L;
	private UploadFile uploadFile;
	Gson gson = new Gson();
	public UploadFile getUploadFile() {
		return uploadFile; 
	}

	public void setUploadFile(UploadFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	
	public List<DisputeFile>  getlist(String json)
	{
		System.out.println(json);
		Type listType=new TypeToken<ArrayList<DisputeFile>>(){}.getType();//TypeToken内的泛型就是Json数据中的类型
		List<DisputeFile>  list = gson.fromJson(json, listType);
        return list;
	}
	
	public String save() {
		String filename=uploadFile.getItemFileName();
		String filePath ="/disputefile/user"+session.get("userid").toString();
		String newName=fileUploadUtil.uploadFile(uploadFile.getItem(),filename,filePath);
		//String newName=fileUploadUtil.uploadFile(uploadFile.getItem(),filename);
		System.out.println(newName);
		String json=ServletActionContext.getRequest().getParameter("filecontent");
		model.setName(filename);								   
		model.setUrl(filePath+"/"+newName);
		List<DisputeFile> list = new ArrayList<DisputeFile>();
		if(!json.trim().equals(""))
		{
			list=getlist(json);
			DisputeFile  dsf=(DisputeFile) list.get(list.size()-1);
			model.setFileid(dsf.getFileid()+1);
			list.add(model);
		}
		else
		{
			int i=1;
			model.setFileid(i);
			list.add(model);
		}
		json =gson.toJson(list);
		System.out.println(json);
		request.put("DisputeFileList", list);
		request.put("json", json);
		return "listadd";
	}
	
	public String delete()
	{
		Integer id=Integer.parseInt(ServletActionContext.getRequest().getParameter("fileid"));
		String json=ServletActionContext.getRequest().getParameter("filecontent");
		List<DisputeFile> list=getlist(json);
		if(list!=null&&list.size()>0)
		{
			DisputeFile  dsf=new DisputeFile();
			for(int i=0;i<list.size();i++)
			{
				dsf=list.get(i);
				if(id==dsf.getFileid())
				{
					fileUploadUtil.delete(dsf.getUrl());
					list.remove(i);
					break;
				}
			}
		}
		json = gson.toJson(list);
		if(json.equals("[]"))
		{
			json="";
		}
		request.put("DisputeFileList", list);
		request.put("json", json);
		return "listadd";
	}
	
	public String download()
	{
		String fileid=ServletActionContext.getRequest().getParameter("fileId");
		DisputeFile file=disputeFileService.get(Integer.parseInt(fileid));
		String outpath="E:/upload/";
		try {
			fileUploadUtil.download(file.getUrl(), outpath, file.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "listfile";
	}
	
		
	public String listfile() throws Exception
	{
		String disputeId=Struts2Utils.getRequest().getParameter("disputeId");
		Dispute dsp= disputeService.get(Integer.parseInt(disputeId));
		//System.out.println(dsp.getContent());
		List<DisputeFile> list=disputeFileService.getlist(Integer.parseInt(disputeId));
		 if(list!=null&&list.size()>0)
		  {
			// responseJson.put("dispute",dsp);
			 responseJson.put("DisputeFileList",list);
			  //request.put("msgf", "");
		  }
		  else
		  {
			    String DisputeFileList="0";
			     //responseJson.put("dispute",dsp);
				 responseJson.put("DisputeFileList",DisputeFileList);
			  //request.put("msgf", "没有符合条件的记录，请重新查询");
		  }
		
		 // request.put("dispute", dsp);
		 // request.put("DisputeFileList", list);
		  return "DisputeFileList";   
	}
}
