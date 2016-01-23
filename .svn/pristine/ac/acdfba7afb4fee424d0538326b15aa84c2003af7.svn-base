

//添加商品收藏
function addFavourite(g_id) {
	
	var shopowner = $("#shopowner").val();//商家Id
	var buyer = $("#buyer").val();//买家Id
	if(shopowner == buyer){
		alert("不能收藏自己出售的商品!");
		return;
	}

	//问号前部分
	var path = window.location.pathname;
	//问号及其后部分
	var param = window.location.search;
	//商品地址
	var goodUrl = path + param; 
	
	$.ajax({
		type : "POST",
		url : ctx + "/order/favouriteAction!addFavourite.action",
		data : "good.goodsid=" + g_id + "&productUrl=" + goodUrl,
		success : function(result,gogogo) {
			if (result.data == 'save') {
				alert('添加收藏成功!');
			} else if (result.data == 'exits') {
				alert('已经收藏过该商品!');
			}
		},
		error : function() {
			//alert('请先登录再进行收藏操作');
		}
	});
}

//添加店铺收藏
function addFavouriteShop(s_id) {
	
	var shopowner = $("#shopowner").val();//商家Id
	var buyer = $("#buyer").val();//买家Id
	if(shopowner == buyer){
		alert("不能收藏自己的店铺!");
		return;
	}
	
	$.ajax({
		type : "POST",
		url : ctx + "/order/favouriteShopAction!addFavourite.action",
		data : "shop.shopId=" + s_id,
		success : function(result) {
			if (result.data == 'save') {
				alert('收藏店铺成功!');
			} else if (result.data == 'exits') {
				alert('已经收藏过该店铺!');
			}
		},
		error : function() {
			//alert('请先登录再进行收藏操作');
		}
	});
}

	
