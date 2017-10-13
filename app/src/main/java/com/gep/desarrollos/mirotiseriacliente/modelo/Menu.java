package com.gep.desarrollos.mirotiseriacliente.modelo;

/**
 * Created by GEP on 08/10/2017.
 */

public class Menu {

    private Plato[] menu=new Plato[]{new Plato(101,20,"empanada de carne","empanada rellena de carne, huevo y aceitunas",1),
            new Plato(102,20,"empanada de jamon y queso","empanada rellena de jamon y queso",2),
            new Plato(103,20,"empanada de choclo","empanada rellena de choclo, queso, crema",3),
            new Plato(204,80,"hamburguesa chica","hamburguesa con lechuga y tomate",4),
            new Plato(205,150,"hamburguesa grande","hamburguesa grande con huevo, queso, lechuga y tomate",5),};

    public Plato[] getMenu(){
        return menu;
    }

    public int getPrecioPlato(int idPlato){
        for(Plato plato:getMenu()) {
            if (plato.getIdPlato() == idPlato)

                return plato.getPrecioPlato();
        }
        return -1;
    }
    public String getNombrePlato(int idPlato){
        for(Plato plato:getMenu()) {
            if (plato.getIdPlato() == idPlato)

                return plato.getNombre();
        }
        return "error pedido";
    }
}
