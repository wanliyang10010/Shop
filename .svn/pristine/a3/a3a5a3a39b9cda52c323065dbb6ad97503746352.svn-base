package cn.xaut.common.security.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xaut.common.security.dao.UserSecurityDao;
import cn.xaut.common.security.service.UserGrantedAuthority;
import cn.xaut.shop.pojo.Authority;
import cn.xaut.shop.pojo.Role;


@Service("userGrantedAuthority")
@Transactional
public class UserGrantedAuthorityImpl implements UserGrantedAuthority {

	@Autowired
	private UserSecurityDao userSecurityDao;
	
	@Override
	public Collection<GrantedAuthority> getUserAuthoritiesByAccount(
			String account) {
		List<Authority> authorities = this.getAuthoritiesByAccount(account);
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		for(Authority authority : authorities){
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthorityName());
			grantedAuthorities.add(grantedAuthority);
		}
		return grantedAuthorities;
		
	}
	
	/*
	 * ����û���account������ȡ�û���ӵ�е�Ȩ�ޣ�authority��
	 * */
	private List<Authority> getAuthoritiesByAccount(String account){
		List<Role> roles = userSecurityDao.getRolesByAccount(account);
		List<Authority> authorities = new ArrayList<Authority>();
		//ʹ��set��ȥ�ظ�Ԫ��
		Set<Authority> setAuthorities = new HashSet<Authority>();
		Iterator<Role> it = roles.iterator();
		while(it.hasNext()){
			//List<Authority> itemAuthorities = new ArrayList<Authority>();
			setAuthorities.addAll(((Role)(it.next())).getAuthorities());
		}
		authorities.addAll(setAuthorities);
		return authorities;
		
	}

}
