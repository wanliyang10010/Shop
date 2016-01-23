//添加trim方法 为了兼用IE8及以下版本
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}

$(function(){
	
	var authorizedToken = $("#authorizedToken").val();
	
	$(document).ready(function (){
		$(":checkbox").each(function(){
			$(this).prop("checked", true);
		});
		//计算总价
		calcTotal();
	});
	
	function deleteItem(itemid){
		//获取商品编号,给后台删除指定购物项
		$.post( ctx + "/cartItemAction_removeCartItem.action",
			{"itemId":itemid,"authorizedToken":authorizedToken},
			function(result){
				try{getCartItemCount();}catch(e){console.log(e);}
				//计算总价
				calcTotal();
				var shopid = parseInt(result.shopid);
				if(shopid > 0){
		 			$("tr[id=trshop_" + shopid + "]").remove();
		 		}
		 	});
		 	// 删除选中行//获取当前按钮的所有tr,选了第一个
			$("#" + itemid).parents("tr:first").remove();
	}
	
	//删除单个购物项
	$(".delLink").click(function(){
		var itemid = $(this).attr("id");
		confirm("确定删除？",deleteItem,null,itemid);
	});
	
	// =========
	//  店铺全选
	// =========
    $("[id^='CheckAll_']").click(function() {
    	//alert("check");
       var flag = this.checked;
        var n=$(this).attr('id').replace('CheckAll_','');
        $("[id=item_"+n+"]:checkbox").each(function() {
            $(this).prop("checked", flag);
           });
    });
	    
    // =========
	//  商品勾选
	// =========
    $("[id^=item_]:checkbox").click(function() {
    	
    	var name = $(this).attr("id");
    	var shopid = name.replace('item_','');
    	
    	//选择所有子购物项
    	var items = $("input[id="+ name +"]");
    	var len = items.length;
    	var selected = 0;
    	items.each(function(i) {
			if ($(this).prop("checked")) {
				selected++;
			}
		});
    	
		if(len == selected){
			$("#CheckAll_"+shopid).prop("checked", true); 		
		}else{
			$("#CheckAll_"+shopid).prop("checked", false);
		}
   });
	    
	    
    //勾选的数量及总价
    $("input[type=checkbox]:not(.check-all)").click(function()
    {
    	calcTotal();
    	
    	//下面是“全选”复选框
    	var count = 0;
    	var shopchecks = $("[id^=CheckAll_]:checkbox");
    	shopchecks.each(function(){
    		if($(this).prop("checked")){
    			count++;
    		}
    	});
    	if(count == shopchecks.length){
    		$(".check-all").prop("checked",true);
    	}
    	else{
    		$(".check-all").prop("checked",false);
    	}
    });
    
    // ==============
    //  全选checkbox
    // ==============
    $(".check-all").click(function(){
    	
    	var flag = $(this).prop("checked");
    	$("input[type=checkbox]").each(function(){
    		$(this).prop("checked",flag);
		});
    	calcTotal();
    });
	    
    // ==============
    //     结算按钮
	// ==============
    $("#submit").click(function() {
    	
    	// 被勾选的商品所在的购物车的购物车Id
    	var cartIdlist = new Array();
    	// 被勾选的购物项Id
    	var list= new Array();
    	
    	var itemlist = $("[id^=item_]:checkbox");
    	
		itemlist.each(function(i){
			if($(this).prop("checked")){
				var itemid = $(this).attr("value");
				list.push(itemid);
				
				// 根据当前item获取shopid
				var shopid = $(this).attr("id").replace('item_','');
				// 根据shopid获取购物车Id
				var cartid = $("#CheckAll_" + shopid).attr("value");
				
				cartIdlist.push(cartid);//这里存在重复添加的清空，需要去重
			}
		});
		
		if(list.length > 0)
    	{
			//提交表单
			
			// 去除重复的ID
			var checkedCart = unique(cartIdlist);
			
			$.ajax({  
                type:'POST',  
                traditional :true,  
                url: ctx + '/orderAction!createPerOrders.action',  
                /*data:$('#form1').serialize() + '&checkedCart=' + checkedCart,*/
                /*传递数组*/
                data : {"checkedCart":checkedCart , "chkItem":list} ,
                success:function(result){
                	if(result.data == 'ok'){
                        //alert('提交成功');
                		//document.location.href= ctx + '/order/submitOrderAction!listPreOrder.action';
                		submitForm(checkedCart);
                	} else if(result.data == 'fail'){
                		alert(result.dataMsg);
                	}
                }  
            });
            
    	}
    	else{
    		alert("请选择要结算的商品");
		}
    });
  });


//--------------------------------------
/* 普通函数 */
//--------------------------------------


