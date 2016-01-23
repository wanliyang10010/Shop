package cn.xaut.shop.pojo;


/**
 * ShopEvaluation entity. @author MyEclipse Persistence Tools
 */

public class ShopEvaluation  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 5230459732507733061L;
	private Integer shopEvaluationId;
     private String evaluationTime;
     private Integer describepoint;
     private Integer servicepoint;
     private Integer speedpoint;
     private Integer shoppoint;

     //替换外键
     private UserInfo userinfo;
     private Shop shop;
     private OrderSon orderSon;
     private Goods goods;
   

    /** default constructor */
    public ShopEvaluation() {
    }

    
    public UserInfo getUserinfo() {
		return userinfo;
	}


	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}


	public Shop getShop() {
		return shop;
	}


	public void setShop(Shop shop) {
		this.shop = shop;
	}


	public OrderSon getOrderSon() {
		return orderSon;
	}


	public void setOrderSon(OrderSon orderSon) {
		this.orderSon = orderSon;
	}


	public Goods getGoods() {
		return goods;
	}


	public void setGoods(Goods goods) {
		this.goods = goods;
	}
   
    // Property accessors

    public Integer getShopEvaluationId() {
        return this.shopEvaluationId;
    }
    
    public void setShopEvaluationId(Integer shopEvaluationId) {
        this.shopEvaluationId = shopEvaluationId;
    }

    public String getEvaluationTime() {
        return this.evaluationTime;
    }
    
    public void setEvaluationTime(String evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    public Integer getDescribepoint() {
        return this.describepoint;
    }
    
    public void setDescribepoint(Integer describepoint) {
        this.describepoint = describepoint;
    }

    public Integer getServicepoint() {
        return this.servicepoint;
    }
    
    public void setServicepoint(Integer servicepoint) {
        this.servicepoint = servicepoint;
    }

    public Integer getSpeedpoint() {
        return this.speedpoint;
    }
    
    public void setSpeedpoint(Integer speedpoint) {
        this.speedpoint = speedpoint;
    }

    public Integer getShoppoint() {
        return this.shoppoint;
    }
    
    public void setShoppoint(Integer shoppoint) {
        this.shoppoint = shoppoint;
    }
}