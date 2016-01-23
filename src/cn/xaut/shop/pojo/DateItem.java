package cn.xaut.shop.pojo;


/**
 * DateItem entity. @author MyEclipse Persistence Tools
 */

public class DateItem implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ditemid;
	private String itemname;
	private String remark;

	// Constructors

	/** default constructor */
	public DateItem() {
	}

	/** full constructor */
	public DateItem(String itemname, String remark) {
		this.itemname = itemname;
		this.remark = remark;
	}

	// Property accessors

	public Integer getDitemid() {
		return this.ditemid;
	}

	public void setDitemid(Integer ditemid) {
		this.ditemid = ditemid;
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