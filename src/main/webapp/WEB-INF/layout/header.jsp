
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
        <a class="nav-link" href="<c:url value="/" />">
            <i class="fa-sharp fa-solid fa-house"></i>
        </a>
    </li>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <li class="nav-item active">
            <a href="<c:url value="/admin/Hoa"/>" class="nav-link">Quản lí hoa</a>
        </li>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <li class="nav-item active">
            <a href="<c:url value="/admin/hoa-stats"/>" class="nav-link">Thống kê</a>
        </li>
    </sec:authorize>
     <c:forEach var="c" items="${Loaihoa}">
        <li class="nav-item">
            <c:url value="/" var="catPath">
                <c:param name="CateID" value="${c.maLoaiHoa}"></c:param>
            </c:url>
            <a class="nav-link" href="${catPath}">${c.tenLoai}</a>
        </li>
    </c:forEach>     
        
        
        
     
    <li class="nav-item active">
        <a class="nav-link" href="<c:url value="/cart"/>">
            <i class="fa-solid fa-cart-shopping"></i>            
            <span class="badge badge-danger" id="cart-counter">${cartCounter}</span>                             
        </a>
    </li>    
        
        
    <c:if test="${pageContext.request.userPrincipal.name ==null}">
        <li class="nav-item active">
            <a class="nav-link text-danger" href="<c:url value="/login"/>">Đăng nhập</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link text-danger" href="<c:url value="/register"/>">Đăng ký</a>
        </li>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name !=null}">
        <li class="nav-item active">
            <a class="nav-link text-danger" href="<c:url value="/"/>">${pageContext.request.userPrincipal.name}</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link text-danger" href="<c:url value="/logout"/>">
                <i class="fa-solid fa-right-from-bracket"></i>
            </a>
        </li>
    </c:if>
      
        
        
    
  </ul>
</nav>