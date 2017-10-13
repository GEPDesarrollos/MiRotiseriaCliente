package com.gep.desarrollos.mirotiseriacliente;

import com.gep.desarrollos.mirotiseriacliente.modelo.ExcepcionRotiseria;
import com.gep.desarrollos.mirotiseriacliente.modelo.IModeloCliente;
import com.gep.desarrollos.mirotiseriacliente.modelo.Pedido;

/**
 * Created by guille on 30/09/2017.
 */

public interface IVistaCliente {

    /**
     * metodo que registra  al modelo
     */
    void registrarModelo(IModeloCliente modelo)throws ExcepcionRotiseria;

    /**
     * metodo que agrega al Controlador como listener de acciones
     */
     void agregaOyenteAcciones(IControladorCliente iControladorCliente) throws ExcepcionRotiseria;

    /**
     * metodo que refresca la Pantalla
     */
    public void refrescar();

    /**
     * metodo para mostrar en pantalla la pantalla requerida por el Controlador
     * @param object
     */
     void mostrarPantalla(Object object) throws ExcepcionRotiseria;

    /**
     * metodo de manejo de cambio en el modelo
     */
    void manejadorDeCambioModeloCliente(Pedido pedido)throws ExcepcionRotiseria;

}
