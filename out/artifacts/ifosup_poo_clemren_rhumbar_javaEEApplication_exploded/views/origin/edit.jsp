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
            <div class="divider"> /</div>
            <div class="section">${ origin.name == null ? "Ajouter" : "Modifier" }</div>
            <c:if test="${origin.name != null}">
                <div class="divider"> /</div>
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
                    <input type="hidden" name="id" value="${ origin.pk }">
                    <div class="field">
                        <label for="name">Pays</label>
                        <div class="ui search selection dropdown" >
                            <input type="hidden" name="country">
                            <i class="dropdown icon"></i>
                            <div class="default text">Select Country</div>
                            <div class="menu" id="countryMenu"></div>
                        </div>
                    </div>
                    <div class="field">
                        <label for="name">Description</label>
                        <textarea name="description" id="description" rows="10" >${ origin.name }</textarea>
                    </div>

                    <div class="field">
                        <input type="hidden" name="id" value="${ origin.pk }">
                        <label for="name">Lieu d'origine du rhum</label>
                        <input type="text" name="name" id="name" value="${ origin.name }">
                    </div>
                    <div class="field">
                        <input type="submit" value="Enregistrer" class="ui button blue">
                    </div>
                </form>
            </div>
        </div>
        <script>
            $(function () {
                $.get('${pageContext.request.contextPath}/data/countries.json', function (result) {
                    $(result).each(function (index, value) {
                        $('#countryMenu').append('<div class="item" data-value="'+value.alpha2+'"><i class="'+value.alpha2+' flag"></i>' + value.name + '</div>');
                    })
                }).then(function(){
                    $('.ui.dropdown').dropdown('set selected','${ origin.countryAlpha2.toLowerCase() }');
                });;
            });


            $('form').validate({
                rules: {
                    name: {
                        required: true
                    },
                    country: {
                        required: true
                    }
                },
                messages: {
                    name: "Veuillez entrer une origine"
                }
            });
        </script>
    </jsp:body>
</t:shell>