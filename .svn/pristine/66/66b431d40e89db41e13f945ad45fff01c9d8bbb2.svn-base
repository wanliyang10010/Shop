<%@ page import="java.util.*,java.text.*,java.io.*,java.net.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<s:token />
<title>上传展示图片</title>
	<%@ include file="/common/top-head.jspf"%>
<link rel="stylesheet" type="text/css"  href="${ctx}/css/page.css" />
<script type="text/javascript" src="${ctx}/js/web1.js"></script>
<script type="text/javascript" src="${ctx}/js/Goods/GoodsPictureInfo.js"></script>
</head>
<body>
<div align="center" style="margin-top:-40px;">
		<%@ include file="/common/top-nav.jspf"%>
	</div>
<div id="templatemo_main">
	<center>
		<form name="form1" action="" id="form1" enctype="multipart/form-data">
		<input type="hidden" id="authorizedToken" name="authorizedToken" value="${sessionScope.userid }" />
	 <input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	  <input type="hidden" name="page.pageSize" id="pageSize" value="${page.pageSize}"/>
	   <input type="hidden" name="goodId" id="goodId" value="${sessionScope.goodsAdd.goodsid}"/>
	  <input type="hidden" name="fileid" id="fileid" >
			   <div>
                            <table width="800">
                                <tr>
                                    <td align="right" style=" width:30%" >
                                    <label for="textfield">商品名称：</label>
                                    </td>
                                    <td align="left">
                                    ${sessionScope.goodsAdd.goodsname}</td>
                                 </tr>
                                 <tr>
                                    <td align="right" style=" width:30%" >
                                    <label for="textfield">上传图片：</label>
                                    </td>
                                    <td align="left">
                                       <input type="file" id="upload" name="uploadFile.item" style=" width:30%">
                                       <input type="button" name="btn_submit" id="btn_submit" value="上传" onclick="add();" >
                                       </td>
                                </tr>
                                 <tr>
	        </tr>
                            </table>
        <c:if test="${msg==''}"> 	
       <table width="800"  align="center" >
       <tr height="40" >
	          <td align="center" colspan="6">1、图片设为封面，该图将作为商品默认图片; 2、图片设为预览，该图将在商品详情页中显示;<br/></td>
	     </tr>
	     <tr height="40">
	          <td align="center" width=10%>序号</td>
	          <td align="center" width=15%>图片预览</td>
	          <td align="center" width=25%>文件名称</td>
	          <td align="center" width=15%>设为封面</td>
	          <td align="center" width=15%>设为预览图</td>
		      <td align="center" width=10%>操作</td>
	     </tr>
		    <s:iterator value="#request.page" status="s">
		    <tr>
		         <td  align="center" width=10%>${s.count+(page.pageNo-1)*page.pageSize}</td>
		          <td width=15% align="center">
		         <img height="100" width="100" src="${ctx}${url}"/></td>
		         <td width=25% align="center">${name}</td>
		          <c:choose>
			      <c:when test="${sessionScope.goodsAdd.goodsPicture.fileid==fileid}">
			                   <td width=15% align="center">封面页  </a>  
			          </td>            
			     </c:when>        
			     <c:otherwise>
			         <td width=15% align="center">
                      <a href="javascript:update('${fileid}','${type}');">设为封面</a>     
			         </td>                      
			      </c:otherwise> 
			       </c:choose>
			         <c:choose>
			      <c:when test="${type=='0'}">
			                   <td width=15% align="center">
			                   <a href="javascript:updatePicture('${fileid}');">设为预览
			                    </a>  
			          </td>            
			     </c:when>        
			     <c:otherwise>
			         <td width=15% align="center">
                         <a href="javascript:updatePicture('${fileid}');">取消预览</a>     
			         </td>                      
			      </c:otherwise> 
			       </c:choose>
			        <c:choose>
			      <c:when test="${sessionScope.goodsAdd.goodsPicture.fileid==fileid}">
			                    <td width=10% align="center">删除</a>
			     </td>
			     </c:when>        
			     <c:otherwise>
			          <td width=10% align="center">
					  <a href="javascript:deletefile('${fileid}');">删除</a>
			     </td>               
			      </c:otherwise> 
			       </c:choose>
		    </tr>
	    	 </s:iterator>
	   </table>
	    </c:if>
	    <%@ include file="/common/pagination.jspf" %>
   <div id="msg" >
	              <font color="red" id="font1" >${msg}</font>
	   
			</div>
	    </div>             
		</form>
	</center>
	 <br/>
	  <br/>
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
