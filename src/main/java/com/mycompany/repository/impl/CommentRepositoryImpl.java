/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.pojos.Comment;
import com.mycompany.repository.CommentRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class CommentRepositoryImpl implements CommentRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public Comment addComment(Comment c) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.save(c);
            
            return c;
        }catch (HibernateException ex){
            ex.printStackTrace();
        }
        return null;
    }

//    @Override
//    public List<Comment> getCommentsByLinhkienId(int linhkienid) {
//       Session session = this.sessionFactory.getObject().getCurrentSession();
//       CriteriaBuilder builder= session.getCriteriaBuilder();
//       CriteriaQuery<Comment> query = builder.createQuery( Comment.class);
//        Root root = query.from(Comment.class);
//        query = query.where(builder.equal(root.get("lKid"), linhkienid));
//        query = query.orderBy(builder.desc(root.get("id")));
//        
//        Query q = session.createQuery(query);
//    }
//    
}
