
//页面加载完成.简写形式为 $(function() {}); 
$(document).ready(function() {
	var addrid = $('input[name="addrradio"]:checked').val();
	$("#addrid").attr("value",addrid); 
	//alert( "地址id  " + $("#addrid").attr("value"));
});

$(function(){
	
	if($('input[name="addrradio"]:checked').length > 0){
		var addrid = $('input[name="addrradio"]:checked').val();
		$("#addrid").attr("value",addrid);
	}
	else if($('input[name="addrradio"]:checked').length == 0){
		//有收货地址，但是没有选中任何一条
		$("#addrid").attr("value","-1");
	}else{
		$("#addrid").attr("value","0");
	}
	
	//更换收货地址
	$("input:radio[name='addrradio']").change(function (){
		//获取选中的id
		var addrid = $('input[name="addrradio"]:checked').val();
		$("#addrid").attr("value",addrid);
		//alert("更换地址id -> " + $("#addrid").attr("value"));
	});	
	
	
	//提交表单
	//$('#form1').submit(
	$("#btn_submit").click(function()
	{ 
		//检查表单,表单错误的不能进行提交
		if(!check())
			return;
		
		//alert("提交表单");
		//alert("表单内容" + $('#form1').serialize());
		$.ajax({  
            type:"POST",
            url : ctx + "/order/buyNowAction!saveOneOrder.action",  
            data : $('#form1').serialize(),//"addrid=1",
            success:function(result){
            	if(result.data == 'ok'){
            		//alert('提交成功');
            		document.location.href = ctx + "/orderAction!jumptoPay.action?orderid=" + result.orderid 
            			 + "&redirectUrl=" + ctx + "/orderAction!haveBuyGoods.action";
            	} else if(result.data == 'fail'){
            		//alert('提交失败');
            		alert(result.dataMsg);
            	}
            },
            error: function(result) {
            	alert("error:"+result.dataMsg);
            }
        });
	}); 

});

//onsubmit事件无法触发，使用绑定按钮点击事件代替
function check() {
	if(checkIllegalChar()){
		alert("文本框中不能包含下列任何字符： \" \' &amp;");
		return false;
	}
  //alert("check");
  var addr = $("#addrid").val();
  
  if(addr == "0"){
	  alert("你还没有可用的地址，请添加！");
    return false;
  }
  
  if(addr == "-1"){
		alert("请选择一个收货地址！");
	    return false;
  }
  
  if(addr == undefined){
	  alert("获取地址信息失败，请重试！");
    return false;
  }
  
  if (addr ==  null) {
	  alert("请选择一个有效的收货地址！");
    return false;
  } 
  
  return true;
}
