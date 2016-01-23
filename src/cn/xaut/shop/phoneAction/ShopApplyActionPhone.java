package cn.xaut.shop.phoneAction;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import cn.xaut.common.paging.domain.Page;
import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.GoodsDetial;
import cn.xaut.shop.pojo.IdentifyPicture;
import cn.xaut.shop.pojo.MarginItem;
import cn.xaut.shop.pojo.ProlongApply;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.ShopApply;
import cn.xaut.shop.pojo.UploadFile;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.pojo.UserPicture;
import cn.xaut.shop.service.UserInfoService;


/*
 * 
 * 1.基本所有的Action都需要用到request session application 内置对象
 * 
 * 通过他们存数数据，交给前台页面显示，Struts提供了AOP+Ioc的方式，在运行的时候自动注入->实现几个接口就可以了
 * 
 * 2. 前台页面中所有的数据名称，必须要用[对象.属性]方式取值， 这样做耦合性太高，我们可以实现一个接口来解耦
 * 
 * */

public class ShopApplyActionPhone extends BaseAction<ShopApply> {

	private static final long serialVersionUID = 1L;

	private UserPicture userPicture;// 上传半身照
	private IdentifyPicture identifyPicture;// 上传身份证正面
	private UploadFile uploadFile; // 上传身份证反面
	private HttpServletRequest req = ServletActionContext.getRequest();
	
	private String myShopId;
	
	private String myUserinfoId;
	
	public String getMyUserinfoId() {
		return myUserinfoId;
	}

	public void setMyUserinfoId(String myUserinfoId) {
		this.myUserinfoId = myUserinfoId;
	}

	@Autowired
	private UserInfoService userInfoService;
	
	private String fromdate;
	
	private String todate;
	
	
	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getMyShopId() {
		return myShopId;
	}

	public void setMyShopId(String myShopId) {
		this.myShopId = myShopId;
	}
	
	private Map<String,Object> responseJson = new HashMap<String,Object>();
 	public Map<String, Object> getResponseJson() {
 		return responseJson;
 	}
 	public void setResponseJson(Map<String, Object> responseJson) {
 		this.responseJson = responseJson;
 	}
	//得到商品类别
	 public String searchProductcategory()
	   {
		  List<MarginItem> list=marginItemService.query();
		  //session.put("MarginItemList", list);
		  responseJson.put("list", list);
		  return "applyShop";   
	   }

	// 申请时检查用户名是否存在
	public String checkshopName() {
		ShopApply shopApply = shopApplyService.getCheckShopName(model);
		if (shopApply != null && !shopApply.getShopApplyId().equals("")) {
			System.out.println(shopApply.getShopname());
			request.put("msg_shopname", "对不起，该店铺名已被注册！");
		} else {
			request.put("msg_shopname", "恭喜您，该店铺名可以使用！");
		}
		return "applyShop";
	}

	// 申请时添加申请表
	public String save() {
		UserInfo user = (UserInfo) session.get("userinfo");
		Date now = new Date();
		model.setUserinfo(user);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		model.setApplyTime(dateFormat.format(now));
		//设置上传半身照的路径
		String url = fileUploadUtil.uploadFileForRealName(
				userPicture.getItem(), userPicture.getItemFileName());
		model.setUserpicture(url);
		//设置上传身份证正面的路径
		String url2 = fileUploadUtil.uploadFileForRealName(
				identifyPicture.getItem(), identifyPicture.getItemFileName());
		model.setIdentifypicture(url2);
		//设置上传身份证反面的路径
		String url3 = fileUploadUtil.uploadFileForRealName(
				uploadFile.getItem(), uploadFile.getItemFileName());
		model.setIdentifypicture2(url3);

		model.setState("0");//状态为0表示待审核
		int shopApplyId= shopApplyService.add(model).getShopApplyId();
		//给管理员发送消息
		messageService.sendMessage(messageService,"新收到一条店铺申请需审核！", user.getUserinfoId(), 0,
				"shopApplyAction_searchAllCheckList.action", "shopId", shopApplyId);
		return "viewShopProgressRedirect";
	}

	// 审核时查找记录 hx
	public String searchAllCheckList() {
		location();//消息定位
		int id=-1;
		/*
		if(req.getParameter("shopId")!=null)
		{
		 id=Integer.parseInt(req.getParameter("shopId"));
		}
		page = shopApplyService.getAllCheckList(page, fromdate(), todate(),id);
		*/
		/*
		if((myShopId != null)&&(myShopId != "")){
			id=Integer.parseInt(myShopId);
		}*/
		boolean isFristPage = true;
		boolean isLastPage = true;
		List<ShopApply> shopApplyList = new ArrayList<ShopApply>();
		//page = shopApplyService.getAllCheckListNoDate(page, id);
		page = shopApplyService.getAllCheckList(page, fromdate(), todate(),id);
		if (page == null || page.getTotalItems() == 0) {
			//request.put("msg_searchAllList", "暂无需要审核的数据！");
		} else {
			// 下载半身照、身份证正面、身份证反面
			//downloadPictureByPage(page);
			isFristPage = page.isFirstPage();
			isLastPage = page.isLastPage();
			shopApplyList = page.getResult();
		}
		//page.getResult()(page.getNextPage());
		//request.put("page", page);// 需要审核的记录，以页面的形式返回
		//location();//消息定位
		
		responseJson.put("first", isFristPage);
		responseJson.put("next", isLastPage);
		responseJson.put("list", shopApplyList);
		return "checkShop";
	}

