package cn.xaut.shop.pojo;


/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class CategorySonDetail implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6387938550469556288L;
	private Integer categorysondetailid;
	private Integer categorysonid;
	private String sondescription;
	private String property;
	// Constructors

	/** default constructor */
	public CategorySonDetail() {
	}

	/** full constructor */

	// Property accessors

	public Integer getCategorysondetailid() {
		return this.categorysondetailid;
	}

	public void setCategorysondetailid(Integer categorysondetailid) {
		this.categorysondetailid = categorysondetailid;
	}
	
	public Integer getCategorysonid() {
		return this.categorysonid;
	}

	public void setCategorysonid(Integer categorysonid) {
		this.categorysonid = categorysonid;
	}

	public String getSondescription() {
		return this.sondescription;
	}

	public void setSondescription(String sondescription) {
		this.sondescription = sondescription;
	}
	
	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
	
	
}