function submitForm(cartIdlist){
	
	//重新提交一次表单给/order/submitOrderAction!listPreOrder.action
	$('#cartIdlist').val(cartIdlist.join(","));
	$('#form1').attr("action", ctx + "/order/preOrderAction!listPreOrder.action"); 
	$("#form1").attr("method","POST");
	$("#form1").submit(); 
	
}


/**
 * 利用hash实现数组去重
 */
function unique(arr) {
    var result = [], hash = {};
    for (var i = 0, elem; (elem = arr[i]) != null; i++) {
        if (!hash[elem]) {
            result.push(elem);
            hash[elem] = true;
        }
    }
    return result;
}

	
/**
 * 计算总价格的函数
 */
function calcTotal()
{
	var price = 0;
    var selected = 0;
	
	$("tr.itemrow").each(function(){
		
		//this.children得到所有td,在第0个td下找第0个input
		var box = $(this).children("td:eq(0)").children("input:eq(0)");
		if(box.prop("checked"))
		{
			var input = $(this).children("td:eq(4)").find("input");
			var span = $(this).children("td:eq(5)").find("span");
			selected += parseInt(input.val());
			price +=  parseFloat(span.html().trim());
		}
		
	});
	$("#selectedTotal").html(selected);//已选商品N件
	$("#priceTotal").html(price.toFixed(2));//合计价格
};
	    
  //减数量
function minus(gid,itemid,property) {
	
	var authorizedToken = $("#authorizedToken").val();
	var amount = $("#amount_" + itemid).val();
	var num = parseInt(amount);
	
	if(num <= 1){
		num = 1;
		$("#amount_"+itemid).attr("value",num);
		return;
	}
 	
	$.ajax({
		type : "POST",
		async: false,
		url : ctx + "/cartItemAction!minusAmount.action",
		data : "goodsId=" + gid+ "&itemId=" +itemid + "&property=" + property + "&authorizedToken=" + authorizedToken, 
		success : function(result) {
			if (result.data == 'ok') {
				
				//alert('修改成功!');
				$("#item_"+itemid).html("");
				num = num - 1;
				$("#amount_" + itemid).attr("value",num);
				var iprice = $("#iprice_"+itemid).html();
			 	var itotal = num * iprice;
			 	$("#itotal_"+itemid).html(itotal.toFixed(2));
				
				calcTotal();
			} else if(result.data == 'fail'){
				//alert('修改失败!');
				if(result.dataFlag == 'greater'){
					num = result.dataAmount;//目前的数量是
					$("#amount_" + itemid).attr("value",num);
					//alert(result.dataMsg);
					$("#item_"+itemid).html(result.dataMsg);
				} else if(result.dataFlag == 'invalid'){
					$("#item_"+itemid).html("商品失效");
				}
				
			} else{
				alert(result.dataMsg);
			}
		},
		error : function() {
			alert('系统繁忙，请稍后再试.');
		}
	});
};
		
//加数量
function plus(gid,itemid,property) {

	var authorizedToken = $("#authorizedToken").val();
	var amount = $("#amount_"+itemid).val();
	var num = parseInt(amount);
 	
	$.ajax({
		type : "POST",
		async: false,
		url : ctx + "/cartItemAction!plusAmount.action",
		data : "goodsId=" + gid+ "&itemId=" +itemid + "&property=" + property + "&authorizedToken=" + authorizedToken, 
		success : function(result) {
			if (result.data == 'ok') {
				
				num = num + 1;
				$("#amount_" + itemid).attr("value",num);
				//计算本行合计
			 	var iprice = $("#iprice_"+itemid).html();
			 	var itotal = num * iprice;
			 	$("#itotal_"+itemid).html(itotal.toFixed(2));
				
				//计算总价
				calcTotal();
			}
			else if(result.data == 'fail'){
				
				if(result.dataFlag == 'invalid'){
					$("#item_"+itemid).html("商品失效");
				}
				alert(result.dataMsg);
			}
			else{
				alert(result.dataMsg);
			}
		},
		error : function() {
			alert('系统繁忙，请稍后再试.');
		}
	});
};

/*=============添加商品收藏=====================*/

function addFavourite(gid) {
	$.ajax({
		type : "POST",
		async: false,
		url : ctx + "/order/favouriteAction!addFavourite.action",
		data : "good.goodsid=" + gid + "&productUrl=" + ctx 
				+ "/viewProductAction_product.do?gid="+gid ,
		success : function(result) {

			if (result.data == 'save') {
				alert('添加收藏成功!');
			} else if (result.data == 'exits') {
				alert('已经收藏过该商品!');
			}
			// window.location.reload(); 
		},
		error : function() {
			alert('系统繁忙，请稍后再试.');
		}
	});
};
		
		

	
	
	
	

	