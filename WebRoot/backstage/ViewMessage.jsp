<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jspf"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
<link rel="stylesheet" type="text/css"
	href="${ctx}/backstage/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/backstage/css/main.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/page.css">
<%@ include file="/common/topAmin.jspf"%>
<script type="text/javascript"
	src="${ctx}/backstage/js/libs/modernizr.min.js"></script>
<script type="text/javascript" src="${ctx}/backstage/js/backstage.js"></script>

</head>
<body>
	<div class="topbar-wrap white">
		<div class="topbar-inner clearfix">
			<div class="topbar-logo-wrap clearfix">
				<h1 class="topbar-logo none">
					<a href="${ctx}/backstage/index.jsp" class="navbar-brand">后台管理</a>
				</h1>
				<ul class="navbar-list clearfix">
					<li><a class="on" href="${ctx}/backstage/index.jsp">首页</a>
					</li>
				</ul>
			</div>
			<div class="top-info-wrap">
				<ul class="top-info-list clearfix">
					<li><a href="${ctx}/superUserAction_viewmessageBack.action">${sessionScope.userinfo.username}</a>
					</li>
					<li><a href="${ctx}/backstage/PasswordChange.jsp">修改密码</a>
					</li>
					<li><a href="${ctx}/userinfoAction_clear.do">退出</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container clearfix">
		<div class="sidebar-wrap">
			<div class="sidebar-title">
				<h1>菜单</h1>
			</div>
			<div class="sidebar-content">
				<ul class="sidebar-list">
					<li><a href="#"><i class="icon-font">&#xe006;</i>项目管理</a>
						<ul class="sub-menu">
							<li><a href="${ctx}/dateItemAction_qury.action"><i
									class="icon-font">&#xe008;</i>日期项管理</a>
							</li>
							<li><a href="${ctx}/pointsItemAction_qury.action"><i
									class="icon-font">&#xe008;</i>积分项管理</a>
							</li>
							<li><a href="${ctx}/marginItemAction_qury.action"><i
									class="icon-font">&#xe008;</i>商品项管理</a>
							</li>
						</ul></li>
					<li><a href="#"><i class="icon-font">&#xe003;</i>规则管理</a>
						<ul class="sub-menu">
							<li><a href="${ctx}/dateItemAction_getlist.action"><i
									class="icon-font">&#xe005;</i>日期规则管理</a>
							</li>
							<li><a href="${ctx}/pointsItemAction_getlist.action"><i
									class="icon-font">&#xe005;</i>积分规则管理</a>
							</li>
							<li><a href="${ctx}/marginItemAction_getlist.action"><i
									class="icon-font">&#xe005;</i>保证金规则管理</a>
							</li>
						</ul></li>
					<li><a href="#"><i class="icon-font">&#xe018;</i>系统管理</a>
						<ul class="sub-menu">
							<li><a href="${ctx}/superUserAction_queryAdmin.action"><i
									class="icon-font">&#xe052;</i>管理员账号管理</a>
							</li>
						</ul></li>
				</ul>
			</div>
		</div>
		<!--/sidebar-->
		<div class="main-wrap">
			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font">&#xe06b;</i><span>${sessionScope.userinfo.username}--欢迎您的使用！</span>
				</div>
			</div>
			<div class="result-wrap">
				<div class="result-title">
					<h1>查看用户信息</h1>
				</div>
				<div class="result-content">
					<left>
					<form id="form1" action="" name="form1">
					<input id="ctx" type="hidden" value="${ctx }">
	<script type="text/javascript">
	   var ctx = $("#ctx").val();
	</script>
						<input type="hidden" name="userinfoid" id="userinfoid"
							value="${userinfo.userinfoId}" />
						<table width="950">
							<tr>
								<td align="right" colspan="2"><a
									href="javascript:update('${userinfo.userinfoId}');">修改个人信息</a>
								</td>
							</tr>
							<tr>
								<td align="right"><label for="textfield">当前用户：</label> <font
									color="red" id="font1"></font></td>
								<td align="left">${userinfo.username}</td>
							</tr>
							<tr>
								<td align="right" width="30%"><label for="textfield">姓名：</label>
								</td>
								<td align="left">${userinfo.name}</td>
							</tr>
							<tr>
								<td align="right" width="30%"><label for="textfield">出生日期：</label>
								</td>
								<td align="left">${userinfo.bdate}</td>

							</tr>

							<tr>
								<td align="right" width="30%"><label for="textfield">手机号码：</label>
								</td>
								<td align="left">${userinfo.telephone}</td>
							</tr>
							<tr>
								<td align="right" width="30%"><label for="textfield">邮箱地址：</label>
								</td>
								<td align="left">${userinfo.mail}</td>
							</tr>

							<tr>
								<td align="right" width="30%"><label for="textfield">常住地址：</label>
								</td>
								<td align="left">${userinfo.address}</td>
							</tr>
							<tr style="display:none">
								<td align="right" width="30%"><label for="textfield">id：</label>
								</td>
								<td align="left"><input type="number" name="userinfoId"
									id="userinfoId" value=""></td>
							</tr>
						</table>
					</form>
					</left>
				</div>
			</div>
		</div>
		<!--/main-->
	</div>
</body>
</html>