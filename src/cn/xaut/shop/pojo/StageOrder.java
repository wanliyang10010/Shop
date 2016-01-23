package cn.xaut.shop.pojo;
import java.util.Date;

/**
 * StageOrder entity. @author MyEclipse Persistence Tools
 */

public class StageOrder implements java.io.Serializable {

	// Fields

	private Integer stageorderId;
	//private Integer userId;
	private Date buytime;
	private String goodsname;
	private String addr;
	private String remark;
	private String transcompany;
	private String transnumber;
	private UserInfo user;
	private StageGoods stagegoods;
	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}
	
	public StageGoods getStagegoods() {
		return stagegoods;
	}

	public void setStagegoods(StageGoods stagegoods) {
		this.stagegoods = stagegoods;
	}
	// Constructors


	public Integer getStageorderId() {
		return this.stageorderId;
	}

	public void setStageorderId(Integer stageorderId) {
		this.stageorderId = stageorderId;
	}

	public Date getBuytime() {
		return this.buytime;
	}

	public void setBuytime(Date buytime) {
		this.buytime = buytime;
	}

	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getTranscompany() {
		return this.transcompany;
	}

	public void setTranscompany(String transcompany) {
		this.transcompany = transcompany;
	}
	
	public String getTransnumber() {
		return this.transnumber;
	}

	public void setTransnumber(String transnumber) {
		this.transnumber = transnumber;
	}

}