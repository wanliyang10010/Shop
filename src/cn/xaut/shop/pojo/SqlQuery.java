package cn.xaut.shop.pojo;

import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.mysql.jdbc.ResultSetMetaData;
import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.sun.org.apache.commons.beanutils.PropertyUtils;

public class SqlQuery {

	private static final String PACKAGE = "cn.xaut.shop.pojo.";
	private String command;
	private String params;
	private String className;

	public SqlQuery() {

	}
	
	public String getFullClassName(){
		return PACKAGE + className;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params.replace("，", ",");
	}

	public List<String> getParamsList() {
		List<String> list = new ArrayList<String>();
		if (params != null && params.length() > 0) {
			String[] arr = params.split(",");
			for (String param : arr) {
				if (param.length() > 0)
					list.add(param);
			}
		}
		return list;
	}

	public List<Object> getResultList(List<Object> result) throws ClassNotFoundException {
		List<Object> list = new ArrayList<Object>();

		Class clazz = Class.forName(this.PACKAGE + this.getClassName());
		for (int i = 0; i < result.size(); i++) {
			Class clz = clazz.getClass().cast(result.get(i));
			list.add(clz);
		}
		return list;
	}
	
	
	public String convert(List<Object> list){
		
		//JSONObject json = new JSONObject();//将map对象转换成json类型数据
		
		JSONArray jsonArray = JSONArray.fromObject( list );  
		
		return jsonArray.toString();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	//----------------------------------------------------------------
	//  分割线
	///----------------------------------------------------------------

	// 参考代码 还没有什么用
	private List pares(ResultSet rs, Object o) throws Exception {
		List list = new ArrayList();

		Class cla = o.getClass();
		// 获取所有属性
		PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(cla);
		// 获取表头
		ResultSetMetaData rsm = (ResultSetMetaData) rs.getMetaData();
		while (rs.next()) {
			// 获取实例
			Object obj = cla.newInstance();
			for (PropertyDescriptor pd : pds) {
				String name = pd.getName();
				Boolean find = false;
				for (int i = 0; i < rsm.getColumnCount(); i++) {
					if (name.toLowerCase().equals(
							rsm.getColumnName(i + 1).toLowerCase())) {
						find = true;
						break;
					}
				}
				if (find) {
					String val = rs.getString(name);
					if (val != null && !"".equals(val)) {
						BeanUtils.setProperty(obj, name, val);
					}
				}
			}
			list.add(obj);
		}
		return list;
	}

	// 参考代码 没有什么用
	private List<Object> getList(Object o) {
		List<Object> list = new ArrayList<Object>();
		try {
			for (int i = 0; i < 10; i++) {
				Object b = o.getClass().newInstance();
				list.add(b);
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
