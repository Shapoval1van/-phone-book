<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:pageLayout title="Главная">
    <jsp:attribute name="bodyLayout">
        <div class="container">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title"><spring:message code="contact.show.title"/> </h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <span class="col-sm-offset-4 col-md-offset-4 col-lg-2 font-bold">
                            <spring:message code="contact.show.firstName"/></span>
                        <span class="font-primary">${contact.getFirstName()}</span>
                    </div>
                    <div class="row">
                        <span class="col-sm-offset-4 col-md-offset-4 col-lg-2 font-bold">
                            <spring:message code="contact.show.secondName"/> </span>
                        <span class="font-primary">${contact.getLastName()}</span>
                    </div>
                    <div class="row">
                        <span class="col-sm-offset-4 col-md-offset-4  col-lg-2 font-bold">
                            <spring:message code="contact.show.modil"/> </span>
                        <span class="font-primary">${contact.getMobilPhone()}</span>
                    </div>
                    <div class="row">
                        <span class="col-sm-offset-4 col-md-offset-4  col-lg-2 font-bold">
                            <spring:message code="contact.show.home"/></span>
                        <span class="font-primary">${contact.getHomePhone()}</span>
                    </div>
                    <div class="row">
                        <span class="col-sm-offset-4 col-md-offset-4  col-lg-2 font-bold">
                            <spring:message code="contact.show.email"/></span>
                        <span class="font-primary">${contact.getEmail()}</span>
                    </div>
                    <div class="row">
                        <span class="col-sm-offset-4 col-md-offset-4  col-lg-2 font-bold">
                            <spring:message code="contact.show.country"/></span>
                        <span class="font-primary">${contact.getAddress().getCountryName()}</span>
                    </div>
                    <div class="row">
                        <span class="col-sm-offset-4 col-md-offset-4  col-lg-2 font-bold">
                            <spring:message code="contact.show.city"/></span>
                        <span class="font-primary">${contact.getAddress().getCityName()}</span>
                    </div>
                    <div class="row">
                        <span class="col-sm-offset-4 col-md-offset-4  col-lg-2 font-bold">
                            <spring:message code="contact.show.street"/></span>
                        <span class="font-primary">${contact.getAddress().getStreetsName()}</span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-3 col-xs-offset-4">
                    <a class="btn btn-default" href="/contact"><spring:message code="contact.show.back"/> </a>
                </div>
                <div class="col-xs-3 ">
                    <a class="btn btn-primary" href="#"><spring:message code="contact.show.edit"/> </a>
                </div>
            </div>
        </div>
    <hr>
    </jsp:attribute>
</t:pageLayout>