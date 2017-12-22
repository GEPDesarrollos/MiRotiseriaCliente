package com.gep.desarrollos.mirotiseriacliente.modelo;

import android.app.Application;

import com.gep.desarrollos.mirotiseriacliente.MiRotiseriaCliente;
import com.gep.desarrollos.mirotiseriacliente.R;


public class Menu {



    private Plato[] menu=new Plato[]{new Plato("101",20,"Salmón","salmón fresco y queso philadelphia", (R.drawable.sushi_go_roll)),
            new Plato("102",20,"SPP","salmón fresco, palta y queso philadelphia",(R.drawable.rollroice)),
            new Plato("103",20,"Paris","salmón fresco, ciboulette, queso roquefort y queso philadelphia",(R.drawable.honey_roll_r52)),
            new Plato("204",80,"Honey","salmón cocido con miel y jengibre, topping de batata crocante",(R.drawable.sushi_go_roll)),
            new Plato("205",150,"Miami","langostinos cocidos, palta y queso philadelphia",(R.drawable.rollroice)),};

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
