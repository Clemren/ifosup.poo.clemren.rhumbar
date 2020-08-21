<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<div class="ui card fluid">

    <div class="image">
        <img src="images/${ rhum.filename }" alt="image du rhum ${ rhum.name }">
    </div>
    <h2 class="center aligned header">${ rhum.name }</h2>
    <div class="content">
        <div class="description">
            ${ rhum.description }
        </div>
        <div class="meta right aligned">
            ${rhum.getFormattedCurrencyPrice()}
        </div>
    </div>
    <div class="extra content">

            <i class="${ rhum.countryAlphaName } flag"></i>
            ${ rhum.countryName } - ${ rhum.origin }


    </div>
</div>

