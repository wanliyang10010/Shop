<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>分配角色权限</title>
<base href="<%=basePath%>">
<s:head/>
<script type="text/javascript" src="<%=basePath%>js/jQuery/jquery-1.9.0.js"></script>
<script type="text/javascript" src="<%=basePath%>js/security/role/roleMapAuthority.js"></script>
<!-- 

<script type="text/javascript" src="<%=basePath%>/js/Alert.js"></script>
 -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/security/role/roleMapAuthority.css">
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
<h2>分配角色权限</h2>
	</div>
	
	<s:form action="roleMapAuthority_!update.action" >
		<input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid }" />
		<table id="mytable">
			<tr>
				<td>
					<!-- 
					<label>请选择角色:</label> -->
					<s:select label="请选择角色" 
						name="roleId" 
						list="roleList" 
						listKey="id" 
						listValue="roleName"   
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
						
						name="authoritiesId_L"
						leftTitle="角色已添加权限"
						list="authoritiesList_L"
						listKey="id"
						listValue="authorityName"
						multiple="true"
						headerKey="headerKey"
						headerValue="---请选择角色所需的权限---"
						emptyOption="false"
						allowUpDownOnLeft="false"
						addToLeftLabel="<-向左移动"
						addAllToLeftLabel="<--全部左移"
						cssStyle="width:220px;height:300px;"
						
						rightTitle="角色未添加权限"
						doubleList="authoritiesList_R"
						doubleListKey="id"
						doubleListValue="authorityName"
						doubleName="authoritiesId_R"
						doubleHeaderKey="doubleHeaderKey"
						doubleHeaderValue="---请选择角色所需的权限---"
						doubleEmptyOption="false"
						doubleMultiple="true"
						allowUpDownOnRight="false"
						addToRightLabel="向右移动->"
						addAllToRightLabel="全部右移-->"
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