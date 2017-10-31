package com.gep.desarrollos.mirotiseriacliente.fragments;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gep.desarrollos.mirotiseriacliente.IControladorCliente;
import com.gep.desarrollos.mirotiseriacliente.IVistaCliente;
import com.gep.desarrollos.mirotiseriacliente.R;
import com.gep.desarrollos.mirotiseriacliente.modelo.ExcepcionRotiseria;
import com.gep.desarrollos.mirotiseriacliente.modelo.IModeloCliente;
import com.gep.desarrollos.mirotiseriacliente.modelo.Menu;
import com.gep.desarrollos.mirotiseriacliente.modelo.Pedido;
import com.gep.desarrollos.mirotiseriacliente.modelo.Plato;
import com.gep.desarrollos.mirotiseriacliente.modelo.PlatoPedido;


class AdaptadorRecyclerPedido extends RecyclerView.Adapter<AdaptadorRecyclerPedido.HolderView> implements IVistaCliente{

    private PlatoPedido[] pedido;
    private IModeloCliente modelo;



    public AdaptadorRecyclerPedido(PlatoPedido[] pedido) {

        this.pedido=pedido;

    }



    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



    @Override
    public HolderView onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_view_pedido,parent,false);
        HolderView holderView=new HolderView(view);
        Log.d("onCreateViewHolder","aca");
        return holderView;

    }

    @Override
    public void onBindViewHolder(HolderView holder, int position) {

        String cantidades = "" + pedido[position].getCantidadPedido();
        holder.cantidad.setText(cantidades);
        String nombrePlatoPedido = pedido[position].getNombrePlatoPedido();
        holder.nombrePlatoPedido.setText(nombrePlatoPedido);
        String subtotal = "$ " + pedido[position].getSubTotal();
        holder.importePlatosPedidos.setText(subtotal);
        Log.d("onBindHolderPedido",cantidades+" "+ nombrePlatoPedido +subtotal);

    }



    @Override
    public int getItemCount() {
        return (pedido==null) ?0:pedido.length;
    }




    public class HolderView extends RecyclerView.ViewHolder {
        //Acá se registran las views
        TextView cantidad,nombrePlatoPedido,importePlatosPedidos;

        public HolderView(View itemView) {
            super(itemView);
            cantidad=(TextView)itemView.findViewById(R.id.text_cantidad_pedido);
            nombrePlatoPedido=(TextView)itemView.findViewById(R.id.text_nombre_plato_pedido);
            importePlatosPedidos=(TextView)itemView.findViewById(R.id.text_importe_platos_pedidos);

        }
    }



    @Override
    public void registrarModelo(IModeloCliente modelo) throws ExcepcionRotiseria {

    }



    @Override
    public void agregaOyenteAcciones(IControladorCliente iControladorCliente) throws ExcepcionRotiseria {

    }



    @Override
    public void refrescar() {

//        notifyDataSetChanged();
    }



    @Override
    public void mostrarPantalla(Object object) throws ExcepcionRotiseria {

    }



    @Override
    public void manejadorDeCambioModeloCliente(Pedido pedido) throws ExcepcionRotiseria {

    }
}
