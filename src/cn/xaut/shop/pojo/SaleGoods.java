
package cn.xaut.shop.pojo;
/**
 * TbGoods entity. @author MyEclipse Persistence Tools
 */

public class SaleGoods implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8192638313410114424L;
	private String goodsname;
	private Integer amount;
	private double price;
	private Integer samount;
	private Integer goodsid;
	private String point;
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

	public String getPoint() {
		return this.point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Integer getSamount() {
		return this.samount;
	}

	public void setSamount(Integer samount) {
		this.samount = samount;
	}

}