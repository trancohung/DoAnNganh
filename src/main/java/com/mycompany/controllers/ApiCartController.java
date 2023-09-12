/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.mycompany.utills.Utils;
import com.mycompany.pojos.Cart;
import com.mycompany.pojos.Hoa;
import com.mycompany.pojos.User;
import com.mycompany.service.HoaService;
import com.mycompany.service.OrderService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class ApiCartController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private HoaService hoaService;
    
    @GetMapping("/api/hoas")
    public ResponseEntity<List<Hoa>> listHoas(){
        List<Hoa> hoas = this.hoaService.getHoas("", 1);
        return new ResponseEntity<>(hoas,HttpStatus.OK);
    }
    
    @GetMapping("/api/cart/{maHoa}")
    public ResponseEntity<Integer> cart(@PathVariable(value = "maHoa") Integer maHoa,
            HttpSession session){
        Map<Integer, Cart> cart= (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart == null)
            cart= new HashMap<>();
        
        
        if(cart.containsKey(maHoa) == true){
            //san pham da co trong gio
            Cart c = cart.get(maHoa);
            c.setCount(c.getCount()+1);
        }else{
            //san pham chua co trong gio
            Hoa h= this.hoaService.getHoaByID(maHoa);
            Cart c= new Cart();
            c.setMaHoa(h.getMaHoa());
            c.setName(h.getTenHoa());
            c.setPrice(h.getGia());
            c.setCount(1);
            
            cart.put(maHoa, c);
        }
        
        session.setAttribute("cart", cart);
        
        return new ResponseEntity<>(Utils.countCart(cart),HttpStatus.OK);
//        System.out.println("=== CART =" + Utils.countCart(cart));
    }
    
    @DeleteMapping("/api/cart/{maHoa}")
    public int deleteCartItem(@PathVariable(value = "maHoa") Integer maHoa,HttpSession session){
        Map<Integer, Cart> cart= (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart != null && cart.containsKey(maHoa)){
            cart.remove(maHoa);
            session.setAttribute("cart", cart);
        }
        return Utils.countCart(cart);
    }
    
    @PostMapping("/api/pay")
    public HttpStatus pay(HttpSession session){
        User u = (User) session.getAttribute("currentUser");
        if(this.orderService.addReceipt((Map<Integer, Cart>) session.getAttribute("cart"), u)==true){
            session.removeAttribute("cart");
            return HttpStatus.OK;
        }
            
        return HttpStatus.BAD_REQUEST;
    }
}
    
