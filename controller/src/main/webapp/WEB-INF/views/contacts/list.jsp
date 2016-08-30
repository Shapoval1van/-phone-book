<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<spring:message code="title.contacts" var="contact_title"/>
<t:pageLayout title="${contact_title}">
    <jsp:attribute name="bodyLayout">
        <script type="text/javascript">
            var mass
            function doAjax(id) {
                event.preventDefault();
                var inputText = $("#input_str").val();
                $.ajax({
                    url: 'get-contacts-for-id?id=' + id,
                    type: 'GET',
                    dataType: 'json',
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    success: function (data) {
                        var respContent = "";
                        respContent +='<table class="table table-striped">'+
                        '<thead>'+
                        '<tr>'+
                        '<th><spring:message code="list.table1"/></th>'+
                        '<th><spring:message code="list.table2"/></th>'+
                        '<th><spring:message code="list.table3"/></th>'+
                        '<th><spring:message code="list.table4"/></th>'+
                        '</tr>'+
                        '</thead>'+
                        '<tbody>';
                        data.forEach(function(item, i){
                            var email = item.email==null?"":item.email;
                            var city = item.address.cityName==null?"":item.address.cityName;
                            var contact = '<tr><td><a href="/contact/id'+item.id+'"'+
                            '>'+item.firstName+'</a></td>';
                            contact += '<td>'+email+'</td>'+
                                    '<td>'+item.mobilPhone+'</td>'+
                                    '<td>'+city+'</td></tr>';
                            respContent += contact;
                        })
                        respContent += '</tr>'+
                        '</tbody>'+
                        '</table>';
                        $('.hide-div').css({"display": "none"});
                        $('.show-div').html(respContent);
                        $('.show-div').css({"display": "block"});
                    }
                });
            }
        </script>
        <div id="myModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button class="close" type="button" data-dismiss="modal">×</button>
                        <h4 class="modal-title"><spring:message code="group.delete"/></h4>
                    </div>
                    <div class="modal-body"><spring:message code="group.promp"/></div>
                    <div class="modal-footer"><a class="btn btn-default" href="/delete-id${param.delete}-all"
                                                 type="button"><spring:message code="group.yes"/></a></div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            var hasParam = window.location.href.indexOf('delete');
            if (hasParam != -1) {
                $('#myModal').modal('show');
            } else {
                $('#myModal').modal('hide');
            }
        </script>
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
                                <li><span class="list-group-item"><a href="#"
                                                                     onclick="doAjax(${group.getId()})">${group.getGroupName()}</a>
                                    <c:if test="${group.getDefault() == false}">
                                        <a href="/delete-id${group.getId()}"><img class="delete"
                                                                                  src="${pageContext.request.contextPath}/resources/image/trash-empty.png"></a>
                                    </c:if>
                                    </span></li>
                            </c:forEach>
                            <li><a class="list-group-item" href="/create-group"><spring:message
                                    code="list.addGroup"/></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-xs-offset-3">
                <div class="hide-div">
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
                <div class="show-div">
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
            </div>
            <hr>
    </jsp:attribute>
</t:pageLayout>