	// 审核通过，更新审核表，添加商品表 hx 现在改成一次只能审核一条数据
	public String updateAndSave() {
		//第一个参数是UserInfo.userinfoId(通过myUserinfoId 传入)
		//第二个参数是审核意见shopApply.checkIdea(通过model传入)
		//第三个参数是shopApply.shopApplyId(通过model传入)
		UserInfo user = userInfoService.getUserInfoByUserInfoId(Integer.parseInt(myUserinfoId));
		Date now = new Date();
		ShopApply shopApply = shopApplyService.get(model.getShopApplyId());
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		shopApply.setCheckuserinfo(user);
		shopApply.setCheckTime(dateFormat.format(now));
		shopApply.setCheckIdea(req.getParameter("checkIdea"));
		shopApply.setState("1");//状态为1表示审核通过
		shopApplyService.update(shopApply);// 更新店铺申请表
		
		Shop shop = new Shop();
		shop.setShopApplyId(model.getShopApplyId());
		shop.setUserinfo(shopApply.getUserinfo());
		shop.setRegeditdate(dateFormat.format(now));
		shop.setShopname(shopApply.getShopname());
		shop.setShopcategory(shopApply.getShopcategory());
		shop.setProductcategory(shopApply.getProductcategory());
		shop.setPoint(0);
		shop.setMargin(0);
		shop.setMarginstate("0");//状态为0表示未交保证金
		shop.setShopstate("1");//状态为1表示店铺状态正常
		shopService.save(shop);// 添加店铺表
		
		//发送消息
		messageService.sendMessage(messageService,"你申请的店铺审核已通过，请查看后重新登录！",
				user.getUserinfoId(), shopApply.getUserinfo().getUserinfoId(),
				"shopApplyAction_searchMyViewList.action","shopId", model.getShopApplyId());
		responseJson.put("isResult", "true");
		return "checkShopApplyPass";
	}

	// 审核不通过 hx 现在改成一次只能审核一条数据
	public String notpassupdate() {
		//第一个参数是UserInfo.userinfoId(通过myUserinfoId 传入)
		//第二个参数是审核意见shopApply.checkIdea(通过model传入)
		//第三个参数是shopApply.shopApplyId(通过model传入)
		UserInfo user = userInfoService.getUserInfoByUserInfoId(Integer.parseInt(myUserinfoId));
		Date now = new Date();
		ShopApply shopApply = shopApplyService.get(model.getShopApplyId());
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		shopApply.setCheckuserinfo(user);
		shopApply.setCheckTime(dateFormat.format(now));
		shopApply.setCheckIdea(req.getParameter("checkIdea"));
		shopApply.setState("2");//状态为2表示审核未通过
		shopApplyService.update(shopApply);// 更新店铺申请表
		//发送消息
		messageService.sendMessage(messageService,"你申请的店铺审核未通过，请修改！",
				user.getUserinfoId(), shopApply.getUserinfo().getUserinfoId(),
				"shopApplyAction_searchMyAlterList.action","shopId",model.getShopApplyId());
		responseJson.put("isResult", "true");
		return "checkShopApplyNotPass";
	}

	// 修改时查找记录  hx
	public String searchMyAlterList() {
		//UserInfo user = (UserInfo) session.get("userinfo");
		//int userid = user.getUserinfoId();
		List<ShopApply> alterShopList = shopApplyService.getMyAlterList(Integer.parseInt(myUserinfoId),
				fromdate(), todate(), "2");
		boolean isFristPage = true;
		boolean isLastPage = true;
		if (alterShopList == null || alterShopList.size() == 0) {
			request.put("msg_searchMyAlterList", "暂无需要修改的数据！");
		} else {
			//downloadPicture(alterShopList);
		}
		//request.put("alterShopList", alterShopList);// alterShopList得到所需要修改的记录
		responseJson.put("first", isFristPage);
		responseJson.put("next", isLastPage);
		responseJson.put("list", alterShopList);
		location();//消息定位
		return "alterShop";
	}

	// 店铺修改提交
	public String alterShopUpdate() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		ShopApply model2 = shopApplyService.get(model.getShopApplyId());

