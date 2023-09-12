<%-- 
    Document   : Hoa-detail
    Created on : Oct 11, 2022, 9:52:07 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<h1 class="text-center text-danger">Chi tiet san pham</h1>
<div class="row">
    <div class="col-md-6">
         <img style="width:250px;" src="${Hoa.hinhanh}" alt="${Hoa.tenHoa}"/>
          <c:if test="${Hoa.hinhanh == null || Hoa.hinhanh.startsWith('https')== false}">
               <img class="img-fluid" src="<c:url value="/images/1.jpg"/>" alt="${Hoa.tenHoa}"/>
          </c:if>
    </div>
    <div class="col-md-6">
        <h1>${Hoa.tenHoa}</h1>
        <h3 class="text-danger">${Hoa.gia}.000 VND</h3>
        <p>${Hoa.moTa}</p>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
        <div>
            <sec:authorize access="hasRole('ROLE_USER')">
                <a href="javascript:;" class="btn btn-danger" onclick="addToCart(${Hoa.maHoa})">Thêm vào giỏ</a>
            </sec:authorize>
        </div>
        </c:if>
    </div>
</div>
<br><br>
<form>
    
        <div class="form-group">
            <textarea class="form-control" id="commentId"  placeholder="Nhap danh gia cua ban ve san pham"></textarea>
            <br>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <input type="submit" onclick="addComment(${Hoa.maHoa})"
                       value="Gui binh luan" class="btn btn-danger"/>
            </c:if>
             <c:if test="${pageContext.request.userPrincipal.name == null}">
                <p style="margin: 7px; text-align: center; color: red; font-size: large">Dang nhap de binh luan ben duoi</p>
            </c:if>
</div>
</form>
           <div id="commentArea">
                <c:forEach items="${Hoa.commentCollection}" var="comment">
                    <div class="row">
                        <div class="col-md-2" style="padding: 10px">
                            <img class="rounded-circle img-fluid" src="<c:url value="/images/1.jpg"/>"/>
                        </div>
                        <div class="col-md-10">
                            <p>${comment.content}</p>
                            <i>${comment.createdDate}</i>
                        </div>
                    </div>
                </c:forEach>
            </div>           
<script>
   window.onload = function(){
       let dates = document.querySelectorAll(".my-date > i")
       for (let i = 0; i< dates.length; i++){
           let d = dates[i]
           d.innerText = moment(d.innerText).fromNow()
       } 
   }
</script>
