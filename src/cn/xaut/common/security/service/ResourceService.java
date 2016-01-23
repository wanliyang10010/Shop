package cn.xaut.common.security.service;

import java.util.List;

import cn.xaut.common.security.domain.PageSec;
import cn.xaut.shop.pojo.Resource;

public interface ResourceService {
	public boolean addResource(Resource resource);
	
	public List<Resource> getAllResource();
	
	/**
     * ��ҳ��ѯ
     * @param resourceName ��Դ���
     * @param currentPage ��ǰ�ڼ�ҳ
     * @param pageSize ÿҳ��С
     * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
     */
    public PageSec<Resource> queryResourceByResourceNameForPage(String resourceName,int pageSize,int currentPage);
    
    /**
     * ��ҳ��ѯ
     * @param resourceString ��Դ����
     * @param currentPage ��ǰ�ڼ�ҳ
     * @param pageSize ÿҳ��С
     * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
     */
    public PageSec<Resource> queryResourceByResourceStringForPage(String resourceString,int pageSize,int currentPage);
    
    /**
     * ��ҳ��ѯ
     * @param description ��Դ����
     * @param currentPage ��ǰ�ڼ�ҳ
     * @param pageSize ÿҳ��С
     * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
     */
    public PageSec<Resource> queryResourceByDescriptionForPage(String description,int pageSize,int currentPage);
    
    /**
     * ��ҳ��ѯ
     * @param currentPage ��ǰ�ڼ�ҳ
     * @param pageSize ÿҳ��С
     * @return ����˷�ҳ��Ϣ(������¼��list)��Bean
     */
    public PageSec<Resource> queryAllResourceForPage(int pageSize,int currentPage);
    
    /*
     * ɾ��resource��ɾ��resource��authority�Ĺ�����ϵ
     * */
    public void deleteResourceAnd_AuthorityById(Integer resourceId);
    
    /* ���resourceId���resource */
    public Resource getResourceById(Integer resourceId);
    
    /* ����resource */
    public void updateResource(Resource resource);
    
    /* ���resourceName���resource */
    public Resource getResourceByResourceName(String resourceName);
    
    public List<Resource> getResourceStringOfAction();
    
    public List<Resource> getResourceStringOfUrl();
    
    /**
     * 添加所有资源
     * @return 返回添加情况
     */
    public String insertAllResources();
}
