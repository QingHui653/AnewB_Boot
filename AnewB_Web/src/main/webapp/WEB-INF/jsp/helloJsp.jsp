<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello jsp and ajax</title>
</head>
<body>
    helloJsp
    <hr/>
    ${hello}
    <button onclick="job()">click</button>
    <hr/>
    <div id="ajaxhtml"></div>
</body>

<script>
	function job(){
		$.ajax({  
		    url: "/test/list" ,  
		    type: "POST",  
		    success: function (returndata) {
		    	$("#ajaxhtml").html("这是第一个JSONfcnction");
		    	job2();
		    },  
		    error: function (returndata) {  
		        alert(returndata); 
		    }  
		});
	}
	
	function job2(){
		$.ajax({  
		    url: "/test/list" ,  
		    type: "POST",  
		    success: function (returndata) {
		    	$("#ajaxhtml").html("这是第二个JSONfcnction");
		    },  
		    error: function (returndata) {  
		        alert(returndata); 
		    }  
		});
	}
</script>
</html>