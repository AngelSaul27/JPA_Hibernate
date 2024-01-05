package com.hibernate.test;

import com.hibernate.dao.CategoriaDAO;
import com.hibernate.dao.ProductoDAO;
import com.hibernate.model.Categoria;
import com.hibernate.model.Producto;
import com.hibernate.util.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class ProductoManyToOne {

    public static void main(String[] args) {
        Categoria categoria = new Categoria("Computo");
        Producto producto = new Producto("Laptop", "Lapton Ryzen", new BigDecimal("1000"), categoria);

        EntityManager entityManager = JPAUtils.getEntityManager();
        ProductoDAO productoDAO = new ProductoDAO(entityManager);
        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);

        entityManager.getTransaction().begin();
        categoriaDAO.guardar(categoria);
        productoDAO.guardar(producto);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
