package com.hibernate.dao;

import com.hibernate.model.Cliente;
import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDAO {
    private EntityManager em;

    public ClienteDAO(EntityManager em){
        this.em = em;
    }

    public void guardar(Cliente cliente){
        this.em.persist(cliente);
    }

    public void actualizar(Cliente cliente){
        this.em.merge(cliente);
        this.em.flush();
    }

    public void eliminar(Cliente cliente){
        cliente = this.em.merge(cliente);
        this.em.remove(cliente);
    }

    public List<Cliente> listar(){
        String JPQL  = "SELECT p FROM Cliente p";
        return em.createQuery(JPQL , Cliente.class).getResultList();
    }
}
