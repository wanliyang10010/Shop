package cn.xaut.shop.pojo;


/**
 * FavouriteShop entity. @author MyEclipse Persistence Tools
 */

public class FavouriteShop implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// Fields
	private Integer favouriteshopId;
	private String state;
	private String shopUrl;
	
	private UserInfo user;
	
	private Shop shop;

	// Constructors
	
	/** default constructor */
	public FavouriteShop() {
	}
	
	// Property accessors
	
	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Integer getFavouriteshopId() {
		return this.favouriteshopId;
	}

	public void setFavouriteshopId(Integer favouriteshopId) {
		this.favouriteshopId = favouriteshopId;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getShopUrl() {
		return shopUrl;
	}

	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}

}