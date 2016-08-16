<%@ page import="java.util.*" %>

<html>
<head>
<title>Testing</title>
</head>
<body>
<h1>Testing</h1>
<%
String salida;
if( request.getParameter("maria")==null ) {
	salida = "No existe el parametro" ;
} else {
	salida = "Si existe el parametro" ;
}
out.println(salida);
%>
</body>
</html>