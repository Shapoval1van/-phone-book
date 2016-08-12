<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<spring:message code="list.addGroup" var="group_title"/>
<t:pageLayout title="${group_title}">
    <jsp:attribute name="bodyLayout">
        <div class="container" id="main">
            <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
                <spring:url value="" var="create_group_url"/>
                <form:form action="/create-group"  role="form" commandName="groupForm" cssClass="form-horizontal" method="POST">
                    <h2>${group_title}</h2>
                        <div class="form-group">
                            <label for="groupName" class="col-sm-3 col-lg-2 control-label">${group_title}</label>
                            <div class="col-sm-9 col-lg-10">
                                <spring:message code="list.group" var="group_ph"/>
                                <spring:bind path="groupName">
                                    <form:input path="groupName" name="groupName" id="groupName"
                                                cssClass="form-control input-lg"  required="required" placeholder="${group_ph}" tabindex="1"/>
                                </spring:bind>
                            </div>
                        </div>
                    <div class="row">
                        <spring:message code="group.create" var="create_groupe"/>
                        <div><input type="submit" value="${create_groupe}" class="btn btn-success btn-block btn-lg" tabindex="2"></div>
                    </div>
                </form:form>
            </div>
        </div>
        <hr>
    </jsp:attribute>
</t:pageLayout>
