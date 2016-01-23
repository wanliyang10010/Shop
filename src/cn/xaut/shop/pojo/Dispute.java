package cn.xaut.shop.pojo;
import java.util.HashSet;
import java.util.Set;

/**
 * Dispute entity. @author MyEclipse Persistence Tools
 */

public class Dispute implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5258910004224591756L;
	private Integer disputeid;
	private String accuser;
	private String sccused;
	//private Integer orderid;
	private String dtype;
	private String state;
	private String content;
	private String infodate;
	private String result;
	//private Integer checkid;
	private UserInfo admin;
	private String checkdate;
	//private Integer accuserid;
	//private Integer sccusedid;
	private String orderson;
	private UserInfo userinfo;
	private Shop shop;
	private OrderSon order; 
    private Set<DisputeFile> disputeFile = new HashSet<DisputeFile>();
	
	// Constructors

	public Set<DisputeFile> getDisputeFile() {
		return disputeFile;
	}

	public void setDisputeFile(Set<DisputeFile> disputeFile) {
		this.disputeFile = disputeFile;
	}
	// Constructors
	public void setUserInfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	
	public UserInfo getUserInfo() {
		return this.userinfo;
	}
	
	public void setAdmin(UserInfo admin) {
		this.admin = admin;
	}
	
	public UserInfo getAdmin() {
		return this.admin;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	public Shop getShop() {
		return this.shop;
	}

	public void setOrder(OrderSon order) {
		this.order = order;
	}
	
	public OrderSon getOrder() {
		return this.order;
	}

	
	// Property accessors

	public Integer getDisputeid() {
		return this.disputeid;
	}

	public void setDisputeid(Integer disputeid) {
		this.disputeid = disputeid;
	}

	public String getAccuser() {
		return this.accuser;
	}

	public void setAccuser(String accuser) {
		this.accuser = accuser;
	}

	public String getSccused() {
		return this.sccused;
	}

	public void setSccused(String sccused) {
		this.sccused = sccused;
	}

	
	public String getDtype() {
		return this.dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getInfodate() {
		return this.infodate;
	}

	public void setInfodate(String infodate) {
		this.infodate = infodate;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String getCheckdate() {
		return this.checkdate;
	}

	public void setCheckdate(String checkdate) {
		this.checkdate = checkdate;
	}
	
	public String getOrderson() {
		return this.orderson;
	}

	public void setOrderson(String orderson) {
		this.orderson = orderson;
	}

}