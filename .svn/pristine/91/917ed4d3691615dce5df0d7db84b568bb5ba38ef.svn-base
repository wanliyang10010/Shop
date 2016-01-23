$(document).ready(function(){
	/* B 公共函数 */
	//1、判断select的option是否没有选择
	function checkSelectId(){
		/* 判断是select的option是否选择*/
		if($.trim($("#selectId  option:selected").val())=="-1"){
			window.alert("请选择所要配置资源的权限！");
			return false;
		}else{
			 var authorityId = $.trim($("#selectId  option:selected").val());
			var url = "authorityMapResource_!leftList.action?authorityId="+authorityId;
			window.location.href=url;
		    return true;
		    /* var authorityId = $.trim($("#selectId  option:selected").val());
			$.ajax({
				 type:"POST",  
		         url:"authorityMapResource_!leftList.action",
		         //dataType:"json",      
		         //contentType:"application/json",               
		         data:"authorityId="+authorityId,
		         async: true, 
		         success:function(result){
		         	/* var resultobj = $.parsejson(result);
		         	ajaxobj=eval("("+data+")");  */ 
		         	/* var returnIsExisted = result.responseJson.isExsited;
		            if(returnIsExisted == "true")  
		            {  
		                alert("账号已存在！");
		                $("#account").focus();
		                return true;  
		            }else{
		            	return true;  
			        }  

			        
			        var leftList = result.resourcesList_L;
			        var rightList = result.resourcesList_R;
			        $("#myLeft").empty();
			        for(var i=0;)
			        $("#myRight").;
				    return true;
				}
			}); */
		    
		}
	}
	//2、防止重复提交函数
	function doSubmit(){
		if(formSubmitFlag == false){
			formSubmitFlag = true;//表单提交后，让标识符设置为true
			return true;//让表单正常提交
		}else{
			window.alert("该表单已经提交过！");
			return false;//表单已经提交过，不让该表单再次提交；
		}
	}
	/* E 公共函数 */
	
	/*判断select的option*/
	$("#selectId").change(checkSelectId);
	var formSubmitFlag = false;//表单是否提交标识符，默认为false,即没有提交
	
	/* 提交表单判断 */
	$("#mysubmit").bind("click",function(){
		//1、判断select的option
		var resultSelectId = checkSelectId();
		if(!resultSelectId){
			return false;
		}
		//2、判断表单是否已提交
		var resultDoSubmit = doSubmit();
		if(!resultDoSubmit){
			//禁止表单提交
			return false;
		}
		
		
		return true;
	});
	
	
	//返回主页
	$("#fanhuibutton").bind("click",function(){
		$("#fanhuiform").attr("action","jumpToIndexAdmin.action");
		$("#fanhuiform").submit();
	});
	
});



function myself(){
	 var right=document.forms[0].resourceName_L;
	 for(i=1; i <right.length; i++)
	 right[i].selected = true;
}


