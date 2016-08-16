<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="licd" uri="FuncionesDeDados" %>
<%@ page errorPage="jstl-error-page.jsp" %>
<c:set scope="application" var="pageName" value="JSTL Tags" />
<c:set scope="application" var="pageBody" value="For testing JSTL [p485: Custom Tags]" />
<html>
<head>
<title>${applicationScope.pageName}</title>
</head>
<body>
<h1>${applicationScope.pageName}</h1>
<hr>${applicationScope.pageBody}<hr>

<div>

<p>
<b>[forEach]</b>
<c:set var="partes" scope="request">
	Luis,Ignacio,Cortorreal,De La Cruz
</c:set>
Partes: 
<c:forEach var="itPartes" items="${requestScope.partes}">
	"${itPartes}" - 
</c:forEach>
</p>

<p>
<b>[if]</b>
agrega el parametro <b>"?nivel"</b> (1, 2 o 3): 
<b><i>
<c:if test="${param.nivel == 1}">  Basico </c:if>
<c:if test="${param.nivel == '2'}"> Avanzado </c:if>
<c:if test="${param.nivel eq 3}"> Experto </c:if>
</i></b>
</p>

<p>
<b>[choose-when-otherwise]</b>
 Usa el parametro <b>"?amigos"</b> (1, 2, 3 o m&aacute;s): 
<b><i>
<c:choose>
	<c:when test="${param.amigos eq '1'}">
		Eso es normal
	</c:when>
	<c:when test="${param.amigos == '2'}">
		Oh!! Realmente??
	</c:when>
	<c:when test="${param.amigos eq 3}">
		Wow!! son amantes??
	</c:when>
	<c:when test="${param.amigos gt 3}">
		Puedes ganarle a Leonel Fernandez
	</c:when>
	<c:otherwise>
		&lt;-- USA EL PARAMETRO!!
	</c:otherwise>
</c:choose>
</i></b>
</p>


<p>
<b>[set-remove]</b> 
<c:set target="${requestScope}" property="fullName">
	Ahora, puedo, usar, comas
</c:set>
${requestScope.fullName} ...

<c:remove var="fullName" scope="request" />
${requestScope.fullName} ya no est&aacute; !!
&nbsp; &nbsp; &nbsp; //ver tambien: [forEach]
</p>


<p>
<b>[import]</b>
<c:import url="http://127.0.0.1:8080/jstl-00/jstl-file-to-import.jsp">
	<c:param name="parametroInclude" value="Lo que yo quiera pasarle, va aqui." />
</c:import>
</p>


<p>
<b>[url]</b>
<c:url value="/jstl-file-to-import.jsp" var="ignEncodedURL">
	<c:param name="simbolos" value="@#$%^&+=" />
</c:url>
${ignEncodedURL}
</p>

<p>
<b>[error-page]</b>
Agrega <b>?error</b> para generar un error ...
o escribe una ruta invalida ...
<c:if test="${param.error ne null}"> <%int unError=1/0;%> </c:if>
</p>

<p>
<b>[catch]</b>
<c:catch var="ignExp">
	<%int unError=1/0;%>
</c:catch>
La excepcion de esta linea fue: <i><u>${ignExp.message}</u></i>
</p>

<p>
<b>[custom tag]</b>
<licd:consejo>
	<jsp:attribute name="usuario">Oicangi3Siul</jsp:attribute>
</licd:consejo>
</p>


</div>

</body>
</html>