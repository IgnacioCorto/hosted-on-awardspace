<%@ page import="java.util.*" %>

<html>
<head>
<title>The Session Calculator</title>
</head>
<body>
<h1>The Session Calculator</h1>
<h2>Results</h2>
<p><b>Formula:</b> <%=(String)request.getAttribute("formula")%></p>
<p><b>Total:</b> <%=(String)request.getAttribute("total")%></p>
<a href="./">Return to index</a>
</body>
</html>