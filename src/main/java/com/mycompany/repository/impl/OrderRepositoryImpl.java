/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.pojos.Cart;
import com.mycompany.pojos.Chitiethd;
import com.mycompany.pojos.Hoadon;
import com.mycompany.pojos.User;
import com.mycompany.repository.HoaRepository;
import com.mycompany.repository.OrderRepository;
import com.mycompany.repository.UserRepository;
import com.mycompany.utills.Utils;
import java.util.Date;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    private UserRepository userRepository;   
    @Autowired
    private HoaRepository hoaRepository;
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addReceipt(Map<Integer, Cart> cart, User user) {
        try{
            Session session = this.sessionFactory.getObject().getCurrentSession();
            Chitiethd cthd= new Chitiethd();
            cthd.setIduser(user);
            Map<String, String> stats1 = Utils.cartStats(cart);
            cthd.setTongtien(Long.parseLong(stats1.get("amount")));
            session.save(cthd);
        for(Cart c: cart.values()){
            Hoadon hd= new Hoadon();
            hd.setMaKH(user);
            hd.setNgayLapHoaDon(new Date());
            hd.setNgayGiao(new Date());
            Map<String, String> stats = Utils.cartStats(cart);
            hd.setThanhGia(c.getPrice());
            hd.setMaHDKN1(cthd);
            hd.setSoLuong(c.getCount());
            hd.setMaHoa10(hoaRepository.getHoaByID(c.getMaHoa()));
            session.save(hd);
        }
            return true;
        }catch (HibernateException ex){
            ex.printStackTrace();
        }
        
        
        return false;
    }
    
}
