<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:pageLayout title="Главная">
    <jsp:attribute name="bodyLayout">
        <div class="col-xs-offset-12">
            <a class="btn btn-primary" href="#"> Add New</a>
        </div>
        <div class="col-xs-3">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Group</h3>
                </div>
                <div class="panel-body">
                    <ul>
                        <c:forEach items="${groups}" var="group">
                            <li><a href="#" class="list-group-item">${group.getGroupName()}</a></li>
                        </c:forEach>
                        <li><a class="list-group-item" href="#">Custom Group</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-xs-offset-3">
            <table class="table table-striped">
                   <thead>
                   <tr>
                       <th>First Name</th>
                       <th>Email</th>
                       <th>Phone</th>
                       <th>City</th>
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
    </jsp:attribute>
</t:pageLayout>