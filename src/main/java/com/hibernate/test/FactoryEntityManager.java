package com.hibernate.test;

import com.hibernate.dao.ProductoDAO;
import com.hibernate.model.Producto;
import com.hibernate.util.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class FactoryEntityManager {
    public static void main(String[] args) {

        EntityManager entityManager = JPAUtils.getEntityManager();
        ProductoDAO productoDAO = new ProductoDAO(entityManager);

        Producto producto = new Producto("Laptop", "Laptop AMD Ryzen 7", new BigDecimal("1000"), null);

        entityManager.getTransaction().begin();
        productoDAO.guardar(producto);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
