package com.gep.desarrollos.mirotiseriacliente;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

/**
 * Created by guille on 30/09/2017.
 */

public class Pedido {
    private FirebaseDatabase database=FirebaseDatabase.getInstance();
    private static Pedido pedido = new Pedido();
    private String idCliente;
    private Map  platos;
    private int precioTotal;
    private int idPedido;
    private String hora, fecha;



    public static Pedido getPedido(){
        return pedido;
    }

    public String getCliente() {
        return idCliente;
    }

    public void setCliente(String cliente) {
        idCliente = cliente;
    }

    public Map getPlatos() {
        return platos;
    }

    public void setPlatos(Map platos) {
        this.platos = platos;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
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
