        package com.gep.desarrollos.mirotiseriacliente.modelo;

        import android.util.Log;
        import com.gep.desarrollos.mirotiseriacliente.fragments.*;
        import com.gep.desarrollos.mirotiseriacliente.IVistaCliente;
        import com.gep.desarrollos.mirotiseriacliente.MyFirebaseInstanceIDService;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

        import java.util.ArrayList;
        import java.util.HashSet;
        import java.util.Iterator;
        import java.util.List;
        import java.util.Set;
        import java.util.TreeMap;

        /**
         * Created by GEP on 08/10/2017.
         */

        public class ImplementacionModeloCliente implements IModeloCliente {

            private FirebaseDatabase database = FirebaseDatabase.getInstance();
            private DatabaseReference myRef = database.getReference("pedido");
            private MyFirebaseInstanceIDService myFirebaseInstanceIDService=new MyFirebaseInstanceIDService();
            private Menu menu;
            private List<IVistaCliente> vistaCliente=new ArrayList<>();
            private Pedido pedido=Pedido.getPedido();
            private static Set<PlatoPedido> hashSetPlatoPedido =new HashSet<>();
            private PedidoFragment pedidoFragment=new PedidoFragment();



            public  PlatoPedido[] getHashSetPlatoPedido() {

                //fijarme como puedo obtener un array de un hasH
                PlatoPedido[] platosPedidos=new PlatoPedido[hashSetPlatoPedido.size()];
                platosPedidos=hashSetPlatoPedido.toArray(platosPedidos);
                return platosPedidos ;

            }



            public void modificarPlatoPedido(int cantidad, int precio, String id) {

    //          si el plato existe lo elimina
                eliminarPlatoPedido(id);

                hashSetPlatoPedido.add(new PlatoPedido(cantidad,precio,menu.getNombrePlato(id)));


            }



            public void eliminarPlatoPedido(String id) {

                Iterator <PlatoPedido> it= hashSetPlatoPedido.iterator();
                while (it.hasNext()){
                    String nombrePlato=it.next().getNombrePlatoPedido();
                    if (nombrePlato.equals(menu.getNombrePlato(id))){
                        it.remove();
                    }
                }
            }



            public ImplementacionModeloCliente(){
                for (IVistaCliente iVistaCliente:vistaCliente){
                    try {
                        iVistaCliente.registrarModelo(this);
                    } catch (ExcepcionRotiseria excepcionRotiseria) {
                        excepcionRotiseria.printStackTrace();
                    }
                }
            }



            @Override
            public void modificaPedido(String idPlato, int numero) throws ExcepcionRotiseria {

                Integer[] idCantidadPrecio;
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
                                modificarPlatoPedido(cantidad,(cantidad*menu.getPrecioPlato(idPlato)),idPlato);

                            } else {

                                pedido.setPlatos(new TreeMap<String, Integer>());
                                pedido.getPlatos().put(idPlato, numero);
                                precio=Integer.valueOf(pedido.getPrecioTotal() + menu.getPrecioPlato(idPlato));
                                cantidad=1;
                                pedido.setPrecioTotal(precio);
                                modificarPlatoPedido(cantidad,(cantidad*menu.getPrecioPlato(idPlato)),idPlato);

                            }
                            idCantidadPrecio=new Integer[]{Integer.parseInt(idPlato),precio,cantidad};


                            disparaCambiosModelo(idCantidadPrecio);


                            Log.i("PEDIDO: ", "" + pedido.getPlatos().toString() + ". Precio pedido: " + pedido.getPrecioTotal());
                            break;

                        case -1:
                            if (cantidadPlatoPedido != 0) {
                                if (cantidadPlatoPedido == 1) {

                                    pedido.getPlatos().remove(idPlato);
                                    precio=Integer.valueOf(pedido.getPrecioTotal() + menu.getPrecioPlato(idPlato) * numero);
                                    cantidad=0;
                                    pedido.setPrecioTotal(precio);
                                    eliminarPlatoPedido(idPlato);

                                } else {

                                    cantidad=Integer.valueOf(cantidadPlatoPedido + numero);
                                    pedido.getPlatos().put(idPlato, cantidad);
                                    precio=Integer.valueOf(pedido.getPrecioTotal() + menu.getPrecioPlato(idPlato) * numero);
                                    pedido.setPrecioTotal(precio);
                                    modificarPlatoPedido(cantidad,(cantidad*menu.getPrecioPlato(idPlato)),idPlato);

                                }

                                idCantidadPrecio=new Integer[]{Integer.parseInt(idPlato),precio,cantidad};

                                disparaCambiosModelo(idCantidadPrecio);


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


                String tokenRotiseria=Rotiseria.getTokenRotiseria();
                Log.i("TokenRotiseriaNuevo",""+tokenRotiseria);



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
            public void agreagarOyenteDelCambio(IVistaCliente iVistaCliente) throws ExcepcionRotiseria {
                vistaCliente.add(iVistaCliente);

            }



            @Override
            public void disparaCambiosModelo(Object object) throws ExcepcionRotiseria {

                for(IVistaCliente iVistaCliente:vistaCliente){

                    iVistaCliente.mostrarPantalla(object);
                }

            }



            @Override
            public Plato[] getMenu() throws ExcepcionRotiseria {
                menu = new Menu();
                return menu.getMenu();

            }



            @Override
            public Integer cantidadPorPlato(String idPlato) throws ExcepcionRotiseria {
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
