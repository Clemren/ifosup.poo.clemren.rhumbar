<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="currentPage" value="${requestScope['javax.servlet.forward.request_uri']}" />
<h1>Système de gestion de bar à rhum</h1>
<nav class="ui secondary pointing menu">
    <a class="item ${currentPage.contains('/origin')? 'active' :''}" href="origin">Origines</a>
    <a class="item ${currentPage.contains('/trademark')? 'active' :''}" href="${pageContext.request.contextPath}/trademark">Marques</a>
    <a class="item ${currentPage.contains('/rhum')? 'active' :''}" href="${pageContext.request.contextPath}/rhum">Rhums</a>
</nav>