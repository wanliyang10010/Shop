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
<title>店铺商品管理</title>
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
	src="${ctx}/js/backstage/ShopGoodsManage.js"></script>
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
					<h1>店铺商品管理</h1>
				</div>
				<div class="result-content">
					<left>
	<form name="form1" action=""  id="form1" >
	<input id="ctx" type="hidden" value="${ctx }">
	<script type="text/javascript">
	   var ctx = $("#ctx").val();
	</script>
	<input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
	  <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	  <input type="hidden" name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
       <input type="hidden" name="sid" id="sid" value='${shop.shopId}'>
       <input type="hidden" name="goodId" id="goodId">
       <input type="hidden" name="shopId" id="shopId" value="${shop.shopId}" >
                            <div>
                             <table width="950" border="1">
                        <tr height="40"> 
                                     <td align="right">
                                        <label for="textfield">店铺名称：</label>
                                    </td>
                                    <td align="left"  colspan="3">
                                      <label for="textfield">${shop.shopname}</label>
                                    </td>
                                </tr>
                                
                                 <tr height="40"> 
                                     <td align="right">
                                        <label for="textfield">店铺类别：</label>
                                    </td>
                                    <td align="left">
                                     <label for="textfield">${shop.shopcategory}</label>
                                    </td>
                                     <td align="right">
                                        <label for="textfield">注册时间：</label>
                                    </td>
                                    <td align="left">
                                     <label for="textfield">${shop.regeditdate}</label>
                                    </td>
                                    </tr>
                           
                                <tr>
                                    <td align="right" style=" width:20%" >
                                    <label for="textfield">商品名称：</label>
                                    </td>
                                    <td align="left" colspan="3">
                                       <input type="text" name="keyword" id="keyword" size="25" value="${param.keyword}">
                                       <button id="btn_submit" type="submit"  onclick="search();" >查询</button>
                                       </td>
                                </tr>
                            </table>
 <c:if test="${msg==''}"> 
        <table width="950" border="1">
	     <tr>
	          <td align="center" width=10%>序号</td>
	          <td align="center" width=60%>商品名称</td>
		      <td align="center" width=15%>状态</td>
		      <td align="center" width=15%>附件管理</td>
	     </tr>
		   <s:iterator value="#request.page" status="s">
		    <tr>
		         <td  align="center" width=10%>${s.count+(page.pageNo-1)*page.pageSize}</td>
		         <td align="center" width=60%>${goodsname}</td>
		          <c:choose>
			      <c:when test="${state=='0'}">
			                  
			                   <td width=15% align="center" color="red">
			                                       在售  <a href="javascript:updateG('${goodsid}');">下架</a>  
			          </td>           
			     </c:when>   
			      <c:when test="${state=='3'}">
			                  
			                   <td width=15% align="center" color="red">
			                                       在售(首页显示)  <a href="javascript:updateG('${goodsid}');">下架</a>  
			          </td> 
			          </c:when>
			           <c:when test="${state=='5'}">
			                  
			                   <td width=15% align="center" color="red">
			                                       在售(二手商品)  <a href="javascript:updateG('${goodsid}');">下架</a>  
			          </td> 
			          </c:when>
			          <c:when test="${state=='2'}">
					<td width=15% align="center">管理员下架  </td>               
			     </c:when>          
			     <c:otherwise>
			         <td width=15% align="center">下架  </td>                       
			      </c:otherwise> 
			       </c:choose>
			     <td width=15% align="center"><a href="javascript:file('${goodsid}');">附件信息</a></td>
	             </tr> 
	     </s:iterator>
	     <tr>
									<td colspan="10">
								   <%@ include file="/common/pagination.jspf"%>
							        </td>
								  </tr>
	   </table> 
	   </c:if>	  
	         <div id="msg" >
	              <font color="red" id="font1" >${msg}</font>
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