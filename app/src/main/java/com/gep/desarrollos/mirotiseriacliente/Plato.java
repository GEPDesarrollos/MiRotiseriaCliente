package com.gep.desarrollos.mirotiseriacliente;

/**
 * Created by guille on 01/10/2017.
 */

public class Plato {
    private int idPlato;
    private String nombre, descripcion;
    private int foto;

    public Plato(int idPlato, String nombre, String descripcion, int foto) {
        this.idPlato = idPlato;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getFoto() {
        return foto;
    }
}
