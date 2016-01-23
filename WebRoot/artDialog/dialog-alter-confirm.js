function alert(message,onFocusName){
	/*if(functionName ==undefined){
		functionName = function(){return true;};
	}*/
	if(onFocusName ==undefined){
		onFocusName = 'body';
	}
	
	var txt=  message;
	var d = dialog({
	    title: '提示',
	    content: message,
	    okValue: '确定',
	    cancel: false,//不显示关闭
	    ok: function(){
	    	return true;
	    },
	    onclose: function () {
	        //alert('对话框已经关闭');
	    	$(onFocusName).focus();
	    }
	}).width(360).height(90);
	d.showModal();
	//return true;
}	

function confirm(message,okFunctionName,cancelFunctionName,parameter,width){
	if(okFunctionName ==undefined){
		okFunctionName = function(){return true;};
	}
	if(cancelFunctionName ==undefined){
		cancelFunctionName = function(){return true;};
	}
	var txt=  message;
	var d = dialog({
	    title: '提示',
	    content: message,
	    cancelValue: '取消',
    	cancel: function(){
    		cancelFunctionName();
    		return true;
    	},
    	okValue: '确定',
	    ok: function(){
	    	okFunctionName(parameter);
	    	return true;
	    }
	}).width(360).height(90);
	d.showModal();
	//return true;
}


function attach(message,elementId){
	var d = dialog({
		id: elementId,
	    align: 'right',
	    content: message,
	    quickClose: true
	});
	d.show(document.getElementById(elementId));
	setTimeout(function () {
	    d.close().remove();
	}, 2000);
}