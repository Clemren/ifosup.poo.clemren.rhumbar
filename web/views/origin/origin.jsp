<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:shell>
    <jsp:attribute name="header">
        <jsp:include page="../header.jsp"/>
    </jsp:attribute>
    <jsp:attribute name="breadcrumb">
        <div class="ui breadcrumb">
            <a class="section" href="${pageContext.request.contextPath}/origin">Origines</a>
            <div class="divider"> / </div>
        </div>
    </jsp:attribute>
    <jsp:body>
        <h2>Liste des origines de rhum</h2>
        <table class="ui celled table">
            <thead>
            <tr>
                <th colspan="2">
                    <a class="ui labeled icon button" href="${pageContext.request.contextPath}/origin/edit">
                        <i class="add icon"></i>
                        Ajouter une origine
                    </a>
                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ origins }" var="origin">
                <tr>
                    <td>
                        <i class="${ origin.countryAlpha2 } flag"></i>
                            ${ origin.countryName }
                    </td>
                    <td>
                            ${ origin.name }
                    </td>
                    <td>
                        <a class="ui button blue basic basic"  href="${pageContext.request.contextPath}/origin/edit?id=${ origin.pk }">Modifier</a>
                        <c:if test="${origin.canDelete}">
                            <a class="ui button red basic" href="${pageContext.request.contextPath}/origin/delete?id=${ origin.pk }"
                               onclick="return confirm('Souhaitez-vous réellement supprimer cette origine ?');">Supprimer</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </jsp:body>
</t:shell>