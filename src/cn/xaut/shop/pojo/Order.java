package cn.xaut.shop.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	private static final long serialVersionUID = -811765196011085432L;
	// Fields
	
	/** 提交 : 0*/
	public static final String SUBMIT = "0";
	/** 取消 : 1*/
	public static final String CANCEL = "1";
	/** 已付款 : 2*/
	public static final String PAY = "2";
	/** 单笔订单最大金额 : 9999999.99*/
	public static final double MAXMONEY = 9999999.99;

	private Integer orderid;
	private UserInfo user;
	private Timestamp buytime;
	private String remark;
	private String state;
	private String statemark;
	private Shop shop;
	private String shopname;
	private String addr;
	private Double freight;
	private Double ftotal;
	private Timestamp lasttime;
	private String transcompany;
	private String transnumber;
	
	private Set<OrderSon> sons = new HashSet<OrderSon>();
	
	private TreeSet<OrderSon> sonlist = new TreeSet<OrderSon>();

	// Constructors

	/** default constructor */
	public Order() {
	}

	// Property accessors
	
	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	
	
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public Timestamp getBuytime() {
		return buytime;
	}

	public void setBuytime(Timestamp buytime) {
		this.buytime = buytime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatemark() {
		return statemark;
	}

	public void setStatemark(String statemark) {
		this.statemark = statemark;
	}

	public Set<OrderSon> getSons() {
		return sons;
	}

	public void setSons(Set<OrderSon> sons) {
		this.sons = sons;
	}

	public Double getFtotal() {
		return ftotal;
	}

	public void setFtotal(Double ftotal) {
		this.ftotal = ftotal;
	}

	public Timestamp getLasttime() {
		return lasttime;
	}

	public void setLasttime(Timestamp lasttime) {
		this.lasttime = lasttime;
	}

	public String getTranscompany() {
		return transcompany;
	}

	public void setTranscompany(String transcompany) {
		this.transcompany = transcompany;
	}

	public String getTransnumber() {
		return transnumber;
	}

	public void setTransnumber(String transnumber) {
		this.transnumber = transnumber;
	}

	public Set<OrderSon> getSonlist() {
		sonlist = new TreeSet<OrderSon>(sons);
		sonlist.comparator();//排序
		return sonlist;
	}
	
}