/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface StatsRepository {
    List<Object[]> hoaStats(String kw, Date fromDate, Date toData);
}