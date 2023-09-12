<%-- 
    Document   : Hoa
    Created on : Oct 7, 2022, 3:35:19 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/admin/Hoa" var="action"/>
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
<div class="hoa-form">
    <form:form method="post" action="${action}" modelAttribute="Hoa" 
               enctype="multipart/form-data">
        <h1 class="text-center text-danger">Quản lí hoa</h1>
        <form:errors path="*" cssClass="alert alert-danger" element="div"/>
        <div class="form-group">
            <label for="tenHoa">Tên</label>
            <form:input type="text"  path="tenHoa" id="tenHoa" cssClass="form-control"/>
            <form:errors path="tenHoa" cssClass="alert alert-danger" element="div"/>
        </div>
         <div class="form-group">
            <label for="moTa">Mô Tả</label>
            <form:textarea  path="moTa" id="moTa" cssClass="form-control"></form:textarea>
        </div>
        <div class="form-group">
            <label for="gia">Giá</label>
            <form:input type="text"  path="gia" id="gia" cssClass="form-control"/>
            <form:errors path="gia" cssClass="alert alert-danger" element="div"/>
        </div>
        <div class="form-group">
            <label for="maLoai">Danh mục</label>
            <form:select path="maLoai" id="maLoai" cssClass="form-control">
                <c:forEach items="${Loaihoa}" var="cat">
                    <option value="${cat.maLoaiHoa}">${cat.tenLoai}</option>
                </c:forEach>
            </form:select>
            <form:errors path="maLoai" cssClass="alert alert-danger" element="div"/>
        </div>
        <div class="form-group">
            <label for="file">Ảnh sản phẩm</label>
            <form:input type="file"  path="file" id="file" cssClass="form-control"/>
        </div>
        <div>
            <input type="submit" value="Them hoa" class="btn btn-danger"/>
        </div>
    </form:form>
</div>