package com.hibernate.test;

import com.hibernate.dao.CategoriaDAO;
import com.hibernate.dao.ClienteDAO;
import com.hibernate.dao.PedidoDAO;
import com.hibernate.dao.ProductoDAO;
import com.hibernate.model.*;
import com.hibernate.util.JPAUtils;
import com.hibernate.vo.RelatorioDeVenta;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ConsultasAvanzadas {

    public static void main(String[] args) {
        registrarProducto();
        EntityManager entityManager = JPAUtils.getEntityManager();
        ProductoDAO productoDao = new ProductoDAO(entityManager);
        PedidoDAO pedidoDAO = new PedidoDAO(entityManager);
        ClienteDAO clienteDAO = new ClienteDAO(entityManager);

        Producto producto = productoDao.consultaPorId(1L);
        Cliente cliente = new Cliente("Juan", "KK5DASD3");
        Pedido pedido = new Pedido(cliente);
        pedido.agregarItems(new ItemsPedido(5, producto, pedido));

        entityManager.getTransaction().begin();
        clienteDAO.guardar(cliente);
        pedidoDAO.guardar(pedido);
        entityManager.getTransaction().commit();

        BigDecimal valorTotal = pedidoDAO.valorTotalVendido();
        System.out.println(valorTotal);

        List<Object[]> relatorio = pedidoDAO.relatorioEventos();
        for (Object[] objects: relatorio){
            System.out.print(objects[0]);
            System.out.print(objects[1] + " ");
            System.out.print(objects[2] + "\n");
        }

        List<RelatorioDeVenta> relatorioDeVentas = pedidoDAO.relatorioEventosVO();
        relatorioDeVentas.forEach(System.out::println);
    }
    private static void registrarProducto() {
        EntityManager em = JPAUtils.getEntityManager();
        ProductoDAO productoDao = new ProductoDAO(em);

        Categoria celulares = new Categoria("CELULARES");
        Producto celular = new Producto("Xiaomi Redmi", "Muy bueno", new BigDecimal("800"), celulares);
        CategoriaDAO categoriaDao = new CategoriaDAO(em);

        em.getTransaction().begin();

        categoriaDao.guardar(celulares);
        productoDao.guardar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
