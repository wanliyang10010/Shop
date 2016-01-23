package cn.xaut.shop.pojo;
/**
 * TbGoodsdetial entity. @author MyEclipse Persistence Tools
 */

public class GoodsDetial implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7830153956068700208L;
	private Integer gdetialId;
	private Integer goodsId;
	//private Intege gtitemId;
	private String itemvalue;
	private String itemtype;
	
    private GoodsTypeItem gtItem;
    public GoodsTypeItem  getGtItem() {
		return this.gtItem;
	}
	public void setGtItem(GoodsTypeItem gtItem) {
		this.gtItem = gtItem;
	}
	// Constructors

	
	// Property accessors

	public Integer getGdetialId() {
		return this.gdetialId;
	}

	public void setGdetialId(Integer gdetialId) {
		this.gdetialId = gdetialId;
	}
	
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	//public String getItemname() {
		//return this.itemname;
	//}

	//public void setItemname(String itemname) {
		//this.itemname = itemname;
	//}

	public String getItemvalue() {
		return this.itemvalue;
	}

	public void setItemvalue(String itemvalue) {
		this.itemvalue = itemvalue;
	}

	public String getItemtype() {
		return this.itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

}