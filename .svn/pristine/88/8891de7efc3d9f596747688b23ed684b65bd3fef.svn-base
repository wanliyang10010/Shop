<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jspf"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
<script type="text/javascript">  
window.onload=function(){   
getTime();    
window.setInterval("getTime()",1); 
};                             
function getTime(){    
   var date = new Date();    
   var y = date.getFullYear();    
   var m = date.getMonth()+1;    
   var d = date.getDate();    
   var h = date.getHours();    
   var i = date.getMinutes();    
   var s = date.getSeconds();   
   document.getElementById("showTimes").innerHTML =y+"年"+(m>9?m:("0"+m))+"月"+(d>9?d:("0"+d))+"日 "+(h>9?h:("0"+h))+":"+(i>9?i:("0"+i))+":"+(s>9?s:("0"+s));
}    
</script> 
</head>
<body>

	
	<div class="result-title">
	    <h1>系统基本信息</h1>
	</div>
	<div class="result-content">
	    <ul class="sys-info-list">
	        <li>
	            <label class="res-lab">开发语言:</label><span class="res-info">Java</span>
	        </li>
	        <li>
	            <label class="res-lab">数据库:</label><span class="res-info">Oracle 11g</span>
	        </li>
	        <li>
	            <label class="res-lab">上传附件限制:</label><span class="res-info">2M</span>
	        </li>
	        <li>
	            <label class="res-lab">当前时间:</label><span class="res-info"><font color="" id="showTimes" ></font></span>
	        </li>
	        <li>
	            <label class="res-lab">服务器域名/IP:</label><span class="res-info">localhost [ 202.118.89.86 ]</span>
	        </li>
	        <li>
	            <label class="res-lab">Host:</label><span class="res-info">202.118.89.86</span>
	        </li>
	    </ul>
	</div>

</body>
</html>