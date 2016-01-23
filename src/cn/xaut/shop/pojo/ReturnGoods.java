package cn.xaut.shop.pojo;

/**
 * ReturnGoods entity. @author MyEclipse Persistence Tools
 */

public class ReturnGoods implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 893640402514776307L;
	private Integer returngoodsId;
	private String applyTime;
	private String reason;
	private String remainchecktime;
	private String checkTime;
	private String checkIdea;
	private String logisticscompany;
	private String logisticsnum;
	private String state;

	// Constructors

	/** default constructor */
	public ReturnGoods() {
	}

	 //替换外键
    private UserInfo userinfo;
    private Order order;
    private Shop shop;
	private UserInfo checkuserinfo;
	
    public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public UserInfo getCheckuserinfo() {
		return checkuserinfo;
	}

	public void setCheckuserinfo(UserInfo checkuserinfo) {
		this.checkuserinfo = checkuserinfo;
	}

	// Property accessors

	public Integer getReturngoodsId() {
		return this.returngoodsId;
	}

	public void setReturngoodsId(Integer returngoodsId) {
		this.returngoodsId = returngoodsId;
	}

	
	public String getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getRemainchecktime() {
		return this.remainchecktime;
	}

	public void setRemainchecktime(String remainchecktime) {
		this.remainchecktime = remainchecktime;
	}

	public String getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckIdea() {
		return this.checkIdea;
	}

	public void setCheckIdea(String checkIdea) {
		this.checkIdea = checkIdea;
	}

	public String getLogisticscompany() {
		return this.logisticscompany;
	}

	public void setLogisticscompany(String logisticscompany) {
		this.logisticscompany = logisticscompany;
	}

	public String getLogisticsnum() {
		return this.logisticsnum;
	}

	public void setLogisticsnum(String logisticsnum) {
		this.logisticsnum = logisticsnum;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}