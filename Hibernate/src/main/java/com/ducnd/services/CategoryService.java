/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.services;

import com.ducnd.hibernate.HibernateUtils;
import com.ducnd.pojo.Category;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.service.Service;

/**
 *
 * @author DucND
 */
public class CategoryService {
    public List<Category> getCategory(){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Category> q = b.createQuery(Category.class);
        Root root = q.from(Category.class);
        q.select(root);
        
        Query query = session.createQuery(q);
        return query.getResultList();
    }
}
