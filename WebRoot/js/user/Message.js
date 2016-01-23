
String.prototype.trim=function(){return this.replace(/(^\s*)|(\s*$)/g,"");}
 function openmessage(id,url,type,value){
	 var authorizedToken=document.getElementById("authorizedToken").value;
    	  $.ajax({
  			type : "POST",
  			url : ctx+"/messageAction_OpenMessage.action",
  			data : "messageId=" + id+"&authorizedToken=" + authorizedToken,
  			success : function(result) {
  				if (result.data == 'right') {
  					//window.open(ctx+"/"+url+"?"+type+"="+value);
  					window.location.href=ctx+"/"+url+"?"+type+"="+value;
  					//window.location.reload(true);
  				} 
  			},
  			error : function() {
  				alert('系统忙，请稍后重试');
  			}
  		});
  }

function update(id) {
	var authorizedToken=document.getElementById("authorizedToken").value;
	  $.ajax({
			type : "POST",
			url : ctx+"/messageAction_OpenMessage.action",
			data : "messageId=" + id+"&authorizedToken=" + authorizedToken,
			success : function(result) {
				if (result.data == 'right') {
					window.location.reload(true);
				} 
			},
			error : function() {
				alert('系统忙，请稍后重试');
			}
		});
	}

function updateA(id) {
	   var authorizedToken=document.getElementById("authorizedToken").value;
	   $.ajax({
			type : "POST",
			url : ctx+"/messageAction_updateAll.action",
			data : "authorizedToken=" + authorizedToken,
			success : function(result) {
				if (result.data == 'right') {
					 document.form1.method="post";
	  	  			 document.form1.action= ctx+"/messageAction_getMessage.action";
	  				 document.form1.submit(); 
				} 
			},
			error : function() {
				alert('系统忙，请稍后重试');
			}
		});
	}