<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:shell>
    <jsp:attribute name="header">
        <jsp:include page="../header.jsp"/>
    </jsp:attribute>
    <jsp:attribute name="breadcrumb">
        <div class="ui breadcrumb">
            <a class="section" href="${pageContext.request.contextPath}/rhum">Rhums</a>
            <div class="divider"> / </div>
        </div>
    </jsp:attribute>
    <jsp:body>
        <h2>Catalogue de rhums</h2>
        <table class="ui celled table">
            <thead>
            <tr>
                <th colspan="3">
                    <a class="ui labeled icon button" href="${pageContext.request.contextPath}/rhum/edit">
                        <i class="add icon"></i>
                        Ajouter un rhum
                    </a>
                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ rhums }" var="rhum">
                <tr>
                    <td>
                        <img src="images/${ rhum.filename }" alt="image du rhum ${ rhum.name }" class="ui small image">
                    </td>
                    <td>
                            ${ rhum.name }
                    </td>
                    <td>
                        <a class="ui button blue basic basic"  href="${pageContext.request.contextPath}/rhum/edit?id=${ rhum.pk }">Modifier</a>
                        <a class="ui button red basic" href="${pageContext.request.contextPath}/rhum/delete?id=${ rhum.pk }"
                           onclick="return confirm('Souhaitez-vous réellement supprimer ce rhum ?');">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </jsp:body>
</t:shell>