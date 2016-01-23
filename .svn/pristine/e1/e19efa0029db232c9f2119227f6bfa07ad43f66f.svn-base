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
<s:token />
<title>积分商城商品管理</title>
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
	src="${ctx}/AdminStage/js/StageGoods.js"></script>
	<script type="text/javascript">
	var id=0;
	$.ajax({
	type : "POST",
	url : ctx+"/messageAction_getMessageCount.action",
	data : "id="+id,
	success : function(result) {
	
	},
	error : function() {
	
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
					<li><a class="on" href="${ctx}/disputeAction_query.action">首页</a>
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
					<h1>积分商城商品管理</h1>
				</div>
				<div class="result-content">
					<left>
	<form name="form1"  id="form1" enctype="multipart/form-data">
	<input id="ctx" type="hidden" value="${ctx }">
	<script type="text/javascript">
	   var ctx = $("#ctx").val();
	</script>
	  <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	  <input type="hidden" name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
	  <input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
	  <input type="hidden" name="sgoodsId" id="sgoodsId"/>
        <div>
           <table width="950" border="1">
                      <tr>
					<td align="right" style=" width:20%" ><label for="textfield">商品名称：</label></td>
					<td align="left">
					 <input type="text" name="goodsname" id="goodsname" size="50" maxlength="25">
					</td>
				</tr>
				 <tr > 
                      <td align="right">
                         <label for="textfield">商品描述：</label>
                     </td>
                     <td align="left">
                       <textarea rows="4" cols="60" name="remark" id="remark"  maxlength="50"  onkeyup="if(value.length>50) value=value.substr(0,50)" style="overflow:hidden"></textarea>
                     </td>
                 </tr>
				<tr>
					<td align="right"><label for="textfield">积分数(分)：</label></td>
					<td align="left">
					 <input type="text" name="points" id="points"   maxlength="8"
					 onkeyup="var myreg=/^(0|[1-9][0-9]*)$/;if(!myreg.test(this.value)){this.value=''; }; "
					 >
					</td>
				</tr>
				<tr>
                    <td align="right">
                    <label for="textfield">上传图片：</label>
                    </td>
                    <td align="left">
                       <input type="file" id="upload" name="uploadFile.item" style=" width:30%">
                       </td>
                </tr> 
                 <tr>
                    <td align="center" colspan="2">
                   <input type="button" name="btn_update" id="btn_update" value="修改" onclick="update();" style="display:none">
                  &nbsp;&nbsp; 
                   <input type="button" name="btn_submit" id="btn_submit" value="添加" onclick="add();" >
                   &nbsp;&nbsp;
                   <input type="button" name="btn_cancel" id="btn_cancel" value="取消" onclick="cancel();" >
                       </td>
                </tr>     
				</table>
               <table width="950" border="1">
                   <tr>
                       <td align="right" style=" width:30%" >
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
	          <td align="center" width=15%>商品图片</td>
	          <td align="center" width=40%>商品名称</td>
		      <td align="center" width=10%>积分数</td>
		      <td align="center" width=15%>状态</td>
		      <td align="center" width=15%>操作</td>
	     </tr>
		   <s:iterator value="#request.page" status="s">
		    <tr>
		         <td  align="center" width=10%>${s.count+(page.pageNo-1)*page.pageSize}</td>
		          <td align="center" width=15%>
                   <img height="80" width="80" src="${ctx}${url}" />
                    </td>
		         <td align="center" width=40%>${goodsname}</td>
		          <td align="center" width=10%>${points}</td>
		          <c:choose>
			      <c:when test="${state=='0'}">
			                   <td width=15% align="center">
			                                       在售  <a href="javascript:updateG('${sgoodsId}');">下架</a>  
			          </td>           
			     </c:when>        
			     <c:otherwise>
			         <td width=15% align="center">
			                     下架  <a href="javascript:updateG('${sgoodsId}');">开售</a></td>                       
			      </c:otherwise> 
			       </c:choose>
		          <td align="center" width=15%>
		           <a href="javascript:updateGoods('${sgoodsId}','${goodsname}','${points}','${remark}');">修改</a> 
		           <a href="javascript:deleteGoods('${sgoodsId}','${goodsname}','${points}','${remark}');">删除</a> 
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
<script type="text/javascript">
$("img").each(function(){
  this.onerror=function(){
    this.src="image/picerror.jpg";
 };
});
</script>
</html>