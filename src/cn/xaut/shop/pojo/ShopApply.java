package cn.xaut.shop.pojo;

/**
 * ShopApply entity. @author MyEclipse Persistence Tools
 */

public class ShopApply implements java.io.Serializable {

	private static final long serialVersionUID = 8225677957716795810L;
	private Integer shopApplyId;
	private String applyTime;
	private String shopname;
	private String shopcategory;
	private String productcategory;
	private String shopaddress;
	private String shoppostnumber;
	private String shopphone;
	private String identifynumber;
	private String userpicture;
	private String identifypicture;
	private String identifypicture2;
	private String checkTime;
	private String checkIdea;
	private String state;
	private String addrarea;
	
	//替换外键
		private UserInfo userinfo;
		private UserInfo checkuserinfo;

	public UserInfo getUserinfo() {
			return userinfo;
		}

		public void setUserinfo(UserInfo userinfo) {
			this.userinfo = userinfo;
		}

		public UserInfo getCheckuserinfo() {
			return checkuserinfo;
		}

		public void setCheckuserinfo(UserInfo checkuserinfo) {
			this.checkuserinfo = checkuserinfo;
		}

	public ShopApply() {
	}

	public Integer getShopApplyId() {
		return this.shopApplyId;
	}

	public void setShopApplyId(Integer shopApplyId) {
		this.shopApplyId = shopApplyId;
	}

	public String getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getShopcategory() {
		return this.shopcategory;
	}

	public void setShopcategory(String shopcategory) {
		this.shopcategory = shopcategory;
	}

	public String getProductcategory() {
		return this.productcategory;
	}

	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}

	public String getShopaddress() {
		return this.shopaddress;
	}

	public void setShopaddress(String shopaddress) {
		this.shopaddress = shopaddress;
	}

	public String getShoppostnumber() {
		return this.shoppostnumber;
	}

	public void setShoppostnumber(String shoppostnumber) {
		this.shoppostnumber = shoppostnumber;
	}

	public String getShopphone() {
		return this.shopphone;
	}

	public void setShopphone(String shopphone) {
		this.shopphone = shopphone;
	}

	public String getIdentifynumber() {
		return this.identifynumber;
	}

	public void setIdentifynumber(String identifynumber) {
		this.identifynumber = identifynumber;
	}

	public String getUserpicture() {
		return this.userpicture;
	}

	public void setUserpicture(String userpicture) {
		this.userpicture = userpicture;
	}

	public String getIdentifypicture() {
		return this.identifypicture;
	}

	public void setIdentifypicture(String identifypicture) {
		this.identifypicture = identifypicture;
	}

	public String getIdentifypicture2() {
		return this.identifypicture2;
	}

	public void setIdentifypicture2(String identifypicture2) {
		this.identifypicture2 = identifypicture2;
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
	
	public String getAddrarea() {
		return this.addrarea;
	}

	public void setAddrarea(String addrarea) {
		this.addrarea = addrarea;
	}	
}