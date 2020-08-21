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
            <div class="section">${ rhum.name == null ? "Ajouter" : "Modifier" }</div>
            <c:if test="${rhum.name != null}">
                <div class="divider"> / </div>
            <div class="section">${ rhum.name }</div>
            </c:if>
        </div>
    </jsp:attribute>
    <jsp:body>
        <div class="ui card">
            <div class="content">
                <div class="header">${ rhum.name == null ? "Ajouter" : "Modifier" }</div>
            </div>
            <div class="content">
                <form action="${pageContext.request.contextPath}/rhum/edit" method="post" class="ui form" enctype="multipart/form-data">
                    <label for="trademark">Marque du rhum</label>
                    <select name="fk_trademark" id="trademark">
                        <c:forEach items="${ trademarks }" var="trademark">
                            <c:choose>
                                <c:when test="${ rhum.fk_trademark == trademark.pk }">
                                    <option value="${ trademark.pk }" selected>${ trademark.name }</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${ trademark.pk }">${ trademark.name }</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>

                    <div class="field">
                        <input type="hidden" name="id" value="${ rhum.pk }">
                        <label for="name">Nom du rhum</label>
                        <input type="text" name="name" id="name" value="${ rhum.name }">
                    </div>
                    <div class="field">
                        <label for="unitprice">Prix unitaire (hors tva)</label>
                        <input type="number" step="0.01" min="0" name="unitprice" id="unitprice" value="${ rhum.unitPrice }">
                    </div>
                    <div class="field">
                        <label for="name">Description</label>
                        <textarea name="description" id="description" rows="10" >${ rhum.description }</textarea>
                    </div>
                    <div class="field">
                        <input type="file" name="file">
                    </div>
                    <div class="field">
                        <input type="submit" value="Enregistrer" class="ui button teal">
                    </div>
                </form>
            </div>
        </div>
        <script>
            $('form').validate({
                rules: {
                    name: {
                        required: true
                    },
                    unitprice: {
                        required: true
                    }
                },
                messages: {
                    name: "Veuillez entrer un nom de rhum",
                    unitprice: "Veuillez entrer un prix unitaire"

                }
            });
        </script>
    </jsp:body>
</t:shell>