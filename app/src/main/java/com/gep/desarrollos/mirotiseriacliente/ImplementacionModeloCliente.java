package com.gep.desarrollos.mirotiseriacliente;

import android.util.Log;

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

        //comprueba que el plato esté en el menu
        if (menu.getPrecioPlato(idPlato) != -1) {

            if (pedido.getPlatos() != null) {
                cantidadPlatoPedido = (pedido.getPlatos().get(idPlato) != null) ? (Integer) pedido.getPlatos().get(idPlato) : 0;
            } else {
                cantidadPlatoPedido = 0;
            }

            switch (numero) {

                case 1:
                    if ((pedido.getPlatos() != null)) {

                        pedido.setPrecioTotal(pedido.getPrecioTotal() + menu.getPrecioPlato(idPlato));
                        pedido.getPlatos().put(idPlato, cantidadPlatoPedido + numero);

                    } else {
                        pedido.setPlatos(new TreeMap<Integer, Integer>());
                        pedido.getPlatos().put(idPlato, numero);
                        pedido.setPrecioTotal(pedido.getPrecioTotal() + menu.getPrecioPlato(idPlato));

                    }
                    Log.i("PEDIDO: ", "" + pedido.getPlatos().toString() + ". Precio pedido: " + pedido.getPrecioTotal());
                    break;

                case -1:
                    if (cantidadPlatoPedido != 0) {
                        if (cantidadPlatoPedido == 1) {
                            pedido.getPlatos().remove(idPlato);
                            pedido.setPrecioTotal(pedido.getPrecioTotal() + menu.getPrecioPlato(idPlato) * numero);

                        } else {
                            pedido.getPlatos().put(idPlato, cantidadPlatoPedido + numero);
                            pedido.setPrecioTotal(pedido.getPrecioTotal() + menu.getPrecioPlato(idPlato) * numero);
                        }

                        Log.i("PEDIDO: ", "" + pedido.getPlatos().toString() + ". Precio pedido: " + pedido.getPrecioTotal());

                    } else {
                        try {
                            Log.i("PEDIDO: ", "Error!!! no se puede pedir: " + cantidadPlatoPedido + " " + numero + ". Precio pedido: " + pedido.getPrecioTotal());
                        } catch (Exception e) {

                        }
                    }
                    break;

                default:
                    Log.i("PEDIDO: ", "Error!!!");
                    throw new ExcepcionRotiseria("no hay pedido");


            }


        }
    }




    @Override
    public void enviarPedido(Pedido pedido) throws ExcepcionRotiseria {

    }

    @Override
    public void comienzaTimer(int tiempo) throws ExcepcionRotiseria {

    }

    @Override
    public void disparaCambiosModelo(Object object) throws ExcepcionRotiseria {
        iVistaCliente.mostrarPantalla(object);
    }

    @Override
    public Plato[] getMenu() throws ExcepcionRotiseria {
        menu = new Menu();
        return menu.getMenu();

    }

    @Override
    public Integer cantidadPorPlato(int idPlato) throws ExcepcionRotiseria {
        return (Integer)pedido.getPlatos().get(idPlato);
    }


    @Override
    public int getPrecioPedido() throws ExcepcionRotiseria {
        return pedido.getPrecioTotal();

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
