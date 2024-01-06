package com.hibernate.dao;

import com.hibernate.model.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

@SuppressWarnings("all")

public class CategoriaDAO {

    private EntityManager em;

    public CategoriaDAO (EntityManager em){
        this.em = em;
    }

    public void guardar(Categoria categoria){
        this.em.persist(categoria);
    }

    public void actualizar(Categoria categoria){
        this.em.merge(categoria);
    }

    public void remover(Categoria categoria){
        categoria =  this.em.merge(categoria);
        this.em.remove(categoria);
    }

    public List<Categoria> listar(){
        String JPQL  = "SELECT c FROM Categoria c";
        return this.em.createQuery(JPQL , Categoria.class).getResultList();
    }

    public  Categoria consultaPorNombre(String nombre){
        String JPQL = "SELECT c FROM Categoria AS C WHERE C.nombre=:nombre";
        return em.createQuery(JPQL, Categoria.class).setParameter("nombre", nombre).getSingleResult();
    }
}
