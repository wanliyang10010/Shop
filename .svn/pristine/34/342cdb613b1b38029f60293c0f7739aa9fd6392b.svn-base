package cn.xaut.shop.action;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.service.CartItemService;
import cn.xaut.shop.service.CartService;
import cn.xaut.shop.service.CategoryService;
import cn.xaut.shop.service.CategorySonService;
import cn.xaut.shop.service.DateItemService;
import cn.xaut.shop.service.DateRuleService;
import cn.xaut.shop.service.DeliverAddrService;
import cn.xaut.shop.service.DiscountService;
import cn.xaut.shop.service.DisputeFileService;
import cn.xaut.shop.service.DisputeService;
import cn.xaut.shop.service.ExpressService;
import cn.xaut.shop.service.FavouriteService;
import cn.xaut.shop.service.FavouriteShopService;
import cn.xaut.shop.service.GoodsDetialService;
import cn.xaut.shop.service.GoodsEvaluationService;
import cn.xaut.shop.service.GoodsPictureService;
import cn.xaut.shop.service.GoodsService;
import cn.xaut.shop.service.GoodsStockService;
import cn.xaut.shop.service.GoodsTypeItemService;
import cn.xaut.shop.service.GoodsTypeService;
import cn.xaut.shop.service.HqlService;
import cn.xaut.shop.service.MarginDetailService;
import cn.xaut.shop.service.MarginItemService;
import cn.xaut.shop.service.MarginRuleService;
import cn.xaut.shop.service.MessageService;
import cn.xaut.shop.service.OrderService;
import cn.xaut.shop.service.OrderSonService;
import cn.xaut.shop.service.PageService;
import cn.xaut.shop.service.PointsItemService;
import cn.xaut.shop.service.PointsRuleService;
import cn.xaut.shop.service.ProlongApplyService;
import cn.xaut.shop.service.ReturnGoodsService;
import cn.xaut.shop.service.ShopApplyService;
import cn.xaut.shop.service.ShopEvaluationService;
import cn.xaut.shop.service.ShopService;
import cn.xaut.shop.service.StageGoodsService;
import cn.xaut.shop.service.StageOrderService;
import cn.xaut.shop.service.UserInfoService;
import cn.xaut.shop.service.UserPointService;
import cn.xaut.shop.util.FileUploadUtil;
import cn.xaut.shop.util.MailSender;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;


