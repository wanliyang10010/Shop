function jumpPage(pageNo) {
	$("#pageNo").val(pageNo);
	$("#form1").submit();
}

function changePageSize(pageSize) {
	$("#pageSize").val(pageSize);
	$("#pageNo").val(1);
	$("#form1").submit();
}

function goPage(totalPages) {
	var pageNo;
	pageNo = $("#navNum").val();
	if(pageNo < 1){
		pageNo = 1;
	} else if(pageNo > totalPages) {
		pageNo = totalPages;
	}
	$("#pageNo").val(pageNo);
	$("#form1").submit();
}

function search() {
	$("#pageNo").val(1);
	$("#form1").submit();
}
