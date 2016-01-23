function doDeleteFavGood(f_id){
	
	var authorizedToken = $("#authorizedToken").val();
	$("#pageNo").val(1);
	$.ajax({
        type:"POST",
        url:"${ctx}/order/favouriteAction!delete.action",
        data:"favouriteId="+f_id + "&authorizedToken=" + authorizedToken,
        success:function(resulte){       	
        	top.window.location = ctx + "/order/favouriteAction_list.action";
        }
      });
}

//删除收藏商品
 function deleteFavourite(f_id){
	 confirm("确定删除？",doDeleteFavGood,null,f_id);
}
	
//-----------------------------分---割---一---下-----------------------------------

 function doDeleteFavShop(s_id){
	 
	 var authorizedToken = $("#authorizedToken").val();
     $.ajax({
       type:"POST",
       url:"${ctx}/order/favouriteShopAction!delete.action",
       data:"favouriteshopId="+s_id + "&authorizedToken=" + authorizedToken,
       success:function(resulte){
    	   top.window.location = ctx + "/order/favouriteShopAction!list.action";
       }
     });
 }
 
 //删除收藏的店铺
 function deleteFavouriteShop(s_id){
  confirm("确定删除？",doDeleteFavShop,null,s_id);
}