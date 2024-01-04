package com.hibernate.test;

import com.hibernate.modelo.Producto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InserccionProductos {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tienda");
        EntityManager em = emf.createEntityManager();

        Producto producto = new Producto();
        producto.setNombre("Laptop");
        producto.setDescripcion("Laptop AMD Ryzen 7");

        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
