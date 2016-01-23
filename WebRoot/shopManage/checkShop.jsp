<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>店铺审核</title>
  
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<script type="text/javascript" src="${ctx}/backstage/js/libs/modernizr.min.js"></script>

<link rel="stylesheet" type="text/css" href="${ctx}/backstage/css/common.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/backstage/css/main.css"/>
<link rel="stylesheet" type="text/css"  href="${ctx}/css/haveBorder.css"> 
<%@ include file="/common/topAmin.jspf"%>
<script type="text/javascript"	src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/shopManage/checkShop.js"></script> 
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
            <h1 class="topbar-logo none"><a href="${ctx}/AdminStage/index.jsp" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="${ctx}/AdminStage/index.jsp">首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="${ctx}/adminUserAction_viewmessageBack.action">${sessionScope.userinfo.username}</a></li>
                <li><a href="${ctx}/messageAction_getMessageAdmin.action">新消息(${sessionScope.MessageCount})</a></li>
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
             <li>
                    <a href="#"><i class="icon-font">&#xe006;</i>纠纷管理</a>
                    <ul class="sub-menu">
                      <li><a href="${ctx}/disputeAction_query.action"><i class="icon-font">&#xe008;</i>纠纷管理</a></li> 
                    </ul>
                </li>
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
                      <%--    <li><a href="${ctx}/shopManage/checkShop.jsp"><i class="icon-font">&#xe005;</i>审核店铺申请</a></li>
                         <li><a href="${ctx}/shopManage/adminViewShopProgress.jsp"><i class="icon-font">&#xe005;</i>查看店铺申请</a></li> --%>
                         <li><a href="${ctx}/shopApplyAction_searchAllCheckList.action"><i class="icon-font">&#xe005;</i>审核店铺申请</a></li>
                         <li><a href="${ctx}/shopApplyAction_adminViewShopProgress.action"><i class="icon-font">&#xe005;</i>查看店铺申请</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>会员管理</a>
                    <ul class="sub-menu">
                        <li><a href="${ctx}/userinfoAction_queryUser.action"><i class="icon-font">&#xe052;</i>会员管理</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>${sessionScope.userinfo.username}--欢迎您的使用！</span></div>
        </div>
    <div class="result-wrap">
            <div class="result-title">
              <h3>店铺审核</h3>
            </div>
            <div class="result-content">
                <left>
		<form name="userform" action="" id="userform">
		<input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
	    <input type="hidden"  name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	    <input type="hidden"  name="page.pageSize" id="pageSize" value="${page.pageSize}"/> 
			
			<table width="950px">
				<tr>
					<td align="center"><label for="textfield">时间：从</label> <input
						class="Wdate" name="fromdate" id="fromdate" type="text"
						value="${param.fromdate}"
						onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
						onBlur="checkdate();"> <label for="textfield">到</label> <input
						class="Wdate" name="todate" id="todate" type="text"
						value="${param.todate}"
						onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
						onBlur="checkdate();">
						<button id="btn_search" type="button" style="width:80px;" onclick="search();">查询</button>
					</td>
				</tr>
			</table>
			<div id="msg_checkover" align="left">
				<font color="red" id="font1">${msg_checkover}</font>
			</div>
			  <s:if test="#request.page!= null&&#request.page.getTotalItems()>0"> 
			<table width="950px" >			
				<tr id="trMain" style="background:#BFDBEB;">
					<td align="center" width=10%>选择</td>
				    <td align="center" width=10%>序号</td>
					<td align="center" width=15%>申请人</td>
					<td align="center" width=25%>申请时间</td>
					<td align="center" width=30%>店铺名称</td>
					<td align="center" width=10%>详情</td>
					<td align="center" width=10% style="display:none">ID</td>
				</tr>
				
				<s:iterator value="#request.page" status="s">			
				<s:if test="%{shopApplyId==(#request.shopId)}">
				<tr id="tr${s.count}" style="background:#BFEFFF">	
				</s:if>
				<s:else>
				<tr id="tr${s.count}">
				</s:else>
					<td align="center"><input type="checkbox"
						name="ckbox" id="ckbox${s.count}"
						value="${shopApplyId}" /></td> 
					<td align="center">${s.count+(page.pageNo-1)*page.pageSize}</td>
					 <td align="center">${userinfo.username}</td>
					 <td align="center">${applyTime}</td>
					<td align="center">${shopname}</td>
					<td align="center"><a
						href="javascript:lbtDetail(
			    				'${shopname}','${shopcategory}',
			    				'${productcategory}','${shopaddress}',
			    				'${shoppostnumber}','${shopphone}',
			    				'${identifynumber}',
			    				'${userpicture}',
			    				'${identifypicture}',
			    				'${identifypicture2}'
			    				,'${s.count}', '${page.getResult().size()}','${addrarea}'
			    				);">详情</a>
					</td> 
					<td  align="center" style="display:none">${shopApplyId}</td>
				</tr>		
				  </s:iterator>	
				  <tr><td colspan="7">
				  <%@ include file="/common/shopPaging.jspf" %>
				  </td></tr>
			</table>
                
			<table width="950px" colspan="2" border="1"
				id="tbDetail" style="display: none">
				<tr>
					<td align="right" width="200px"><label for="textfield">店铺名称：</label>
					</td>
					<td align="left" width="600px"><input type="text"
						name="shopname" id="shopname" size="60" maxlength="30"
						value="${param.shopname}" readonly="readonly"
						style="background:#CCCCCC"></td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">店铺类别：</label></td>
					<td align="left"><input type="text" name="shopcategory"
						id="shopcategory" size="60" maxlength="30"
						value="${param.shopcategory}" readonly="readonly"
						style="background:#CCCCCC"></td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">商品类别：</label></td>
					<td align="left"><input type="text" name="productcategory"
						id="productcategory" size="60" maxlength="30"
						value="${param.productcategory}" readonly="readonly"
						style="background:#CCCCCC"></td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">店铺所在地区：</label></td>
					<td align="left"><input type="text" name="addrarea"
						id="addrarea" size="60" maxlength="65" readonly="readonly"
						style="background:#CCCCCC" value="${param.addrarea}"></td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">店铺具体位置：</label></td>
					<td align="left"><input type="text" name="shopaddress"
						id="shopaddress" size="60" maxlength="65" readonly="readonly"
						style="background:#CCCCCC" value="${param.shopaddress}"></td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">店铺所在地邮编：</label></td>
					<td align="left"><input type="text" name="shoppostnumber"
						id="shoppostnumber" size="60" maxlength="6" readonly="readonly"
						style="background:#CCCCCC" value="${param.shoppostnumber}">
					</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">手机号码：</label></td>
					<td align="left"><input type="text" name="shopphone"
						id="shopphone" size="60" maxlength="11" readonly="readonly"
						style="background:#CCCCCC" value="${param.shopphone}"></td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">身份证号：</label></td>
					<td align="left"><input type="text" name="identifynumber"
						id="identifynumber" size="60" maxlength="18" readonly="readonly"
						style="background:#CCCCCC" value="${param.identifynumber}">
					</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">半身照：</label></td>
					<td align="left">
						<img id="userpicturepicture"  style="weight:102px;height:116px"/>
						</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">身份证正面：</label></td>
					<td align="left">
						<img id="identifypicturepicture" style="weight:283px;height:179px"/>
					</td>
				</tr>
				<tr>
					<td align="right"><label for="textfield">身份证反面：</label></td>
					<td align="left">
						<img id="identifypicture2picture"  style="weight:283px;height:179px"/>
					</td>
				</tr>
			</table>
			<table width="950px" id="tbCheck" style="display: ">
				<tr>
					<td align="left" style="background:#E0FFFF"><label
						for="textfield">审核意见：</label></td>
				</tr>
				<tr>
					<td align="left"><input type="text" name="checkIdea"
						id="checkIdea" maxlength="57"
						  	
						 style="width:100%;height:50px"></td>
				</tr>
				<tr>
					<td align="center">
						<button id="btn_pass" type="button" onclick="pass(${page.getResult().size()});"
							style="width:100px;">审核通过</button> &nbsp; &nbsp;&nbsp;
						<button id="btn_notpass" type="button"
							onclick="notpass(${page.getResult().size()});" style="width:100px;">审核不通过</button>
					</td>
				</tr>
			</table>
			<span style="color:red;font-size:14px;font-weight: bold;display:-moz-inline-box;display:inline-block;width:950px;margin-top:15px">
			（友情提示：当前页面被选中（即被打钩）的每条申请均会被同时审核！为了防止误操作，如果翻页，则翻页之前的选中项将被取消，如果需要选中的申请条数过多，请将每页显示的条数增大！谢谢合作。）</span>
			 </s:if>		
			<div id="msg_searchAllList"> 
				<font color="red" id="font1">${msg_searchAllList}</font>
			</div>		
		</form>
		</left>            
            </div>
        </div>
    </div>
    <!--/main-->
</body>
</html>
