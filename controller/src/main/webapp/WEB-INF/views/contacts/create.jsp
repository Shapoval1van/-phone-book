<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<spring:message code="contact.show.edit" var="${edit_title}"/>
<t:pageLayout title="${edit_title}">
    <jsp:attribute name="bodyLayout">
        <div class="container" id="main">
            <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
                <spring:url value="/contact/create" var="create_url"/>
                <form:form role="form" commandName="contactForm" cssClass="form-horizontal" action="${create_url}" method="POST">
                    <h2><spring:message code="create.title"/></h2>
                    <hr class="colorgraph">
                    <spring:bind path="firstName" >
                        <div class="form-group">
                            <spring:message code="contact.show.firstName" var="FN"/>
                            <label for="firstName" class="col-sm-3 col-lg-2 control-label">${FN}</label>
                            <form:errors path="firstName" cssClass="error-text"/>
                            <div class="col-sm-9 col-lg-10">
                                <form:input path="firstName" type="text" name="firstName" id="firstName"
                                            cssClass="form-control input-lg"  required="required" placeholder="${FN}" tabindex="1" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="lastName">
                        <div class="form-group">
                            <spring:message code="contact.show.secondName" var="SN"/>
                            <label for="lastName" class="col-sm-3  col-lg-2 control-label">${SN}</label>
                            <form:errors path="lastName" cssClass="error-text"/>
                            <div class="col-sm-9 col-lg-10">
                                <form:input path="lastName" type="text" name="lastName" id="lastName"
                                            cssClass="form-control input-lg"  required="required" placeholder="${SN}" tabindex="2" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="homePhone">
                        <div class="form-group">
                            <spring:message code="contact.show.home" var="HP"/>
                            <label for="homePhone" class="col-sm-3  col-lg-2 control-label">${HP}</label>
                            <form:errors path="homePhone" cssClass="error-text"/>
                            <div class="col-sm-9 col-lg-10">
                                <form:input path="homePhone" type="text" name="homePhone" id="homePhone"
                                            cssClass="form-control input-lg"  placeholder="${HP}" tabindex="3" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="mobilPhone">
                        <div class="form-group">
                            <spring:message code="contact.show.modil" var="MP"/>
                            <label for="mobilPhone" class="col-sm-3  col-lg-2 control-label">${MP}</label>
                            <form:errors path="mobilPhone" cssClass="error-text"/>
                            <div class="col-sm-9 col-lg-10">
                                <form:input path="mobilPhone" type="text" name="mobilPhone" id="mobilPhone"
                                            cssClass="form-control input-lg" required="required" placeholder="${MP}" tabindex="4" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="email">
                        <div class="form-group">
                            <spring:message code="contact.show.email" var="email"/>
                            <label for="mobilPhone" class="col-sm-3  col-lg-2 control-label">${email}</label>
                            <form:errors path="email" cssClass="error-text"/>
                            <div class="col-sm-9 col-lg-10">
                                <form:input path="email" type="email" name="email" id="email"
                                            cssClass="form-control input-lg" required="required" placeholder="${email}" tabindex="4" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="address.countryName">
                        <spring:message code="contact.show.country" var="country"/>
                        <div class="form-group">
                            <label for="country" class="col-sm-3  col-lg-2 control-label">${country}</label>
                            <form:errors path="address.countryName" cssClass="error-text"/>
                            <div class="col-sm-9 col-lg-10">
                                <form:input path="address.countryName" type="text" name="country" id="country"
                                            cssClass="form-control input-lg" required="required" placeholder="${country}" tabindex="5" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="address.cityName">
                        <div class="form-group">
                            <spring:message code="contact.show.city" var="city"/>
                            <label for="city" class="col-sm-3  col-lg-2 control-label">${city}</label>
                            <form:errors path="address.cityName" cssClass="error-text"/>
                            <div class="col-sm-9 col-lg-10">
                                <form:input path="address.cityName" type="text" name="city" id="city"
                                            cssClass="form-control input-lg" placeholder="${city}" tabindex="7" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="address.streetsName">
                        <spring:message code="contact.show.street" var="streets"/>
                        <div class="form-group">
                            <label for="streets" class="col-sm-3  col-lg-2 control-label">${streets}</label>
                            <form:errors path="address.streetsName" cssClass="error-text"/>
                            <div class="col-sm-9 col-lg-10">
                                <form:input path="address.streetsName" type="text" name="streets" id="streets"
                                            cssClass="form-control input-lg" placeholder="${streets}" tabindex="8" />
                            </div>
                        </div>
                    </spring:bind>
                    <spring:bind path="group.id">
                        <div class="form-group">
                            <spring:message code="list.group" var="group"/>
                            <label for="streets" class="col-sm-3  col-lg-2 control-label">${group}</label>
                            <div class="col-sm-9 col-lg-10">
                                <form:select cssClass="form-control input-lg" path="group.id">
                                    <form:option  value="" label="  "/>
                                    <form:options items="${groups}" itemValue="id" itemLabel="groupName"/>
                                </form:select>
                                    <%--<form:input path="group.groupName" type="text" name="streets" id="streets"
                                                cssClass="form-control input-lg" placeholder="${streets}" tabindex="8" />--%>
                            </div>
                        </div>
                    </spring:bind>
                    <div class="row">
                        <spring:message code="create.button" var="edit"/>
                            <%--<div class="col-xs-6 col-md-6"><a href="/login" class="btn btn-primary btn-block btn-lg"><spring:message code="reg.button"/></a></div>--%>
                        <div ><input type="submit" value="${edit}" class="btn btn-success btn-block btn-lg" tabindex="8"></div>
                    </div>
                </form:form>
            </div>
        </div>
        <hr>
    </jsp:attribute>
</t:pageLayout>
