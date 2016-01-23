package cn.xaut.shop.pojo;

/**
 * TbGoodstypeitem entity. @author MyEclipse Persistence Tools
 */

public class GoodsTypeItem implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5708633962483908535L;
	private Integer gtitemId;
	private Integer gtypeId;
	private String itemname;
	private String remark;

	// Constructors

	/** default constructor */
	public GoodsTypeItem() {
	}

	/** full constructor */
	public GoodsTypeItem(String itemname, String remark) {
		this.itemname = itemname;
		this.remark = remark;
	}

	// Property accessors

	public Integer getGtitemId() {
		return this.gtitemId;
	}

	public void setGtitemId(Integer gtitemId) {
		this.gtitemId = gtitemId;
	}
	
	public Integer getGtypeId() {
		return this.gtypeId;
	}

	public void setGtypeId(Integer gtypeId) {
		this.gtypeId = gtypeId;
	}

	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}