<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.text.DecimalFormat" %>
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
        <h2 class="">Catalogue de rhums</h2>
        <fieldset class="ui basic segment">
            <form action="/rhum/filter" method="get" id="filterForm" class="ui form">
                <div class="fields">
                    <div class="four wide field">
                        <label for="countryMenu">Pays</label>
                        <div class="ui search selection dropdown" >
                            <input type="hidden" name="country">
                            <i class="dropdown icon"></i>
                            <div class="default text">Sélectionnez un pays</div>
                            <div class="menu" id="countryMenu"></div>
                        </div>
                    </div>
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
                </div>
                <div class="fields">
                    <div class="four wide field">
                        <div class="ui divider hidden"></div>
                        <input type="submit" class="ui button teal" value="Filtrer">
                        <a id="refreshFilter" class="ui button circular icon default"><i class="sync icon"></i></a>
                    </div>
                </div>
            </form>
        </fieldset>
        <jsp:include page="/views/rhum/table.jsp">
            <jsp:param name="rhums" value="${rhums}"/>
        </jsp:include>


        <script>
            $(function () {
                $.get('${pageContext.request.contextPath}/data/countries.json', function (result) {
                    $(result).each(function (index, value) {
                        $('#countryMenu').append('<div class="item" data-value="'+value.alpha2+'"><i class="'+value.alpha2+' flag"></i>' + value.name + '</div>');
                    })
                }).then(function(){
                    $('.ui.dropdown').dropdown({
                        onChange: function(value) {
                            $('#filterForm').submit();
                        }
                    });
                });
            });

            $(document).on('click', '.detailButton', function(e){
                e.preventDefault();
                const id = $(this).data('id');
                $.get('${pageContext.request.contextPath}/rhum/details', {id : id}, function (result) {
                    $('#modalContent').html(result);
                    $('#modal').modal('show');
                })
            });

            $('#filterForm input').on('keyup', function () {
                $('#filterForm').submit();
            });

            $('#filterForm').on('submit', function (e) {
                e.preventDefault();
                $.get('rhum/filter', {
                    country: $('input[name=country]').val(),
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

                $('.ui.dropdown').dropdown('clear');

                $.get('rhum/filter', function (response) {
                    $('#rhums').replaceWith(response);
                });
            });

        </script>

    </jsp:body>
</t:shell>