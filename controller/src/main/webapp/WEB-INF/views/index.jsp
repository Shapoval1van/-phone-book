<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<spring:message code="title.main" var="main_title"/>
<t:pageLayout title="${main_title}">
    <jsp:attribute name="bodyLayout">
        <div class="jumbotron masthead">
            <div class="container">
                <h1><spring:message code="welcome.h1"/></h1>
                <p class="lead"><spring:message code="welcome.ads"/></p>
                <p><a href="/contact" class="btn btn-primary btn-lg"><spring:message code="welcome.button"/>»</a></p>
            </div>
        </div>
    </jsp:attribute>
</t:pageLayout>