<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:pageLayout title="Главная">
    <jsp:attribute name="bodyLayout">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title">Contact</h3>
            </div>
            <div class="panel-body">
                <table class="table table-striped">
                    <tr>
                        <td><span class="font-bold"> FirstName: </span></td>
                        <td><span class="font-primary">${contact.getFirstName()}</span></td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-3 col-xs-offset-4">
                <a class="btn btn-default" href="#">Back</a>
            </div>
            <div class="col-xs-3 ">
                <a class="btn btn-primary" href="#">Edit</a>
            </div>
        </div>
    <hr>
    </jsp:attribute>
</t:pageLayout>