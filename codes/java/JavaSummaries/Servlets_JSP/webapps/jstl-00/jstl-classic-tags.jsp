<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" uri="FuncionesDeDados" %>

<head>
<c:set scope="application" var="pageName" value="Classic Tags [p517]" />
<c:set scope="application" var="pageBody" value="Testing my creation of <b>classic tags</b>." />
<title>${applicationScope.pageName}</title>
</head>

<body>
<h1>${applicationScope.pageName}</h1>
${applicationScope.pageBody}<hr>

<p>
<b>[.doStartTag()]</b>
<custom:classic1/>
</p>

<p>
<b>[.doStart|EndTag()]</b>
<custom:classic2></custom:classic2>
</p>

<p>
<b>[EVAL_BODY_INCLUDE]</b>
<custom:classic3> <u><i>Este es el Body</i></u> </custom:classic3>
</p>

<p>
<b>[iteracion doAfterBody()]</b>
Peliculas: 
<custom:classic4> "${pelicula}" &nbsp; </custom:classic4>
</p>

<hr>

<p>
<b>[tags anidados]</b>
<custom:parent1>
	<custom:parent1>
		<custom:parent1 />
	</custom:parent1>
</custom:parent1>
</p>

<p>
<b>[classicOuter simpleInner]</b>
<custom:classicOuter name="Oicangi3Siul">
	<custom:simpleInner />
</custom:classicOuter>
&nbsp; [p537]
</p>

<p>
<b>[Menu padre/hijo]</b>
<custom:menuPadre>
	<custom:menuHijo nombre="Archivo" />
	<custom:menuHijo nombre="Edicion" />
	<custom:menuHijo nombre="Formato" />
	<custom:menuHijo nombre="Ver" />
	<custom:menuHijo nombre="Ayuda" />
</custom:menuPadre>
<br>
<i><b>Nota:</b> Este usa <u>pageContext.getOut()</u> &nbsp; y &nbsp; 
<u>findAncestorWithClass(this,MenuParentTagHandler.class)</u>
respectivamente</i>
</p>


</body>
</html>