		model2.setApplyTime(dateFormat.format(now));
		model2.setShopaddress(model.getShopaddress());
		model2.setShoppostnumber(model.getShoppostnumber());
		model2.setShopphone(model.getShopphone());
		model2.setIdentifynumber(model.getIdentifynumber());
		//半身照如果修改则设置上传路径
		if (this.userPicture != null) {
			String url = fileUploadUtil.uploadFileForRealName(
					userPicture.getItem(), userPicture.getItemFileName());
			model2.setUserpicture(url);
		}
		//身份证正面如果修改则设置上传路径
		if (this.identifyPicture != null) {
			String url2 = fileUploadUtil.uploadFileForRealName(
					identifyPicture.getItem(),
					identifyPicture.getItemFileName());
			model2.setIdentifypicture(url2);
		}
		//身份证反面如果修改则设置上传路径
		if (this.uploadFile != null) {
			String url3 = fileUploadUtil.uploadFileForRealName(
					uploadFile.getItem(), uploadFile.getItemFileName());
			model2.setIdentifypicture2(url3);
		}

		model2.setCheckTime("");
		model2.setCheckIdea("");
		model2.setState("0");//状态为0表示待审核
		shopApplyService.update(model2);// 更新店铺申请表
		//给管理员发送消息
		messageService.sendMessage(messageService,"新收到一条店铺申请需审核！", 
				model2.getUserinfo().getUserinfoId(), 0,
				"shopApplyAction_searchAllCheckList.action","shopId", model.getShopApplyId());
				
		request.put("msg_alterover", "修改已完成！");
		//searchMyAlterList();		
		return "viewShopProgressRedirect";
	}

//	public String get() {
//		request.put("ShopApply", shopApplyService.get(model.getShopApplyId()));
//		return "updateShopApply";
//	}

	// 查看进度时查找记录 hx
	public String searchMyViewList() {
		//传入参数myShopId
		//UserInfo user = (UserInfo) session.get("userinfo");
		//int userid = user.getUserinfoId();
		//List<ShopApply> viewShopProgressList = shopApplyService.getMyViewList(Integer.parseInt(myUserinfoId),
		//		fromdate(), todate());
		boolean isFristPage = true;
		boolean isLastPage = true;
		//List<ShopApply> shopApplyList = shopApplyService.getMyViewListNoDate(Integer.parseInt(myShopId));
		List<ShopApply> shopApplyList = shopApplyService.getMyViewList(Integer.parseInt(myUserinfoId),
						fromdate(), todate());
		if (shopApplyList == null || shopApplyList.size() == 0) {
			//request.put("msg_searchMyViewList", "暂无数据！");
		} else {
			//downloadPicture(viewShopProgressList);
			

		}
		
		//request.put("viewShopProgressList", viewShopProgressList);// viewShopProgressList得到店铺审核进展记录
		responseJson.put("first", isFristPage);
		responseJson.put("next", isLastPage);
		responseJson.put("list", shopApplyList);
		location();//消息定位
		return "viewShopProgress";
	}
	//后台管理员查看审核进度
	public String adminViewShopProgress(){
		//searchMyViewList();
		boolean isFristPage = true;
		boolean isLastPage = true;
		//List<ShopApply> shopApplyList = shopApplyService.getMyViewListNoDate(Integer.parseInt(myShopId));
		List<ShopApply> shopApplyList = shopApplyService.getMyViewList(Integer.parseInt(myUserinfoId),
						fromdate(), todate());
		if (shopApplyList == null || shopApplyList.size() == 0) {
			//request.put("msg_searchMyViewList", "暂无数据！");
		} else {
			//downloadPicture(viewShopProgressList);
			

		}
		
		//request.put("viewShopProgressList", viewShopProgressList);// viewShopProgressList得到店铺审核进展记录
		responseJson.put("first", isFristPage);
		responseJson.put("next", isLastPage);
		responseJson.put("list", shopApplyList);
		location();//消息定位
		return "adminViewShopProgress";
	}
//	public String query() {
//		// 查询的数据，如果能存到request中就不要存储在session中
//		// 实现接口后，用request对象就替代上一句了
//		request.put("ShopApplys", shopApplyService.query());
//		return "checkShopApply";
//	}

	public String delete() {
		int id = model.getShopApplyId();
		shopApplyService.delete(id);
		request.put("msg_alterover", "删除成功！");
		//searchMyAlterList();
		return "viewShopProgressRedirect";
	}
	

	public UserPicture getUserPicture() {
		return userPicture;
	}

	public void setUserPicture(UserPicture userPicture) {
		this.userPicture = userPicture;
	}

	public IdentifyPicture getIdentifyPicture() {
		return identifyPicture;
	}

	public void setIdentifyPicture(IdentifyPicture identifyPicture) {
		this.identifyPicture = identifyPicture;
	}

	public UploadFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(UploadFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String fromdate(){
		if (fromdate == null || fromdate.equals("")) {
			fromdate = "2015-01-01";
		}
		return fromdate;
	}
	public String todate(){
		if (todate == null || todate.equals("")) {
			todate = "2115-01-01";
		}
		return todate;
	}

	public void location() {
		String shopId=req.getParameter("shopId");//从消息中传过来
		request.put("shopId",shopId);
	}
}
