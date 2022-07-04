/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ducnd.hibernate;

import com.ducnd.pojo.Category;
import com.ducnd.pojo.Product;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author DucND
 */
public class HibernateUtils {
    private static final SessionFactory FACTORY;
    
    static{
        Configuration conf = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties props = new Properties();
                props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                props.put(Environment.URL, "jdbc:mysql://localhost:3306/saledb");
                props.put(Environment.USER, "root");
                props.put(Environment.PASS, "password");
                props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                props.put(Environment.SHOW_SQL, "true");


                conf.setProperties(props);
                conf.addAnnotatedClass(Category.class);
                conf.addAnnotatedClass(Product.class);


                ServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .applySettings(conf.getProperties()).build();

                FACTORY = conf.buildSessionFactory(registry);
    }

    /**
     * @return the FACTORY
     */
    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
    
    
}
