package cn.xaut.shop.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {
	
	// Fields
	private static final long serialVersionUID = -8886376599329386908L;
	private Integer userinfoId;
	private String username;
	private String password;
	private String name;
	private String telephone;
	private String mail;
	private String sex;
	private String bdate;
	private String address;
	private String regeditdate;
	private String state;
	private String role;
	private Integer points;

	private Set<Role> roles = new HashSet<Role>();

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	// Property accessors

	public Integer getUserinfoId() {
		return this.userinfoId;
	}

	public void setUserinfoId(Integer userinfoId) {
		this.userinfoId = userinfoId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBdate() {
		return this.bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegeditdate() {
		return this.regeditdate;
	}

	public void setRegeditdate(String regeditdate) {
		this.regeditdate = regeditdate;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Integer getPoints() {
		return this.points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
}