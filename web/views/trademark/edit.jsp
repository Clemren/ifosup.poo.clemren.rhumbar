<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:shell>
    <jsp:attribute name="header">
        <jsp:include page="../header.jsp"/>
    </jsp:attribute>
    <jsp:attribute name="breadcrumb">
        <div class="ui breadcrumb">
            <a class="section" href="${pageContext.request.contextPath}/origin">Marques</a>
            <div class="divider"> /</div>
            <div class="section">${ trademark.name == null ? "Ajouter" : "Modifier" }</div>
            <c:if test="${trademark.name != null}">
                <div class="divider"> /</div>
            <div class="section">${ trademark.name }</div>
            </c:if>
        </div>
    </jsp:attribute>
    <jsp:body>
        <div class="ui card">
            <div class="content">
                <div class="header">${ trademark.name == null ? "Ajouter" : "Modifier" }</div>
            </div>
            <div class="content">
                <form action="${pageContext.request.contextPath}/trademark/edit" method="post" class="ui form">
                    <div class="field">
                        <label for="origin">Origine de la marque</label>
                        <select name="fk_origin" id="origin">
                            <c:forEach items="${ origins }" var="origin">
                                <c:choose>
                                    <c:when test="${ trademark.fk_origin == origin.pk }">
                                        <option value="${ origin.pk }" selected="selected">${ origin.name }</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${ origin.pk }">${ origin.name }</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="field">
                        <input type="hidden" name="id" value="${ trademark.pk }">
                        <label for="name" id="name">Nom de la marque</label>
                        <input type="text" name="name" value="${ trademark.name }">
                    </div>
                    <div class="field">
                        <input type="submit" value="Enregistrer" class="ui button blue">
                    </div>
                </form>
            </div>
        </div>
        <script>
            $('form').validate({
                rules: {
                    name: {
                        required: true
                    }
                },
                messages: {
                    name: "Veuillez entrer un nom de marque"
                }
            });
        </script>
    </jsp:body>
</t:shell>