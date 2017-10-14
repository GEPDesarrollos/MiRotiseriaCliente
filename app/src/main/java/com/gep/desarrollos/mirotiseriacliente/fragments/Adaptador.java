package com.gep.desarrollos.mirotiseriacliente.fragments;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gep.desarrollos.mirotiseriacliente.IControladorCliente;
import com.gep.desarrollos.mirotiseriacliente.IVistaCliente;
import com.gep.desarrollos.mirotiseriacliente.R;
import com.gep.desarrollos.mirotiseriacliente.modelo.ExcepcionRotiseria;
import com.gep.desarrollos.mirotiseriacliente.modelo.IModeloCliente;
import com.gep.desarrollos.mirotiseriacliente.modelo.Pedido;
import com.gep.desarrollos.mirotiseriacliente.modelo.Plato;

/**
 * Created by GEP on 12/10/2017.
 */

class Adaptador extends RecyclerView.Adapter<Adaptador.MyViewHolder> implements IVistaCliente {

    private Plato[] platos;
    private IModeloCliente iModeloCliente;
    private IControladorCliente controladorCliente;

    @Override
    public void registrarModelo(IModeloCliente modelo) throws ExcepcionRotiseria {
        modelo=iModeloCliente;
    }

    @Override
    public void agregaOyenteAcciones(IControladorCliente iControladorCliente) throws ExcepcionRotiseria {
        iControladorCliente=controladorCliente;
    }

    @Override
    public void refrescar() {


    }

    @Override
    public void mostrarPantalla(Object object) throws ExcepcionRotiseria {

    }
    public void mostrarPantalla(int posicion) throws ExcepcionRotiseria {

        notifyItemChanged(posicion);

    }


    @Override
    public void manejadorDeCambioModeloCliente(Pedido pedido) throws ExcepcionRotiseria {

    }


    public Adaptador(Plato[] platos, IModeloCliente iModeloCliente) {
        this.platos = platos;
        this.iModeloCliente = iModeloCliente;
    }

    @Override
    public Adaptador.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        MyViewHolder mVH=new MyViewHolder(view);
        try {
            iModeloCliente.agreagarOyenteDelCambio(this);
        } catch (ExcepcionRotiseria excepcionRotiseria) {
            excepcionRotiseria.printStackTrace();
        }

        return mVH;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.imagen.setImageResource(platos[position].getFoto());
        holder.id.setText(platos[position].getIdPlato());
        holder.nombre.setText(platos[position].getNombre());
        try {
            Integer cantidadPlato=(iModeloCliente.cantidadPorPlato(platos[position].getIdPlato())==null)?0:iModeloCliente.cantidadPorPlato(platos[position].getIdPlato());
            holder.cantidad.setText("0"+cantidadPlato);
        } catch (ExcepcionRotiseria excepcionRotiseria) {
            excepcionRotiseria.printStackTrace();
        }catch (NullPointerException nullPointer){
            nullPointer.getMessage();
        }
        holder.descripcion.setText(platos[position].getDescripcion());
        holder.precio.setText("$ "+platos[position].getPrecioPlato());
        //botones
        holder.setOnClickListeners(iModeloCliente,holder.getAdapterPosition());

    }

    @Override
    public int getItemCount() {
        return platos.length;
    }


    public  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private int position;
        private ImageView imagen;
        private TextView id,nombre, cantidad, descripcion, precio;
        private Button btMas, btMenos;
        private IModeloCliente modeloCliente;
        Adaptador adaptador;

        public MyViewHolder(View itemView) {
            super(itemView);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
            id =  (TextView) itemView.findViewById(R.id.id_plato);
            nombre = (TextView) itemView.findViewById(R.id.nombre_plato);
            cantidad = (TextView) itemView.findViewById(R.id.cantidad_plato);
            descripcion = (TextView) itemView.findViewById(R.id.descripcion_plato);
            precio = (TextView) itemView.findViewById(R.id.precio_plato);
            btMas = (Button) itemView.findViewById(R.id.mas);
            btMenos = (Button) itemView.findViewById(R.id.menos);

        }
        void setOnClickListeners(IModeloCliente modeloCliente,int position){
            btMas.setOnClickListener(this);
            btMenos.setOnClickListener(this);
            this.position= position;
            this.modeloCliente=modeloCliente;

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case (R.id.mas):
                    //llamar al manejador de la tecla mas
                    try {

                        modeloCliente.modificaPedido(id.getText().toString(),1);
                        mostrarPantalla(position);
                    } catch (ExcepcionRotiseria excepcionRotiseria) {
                        excepcionRotiseria.printStackTrace();
                    }

                    break;

                case (R.id.menos):
                    //llamar al manejador de la tecla menos
                    try {
                        modeloCliente.modificaPedido(id.getText().toString(),-1);
                        mostrarPantalla(position);

                    } catch (ExcepcionRotiseria excepcionRotiseria) {
                        excepcionRotiseria.printStackTrace();
                    }
                    break;
            }

        }
    }

   }
