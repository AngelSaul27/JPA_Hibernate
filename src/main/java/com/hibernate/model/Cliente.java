package com.hibernate.model;

import javax.persistence.*;

@SuppressWarnings("all")

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private DatosPersonales datosPersonales;

    public Cliente(){

    }

    public Cliente(String nombre, String dni) {
        this.datosPersonales = new DatosPersonales(nombre, dni);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.datosPersonales.getNombre();
    }

    public void setNombre(String nombre) {
        this.datosPersonales.setNombre(nombre);
    }

    public String getDni() {
        return this.datosPersonales.getDNI();
    }

    public void setDni(String dni) {
        this.datosPersonales.setDNI(dni);
    }
}
