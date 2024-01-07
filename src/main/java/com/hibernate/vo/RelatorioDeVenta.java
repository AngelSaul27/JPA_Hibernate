package com.hibernate.vo;

import java.time.LocalDate;

public class RelatorioDeVenta {
    private String nombreProducto;
    private Long cantidadTotal;
    private LocalDate fechaMaximaPedido;


    public RelatorioDeVenta(String nombreProducto, Long cantidadTotal, LocalDate fechaMaximaPedido) {
        this.nombreProducto = nombreProducto;
        this.cantidadTotal = cantidadTotal;
        this.fechaMaximaPedido = fechaMaximaPedido;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Long getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(Long cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public LocalDate getFechaMaximaPedido() {
        return fechaMaximaPedido;
    }

    public void setFechaMaximaPedido(LocalDate fechaMaximaPedido) {
        this.fechaMaximaPedido = fechaMaximaPedido;
    }

    @Override
    public String toString() {
        return "RelatorioDeVenta{" +
                "nombreProducto='" + nombreProducto + '\'' +
                ", cantidadTotal=" + cantidadTotal +
                ", fechaMaximaPedido=" + fechaMaximaPedido +
                '}';
    }
}
