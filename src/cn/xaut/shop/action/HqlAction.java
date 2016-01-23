package cn.xaut.shop.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.commons.lang.StringUtils;

import cn.xaut.shop.pojo.SqlQuery;

public class HqlAction extends BaseAction<SqlQuery> {

	private static final long serialVersionUID = -3931640404524402262L;
	
	public String list() {
		return "list";
	}

	public String execHql() {

		try {

			if (!StringUtils.isEmpty(model.getCommand())) {

				int flag = hqlService.executeHql(model);
				jsonMap.put("data", flag >= 0 ? "执行成功" : "执行失败");

			} else {
				jsonMap.put("data", "请填写HQL语句");
			}
		} catch (Exception e) {
			jsonMap.put("data", e.getMessage());
		}

		return "json";
	}
	
	
	public String queryByHql() {
		try {
			if (!StringUtils.isEmpty(model.getCommand())) {

				List list = hqlService.queryByHql(model);
				JsonConfig jsonConfig = new JsonConfig();
				jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
				//设置默认忽略
				jsonConfig.setIgnoreDefaultExcludes(false);
				//将所需忽略字段加到数组中shop  good  goods userinfo roles owner 
				jsonConfig.setExcludes(new String[]{"shop","userinfo","good","goods","roles","owner"});
				
				JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
				
				jsonMap.put("list", jsonArray.toString());
				jsonMap.put("data", "执行成功");
				jsonMap.put("dataFlag", "结果数:"+ list.size());

			} else {
				this.request.put("data", "请填写Sql语句");
			}
			
		} catch (ClassNotFoundException e) {
			 jsonMap.put("data", "类名出错");
			//e.printStackTrace();
		} catch (Exception e) {
			jsonMap.put("data", e.getMessage());
			//e.printStackTrace();
		}
		return "json";
	}
	
	
	
	
	
	

	public String execSql() {
		try {

			if (!StringUtils.isEmpty(model.getCommand())) {
				int flag = hqlService.executeSql(model);
				jsonMap.put("data", flag >= 0 ? "执行成功" : "执行失败");
				jsonMap.put("dataFlag", flag);
			} else {
				jsonMap.put("data", "请填写Sql语句");
			}
		} catch (Exception e) {
			//e.printStackTrace();
			jsonMap.put("data", e.getMessage());
		}

		return "json";// list
	}

	public String queryBySql() {
		try {
			if (!StringUtils.isEmpty(model.getCommand())) {

				List list = hqlService.queryBySql(model);
				JsonConfig jsonConfig = new JsonConfig();
				jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
				//设置默认忽略
				jsonConfig.setIgnoreDefaultExcludes(false);
				//将所需忽略字段加到数组中shop  good  goods userinfo roles owner 
				jsonConfig.setExcludes(new String[]{"shop","userinfo","good","goods","roles","owner"});
				
				JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
				
				jsonMap.put("list", jsonArray.toString());
				jsonMap.put("data", "执行成功");
				jsonMap.put("dataFlag", "结果数:"+ list.size());

			} else {
				this.request.put("data", "请填写Sql语句");
			}
			
		} catch (ClassNotFoundException e) {
			 jsonMap.put("data", "类名出错");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			jsonMap.put("data", e.getMessage());
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		return "json";
	}
	
}
