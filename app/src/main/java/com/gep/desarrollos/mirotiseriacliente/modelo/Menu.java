package com.gep.desarrollos.mirotiseriacliente.modelo;

import android.app.Application;

import com.gep.desarrollos.mirotiseriacliente.MiRotiseriaCliente;
import com.gep.desarrollos.mirotiseriacliente.R;


public class Menu {



    private Plato[] menu=new Plato[]{new Plato("101",20,"Empanada de Carne","Empanada rellena de carne, huevo y aceitunas", (R.mipmap.empanada_foto)),
            new Plato("102",20,"Empanada de Jamon y Queso","Empanada rellena de jamon y queso",(R.mipmap.empanada)),
            new Plato("103",20,"Empanada de Choclo","Empanada rellena de choclo, queso, crema",(R.mipmap.empanada_foto)),
            new Plato("204",80,"Hamburguesa chica","Hamburguesa con lechuga y tomate",(R.mipmap.hamburguesa)),
            new Plato("205",150,"Hamburguesa grande","Hamburguesa grande con huevo, queso, lechuga y tomate",(R.mipmap.hamburguesa)),};

    public Plato[] getMenu(){
        return menu;
    }

    public int getPrecioPlato(String idPlato){
        for(Plato plato:getMenu()) {
            if (plato.getIdPlato().equals(idPlato))

                return plato.getPrecioPlato();
        }
        return -1;
    }
    public String getNombrePlato(String idPlato){
        for(Plato plato:getMenu()) {
            if (plato.getIdPlato().equals(idPlato))

                return plato.getNombre();
        }
        return "error pedido";
    }
}
