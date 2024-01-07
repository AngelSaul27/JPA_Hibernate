package com.hibernate.model;

import javax.persistence.Embeddable;

@Embeddable
public class DatosPersonales {
    private String nombre;
    private String DNI;

    public DatosPersonales() {
    }

    public DatosPersonales(String nombre, String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
