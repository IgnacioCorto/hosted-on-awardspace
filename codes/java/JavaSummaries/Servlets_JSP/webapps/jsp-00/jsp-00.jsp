<%-- IMPORT A CLASS --%>
<%@ page import="com.MyAlert" %>

<%-- INCLUDE A FILE --%>
<%@ include file="header.html" %>

<h3>Konnichi Wa, Sekai</h3>

<%-- HERE COMES A SCRIPTLET --%>
<% out.println("Next comes an alert: "); %>

<%-- HERE COMES A EXPRESSION --%>
<%=MyAlert.show("Bonjour Le Monde")%>

<%@ include file="footer.html" %>