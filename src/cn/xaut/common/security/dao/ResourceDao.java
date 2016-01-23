package cn.xaut.common.security.dao;

import java.util.List;

import cn.xaut.common.security.domain.PageSec;
import cn.xaut.shop.pojo.Authority;
import cn.xaut.shop.pojo.Resource;

public interface ResourceDao {

	/*
	 * ���resourceʵ�壬���resource
	 * */
	public boolean addResource(Resource resource);
	
	/*
	 * ���id��ö�Ӧ��Resourceʵ��
	 * */
	public Resource findResourceById(Integer id);
	
	/*
	 * ���idɾ���ӦResourceʵ��
	 * */
	public void deleteResourceById(Integer id);
	
	/*
	 * ���id��ȡӵ�и���Դ������authority����������Щauthority��ɵ�List
	 * */
	public List<Authority> findAuthoritiesById(Integer id);
	
	/*
	 * ��ȡ����Resource
	 * */
	public List<Resource> findAllResource();
	
	/*
	 * �޸�resource��ݣ�����
	 * */
	public void updateResource(Resource resource);
	
	
	/* ��ҳ��ѯResource */
	/**
     * ��ҳ��ѯ
     * @param hql ��ѯ������
     * @param offset ��ʼ��¼
     * @param length һ�β�ѯ������¼
     * @return
     */
    public List<Resource> queryForPage(String hql,int offset,int length);
    
    /**
     * ��ѯ���м�¼��
     * @param hql ��ѯ������
     * @return �ܼ�¼��
     */
    public int getAllRowCount(String hql);
    
    /* ���resourceName���resource */
    public Resource findResourceByResourceName(String resourceName);
    
    /*  */
    public PageSec<Resource> findResourceByResourceNameForPage(
			String resourceName, int pageSize, int currentPage);
    
    public PageSec<Resource> findResourceByResourceStringForPage(
			String resourceString, int pageSize, int currentPage);
    
    public PageSec<Resource> findResourceByDescriptionForPage(String description,
			int pageSize, int currentPage);
    public PageSec<Resource> findAllResourceForPage(int pageSize, int currentPage);
}
