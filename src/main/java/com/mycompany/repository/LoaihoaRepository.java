/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.pojos.Loaihoa;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface LoaihoaRepository {
    List<Loaihoa> getLoaihoa();
    Loaihoa getLoaiHoaById(int cateId);
}
