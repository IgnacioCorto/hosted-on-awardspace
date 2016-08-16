<%@ include file="header.html" %>
<%-- 
This directive does not request the contents.
The application must be reloaded more often in order to 
reflect the changes of the include.
--%>

<h3>Konnichi Wa, Sekai</h3>
<p>If you want to do a forward, <br />
append <b>?forward</b> <br />
at the end of the URL <br />
of this JSP content  :-o <br />
<br />
or <a href="?forward">click here</a><br />
</p>
<% if(request.getParameter("forward")!=null) { %>
	<jsp:forward page="forward_receptor.html" />
<% } %>




<jsp:include page="footer.jsp">
	<jsp:param name="propietary" value="Ignacio De La Cruz" />
</jsp:include>
<%-- 
This directive always request the contents.
If you modify the include file, the changes will be
reflected  inmediatly.
--%>


