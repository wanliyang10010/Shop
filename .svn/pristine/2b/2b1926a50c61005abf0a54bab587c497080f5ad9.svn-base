package cn.xaut.shop.action;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import cn.xaut.shop.pojo.IdentifyPicture;
import cn.xaut.shop.pojo.MarginItem;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.ShopApply;
import cn.xaut.shop.pojo.UploadFile;
import cn.xaut.shop.pojo.UserInfo;
import cn.xaut.shop.pojo.UserPicture;


/*
 * 
 * 1.基本所有的Action都需要用到request session application 内置对象
 * 
 * 通过他们存数数据，交给前台页面显示，Struts提供了AOP+Ioc的方式，在运行的时候自动注入->实现几个接口就可以了
 * 
 * 2. 前台页面中所有的数据名称，必须要用[对象.属性]方式取值， 这样做耦合性太高，我们可以实现一个接口来解耦
 * 
 * */

public class ShopApplyAction extends BaseAction<ShopApply> {

	private static final long serialVersionUID = 1L;

	private UserPicture userPicture;// 上传半身照
	private IdentifyPicture identifyPicture;// 上传身份证正面
	private UploadFile uploadFile; // 上传身份证反面
	private HttpServletRequest req = ServletActionContext.getRequest();
	
	//得到商品类别
	 public String searchProductcategory()
	   {
		  List<MarginItem> list=marginItemService.query();
		  session.put("MarginItemList", list);
		  //判断该用户是否申请过店铺
		  UserInfo user = (UserInfo) session.get("userinfo");		 
			if (shopApplyService.isApply(user.getUserinfoId())) {
				request.put("msg_isShopApply", "对不起，您已申请过开店，请查看审核结果！");
			}			
		  return "applyShop";   
	   }

	// 申请时检查用户名是否存在
	public String checkshopName() {
		ShopApply sa=new ShopApply();
		sa.setShopname(ServletActionContext.getRequest().getParameter("shopname"));
		ShopApply shopApply = shopApplyService.getCheckShopName(sa);
		if (shopApply != null && !shopApply.getShopApplyId().equals("")) {
			System.out.println(shopApply.getShopname());
			request.put("msg_shopname", "对不起，该店铺名已被注册！");
			jsonMap.put("data", "no");//no代表已被注册，不能用
		} else {
			request.put("msg_shopname", "该店铺名可以使用。注意：店铺名申请后不可更改！");
			jsonMap.put("data", "yes");//yes代表可以使用
		}
		return "json";
	}

	// 申请时添加申请表
	public String save() {
		UserInfo user = (UserInfo) session.get("userinfo");
		
		//验证是否是重复提交
		int id=-1;
		page = shopApplyService.getMyViewList(page, fromdate(), todate(),user,id);
		if (page != null && page.getTotalItems() > 0) {						
			return "reOperation";	
		}
		
		Date now = new Date();
		model.setUserinfo(user);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		model.setApplyTime(dateFormat.format(now));
		
		//String filename=uploadFile.getItemFileName();
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
		model.setAddrarea(req.getParameter("addrArea"));
		int shopApplyId= shopApplyService.add(model).getShopApplyId();

		//给管理员发送消息
		messageService.sendMessage(messageService,"新收到一条店铺申请需审核！", user.getUserinfoId(), 0,
				"shopApplyAction_searchAllCheckList.action", "shopId", shopApplyId);
		return "viewShopProgressRedirect";
	}

	// 审核时查找记录
	public String searchAllCheckList() {
		location();//消息定位
		int id=-1;
		if(req.getParameter("shopId")!=null)
		{
		 id=Integer.parseInt(req.getParameter("shopId"));
		}
		page = shopApplyService.getAllCheckList(page, fromdate(), todate(),id);
		if (page == null || page.getTotalItems() == 0) {
			request.put("msg_searchAllList", "暂无需要审核的数据！");
		}
		request.put("page", page);// 需要审核的记录，以页面的形式返回
		//location();//消息定位
		return "checkShop";
	}

	// 审核通过，更新审核表，添加商品表
	public String updateAndSave() {
		String[] valus = req.getParameterValues("ckbox");
		UserInfo user = (UserInfo) session.get("userinfo");
		Date now = new Date();
		if (valus != null && valus.length != 0) {
			for (int i = 0; i < valus.length; i++) {
				int modelId = Integer.parseInt(valus[i]);
				ShopApply model = shopApplyService.get(modelId);
				
				//验证是否是重复提交
				if(model.getState().equals("1")){
					//return "reOperation";
					return "checkShopAction";
				}
											
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				model.setCheckuserinfo(user);
				model.setCheckTime(dateFormat.format(now));
				model.setCheckIdea(req.getParameter("checkIdea"));
				model.setState("1");//状态为1表示审核通过
				//shopApplyService.update(model);// 更新店铺申请表

				Shop modelShop = new Shop();
				modelShop.setShopApplyId(modelId);
				modelShop.setUserinfo(model.getUserinfo());
				modelShop.setRegeditdate(dateFormat.format(now));
				modelShop.setShopname(model.getShopname());
				modelShop.setShopcategory(model.getShopcategory());
				modelShop.setProductcategory(model.getProductcategory());
				modelShop.setPoint(0);
				modelShop.setMargin(0);
				modelShop.setMarginstate("0");//状态为0表示未交保证金
				modelShop.setShopstate("1");//状态为1表示店铺状态正常
				//shopService.save(modelShop);// 添加店铺表
				shopApplyService.updateAndSave(model,modelShop);
				
				//发送消息
				messageService.sendMessage(messageService,"您申请的店铺审核已通过，为了保障您享有开店的权利，请查看该消息后重新登录！",
						user.getUserinfoId(), model.getUserinfo().getUserinfoId(),
						"shopApplyAction_searchMyViewList.action","shopId", modelId);	
			}
		}			
		request.put("msg_checkover", "审核完成！");
		searchAllCheckList();
		return "checkShop";
	}

