<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<spring:message code="title.contacts" var="${contact_title}"/>
<t:pageLayout title="${contact_title}">
    <jsp:attribute name="bodyLayout">
        <div class="container" id="main">
            <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
                <spring:url value="/contact/id{contact_id}/edit" var="edit_url">
                    <spring:param name="contact_id" value="${contact.getId()}"/>
                </spring:url>
                <form:form role="form" cssClass="form-horizontal" modelAttribute="contactForm" action="${edit_url}" method="POST">
                    <h2>Edit contact</h2>
                    <hr class="colorgraph">
                    <spring:bind path="firstName">
                        <div class="form-group">
                            <label for="firstName" class="col-sm-3 col-lg-2 control-label">First Name</label>
                                    <%--<form:errors path="userName" cssClass="error-text"/>--%>
                            <div class="col-sm-9 col-lg-10">
                                <form:input path="firstName" type="text" name="firstName" id="firstName"
                                                cssClass="form-control input-lg"  required="required" placeholder="First Name" tabindex="1" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="lastName">
                        <div class="form-group">
                            <label for="lastName" class="col-sm-3  col-lg-2 control-label">Last Name</label>
                                <%--<form:errors path="userName" cssClass="error-text"/>--%>
                            <div class="col-sm-9 col-lg-10">
                                <form:input path="lastName" type="text" name="lastName" id="lastName"
                                            cssClass="form-control input-lg"  required="required" placeholder="Second Name" tabindex="2" />
                            </div>
                        </div>
                    </spring:bind>
                    <script type="text/javascript">
                        $("#firstName").val("${contact.getFirstName()}");
                        $("#lastName").val("${contact.getLastName()}");
                    </script>
                </form:form>
            </div>
        </div>
        <hr>
    </jsp:attribute>
</t:pageLayout>
