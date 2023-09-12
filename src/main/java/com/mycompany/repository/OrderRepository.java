/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.pojos.Cart;
import com.mycompany.pojos.User;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface OrderRepository {
    boolean addReceipt(Map<Integer, Cart> cart, User user);
}