	// 审核不通过
	public String notpassupdate() {
		String[] valus = req.getParameterValues("ckbox");

		UserInfo user = (UserInfo) session.get("userinfo");
		Date now = new Date();
		if (valus != null && valus.length != 0) {
			for (int i = 0; i < valus.length; i++) {
				int modelId = Integer.parseInt(valus[i]);
				ShopApply model = shopApplyService.get(modelId);
				
				if(model.getState().equals("2")){
					return "checkShopAction";
				}
				
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				model.setCheckuserinfo(user);
				model.setCheckTime(dateFormat.format(now));
				model.setCheckIdea(req.getParameter("checkIdea"));
				model.setState("2");//状态为2表示审核未通过
				shopApplyService.update(model);// 更新店铺申请表				
				//发送消息
				messageService.sendMessage(messageService,"你申请的店铺审核未通过，请修改！",
						user.getUserinfoId(), model.getUserinfo().getUserinfoId(),
						"shopApplyAction_searchMyAlterList.action","shopId", modelId);	
			}
		}
		request.put("msg_checkover", "审核完成！");
		searchAllCheckList();
		return "checkShop";
	}

	// 修改时查找记录
	public String searchMyAlterList() {
		UserInfo user = (UserInfo) session.get("userinfo");
		int userid = user.getUserinfoId();
		List<ShopApply> alterShopList = shopApplyService.getMyAlterList(userid,
				 "2015-01-01", "2115-01-01", "2");
		if (alterShopList == null || alterShopList.size() == 0) {
			request.put("msg_searchMyAlterList", "暂无管理员审核不通过的店铺，只有您申请的店铺管理员审核不通过才能修改哦！");
		}
		request.put("alterShopList", alterShopList);// alterShopList得到所需要修改的记录
		location();//消息定位
		return "alterShop";
	}
	
	// 修改店铺时查找记录
	public String searchMyShopAlterList() {
		UserInfo user = (UserInfo) session.get("userinfo");
		int userid = user.getUserinfoId();
		List<ShopApply> viewShopList = shopApplyService.getMyAlterList(userid,
				 "2015-01-01", "2115-01-01", "1");			
		request.put("viewShopList", viewShopList);// alterShopList得到所需要修改的记录
		return "alterMyShop";
	}
		
	// 修改店铺后更新记录
	public String alterMyShopUpdate() {				
		ShopApply model2 = shopApplyService.get(model.getShopApplyId());			
		model2.setShopaddress(model.getShopaddress());
		model2.setShoppostnumber(model.getShoppostnumber());
		model2.setShopphone(model.getShopphone());
		shopApplyService.update(model2);// 更新店铺申请表
		return "viewShopRedirect";
	}
				
	// 店铺修改提交
	public String alterShopUpdate() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		ShopApply model2 = shopApplyService.get(model.getShopApplyId());
		
		if(model2.getState().equals("0")){
			return "reOperation";
		}
		
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
		return "viewShopProgressRedirect";
	}

	// 查看进度时查找记录
	public String searchMyViewList() {
		UserInfo user = (UserInfo) session.get("userinfo");
		location();//消息定位
		int id=-1;
		if(req.getParameter("shopId")!=null)
		{
		 id=Integer.parseInt(req.getParameter("shopId"));
		}
		page = shopApplyService.getMyViewList(page, fromdate(), todate(),user,id);
		if (page == null || page.getTotalItems() == 0) {			
			request.put("msg_searchMyViewList", "暂无数据！");
		}
		request.put("page",page);
		return "viewShopProgress";
	}
	//后台管理员查看审核进度
	public String adminViewShopProgress(){
		searchMyViewList();
		location();//消息定位
		return "adminViewShopProgress";
	}

	public String delete() {
		UserInfo user = (UserInfo) session.get("userinfo");	
		page = shopApplyService.getMyViewList(page, fromdate(), todate(),user,-1);
		if (page == null || page.getTotalItems() == 0) {			
			return "reOperation";
		}
		
		int id = model.getShopApplyId();
		shopApplyService.delete(id);
		request.put("msg_alterover", "删除成功！");
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
		String fromdate = req.getParameter("fromdate");
		if (fromdate == null || fromdate.equals("")) {
			fromdate = "2015-01-01";
		}
		return fromdate;
	}
	public String todate(){
		String todate = req.getParameter("todate");
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
