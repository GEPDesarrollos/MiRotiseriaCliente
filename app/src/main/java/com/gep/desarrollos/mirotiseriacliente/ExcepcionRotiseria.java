package com.gep.desarrollos.mirotiseriacliente;

/**
 * Created by guille on 30/09/2017.
 */

public class ExcepcionRotiseria extends Exception {
    private String mensaje;

    public ExcepcionRotiseria(String mensaje){
        super(mensaje);
    }
}
