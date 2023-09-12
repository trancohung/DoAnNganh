 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.pojos.Hoadon;
import com.mycompany.pojos.Hoa;
import com.mycompany.repository.StatsRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class StatsRepositoryImpl implements StatsRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Override
    public List<Object[]> hoaStats(String kw, Date fromDate, Date toData) {
       Session session = this.sessionFactory.getObject().getCurrentSession();
    CriteriaBuilder builder= session.getCriteriaBuilder();
    CriteriaQuery<Object[]> query= builder.createQuery(Object[].class);
    Root roothoa= query.from(Hoa.class); 
    Root rootO = query.from(Hoadon.class);
    
//    List<Predicate> predicates= new ArrayList<>();
//    predicates.add(builder.equal(rootO.get("maLK10"), rootlk.get("maLK")));
//    query.where(builder.equal(rootO.get("maLK10"), rootlk.get("maLK")));
//    query.multiselect(rootlk.get("maLK"),rootlk.get("tenLK"),
//            builder.sum(builder.prod(rootO.get("thanhGia"), rootO.get("soLuong"))));
    
//    if(kw != null)
//        predicates.add(builder.like(rootlk.get("tenLK"), kw));
//    if(fromDate != null)
//         predicates.add(builder.greaterThanOrEqualTo(rootO.get("ngayLapHoaDon"), fromDate));
//    if(toData != null)
//         predicates.add(builder.lessThanOrEqualTo(rootO.get("ngayLapHoaDon"), toData));
    
//    query.groupBy(rootlk.get("maHoa"));
//    query.where(predicates.toArray(new Predicate[]{}));
    query.multiselect(roothoa.get("maHoa"), roothoa.get("tenHoa"),builder.sum(builder.prod(rootO.get("thanhGia"), rootO.get("soLuong"))));
    query.where(builder.equal(rootO.get("maHoa10"), roothoa.get("maHoa")));    
    query.groupBy(roothoa.get("maHoa"));
    Query q = session.createQuery(query);

    return q.getResultList();
    }
}
