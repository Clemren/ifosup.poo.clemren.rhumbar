<%@tag description="Master layout tag" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="title" fragment="true" %>
<%@attribute name="breadcrumb" fragment="true" %>

<html
        xmlns="http://www.w3.org/1999/xhtml"
        xmlns:c="http://java.sun.com/jstl/core">
<head>
    <meta charset="utf-8">
    <title>
        <jsp:invoke fragment="title"/>
    </title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js" integrity="sha512-UdIMMlVx0HEynClOIFSyOrPggomfhBKJE28LKl8yR3ghkgugPnG6iLfRfHwushZl1MOPSY6TsuBDGPK2X4zYKg==" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.js" integrity="sha512-dqw6X88iGgZlTsONxZK9ePmJEFrmHwpuMrsUChjAw1mRUhUITE5QU9pkcSox+ynfLhL15Sv2al5A0LVyDCmtUw==" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css" integrity="sha512-8bHTC73gkZ7rZ7vpqUQThUDhqcNFyYi2xgDgPDHc+GXVGHXq+xPjynxIopALmOPqzo9JZj0k6OqqewdGO3EsrQ==" crossorigin="anonymous" />
</head>
<body>
<div class="ui container">
    <div id="pageheader">
        <jsp:invoke fragment="header"/>
    </div>
    <div class="ui hidden divider"></div>
    <div id="breadcrumb">
        <jsp:invoke fragment="breadcrumb"/>
    </div>
    <div class="ui hidden divider"></div>
    <div id="body">
            <jsp:doBody/>
    </div>
    <div class="ui hidden divider"></div>
    <div id="pagefooter">
        <jsp:invoke fragment="footer"/>
    </div>
</div>
</body>
</html>