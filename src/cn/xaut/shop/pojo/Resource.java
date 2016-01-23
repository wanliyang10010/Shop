package cn.xaut.shop.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component("resource")
public class Resource implements Serializable{

	private static final long serialVersionUID = 467992500644138841L;
	private Integer id;
	private String resourceName;
	private String type;//��Դ���� url��method
	private Integer priority;
	private String resourceString;//��Դ����
	private String description;
	private Integer enabled;
	private Integer isSys;
	
	
	private Set<Authority> authorities = new HashSet<Authority>();
	
	public Set<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getResourceString() {
		return resourceString;
	}
	public void setResourceString(String resourceString) {
		this.resourceString = resourceString;
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
	public Resource() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((resourceName == null) ? 0 : resourceName.hashCode());
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
		Resource other = (Resource) obj;
		if (resourceName == null) {
			if (other.resourceName != null)
				return false;
		} else if (!resourceName.equals(other.resourceName))
			return false;
		return true;
	}
	
	
}
