
<!DOCTYPE html>
<html>
<head>
<title>Result</title>
</head>
<body>
<h1>Result from the included file..</h1>
<h1>

<%

		int number1 = Integer.parseInt(request.getParameter("number1"));
		int number2 = Integer.parseInt(request.getParameter("number2"));
		
		out.print(number1+number2);

%>

<!-- Leemos el parámetro enviado desde jspexample.jsp, en el forward -->
 <p>
	<%= "Parameter received by forwarding: " + request.getParameter("name") %>
 </p>

</h1>
</body>
</html>
