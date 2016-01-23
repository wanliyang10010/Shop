package cn.xaut.common.security.core;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xaut.common.security.service.UserGrantedAuthority;
import cn.xaut.shop.service.UserInfoService;

@Service("userDetailsManager")
@Transactional
public class MyUserDetailsService implements UserDetailsService {

	//private DataSource dataSource; 
	@Autowired
	@Qualifier("userCache")
	private UserCache userCache;
	
	@Autowired
	private UserGrantedAuthority userGrantedAuthority;
	@Autowired
	private UserInfoService userService;
	public void setUserService(UserInfoService userService) {
		this.userService = userService;
	}
			
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	
		authorities = userGrantedAuthority.getUserAuthoritiesByAccount(username);

		String password = "";

		password = userService.getPasswordByUsername(username);

		UserDetails userDetail = new User(username,password,true,true,true,true,authorities);
		
		return userDetail;
	}

	
}
