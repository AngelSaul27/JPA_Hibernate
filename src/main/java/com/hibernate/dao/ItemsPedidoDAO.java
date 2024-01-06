package com.hibernate.dao;

import com.hibernate.model.Cliente;
import com.hibernate.model.ItemsPedido;

import javax.persistence.EntityManager;
import java.util.List;

public class ItemsPedidoDAO {
    private EntityManager em;

    public ItemsPedidoDAO(EntityManager em){
        this.em = em;
    }

    public void guardar(ItemsPedido itemsPedido){
        this.em.persist(itemsPedido);
    }

    public void actualizar(ItemsPedido itemsPedido){
        this.em.merge(itemsPedido);
        this.em.flush();
    }

    public void eliminar(ItemsPedido itemsPedido){
        itemsPedido = this.em.merge(itemsPedido);
        this.em.remove(itemsPedido);
    }

    public List<ItemsPedido> listar(){
        String JPQL  = "SELECT p FROM ItemsPedido p";
        return em.createQuery(JPQL , ItemsPedido.class).getResultList();
    }
}
