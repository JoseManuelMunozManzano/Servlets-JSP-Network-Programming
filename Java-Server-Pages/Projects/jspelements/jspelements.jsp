
<!DOCTYPE html>
<html>
<head>
<title>Result</title>
</head>
<body>


<%-- JSP Comments --%>

<!--============ Separator ==============-->

<h3>JSP Scriptlet</h3>
<% 

int a= 10;
int b = 20;

out.print(a+b);

%>

<!--============ Separator ==============-->

<h3>JSP Expressions</h3>
<p>Current Date info : <%= new java.util.Date() %></p>

<!--============ Separator ==============-->

<h3>JSP Declarations (Check the generated source file)</h3>
<%! private int pageviews; %>
<%! public void incrementPageviews() 
{ 
++pageviews; 
} 
%> 

<!--============ Separator ==============-->

<h3>JSP Page Directives (Check the generated source file)</h3>
<%-- import package java.sql.* --%>
<%@page import="java.sql.*" %>

<%@page session="false" %>

<!--============ Separator ==============-->

<h3>JSP Include Directives</h3>
<%@include file="test.html" %>

<!--============ Separator ==============-->

<h3>JSP Taglib Directive (will talk about it later)</h3>


</body>
</html>