<%-- 
    Document   : login
    Created on : Oct 9, 2022, 2:01:56 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/register" var="register"/>
<div class="login-form">
    
    <c:if test="${param.error != null}">
        <div class="alert alert-danger">
            Username hoặc password không đúng
        </div>
    </c:if>
    <c:if test="${param.accessDenied != null}">
        <div class="alert alert-danger">
            Ban không có quyền truy cập
        </div>
    </c:if>
    <c:url value="/login" var="action"/>
    <form method="post" action="${action}">
        <h1 class="text-center text-danger">Đăng nhập</h1>
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" class="form-control"/>
        </div>
        <div class="form-group ">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" class="form-control"/>
        </div>
        <div class="form-group ">
            <input type="submit" value="Đăng nhập" class="btn btn-danger"/>
        </div>
        <div class="text-center">
            <p>Bạn chưa có tài khoản<a href="${register}"> Đăng ký ngay</a></p>
        </div>
    </form>
        
</div>