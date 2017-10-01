package com.gep.desarrollos.mirotiseriacliente;

import java.util.Map;

/**
 * Created by guille on 30/09/2017.
 */

public class Pedido {

    private Cliente cliente;
    private Map  platos;
    private int precio;
    private int idPedido;
    private String hora, fecha;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Map getPlatos() {
        return platos;
    }

    public void setPlatos(Map platos) {
        this.platos = platos;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
