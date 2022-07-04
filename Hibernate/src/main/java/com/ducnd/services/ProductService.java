/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.services;

import com.ducnd.hibernate.HibernateUtils;
import com.ducnd.pojo.Product;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author DucND
 */
public class ProductService {
    public List<Product> getProducts(String kw){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Product> q = b.createQuery(Product.class);
        Root root = q.from(Product.class);
        q.select(root);
        
        if(kw!=null && !kw.isEmpty()){
            Predicate p = b.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
            q.where(p);
        }
        
        Query query = session.createQuery(q);
        return query.getResultList();
    }
}
