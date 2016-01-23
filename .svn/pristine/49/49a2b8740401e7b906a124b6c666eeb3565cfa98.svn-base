<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<s:token />
<title>商品添加</title>
	<%@ include file="/common/top-head.jspf"%>
<link rel="stylesheet" type="text/css"  href="${ctx}/css/page.css"/> 
<script type="text/javascript" src="${ctx}/js/web1.js"></script>
<script type="text/javascript" src="${ctx}/js/Goods/GoodsInfo.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
<div id="templatemo_main">
	<center>
		<form name="form1" action="" id="form1" autocomplete="off">
		<input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
		<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	  <input type="hidden" name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
	  <input type="hidden" name="shopId" id="shopId" value="${shop.shopId}"/>
	  <input type="hidden" name="Smark" id="Smark" value="0"/>
			<h1>商品添加</h1>
			 <table width="800"   border="1" oncontextmenu=return(false)>
                        <tr> 
                                     <td align="right" width="30%" >
                                        <label for="textfield">店铺名称：</label>
                                    </td>
                                    <td align="left">
                                      <label for="textfield">${sessionScope.shop.shopname}</label>
                                    </td>
                                </tr>
				<tr>
					<td align="right"><label for="textfield">商品类别：</label></td>
					<td align="left">${shop.productcategory}</td>
				</tr>
				<c:choose>
								<c:when test="${sessionScope.goodstypeList!=null&&sessionScope.goodstypeList.size()>0}">
									<tr>
					<td align="right"><label for="textfield">商品子类别：</label></td>
					<td align="left">
					<select name="typeid" id="typeid">
					       <option value="请选择">请选择</option>   
							<c:forEach items="${sessionScope.goodstypeList}" var="goodstype">
								 <option value="${goodstype.gtypeId}">${goodstype.typename}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">商品名称：</label></td>
					<td align="left">
					 <input type="text" name="goodsname" id="goodsname" size="50" maxlength="30">
					 <input type="checkbox" id="checkbox">添加为二手
					</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">商品单价(元)：</label></td>
					<td align="left">
					 <input type="text" name="price" id="price"  maxlength="7" onpaste="return false"
					 onkeyup="var myreg=/^[0-9]+\.?[0-9]{0,2}$/;if(!myreg.test(this.value)){this.value=''; }; "
					 oninput="var myreg=/^[0-9]+\.?[0-9]{0,2}$/;if(!myreg.test(this.value)){this.value=''; }; "   
					 onpropertychange="var myreg=/^[0-9]+\.?[0-9]{0,2}$/;if(!myreg.test(this.value)){this.value=''; }; "
					 >
					</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">运费(元)：</label></td>
					<td align="left">
					 <input type="text" name="freight" id="freight"   maxlength="5" onpaste="return false"
					 onkeyup="var myreg=/^[0-9]+\.?[0-9]{0,2}$/;if(!myreg.test(this.value)){this.value=''; }; "
					 oninput="var myreg=/^[0-9]+\.?[0-9]{0,2}$/;if(!myreg.test(this.value)){this.value=''; }; "   
					 onpropertychange="var myreg=/^[0-9]+\.?[0-9]{0,2}$/;if(!myreg.test(this.value)){this.value=''; }; " >
					</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">库存量：</label></td>
					<td align="left">
					 <input type="text" name="amount" id="amount" maxlength="8" onpaste="return false"
					  onkeyup="var myreg=/^([1-9][0-9]*)$/;if(!myreg.test(this.value)){this.value=''; }; "
					oninput="var myreg=/^([1-9][0-9]*)$/;if(!myreg.test(this.value)){this.value=''; }; "   
					 onpropertychange="var myreg=/^([1-9][0-9]*)$/;if(!myreg.test(this.value)){this.value=''; }; ">
					</td>
				</tr>
				<tr>
				<tr>
					<td align="center" colspan="2">
					<input type="button" name="btn_submit" id="btn_submit" value="添加" onclick="add();">
					 &nbsp;&nbsp; 
					<input type="button" name="btn_cancel" id="btn_cancel" value="取消" onclick="cancel();"></td>
				</tr>
								</c:when>
								<c:otherwise>
									<tr>
					<td align="center" colspan="2">
					<font color="red" id="font1" >您尚未添加商品子类别，请添加子类别后再进行商品添加操作</font>
					 <a href="${ctx}/GoodsType/GoodsTypeManage.jsp">前往添加商品子类别</a>
					</td>
				</tr>
								</c:otherwise>
							</c:choose>
			</table>
			<div>
		</form>
	</center>
	</div>
</body>
</html>
