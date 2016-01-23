package cn.xaut.shop.pojo;
/**
 * PointsRule entity. @author MyEclipse Persistence Tools
 */

public class PointsRule implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7677695614727808104L;
	private Integer pointsId;
	private String type;
	private String rule;
	private String count;

	// Constructors

	/** default constructor */
	public PointsRule() {
	}

	/** full constructor */
	public PointsRule(String type, String rule, String count) {
		this.type = type;
		this.rule = rule;
		this.count = count;
	}

	// Property accessors

	public Integer getPointsId() {
		return this.pointsId;
	}

	public void setPointsId(Integer pointsId) {
		this.pointsId = pointsId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRule() {
		return this.rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getCount() {
		return this.count;
	}

	public void setCount(String count) {
		this.count = count;
	}

}