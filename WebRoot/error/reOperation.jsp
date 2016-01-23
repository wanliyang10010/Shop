<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!-- 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>重复提交</title>
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="description" content="重复提交异常信息提示">
		<meta http-equiv="refresh" content="5;url=${ctx }/MyShop.jsp">  
		
	<style>
 
		body{
		/*TEXT-ALIGN: center;*/
		background:url(${ctx}/image/error/bg.jpg) no-repeat 0px 0px;
		}
		
		h3 {
			/*font-size: 2.5em;*/
			color: #FFF;
			font-family: 'pt_sansbold';
			width: 35%;
			line-height: 1.2em;
			margin: 2.5em 0 1em;
			text-shadow: 0px 0px 5px #474747;
			-webkit-text-shadow: 0px 0px 5px #474747;
			-moz-text-shadow: 0px 0px 5px #474747;
			-o-text-shadow: 0px 0px 5px #474747;
		}
		
		p{
			color: #FFF;
			font-family: 'Microsoft YaHei';
			width: 35%;
			line-height: 1.2em;
			margin: 2.5em 0 1em;
			text-shadow: 0px 0px 5px #474747;
			-webkit-text-shadow: 0px 0px 5px #474747;
			-moz-text-shadow: 0px 0px 5px #474747;
			-o-text-shadow: 0px 0px 5px #474747;
		}
		 
		#center{
		color:#7F7F7F;
		margin:50px auto;
		width:550px;
		vertical-align:middle;
		/*line-height:20px;*/
		}
		 
		</style>

	</head>
	<body>
		<div id="center">
			<h3>提示：</h3>
			<br />
			<p>系统检测到您：</p>
			<br />
			<p>已经执行过刚才的操作或者刚才页面已失效，</p>
			<%-- <p>====================================</p>
			<br />
			<p><s:property value="exception.message" /></p>
			<br />
			<p>====================================</p> --%>
			<br />
			<p>请勿尝试重复提交！请重新进入刚才的页面！</p>
			<br />
			<p>即将跳转到主页……</p>
			<!--
				//桟信息--对用户没有用处 
				<s:property value="exceptionStack" />
		 	-->
		</div>
	</body>
</html>
