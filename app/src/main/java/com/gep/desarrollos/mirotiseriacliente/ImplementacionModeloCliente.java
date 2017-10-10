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
        Integer []idCantidadPrecio;
        Integer precio, cantidad;
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

                        precio=Integer.valueOf(pedido.getPrecioTotal() + menu.getPrecioPlato(idPlato));
                        pedido.setPrecioTotal(precio);
                        cantidad=Integer.valueOf(cantidadPlatoPedido + numero);
                        pedido.getPlatos().put(idPlato,cantidad);

                    } else {
                        pedido.setPlatos(new TreeMap<Integer, Integer>());
                        pedido.getPlatos().put(idPlato, numero);
                        precio=Integer.valueOf(pedido.getPrecioTotal() + menu.getPrecioPlato(idPlato));
                        cantidad=1;
                        pedido.setPrecioTotal(precio);

                    }
                    idCantidadPrecio=new Integer[]{idPlato,precio,cantidad};
                    iVistaCliente.mostrarPantalla(idCantidadPrecio);
                    Log.i("PEDIDO: ", "" + pedido.getPlatos().toString() + ". Precio pedido: " + pedido.getPrecioTotal());
                    break;

                case -1:
                    if (cantidadPlatoPedido != 0) {
                        if (cantidadPlatoPedido == 1) {
                            pedido.getPlatos().remove(idPlato);
                            precio=Integer.valueOf(pedido.getPrecioTotal() + menu.getPrecioPlato(idPlato) * numero);
                            cantidad=0;
                            pedido.setPrecioTotal(precio);

                        } else {
                            cantidad=Integer.valueOf(cantidadPlatoPedido + numero);
                            pedido.getPlatos().put(idPlato, cantidad);
                            precio=Integer.valueOf(pedido.getPrecioTotal() + menu.getPrecioPlato(idPlato) * numero);
                            pedido.setPrecioTotal(precio);
                        }
                        idCantidadPrecio=new Integer[]{idPlato,precio,cantidad};
                        iVistaCliente.mostrarPantalla(idCantidadPrecio);

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
