<%-- 
    Document   : cart
    Created on : Oct 7, 2022, 2:56:02 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-danger">Giỏ hàng</h1>
<c:if test="${cart == null}">
    <h4 class="text-danger">Không có sản phẩm nào trong giỏ</h4>
</c:if>
<c:if test="${cart != null}">
    <table class="table">
        <tr>
            <th>Mã sản phẩm</th>
            <th>Tên sản phẩm</th>
            <th>Đơn giá</th>
            <th>Số lượng</th>
        </tr>
        <c:forEach var="c" items="${cart}">
            <tr>
                <td>${c.maHoa}</td>
                <td>${c.name}</td>
                <td>${c.price} VND</td>
                <td>
                    <div class="form-group">
                        <input type="number"  value="${c.count}" class="form-control"/>
                    </div>
                </td>
                <td>
                    <input type="button"
                           onclick="deleteCart(${c.maHoa})"
                           value="Xoa" 
                           class="btn btn-danger"/>
                </td>
            </tr>
        </c:forEach>
    
    </table>
    <div>
        <h4 class="text-info">Tổng tiền hóa đơn <span>${cartStats.amount}</span> </h4>
    </div>
    <input type="button" value="Thanh toán" onclick="pay()" class="btn btn-danger"/>
    <br><br>
</c:if>

