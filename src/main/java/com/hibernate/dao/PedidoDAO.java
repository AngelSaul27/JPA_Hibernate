package com.hibernate.dao;

import com.hibernate.model.Pedido;

import javax.persistence.EntityManager;
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
}
