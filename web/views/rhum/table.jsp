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