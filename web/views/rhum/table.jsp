<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

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
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ rhums }" var="rhum">
        <tr>
            <td>
                <a href="#" class="detailButton" data-id="${ rhum.pk }">
                    <img src="images/${ rhum.filename }" alt="image du rhum ${ rhum.name }" class="ui small image">
                </a>
            </td>
            <td>
                <a href="#" class="detailButton" data-id="${ rhum.pk }">
                        ${ rhum.name }
                </a>
            </td>
            <td>
                    ${ rhum.trademark }
            </td>
            <td>
                <i class="${ rhum.countryAlphaName } flag"></i>
                    ${ rhum.countryName } - ${ rhum.origin }
            </td>
            <td>${rhum.getFormattedCurrencyPrice()}</td>
            <td>
                <div class="ui buttons">
                    <a class="ui button default"  href="${pageContext.request.contextPath}/rhum/edit?id=${ rhum.pk }">Modifier</a>
                    <div class="or" data-text="ou"></div>
                    <a class="ui button red" href="${pageContext.request.contextPath}/rhum/delete?id=${ rhum.pk }" onclick="return confirm('Souhaitez-vous réellement supprimer ce rhum ?');">Supprimer</a>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>