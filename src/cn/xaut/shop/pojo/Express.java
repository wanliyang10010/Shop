package cn.xaut.shop.pojo;


public class Express implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer expressId;
	private String applyTime;
	private String name;
	private String address;
	private String phone;
	private String receiveaddr;
	private String weight;
	private String description;
	private String money;
	private String remark;
	private String state;
	
	private UserInfo userinfo;

	// Constructors


	/** default constructor */
	public Express() {
	}


	public Integer getExpressId() {
		return this.expressId;
	}

	public void setExpressId(Integer expressId) {
		this.expressId = expressId;
	}
	
	public String getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getReceiveaddr() {
		return this.receiveaddr;
	}

	public void setReceiveaddr(String receiveaddr) {
		this.receiveaddr = receiveaddr;
	}

	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMoney() {
		return this.money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public UserInfo getUserinfo() {
		return userinfo;
	}


	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

}