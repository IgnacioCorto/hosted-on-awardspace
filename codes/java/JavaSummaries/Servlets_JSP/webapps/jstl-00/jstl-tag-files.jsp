<html>
<%@ page import="java.util.*,com.simple.Pelicula" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fileTag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="custom" uri="FuncionesDeDados" %>

<head>
<c:set scope="application" var="pageName" value="File Tags [p499: SimpleTags]" />
<c:set scope="application" var="pageBody" value="Testing my creation of file tags." />
<title>${applicationScope.pageName}</title>
</head>

<body>
<h1>${applicationScope.pageName}</h1>
${applicationScope.pageBody}<hr>

<p><b>[file tag]</b>
<fileTag:header-tag parametro="PARAMETRO">
	Body del filetag ${asdf}
</fileTag:header-tag>
</p>

<p>
<b>[.doTag()]</b>
<custom:simple1/>
</p>

<p>
<b>[getJspBody().invoke(null)]</b>
<custom:simple2> Usar el contenido del body </custom:simple2>
</p>

<p>
<b>[getJspContext().setAttribute("a","b")]</b>
<custom:simple3> Mensaje: ${mensaje} </custom:simple3>
</p>

<p>
<b>[Bucle: reinvocar JspBody]</b> Peliculas: 
<custom:simple4> "${pelicula}" &nbsp; </custom:simple4>
</p>

<p>
<b>[Iterar un atributo coleccion]</b> Peliculas: 
<%
Pelicula peli;
ArrayList colPeli = new ArrayList();
peli = new Pelicula();
 peli.setNombre("Troya");
  peli.setGenero("Guerra");
   colPeli.add(peli);
peli = new Pelicula();
 peli.setNombre("Gladiador");
  peli.setGenero("Greco-Romana");
   colPeli.add(peli);
request.setAttribute("coleccionPeliculas", colPeli);
%>

<custom:simple5 listaDePeliculas="${coleccionPeliculas}">
	"${pelicula.nombre}"(${pelicula.genero}) &nbsp; 
</custom:simple5>
</p>

<p>
<b>[SkipPageException]</b> 
[Pre-Error] <custom:simple6/> [Post-Error] 
</p>


</body>
</html>