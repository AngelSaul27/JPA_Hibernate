package com.hibernate.model;

import javax.persistence.*;

@SuppressWarnings("all")
@Entity
@Table(name = "categorias")
public class Categoria {

    @EmbeddedId
    private CategoriaId categoriaId;

    public Categoria(String nombre){
        this.categoriaId = new CategoriaId(nombre, "123");
    }

    public Categoria() {

    }


    public String getNombre() {
        return this.categoriaId.getNombre();
    }

    public void setNombre(String nombre) {
        this.categoriaId.setNombre(nombre);
    }
}
