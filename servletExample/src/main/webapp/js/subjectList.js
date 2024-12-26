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

$(".updateBtn").on("click", function(){
	$(".upResetBtn").detach();
	
	let no = $(this).parents("tr").attr("data-no");
	console.log(no);
	$("#no").val(no);
	
	let subjectNumber = $(this).parents("tr").children().eq(1).html();
	$("#subjectNumber").val(subjectNumber);
	
	let subjectName = $(this).parents("tr").children().eq(2).html();
	console.log(subjectName);
	$("#subjectName").val(subjectName);
	
	// "입력완료"" 버튼을 "수정완료"" 버튼으로 변경
	$("#insertBtn").html("수정완료");

	// "수정취소" 버튼 추가
	let upReset = $("<button>");
	upReset.attr("type","button");
	upReset.addClass("upResetBtn btn btn-success ms-1");
	upReset.html("수정취소");
	$("#insertBtn").after(upReset);
});

$(document).on("click", "#insertBtn", ()=>{
	if (!chkData("#subjectName","학과명을 "))	return;
	else{
		/*$("#subject").attr({
			"method":"post", 
			"action":"/servletExample/insert"
		});*/
		
		$("#subject").attr("method", "post");

		if($("#no").val()=="0"){
			$("#subject").attr("action", "/servletExample/insert");
		} else {
			$("#subject").attr("action", "/servletExample/update");
		}
		
		//console.log($("#no").val());
		$("#subject").submit();
	}
});

const autoSubjectNumber = () => {
	// 자동으로 학번 구하기
	$.ajax({
		url : "/servletExample/subjectNumber", // 요청 url
		method:"post",                         // 전송방식(get/post)
		dataType:"text"                        // 서버로부터 응답받을 문서 타입(text/json/xml)   
	}).done(function (data) {
		//console.log(data);
		$("#subjectNumber").val(data);
	}).fail(function(xhr, textStatus) {
		alert(textStatus + " 발생.\n상태: " + xhr.status);
	});	
}
autoSubjectNumber();

$(document).on("click", ".upResetBtn", ()=>{
	$(".upResetBtn").detach();
	
	$("#insertBtn").html("입력완료");
	$("#subjectName").val("");
	$("#no").val(0);
	
	autoSubjectNumber();
});


// "삭제" 버튼 제어 - 1
/*$(".deleteBtn").on("click", function(){
	if(confirm("학과 정보 삭제하시겠습니까?")){
		//let no = $(this).parents("tr").attr("data-no");  // 삭제 시 기준이 no 컬럼으로 되어 있다면
		//location.href="/servletExample/delete?no="+no; 
		
		let subjectNumber = $(this).parents("tr").children().eq(1).html();  // 삭제 시 기준이 s_num 컬럼으로 되어 있다면
		location.href="/servletExample/delete?subjectNumber="+subjectNumber;
	}
});*/

// "삭제" 버튼 제어 - 2
$(".deleteBtn").on("click", function(){
	let subjectNumber = $(this).parents("tr").find("td:eq(1)").html();
	//let no = $(this).parents("tr").data("no");
	
	$.ajax({
		url:"/servletExample/studentCheck",  // 요청 url
		method:"post",                       // 전송방식(get/post)
		data:{                               // 요청 url에 전달할 값(파라미터). subjectNumber=01
			"subjectNumber":subjectNumber  
		},
		dataType:"text"                 // 서버로부터 응답받을 문서 타입(text/json/xml)   
	}).done(function (data) {
		console.log(subjectNumber + " / " + data);
		if(data > 0){
			alert("소속된 학생이 존재함으로 학과데이터를 삭제할 수 없습니다.");
			return;
		} else{
			if(confirm("삭제하시겠습니까?")){
				location.href="/servletExample/delete?subjectNumber="+subjectNumber;
			}
		}
	}).fail(function(xhr, textStatus) {
		alert(textStatus + " 발생.\n상태: " + xhr.status);
	});
	
}); 

$("#searchBtn").on("click", ()=>{
	let subjectName = $("#name").val();
		if(!chkData("#name","학과명을 ")) return;
		else{
			$("#search").attr({
				"method":"get",
				"action":"/servletExample/list?subjectName="+subjectName
			});
			$("#search").submit();
		}
	});

	$("#searchAllBtn").on("click", ()=>{
		location.href = "/servletExample/list";
	});
