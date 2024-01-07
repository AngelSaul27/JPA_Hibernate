package com.hibernate.dao;

import com.hibernate.model.Pedido;
import com.hibernate.vo.RelatorioDeVenta;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDAO {
    private EntityManager em;

    public PedidoDAO(EntityManager em){
        this.em = em;
    }

    public void guardar(Pedido pedido){
        this.em.persist(pedido);
    }

    public void actualizar(Pedido pedido){
        this.em.merge(pedido);
        this.em.flush();
    }

    public void eliminar(Pedido pedido){
        pedido = this.em.merge(pedido);
        this.em.remove(pedido);
    }

    public List<Pedido> listar(){
        String JPQL  = "SELECT p FROM Pedido p";
        return em.createQuery(JPQL , Pedido.class).getResultList();
    }

    public BigDecimal valorTotalVendido(){
        String JPQL = "SELECT MAX(P.valorTotal) FROM Pedido P";
        return em.createQuery(JPQL, BigDecimal.class).getSingleResult();
    }

    public List<Object[]> relatorioEventos(){
        String JPQL = "SELECT producto.nombre, SUM(item.cantidad), MAX(pedido.date) " +
                "FROM Pedido pedido " +
                "JOIN pedido.itemsPedidos item " +
                "JOIN item.producto producto " +
                "GROUP BY producto.nombre " +
                "ORDER BY item.cantidad DESC";

        return em.createQuery(JPQL, Object[].class).getResultList();
    }

    public List<RelatorioDeVenta> relatorioEventosVO(){
        String JPQL = "SELECT NEW com.hibernate.vo.RelatorioDeVenta" +
                "(producto.nombre, SUM(item.cantidad), MAX(pedido.date)) " +
                "FROM Pedido pedido " +
                "JOIN pedido.itemsPedidos item " +
                "JOIN item.producto producto " +
                "GROUP BY producto.nombre " +
                "ORDER BY item.cantidad DESC";

        return em.createQuery(JPQL, RelatorioDeVenta.class).getResultList();
    }
}
