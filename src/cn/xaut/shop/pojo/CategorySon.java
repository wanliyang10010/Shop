package cn.xaut.shop.pojo;


/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class CategorySon implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1872971421682532911L;
	private Integer categorysonid;
	private Integer categoryid;
	private String property;
	private String description;
	
//	private Category category;
	
	//类别子表外键
//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}

	// Constructors

	/** default constructor */
	public CategorySon() {
	}


	// Property accessors

	public Integer getCategorysonid() {
		return this.categorysonid;
	}

	public void setCategorysonid(Integer categorysonid) {
		this.categorysonid = categorysonid;
	}
	
	public Integer getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	
	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
	
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}