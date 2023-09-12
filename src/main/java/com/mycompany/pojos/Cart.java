/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojos;

import java.math.BigDecimal;

/**
 *
 * @author Admin
 */
public class Cart {
    private int maHoa;
    private String Name;
    private long price;
    private int count;

    /**
     * @return the maHoa
     */
    public int getMaHoa() {
        return maHoa;
    }

    /**
     * @param maHoa the maHoa to set
     */
    public void setMaHoa(int maHoa) {
        this.maHoa = maHoa;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the price
     */
    public long getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(long price) {
        this.price = price;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }
}
