package com.gep.desarrollos.mirotiseriacliente.modelo;

import com.gep.desarrollos.mirotiseriacliente.IVistaCliente;

/**
 * Created by guille on 01/10/2017.
 */

public interface IModeloCliente {

    /**
     * metodo de registración de la vista como listener
     */

    void agreagarOyenteDelCambio(IVistaCliente iVistaCliente) throws ExcepcionRotiseria;

    //------- Metodos de servicio para el Controlador ---------

    /**
     * metodo para agregar o restar plato al pedido
     */
    void modificaPedido(int idPlato,int numero)throws ExcepcionRotiseria;


    /**
     * metodo para enviar el pedido a la base de datos
     */
    void enviarPedido(String token)throws ExcepcionRotiseria;


    /**
     * metodo para comenzar el timer.
     */
    void comienzaTimer(int tiempo)throws ExcepcionRotiseria;


    //------- Metodos de servicio para la Vista ---------

    /**
     * metodo que notifica cambios en el modelo
     */
    void disparaCambiosModelo(Object object)throws ExcepcionRotiseria;
    /**
     * metodo que obtiene el menú de platos de la Rotisería. Pantalla1
     */
     Plato[] getMenu()throws ExcepcionRotiseria;

    /**
     * metodo para obtener la cantidad de pedidos de cada plato. Pantalla1
     */
    Integer cantidadPorPlato(int idPlato)throws ExcepcionRotiseria;


    /**
     * metodo que obtiene el precio total del pedido. Barra de Pedido. Pantalla1
     * @throws ExcepcionRotiseria
     */
    int getPrecioPedido()throws ExcepcionRotiseria;

    /**
     * metodo que obtiene todos los datos del pedido. Pantalla2
     */
    Pedido getPedido()throws ExcepcionRotiseria;


    /**
     * metodo para ver la demora del pedido. Pantalla3
     */
    void getDemoraPedido()throws ExcepcionRotiseria;


    /**
     * método para logearse usando facebook
     */
    void faceLogin()throws ExcepcionRotiseria;

}
