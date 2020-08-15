<%--
  Created by IntelliJ IDEA.
  User: cleme
  Date: 11/12/2019
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bienvenue</title>
</head>
<body>
<h1>Liste des origines de rhum</h1>

<table>
    <c:forEach items="${origins}" var="origin">
        <tr>
            <td>${origin.pk_origin}</td>
            <td>${origin.name}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
