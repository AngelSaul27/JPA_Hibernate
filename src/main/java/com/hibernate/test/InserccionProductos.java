package com.hibernate.test;

import com.hibernate.model.Producto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class InserccionProductos {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tienda");
        EntityManager em = emf.createEntityManager();

        Producto producto = new Producto("Laptop", "Laptop AMD Ryzen 7", new BigDecimal("1000"), null);

        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
