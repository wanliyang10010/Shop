<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title>系统提示</title>
  <meta name="Generator" content="www.aspku.com">
  <meta name="Author" content="aspku">   
  <script type="text/javascript" src="${ctx}/js/jQuery/jquery-1.9.0.js"></script>     
 </head>
 <style type="text/css">
.gohome{margin-left: 10px; padding-top: 4px;height: 25px; vertical-align: top;color:#000000;font-family : Times New Roman,华文行楷;font-size : 1.7em;}
.gohome2{margin-left: 10px; padding-top: 4px;height: 25px; vertical-align: top;color:#FF0000;font-family : 华文行楷;font-size : 1.8em;}
.gohome1{margin-left: 20px; padding-top: -10;height: 25px; vertical-align: top;color:#6699ff;font-family : 华文行楷;font-size : 1.7em;text-decoration:none;}
.tips{margin-left: 150px;vertical-align: top;color:red;font-size : 1em;}
</style>
 <body style="background:#f5f5f5;">
 <input id="ctx" type="hidden" value="${ctx}">
 <script type="text/javascript">
 	var ctx = $("#ctx").val();
	function myBrowser(){
		var userAgent = navigator.userAgent;
		var isOpera = userAgent.indexOf("Opera") > -1;
		var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera ;

		if(isIE){
		var IE5 = IE55 = IE6 = IE7 = IE8 = false;
		var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
		reIE.test(userAgent);
		var fIEVersion = parseFloat(RegExp["$1"]);
		
		IE55 = fIEVersion == 5.5 ;
		IE6 = fIEVersion == 6.0 ;
		IE7 = fIEVersion == 7.0 ;
		IE8 = fIEVersion == 8.0 ;
		
		if(IE55){ return "IE55"; }
		if(IE6){ return "IE6"; }
		if(IE7){ return "IE7"; }
		if(IE8){ return "IE8"; }
		}
		return "notIE";
	}
		
 	 if((myBrowser()!="IE55")&&(myBrowser()!="IE6")&&(myBrowser()!="IE7")&&(myBrowser()!="IE8")){
	   window.location.href = ctx+"/viewProductAction_MyShop.do";
	  //alert("(myBrowser()");
	}  
	</script>
	
		<div style="z-index: 100;margin-left: 5%;margin-top: 10%;background:#f5f5f5; color:#FFF">
			 <div style="margin-left: 25%;color:#FFF">
				<p class="gohome2">提示：</p>
				<p class="gohome">—————————————————————</p>
				<p class="gohome">为预防购物风险，本平台不支持IE6/7/8浏览器;</p>
				<p class="gohome">建议您使用FireFox/Chrome等浏览器;</p>
				<p class="gohome"><span style="padding-left:82px">或者使用新版本IE浏览器。</span></p>
				<!-- <p class="gohome">请关闭当前页面！</p> -->
				<p class="gohome">—————————————————————</p>
			</div>
			 <div style="margin-left: 50%;vertical-align: top;color:#369;font-size : 1em;">
				<a href="/help/browserHelp.jsp" target="_blank">还有问题？</a>
			</div>
		</div>
 </body>
</html>
