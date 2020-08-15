<%@ page import="beans.Origin" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: cleme
  Date: 11/12/2019
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html
        xmlns="http://www.w3.org/1999/xhtml"
        xmlns:c="http://java.sun.com/jstl/core">
<head>
    <meta charset="utf-8">
    <title>Liste des origines de rhum</title>
</head>
<body>

<jsp:include page="../header.jsp"></jsp:include>

<h2>Liste des origines de rhum</h2>
<table>

    <tr>
        <th>
            <a href="${pageContext.request.contextPath}/origin/edit">add</a>
        </th>
    </tr>

    <%
        List<Origin> origins = (List<Origin>) request.getAttribute("origins") ;
        for (Origin origin : origins) {
    %>
    <tr>
        <td>
            <%=origin.getName()%>
        </td>
        <td>
            <a href="${pageContext.request.contextPath}/origin/delete?id=<%= origin.getPk() %>"
               onclick="return confirm('Souhaitez-vous réellement supprimer cette origine ?');">delete</a>
        </td>

        <td>
            <a href="${pageContext.request.contextPath}/origin/edit?id=<%= origin.getPk() %>">edit</a>
        </td>
    </tr>

    <%}%>
</table>
</body>
</html>
