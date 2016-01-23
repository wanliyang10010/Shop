package cn.xaut.shop.phoneAction;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.xaut.shop.action.BaseAction;
import cn.xaut.shop.pojo.Category;
import cn.xaut.shop.pojo.CategorySon;
import cn.xaut.shop.pojo.Goods;
import cn.xaut.shop.pojo.UserInfo;

/*
 * 
 * 1.基本所有的Action都需要用到request session application 内置对象
 * 
 * 通过他们存数数据，交给前台页面显示，Struts提供了AOP+Ioc的方式，在运行的时候自动注入->实现几个接口就可以了
 * 
 * 2. 前台页面中所有的数据名称，必须要用[对象.属性]方式取值， 这样做耦合性太高，我们可以实现一个接口来解耦
 * 
 * */

@SuppressWarnings("serial")
public class CategoryActionPhone extends BaseAction<Category> {

	public String cancel() {
		List<Category> categorys = categoryService.query();
		request.put("GET", categorys);
		return "categoryCancel";
	}

	public String updateno() {
		List<Category> category = categoryService.query();
		request.put("categorys", category);
		return "categoryQuery";
	}

	// new
	// 存主表信息
	public String save() {
		UserInfo user = (UserInfo) session.get("userinfo");
		int userid = user.getUserinfoId();
		model.setUserid(userid);
		categoryService.save(model);
		List<Category> categorys = categoryService.queryByUserid(userid);
		request.put("categorys", categorys);
		return "categorySaved";
	}

	// 根据userid查询出所属店铺商品类别
	public String queryCategory() {
		UserInfo user = (UserInfo) session.get("userinfo");
		int userid = user.getUserinfoId();
		List<Category> category = categoryService.queryByUserid(userid);
		request.put("categorys", category);
		return "categoryQueryed";
	}

	// 商品属性描述添加
	public String addproperty() {
		String CategoryId = ServletActionContext.getRequest().getParameter(
				"cid");
		int categoryid = Integer.parseInt(CategoryId);
		Category category = categoryService.queryById(categoryid);
		session.put("list", category);
		List<CategorySon> categorySon = categorySonService
				.queryById(categoryid);
		request.put("categoryson", categorySon);
		return "categoryProperty";
	}

	// 删除属性描述
	public String deleteproperty() {
		Category categorymain = (Category) session.get("list");
		int categoryid = categorymain.getCid();
		String categorysonid = ServletActionContext.getRequest().getParameter(
				"categorysonid");
		int idson = Integer.parseInt(categorysonid);
		categorySonService.delete(idson);
		List<CategorySon> categoryson = categorySonService
				.queryById(categoryid);
		request.put("categoryson", categoryson);
		return "categoryDelete";
	}

	// 添加属性描述
	public String saveproperty() {
		String property = ServletActionContext.getRequest().getParameter(
				"property");
		Category categorymain = (Category) session.get("list");
		int categoryid = categorymain.getCid();
		CategorySon son = new CategorySon();
		son.setCategoryid(categoryid);
		son.setProperty(property);
		categorySonService.save(son);
		addproperty();
		return "categoryProperty";
	}

	public String manage() {
		UserInfo user = (UserInfo) session.get("userinfo");
		int userid = user.getUserinfoId();
		List<Category> categorys = categoryService.queryByUserid(userid);
		request.put("categorys", categorys);
		return "categoryQuery";
	}

	public String update() {
		UserInfo user = (UserInfo) session.get("userinfo");
		int userid = user.getUserinfoId();
		List<Category> categorys = categoryService.queryByUserid(userid);
		System.out.print("list的个数是：" + categorys.size());
		request.put("categorys", categorys);
		String cid = ServletActionContext.getRequest().getParameter("cid");
		int categoryid = Integer.parseInt(cid);
		Category categorypick = categoryService.queryById(categoryid);
		session.put("categorypick", categorypick);
		request.put("categorystype", categorypick.getCtype());
		return "categoryQuery";
	}

	public String updateensure() {

		String cid = ServletActionContext.getRequest().getParameter("cid");
		int categoryid = Integer.parseInt(cid);
		Category categorypick = categoryService.queryById(categoryid);
		String ctype = ServletActionContext.getRequest().getParameter("ctype");
		categorypick.setCtype(ctype);
		categoryService.update(categorypick);
		UserInfo user = (UserInfo) session.get("userinfo");
		int userid = user.getUserinfoId();
		List<Category> categorys = categoryService.queryByUserid(userid);
		request.put("categorys", categorys);
		return "categoryChange";
	}

	public String detailsproperty() {
		String CategoryId = ServletActionContext.getRequest().getParameter(
				"cid");
		int categoryid = Integer.parseInt(CategoryId);
		Category category = categoryService.queryById(categoryid);
		session.put("list", category);
		List<CategorySon> categorySon = categorySonService
				.queryById(categoryid);
		request.put("categoryson", categorySon);
		return "categoryDetails";
	}

	public String updateok() {
		String categorysonid = ServletActionContext.getRequest().getParameter(
				"categorysonid");
		int idson = Integer.parseInt(categorysonid);
		String property = ServletActionContext.getRequest().getParameter(
				"property");
		CategorySon Son = categorySonService.queryByMainId(idson);
		Son.setProperty(property);
		categorySonService.update(Son);
		detailsproperty();
		return "categoryDetails";
	}

	public String delete() {
		UserInfo user = (UserInfo) session.get("userinfo");
		int userid = user.getUserinfoId();
		String cid = ServletActionContext.getRequest().getParameter("cid");
		int categoryid = Integer.parseInt(cid);
		List<Goods> goods = goodsService.queryGoodsByCid(categoryid);
		for (int i = 0; i < goods.size(); i++) {
			//if (goods.get(i).getCategory().getCid() == categoryid) {
				//goodsService.delete(goods.get(i).getGid());
			//}
		}
		categoryService.delete(categoryid);
		List<Category> category = categoryService.queryByUserid(userid);
		request.put("categorys", category);
		return "categoryQuery";
	}
}
