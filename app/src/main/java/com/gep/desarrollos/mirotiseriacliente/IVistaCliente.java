package com.gep.desarrollos.mirotiseriacliente;

/**
 * Created by guille on 30/09/2017.
 */

public interface IVistaCliente {

    /**
     * metodo que agrega al controlador como listener de acciones
     */
     void agregaOyenteAcciones(IControladorCliente iControladorCliente) throws ExcepcionRotiseria;

    /**
     * metodo para mostrar en pantalla el fragment requerido por el controlador
     */
     void mostrarPantalla(Object object) throws ExcepcionRotiseria;

    /**
     * metodo de manejo de cambio en el modelo
     */
    void manejadorDeCambioModeloCliente(Pedido pedido)throws ExcepcionRotiseria;

}
