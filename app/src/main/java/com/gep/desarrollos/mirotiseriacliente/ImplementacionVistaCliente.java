package com.gep.desarrollos.mirotiseriacliente;

import android.util.Log;

import com.gep.desarrollos.mirotiseriacliente.modelo.ExcepcionRotiseria;
import com.gep.desarrollos.mirotiseriacliente.modelo.IModeloCliente;
import com.gep.desarrollos.mirotiseriacliente.modelo.Menu;
import com.gep.desarrollos.mirotiseriacliente.modelo.Pedido;
import com.gep.desarrollos.mirotiseriacliente.modelo.Plato;

/**
 * Created by GEP on 08/10/2017.
 */

public class ImplementacionVistaCliente implements IVistaCliente {
    //private PantallaEspera mainActivity;
    private IModeloCliente modelo;
    private Plato[] platos;
    private Menu menu;
    private final static String TAG="ImplementaciónVista";



    @Override
    public void registrarModelo(IModeloCliente modelo){
        this.modelo=modelo;
    }

    @Override
    public void refrescar(){

    }

    @Override
    public void agregaOyenteAcciones(IControladorCliente iControladorCliente) throws ExcepcionRotiseria {

    }

    @Override
    public void mostrarPantalla(Object object) throws ExcepcionRotiseria {

        if(object instanceof Integer[]){
            Integer []datosPantalla=(Integer[])object;

            Log.i(TAG,datosPantalla[2]+"-id: "+datosPantalla[0]+" $"+datosPantalla[1]);
        }


    }

    @Override
    public void manejadorDeCambioModeloCliente(Pedido pedido) throws ExcepcionRotiseria {

    }
}
