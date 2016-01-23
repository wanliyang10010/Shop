package cn.xaut.common.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xaut.common.security.dao.ResourceDao;
import cn.xaut.common.security.domain.PageSec;
import cn.xaut.common.security.service.ResourceService;
import cn.xaut.common.security.utils.ParseResouceXml;
import cn.xaut.shop.pojo.Resource;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceDao resourceDao;
	
	@Override
	@Transactional
	public boolean addResource(Resource resource) {
		boolean result = resourceDao.addResource(resource);
		//resourceDao.addResource(resource);
		return result;
	}
	@Override
	@Transactional
	public List<Resource> getAllResource() {
		List<Resource> resources = resourceDao.findAllResource();
		return resources;
	}
	
	@Override
	@Transactional
	public PageSec<Resource> queryResourceByResourceNameForPage(
			String resourceName, int pageSize, int currentPage) {
		
		PageSec<Resource> page = new PageSec<Resource>();
		page = resourceDao.findResourceByResourceNameForPage(resourceName, pageSize, currentPage);
		return page;	
	}
	
	@Override
	@Transactional
	public PageSec<Resource> queryResourceByResourceStringForPage(
			String resourceString, int pageSize, int currentPage) {
		
		PageSec<Resource> page = new PageSec<Resource>();
		page = resourceDao.findResourceByResourceStringForPage(resourceString, pageSize, currentPage);
		return page;
		
	}
	
	@Override
	@Transactional
	public PageSec<Resource> queryResourceByDescriptionForPage(String description,
			int pageSize, int currentPage) {
		
		PageSec<Resource> page = new PageSec<Resource>();
		page = resourceDao.findResourceByDescriptionForPage(description, pageSize, currentPage);
		return page;
	}
	
	@Override
	@Transactional
	public PageSec<Resource> queryAllResourceForPage(int pageSize, int currentPage) {
		
		PageSec<Resource> page = new PageSec<Resource>();
		page = resourceDao.findAllResourceForPage(pageSize, currentPage);
		return page;
	}
	
	@Override
	@Transactional
	public void deleteResourceAnd_AuthorityById(Integer resourceId) {
		resourceDao.deleteResourceById(resourceId);
	}
	
	
	@Override
	@Transactional
	public Resource getResourceById(Integer resourceId) {
		Resource resource = resourceDao.findResourceById(resourceId);
		return resource;
	}
	@Override
	@Transactional
	public void updateResource(Resource resource) {
		resourceDao.updateResource(resource);
	}
	
	@Override
	@Transactional
	public Resource getResourceByResourceName(String resourceName) {
		Resource resource = resourceDao.findResourceByResourceName(resourceName);
		return resource;
	}
	
	@Override
	@Transactional
	public List<Resource> getResourceStringOfAction() {
		List<Resource> resourceList = new ArrayList<Resource>();
		try {
			resourceList = ParseResouceXml.read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*Iterator<Resource> iter = resourceList.iterator();
		Resource resourceTemp = iter.next();
		//List<Resource> deleteResourceList = new ArrayList<Resource>();
		while(iter.hasNext()){
			//Resource resourceTemp = iter.next();
			if((resourceTemp.getType()).equals("url")){
				//resourceList.remove(resourceTemp);
				//deleteResourceList.add(resourceTemp);
				iter.remove();
			}
		}
		//resourceList.removeAll(deleteResourceList);*/		
		for(int i = resourceList.size() -1;i >= 0;i--){
			Resource resourceTemp = resourceList.get(i);
			if((resourceTemp.getType()).equals("url")){
				resourceList.remove(i);
			}
		}
		return resourceList;
	}
	
	@Override
	@Transactional
	public List<Resource> getResourceStringOfUrl() {
		List<Resource> resourceList = new ArrayList<Resource>();
		try {
			resourceList= ParseResouceXml.read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*Iterator<Resource> iter = resourceList.iterator();
		List<Resource> deleteResourceList = new ArrayList<Resource>();
		while(iter.hasNext()){
			Resource resourceTemp = iter.next();
			if((resourceTemp.getType()).equals("action")){
				//resourceList.remove(resourceTemp);
				deleteResourceList.add(resourceTemp);
			}
		}
		resourceList.removeAll(deleteResourceList);*/
		for(int i = resourceList.size() -1;i >= 0;i--){
			Resource resourceTemp = resourceList.get(i);
			if((resourceTemp.getType()).equals("action")){
				resourceList.remove(i);
			}
		}
		return resourceList;
	}
	
	
	@Override
	@Transactional
	public String insertAllResources() {
		
		String result = "";
		
		List<Resource> list = ParseResouceXml.read();
		if (list == null)
		{
			System.out.println("无可添加资源");
			return "无可添加资源";
		}

		String strResoName = "";
		int nSussess = 0;
		int nFail = 0;
		int nExist = 0;
		for (Resource reso : list) {

			strResoName = this.createResourceName(reso.getResourceString());

			Resource exist = resourceDao.findResourceByResourceName(strResoName);
			if (exist != null) {
				System.out.println("资源 : " + exist.getResourceName() + " -> "
						+ exist.getResourceString() + "已存在");
				nExist++;
			} else {

				reso.setIsSys(0);
				reso.setEnabled(0);
				reso.setResourceName(strResoName);
				// System.out.println(reso.getResourceName());
				// System.out.println(reso.getResourceString());
				// System.out.println(reso.getType());
				// System.out.println(reso.getDescription());
				
				if(resourceDao.addResource(reso))
				{
					System.out.println("添加资源 -> " + reso.getResourceName());
					nSussess++;
				}
				else
					nFail++;
			}
		}
		result = "重复资源： " + nExist + "条，添加资源：" + nSussess + "条，添加失败 :" + nFail + "条";
		System.out.println(result);
		return result;
	}
	
	private String createResourceName(String Name) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("RESO_");

		int begin = Name.indexOf("/") + 1;// 找第一个斜杠/
		// System.out.println("begin " + begin);
		int end = Name.indexOf(".", begin);

		if (end >= 0)
			buffer.append(Name.substring(begin, end));
		else
			buffer.append(Name.substring(begin));

		String ResName = buffer.toString(); 
		if(ResName.indexOf("/") > 0)
		{
			System.out.println("HHHH");
			ResName = ResName.replace("/", "_");
		}
		
		return ResName;
	}
	
}
