package com.gep.desarrollos.mirotiseriacliente.modelo;

import android.util.Log;

import com.gep.desarrollos.mirotiseriacliente.IVistaCliente;
import com.gep.desarrollos.mirotiseriacliente.MyFirebaseInstanceIDService;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.TreeMap;

/**
 * Created by GEP on 08/10/2017.
 */

public class ImplementacionModeloCliente implements IModeloCliente {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("pedido");


    private MyFirebaseInstanceIDService myFirebaseInstanceIDService=new MyFirebaseInstanceIDService();
    private Menu menu;
    private IVistaCliente vistaCliente;
    private Pedido pedido=Pedido.getPedido();



    @Override
    public void agreagarOyenteDelCambio(IVistaCliente iVistaCliente) throws ExcepcionRotiseria {
        vistaCliente =iVistaCliente;

    }

    @Override
    public void modificaPedido(int idPlato, int numero) throws ExcepcionRotiseria {
        Integer []idCantidadPrecio;
        Integer precio, cantidad;
        Integer cantidadPlatoPedido;

        //comprueba que el plato esté en el menu
        if (menu.getPrecioPlato(idPlato) != -1) {

            if (pedido.getPlatos() != null) {
                cantidadPlatoPedido = (pedido.getPlatos().get(""+idPlato) != null) ? (Integer) pedido.getPlatos().get(""+idPlato) : 0;
            } else {
                cantidadPlatoPedido = 0;
            }

            switch (numero) {

                case 1:
                    if ((pedido.getPlatos() != null)) {

                        precio=Integer.valueOf(pedido.getPrecioTotal() + menu.getPrecioPlato(idPlato));
                        pedido.setPrecioTotal(precio);
                        cantidad=Integer.valueOf(cantidadPlatoPedido + numero);
                        pedido.getPlatos().put(""+idPlato,cantidad);

                    } else {
                        pedido.setPlatos(new TreeMap<String, Integer>());
                        pedido.getPlatos().put(""+idPlato, numero);
                        precio=Integer.valueOf(pedido.getPrecioTotal() + menu.getPrecioPlato(idPlato));
                        cantidad=1;
                        pedido.setPrecioTotal(precio);

                    }
                    idCantidadPrecio=new Integer[]{idPlato,precio,cantidad};
                    vistaCliente.mostrarPantalla(idCantidadPrecio);
                    Log.i("PEDIDO: ", "" + pedido.getPlatos().toString() + ". Precio pedido: " + pedido.getPrecioTotal());
                    break;

                case -1:
                    if (cantidadPlatoPedido != 0) {
                        if (cantidadPlatoPedido == 1) {
                            pedido.getPlatos().remove(""+idPlato);
                            precio=Integer.valueOf(pedido.getPrecioTotal() + menu.getPrecioPlato(idPlato) * numero);
                            cantidad=0;
                            pedido.setPrecioTotal(precio);

                        } else {
                            cantidad=Integer.valueOf(cantidadPlatoPedido + numero);
                            pedido.getPlatos().put(""+idPlato, cantidad);
                            precio=Integer.valueOf(pedido.getPrecioTotal() + menu.getPrecioPlato(idPlato) * numero);
                            pedido.setPrecioTotal(precio);
                        }
                        idCantidadPrecio=new Integer[]{idPlato,precio,cantidad};
                        vistaCliente.mostrarPantalla(idCantidadPrecio);

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
    public void enviarPedido(String token) throws ExcepcionRotiseria {

        String tokenRotiseria;

        //solicita Token de Rotisería
        do{
            Rotiseria.leerTokenRotiseria();
            tokenRotiseria=Rotiseria.getTokenRotiseria();
            Log.i("TokenRotiseriaNuevo",""+tokenRotiseria);
        }while (tokenRotiseria==null);


        //obtener token de la app que va a ser anexado con el pedido

        pedido.setCliente(token);
       //Log.i("tokenDevueltoCliente",pedido.getCliente());


        //Escribir en Firebase y enviar mensaje

        myRef.push().setValue(pedido);


    }

    @Override
    public void comienzaTimer(int tiempo) throws ExcepcionRotiseria {

    }

    @Override
    public void disparaCambiosModelo(Object object) throws ExcepcionRotiseria {
        vistaCliente.mostrarPantalla(object);
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
    public Pedido getPedido() throws ExcepcionRotiseria {
        return Pedido.getPedido();

    }

    @Override
    public void getDemoraPedido() throws ExcepcionRotiseria {

    }

    @Override
    public void faceLogin() throws ExcepcionRotiseria {

    }
}
