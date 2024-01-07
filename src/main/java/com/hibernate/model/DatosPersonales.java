package com.hibernate.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DatosPersonales implements Serializable {
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
