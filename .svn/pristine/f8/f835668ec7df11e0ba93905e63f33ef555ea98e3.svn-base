package cn.xaut.shop.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Cart entity. @author MyEclipse Persistence Tools
 * 购物车
 */

public class Cart  implements java.io.Serializable{

	// Fields

	private static final long serialVersionUID = -8684050828783596652L;
	private Integer cartId;
	private Double total;
	private Timestamp createTime;
	private String remark;

	//外键
//	private Integer userId;
//	private Integer shopId;
	
	//替换外键
	private UserInfo userInfo;
	private Shop shop;
	
	/*购物车中要存储商品(购物项)*/
	private Set<CartItem> cartitems = new HashSet<CartItem>();
	
	// Constructors

	public Set<CartItem> getCartitems() {
		return cartitems;
	}

	public void setCartitems(Set<CartItem> cartitems) {
		this.cartitems = cartitems;
	}


	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	/** default constructor */
	public Cart() {
	}

	// Property accessors

	public Integer getCartId() {
		return this.cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}


	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}