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
<title>修改权限</title>
<script type="text/javascript" src="<%=basePath%>js/jQuery/jquery-1.9.0.js"></script>

<script type="text/javascript" src="<%=basePath%>js/security/authority/alterAuthority.js"></script>
<!-- 
<script type="text/javascript" src="<%=basePath%>/js/Alert.js"></script>
 -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/security/authority/alterAuthority.css">
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
<h2>修改权限</h2>
</div>
<form action="searchDeleteAuthorityAction_!update.action" method="post">
	<input type="hidden" name="authority.id" id="id" value="${authority.id}"/>
	<input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid }" />
	<table id="mytable">
		<tr>
			<td>
				<span>权限名称：</span>
			</td>
			<td>	
				<input type="text" name="authority.authorityName" id="authorityName" class="myinput" value="${authority.authorityName}" readonly="readonly" placeholder="权限名称格式不正确！格式要求：以AUTH_开头，后面接有字母、数字和下划线组成的串。"></input>
			</td>
		</tr>
		<tr>	
			<td>	
				<span>是否被禁用：</span>
			</td>
			<td>
				<input type="radio" name="authority.enabled" value="0" <c:if test="${authority.enabled=='0'}">checked=true</c:if>>否</input>
				&nbsp&nbsp
				<input type="radio" name="authority.enabled" value="1" <c:if test="${authority.enabled=='1'}">checked=true</c:if>>是</input>
			</td>
		</tr>
		<tr>
			<td>
				<span>是否是超级用户：</span>
			</td>
			<td>	
				<input type="radio" name="authority.isSys" value="0" <c:if test="${authority.isSys=='0'}">checked=true</c:if>>否</input>
				&nbsp&nbsp
				<input type="radio" name="authority.isSys" value="1" <c:if test="${authority.isSys=='1'}">checked=true</c:if>>是</input>
			</td>
		</tr>
		<tr>	
			<td>
				<span>权限描述：</span>
			</td>
			<td>	
				<textarea rows="3" cols="20" name="authority.description" id="description" class="mytextarea"><c:if test="${authority.description!=''}">${authority.description}</c:if></textarea>
			</td>
		</tr>
		<tr>	
			<td colspan="2">
				<input type="submit" value="更新" id="mysubmit"></input>
				&nbsp&nbsp&nbsp&nbsp&nbsp
				<!-- 
				<input type="button" value="重置" id="myreset"></input>
				&nbsp&nbsp&nbsp&nbsp&nbsp -->
				<input type="button" name="reset" value="放弃修改返回" onclick="goback()">
			</td>
		</tr>
	</table>
</form>
</body>
</html>