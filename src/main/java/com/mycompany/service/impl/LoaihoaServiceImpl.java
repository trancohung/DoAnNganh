/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.pojos.Loaihoa;
import com.mycompany.repository.LoaihoaRepository;
import com.mycompany.service.LoaihoaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class LoaihoaServiceImpl implements LoaihoaService{
    @Autowired
    private LoaihoaRepository loaihoaRepository;
    
    @Override
    public List<Loaihoa> getLoaihoa() {
        return this.loaihoaRepository.getLoaihoa();
    }

    @Override
    public Loaihoa getLoaiHoaById(int cateId) {
        return this.loaihoaRepository.getLoaiHoaById(cateId);
    }
    
}
