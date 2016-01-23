<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="cn.xaut.shop.pojo.GoodsDetial"%>
<%@ include file="/common/taglibs.jspf"%>
<!doctype html>
<html>
<head>
<title>${goods.goodsname}</title>
<script type="text/javascript" src="${ctx}/js/mzp-packed.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/jquery-1.9.0.js"></script>
<link href="${ctx}/css/zzsc.css" type="text/css" rel="stylesheet">
<link href="${ctx}/css/magiczoomplus.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="${ctx}/css/jquery.spinner.css" />
<script type="text/javascript" src="${ctx}/js/ViewGoods/ProductDetial.js"></script>  
<link href="${ctx}/css/MyShop/templatemo_style.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="${ctx}/css/MyShop/nivo-slider.css" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/MyShop/ddsmoothmenu.css" />
<script type="text/javascript" src="${ctx}/js/jquery.spinner.js"></script>
    
<style type="text/css">
	div {
	
		align:center;
		margin-left:auto; margin-right:auto;
	}	
	body{text-align:center} 
</style>
</head>
<body>
<div id="templatemo_main">
	<center>
		  <c:if test="${msg==''}">          
		   <table width="900" border="1">
              <tr height="40"> 
                  <td align="right" >
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
                     <td align="left" width="30%">
                      <label for="textfield">${shop.shopcategory}</label>
                     </td>
                      <td align="right">
                         <label for="textfield">注册时间：</label>
                     </td>
                     <td align="left" width="30%">
                      <label for="textfield">${shop.regeditdate}</label>
                     </td>
                     </tr>
                      <tr height="40"> 
                        <td align="left" colspan="4">
     						<a href="javascript:shopdetial('${shop.shopId}');">所有商品></a>
          					${goods.goodsname}
          				</td>
                      <tr>
                  </table>
			<table width="900">
				<tr>
					<td align="right" style=" width:40%">
						<div class="box">
							<div class="left-pro">
								<div class="t2">
									<a href="${ctx}${goods.goodsPicture.url}" id="zoom1"
										class="MagicZoom MagicThumb"><img
										src="${ctx}${goods.goodsPicture.url}" id="main_img" class="main_img"
										style="width:350px; height:350px;" /> </a>
								</div>
								<div class="t1">
									<img src="${ctx}/image/viewproduct/gotop.gif" id="gotop" />
									<div id="showArea">
									<c:forEach items="${GPictureList}" var="gpicture">
										<a href="${ctx}${gpicture.url}" rel="zoom1"
											rev="${ctx}${gpicture.url}"><img
											src="${ctx}${gpicture.url}" /> </a>
									</c:forEach>
									</div>
									<img src="${ctx}/image/viewproduct/gobottom.gif" id="gobottom" />
								</div>
								
							</div>
						</div>
					</td>
					<form name="form1" id="form1" method="get">
						<input type="hidden" name="shopid"  id="shopid" value="${shop.shopId}" />
						<input type="hidden" name="shopname"  id="shopid" value="${shop.shopname}" />
						<input type="hidden" name="goodsid"  id="goodsid" value="${goods.goodsid}" />
						<input type="hidden" name="goodsname" id="goodsName" value="${goods.goodsname}" />
						<input type="hidden" name="price"  id="goodsPirce" value="${goods.price}" />
						<input type="hidden" name="amount" id="num" />
					<td align="left" style=" width:60%">
						<table  id="save_text" align="left" style=" width:100%" border="1">
							<tr height="40">
								<td width="30%" align="right">店铺名称：</td>
								<td align="left">${shop.shopname}</td>
							</tr>
							<tr height="40">
								<td width="30%" align="right">商品名称：</td>
								<td align="left">${goods.goodsname}</td>
							</tr>
							<tr height="40">
								<td width="30%" align="right">商品售价￥：</td>
								<td align="left">${goods.price}</td>
							</tr>
							<tr height="40" id="tr_p" style="display:none">
								<td  width="30%" align="right">促销价￥：</td>
								<td align="left">${goods.discount.price}</td>
							</tr>
							<script type="text/javascript">
                            var ss='${goods.discount.discountId}';
	                            if(ss>0)
	                            {
	                                document.getElementById("tr_p").style.display="";
	                            }
	                            else
	                            {
	                                document.getElementById("tr_p").style.display="none";
	                            }
							</script>	
							<tr height="40">
								<td align="right">	
								<label for="textfield">累计销量：</label>
								</td>
								<td align="left">${goods.samount}</td>
							</tr>
						
						<tr height="40">
								<td align="right" >	
								<label for="textfield">累计评论：</label>
								</td>
								<td align="left">
								<a href="javascript:openDetial(${goods.goodsid})">  查看详情</a>
								<a href="javascript:openEva(${goods.goodsid})">  查看评论</a></td>
								<% 
								List<GoodsDetial> list=(List<GoodsDetial>)request.getAttribute("GDetialList");
								if(list!=null&&list.size()>0)
								{
								 for(int i=0;i<list.size();i++)
								 {
								    GoodsDetial goodsDetial=list.get(i);
								    String[] str=goodsDetial.getItemvalue().split("，");
								%>
							<tr height="40">
							   <td align="right"><%=goodsDetial.getGtItem().getItemname()%></td>		   
							   <td align="right">
							   <% 
							    if(str.length>0)
								{
								   for(int j=0;j<str.length;j++)
								 {
								 %>
							    <input type="radio" name="radio<%=i%>" id="radio<%=i%><%=j%>" value="<%=str[j]%>"><%=str[j]%>
								<% 
								}
								}
								 %>
								</td>
								</tr>
								<% 
								}
								}
								%>
							<tr height="40">
								<td align="right">数量：</td>
								<td align="left">
								<input type="text" class="spinner" id="amount" name="amount"/>
								库存(${goods.amount})件</td>
							</tr>
							<tr height="45">
								<td align="center"><a href="javascript:addFavourite('${ctx}' ,'${goods.goodsid}');">收藏商品</a>
								</td>
								<td align="center">
									<input type="button" id="add2cart"  onclick="add2Cart();"  value="加入购物车" style="height:30" />
									<button id="btn_cancel" type="submit" style="height:30" onclick="buyNow();">立即购买</button>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<script type="text/javascript" src="${ctx}/js/zzsc.js"></script>
			<script type="text/javascript">
				$('.spinner').spinner();
			</script>
			  </c:if>         
			<div id="msg" >
	              <font color="red" id="font1" >${msg}</font>
             </div>
		</div>
		<input id="context" type="hidden"  value="${ctx }" />
		</form>
	</center>
</body>
</html>
