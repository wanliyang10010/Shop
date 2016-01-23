<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>浏览器兼容性</title>
<script type="text/javascript" src="${ctx}/js/jQuery/jquery-1.9.0.js"></script>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/noneBorder.css">
<style type="text/css">
p {
	text-align: left;
	width: 900px;
	font-family: 宋体;
	font-size: 17px;
	line-height: 30px;
	font-weight: normal;
	text-indent: 2em
}

.browser {
	text-align: center;
	width: 900px;
	font-family: 宋体;
	font-size: 14px;
	line-height: 26px;
	font-weight: bold;
}
</style>
<script type="text/javascript">
  function myBrowser(){
		var userAgent = navigator.userAgent;
		var isOpera = userAgent.indexOf("Opera") > -1;
		var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera ;

		if(isIE){
		var IE5 = IE55 = IE6 = IE7 = false;
		var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
		reIE.test(userAgent);
		var fIEVersion = parseFloat(RegExp["$1"]);
		
		IE55 = fIEVersion == 5.5 ;
		IE6 = fIEVersion == 6.0 ;
		IE7 = fIEVersion == 7.0 ;
		
		if(IE55){ return "IE55"; }
		if(IE6){ return "IE6"; }
		if(IE7){ return "IE7"; }
		}
		return "notIE";
	}
	
	var ie_version = myBrowser(); 
  if((ie_version!="IE55")&&(ie_version!="IE6")&&(ie_version!="IE7")){
	   window.location.href = "${ctx}"+"/viewProductAction_MyShop.do";
	}  
</script>
</head>

<body style="background:#f5f5f5;">
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform">
			 &nbsp; &nbsp;&nbsp;<h2>浏览器兼容性</h2>
			 <div width="900px" align="center" >
				<p>所谓的浏览器兼容性问题，是指因为不同的浏览器对同一段代码有不同的解析，造成页面显示效果不统一的情况。</p>
				<p>对于本平台，为了预防购物风险，不支持IE6/7浏览器。</p>
				<p>如果您不是IE浏览器，则可能使用了该浏览器的<span style="color:#F00">兼容模式</span>，
				请调换至<span style="color:#F00">极速模式</span>。
				(兼容模式：有些浏览器同时采用IE内核和其它内核，一般称为双核浏览器，
				兼容模式即双核浏览器中以IE内核浏览页面的模式。而使用兼容模式，360的做法是保留了你电脑里面本身的IE内核，
				倘若你的电脑浏览器是IE7.0，使用兼容模式，就相当于使用了IE7.0，同理，如果你电脑是IE6.0，那么兼容就是6.0。)</p>
    			<p>各个浏览器兼容模式和极速模式切换的地方都不太一样，对以下常用的浏览器的极速模式截图如下（其它浏览器类似）：</p>
				<div class="browser">
					<div>360安全浏览器8.1</div>
					<img src="${ctx}/image/help/360.png">
					</br>
					</br>
					<div>360极速浏览器</div>
					<img src="${ctx}/image/help/360speed.png">
					</br>
					</br>
					<div>搜狗浏览器</div>
					<div style="text-align: center;">
					<img src="${ctx}/image/help/sougou.png">
					</div>
				</div>	
			</div>
		</form>
	</center>
	</div>
</body>
</html>