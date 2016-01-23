function doDeleteAddr(id){
	var authorizedToken = $("#authorizedToken").val();
	var ctx = $("#context").val();
	$.ajax({
        type:"POST",
        url: ctx + "/order/deliverAddrAction!delete.action",
        data:"deliveraddrId=" + id + "&authorizedToken=" + authorizedToken,
        success:function(result){
      	  if(result.data == 'delete'){
      		  window.location.reload();
  		  }
        },
        error : function() {
			alert('请重新登录后，再进行操作');
        }
      });
}

//删除地址
function deleteAddr(id) {
	confirm("确定删除？",doDeleteAddr,null,id);
};

function updateType(deliveraddrId,recevername,area,addr,postcode,phone,isdefault)
{
	$("#updateId").val(deliveraddrId);
	$("#area").val(area);
	$("#addr").val(addr);
	$("#postcode").val(postcode);
	$("#recevername").val(recevername);
	$("#phone").val(phone);
	if(isdefault=="1"){
    	$("#isdefault").attr("checked",'true');
    }else{
    	$("#isdefault").removeAttr("checked");     
    }
    $("#btn_update").css("display",""); 
    $("#btn_add").css("display","none");
    
    var EVENT_CHANGE = 'change.distpicker'
    var p_c_d = area.split(" ");
    $("#province").find("option[value='" + p_c_d[0] + "']").attr("selected", true).trigger(EVENT_CHANGE);
    $("#city").find("option[value='" + p_c_d[1] + "']").attr("selected", true).trigger(EVENT_CHANGE);
    $("#district").find("option[value='" + p_c_d[2] + "']").attr("selected", true);
}

function alterAddr(id) {
	
	var authorizedToken = $("#authorizedToken").val();
	$.ajax({
		type : "POST",
		url : ctx + "/order/deliverAddrAction!get.action",
		data:"deliveraddrId=" + id  + "&authorizedToken=" + authorizedToken,
		success : function(result) {
			if (result.data == 'get') {
				var jsonStr = JSON.parse(result.model);
				//$("#addrForm").putFormValue(jsonStr);
				putFormValue(jsonStr);
				$("#addrForm").attr("action",ctx + "/order/deliverAddrAction!update.action");
				$("#btn_add").attr("disabled",false); 
				$("#btn_add").css({'background': '#ff4001'});
			}
		}
	});
};

//改变
function changeDefaultAddr(id) {
	
	var authorizedToken = $("#authorizedToken").val();
	$.ajax({
		type : "POST",
		url : ctx + "/order/deliverAddrAction!changeDefaultAddr.action",
		data:"deliveraddrId=" + id + "&authorizedToken=" + authorizedToken,
		success : function(result) {
			if (result.data == 'change') {
				window.location.reload();
			}
		},
		error : function() {
			alert('服务器未响应，请稍后再重新操作.');
		}
	});
};


//页面载入的时候执行表单验证
$().ready(function() {
	'use strict';
	var authorizedToken = $("#authorizedToken").val();
	
	$("#btn_add").click(function(){
		$("#addrForm").attr("action", ctx +"/order/deliverAddrAction_add.action");
	});
	
	$("#btn_update").click(function(){
		$("#addrForm").attr("action", ctx +"/order/deliverAddrAction_update.action");
	});
	

    var $distpicker = $('#picker');
    
    $distpicker.distpicker({
      province: "---- 所在省 ----",
      city: "---- 所在市 ----",
      district: "---- 所在区 ----",
      autoSelect: false
    });
    
    $("#district").on("change",function(){
    	var addrArea = $("#province").val() +' ' + $("#city").val() + ' ' + $(this).val() + ' ';
    	$("#area").val(addrArea);
    });
    
	//IE兼容模式不支持JSON
	if(typeof JSON == 'undefined'){
        $('head').append($("<script type='text/javascript' src='"+ ctx + "/js/common/json2.js'>"));
	}
	
	$( "#addrForm" ).validate({ 
		//focusCleanup:true,
		// 采用指定的标签显示错误消息
		errorPlacement : function(error, element) {
			$(element).parent().children("em:eq(0)").html(error);
		},
		rules: { 
			// 地区
			district: { 
				required: true, 
			}, 
			// 地址 
			addr: { 
				isAllBlank : true,
				illegalChar : true,
				required: true, 
				maxlength: 30
			}, 
			// 邮编 
			postcode: {
				isZipCode: true  
			}, 
			// 收货人
			recevername: {
				isAllBlank : true,
				illegalChar : true,
				required: true,
				maxlength: 10
			}, 
			// 手机号
			phone: { 
				required: true,
				isMobile: true,
				maxlength: 11
			}
		}, 
		messages: { 
			// 地区
			district: { 
				required: "请您填写完整的地区信息", 
			}, 
			// 地址 
			addr: { 
				isAllBlank : "请您填写收货人详细地址",
				required: "请您填写收货人详细地址", 
				maxlength: 30
			}, 
			// 收货人
			recevername: { 
				required: "请填写收货人姓名", 
				maxlength: "请不要多于10个字符"
			},
			// 手机
			phone: { 
				required: "请您填写收货人手机号码", 
				isMobile: "手机号码格式不正确",
				maxlength: "手机号为11位"
			}
		}
	}); 
}); 


