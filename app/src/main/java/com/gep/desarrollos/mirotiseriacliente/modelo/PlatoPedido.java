package com.gep.desarrollos.mirotiseriacliente.modelo;

/**
 * Created by gep on 24/10/17.
 * Clase que sirve para pasarle los datos al RecyclerView del pedido
 */

public class PlatoPedido {

    private int cantidadPedido,subTotal;
    private String nombrePlatoPedido;

    public PlatoPedido(int cantidadPedido, int subTotal, String nombrePlatoPedido) {
        this.cantidadPedido = cantidadPedido;
        this.subTotal = subTotal;
        this.nombrePlatoPedido = nombrePlatoPedido;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this)return true;
        if(obj==null)return false;
        if(!(obj instanceof PlatoPedido))return false;
        PlatoPedido otro=(PlatoPedido)obj;
        if(cantidadPedido==0){
           if (otro.cantidadPedido!=0)return false;
        }else if(cantidadPedido!=otro.cantidadPedido)return false;
        if(subTotal==0){
            if (otro.subTotal!=0)return false;
                        }else if (subTotal!=otro.subTotal)return false;
        if (nombrePlatoPedido==null){
            if (!(otro.nombrePlatoPedido.equals(null)))return false;
        }else if (!(nombrePlatoPedido.equals(otro.nombrePlatoPedido)))return false;
        if ((Integer.toOctalString((Integer)subTotal))!=(Integer.toOctalString((Integer)otro.subTotal)))return false;
        return true;
    }

    public int getCantidadPedido() {
        return cantidadPedido;
    }

    public void setCantidadPedido(int cantidadPedido) {
        this.cantidadPedido = cantidadPedido;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public String getNombrePlatoPedido() {
        return nombrePlatoPedido;
    }

    public void setNombrePlatoPedido(String nombrePlatoPedido) {
        this.nombrePlatoPedido = nombrePlatoPedido;
    }

    @Override
    public String toString() {
        return "PlatoPedido{" +
                "cantidadPedido=" + cantidadPedido +
                ", subTotal=" + subTotal +
                ", nombrePlatoPedido='" + nombrePlatoPedido + '\'' +
                '}';
    }
}
