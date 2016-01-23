package cn.xaut.shop.service;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.pojo.UserInfo;

public interface PageService extends BaseServiceR<UserInfo,Integer>{

	Page<UserInfo> searchUser(Page<UserInfo> page);

	UserInfo findUserById(Integer id);

	UserInfo findUserByLoginName(String loginName);

}
