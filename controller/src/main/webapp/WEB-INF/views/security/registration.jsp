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
       <div class="container">

           <div class="row">
               <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
                   <form role="form" action="/registration" method="post">
                       <h2><spring:message code="reg.title"/></h2>
                       <hr class="colorgraph">
                       <div class="form-group">
                          <spring:message code="login.username" var="Username"/>
                           <input type="text" name="user_name" id="user_name" class="form-control input-lg" placeholder="${Username}" tabindex="1" required>
                       </div>
                       <div class="row">
                           <div class="col-xs-6 col-sm-6 col-md-6">
                               <div class="form-group">
                                   <spring:message code="login.password" var="Password"/>
                                   <input type="password" name="password" id="password" class="form-control input-lg" placeholder="${Password}" tabindex="5" required>
                               </div>
                           </div>
                           <div class="col-xs-6 col-sm-6 col-md-6">
                               <div class="form-group">
                                   <spring:message code="reg.confPas" var="ConfirmPassword"/>
                                   <input type="password" name="password_confirmation" id="password_confirmation" class="form-control input-lg" placeholder="${ConfirmPassword}" tabindex="6" required>
                               </div>
                           </div>
                       </div>
                       <span class="label label-primary" name = "prompt">${prompt}</span>
                       <hr class="colorgraph">
                       <div class="row">
                           <spring:message code="login.registration" var="registration"/>
                           <div class="col-xs-6 col-md-6"><a href="/login" class="btn btn-primary btn-block btn-lg"><spring:message code="reg.button"/></a></div>
                           <div class="col-xs-6 col-md-6"><input type="submit" value="${registration}" class="btn btn-success btn-block btn-lg" tabindex="7"></div>
                       </div>
                   </form>
               </div>
           </div>
       </div>
    </jsp:attribute>
</t:pageLayout>