
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}


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
	});	
	
});

//更新了判断地址check方法 donglei 
//onsubmit事件无法触发，使用绑定按钮点击事件代替
function check() {
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


 function listGoods()
 {
	 document.form1.action= ctx+"/stageGoodsAction_getGoods.action"; 
	 document.form1.submit(); 
 }
 
 function openGoods(id)
 {
	window.open(ctx+"/stageGoodsAction_opengoods.action?gid="+id+"");
 }
 
 function changeNow(){
	 var sgoodsId = document.form1.sgoodsId.value;
	 var authorizedToken=document.getElementById("authorizedToken").value;
	  $.ajax({
			type : "POST",
			url : ctx+"/stageOrderAction_checkOrder.action",
			data : "sgoodsId=" + sgoodsId+"&authorizedToken=" + authorizedToken,
			success : function(result) {
				if (result.data == 'right') {
					document.getElementById("address").style.display="";
					return;
				}
				else if (result.data == 'wrong')
				{
					alert('您本月已兑换过该商品！');
				}
			},
			error : function() {
				alert('系统忙，请稍后重试');
			}
		});
}
 
 function addOrder(id)
 {
	 if(check())
	 {
		 var addr = $('input[name="addrradio"]:checked').val();
		 var authorizedToken=document.getElementById("authorizedToken").value;
    	  $.ajax({
  			type : "POST",
  			url : ctx+"/stageOrderAction_AddOrder.action",
  			data : "sgoodsId=" + id
  			  +"&addrid="+addr+"&authorizedToken=" + authorizedToken,
  			success : function(result) {
  				if (result.data == 'right') {
  					alert('积分商品兑换成功！');
  					document.getElementById("address").style.display="none";
  				}
  				else if (result.data == 'wrong')
  				{
  					alert('积分商品兑换失败！');
  				}
  				else if (result.data == 'not')
  				{
  					alert('您的积分值不够兑换该商品！');
  				}
  			},
  			error : function() {
  				alert('系统忙，请稍后重试');
  			}
  		});
	 }
 }
 