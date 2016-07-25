<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@tag description="Page Template" pageEncoding="UTF-8"%>

<%@attribute name="title"%>
<%@attribute name="bodyLayout" fragment="true" %>

<html>
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
<%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app.js"></script>--%>
<%--<script>--%>
    <%--$(document).ready(function() {--%>
        <%--var pathname = window.location.pathname;--%>
        <%--$("nav").on("click", function () {--%>
            <%--$("nav").removeClass("active");--%>
            <%--$('.nav > li > a[href="'+pathname+'"]').parent().addClass('active');--%>
        <%--});--%>
        <%--$('.nav > li > a[href="'+pathname+'"]').parent().addClass('active');--%>
    <%--});--%>
<%--</script>--%>
</head>
<body>
<div class="row">
    <nav class="navbar navbar-inverse row ">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">JS</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav col-md-3 col-xs-offset-6">
                    <li><a href="${pageContext.request.contextPath}/contact">Contacts</a></li>
                </ul>
                <ul class="nav navbar-nav col-md-3 col-xs-offset-8">
                    <li><a href="#">MyProfile</a></li>
                </ul>
                <ul class="nav navbar-nav col-md-3 col-xs-offset-7">
                    <li><a href="#">Exit</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>
<div class="container" id = "main">
    <jsp:invoke fragment="bodyLayout"/>
    <hr>
    <footer>
        <p>© JungleC.</p>
    </footer>
</div>

<%--<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app.js"></script>--%>
</body>
</html>
