package cn.xaut.shop.pojo;


/**
 * DisputeFile entity. @author MyEclipse Persistence Tools
 */

public class GoodsPicture implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5418810191474467024L;
	private Integer fileid;
	private Integer gid;
	private String name;
	private String url;
	private String type;
	// Constructors

	/** default constructor */
	public GoodsPicture() {
	}

	// Property accessors

	public Integer getFileid() {
		return this.fileid;
	}

	public void setFileid(Integer fileid) {
		this.fileid = fileid;
	}

	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}