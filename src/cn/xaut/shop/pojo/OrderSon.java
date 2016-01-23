package cn.xaut.shop.pojo;


/**
 * TbOrderson entity. @author MyEclipse Persistence Tools
 */

public class OrderSon implements java.io.Serializable,Comparable<OrderSon>{

	// Fields

	private static final long serialVersionUID = 1L;

	private Integer ordersonId;
	private Double price;
	private Integer amount;
	private String isdispute;
	private Order order;
	private Goods goods;
	private String goodsName;
	private String sonstate;
	private String property;
	
	private Integer tempIndex;//一个临时的顺序变量，用于没提交之前的排序

	// Constructors

	/** default constructor */
	public OrderSon() {
	}

	// Property accessors

	public Integer getOrdersonId() {
		return ordersonId;
	}

	public void setOrdersonId(Integer ordersonId) {
		this.ordersonId = ordersonId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getIsdispute() {
		return isdispute;
	}

	public void setIsdispute(String isdispute) {
		this.isdispute = isdispute;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getSonstate() {
		return sonstate;
	}

	public void setSonstate(String sonstate) {
		this.sonstate = sonstate;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
	
	public Integer getTempIndex() {
		return tempIndex;
	}

	public void setTempIndex(Integer tempIndex) {
		this.tempIndex = tempIndex;
	}

	/**
	 * 订单子项记录中的商品的商品类别信息是否可用
	 * @return true 可用 ; false 不可用
	 */
	public boolean isPropertyValid(){
		if(this.getProperty() != null && this.getProperty().length() > 0)
			return true;
		return false;
	}

	/*
	@Override
	public int compare(OrderSon o1, OrderSon o2) {
		// TODO Auto-generated method stub
		
		
		if(o1.getTempIndex() == null){
			return -1;
		}
		
		if(o2.getTempIndex() == null){
			return 1;
		}
		
		if(o1.getTempIndex() !=null && o2.getTempIndex() != null){
			return o1.getTempIndex() - o2.getTempIndex();
		} else{
			return o1.getOrdersonId() - o2.getOrdersonId();
		}
	}
	*/
	
	@Override
	public int compareTo(OrderSon o) {

		if(this.getTempIndex() == null){
			return -1;
		}
		
		if(o.getTempIndex() == null){
			return 1;
		}
		
		if(this.getTempIndex() != null && o.getTempIndex() != null){
			return this.getTempIndex() - o.getTempIndex();
		} else{
			return this.getOrdersonId() - o.getOrdersonId();
		}
		
	}
	
}