$(function() {
    $("#loginBtn").on("click", () => {
        if(!chkData("#memberId", "아이디를")) return;
        else if(!chkData("#memberPasswd", "비밀번호를")) return;
        else {
	        $("#login").attr({
	        	 "method":"post",
	        	 "action":"/servletExample/login"
	        });
	        $("#login").submit();
        }
	});
});