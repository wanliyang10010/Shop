
//添加到购物车
function add2Cart() {
	
	if(!check()){
		return;//没通过check的都直接返回
	}
	
	var gid = $("#goodsId").val();//商品id
	var shopid = $("#shopid").val();//店铺Id
	var g_num = $("#num").val();//商品数量
	
	var dataVal = "goodsId=" + gid + "&amount=" + g_num+ "&shopid="+shopid;
	if($("input[type='radio'][name^='radio']:checked").length > 0){
		//dataVal += "&property=" + $("input[type='radio']:checked").val();
		$("#property").val($("input[type='radio']:checked").val());
	}
	
	//document.form1.action= ctx + "/cartItemAction!addItemJson.action"; 
	//document.form1.submit();
	
	$.ajax({
		type : "POST",
		url  : ctx + "/cartItemAction!addItemJson.action",
		data : $("#form1").serialize(),
		success : function(result) {
			if (result.data == "ok") {
				try{getCartItemCount();}catch(e){console.log(e);}
				
				alert('商品已加入购物车!');
			} else if(result.data == "shopowner"){
				document.location.href = ctx + '/viewProductAction_product.do?gid=' + result.goodsId;
			}
			else{
				alert('操作失败请重试!');
			}				
		},
		error : function(e) {
			alert('系统繁忙，请稍后再试.');
			console.log(e);
		}
	});

};

//立即购买
function doBuyNowSubmit(){
	
	if(check())
	{
		document.form1.action= ctx+"/order/buyNowAction!buyNow.action"; 
		document.form1.submit();
 	} 
}

// 检查函数
function check()
{
	var shopowner = $("#shopowner").val();//商家Id
	var buyer = $("#buyer").val();//买家Id
	if(shopowner == buyer){
		alert("不能选购自己出售的商品!");
		return false;
	}
	
	var num_val = $("#num").val();//选购商品数量
	
	if(!num_val || num_val == ''){
		alert("请填写选购数量");
		//alert("null or undefined or NaN"); 
		return false;
	} 
		
	if(parseInt(num_val) != num_val){
		alert("选购数量请填写整数");
		return false;
	}
	
	var g_num =  parseInt(num_val);//转换成整数
	
	if(g_num <= 0){
		alert("选购数量至少为1件");
		return false;
	}
	
	/**----判断库存信息----**/
//	if($("input[type='radio'][name^='radio']").length > 0){
//		var prop = $("input[type='radio'][name^='radio']:checked");
	
	if($("input[type='radio'][name^='property']").length > 0){
		
		//存在属性信息的情况
		var prop = $("input[type='radio'][name^='property']:checked");
		if(prop.length > 0){
			//删去背景颜色
			$("td[class^='td_properities']").css("background-color","");
			//选中了属性值，判断带属性的库存
			var propAmount = parseInt(prop.next("span").text());
			if(g_num > propAmount){
				//alert('库存不够');
				alert("您选购数量大于库存数量");
				return false;
			}
		} else {
			//没有选中属性值,加背景色显示提示
			$("td[class^='td_properities']").css("background-color", "#FFFFCC");
			alert("您选择商品类别");
			//alert('选择类别');
			return false;
		}
		
	} else {
		//不存在属性信息的情况
		var goods_amount =  parseInt($(".goods_amount").text());//库存数量
		//alert('总库存 : ' + goods_amount);
		if(g_num > goods_amount){
			alert("您选购数量 " + g_num + " 大于库存数量");
			return false;
		}
	}
	return true;
}


//获取属性信息
function getProperties()
{
	/*用length来判断是否存在某元素*/
	//获取一组radio
	var radioProperties = $("input[type='radio']");
	if(radioProperties.length > 0){
		
		radioChecked = $("input[type='radio']:checked");
		if(radioChecked.length > 0){
			//找到属性值
			alert(radioChecked.val());
			return radioChecked.val();
		}else{
			//不存在被选中的，那么报错
			return 'error';
		}
	}
}


