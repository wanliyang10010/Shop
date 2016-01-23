package cn.xaut.shop.pojo;


/**
 * GoodsEvaluation entity. @author MyEclipse Persistence Tools
 */

public class GoodsEvaluation  implements java.io.Serializable {


    // Fields    
	private static final long serialVersionUID = -77339529621786118L;
	private Integer goodsEvaluationId;
     private String evaluationTime;
     private Integer goodspoint;
     private String goodscontent;
     private String ispublic;
     private String addTime;
     private String addcontent;
     private String checkTime;
     private String checkIdea;
     private String state;

   //替换外键
     private UserInfo userinfo;
     private Shop shop;
     private OrderSon orderSon;
     private Goods goods;
     private UserInfo checkuserinfo;
     
    // Constructors

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


	public UserInfo getCheckuserinfo() {
		return checkuserinfo;
	}


	public void setCheckuserinfo(UserInfo checkuserinfo) {
		this.checkuserinfo = checkuserinfo;
	}


	/** default constructor */
    public GoodsEvaluation() {
    }

    public Integer getGoodsEvaluationId() {
        return this.goodsEvaluationId;
    }
    
    public void setGoodsEvaluationId(Integer goodsEvaluationId) {
        this.goodsEvaluationId = goodsEvaluationId;
    }


    public String getEvaluationTime() {
        return this.evaluationTime;
    }
    
    public void setEvaluationTime(String evaluationTime) {
        this.evaluationTime = evaluationTime;
    }


    public Integer getGoodspoint() {
        return this.goodspoint;
    }
    
    public void setGoodspoint(Integer goodspoint) {
        this.goodspoint = goodspoint;
    }

    public String getGoodscontent() {
        return this.goodscontent;
    }
    
    public void setGoodscontent(String goodscontent) {
        this.goodscontent = goodscontent;
    }

    public String getIspublic() {
        return this.ispublic;
    }
    
    public void setIspublic(String ispublic) {
        this.ispublic = ispublic;
    }

    public String getAddTime() {
        return this.addTime;
    }
    
    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getAddcontent() {
        return this.addcontent;
    }
    
    public void setAddcontent(String addcontent) {
        this.addcontent = addcontent;
    }

    public String getCheckTime() {
        return this.checkTime;
    }
    
    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getCheckIdea() {
        return this.checkIdea;
    }
    
    public void setCheckIdea(String checkIdea) {
        this.checkIdea = checkIdea;
    }

    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
}