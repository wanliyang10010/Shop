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
<title>会员管理</title>
<link rel="stylesheet" type="text/css"
	href="${ctx}/backstage/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/backstage/css/main.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/page.css">
<%@ include file="/common/topAmin.jspf"%>
<script type="text/javascript" src="${ctx}/js/web1.js"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="${ctx}/backstage/js/libs/modernizr.min.js"></script>
<script type="text/javascript"
	src="${ctx}/js/backstage/UserStateManage.js"></script>
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
					<a href="${ctx}/AdminStage/index.jsp" class="navbar-brand">ng后台管理</a>
				</h1>
				<ul class="navbar-list clearfix">
					<li><a class="on" href="${ctx}/AdminStage/index.jsp">首页</a></li>
				</ul>
			</div>
			<div class="top-info-wrap">
				<ul class="top-info-list clearfix">
					<li><a href="${ctx}/adminUserAction_viewmessageBack.action">${sessionScope.userinfo.username}</a>
					</li>
					<li><a href="${ctx}/messageAction_getMessageAdmin.action">新消息(${sessionScope.MessageCount})</a>
					</li>
					<li><a href="${ctx}/AdminStage/PasswordChange.jsp">修改密码</a></li>
					<li><a href="${ctx}/userinfoAction_clear.do">退出</a></li>
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
									class="icon-font">&#xe008;</i>纠纷管理</a></li>
						</ul>
					</li>
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
									class="icon-font">&#xe052;</i>会员管理</a></li>
						</ul>
					</li>
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
					<h1>会员信息管理</h1>
				</div>
				<div class="result-content">
					<left>
					<form name="form1" action="" id="form1">
					<input id="ctx" type="hidden" value="${ctx }">
	<script type="text/javascript">
	   var ctx = $("#ctx").val();
	</script>
						<input type="password" autocomplete="off" style="display:none" />
						<input type="hidden" id="authorizedToken" name="authorizedToken"
							value="${sessionScope.userid }" /> <input type="hidden"
							name="page.pageNo" id="pageNo" value="${page.pageNo}" /> <input
							type="hidden" name="page.pageSize" id="pageSize"
							value="${page.pageSize}" />
						<div>
							<table width="950">
								<tr>
									<td align="right" style=" width:20%"><label
										for="textfield">关键字：</label>
									</td>
									<td align="left"><select id="stype" name="stype">
											<option value="用户名">用户名</option>
											<option value="姓名">姓名</option>
											<option value="联系方式">联系方式</option>
											<option value="邮箱">邮箱</option>
									</select> <script type="text/javascript">
										var ss = '${param.stype}';
										if (ss != "") {
											document.getElementById("stype").value = '${param.stype}';
											//document.getElementById("stype")['${param.stype}'].selected = true;
										}
									</script> <input type="text" name="keyword" id="keyword" size="25"
										value="${param.keyword}">
										<button id="btn_submit" type="submit" onclick="search();">查询</button>
									</td>
								</tr>
								<tr style="display:none">
									<td align="right"><label for="textfield">id：</label>
									</td>
									<td align="left"><input type="number" name="userinfoId"
										id="userinfoId">
									</td>
								</tr>
							</table>

							<c:if test="${msg==''}">
								<table width="950">
									<tr>
										<td align="center" width=10%>序号</td>
										<td align="center" width=15%>用户名</td>
										<td align="center" width=10%>姓名</td>
										<td align="center" width=10%>联系方式</td>
										<td align="center" width=15%>邮箱</td>
										<td align="center" width=15%>状态</td>
										<td align="center" width=15%>操作</td>
									</tr>
									<s:iterator value="#request.page" status="s">
										<tr>
											<td align="center" width=10%>${s.count+(page.pageNo-1)*page.pageSize}</td>
											<td align="center" width=15%>${username}</td>
											<td align="center" width=10%>${name}</td>
											<td align="center" width=10%>${telephone}</td>
											<td align="center" width=15%>${mail}</td>
											<c:choose>
												<c:when test="${state=='0'}">
													<td align="center" width=15%>激活 <a
														href="javascript:update('${userinfoId}');">冻结</a>
													</td>
												</c:when>
												<c:otherwise>
													<td align="center" width=15%>冻结 <a
														href="javascript:update('${userinfoId}');">激活</a>
													</td>
												</c:otherwise>
											</c:choose>
											<td align="center" width=15%><a
												href="javascript:edituser('${userinfoId}');">密码重置</a><br />
												<a href="javascript:deleteuser('${userinfoId}');">删除用户</a>
										</tr>
									</s:iterator>
									<tr>
									<td colspan="10">
								   <%@ include file="/common/pagination.jspf"%>
							        </td>
								  </tr>
								</table>
							</c:if>
							<div id="editMessage" style="display:none">
								<table width="950" align="left" border="1"
									oncontextmenu=return(false)>
									<tr>
										<td align="right" width="30%"><label for="textfield">新密码：</label>
										</td>
										<td align="left"><input type="password" name="password"
											id="password" maxlength="20"
											 onkeyup="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
											 oninput="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "></td>
									</tr>
									<tr>
										<td align="right"><label for="textfield">密码确认：</label></td>
										<td align="left"><input type="password" name="password2"
											id="password2" maxlength="20"
											 onkeyup="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "
											 oninput="var myreg=/^[A-Za-z0-9]+$/;if(!myreg.test(this.value)){this.value=''; }; "></td>
									</tr>
									<tr>
										<td align="center" colspan="4"><input id="btn_submit"
											type="button" onclick="changePWD();" value="重置密码">
											&nbsp;&nbsp;&nbsp;&nbsp; <input id="btn_cancel" type="button"
											onclick="cancel()" value="取消"></td>
									</tr>
								</table>
							</div>
							<div id="msg">
								<font color="red" id="font1">${msg}</font>
							</div>
						</div>
					</left>
					</form>
				</div>
			</div>
		</div>
		<!--/main-->
	</div>
</body>
</html>