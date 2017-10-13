package com.gep.desarrollos.mirotiseriacliente.fragments;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gep.desarrollos.mirotiseriacliente.R;
import com.gep.desarrollos.mirotiseriacliente.modelo.ExcepcionRotiseria;
import com.gep.desarrollos.mirotiseriacliente.modelo.IModeloCliente;
import com.gep.desarrollos.mirotiseriacliente.modelo.Plato;

/**
 * Created by GEP on 12/10/2017.
 */

class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private Plato[] platos;
    private IModeloCliente iModeloCliente;


    public Adaptador(Plato[] platos, IModeloCliente iModeloCliente) {
        this.platos = platos;
        this.iModeloCliente = iModeloCliente;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.imagen.setImageResource(platos[position].getFoto());
        holder.nombre.setText(platos[position].getNombre());
        try {
            holder.cantidad.setText(iModeloCliente.cantidadPorPlato(platos[position].getIdPlato()));
        } catch (ExcepcionRotiseria excepcionRotiseria) {
            excepcionRotiseria.printStackTrace();
        }
        holder.cantidad.setText(platos[position].getDescripcion());
        holder.precio.setText(platos[position].getPrecioPlato());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private ImageView imagen;
        private TextView nombre, cantidad, descripcion, precio;
        private Button btMas, btMenos;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
            nombre = (TextView) itemView.findViewById(R.id.nombre_plato);
            cantidad = (TextView) itemView.findViewById(R.id.cantidad_plato);
            descripcion = (TextView) itemView.findViewById(R.id.descripcion_plato);
            precio = (TextView) itemView.findViewById(R.id.precio_plato);
            btMas = (Button) itemView.findViewById(R.id.mas);
            btMenos = (Button) itemView.findViewById(R.id.menos);

        }


    }
}
