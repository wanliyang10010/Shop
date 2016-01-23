//var ctx="/"+window.location.pathname.split("/")[1];

function prolongSeller() {
	document.getElementById("tbDetail").style.display = "";		
	}
	
	function ok() {
		   var da=document.getElementById("dayapply");
	       if (da.value == ""||da.value == "  ") {
			alert("延长天数不能为空！");
			return false;
		   }
	       if (da.value == "00"||da.value == "0" ||da.value == "0 ") {
				alert("延长天数必须为大于0的数字!");				
				return false;
			   }
	     var re = /^[0-9]*[1-9][0-9]*$/ ; 
	  	 if(!re.test(da.value))
	  	 {
	  		 alert("延长天数必须为大于0的数字，谢谢!");
	  		 return false;
	  	 }  
		alert("已延长时间，谢谢使用！");
		document.getElementById("tbDetail").style.display = "none";			
		return ;
	}
	function cancel() {
         document.getElementById("tbDetail").style.display = "none";
	}