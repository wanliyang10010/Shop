<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript"  src="js/other_web.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jQuery/jquery-1.9.0.js"></script>

<script type="text/javascript" src="<%=basePath%>js/security/resource/searchDeleteResource.js"></script>
<!-- 
<script type="text/javascript" src="<%=basePath%>/js/Alert.js"></script>
 -->
<script type="text/javascript" src="<%=basePath%>js/tableColor.js"></script>


<link rel="stylesheet" type="text/css" href="<%=basePath%>css/security/resource/searchDeleteResource.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/table_color.css" ></link>
<title>变更资源</title>
<style type="text/css">
.h2Center{
	text-align: center;
}
.col1 {width:15%;}
.col2 {width:15%;}
.col3 {width:10%;}
.col4 {width:15%;}
.col5 {width:15%;}
.col6 {width:10%;}
.col7 {width:10%;}
.col8 {width:10%;}
</style>
</head>
<body>
	<div  id="pagecontent">
	<!-- 
	<div id="fanhui">
		<form  action="" id="fanhuiform">
			<input type="button" value="返回主页" id="fanhuibutton" />
		</form>
		
	</div> 
	 -->
	<div class="h2Center">
	<h2>变更资源</h2>
	</div>
		<form action="searchDeleteResourceAction_!search.action" method="post" id="myform">
			<input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid }" />
			<table  id="mytable">
				<tr>
					<td>
						<span>查询方式：</span>
					</td>
					<td>
						<select id="selectId" name="selectId">
						  <option value="-1">请选择查询方式</option>
						  <option value ="resourceName"  <c:if test="${'resourceName' eq selectId}">selected</c:if>>资源名称</option>
						  <option value ="resourceString" <c:if test="${'resourceString' eq selectId}">selected</c:if>>资源链接</option>
						  <option value ="description" <c:if test="${'description' eq selectId}">selected</c:if>>资源描述</option>
						  <option value ="allResource" <c:if test="${'allResource' eq selectId}">selected</c:if>>查询所有资源</option>
					    </select>
				    </td>
				 </tr>
				 <tr>
				 	<td>
				        <span>查询条件：</span>
				    </td>
				    <td>
				    	<input type="text" id="queryItems" name="queryItems"  class="myinput"  value="${queryItems}"></input>
				 	</td>
				 </tr>
				 <tr>  
				   <td  colspan="2">
				    <input type="submit" value="查询" id="mysubmit"></input>
				   </td>
				 </tr>
			</table>
			<input type="hidden" name="page.currentPage" id="currentPage" value="${page.currentPage}"/>
			<input type="hidden" name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
	    </form>
	    <s:if test="page.allRow > 0">
	    <hr />
	    <table  id="myresult" align="center">
	    	<thead>
				<tr>
					<th align="center">资源编号</th>
					<th align="center">资源名称</th>
					<th align="center">资源类型</th>
					<th align="center">资源链接</th>
					<th align="center">资源描述</th>
					<th align="center">是否有效</th>
					<th align="center">删除</th>
					<th align="center">修改</th>
								
				</tr>
			</thead>
			<tbody>
				<s:iterator value="page.list" status="s">
					<tr onmouseover="over_color(this)" onmouseout="remove_color(this)"  class="tr-color cursor">
						<td align="center" class="col1">${id}</td>
						<td align="center" class="col2">${resourceName}</td>
						<td align="center" class="col3" >${type}</td>
						<td align="center" class="col4">${resourceString}</td>
						<td align="center" class="col5">${description}</td>
						<td align="center" class="col6">${enabled}</td>	
						<td align="center" class="col7"><a onclick="alter(${id})" href="javascript:void(0)">修改</a></td>				
						<td align="center" class="col8"><a onclick="click_color(this);confirm_del(${id})" href="javascript:void(0)" >删除</a></td>
					</tr>
				</s:iterator>
			</tbody>
	    	<tfoot>
					<tr>
						<td colspan="8">
						<%@ include file="/common/other_pagination.jspf" %>
						</td>
					</tr>
			</tfoot>
	    </table>
	    
	    </s:if>
	    <s:if test="page.allRow == 0">没有符合查询条件的数据</s:if>
	</div>
</body>
</html>