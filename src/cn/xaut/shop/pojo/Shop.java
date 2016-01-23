package cn.xaut.shop.pojo;

/**
 * Shop entity. @author MyEclipse Persistence Tools
 */

public class Shop implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8316418708522947762L;
	private Integer shopId;
	private Integer shopApplyId;
	private String regeditdate;
	private String shopname;
	private String shopcategory;
	private String productcategory;
	private Integer point;
	private Integer margin;
	private String marginstate;
	private String shopstate;

	// 替换外键
	private UserInfo userinfo;


	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	/** default constructor */
	public Shop() {
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getShopApplyId() {
		return this.shopApplyId;
	}

	public void setShopApplyId(Integer shopApplyId) {
		this.shopApplyId = shopApplyId;
	}

	public String getRegeditdate() {
		return this.regeditdate;
	}

	public void setRegeditdate(String regeditdate) {
		this.regeditdate = regeditdate;
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

	public Integer getPoint() {
		return this.point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Integer getMargin() {
		return this.margin;
	}

	public void setMargin(Integer margin) {
		this.margin = margin;
	}

	public String getMarginstate() {
		return this.marginstate;
	}

	public void setMarginstate(String marginstate) {
		this.marginstate = marginstate;
	}

	public String getShopstate() {
		return this.shopstate;
	}

	public void setShopstate(String shopstate) {
		this.shopstate = shopstate;
	}

}
