package cn.xaut.common.config;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xaut.shop.action.AdminUserAction;
import cn.xaut.shop.action.SuperUserAction;
import cn.xaut.shop.action.UserInfoAction;
import cn.xaut.shop.action.UserLoginAction;

@Transactional
@Service("timeCountService")
public class TimeCountService {

	public void execute(){
		//System.out.println("定时器、。。。。。。。。");			
		boolean nativeTime=TimeCountFactory.getInstance().nativeTime();
		boolean netTime=TimeCountFactory.getInstance().netTime();
		if(nativeTime||netTime){
			System.out.println("到期了");
			UserInfoAction.isarrive =  true;
			SuperUserAction.isarrive = true;
			AdminUserAction.isarrive = true;
			UserLoginAction.isarrive = true;
		}
	}
}
