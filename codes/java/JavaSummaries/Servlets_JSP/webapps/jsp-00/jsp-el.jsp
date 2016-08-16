<%@ page import="com.Cortorreal" %>

<%
Cortorreal familia = new Cortorreal();
familia.setNombre("Mi Padre en Bacaneria");
familia.setHobby("El Domino en Fuerza");

String [] cadenas = { "Hello World", "Konnichi Wa Sekai", "Bonjour Le Monde", "Hola Mundo" } ;

application.setAttribute("pageName", "First Glance of EL");
application.setAttribute("pageBody", "This is a test for testing some of EL features.");
application.setAttribute("miPadre", familia );
application.setAttribute("attrCadenas", cadenas );
%>


<html>
<head>
<title>${applicationScope.pageName}</title>
</head>
<body>
<h1>${applicationScope.pageName}</h1>
<hr>${applicationScope.pageBody}<hr>

<div>

<jsp:useBean       id="miPadre"  class="com.Cortorreal" scope="application" />
<jsp:setProperty name="miPadre"  property="*" />

<b>&lt;jsp:useBean ... /&gt:</b> <br />

<jsp:getProperty name="miPadre"  property="nombre" /> <br>
<jsp:getProperty name="miPadre"  property="hobby" /> <br>

<hr>
<b>Expression Languages:</b> <br />
${attrCadenas["0"]} <br>
${applicationScope["attrCadenas"]["1"]} <br>
${miPadre.nombre} <br>
${param.mimadre} <br>

</div>


</body>
</html>