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
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改角色</title>
<script type="text/javascript" src="<%=basePath%>js/jQuery/jquery-1.9.0.js"></script>
<script type="text/javascript" src="<%=basePath%>js/security/role/alterRole.js"></script>
<!-- 
<script type="text/javascript" src="<%=basePath%>/js/Alert.js"></script>
 -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/security/role/alterRole.css">
<style type="text/css">
.h2Center{
	text-align: center;
}
</style>
</head>
<body>
<!-- 
<div id="fanhui">
	<form  action="" id="fanhuiform">
		<input type="button" value="返回主页" id="fanhuibutton" />
	</form>
	
</div>
<br/>
 -->
 <div class="h2Center">
<h2>修改角色</h2>
</div>
<form action="searchRoleAction_!update.action" method="post">
	<input type="hidden" name="role.id" id="id" value="${role.id}"/>
	<input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid }" />
	<table id="mytable">
		<tr>
			<td>
				<span>角色名称：</span>
			</td>
			<td>
				<input type="text" name="role.roleName" id="roleName" value="${role.roleName}" readonly="readonly" class="myinput"></input>
			</td>
		</tr>
		<tr>	
			<td>	
				<span>是否被禁用：</span>
			</td>
			<td>
				<input type="radio" name="role.enabled" value="0"  <c:if test="${role.enabled=='0'}">checked</c:if>>否</input>
				&nbsp&nbsp
				<input type="radio" name="role.enabled" value="1"   <c:if test="${role.enabled=='1'}">checked</c:if>>是</input>
			</td>
		</tr>
		<tr>
			<td>
				<span>是否是超级用户：</span>
			</td>
			<td>
				<input type="radio" name="role.isSys" value="0"  <c:if test="${role.isSys=='0'}">checked</c:if>>否</input>
				&nbsp&nbsp
				<input type="radio" name="role.isSys" value="1"  <c:if test="${role.isSys=='1'}">checked</c:if>>是</input>
			</td>
		</tr>
		<tr>
			<td>
				<span>角色描述：</span>
			</td>
			<td>
				<textarea rows="3" cols="20" name="role.description" id="description" class="mytextarea"><c:if test="${role.description!=''}">${role.description}</c:if></textarea>
			</td>
		</tr>
		<tr>	
			<td colspan="2">	
				<input type="submit" value="更新" id="mysubmit"></input>
				&nbsp&nbsp&nbsp&nbsp&nbsp
				<!-- 
				<input type="button" value="重置" id="myreset"></input>
				&nbsp&nbsp&nbsp&nbsp&nbsp  -->
				<input type="button" name="reset" value="放弃修改返回" onclick="goback()">
			</td>
		</tr>
	</table>
	
</form>



</body>
</html>