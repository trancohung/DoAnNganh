<%-- 
    Document   : register
    Created on : Oct 9, 2022, 3:02:24 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="register-form">
    
    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">
           ${errMsg}
        </div>
    </c:if>

    <c:url value="/register" var="action"/>    
    <form:form method="post" action="${action}" modelAttribute="user">
        <h1 class="text-center text-danger">Đăng Ký</h1>
        <div class="form-group">
            <label for="ho">Họ</label>
            <form:input type="text" id="ho" path="ho" class="form-control"/>
        </div>
         <div class="form-group">
            <label for="ten">Tên</label>
            <form:input type="text" id="ten" path="ten" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <form:input type="text" id="email" path="email" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="sdt">Số điện thoại</label>
            <form:input type="text" id="sdt" path="sdt" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="taiKhoan">Username</label>
            <form:input type="text" id="taiKhoan" path="taiKhoan" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="matKhau">Password</label>
            <form:input type="password" id="matKhau" path="matKhau" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="confirm-password">Comfirm Password</label>
            <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control"/>
        </div>
        <div class="form-group">
            <input type="submit" value="Đăng ký" class="btn btn-danger"/>
        </div>
    </form:form>>
</div>