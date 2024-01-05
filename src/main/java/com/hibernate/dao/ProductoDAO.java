package com.hibernate.dao;


import com.hibernate.model.Producto;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    private EntityManager em;

    public ProductoDAO(EntityManager em){
        this.em = em;
    }

    public void guardar(Producto producto){
        this.em.persist(producto);
    }

    public void actualizar(Producto producto, Long id){


        this.em.persist(producto);
    }

    public void eliminar(Long id){

    }

   public List<Producto> listar(){

        return new ArrayList<>();
   }

}
