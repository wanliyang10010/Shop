<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title>系统提示</title>
  <meta name="Generator" content="www.aspku.com">
  <meta name="Author" content="aspku">
     
    
 </head>
 <style type="text/css">
.gohome{margin-left: 10px; padding-top: 4px;height: 25px; vertical-align: top;color:#000000;font-family : 华文行楷;font-size : 1.7em;}
.gohome2{margin-left: 10px; padding-top: 4px;height: 25px; vertical-align: top;color:#FF0000;font-family : 华文行楷;font-size : 1.8em;}
.gohome1{margin-left: 20px; padding-top: -10;height: 25px; vertical-align: top;color:#6699ff;font-family : 华文行楷;font-size : 1.7em;text-decoration:none;}
.tips{margin-left: 150px;vertical-align: top;color:red;font-size : 1em;}
</style>
 <body style="background:#f5f5f5;" onload='setTimeout("mm()",3000)'>
		<script language="javascript" type="text/javascript">
		window.history.forward();
		window.onbeforeunload=function (){}; 
        function mm(){
        	var browserName=navigator.appName;
            if (browserName=="Netscape"){
            	window.opener=null;
            	window.open("about:blank","_self").close();
            } else if (browserName=="Microsoft Internet Explorer") {
            	window.opener=null;
            	window.parent.opener = null; 
                window.parent.close(); 
            } else{
            	window.opener=null;
            	window.close();
            }
		} 
    	</script>  
		<div style="z-index: 100;margin-left: 5%;margin-top: 20%;background:#f5f5f5; color:#FFF">
			 <div style="margin-left: 25%;color:#FFF">
				<p class="gohome2">提示：</p>
				<p class="gohome">——————————————————————————</p>
				<p class="gohome">1：当前页面的信息不属于目前登录的账号，您无权进行操作;</p>
				<p class="gohome">2：请核对当前登录的账号;</p>
				<p class="gohome">3：本页面即将自动关闭。</p> 
				<p class="gohome">——————————————————————————</p>
			</div>
			<div style="margin-left: 30%;">
				<p class="tips">页面即将关闭</p>
			</div>
		</div>
 </body>
</html>
