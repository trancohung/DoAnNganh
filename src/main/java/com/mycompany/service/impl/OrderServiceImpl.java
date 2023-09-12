/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.pojos.Cart;
import com.mycompany.pojos.User;
import com.mycompany.repository.OrderRepository;
import com.mycompany.service.OrderService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public boolean addReceipt(Map<Integer, Cart> cart, User user) {
        if(cart !=  null)
            return this.orderRepository.addReceipt(cart, user);
        return false;
    }
    
}
