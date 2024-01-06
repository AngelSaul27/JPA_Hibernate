package com.hibernate.test;

import com.hibernate.dao.CategoriaDAO;
import com.hibernate.dao.ProductoDAO;
import com.hibernate.model.Categoria;
import com.hibernate.model.Producto;
import com.hibernate.util.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

@SuppressWarnings("ALL")
public class RegistroDeProducto {

    public static void main(String[] args) {
        registrarProducto();
        EntityManager em = JPAUtils.getEntityManager();
        ProductoDAO productoDao = new ProductoDAO(em);
        Producto producto = productoDao.consultaPorId(1l);
        System.out.println(producto.getNombre());

        BigDecimal precio = productoDao.consultarPrecioPorNombreDeProducto("Xiaomi Redmi");
        System.out.println(precio);

    }

    private static void registrarProducto() {
        Categoria celulares = new Categoria("CELULARES");

        Producto celular = new Producto("Xiaomi Redmi", "Muy bueno", new BigDecimal("800"), celulares);

        EntityManager em = JPAUtils.getEntityManager();
        ProductoDAO productoDao = new ProductoDAO(em);
        CategoriaDAO categoriaDao = new CategoriaDAO(em);

        em.getTransaction().begin();

        categoriaDao.guardar(celulares);
        productoDao.guardar(celular);

        em.getTransaction().commit();
        em.close();
    }

}
