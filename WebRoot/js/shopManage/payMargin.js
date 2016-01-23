function paymoney() {
	    $("#btn_submit").attr('disabled',true);
	    document.userform.action = ctx+"/shopAction_updateAndSave.action";
		document.userform.submit();	 
	}