package com.gep.desarrollos.mirotiseriacliente;

/**
 * Created by guille on 01/10/2017.
 */

public interface IModeloCliente {

    /**
     * metodo de registración de la vista como listener
     */

    void agreagarOyenteDelCambio(IVistaCliente iVistaCliente) throws ExcepcionRotiseria;

    /**
     * metodo para agregar o restar plato al pedido
     */
    void agregarRestarPlato(String idPlato)throws ExcepcionRotiseria;

    /**
     * metodo para enviar el pedido a la base de datos
     */
    void enviarPedido(Pedido pedido)throws ExcepcionRotiseria;

    /**
     * metodo que obtiene el precio total del pedido
     * @throws ExcepcionRotiseria
     */
    void getPrecioPedido()throws ExcepcionRotiseria;

    /**
     * metodo que obtiene todos los datos del pedido
     */
    void getPedido()throws ExcepcionRotiseria;

    /**
     * metodo que obtiene el menú de platos de la Rotisería
     */
    void getMenu()throws ExcepcionRotiseria;
}
