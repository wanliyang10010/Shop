package cn.xaut.shop.pojo;


/**
 * DisputeFile entity. @author MyEclipse Persistence Tools
 */

public class DisputeFile implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1700722068784179239L;
	private Integer fileid;
	//private Integer disputeid;
	private String name;
	private String url;
	// Constructors

	 private Dispute dispute;	
	 public Dispute getDispute() {
			return dispute;
	}
	public void setDispute(Dispute dispute) {
			this.dispute = dispute;
	}

	public Integer getFileid() {
		return this.fileid;
	}

	public void setFileid(Integer fileid) {
		this.fileid = fileid;
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

}