// 手机号码验证  
jQuery.validator.addMethod("isMobile", function (value, element) {  
    var length = value.length;
    var mobile = /(^13\d{9}$)|(^14)[5,7]\d{8}$|(^15[0,1,2,3,5,6,7,8,9]\d{8}$)|(^17)[6,7,8]\d{8}$|(^18\d{9}$)/g ; 
    return this.optional(element) || (length == 11 && mobile.test(value));  
}, "请正确填写您的手机号码");


//只能输入数字  
jQuery.validator.addMethod("isNum", function (value, element) {  
    var RegExp = /^\d+$/;  
    return RegExp.test(value);  
}, $.validator.format("只能为数字!"));


//邮政编码验证       
jQuery.validator.addMethod("isZipCode", function(value, element) {
	if(value != ''){
		var tel = /^[0-9]{6}$/;
		return this.optional(element) || (tel.test(value));
	}
	return true;
}, "请正确填写您的邮政编码");

// 汉字  
jQuery.validator.addMethod("chcharacter", function (value, element) {  
    var tel = /^[\u4e00-\u9fa5]+$/;  
    return this.optional(element) || (tel.test(value));  
}, "请输入中文");

//内容不能全为空格
jQuery.validator.addMethod("isAllBlank", function (value, element) {  
	value = $.trim(value); //value.replace(/(^\s+)|(\s+$)/g,"").replace(/\s/g,"");
    return this.optional(element) || (value != "");  
}, "不能全部为空格");


jQuery.validator.addMethod("illegalChar", function (value, element) {  
    return this.optional(element) || ( ! illegalChar(value) );  
}, "包含非法字符");


function illegalChar(value){
	var reg = /([",&,'])/g;
	return reg.test(value);
}


function  putFormValue(jsonStr){
	
	$.each(jsonStr, function(name, val) {
		    if(val != ""){
		        var htmlType = $("[name='"+name+"']").attr("type");
		        if(htmlType == "text" || htmlType == "textarea" || htmlType == "select-one" || htmlType == "hidden" || htmlType == "button"){
		            $("[name='"+name+"']").val(val);
		        }else if(htmlType == "radio"){
		            $("input[type=radio][name='"+name+"'][value='"+val+"']").attr("checked",true);
		        }else if(htmlType == "checkbox"){
		        	//单值使用
		        	var chk = $("input[type=checkbox][name='"+name+"']");
		        	if(val == "1"){
		        		chk.prop("checked",true);
		        	}else{
		        		chk.prop("checked",false);
		        	}
		        }
		    }
	});
}

function check(){
	$("#error").text("");
	if($("#area").val() == '' || $("#recevername").val() == '' 
		|| $("#addr").val() == '' || $("#phone").val() == '' 
		|| illegalChar($("#recevername").val()) || illegalChar($("#addr").val())){
		return false;
	}
	if($("#btn_add").css("display") == "none"){
		return true;
	}
	
	var flag = false;
	$.ajax({
		async: false,
        type:"POST",
        url: $("#context").val() + "/order/deliverAddrAction!isExits.action",
        data:$("#addrForm").serialize(),
        success:function(result){
      	  if(result.data == 'no'){
      		  flag = true;
  		  } else if(result.data == 'yes'){
  			  flag = false;
  		  }
        },
        error : function(e) {
        	console.log(e);
        }
      });
	
	$("#error").val("");
	if(!flag){
		$("#error").text("该地址已存在");
	} 
	return flag;
}


