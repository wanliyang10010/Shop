package cn.xaut.shop.pojo;

/**
 * CartItem entity. @author MyEclipse Persistence Tools
 */

public class CartItem implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -5685447317825427310L;

	private Integer itemId;
	private String itemname;
	private Integer amount;
	private Double price;
	private String property;
	private Integer goodsId;
	private String goodsPicUrl;

	// 外键
	// private Integer cartId;
	// 购物车-外键 -->这个最终要存在数据库中
	private Cart cart;

	// Constructors
	/** default constructor */
	public CartItem() {
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	// Property accessors

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsPicUrl() {
		return goodsPicUrl;
	}

	public void setGoodsPicUrl(String goodsPicUrl) {
		this.goodsPicUrl = goodsPicUrl;
	}
	
	/**
	 * 购物项全称 商品名 + 属性名称
	 * */
	public String getFullName(){
		return  this.getItemname() + (property == null ? "" : property);
	}
	

	/**
	 * 该购物项的属性信息是否可用
	 * @return true可用 ; false 不可用.
	 */
	public boolean isPropertyValid() {
		if(this.getProperty() != null && this.getProperty().length() > 0)
			return true;
		return false;
	}
}