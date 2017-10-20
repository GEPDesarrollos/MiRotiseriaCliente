package com.gep.desarrollos.mirotiseriacliente.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gep.desarrollos.mirotiseriacliente.R;
import com.gep.desarrollos.mirotiseriacliente.modelo.ExcepcionRotiseria;
import com.gep.desarrollos.mirotiseriacliente.modelo.Pedido;


class AdaptadorRecyclerPedido extends RecyclerView.Adapter<AdaptadorRecyclerPedido.HolderView> {
    private Pedido pedido;

    public AdaptadorRecyclerPedido(Pedido pedido) {
        this.pedido=pedido;
    }

    @Override
    public AdaptadorRecyclerPedido.HolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_menu, parent, false);
        Adaptador.MyViewHolder mVH=new Adaptador.MyViewHolder(view);
        try {
            iModeloCliente.agreagarOyenteDelCambio(this);
        } catch (ExcepcionRotiseria excepcionRotiseria) {
            excepcionRotiseria.printStackTrace();
        }

        return mVH;

    }

    @Override
    public void onBindViewHolder(AdaptadorRecyclerPedido.HolderView holder, int position) {
        //Acá van los setters

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HolderView extends RecyclerView.ViewHolder {
        //Acá se registran las views
        public HolderView(View itemView) {
            super(itemView);
        }
    }
}
