//var ctx="/"+window.location.pathname.split("/")[1];

//判断店铺名称
	function checkshopname() {
		var shopname = $.trim($("#shopname").val());
		if(shopname.length<=0){ 
			alert("店铺名称不能为空！");
			return false;
		}
		else {	  
			  $.ajax({
					 type:"POST",
					 url:ctx+"/shopApplyAction_checkshopName.action",	
					 data : "shopname=" + shopname,
					// async:false,
					 success:function(result){				 
						 if(result.data == "yes"){
								document.getElementById("msgshopname").value = "该店铺名可以使用。注意：店铺名申请后不可更改！";   //FF									 					 
						  }
					  else if(result.data=="no"){
								document.getElementById("msgshopname").value = "对不起，该店铺名已被注册！";   //FF						       					 
						  }					 					 
					 },
					 error:function(){
					 alert("系统错误，请联系管理员！");
					 }
					 });	
		}
	}
	//判断店铺具体位置
	function checkshopaddress() {
		if($("#province").val()==""||$("#city").val()==""){ 
			/*||$("#district").val()==""*/
			alert("请选择完整的店铺所在区域！");
			return false;
		}
		
		if($.trim($("#shopaddress").val()).length<=0){ 
			alert("店铺具体位置不能为空！");
			return false;
		}
	}
	//判断店铺所在地邮编
	function checkshoppostnumber() {
		var shoppostnumber = $("#shoppostnumber").val();
		if($.trim($("#shoppostnumber").val()).length<=0){ 
			alert("店铺所在地邮编不能为空！");
			return false;
		}else if (shoppostnumber.length != 6) {
			alert("店铺所在地邮编为6位数字");
			return false;
		}else{			 
		        var re= /^[0-9]{6}$/;
		        if(!re.test(shoppostnumber))		         
		        {
		        	alert("店铺所在地邮编不正确");
					return false;
		        }
		}
	}
	//判断手机号码
	function checkshopphone() {
		var shopphone = $("#shopphone").val();
		if($.trim($("#shopphone").val()).length<=0){ 
			alert("手机号码不能为空！");
			return false;
		}else if (shopphone.length != 11) {
			alert("手机号码为11位数字");
			return false;
		} else {
			var myreg = /^1(3\d|5[0123456789]|8[0123456789]|4[7]|7[7])\d{8}$/;
			if (!myreg.test(shopphone)) {
				alert("手机号码不正确");
				return false;
			}
		}
	}
	//判断身份证号
	function checkidentifynumber() {
		var identifynumber = $("#identifynumber").val();
		if($.trim($("#identifynumber").val()).length<=0){ 
			alert("身份证号不能为空！");
			return false;
		}else {
			//下面是判断身份证号码格式的代码  	
			//15位和18位身份证号码的正则表达式
			var regidnumber = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
			//如果通过该验证，说明身份证格式正确，但准确性还需计算
			if (regidnumber.test(identifynumber)) {
				if (identifynumber.length == 18) {
					var idnumberWi = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3,
							7, 9, 10, 5, 8, 4, 2); //将前17位加权因子保存在数组里
					var idnumberY = new Array(1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2); //这是除以11后，可能产生的11位余数、验证码，也保存成数组
					var idnumberWiSum = 0; //用来保存前17位各自乖以加权因子后的总和
					for ( var i = 0; i < 17; i++) {
						idnumberWiSum += identifynumber.substring(i, i + 1)
								* idnumberWi[i];
					}

					var idnumberMod = idnumberWiSum % 11;//计算出校验码所在数组的位置
					var idnumberLast = identifynumber.substring(17);//得到最后一位身份证号码

					//如果等于2，则说明校验码是10，身份证号码最后一位应该是X
					if (idnumberMod == 2) {
						if (idnumberLast == "X" || idnumberLast == "x") {
						} else {
							alert("身份证号错误");
							return false;
						}
					} else {
						//用计算出的验证码与最后一位身份证号码匹配，如果一致，说明通过，否则是无效的身份证号码
						if (idnumberLast == idnumberY[idnumberMod]) {
						} else {
							alert("身份证号错误");
							return false;
						}
					}
				}
			} else {
				alert("身份证号错误");
				return false;
			}
		}
	}

	function addshop() {
		if(checkIllegalChar()){
			alert("文本框中不能包含下列任何字符： \" \' &amp;");
			return false;
		}	
		var shopname = $("#shopname").val();
		if($.trim($("#shopname").val()).length<=0){ 
			alert("店铺名称不能为空！");
			return false;
		}
		var msgshopname = $("#msgshopname").val();
		if (msgshopname == "对不起，该店铺名已被注册！") {
			alert("店铺名称已被使用，请更换");
			return false;
		}
		if (checkshopaddress() == false) {
			return false;
		} else if (checkshoppostnumber() == false) {
			return false;
		} else if (checkshopphone() == false) {
			return false;
		} else if (checkidentifynumber() == false) {
			return false;
		} else {	
			 var userpicture=document.getElementById("userpicture");
			 var identifypicture=document.getElementById("identifypicture");
			 var identifypicture2=document.getElementById("identifypicture2");
			  if((document.getElementById("userpicture").value!="" )&& 
					  (document.getElementById("identifypicture").value!="") &&
					  (document.getElementById("identifypicture2").value!="") )
			    {
			    	 if(checkImgType(userpicture) && checkImgType(identifypicture) && checkImgType(identifypicture2))
			 		{			    		
			 		}
			    	 else
			    		 return false;
			    }
			    else if(document.getElementById("userpicture").value=="" )
			    {
			        alert("请上传半身照！");
			        return false;
			    }
			    else if(document.getElementById("identifypicture").value=="" )
			    {
			        alert("请上传身份证正面照片！");
			        return false;
			    }
			    else if(document.getElementById("identifypicture2").value=="" )
			    {
			        alert("请上传身份证反面照片！");
			        return false;
			    }
			  
			var addrArea = $("#province").val() +' ' + $("#city").val() + ' ' + $("#district").val();
		    
			$("#btn_submit").attr('disabled',true);
			$("#btn_cancel").attr('disabled',true);
			document.userform.method = "post";
			//document.userform.enctype = "multipart/form-data";
			document.userform.action = ctx+"/shopApplyAction_save.action?addrArea="+addrArea;
			document.userform.submit();
		}
	}
	
	function checkImgType(ths) {
		var name=ths.value.substr(ths.value.replace("/","\\").lastIndexOf('\\')+1,ths.value.length-1);
		if(parseInt(name.length)<=65)
		{
			if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(ths.value)) {
				alert("图片类型必须是.gif,jpeg,jpg,png中的一种");
				return false;
			}
		}
		else
		{
			alert("文件名超过最大长度60，请修改后再上传！");
			return false;
		}
		return true;
	}
	
	function cancel() {
		window.location.href = ctx+"/shopManage/applyShop.jsp";
	}

	$(function() {
		$("#userpicture").change(
				function(){
					imagechange('userpicture','viewuserpicture','tr_userpicture','viewuserpictureDiv');						
				});
		$("#identifypicture").change(
				function() {
					imagechange('identifypicture','viewidentifypicture','tr_identifypicture','viewidentifypictureDiv');		
				});
		$("#identifypicture2").change(
				function() {
					imagechange('identifypicture2','viewidentifypicture2','tr_identifypicture2','viewidentifypicture2Div');		
				});
	});
	
	function imagechange(picture,view,tr,viewdiv) {	
		var $file = $("#"+picture);
		var fileObj = $file[0];
		var windowURL = window.URL || window.webkitURL;
		var dataURL;
		var $img = $("#"+view);

		if (fileObj && fileObj.files && fileObj.files[0]) {
			dataURL = windowURL.createObjectURL(fileObj.files[0]);
			//alert("dataURL"+dataURL);
			//允许上传的图片格式  
			var newPreview = document.getElementById(picture).value;
			var regext = /\.jpg$|\.gif$|\.jpeg$|\.png$|\.bmp$/gi;
			if (!regext.test(newPreview)) {
				alert("对不起，系统仅支持标准格式的照片，请您调整格式后重新上传！");
			 $(fileObj).after($(fileObj).clone($(fileObj)));
		     $(fileObj).remove();
		     $("#"+tr).hide();
		     return false;
			}														         
			$img.attr("src", dataURL);
			$("#"+tr).show();
		} else {
			dataURL = $file.val();
			if(dataURL==null||dataURL==""){
				$("#"+tr).hide();
				return false;
			}
			var regext = /\.jpg$|\.gif$|\.jpeg$|\.png$|\.bmp$/gi;
			if (!regext.test(dataURL)) {
				alert("对不起，系统仅支持标准格式的照片，请您调整格式后重新上传！");
			$(fileObj).after($(fileObj).clone($(fileObj)));	
			 $file.remove();
		     $("#"+tr).hide();
		     return false;
			}		
			var imgObj = document.getElementById(viewdiv);
			imgObj.innerHTML = "";
			
			// 两个坑:
			// 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
			// 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
			imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
			imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;
			$("#"+tr).show();
		}
	}
	
	
	
	
	
	
	/*	$(function() {
		$("#identifypicture").change(
						function() {
							var $file = $(this);
							var fileObj = $file[0];
							var windowURL = window.URL || window.webkitURL;
							var dataURL;
							var $img = $("#viewidentifypicture");
							if (fileObj && fileObj.files && fileObj.files[0]) {
								dataURL = windowURL.createObjectURL(fileObj.files[0]);

								//允许上传的图片格式  
								var newPreview = document.getElementById("identifypicture").value;
								var regext = /\.jpg$|\.gif$|\.jpeg$|\.png$|\.bmp$/gi;

								if (!regext.test(newPreview)) {
									alert("对不起，系统仅支持标准格式的照片，请您调整格式后重新上传！");
									 $(fileObj).after($(fileObj).clone($(fileObj)));
								       $(fileObj).remove();
								       $("#tr_identifypicture").hide();
									return false;
								}																															
								$img.attr("src", dataURL);
								$("#tr_identifypicture").show();
							} else {
								$("#tr_identifypicture").hide();						
							}
								dataURL = $file.val();
								var imgObj = document
										.getElementById("viewidentifypicture");
								// 两个坑:
								// 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
								// 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
								imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
								imgObj.filters
										.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;
							}
						});
	});
	
		$(function() {
		$("#identifypicture2").change(
						function() {
							var $file = $(this);
							var fileObj = $file[0];
							var windowURL = window.URL || window.webkitURL;
							var dataURL;
							var $img = $("#viewidentifypicture2");
							if (fileObj && fileObj.files && fileObj.files[0]) {
								dataURL = windowURL.createObjectURL(fileObj.files[0]);

								//允许上传的图片格式  
								var newPreview = document.getElementById("identifypicture2").value;
								var regext = /\.jpg$|\.gif$|\.jpeg$|\.png$|\.bmp$/gi;

								if (!regext.test(newPreview)) {
									alert("对不起，系统仅支持标准格式的照片，请您调整格式后重新上传！");
									 $(fileObj).after($(fileObj).clone($(fileObj)));
								      $(fileObj).remove();
								      $("#tr_identifypicture2").hide();
									return false;
								}														
								
								$img.attr("src", dataURL);
								$("#tr_identifypicture2").show();
							
							} else {
								$("#tr_identifypicture2").hide();
							}
								dataURL = $file.val();
								var imgObj = document
										.getElementById("viewidentifypicture2");
								// 两个坑:
								// 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
								// 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
								imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
								imgObj.filters
										.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;
							}
						});
	});*/
		
	$(function() {
		$("#productcategory").change(
						function() {
						 var productcategory = $("productcategory");
  					for (var i = 0; i < productcategory.length; i++) {
  					productcategory[i].options[0].selected = true; 
 					 }  					
		});
	});