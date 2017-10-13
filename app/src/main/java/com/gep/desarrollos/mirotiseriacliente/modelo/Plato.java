package com.gep.desarrollos.mirotiseriacliente.modelo;


public class Plato {
    private int idPlato;
    private int precioPlato;
    private String nombre, descripcion;
    private int foto;


    public Plato(int idPlato, int precioPlato, String nombre, String descripcion, int foto) {
        this.idPlato = idPlato;
        this.precioPlato = precioPlato;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    public int getPrecioPlato() {
        return precioPlato;
    }

    public void setPrecioPlato(int precioPlato) {
        this.precioPlato = precioPlato;
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

    @Override
    public String toString() {
        return "Plato{" +
                "idPlato=" + idPlato +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", foto=" + foto +
                '}';
    }
}
