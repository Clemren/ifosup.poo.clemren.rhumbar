<%@ page import="beans.Origin" %><%--
  Created by IntelliJ IDEA.
  User: cleme
  Date: 15/08/2020
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<jsp:include page="../header.jsp"></jsp:include>

<%
Origin origin = (Origin) request.getAttribute("origin");
%>
<form action="<%=request.getContextPath()%>/origin/edit" method="post">
    <%if (origin != null){%>
    <input type="hidden" name="id" value="<%=origin != null ? origin.getPk() : "" %>">
    <%}else{%>

    <%}%>
    <input type="text" name="name" value="<%=origin != null ? origin.getName() : "" %>">
    <input type="submit" value="Enregistrer">
</form>
</body>
</html>
