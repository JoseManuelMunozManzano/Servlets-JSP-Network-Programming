<!DOCTYPE html>
<html>
<head>
  <title>Result</title>
</head>
<body>
  <h1>And the result is...</h1>
  <!-- Manera de adjuntar código Java -->
   <%
		int number1 = Integer.parseInt(request.getParameter("number1"));
		int number2 = Integer.parseInt(request.getParameter("number2"));

    out.print(number1 + number2);
   %>

<!-- INCLUDE -->

<!-- Usando action element include -->
<jsp:include page="test.html"/>

<!-- Usando la directiva include -->
 <!-- <%@include file="test.html" %> -->

<!-- 
El resultado es el mismo, pero la forma de conseguirlo varía.
Si vamos a la carpeta donde tenemos instalado Tomcat, al fichero work/Catalina/localhost/jspinclude/org/apache/jsp/jspexample_jsp.java veremos que:

- Usando la directiva include, el servlet traducido contiene el código HTML del fichero test.html. Esto indica que, si necesitamos objetos request y response, no podemos usar la directiva include porque en el momento de traducción esos objetos no existen. Además, las directivas se reemplazan por elementos HTML.

- Usando el action element include, el servlet traducido no contiene el código HTML del fichero test.html, sino que contiene la llamada:
		org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "test.html", out, false);
Es decir, un action element se convierte en una llamada a un método, que se ejecutará cuando el servlet están en ejecución.
 -->

<!-- FORWARD -->
 
<jsp:forward page="include.jsp" >
  <jsp:param name="name" value="some value" />
</jsp:forward>

</body>
</html>
