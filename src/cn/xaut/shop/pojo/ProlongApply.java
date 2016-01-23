package cn.xaut.shop.pojo;

/**
 * ProlongApply entity. @author MyEclipse Persistence Tools
 */

public class ProlongApply implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2759456602897428895L;
	private Integer prolongapplyId;
	private String applyTime;
	private String reason;
	private String dayapply;
	private String remainchecktime;
	private String checkTime;
	private String checkIdea;
	private String state;


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


    
	/** default constructor */
	public ProlongApply() {
	}


	public Integer getProlongapplyId() {
		return this.prolongapplyId;
	}

	public void setProlongapplyId(Integer prolongapplyId) {
		this.prolongapplyId = prolongapplyId;
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

	public String getDayapply() {
		return this.dayapply;
	}

	public void setDayapply(String dayapply) {
		this.dayapply = dayapply;
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

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}