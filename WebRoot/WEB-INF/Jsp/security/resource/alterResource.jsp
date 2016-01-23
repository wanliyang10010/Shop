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
<title>修改资源</title>
<script type="text/javascript" src="<%=basePath%>js/jQuery/jquery-1.9.0.js"></script>

<script type="text/javascript" src="<%=basePath%>js/security/resource/alterResource.js"></script>
<!-- 
<script type="text/javascript" src="<%=basePath%>/js/Alert.js"></script>
 -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/security/resource/alterResource.css">

<base href="<%=basePath%>">
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
	<h2>修改资源</h2>
	</div>
<form action="searchDeleteResourceAction_!update.action" method="post">
	<input type="hidden" name="resource.id" id="id" value="${resource.id}"/>
	<input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid }" />
	<br />
	<table  id="mytable">
		<tr>
			<td>
				<span>资源名称：</span>
			</td>
			<td>	
				<input type="text" name="resource.resourceName" id="resourceName" class="myinput" value="${resource.resourceName}" readonly="readonly" placeholder="资源名称格式不正确！格式要求：以RESO_开头，后面接有字母、数字和下划线组成的串。"></input>
			</td>
		</tr>
		<tr>
			<td>		
				<span>资源类型：</span>
			</td>
			<td>
				<input type="radio" name="resource.type" value="action" id="resourceTypeAction" <c:if test="${resource.type != 'url'}">checked="checked"</c:if>>action</input>	
				&nbsp&nbsp
				<input type="radio" name="resource.type" value="url" id="resourceTypeUrl" <c:if test="${resource.type=='url'}">checked="checked"</c:if>>url</input>

			</td>
		</tr>
		<tr>
			<td>
				<span>资源链接：</span>
			</td>
			<td>	
				<!-- 
				<input type="text" name="resource.resourceString" id="resourceString" class="myinput" value="${resource.resourceString}"></input>
				 -->
				 <s:select             
						name="resource.resourceString" 
						list="resourceStringList" 
						listKey="resourceString" 
						listValue="resourceString"   
						headerKey="-1" 
						headerValue="------请选择------"
						id="resourceString"
						value="resource.resourceString"
						>
				</s:select>
			</td>
		</tr>
		<tr>
			<td>		
				<span>资源描述：</span>
			</td>
			<td>	
				<textarea rows="3" cols="20" name="resource.description" id="description" class="mytextarea"><c:if test="${resource.description!=''}">${resource.description}</c:if></textarea>
			</td>
		</tr>
		<tr>
			<td>	
				<span>是否禁用：</span>
			</td>
			<td>	
				<input type="radio" name="resource.enabled" value="0" <c:if test="${resource.enabled=='0'}">checked="checked"</c:if>>否</input>
				&nbsp&nbsp
				<input type="radio" name="resource.enabled" value="1" <c:if test="${resource.enabled=='1'}">checked="checked"</c:if>>是</input>
			</td>
		</tr>
		<tr>	
			<td>
				<span>是否是超级权限：</span>
			</td>
			<td>	
				<input type="radio" name="resource.isSys" value="0" <c:if test="${resource.isSys=='0'}">checked="checked"</c:if>> 否</input>
				&nbsp&nbsp
				<input type="radio" name="resource.isSys" value="1" <c:if test="${resource.isSys=='1'}">checked="checked"</c:if>> 是</input>
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