package com.gep.desarrollos.mirotiseriacliente;

import android.util.Log;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by GEP on 08/10/2017.
 */

public class ImplementacionModeloCliente implements IModeloCliente {

    private Menu menu;
    private IVistaCliente iVistaCliente;
    private Pedido pedido=Pedido.getPedido();


    @Override
    public void agreagarOyenteDelCambio(IVistaCliente iVistaCliente) throws ExcepcionRotiseria {
        this.iVistaCliente=iVistaCliente;

    }

    @Override
    public void modificaPedido(int idPlato, int numero) throws ExcepcionRotiseria {

        Integer cantidadPlatoPedido;

        if(pedido.getPlatos()!=null) {
            cantidadPlatoPedido = (pedido.getPlatos().get(idPlato) != null) ? (Integer) pedido.getPlatos().get(idPlato) : 0;
        }else{
             cantidadPlatoPedido=0;
        }

        switch (numero){

            case 1:
                if ((pedido.getPlatos()!=null)) {
                    pedido.getPlatos().put(idPlato,cantidadPlatoPedido+numero);
                }else{
                    pedido.setPlatos(new TreeMap<Integer,Integer>());
                    pedido.getPlatos().put(idPlato,numero);
                }
                Log.i("PEDIDO: ",""+pedido.getPlatos().toString()+" - Obj pedido: "+pedido.toString());
                break;

            case -1:
                if(cantidadPlatoPedido!=0) {
                    if (cantidadPlatoPedido == 1) pedido.getPlatos().remove(idPlato);
                    else pedido.getPlatos().put(idPlato, cantidadPlatoPedido + numero);


                        Log.i("PEDIDO: ", "" + pedido.getPlatos().toString()+" - Obj pedido: "+pedido.toString());
                  }else {
                    try {
                        Log.i("PEDIDO: ", "Error!!! no se puede pedir: "+cantidadPlatoPedido+" "+numero);
                    } catch (Exception e) {

                    }
                }
                break;

            default:
                Log.i("PEDIDO: ","Error!!!");
                throw new ExcepcionRotiseria("no hay pedido");


        }


    }



    @Override
    public void enviarPedido(Pedido pedido) throws ExcepcionRotiseria {

    }

    @Override
    public void comienzaTimer(int tiempo) throws ExcepcionRotiseria {

    }

    @Override
    public Plato[] getMenu() throws ExcepcionRotiseria {
        menu = new Menu();
        return menu.getMenu();

    }

    @Override
    public void cantidadPorPlato(String idPlato) throws ExcepcionRotiseria {

    }

    @Override
    public void getPrecioPedido() throws ExcepcionRotiseria {

    }

    @Override
    public void getPedido() throws ExcepcionRotiseria {

    }

    @Override
    public void getDemoraPedido() throws ExcepcionRotiseria {

    }

    @Override
    public void faceLogin() throws ExcepcionRotiseria {

    }
}
