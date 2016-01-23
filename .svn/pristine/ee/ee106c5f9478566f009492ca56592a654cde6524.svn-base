package cn.xaut.shop.pojo;

/**
 * TbGoods entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8192638313410114424L;
	private Integer goodsid;
	private String goodsname;
	private Integer typeid;
	// private Integer shopid;
	private Integer amount;
	private String state;
	// private String discountid;
	private String hot;
	private String infodate;
	private String point;
	private String shand;
	private double price;
	private double freight;
	private Integer samount;
	private Discount discount;
	private GoodsPicture goodsPicture;
	private Shop shop;
	private double currentPrice;

	public Goods() {
//		this.currentPrice = this.getDiscount() != null ? getDiscount()
//				.getPrice() : getPrice();
	}

	public Discount getDiscount() {
		return this.discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public GoodsPicture getGoodsPicture() {
		return this.goodsPicture;
	}

	public void setGoodsPicture(GoodsPicture goodsPicture) {
		this.goodsPicture = goodsPicture;
	}

	public Integer getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public Integer getTypeid() {
		return this.typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHot() {
		return this.hot;
	}

	public void setHot(String hot) {
		this.hot = hot;
	}

	public String getInfodate() {
		return this.infodate;
	}

	public void setInfodate(String infodate) {
		this.infodate = infodate;
	}

	public String getPoint() {
		return this.point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getFreight() {
		return this.freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}

	public void setPrice(String price) {
		this.price = Double.parseDouble(price);
	}

	public Integer getSamount() {
		return this.samount;
	}

	public void setSamount(Integer samount) {
		this.samount = samount;
	}

	public String getShand() {
		return this.shand;
	}

	public void setShand(String shand) {
		this.shand = shand;
	}

	/**
	 * 商品是否有效
	 * 
	 * @return true 有效 ; false 无效
	 */
	public boolean isValid() {
		/*
		 * 0 在售 1 下架 2 管理员下架 3 首页显示 4商品删除 5二手商品
		 */
		if (this.getState().equals("0") || this.getState().equals("3")) {
			return true;
		}
		return false;
	}

	/**
	 * 查询当前价格
	 * 
	 * @return
	 */
	public double getCurrentPrice() {
		//return currentPrice;
		return discount != null ? discount.getPrice() : getPrice();
				
	}

}