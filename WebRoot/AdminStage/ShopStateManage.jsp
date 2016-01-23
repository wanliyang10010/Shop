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
<title>店铺管理</title>
<link rel="stylesheet" type="text/css"
	href="${ctx}/backstage/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/backstage/css/main.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/page.css">
<%@ include file="/common/topAmin.jspf"%>
<script type="text/javascript" src="${ctx}/js/web1.js"></script>
<script type="text/javascript"
	src="${ctx}/backstage/js/libs/modernizr.min.js"></script>
<script type="text/javascript"
	src="${ctx}/js/backstage/ShopStateManage.js"></script>
		<script type="text/javascript">
	var id=0;
	$.ajax({
	type : "POST",
	url : ctx+"/messageAction_getMessageCount.action",
	data : "id="+id,
	success : function(result) {
	if (result.data == 'right') {
	  				} else if (result.data == 'wrong') {
				          window.location.href=ctx+"/error/404.jsp";
	  				}
	},
	error : function() {
	window.location.href=ctx+"/error/404.jsp";
	}	
});	</script>
</head>
<body>
	<div class="topbar-wrap white">
		<div class="topbar-inner clearfix">
			<div class="topbar-logo-wrap clearfix">
				<h1 class="topbar-logo none">
					<a href="${ctx}/AdminStage/index.jsp" class="navbar-brand">后台管理</a>
				</h1>
				<ul class="navbar-list clearfix">
					<li><a class="on" href="${ctx}/AdminStage/index.jsp">首页</a>
					</li>
				</ul>
			</div>
			<div class="top-info-wrap">
				<ul class="top-info-list clearfix">
					<li><a href="${ctx}/adminUserAction_viewmessageBack.action">${sessionScope.userinfo.username}</a>
					</li>
					<li><a href="${ctx}/messageAction_getMessageAdmin.action">新消息(${sessionScope.MessageCount})</a></li>
					<li><a href="${ctx}/AdminStage/PasswordChange.jsp">修改密码</a>
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
					<li><a href="#"><i class="icon-font">&#xe006;</i>纠纷管理</a>
						<ul class="sub-menu">
							<li><a href="${ctx}/disputeAction_query.action"><i
									class="icon-font">&#xe008;</i>纠纷管理</a>
							</li>
						</ul></li>
						 <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>积分商城管理</a>
                    <ul class="sub-menu">
                        <li><a href="${ctx}/stageGoodsAction_query.action"><i class="icon-font">&#xe005;</i>商城商品管理</a></li>
                        <li><a href="${ctx}/stageOrderAction_openAdmin.action"><i class="icon-font">&#xe005;</i>商城订单管理</a></li>
                    </ul>
                </li>
                 <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>创业平台首页管理</a>
                    <ul class="sub-menu">
                        <li><a href="${ctx}/shopStateAction_getTopGoods.action"><i class="icon-font">&#xe005;</i>首页展示商品管理</a></li>
                    </ul>
                </li>
					 <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>店铺管理</a>
                    <ul class="sub-menu">
                        <li><a href="${ctx}/shopStateAction_qury.action"><i class="icon-font">&#xe005;</i>店铺信息管理</a></li>
                         <li><a href="${ctx}/shopApplyAction_searchAllCheckList.action"><i class="icon-font">&#xe005;</i>审核店铺申请</a></li>
                         <li><a href="${ctx}/shopApplyAction_adminViewShopProgress.action"><i class="icon-font">&#xe005;</i>查看店铺申请</a></li>
                    </ul>
                </li>
					<li><a href="#"><i class="icon-font">&#xe018;</i>会员管理</a>
						<ul class="sub-menu">
							<li><a href="${ctx}/userinfoAction_queryUser.action"><i
									class="icon-font">&#xe052;</i>会员管理</a>
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
					<h1>店铺信息管理</h1>
				</div>
				<div class="result-content">
					<left>
					<form name="form1" action="" id="form1">
					<input id="ctx" type="hidden" value="${ctx }">
	<script type="text/javascript">
	   var ctx = $("#ctx").val();
	</script>
					<input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
						<input type="hidden" name="page.pageNo" id="pageNo"
							value="${page.pageNo}" /> <input type="hidden"
							name="page.pageSize" id="pageSize" value="${page.pageSize}" />

						<div>
							<table width="1000">
								<tr>
									<td align="right" style=" width:30%"><label
										for="textfield">关键字：</label></td>
									<td align="left"><select id="stype" name="stype">
											<option value="店铺名">店铺名</option>
											<option value="店铺类别">店铺类别</option>
											<option value="商品类别">商品类别</option>
									</select> 
									 <input
										type="text" name="keyword" id="keyword" size="25"
										value="${param.keyword}">
										<button id="btn_submit" type="submit" onclick="search();">查询</button>
									</td>
								</tr>
								<tr style="display:none">
									<td align="right"><label for="textfield">id：</label></td>
									<td align="left"><input type="number" name="shopId"
										id="shopId"></td>
								</tr>
							</table>
							<script type="text/javascript">
										var ss = '${param.stype}';
										if (ss != "") {
										    var sel=document.getElementById("stype");
											document.getElementById("stype").value = '${param.stype}';
											//document.getElementById("stype")['${param.stype}'].selected = true;
										}
									</script>
							<c:if test="${msg==''}">
								<table width="1000" border="1">
									<tr>
										<td align="center" width=5%>序号</td>
										<td align="center" width=30%>店铺名</td>
										<td align="center" width=20%>店铺/商品类别</td>
										<td align="center" width=15%>店主账号</td>
										<td align="center" width=10%>状态</td>
										<td align="center" width=10%>操作</td>
									</tr>
									<s:iterator value="#request.page" status="s">
										<tr>
											<td align="center" width=5%>${s.count+(page.pageNo-1)*page.pageSize}</td>
											<td align="center" width=30%>${shopname}</td>
											<td align="center" width=20%>${shopcategory}/${productcategory}</td>
											<td align="center" width=15%>${userinfo.username}</td>
											<c:choose>
												<c:when test="${shopstate=='1'}">
													<td align="center" width=10%>激活 <a
														href="javascript:update('${shopId}');">冻结</a></td>
												</c:when>
												<c:otherwise>
													<td align="center" width=10%>冻结 <a
														href="javascript:update('${shopId}');">激活</a></td>
												</c:otherwise>
											</c:choose>
											<td align="center" width=10%><a
												href="javascript:shopdetial('${shopId}');">商品明细</a> <br /> <a
												href="javascript:marginpunish('${shopId}');">店铺处罚</a> <br />
												<a href="javascript:viewmargin('${shopId}');">查看保证金</a> <br />
											</td>
										</tr>
									</s:iterator>
									<tr>
									<td colspan="10">
	
								   <%@ include file="/common/pagination.jspf"%>
							        </td>
								  </tr>
								</table>
							</c:if>
							<div id="msg">
								<font color="red" id="font1">${msg}</font>
							</div>
						</div>
					</form>
					</left>
				</div>
			</div>
		</div>
		<!--/main-->
	</div>
</body>
</html>