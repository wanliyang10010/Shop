<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    
<%@taglib prefix="s" uri="/struts-tags"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>分配权限资源</title>
<base href="<%=basePath%>">
<script type="text/javascript" src="<%=basePath%>js/jQuery/jquery-1.9.0.js"></script>

<script type="text/javascript" src="<%=basePath%>js/security/authority/authorityMapResource.js"></script>
<!-- 
<script type="text/javascript" src="<%=basePath%>/js/Alert.js"></script>
 -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/security/authority/authorityMapResource.css">

<s:head/>
  


<script type="text/javascript">
 function myself(){
 var right=document.forms[0].resourceName_L;
 for(i=1; i <right.length; i++)
 right[i].selected = true;
}
</script> 
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
	<h2>分配权限资源</h2>
	</div>
	<div id="formFather">
		<s:form action="authorityMapResource_!update.action" id="sform">
			<input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid }" />
			<table id="mytable">
				<tr>
					<td>
					<!-- 
					<label>请选择权限:</label> -->
					<s:select label="请选择权限" 
						name="authorityId" 
						list="authoritiesList" 
						listKey="id" 
						listValue="authorityName"   
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
					
					name="resourceId_L"
					leftTitle="权限已添加资源"
					list="resourcesList_L"
					listKey="id"
					listValue="resourceName"
					multiple="true"
					headerKey="headerKey"
					headerValue="---请选择权限所需的资源---"
					emptyOption="false"
					allowUpDownOnLeft="false"
					addToLeftLabel="<-向左移动"
					addAllToLeftLabel="<--全部左移"
					cssStyle="width:300px;height:400px;"
					
					
					rightTitle="权限未添加资源"
					doubleList="resourcesList_R"
					doubleListKey="id"
					doubleListValue="resourceName"
					doubleName="resourceId_R"
					doubleHeaderKey="doubleHeaderKey"
					doubleHeaderValue="---请选择权限所需的资源---"
					doubleEmptyOption="false"
					doubleMultiple="true"
					allowUpDownOnRight="false"
					addToRightLabel="向右移动->"
					addAllToRightLabel="全部右移-->"
					doubleCssStyle="width:300px;height:400px;"
					
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
	</div>
</body>
</html>