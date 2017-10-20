package com.gep.desarrollos.mirotiseriacliente.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gep.desarrollos.mirotiseriacliente.IControladorCliente;
import com.gep.desarrollos.mirotiseriacliente.IVistaCliente;
import com.gep.desarrollos.mirotiseriacliente.R;
import com.gep.desarrollos.mirotiseriacliente.modelo.ExcepcionRotiseria;
import com.gep.desarrollos.mirotiseriacliente.modelo.IModeloCliente;
import com.gep.desarrollos.mirotiseriacliente.modelo.ImplementacionModeloCliente;
import com.gep.desarrollos.mirotiseriacliente.modelo.Pedido;
import com.gep.desarrollos.mirotiseriacliente.modelo.Plato;


public class PedidoFragment extends Fragment implements IVistaCliente {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private Pedido pedido;
    private IModeloCliente iModelo;
    private AdaptadorRecyclerPedido mAdapter;

    public PedidoFragment() {
          }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_pedido, container, false);
        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.fab);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler_pedido);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);


        // agrega la vista como oyente del modelo y llena el vector platos para el Adapter
        iModelo=new ImplementacionModeloCliente();
        try {
            iModelo.agreagarOyenteDelCambio(this);
            registrarModelo(iModelo);
            pedido= iModelo.getPedido();
        } catch (ExcepcionRotiseria excepcionRotiseria) {
            excepcionRotiseria.printStackTrace();
        }


        mAdapter = new AdaptadorRecyclerPedido(pedido);
        mRecyclerView.setAdapter(mAdapter);




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        return view;
    }

    @Override
    public void registrarModelo(IModeloCliente modelo) throws ExcepcionRotiseria {

    }

    @Override
    public void agregaOyenteAcciones(IControladorCliente iControladorCliente) throws ExcepcionRotiseria {

    }

    @Override
    public void refrescar() {

    }

    @Override
    public void mostrarPantalla(Object object) throws ExcepcionRotiseria {

    }

    @Override
    public void manejadorDeCambioModeloCliente(Pedido pedido) throws ExcepcionRotiseria {

    }
}
