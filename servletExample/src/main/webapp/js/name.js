$(function(){
	$("#btn").on("click", ()=>{
		const namePatten = /^[가-힣]+$/g; 
		if($("#name").val().replace(/\s/g,"")==""){
			$("#name").val("");
			$("#name").attr("placeholder", "이름을 입력해 주세요");
			return;
		}
		if ($("#name").val().search(namePatten)<0) {
			$("#name").val("");
			$("#name").attr("placeholder", "한글이름으로만 작성해 주세요");
			return;
		 }
		$("#frm").attr({
			"method":"post",
			"action":"/servletExample/configTest"
		});
		$("#frm").submit();
	});
});