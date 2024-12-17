document.addEventListener("DOMContentLoaded", function() {
    const form = document.querySelector("form");

    form.addEventListener("submit", function(event) {
        const name = document.querySelector('input[name="name"]').value;
        const address = document.querySelector('input[name="address"]').value;

        if (!name || !address) {
            alert("이름과 주소를 모두 입력해주세요.");
            event.preventDefault(); // 폼 전송 방지
        }
		$("#dataForm").attr({
			"method" : "post",
			"action" : "/servletExample/getData"
		});
		$("#dataForm").submit();
    });
});
