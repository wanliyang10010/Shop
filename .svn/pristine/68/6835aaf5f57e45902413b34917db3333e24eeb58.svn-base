<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<s:token />
<title>商品类别子项管理</title>
	<%@ include file="/common/top-head.jspf"%>
<link rel="stylesheet" type="text/css"  href="${ctx}/css/page.css" />  
<script type="text/javascript" src="${ctx}/js/web1.js"></script>
<script type="text/javascript" src="${ctx}/js/GoodsType/GoodsTypeItemManage.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
<div id="templatemo_main">
	<center>
		<form name="form1" action="" id="form1">
		<input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
		<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	  <input type="hidden" name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
	   <input type="hidden" name="gtypeId" id="gtypeId" value="${sessionScope.goodstype.gtypeId}"/>
	  <input type="hidden" name="gtItemId" id="gtItemId"/>
			 <table width="800">     
				<tr>
					<td align="right" width="30%"><label for="textfield">商品二级类别：</label></td>
					<td align="left">${sessionScope.goodstype.typename}</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">属性名称：</label></td>
					<td align="left"><input type="text" name="itemname" id="itemname" maxlength="15" size="40" >
					<font color="red" id="font1" >${msgjudge}</font>
					</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">备注信息：</label></td>
					<td align="left">
					 <textarea rows="3" cols="60" name="remark" id="remark" maxlength="50"  onkeyup="if(value.length>50) value=value.substr(0,50);" style="overflow:hidden"></textarea>
					</td>
				</tr>
				<tr>
				<tr>
					<td align="center" colspan="2">
					<input type="button" name="btn_update" id="btn_update" value="修改" onclick="update();" style="display:none"> 
					  &nbsp;&nbsp; 
					<input type="button" name="btn_submit" id="btn_submit" value="添加" onclick="add();">
					 &nbsp;&nbsp; 
					<input type="button" name="btn_cancel" id="btn_cancel" value="取消" onclick="cancel();"></td>
				</tr>
			</table>
			<div>
		 <table width="800">
                                <tr>
                                    <td align="right" style=" width:30%" >
                                    <label for="textfield">属性名称：</label>
                                    </td>
                                    <td align="left">
                                       <input type="text" name="keyword" id="keyword" size="25" value="${param.keyword}">
                                         <button id="btn_submit"  onclick="search();" >查询</button>
                                    </td>
                                </tr>
            </table>	
		<c:if test="${msg==''}">  		
       <table width="800"  align="center" >
	     <tr height="40">
	          <td align="center" width=10%>序号</td>
		      <td align="center" width=30%>属性名称</td>
		      <td align="center" width=40%>备注</td>
		      <td align="center" width=20%>操作</td>
	     </tr>
		     <s:iterator value="#request.page" status="s">
		    <tr>
		         <td  align="center" width=10%>${s.count+(page.pageNo-1)*page.pageSize}</td>
		        <td align="center" width=30%>${itemname}</td>
			    <td  align="center"  width=40% >${remark}</td>
			     <td  align="center"  width=20%>
			    	<a href="javascript:updateItem('${gtitemId}','${itemname}','${remark}');">修改</a> &nbsp; 
			    	<a href="javascript:deleteItem('${gtitemId}');">删除</a> &nbsp; 
			     </td>
		    </tr>
	    	   </s:iterator>
	   </table>
	    </c:if>
	    <%@ include file="/common/pagination.jspf" %>
	         <div id="msg" >
	              <font color="red" id="font1" >${msg}</font>
	   
			</div>
		</form>
	</center>
	 <br/>
	  <br/>
	</div>
</body>
</html>
