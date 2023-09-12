/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

/* global fetch */

function addToCart(maHoa){
    fetch(`/Webdoannganh/api/cart/${maHoa}`).then(res => res.json()).then(data =>{
        var d = document.getElementById("cart-counter");
        if(d !== null)
            d.innerText =data;
    })
}

function addComment(hoaId){
    fetch("/Webdoannganh/api/add-comment",{
        method:'post',
        body:JSON.stringify({
            "content":document.getElementById("commentId").value,
            "hoaId":  hoaId
        }),
        headers:{
            "Content-Type": "application/json"
        }
    }).then(function(res){
        console.info(res)
        return res.json();
    }).then(function(data){
        console.info(data);
        
        let area = document.getElementById("commentArea");
        area.innerHTML = `
        <div class="row">
            <div class="col-md-2" style="padding: 10px">
                <img class="rounded-circle img-fluid" src="<c:url value="/images/1.jpg"/>"/>
            </div>
            <div class="col-md-10 my-date">
                <p>${data.content}</p>
                <i>${moment(data.createdDate).fromNow()}</i>
            </div>
        </div>
        ` +area.innerHTML 
        location.reload()
    })
}

//function updateCart(obj, productId){
//    fetch("/Webdoannganh/api/add-comment",{
//        method="put"
//        body:JSON.stringify({
//            "c": productId,
//            "tenHoa":  "",
//            "gia": 0,
//            
//        }),
//    })
//}

function deleteCart(maHoa){
    if(confirm("ban co chac muon xoa khong?")== true){
        fetch(`/Webdoannganh/api/cart/${maHoa}`,{
            method:"delete"
        }).then(function(res){
            console.info(res)
            return res.json();
        }).then(function(data){
            let counter = document.getElementById("cart-counter");
            counter.innerText = data
            location.reload()
        }) 
    }
    
}

function pay(){
    if(confirm("ban chac chan thanh toan")== true){
        fetch("/Webdoannganh/api/pay",{
            method: "post"
        }).then(function(res){
            return res.json();
        }).then(function(code){
            console.info(code);
            location.reload();
        })
    }
}