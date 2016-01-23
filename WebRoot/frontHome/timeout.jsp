<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ include file="/common/taglibs.jspf"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
		<title>异地登录</title>
		
		<style type="text/css">
			body{ margin:0; padding:0; background:#efefef; font-family:Georgia, Times, Verdana, Geneva, Arial, Helvetica, sans-serif; }
			div#mother{ margin:0 auto; width:943px; height:572px; position:relative; }
			div#errorBox{ background: url(${ctx}/image/Activity/slider/bg.png) no-repeat top left; width:943px; height:572px; margin:auto; }
			div#errorText{ color:#39351e; padding:146px 0 0 446px;font-family : �����п�;  }
			div#errorText p{ width:303px; font-size:14px; line-height:26px; }
			div.link{ /*background:#f90;*/ height:50px; width:145px; float:left; }
			div#home{ margin:20px 0 0 444px;}
			div#contact{ margin:20px 0 0 25px;}
			h1{ font-size:40px; margin-bottom:35px; }
			.gohome{margin-left: 10px; padding-top: 4px;height: 25px; vertical-align: top;color:#000000;font-family : 华文行楷;font-size : 3.0em;}
		</style>
	</head>
	<body>
		<div id="mother">
			<div id="errorBox">
				<div id="errorText">
				<h1>平台提示！</h1>
					<h1>由于您的账号在异地已登录，故此次登录已下线。</h1>
				</div>
				<div class="gohome" style="margin-left: 400px;margin-right: auto;text-align: center;">
				<a href="${ctx}/activityinfo!MyActivity.action" style="text-decoration:none;">
					返回平台首页
				</a>
				</div>
			</div>
		</div>
	</body>
</html>