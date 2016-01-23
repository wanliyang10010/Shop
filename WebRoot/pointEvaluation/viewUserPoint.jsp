<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<title>买家积分查看</title>

<script type="text/javascript" src="${ctx}/js/web.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.min.js" ></script>
<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/ypublic.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/mediaQuery.css"/>
<%@ include file="/common/topAmin.jspf" %>
</head>
<body>
<div class="container-fluid" id="templatemo_main">
		<form class="form-horizontal" role="form" name="userform" action="" id="userform">
			<div class="row">				
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-1  hidden-xs"></div>
						<div class="col-md-10 col-xs-12">
							<div class="row" style="background-color: #cccccc;height: 30px;"></div>
							<div class="row" style="background-color: #ff4401;height: 50px;"></div>
							<div class="row">
								<div class="col-md-2">
									<div class="list-group">
									  <a href="#" class="list-group-item active">Cras justo odio</a>
									  <a href="#" class="list-group-item">Dapibus ac facilisis</a>
									  <a href="#" class="list-group-item">Morbi leo risus</a>
									  <a href="#" class="list-group-item">Porta ac consectetur</a>
									  <a href="#" class="list-group-item">Vestibulum at eros</a>
									</div>
								</div>
								<div class="col-md-10">
									<div class="row">
										<div class="col-md-12">
											<h3 class="text-center"><B>买家积分查看</B></h3>
											<input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
										     <input type="hidden"  name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	  		 								 <input type="hidden"  name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
											
										    <div class="col-md-12 table-responsive divtable">
										     <s:if test="#request.page!= null&&#request.page.getTotalItems()>0"> 
												 <table class="table  table-striped table-hover wordflow text-overflow text-center break-wrap">
												 	<thead>
												 	<tr>
												 		<td class="hidden-xs">会员名字</td>
													  	<td>积分到账时间</td>
													  	<td>分值（分）</td>
													  	<td>加减</td>
													  	<td>来源/用途</td>
												 	</tr>
												 	</thead>
												 	<tbody>
												 		<s:iterator value="#request.page" status="s">	
												 		<tr>
												 			<td class="hidden-xs">${userinfo.username}</td>
												 			<td>${operateTime}</td>
												 			<td>${point}</td>
												 			<td>${plusminus}</td>
												 			<td>${content}</td>
												 		</tr>
												 		</s:iterator>
												 	</tbody>
												 </table>
												 <div>
												  <%@ include file="/common/shopPaging.jspf" %>
		 										 </div>
		 										 </s:if>
												</div>	
												
												<div id="msg_userpoint" style="text-align:center">
													<font color="red" id="font1">${msg_userpoint}</font>
												</div>
										    </div>	
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-1  hidden-xs"></div>
						</div>
					</div>				
				</div>
			</form>
		</div>		
</body>
</html>
