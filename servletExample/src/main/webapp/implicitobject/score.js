$(document).ready(function() {
	$("#sendBtn").click(function() {
		var score = $("#score").val();

		// 점수 유효성 검사
		if (score < 0 || score > 100 || isNaN(score)) {
			alert("0에서 100 사이의 숫자를 입력해주세요.");
			return;
		}

		// 서버로 점수 보내기 (AJAX)
		$.ajax({
			url: "score.jsp", // 점수를 받아 처리할 JSP 파일
			type: "GET",
			data: { score: score },
			success: function(response) {
				$("#result").html(response); // 서버에서 반환된 결과 출력
			},
			error: function() {
				alert("서버 요청에 실패했습니다.");
			}
		});
	});
});