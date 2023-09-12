/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.cloudinary.Util;
import com.mycompany.pojos.Cart;
import com.mycompany.utills.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Admin
 */
@Controller
public class CartController {
    @GetMapping("/cart")
    public String cart(Model model, HttpSession session){
        Map<Integer, Cart> cart=(Map<Integer, Cart>) session.getAttribute("cart");
        if(cart != null)
            model.addAttribute("cart",cart.values());
        else
            model.addAttribute("cart",null);
//        model.addAttribute("amount", Utils.sumAmount(cart));
        model.addAttribute("cartStats", Utils.cartStats(cart));
        return "cart";
    }
}
