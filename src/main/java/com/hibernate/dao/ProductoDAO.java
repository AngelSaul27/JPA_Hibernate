package com.hibernate.dao;


import com.hibernate.model.Producto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProductoDAO {

    private EntityManager em;

    public ProductoDAO(EntityManager em){
        this.em = em;
    }

    public void guardar(Producto producto){
        this.em.persist(producto);
    }

    public void actualizar(Producto producto){
        this.em.merge(producto);
        this.em.flush();
    }

    public void eliminar(Producto producto){
        producto = this.em.merge(producto);
        this.em.remove(producto);
    }

   public List<Producto> listar(){
        String JPQL  = "SELECT p FROM Producto p";
       return em.createQuery(JPQL , Producto.class).getResultList();
   }

}
