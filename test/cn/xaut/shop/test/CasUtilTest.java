package cn.xaut.shop.test;

import net.sf.json.JSONObject;

import org.junit.Test;

import cn.xaut.shop.pojo.CasUser;
import cn.xaut.shop.util.CasUserUtil;

public class CasUtilTest {
	
	
	@Test
	public void testCatUtil() throws Exception {
		
		String userId = "2220130774";
		String str_user = CasUserUtil.getCasUserJsonString(userId, "1");
		
		System.out.println(str_user);

	}
	
	@Test
	public void testCatUtilService() throws Exception {
		
		String userId = "2220130773";
		String str_user = CasUserUtil.getCasUserJsonString(userId, "1");
		
		String json = str_user;
		CasUser casUser = null; 
		try {
			json = CasUserUtil.getCasUserJsonString(userId, "1");
			JSONObject jsonObject = JSONObject.fromObject(json);
			JSONObject userjsonObject = jsonObject.getJSONObject("user");
			casUser = (CasUser) JSONObject.toBean(userjsonObject,CasUser.class);
		} catch (Exception e) {
			
		}
		System.out.println(casUser.getXm());

	}

}
