<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:shell>
    <jsp:attribute name="header">
        <jsp:include page="../header.jsp"/>
    </jsp:attribute>
    <jsp:attribute name="breadcrumb">
        <div class="ui breadcrumb">
            <a class="section" href="${pageContext.request.contextPath}/rhum">Accueil</a>
            <div class="divider"> /</div>
        </div>
    </jsp:attribute>
    <jsp:body>
        <h2>Catalogue de rhums</h2>
        <table class="ui celled table">
            <thead>
            <tr>
                <th>
                    Rhum
                </th>
                <th>
                    Marque
                </th>
                <th>
                    Origine
                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ rhums }" var="rhum">
                <tr>
                    <td>
                            ${ rhum.name }
                    </td>
                    <td>
                            ${ rhum.trademark }
                    </td>
                    <td>
                            ${ rhum.origin }
                    </td>

                </tr>
            </c:forEach>
            </tbody>

        </table>
    </jsp:body>
</t:shell>