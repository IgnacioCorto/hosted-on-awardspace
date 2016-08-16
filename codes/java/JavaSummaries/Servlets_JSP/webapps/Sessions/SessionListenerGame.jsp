<%@ page import="java.util.*" %>

<html>
<head>
<title>Session Listeners Game</title>
</head>
<body>

<a href="./">Go to Index</a> 
<h1>Session Listeners Game</h1>
<p>
<b>Note:</b> "Destroy Session" link needs improvements on JSP file. <br>
<b>Note:</b> "Session Migrations" should work in "Object Status", but Multi-JVMs for Load-Balancing have not been tested. <br>
</p>

<table>
<tr>
<th>Session</th>
<th>Attributes</th>
<th>Object</th>
</tr>

<tr>

<!-- SESSION -->
<td>
Session Status:<br>
<%
if(request.getParameter("destroySession")!=null) {
	session.invalidate();
}
String sessionMessage = (String) application.getAttribute("sessionStatus") ;
out.println(sessionMessage);
%>
<hr>
<a href="?createSession">Create Session</a><br>
<a href="?destroySession">Destroy Session</a><br>
</td>

<!-- ATTRIBUTES -->
<td>
Attribute Status:<br>
<%
String attributeMessage = (String) application.getAttribute("attributeStatus") ;
out.println(attributeMessage);
%>
<hr>
<a href="?setAttribute">Set Attribute</a><br>
<a href="?removeAttribute">Remove Attribute</a><br>
</td>

<!-- OBJECTS -->
<td>
Object Status:<br>
<%
String objectMessage = (String) application.getAttribute("objectStatus") ;
out.println(objectMessage);
%>
<hr>
<a href="?addObject">Add Object</a><br>
<a href="?removeObject">Remove Object</a><br>
</td>

</tr>

</table>

</body>
</html>