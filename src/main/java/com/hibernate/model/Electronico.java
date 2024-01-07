package com.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "electonicos")
public class Electronico extends Producto{

    private String modelo;
    private String marca;

    public Electronico(String modelo, String marca) {
        this.modelo = modelo;
        this.marca = marca;
    }

    public Electronico() {

    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
