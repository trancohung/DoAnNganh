<%-- 
    Document   : index
    Created on : Oct 6, 2022, 2:00:57 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div id="demo" class="carousel slide" data-ride="carousel" style="width: 100%">

  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>

  <!-- The slideshow -->
  <div class="carousel-inner" style="height: 600px">
      <div class="carousel-item active" >
      <img src="<c:url value="/images/web-shop-hoa-1.jpg"/>" alt="Hoa" style="height: 600px; width: 100%">
    </div>
    <div class="carousel-item">
      <img src="<c:url value="/images/web-shop-hoa-2.png"/>" alt="Hoa" style="height: 600px; width: 100%">
    </div>
    <div class="carousel-item">
      <img src="<c:url value="/images/web-shop-hoa-3.jpg"/>" alt="Hoa" style="height: 600px; width: 100%">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>

</div>


<form action="">
    <div class="row">
        <div class="col-md-10">
            <input class="form-control" type="text" name="kw" placeholder="Nhap tu khoa de tim"/>
        </div>
        <div>            
            <input type="submit" value="Tim kiếm" class="btn btn-danger"/>            
        </div>
    </div>
</form>
    <div>           
        <ul class="pagination">
            <c:forEach begin="1" end="${Math.ceil(counts/6)}" var="i">
                <li class="page-item"><a class="page-link" href="<c:url value="/" />?page=${i}">${i}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="index-form">
    <div class="row">
        <c:forEach var="p" items="${Hoa}"> 
         <div class="card col-md-4" >
             <div class="card" >
                <div class="card-body bg-light">
                    <a href="<c:url value="/Hoa/${p.maHoa}"/>">
                        <img  style="width: 290px; height: 300px" src="${p.hinhanh}" alt="${p.tenHoa}"/>
                          <c:if test="${p.hinhanh == null || p.hinhanh.startsWith('https')== false}">
                              <img  src="<c:url value="/images/1.jpg"/>" alt="${p.tenHoa}"/>
                          </c:if>
                    </a>
                      <h3>${p.tenHoa}</h3>
                      <p>${p.gia}.000 VND</p>
                </div>
             </div>
                <sec:authorize access="hasRole('ROLE_USER')">
                      <c:if test="${pageContext.request.userPrincipal.name != null}">
                          <div class="card-footer bg-dark">
                              <a href="javascript:;" class="btn btn-danger" onclick="addToCart(${p.maHoa})">Thêm vào giỏ</a>
                               <a href="#" class="btn btn-success">Mua ngay</a>
                          </div>
                      </c:if>
                </sec:authorize>
        </div>

        </c:forEach>
    </div>
</div>