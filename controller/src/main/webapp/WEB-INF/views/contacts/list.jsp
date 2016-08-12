<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<spring:message code="title.contacts" var="contact_title"/>
<t:pageLayout title="${contact_title}">
    <jsp:attribute name="bodyLayout">
        <div class="container" id="main">
            <div class="col-xs-offset-11">
                <a class="btn btn-primary" href="/contact/create"><spring:message code="list.button"/></a>
            </div>
            <div class="col-xs-3">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title"><spring:message code="list.group"/></h3>
                    </div>
                    <div class="panel-body">
                        <ul>
                            <c:forEach items="${groups}" var="group">
                                <li><span class="list-group-item"><a href="#" >${group.getGroupName()}</a>
                                    <c:if test="${group.getDefault() == false}">
                                        <a href="/delete-id${group.getId()}"><img class="delete" src="${pageContext.request.contextPath}/resources/image/trash-empty.png"></a>
                                    </c:if>
                                    </span></li>
                            </c:forEach>
                            <li><a class="list-group-item" href="/create-group"><spring:message code="list.addGroup"/></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-xs-offset-3">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th><spring:message code="list.table1"/></th>
                        <th><spring:message code="list.table2"/></th>
                        <th><spring:message code="list.table3"/></th>
                        <th><spring:message code="list.table4"/></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${contacts}" var="contact">
                        <tr>
                            <td><a href="/contact/id${contact.getId()}">${contact.getFirstName()}</a></td>
                            <td>${contact.getEmail()}</td>
                            <td>${contact.getMobilPhone()}</td>
                            <td>${contact.getAddress().getCityName()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <hr>
        </div>
        <hr>
    </jsp:attribute>
</t:pageLayout>