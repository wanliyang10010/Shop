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
<title>注册</title>
<base href="<%=basePath%>">
<!-- -->
<script type="text/javascript" src="<%=basePath%>js/jQuery/jquery-1.9.0.js"></script>
<script type="text/javascript" src="<%=basePath%>js/security/user/register.js"></script> 
<script type="text/javascript" src="<%=basePath%>/js/Alert.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/security/user/register.css">
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
 -->
<br>
 
 <div class="h2Center">
<h2>添加用户</h2>
</div>

<form action="<%=path%>/userAction_!create.action" method="post" enctype="multipart/form-data">
	<div id="msg">
		<font color="red" id="font1">${msg}</font>
	</div>
	<table  id="mytable">
		<tr>
			<td>
				<span>用户名：</span>
			</td>
			<td>
				<input type="text" name="user.account" value="${user.account}" placeholder="请输入注册的邮箱" id="account" value="${user.account}" class="myinput"></input>
			</td>
		</tr>
		<tr>
			<td>
				<span>姓名：</span>
			</td>
			<td>
				<input type="text" name="user.username" id="username" value="${user.username}" class="myinput"></input>
			</td>
		</tr>
		<tr>
			<td>
				<span>密码：</span>
			</td>
			<td>
				<input type="password" name="user.password" id="password" value="${user.password}" class="myinput"></input>
			</td>
		</tr>
		<tr>
			<td>
				<span>用户描述：</span>
			</td>
			<td>
				<textarea rows="3" cols="20" name="user.description" id="description" value="${user.description}" class="mytextarea"></textarea>
			</td>
		</tr>
		

		<tr>
			<td>
			 	<span>单位：</span>
					</td>
					<td>
						<input type="text" name="user.company"  id="company" value="${user.company}" class="myinput" />
					</td>
				</tr>
				<tr>
					<td>
						<span>部门：</span>
					</td>
					<td>
						<input type="text" name="user.department" id="department" value="${user.department}" class="myinput" />
					</td>
				</tr>
				<tr>
					<td>
						<span>职务：</span>
					</td>
					<td>
						<input type="text" name="user.memberpost"  id="memberpost"  value="${user.memberpost}" class="myinput" />
					</td>
				</tr>
				<tr>
					<td>
					<span>手机号码：</span>
					</td>
					<td>
						<input  name="user.phonenumber" type="text" required="true" value="${user.phonenumber}" id="phonenumber"
						  maxlength="11"   onkeyup="value=value.replace(/[^\d]/g,'') "  class="myinput"/>
					</td>
				</tr>
				<tr>
					<td>
						<span>身份证号码：</span>
					</td>
					<td>
						<input type="text" name="user.idnumber" id="idnumber"  value="${user.idnumber}"  onkeyup="value=value.replace(/[\W]/g,'') "
						onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[\W]/g,''))" class="myinput"/>
					</td>
				</tr>
				<tr>
    				<td align="center" width="100">
    				<span>照片：</span>
    				</td>
    				<td><input type="file" id="picture" name="upload" /></td>
    			</tr>
    			<tr>
					<td colspan="2">
						<input type="submit" value="提交" id="mysubmit"></input>
						&nbsp&nbsp&nbsp&nbsp&nbsp
						<input type="reset" value="重置"></input>
					</td>
				</tr>
	</table>
</form>

</body>
</html>