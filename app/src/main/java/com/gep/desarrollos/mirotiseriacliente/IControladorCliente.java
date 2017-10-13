package com.gep.desarrollos.mirotiseriacliente;

import com.gep.desarrollos.mirotiseriacliente.modelo.ExcepcionRotiseria;

/**
 * Created by guille on 30/09/2017.
 */

public interface IControladorCliente {

    /**
     * metodo manejador para la acción del boton + en el plato
     */
    void manejadorBotonMas(String idPlato)throws ExcepcionRotiseria;

    /**
     * metodo manejador para la acción del boton - en el plato
     */
    void manejadorBotonMenos(String idPlato)throws ExcepcionRotiseria;

    /**
     * metodo manejador para la acción del boton OK en barraPedido. Pantalla1
     */
    void manejadorOkBarraPedido()throws ExcepcionRotiseria;


    /**
     * metodo manejador para la acción del boton agregar más platos. Pantalla2.
     */
    void manejadorBotonAgregarPlatos(String idPlato)throws ExcepcionRotiseria;

    /**
     * metodo manejador para la acción del boton OK enviar Pedido. Pantalla2.
     */
    void manejadorBotonEnviarPedido()throws ExcepcionRotiseria;


    /**
     * metodo manejador para la acción del boton Salir. Pantalla3.
     */
    void manejadorBotonSalir()throws ExcepcionRotiseria;

    /**
     * metodo manejador para la acción del boton comenzarTimer. Pantalla3.
     */
    void manejadorComenzarTimer()throws ExcepcionRotiseria;


}
