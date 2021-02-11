package com.rjqdf.ejercicios.ej6.dominio;

import java.util.Date;
import java.util.List;

public class Pedido {

    private String id;
    private int cliente;
    private List<Integer> productos;
    private Date fecha;

    public Pedido(String id, int cliente, List<Integer> productos, Date fecha) {
        this.id = id;
        this.cliente = cliente;
        this.productos = productos;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public List<Integer> getProductos() {
        return productos;
    }

    public void setProductos(List<Integer> productos) {
        this.productos = productos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
