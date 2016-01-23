package cn.xaut.shop.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.web.context.support.WebApplicationContextUtils;
public class ShopServleContextListener implements ServletContextListener {
	//private ShopTimerTask shopTimerTask=null;

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent se) {
		// TODO Auto-generated method stub
		
		WebApplicationContextUtils.getWebApplicationContext(se.getServletContext());
		
		
	}
}
		

