package cn.xaut.shop.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.xml.registry.infomodel.User;

import org.springframework.stereotype.Component;

import cn.xaut.shop.pojo.UserInfo;


@Component(value = "role")


public class Role implements Serializable {
	
	private Integer id;
	private String roleName;
	private String description;
	private Integer enabled;
	private Integer isSys;

	private Set<UserInfo> users = new HashSet<UserInfo>();

	private Set<Authority> authorities = new HashSet<Authority>();

	public Set<Authority> getAuthorities() {
		return authorities;
	}
	
	public Role() {
		
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public Set<UserInfo> getUsers() {
		return users;
	}

	public void setUsers(Set<UserInfo> users) {
		this.users = users;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Integer getIsSys() {
		return isSys;
	}

	public void setIsSys(Integer isSys) {
		this.isSys = isSys;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((roleName == null) ? 0 : roleName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}

}
