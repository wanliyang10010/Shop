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
<title>商品附件管理</title>
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
	src="${ctx}/js/backstage/GoodsFileManage.js"></script>
<script type="text/javascript">
	var id = 0;
	$.ajax({
		type : "POST",
		url : ctx + "/messageAction_getMessageCount.action",
		data : "id=" + id,
		success : function(result) {
			if (result.data == 'right') {
			} else if (result.data == 'wrong') {
				window.location.href = ctx + "/error/404.jsp";
			}
		},
		error : function() {
			window.location.href = ctx + "/error/404.jsp";
		}
	});
</script>
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
					<li><a href="${ctx}/messageAction_getMessageAdmin.action">新消息(${sessionScope.MessageCount})</a>
					</li>
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
					<li><a href="#"><i class="icon-font">&#xe003;</i>积分商城管理</a>
						<ul class="sub-menu">
							<li><a href="${ctx}/stageGoodsAction_query.action"><i
									class="icon-font">&#xe005;</i>商城商品管理</a>
							</li>
							<li><a href="${ctx}/stageOrderAction_openAdmin.action"><i
									class="icon-font">&#xe005;</i>商城订单管理</a>
							</li>
						</ul></li>
					<li><a href="#"><i class="icon-font">&#xe003;</i>创业平台首页管理</a>
						<ul class="sub-menu">
							<li><a href="${ctx}/shopStateAction_getTopGoods.action"><i
									class="icon-font">&#xe005;</i>首页展示商品管理</a>
							</li>
						</ul></li>
					<li><a href="#"><i class="icon-font">&#xe003;</i>店铺管理</a>
						<ul class="sub-menu">
							<li><a href="${ctx}/shopStateAction_qury.action"><i
									class="icon-font">&#xe005;</i>店铺信息管理</a>
							</li>
							<li><a
								href="${ctx}/shopApplyAction_searchAllCheckList.action"><i
									class="icon-font">&#xe005;</i>审核店铺申请</a>
							</li>
							<li><a
								href="${ctx}/shopApplyAction_adminViewShopProgress.action"><i
									class="icon-font">&#xe005;</i>查看店铺申请</a>
							</li>
						</ul></li>
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
					<h1>商品附件管理</h1>
				</div>
				<div class="result-content">
					<left>
					<form name="form1" id="form1" action="">
					<input id="ctx" type="hidden" value="${ctx }">
	<script type="text/javascript">
	   var ctx = $("#ctx").val();
	</script>
						<input type="hidden" id="authorizedToken" name="authorizedToken"
							value="${sessionScope.userid }" /> <input type="hidden"
							name="page.pageNo" id="pageNo" value="${page.pageNo}" /> <input
							type="hidden" name="page.pageSize" id="pageSize"
							value="${page.pageSize}" /> <input type="hidden" name="goodId"
							id="goodId" value="${goodsAdd.goodsid}" />
						<div>
							<table width="950px" border="1">
								<tr height="40">
									<td align="right" width="30%"><label for="textfield">商品名称：</label>
									</td>
									<td align="left" colspan="3"><label for="textfield">${goodsAdd.goodsname}</label>
									</td>
								</tr>
								<tr style="display:none">
									<td align="right" style=" width:30%"><label
										for="textfield">gid</label></td>
									<td align="left"><input type="text" name="gid" id="gid"
										value="${goodsAdd.goodsid}"></td>
								</tr>
								<tr style="display:none">
									<td align="right" style=" width:30%"><label
										for="textfield">fileid</label></td>
									<td align="left"><input type="text" name="fileid"
										id="fileid"></td>
								</tr>
							</table>
							<c:if test="${msg==''}">
								<table width="950" align="left">
									<tr height="40">
										<td align="center" width=10%>序号</td>
										<td align="center" width=15%>图片预览</td>
										<td align="center" width=25%>文件名称</td>
										<td align="center" width=10%>设为封面</td>
										<td align="center" width=10%>设为预览图</td>
										<td align="center" width=10%>操作</td>
									</tr>
									<s:iterator value="#request.page" status="s">
										<tr>
											<td width=10% align="center">${s.count+(page.pageNo-1)*page.pageSize}</td>
											<td width=15% align="center"><img height="100"
												width="100" src="${ctx}${url}" />
											</td>
											<td width=25% align="center">${name}</td>
											<c:choose>
												<c:when test="${goodsAdd.goodsPicture.fileid==fileid}">
													<td width=15% align="center">封面页 </a></td>
												</c:when>
												<c:otherwise>
													<td width=15% align="center"><a
														href="javascript:update('${fileid}','${type}');">设为封面</a>
													</td>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${type=='0'}">
													<td width=15% align="center"><a
														href="javascript:updatePicture('${fileid}');">设为预览 </a></td>
												</c:when>
												<c:otherwise>
													<td width=15% align="center"><a
														href="javascript:updatePicture('${fileid}');">取消预览</a></td>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${goodsAdd.goodsPicture.fileid==fileid}">
													<td width=10% align="center">删除</a></td>
												</c:when>
												<c:otherwise>
													<td width=10% align="center"><a
														href="javascript:deletefile('${fileid}');">删除</a></td>
												</c:otherwise>
											</c:choose>
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
<script type="text/javascript">
$("img").each(function(){
  this.onerror=function(){
    this.src="image/picerror.jpg";
 };
});
</script>
</html>