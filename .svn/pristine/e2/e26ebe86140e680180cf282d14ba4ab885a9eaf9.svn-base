

$(document).ready(function(){
	
	$('.spinner').spinner();
	
	$('#amount').bind('input propertychange', function() {
		$('#num').val($(this).val());
	});
	
});

function openDetial(id){
	window.open(ctx+"/viewProductAction_goodsDetial.do?goodsid="+id+"")
}

function opendetial(id,sid)
{
    window.open(ctx+"/viewProductAction_product.do?gid="+id+"&sid="+sid+"");
}
function openDetialOrEva(tag){
	document.form1.viewtag.value=tag;
	document.form1.action= ctx+"/viewProductAction_detailorEva.do"; 
 	document.form1.submit(); 
}
function openEva(id){
	 window.open(ctx+"/viewProductAction_evalution.do?gid="+id+"")
}

function openDetialPicture(id){
 	document.form1.action= ctx+"/viewProductAction_product.do"; 
 	document.form1.submit(); 
}

function openEvaPicture(id){
	window.open(ctx+"/viewProductAction_evalution.do?gid="+id+"")
}
 
function shopdetial(id){
	window.location.href = ctx + "/viewProductAction_shop.do?shopid=" + id;
}


 