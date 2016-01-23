function jumpPage(pageNo) {
	$("#pageNo").val(pageNo);
	$("#userformmarginDetail").submit();
}

function changePageSize(pageSize) {
	$("#pageSize").val(pageSize);
	$("#pageNo").val(1);
	$("#userformmarginDetail").submit();
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
	$("#userformmarginDetail").submit();
}

function search() {
	$("#pageNo").val(1);
	$("#userformmarginDetail").submit();
}
