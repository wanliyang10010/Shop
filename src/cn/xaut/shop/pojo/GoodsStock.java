package cn.xaut.shop.pojo;

/**
 * GoodsStock entity. @author MyEclipse Persistence Tools
 */

public class GoodsStock implements java.io.Serializable {

	// Fields

	private Integer goodstockId;
	private String goodstype;
	private String price;
	private Integer amount;
	private Integer goodsId;
	// Constructors
	
	public Integer getGoodstockId() {
		return this.goodstockId;
	}

	public void setGoodstockId(Integer goodstockId) {
		this.goodstockId = goodstockId;
	}

	public String getGoodstype() {
		return this.goodstype;
	}

	public void setGoodstype(String goodstype) {
		this.goodstype = goodstype;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

}