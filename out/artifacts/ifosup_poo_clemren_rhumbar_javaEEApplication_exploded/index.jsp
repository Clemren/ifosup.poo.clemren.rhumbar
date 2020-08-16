<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: clemren
  Date: 15/08/2020
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>

<t:shell>
    <jsp:attribute name="header">
        <jsp:include page="/views/header.jsp"/>
        <div>
            Je suis le contenu: <c:out value="${1+3}"/>
        </div>
    </jsp:attribute>
    <jsp:body>
        <p>
            TEST
        </p>
    </jsp:body>
</t:shell>
