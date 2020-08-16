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
            <div class="section">${ origin.name == null ? "Ajouter" : "Modifier" }</div>
            <c:if test="${origin.name != null}">
                <div class="divider"> / </div>
            <div class="section">${ origin.name }</div>
            </c:if>
        </div>
    </jsp:attribute>
    <jsp:body>
        <div class="ui card">
            <div class="content">
                <div class="header">${ origin.name == null ? "Ajouter" : "Modifier" }</div>
            </div>
            <div class="content">
                <form action="${pageContext.request.contextPath}/origin/edit" method="post" class="ui form">
                    <div class="field">
                        <input type="hidden" name="id" value="${ origin.pk }">
                        <input type="text" name="name" value="${ origin.name }">
                    </div>
                    <div class="field">
                        <input type="submit" value="Enregistrer" class="ui button blue">
                    </div>
                </form>
            </div>
        </div>

    </jsp:body>
</t:shell>