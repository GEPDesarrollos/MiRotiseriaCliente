package com.gep.desarrollos.mirotiseriacliente;

import android.util.Log;

/**
 * Created by GEP on 08/10/2017.
 */

public class ImplementacionVistaCliente implements IVistaCliente {
    private MainActivity mainActivity;
    private IModeloCliente modelo;
    private Plato[] platos;



    @Override
    public void registrarModelo(IModeloCliente modelo){
        this.modelo=modelo;
    }

    @Override
    public void refrescar(){
        try {
            platos=modelo.getMenu();
            for (Plato plato : platos) {
               Log.i("REFRESCAR: ",plato.toString()+"\n");
            }

        } catch (ExcepcionRotiseria excepcionRotiseria) {
            excepcionRotiseria.printStackTrace();
        }
    }
    @Override
    public void agregaOyenteAcciones(IControladorCliente iControladorCliente) throws ExcepcionRotiseria {

    }

    @Override
    public void mostrarPantalla(Object object) throws ExcepcionRotiseria {


    }

    @Override
    public void manejadorDeCambioModeloCliente(Pedido pedido) throws ExcepcionRotiseria {

    }
}
