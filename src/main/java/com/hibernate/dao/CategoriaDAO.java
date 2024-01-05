package com.hibernate.dao;

import com.hibernate.model.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDAO {

    private EntityManager em;

    public CategoriaDAO (EntityManager em){
        this.em = em;
    }

    public void guardar(Categoria categoria){
        this.em.persist(categoria);
    }

}
