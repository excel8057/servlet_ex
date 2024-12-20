$.ajax({
	url : "/servletExample/subjectNumber", // 요청 url
	method:"post",                         // 전송방식(get/post)
	dataType:"text"                        // 서버로부터 응답받을 문서 타입(text/json/xml)   
}).done(function (data) {
	$("#subjectNumber").val(data);
}).fail(function(xhr, textStatus) {
	alert(textStatus + " 발생.\n상태: " + xhr.status);
});


/*$("#insertBtn").on("click", () => {
	if (!chkData("#subjectName","학과명을 "))	return;
	else{
		$("#subject").attr({
			"method":"post", 
			"action":"/servletExample/insert"
		});
		$("#subject").submit();
	}
});*/


$(document).on("click", "#insertBtn", ()=>{
	if (!chkData("#subjectName","학과명을 "))	return;
	else{
		$("#subject").attr({
			"method":"post", 
			"action":"/servletExample/insert"
		});
		$("#subject").submit();
	}
});

$("#resetBtn").on("click", ()=>{
	$("#subjectName").val("");
});