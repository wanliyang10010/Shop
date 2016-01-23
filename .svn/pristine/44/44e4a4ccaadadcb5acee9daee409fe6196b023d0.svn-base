<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>分配用户角色</title>

<base href="<%=basePath%>">
<s:head/>
<script type="text/javascript" src="<%=basePath%>js/jQuery/jquery-1.9.0.js"></script>
<script type="text/javascript" src="<%=basePath%>js/security/user/userMapRole.js"></script>
<!-- 
<script type="text/javascript" src="<%=basePath%>/js/Alert.js"></script>
 -->
<link rel="stylesheet" type="text/css" href="css/security/user/userMapRole.css">

<style type="text/css">
.h2Center{
	text-align: center;
}
</style>

<script type="text/javascript" src="<%=basePath%>js/struts/inputtransferselect.js"></script>
<script type="text/javascript" src="<%=basePath%>js/struts/optiontransferselect.js"></script>
<script type="text/javascript" src="<%=basePath%>js/struts/utils.js"></script>

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
	<h2>分配用户角色</h2>
	</div>
	<s:form action="userMapRole!update.action">
		<input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid }" />
		<table id="mytable">
			<tr>
				<td>
					<!-- 
					<label>请选择用户:</label> -->
					<s:select label="请选择用户" 
						name="userId" 
						list="userList" 
						listKey="userinfoId" 
						listValue="username"   
						headerKey="-1" 
						headerValue="------请选择------"
						id="selectId"
						>
					</s:select>
				</td>
			</tr>
			<tr>
				<td>
				<s:optiontransferselect 
					name="rolesId_L"
					
					leftTitle="用户已添加角色"
					list="rolesList_L"
					listKey="id"
					listValue="roleName"
					multiple="true"
					headerKey="headerKey"
					headerValue="---请选择用户所需的角色---"
					emptyOption="false"
					allowUpDownOnLeft="false"
					addToLeftLabel="<-向左移动"
					addAllToLeftLabel="<<-全部左移"
					cssStyle="width:220px;height:300px;"
					
					rightTitle="用户未添加角色"
					doubleName="rolesId_R"
					
					doubleList="rolesList_R"
					doubleListKey="id"
					doubleListValue="roleName"
					doubleHeaderKey="doubleHeaderKey"
					doubleHeaderValue="---请选择用户所需的角色---"
					doubleEmptyOption="false"
					doubleMultiple="true"
					allowUpDownOnRight="false"
					addToRightLabel="向右移动->"
					addAllToRightLabel="全部右移->>"
					doubleCssStyle="width:220px;height:300px;"
					  >
				</s:optiontransferselect>
			</td>
			</tr>
			<tr>
				<td align="center">
					<s:submit type="button"  value="提交" id="mysubmit"></s:submit>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>