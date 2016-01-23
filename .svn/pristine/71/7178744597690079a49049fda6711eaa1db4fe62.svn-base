package cn.xaut.shop.pojo;


/**
 * TbDeliveraddr entity. @author MyEclipse Persistence Tools
 */

public class DeliverAddr implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;

	private Integer deliveraddrId;
	private String area;
	private String addr;
	private String postcode;
	private String recevername;
	private String phone;
	private String isdefault;
	private UserInfo user;

	// Constructors

	/** default constructor */
	public DeliverAddr() {
	}

	// Property accessors
	
	public Integer getDeliveraddrId() {
		return deliveraddrId;
	}

	public void setDeliveraddrId(Integer deliveraddrId) {
		this.deliveraddrId = deliveraddrId;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getRecevername() {
		return this.recevername;
	}

	public void setRecevername(String recevername) {
		this.recevername = recevername;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIsdefault() {
		return this.isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}
	
	/**
	 * 获得拼接后收获地址
	 * @return
	 */
	public String getFinalAddr()
	{
		StringBuffer buf = new StringBuffer();
		buf.append(getArea().replace(" ", "") + " ");
		buf.append(getAddr() + " ");
		buf.append(getRecevername() + "（收） ");
		buf.append(getPhone());
		return buf.toString();
	}

}