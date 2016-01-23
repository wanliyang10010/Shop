<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>

<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="owner" content="" />
<meta name="robots" content="index, follow" />
<meta name="googlebot" content="index, follow" />
<title>我的评价</title>

<%@ include file="/common/top-head.jspf" %>
<script type="text/javascript" src="${ctx}/js/web.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/evaluation.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/fontBorder.css">
<script type="text/javascript"
	src="${ctx}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/pointEvaluation/buyPostViewEvaluation.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top-nav.jspf" %>
</div>
<div id="templatemo_main">
	<center>
		<form name="userform" action="" id="userform" action="">			
			 &nbsp; &nbsp;&nbsp;<h3>我的评价</h3>	
			 <input type="hidden" id="authorizedToken" name="authorizedToken" value="${userid}"/>
			  <input type="hidden"  name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	   		 <input type="hidden"  name="page.pageSize" id="pageSize" value="${page.pageSize}"/>	
			<table width="800px" align="center" colspan="1">
			 <s:if test="#request.msg_shoppoint!='暂无数据！' ">
				<tr>
					<td align="center">店铺平均得分： <font color="red" id="font1">${msg_shoppoint}</font>
						&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
						<button id="btn_shoppoint" type="button" onclick="shoppoint('${userid}');"
							style="width:80px;">查看详情</button></td>
				</tr>
				<tr>
					<td align="right" style="height:20px"></td>
				</tr>
				</s:if>
				<tr>
					<td align="center">买家累积积分： <font color="red" id="font1">${msg_userpoint}</font>
						&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
						<button id="btn_userpoint" type="button" onclick="userpoint('${userid}');"
							style="width:80px;">查看详情</button>
					</td>
				</tr>
			</table>

				<table width="800px" align="center" colspan="8" id="">
				</br>
				<tr>
					<td align="center" style="width:110px;" colspan="1"><img
						id="imgFromBuyY" src="${ctx}/image/evaluation/fromBuyY.png"
						style="CURSOR: pointer" /> <img id="imgFromBuyN"
						src="${ctx}/image/evaluation/fromBuyN.png" onclick="img1('${userid}');" 
						style="CURSOR: pointer;display:none"/></td>
					<td align="center" style="width:120px" colspan="1"><img
						id="imgFromSellY" src="${ctx}/image/evaluation/fromSellY.png" 
						style="CURSOR: pointer;display:none"/>
						<img id="imgFromSellN" src="${ctx}/image/evaluation/fromSellN.png"
						style="CURSOR: pointer" onclick="img2('${userid}');" /></td>
					<td align="center" style="width:110px" colspan="1"><img
						id="imgToOtherY" src="${ctx}/image/evaluation/toOtherY.png"
						style="CURSOR: pointer;display:none" /> <img id="imgToOtherN"
						style="CURSOR: pointer" src="${ctx}/image/evaluation/toOtherN.png" onclick="img3('${userid}');" /></td>
					<td align="center" style="width:460px" colspan="5"></td>
				</tr>
			</table>

			<table width="800px" align="center" id="tbFromBuy" style='word-wrap:break-word;word-break:break-all'>
				 <tr>
					<td>
					<s:if test="#request.page!= null&&#request.page.getTotalItems()>0"> 
							<table width="800px" align="center" class="table">
								<tr style="background:#BFDBEB;">
									<td align="center" width=30%><B>评价内容</B>
									</td>
									<td align="center" width=20%><B>评价人</B>
									</td>
									<td align="center" width=30%><B>宝贝信息</B>
									</td>
									<td align="center" width=10%><B>操作</B>
									</td>
									<td align="center" width=10% style="display:none">ID</td>
								</tr>
							<s:iterator value="#request.page" status="s">	
									<tr>
										<td align="center">${goodscontent}</br>[${evaluationTime}]
											</br> 
											<textarea name="checkIdea${goodsEvaluationId}"
												id="checkIdea${goodsEvaluationId}" maxlength="333"
												style="width:240px;height:50px;font-size: 16;display:none"></textarea>
											</br>
											 <img
											id="imgFromBuyPublishReply${goodsEvaluationId}"
											src="${ctx}/image/evaluation/publishReply.png"
											onclick="publishreplyfrombuy('${goodsEvaluationId}');"
											style="display:none;" /> 
											
											<s:if test="checkTime!=null && checkTime!=\"\" ">
											<label style="font-size:16;">[我的回复]</label>
											<label id="lbfrombuycheckIdea"
											style="font-size:16;color:#BD7F00">${checkIdea}</br>[${checkTime}]</label>
											</br>
											</s:if>
											
											 <s:if test="addTime!=null && addTime!=\"\" ">
											 </br>
											<label id="lbfrombuy"
											style="font-size: 16">[追加评论]${addcontent}</br>[${addTime}]</label>
											</s:if>
											
										</td>
										<td align="center">${userinfo.username}</td>
										<td align="center">${goods.goodsname}</td>
										<td align="center">
										 <s:if test="(checkIdea==null) || (checkIdea==\"\")">
										<img
											id="imgFromBuyReply${goodsEvaluationId}"
											src="${ctx}/image/evaluation/reply.png"
											onclick="replyfrombuy('${goodsEvaluationId}');"/>
											</s:if>
											</td>
										<td align="center" style="display:none">${goodsEvaluationId}</td>
									</tr>
								</s:iterator>
								<tr>
								<td colspan="5">
				  <%@ include file="/common/shopPaging.jspf" %>
				  </td></tr>
							</table>
						</s:if>
						<div id="msg_frombuy">
							<font color="red" id="font1">${msg_frombuy}</font>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</center>
</div></body>
</html>
