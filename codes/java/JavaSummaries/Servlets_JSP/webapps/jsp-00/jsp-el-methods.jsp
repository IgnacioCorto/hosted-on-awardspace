<%@ page import="com.LudicMethods" %>
<%@ taglib prefix="Ignacio" uri="FuncionesDeDados" %>
<%
application.setAttribute("pageName", "Ludic Methods");
application.setAttribute("pageBody", "This file are used for testing the EL methods.");
%>
<html>
<head>
<title>${applicationScope.pageName}</title>
</head>
<body>
<h1>${applicationScope.pageName}</h1>
<hr>${applicationScope.pageBody}<hr>

<div>

Roled dice: ${Ignacio:lanzarDado(20)} <br>

</div>


</body>
</html>