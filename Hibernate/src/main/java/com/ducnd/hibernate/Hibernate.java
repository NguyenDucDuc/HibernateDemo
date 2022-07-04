/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.ducnd.hibernate;

import com.ducnd.services.CategoryService;
import com.ducnd.services.ProductService;

/**
 *
 * @author DucND
 */
public class Hibernate {

    public static void main(String[] args) {
        ProductService ps = new ProductService();
        ps.getProducts("iPhone").forEach(product -> System.out.printf("%d - %s\n", product.getId(), product.getName()));
    }
}
