/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.pojos.Loaihoa;
import com.mycompany.repository.LoaihoaRepository;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class LoaihoaRepositoryImpl implements LoaihoaRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Loaihoa> getLoaihoa() {
        Session s = sessionFactory.getObject().getCurrentSession();
        javax.persistence.Query q= s.createQuery("From Loaihoa");
        return q.getResultList();        
    }

    @Override
    public Loaihoa getLoaiHoaById(int cateId) {
         Session s = sessionFactory.getObject().getCurrentSession();
         return s.get(Loaihoa.class,cateId);
    }
    
}
