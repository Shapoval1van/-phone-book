<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@tag description="Page Template" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="title"%>
<%@attribute name="bodyLayout" fragment="true" %>

<html>
<csrf disabled="true"/>
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
    <div >
        <nav class="navbar navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Jc</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav col-md-3 col-xs-offset-6">
                        <li><a href="${pageContext.request.contextPath}/contact"><spring:message code="navbar.contact"/></a></li>
                    </ul>
                    <ul class="nav navbar-nav col-md-3 col-xs-offset-7">
                        <c:url value="/j_spring_security_logout" var="logoutUrl" />
                        <li><a id="exit" href="<c:url value="${logoutUrl}" />"><spring:message code="navbar.exit"/></a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <jsp:invoke fragment="bodyLayout"/>
    <footer>
        <div >
            <div class="col-md-3 col-sm-3">
                <p>© JungleC.</p>
            </div>
            <div class="col-md-9 col-sm-9 clearfix" align="right">
                <a href="?lang=en" class="btn btn-default flag flag-uk"<%--onclick="SetCookie('localeCookie','ru_RU')--%>>
                    ENG
                </a>
                <a href="?lang=ru" class="btn btn-default flag flag-ru"<%--onclick="SetCookie('localeCookie','en_US')--%>>
                    RUS
                </a>
            </div>
        </div>
    </footer>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app.js"></script>--%>
</body>
</html>
