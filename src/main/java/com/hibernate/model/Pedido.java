package com.hibernate.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("all")

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date = LocalDate.now();
    private BigDecimal valorTotal = new BigDecimal(0);
    @ManyToOne
    private Cliente cliente;

    /*
        @ManyToMany solo cuando la impletación es sencilla (producto_id y pedido_id)
        @JoinTable(name = "item_pedido") para evitar la creación de un entity
        private List<Productos> productos;
    */

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL) //ManyToOne OneToMany
    private List<ItemsPedido> itemsPedidos = new ArrayList<>();

    public Pedido(Cliente cliente){
        this.cliente = cliente;
    }

    //Relación bidireccional
    public void agregarItems(ItemsPedido itemsPedido){
        itemsPedido.setPedido(this); //Añadimos el pedido a items pedido
        this.itemsPedidos.add(itemsPedido); //Añadimos el item pedido a la lista pedidos
        this.valorTotal = this.valorTotal.add(itemsPedido.getValor());
    }

    public Pedido(){}

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
