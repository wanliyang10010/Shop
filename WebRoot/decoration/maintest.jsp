<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="/common/taglibs.jspf"%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<base target="_self"/>
<title>布局管理</title>
<div align="center" style="margin-top:-40px;">
<%@ include file="/common/top.jspf" %>
</div>
<script type="text/javascript" src="${ctx}/js/jQuery/jquery-1.9.0.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-ui.js"></script>
<link rel="stylesheet" href="${ctx}/css/jquery-ui.css" type="text/css"></link>
<script type="text/javascript">
 
	function submitunit(){
      if($("#size").val()=="1"){
  a="<div  style='width:950px;'>+请添加功能模块</div>";
      }
      if($("#size").val()=="2"){
      a="<div width='190px' style='float:left;width:190px;'>+请添加功能模块</div><div >+请添加功能模块</div>";
      }
      if($("#size").val()=="3"){
       a="<div style='float:left;width:750px;'>+请添加功能模块</div><div width='190px' >+请添加功能模块</div>";
      }
      if($("#size").val()=="4"){
      a="<div style='float:left;width:190px;' >+请添加功能模块</div><div style='float:left;width:550px;'>+请添加功能模块</div><div width='190px'>+请添加功能模块</div>";
      }
      if($("#size").val()=="5"){
       a="<div style='float:left;width:550px;' >+请添加功能模块</div><div style='float:left;width:190px;'>+请添加功能模块</div><div width='190px'>+请添加功能模块</div>";
           }
      if($("#size").val()=="6"){
      a="<div style='float:left;width:190px;' >+请添加功能模块</div><div style='float:left;width:190px;'>+请添加功能模块</div><div width='190px'>+请添加功能模块</div>";
        }
       
       $("#include").append(a);
       
 $("#include").children().unbind("click");
 $("#include").children();
   $("#include").children().each(function(){
			$(this).click(function(){
					$(this).attr("name","1");
				 $( "#dialog-form" ).dialog( "open" );
				 
			});
		});
}
 
  $(function() {
  
   dialog = $( "#dialog-form" ).dialog({
      autoOpen: false,
      height: 500,
      width: 350,
      modal: true,
      buttons: {
        "添加": addUser,
        Cancel: function() {
          dialog.dialog( "close" );
        }
      },
      close: function() {
        dialog.dialog( "close" );
      }
    });
 
  
 function addUser() {
 var funct=$("#funtrunck").find("option:selected").text();
 $("#include").children().each(function(){
 var boo=$(this).attr("name");
 if(boo=="1"){
 if(funct=="自定义区域"){
 $(this).html($("#zdytext").val());
 }else{
 $(this).html(funct);
 }
 
 $(this).attr("name","0");
 }
 })
  dialog.dialog( "close" );
 }
 
 
 $("#zdy").hide();
 $("#funtrunck").change(function(){
if($(this).val()=="4")
{
$("#zdy").show();
}
else
{
$("#zdy").hide();
 
}
})
 
   
  });
  function submit(){
  
  
  var layout=$("#include").html();
  var shopid=$("#shopid").val();
  
    $.ajax(
			       {
				   type: "POST",
				   url: "decoration_save.action",
				   //data: "layout="+layout+"&gooid="+1,
				   data:{layout:layout,shopid:shopid},
				   async: false,	
				   dataType: "json",			   
				   success: function(result)
				   {
				   	    var returnIsResult = result.isResult;
				   	    if(returnIsResult == "true")  
						 {  
						      alert("提交成功！");						  
						      return true;  
						 }else{
						      alert("提交失败！");
						      return true;  
						 } 
				   }

				});	
				}
				
				function reset(){
				$("#include").empty();
				}
</script>
<style type="text/css">
	div {
		
		align:center;
	}
</style> 
</head>

	<body align="center">
	<div id="dialog-form" title="添加功能模块"> 
  <form>
    <fieldset>
    <label for="name">功能模块选择：</label>
     <select  name="funtrunck" id="funtrunck">		
			<!-- <option value ="1">店铺内搜索</option>   --> 
  <option value ="2">商品购买页</option>  
  <option value="3">商品详情页</option>  
  <option value="4">自定义区域</option> 				
						     </select>
						     
						       <div id="zdy"><p><label id="zdylable" for="name" style="align:center">自定义区域添加代码：</label></p>
<textarea id="zdytext" style="width:300px;height:200px;" name="defint"></textarea>
</div>
						       </fieldset>
  
  </form>
</div>
  <div id="333"  style="width:950px;">
  <p class="validateTips">选择布局格式</p>
 
  <form>
      <label for="name">布局大小：</label>
      <select  name="size" id="size">		
			 <option value ="1">950px</option>  
  <option value ="2">190px+750px</option>  
  <option value="3">750px+190px</option>  
  <option value="4">190px+550px+190px</option> 
   <option value="5">550px+190px+190px</option>
    <option value="6">190px+190px+550px</option> 				
						     </select>
 <input type="button" name="添加" value="添加" onclick="submitunit();"/>	   
  </form>
</div>
   <div  style="background:#f0ffff; color:black;border:2;width:950px;" align="center">店铺页头
   </div>
   <div style="background:#f0ffff; color:black;border:2;width:950px;" align="center" >店铺招牌</div>
   <div  style="background:#f0ffff; color:black;border:2;width:950px;" align="center">导航</div>
   <div id="include" style="width:950px"></div>
   <div id="adddiv"  align="center" style="background:red;border:2 red;width:950px;">+添加布局单元</div>
    <div  style="background:#f0ffff; color:black;border:2;width:950px;" align="center">店铺页尾
   </div>
   <div style="width:950px" align="center"><input type="button" name="添加" value="保存" style="background:#0174DF;" onclick="submit();"/>	   
   <input type="button" name="添加" value="取消" onclick="reset();"/>	   </div>
<input type="hidden" id="shopid" name="shopid" value="${shopid}" />
  </body>

</html>