package cn.xaut.shop.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.UserPoint;
import cn.xaut.shop.pojo.OrderSon;
import cn.xaut.shop.pojo.ShopEvaluation;
import cn.xaut.shop.pojo.Shop;
import cn.xaut.shop.pojo.UserInfo;

public class UserPointAction extends BaseAction<UserPoint> {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest req = ServletActionContext.getRequest();

	// 转发用户积分
	public String forwardUserPoint() {
		UserInfo user = (UserInfo) session.get("userinfo");
		
		List<UserPoint> userPointList = userPointService.getListByUserId(user
				.getUserinfoId());
		if (userPointList == null || userPointList.size() == 0) {
			request.put("msg_userpoint", "0分");
		} else {
			int userpointTemp = 0;
			for (int i = 0; i < userPointList.size(); i++) {
				if(userPointList.get(i).getPlusminus().equals("+")){
					userpointTemp += userPointList.get(i).getPoint();
				}else if(userPointList.get(i).getPlusminus().equals("-")){
					userpointTemp -= userPointList.get(i).getPoint();
				}else{
					request.put("msg_userpoint", "对不起，您的积分有误，请联系管理员！");
				}				
			}
			String userpoint = userpointTemp + "分";
			request.put("msg_userpoint", userpoint);
			request.put("userPointList", userPointList);
		}
		
		page = userPointService.getListByUserId(page,user.getUserinfoId());
		request.put("page", page);
			
		return "forwardUserPoint";
	}		
}
