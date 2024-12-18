			$("#btnCalc").on("click",function(){
				const numberPattern = /^\d+$/g;
					
				if($("#num1").val().replace(/\s/g,"")==""){
					alert("숫자를 입력해 주세요");
					$("#num1").val("");
					$("#num1").focus();
					return;
				}else{
					if($("#num1").val().search(numberPattern) < 0){
						alert("문자를 입력할 수 없습니다.");
						$("#num1").val("");
						$("#num1").focus();
						return;
					}
				}						
					
				if($("#num2").val().replace(/\s/g,"")==""){
					alert("숫자를 입력해 주세요");
					$("#num2").val("");
					$("#num2").focus();
					return;
				}else{
					if($("#num2").val().search(numberPattern) < 0){
						alert("문자를 입력할 수 없습니다.");
						$("#num2").val("");
						$("#num2").focus();
						return;
					}
				}
					
				/*$("#frm").attr({
					"method":"post",
					"action":"/servletExample/calcServlet"
				});
				
				$("#frm").submit();*/
				
				// ajax로 서버 요청 코드 작성
				// data 속성은 요청 url에 전달할 값을 설정.
				// 폼전체 데이터 전송
				// data : $("#frm").serialize(), 
				// 함수를 사용하지 않을 경우
				// data : "num1="+$("#num1").val()+"&operator="+$("#operator").val()+"&num2="+$("#num2").val(), 
				// data : "num1=1&operator=+&num2=3" 
				// 서버측에 전달 (입력양식의 name으로 입력한 값이 전달된다 name=value)

				$.ajax({
					url:"/servletExample/calcServlet2", // 요청 url
					method:"post",                      // 전송방식(get/post)
					data:{
						"num1":$("#num1").val(),
						"operator":$("#operator").val(),
						"num2":$("#num2").val()
					},
					//data : $("#frm").serialize(),  // 서버에 전달한 파라미터(serialize():폼전체 데이터 전송하는 메서드)
					dataType:"text"                // 서버로부터 응답받을 문서 타입(text/json/xml)   
				}).done(function (data) {
					//console.log(data);
					$("#result").val(data);
				}).fail(function(xhr, status) {
					alert(status + " 발생.\n상태: " + xhr.status);
				});
				
			}); 