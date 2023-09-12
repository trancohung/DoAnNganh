/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.pojos.Hoa;
import com.mycompany.pojos.User;
import com.mycompany.repository.UserRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
public class UserRepositoryImpl implements UserRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.save(user);
            return true;
        }catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<User> getUsers(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder= session.getCriteriaBuilder();
        CriteriaQuery<User> query= builder.createQuery(User.class);
        Root root= query.from(User.class);
        query= query.select(root);
        
        if(!username.isEmpty()){
            Predicate p = builder.equal(root.get("taiKhoan").as(String.class),username.trim());
            query = query.where(p);
        }
        
        Query q= session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public User getUserById(int userId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(User.class, userId);
    }
    
}
