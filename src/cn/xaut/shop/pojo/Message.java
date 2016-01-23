package cn.xaut.shop.pojo;

/**
 * TbMessage entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4250778541105110148L;
	private Integer messageId;
	private String text;
	private Integer sender;
	private Integer receiver;
	private String state;
	private String url;
	private Integer idvalue;
	private String idtype;
	// Property accessors

	public Integer getMessageId() {
		return this.messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getSender() {
		return this.sender;
	}

	public void setSender(Integer sender) {
		this.sender = sender;
	}

	public Integer getReceiver() {
		return this.receiver;
	}

	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getIdtype() {
		return this.idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}
	
	public Integer getIdvalue() {
		return this.idvalue;
	}

	public void setIdvalue(Integer idvalue) {
		this.idvalue = idvalue;
	}

}