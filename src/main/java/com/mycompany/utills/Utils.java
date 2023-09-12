/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utills;

import com.mycompany.pojos.Cart;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class Utils {
    public static int countCart(Map<Integer, Cart> cart){
        int count =0;
        if(cart!= null){
            for(Cart c: cart.values())
                count+= c.getCount();
        }
        return count;
    }
    public static Long sumAmount(Map<Integer, Cart> cart){
        Long s=0l;
        if(cart!= null){
            for(Cart c: cart.values())
                s+= c.getCount()* c.getPrice();
        }
        
        return s;
    }
    public static Map<String, String> cartStats(Map<Integer, Cart> cart){
        Long s=0l;
        int q= 0 ;
        
        if(cart!= null)
            for(Cart c: cart.values()){
                q += c.getCount();
                s += c.getCount()*c.getPrice();
        }
        Map<String, String> kq= new HashMap<>();
        kq.put("counter", String.valueOf(q));
        kq.put("amount", String.valueOf(s)); 
        return kq;
}
}