/**
 * 此Action 存放公共代码：
 * 
 * ModelDriven<Account>, RequestAware,SessionAware,ApplicationAware
 * 
 * 包括业务逻辑类
 * 
 * @author Administrator
 * 
 */

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>,
		RequestAware, SessionAware, ApplicationAware,Preparable {
	
	private static final long serialVersionUID = -7478831641719524541L;
	// 用构造方法获取T的类型
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseAction() {
		try {
			ParameterizedType type = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			//获得父类的第一个实际类类型
			Class clazz = (Class) type.getActualTypeArguments()[0];
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Map<String ,Object> jsonMap = new HashMap<String, Object>();
	
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}
	
	
	protected T model = null;
	public T getModel() {
		return model;
	}
	
	protected Page<T> page = new Page<T>();
	
	public Page<T> getPage() {
		return page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}

	protected Map<String, Object> request = null;
	protected Map<String, Object> session = null;
	protected Map<String, Object> application = null;
	
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	//------------又---是---一---条---华---丽---分---割---线-----------------
	//------↓-----在---下---面---添---加---服---务---代---码------↓----------

	protected FileUploadUtil fileUploadUtil = null;
	public void setFileUploadUtil(FileUploadUtil fileUploadUtil) {
		this.fileUploadUtil = fileUploadUtil;
	}
	
	protected MailSender mailSender = null;
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	protected OrderService orderService = null;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	protected OrderSonService orderSonService = null;
	public void setOrderSonService(OrderSonService orderSonService) {
		this.orderSonService = orderSonService;
	}
	
	protected CategoryService categoryService = null;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	protected CategorySonService categorySonService = null;
	public void setCategorySonService(CategorySonService categorySonService) {
		this.categorySonService = categorySonService;
	}
	
	protected GoodsService goodsService = null;
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	protected GoodsTypeService goodsTypeService = null;
	public void setGoodsTypeService(GoodsTypeService goodsTypeService) {
		this.goodsTypeService = goodsTypeService;
	}
	
	protected GoodsTypeItemService goodsTypeItemService = null;
	public void setGoodsTypeItemService(GoodsTypeItemService goodsTypeItemService) {
		this.goodsTypeItemService = goodsTypeItemService;
	}
	
	protected GoodsDetialService goodsDetialService = null;
	public void setGoodsDetialService(GoodsDetialService goodsDetialService) {
		this.goodsDetialService = goodsDetialService;
	}
	
	protected GoodsPictureService goodsPictureService = null;
	public void setGoodsPictureService(GoodsPictureService goodsPictureService) {
		this.goodsPictureService = goodsPictureService;
	}
	
	protected CartService cartService = null;
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	
	protected CartItemService cartItemService = null;
	public void setCartItemService(CartItemService cartItemService) {
		this.cartItemService = cartItemService;
	}
	
	protected ShopService shopService = null;
	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	protected UserInfoService userInfoService = null;
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	
	protected MarginDetailService marginDetailService = null;
	public void setMarginDetailService(MarginDetailService MarginDetailService) {
		this.marginDetailService = MarginDetailService;
	}
	
	protected ShopApplyService shopApplyService = null;
	public void setShopApplyService(ShopApplyService shopApplyService) {
		this.shopApplyService = shopApplyService;
	}
	
	protected MarginRuleService marginRuleService = null;
	public void setMarginRuleService(MarginRuleService MarginRuleService) {
		this.marginRuleService = MarginRuleService;
	}
	
	protected PointsRuleService pointsRuleService = null;
	public void setPointsRuleService(PointsRuleService PointsRuleService) {
		this.pointsRuleService =  PointsRuleService;
	}
	
	protected DateRuleService dateRuleService = null;
	public void setDateRuleService(DateRuleService DateRuleService) {
		this.dateRuleService =  DateRuleService;
	}
	
	protected FavouriteService favouriteService = null;
	public void setFavouriteService(FavouriteService favouriteService) {
		this.favouriteService = favouriteService;
	}
	
	protected FavouriteShopService favouriteShopService = null;
	public void setFavouriteShopService(FavouriteShopService favouriteShopService) {
		this.favouriteShopService = favouriteShopService;
	}
	
	protected DisputeFileService disputeFileService = null;
	public void setDisputeFileService(DisputeFileService DisputeFileService) {
		this.disputeFileService =  DisputeFileService;
	}
	
	protected DisputeService disputeService = null;
	public void setDisputeService(DisputeService DisputeService) {
		this.disputeService =  DisputeService;
	}

	protected ProlongApplyService prolongApplyService = null;
	public void setProlongApplyService(ProlongApplyService prolongApplyService) {
		this.prolongApplyService = prolongApplyService;
	}
	
	protected ReturnGoodsService returnGoodsService = null;
	public void setReturnGoodsService(ReturnGoodsService returnGoodsService) {
		this.returnGoodsService = returnGoodsService;
	}
	
	protected GoodsEvaluationService goodsEvaluationService = null;
	public void setGoodsEvaluationService(GoodsEvaluationService goodsEvaluationService) {
		this.goodsEvaluationService = goodsEvaluationService;
	}
	
	protected ShopEvaluationService shopEvaluationService = null;
	public void setShopEvaluationService(ShopEvaluationService shopEvaluationService) {
		this.shopEvaluationService = shopEvaluationService;
	}
	
	protected UserPointService userPointService = null;
	public void setUserPointService(UserPointService userPointService) {
		this.userPointService = userPointService;
	}
	
	protected DiscountService discountService = null;
	public void setDiscountService(DiscountService discountService) {
		this.discountService = discountService;
	}
    
	protected MarginItemService marginItemService = null;
	public void setMarginItemService(MarginItemService MarginItemService) {
		this.marginItemService = MarginItemService;
	}
	
	protected PointsItemService pointsItemService = null;
	public void setPointsItemService(PointsItemService PointsItemService) {
		this.pointsItemService = PointsItemService;
	}
	
	protected DateItemService dateItemService = null;
	public void setDateItemService(DateItemService DateItemService) {
		this.dateItemService =DateItemService;
	}

	protected DeliverAddrService deliverAddrService =null;
	public void setDeliverAddrService(DeliverAddrService deliverAddrService) {
		this.deliverAddrService = deliverAddrService;
	}

	protected MessageService messageService = null;
	public void setMessageService(MessageService messageService) {
		this.messageService=messageService;
	}
	
	protected StageGoodsService stageGoodsService = null;
	public void setStageGoodsService(StageGoodsService stageGoodsService) {
		this.stageGoodsService=stageGoodsService;
	}
	
	protected StageOrderService stageOrderService = null;
	public void setStageOrderService(StageOrderService stageOrderService) {
		this.stageOrderService=stageOrderService;
	}
	
	protected PageService pageService = null;
	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}
	
	protected GoodsStockService goodsStockService = null;
	public void setGoodsStockService(GoodsStockService goodsStockService) {
		this.goodsStockService=goodsStockService;
	}
	
	protected ExpressService expressService=null;
	public void setExpressService(ExpressService expressService) {
		this.expressService = expressService;
	}

	@Autowired
	protected HqlService hqlService = null;
}
