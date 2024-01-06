package com.hibernate.dao;


import com.hibernate.model.Producto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

@SuppressWarnings("all")
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

   public List<Producto> listarPorNombre(String nombre){
        String JPQL = "SELECT P FROM Producto AS P WHERE nombre=:nombre";
        return em.createQuery(JPQL, Producto.class).setParameter("nombre", nombre).getResultList();
   }

   public List<Producto> listarPorNombreDeCategoria(String categoriaNombre){
        String JPQL = "SELECT P FROM Producto AS P WHERE P.categoria.nombre =:nombre";
        return em.createQuery(JPQL,Producto.class).setParameter("nombre", categoriaNombre).getResultList();
   }

   public BigDecimal consultarPrecioPorNombreDeProducto(String nombre){
        String JPQL = "SELECT P.precio FROM Producto AS P WHERE P.nombre = :nombre";
        return em.createQuery(JPQL, BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
   }

    public Producto consultaPorId(Long id) {
        return em.find(Producto.class, id);
    }
}
