/**
 * 
 */    document.addEventListener("DOMContentLoaded", function() {
        const button = document.querySelector("#submitBtn");

        button.addEventListener("click", function(event) {
            const name = document.querySelector('select[name="menu"]').value;

    		$("#dataForm").attr({
    			"method" : "post",
    			"action" : "/servletExample/todayMenu"
    		});
    		$("#dataForm").submit();
        });
    });