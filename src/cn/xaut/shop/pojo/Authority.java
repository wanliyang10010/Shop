package cn.xaut.shop.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
@Component("authority")
public class Authority implements Serializable{

	private static final long serialVersionUID = 8764463571095671578L;
	private Integer id;
	private String authorityName;
	private String description;
	private Integer enabled;
	private Integer isSys;
	
	private Set<Role> roles = new HashSet<Role>();
	private Set<Resource> resources = new HashSet<Resource>();
	
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public Set<Resource> getResources() {
		return resources;
	}
	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
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
	
	public Authority() {
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((authorityName == null) ? 0 : authorityName.hashCode());
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
		Authority other = (Authority) obj;
		if (authorityName == null) {
			if (other.authorityName != null)
				return false;
		} else if (!authorityName.equals(other.authorityName))
			return false;
		return true;
	}
	
}
