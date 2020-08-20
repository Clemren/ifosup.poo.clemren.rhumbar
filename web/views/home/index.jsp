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
        <fieldset class="ui basic segment">
            <form action="/rhum/filter" method="get" id="filterForm" class="ui form">
                <div class="fields">
                    <div class="four wide field">
                        <label>Nom du rhum</label>
                        <input type="text" name="name">
                    </div>
                    <div class="four wide field">
                        <label>Marque</label>
                        <input type="text" name="trademark">
                    </div>
                    <div class="four wide field">
                        <label>Origine</label>
                        <input type="text" name="origin">
                    </div>
                    <div class="four wide field">
                        <label>.</label>
                        <input type="submit" class="ui button blue" value="Filtrer">
                        <a id="refreshFilter" class="ui button blue">Rafraichir</a>
                    </div>
            </form>
        </fieldset>
        <table class="ui celled table" id="rhums">
            <thead>
            <tr>
                <th>
                    <a class="ui labeled icon button" href="${pageContext.request.contextPath}/rhum/edit">
                        <i class="add icon"></i>
                        Ajouter un rhum
                    </a>
                </th>
                <th>
                    Rhum
                </th>
                <th>
                    Marque
                </th>
                <th>
                    Origine
                </th>
                <th>
                    Prix unitaire TVA incluse (21%)
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
                            ${ rhum.trademark }
                    </td>
                    <td>
                        <i class="${ rhum.countryAlphaName } flag"></i>
                            ${ rhum.countryName } - ${ rhum.origin }
                    </td>
                    <th>${ rhum.getVatIncludedUnitPrice() }</th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <script>

            $('#filterForm').on('submit', function (e) {
                e.preventDefault();
                $.get('rhum/filter', {
                    name: $('input[name=name]').val(),
                    trademark: $('input[name=trademark]').val(),
                    origin: $('input[name=origin]').val(),
                }, function (response) {
                    $('#rhums').replaceWith(response);
                });
            });

            $('#refreshFilter').on('click', function () {
                $('input[name=name]').val('');
                $('input[name=trademark]').val('');
                $('input[name=origin]').val('');
                $.get('rhum/filter', function (response) {
                    $('#rhums').replaceWith(response);
                });
            });

        </script>

    </jsp:body>
</t:shell>