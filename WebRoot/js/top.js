ddsmoothmenu.init({
  mainmenuid: "top_nav", //menu DIV id
  orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
  classname: 'ddsmoothmenu', //class added to menu's outer DIV
  contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
});

function listGoodsTop() {
  document.top.action = ctx + "/viewProductAction_listGoods.do";
  document.top.submit();
}


function shopchange(id) {
  $.ajax({
    type: "POST",
    url: ctx + "/userinfoAction_shopChange.action",
    data: "shopId=" + id,
    success: function(result) {
      if (result.data == 'right') {
        alert("切换成功！");
        window.location.reload(true);
      } else if (result.data == 'wrong') {
        alert("验证码输入有误，请查看邮箱确认");
        return;
      }
    },
    error: function() {
      alert('系统忙，请稍后重试');
    }
  });
}



function myBrowser() {
  var userAgent = navigator.userAgent;
  var isOpera = userAgent.indexOf("Opera") > -1;
  var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera;

  if (isIE) {
    var IE5 = IE55 = IE6 = IE7 = IE8 = false;
    var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
    reIE.test(userAgent);
    var fIEVersion = parseFloat(RegExp["$1"]);

    IE55 = fIEVersion == 5.5;
    IE6 = fIEVersion == 6.0;
    IE7 = fIEVersion == 7.0;
    IE8 = fIEVersion == 8.0;

    if (IE55) {
      return "IE55";
    }
    if (IE6) {
      return "IE6";
    }
    if (IE7) {
      return "IE7";
    }
    if (IE8) {
      return "IE8";
    }
  }
  return "notIE";
}

function getUserMessage() {
  $.ajax({
    type: "POST",
    url: ctx + "/messageAction_getMessageCount.action",
    data: "id=1",
    success: function(result) {
      if (result.data == 'wrong') {
        window.location.href = ctx + "/frontHome/accessDenied.jsp";
      }
    }
  });
}

function getCartItemCount() {
	
	  $.ajax({
	    type: "POST",
	    url: ctx + "/cartAction_getItemCount.action",
	    success: function(result) {
	      var content = $("#top_item_count").html();
	      var text = "(" + result.count + ")";
	      if (content != text) {
	        $("#top_item_count").html(text);
	      }
	      //console.log("itemcount : " + result.count);
	    },
	    error: function(e) {
	      console.log(e);
	    }
	  });
	}

function checkIllegalChar() {
  var flag = false;
  $("input[type='text'],textarea").each(function(index, item) {
    var reg = /(["&'])/g;
    if (reg.test($(this).val())) {
      $(this).css("border-color", "red");
      flag = true;
    } else {
      $(this).css("border-color", "");
    }
  });
  return flag;
}


function divclose() {
	document.getElementById("ie-check").style.display="none";
}

$(function(){
	var ie_version = myBrowser();
	if((ie_version === "IE55") || (ie_version === "IE6")||(ie_version === "IE7")){
  		$("#ie-check").show();
    } else {
    	$("#ie-check").hide();
    }
});

