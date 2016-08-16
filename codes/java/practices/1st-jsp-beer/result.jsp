<%@ page import="java.util.*" %>
<html>
<body>
<h1>Beer Recommendation JSP</h1>
<%
    //BeerExpert be = new BeerExpert();
    List<String> styles = (List) request.getAttribute("styles");
    Iterator it = styles.iterator();
    while(it.hasNext()) out.print("<br />Try: "+it.next());
%>
</body>
</html>