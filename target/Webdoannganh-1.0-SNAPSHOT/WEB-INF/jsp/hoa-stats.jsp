<%-- 
    Document   : hoa-stats
    Created on : Oct 14, 2022, 2:10:54 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="bg-info text-white text-center">Thống kê doanh thu theo hoa</h1>
<form action="">
    <div class="form-group">
        <label>Tu khóa</label>
        <input type="text" name="kw" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Từ thời điểm</label>
        <input type="date" name="fromDate" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Đến thời điểm</label>
        <input type="date" name="toDate" class="form-control"/>
    </div>
    <input type="submit" value="Bao cao" class="btn btn-success"/>
</form>

<div>
    <canvas id="myHoaStartsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Doanh thu</th>
    </tr>
    <c:forEach items="${hoaStats}" var="h">
        <tr>
            <td>${h[0]}</td>
            <td>${h[1]}</td>
            <td>${h[2]} VND</td>
        </tr>
    </c:forEach>
</table>
<script>
    let hlabels =[], hinfo=[]
    
    <c:forEach items="${hoaStats}" var="h">
        hlabels.push('${h[1]}')
        hinfo.push(${h[2]})
    </c:forEach>
    
    window.onload = function (){
        hoaChart("myHoaStartsChart",hlabels, hinfo)
    }
</script>


