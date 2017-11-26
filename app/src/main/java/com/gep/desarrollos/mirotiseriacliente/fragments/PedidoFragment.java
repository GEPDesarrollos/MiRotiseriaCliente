package com.gep.desarrollos.mirotiseriacliente.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.gep.desarrollos.mirotiseriacliente.modelo.PlatoPedido;


public class PedidoFragment extends Fragment implements IVistaCliente {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private AdaptadorRecyclerPedido mAdapter;
    private PlatoPedido[] arrayPlatosPedidos;
    private IModeloCliente iModelo;
    private Context context;



    public PedidoFragment() {
          }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_pedido, container, false);
        super.onViewCreated(view, savedInstanceState);
        return view;

    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler_pedido);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);


    }



    @Override
    public void onResume() {

        super.onResume();
        refrescar();

    }



    @Override
    public void refrescar() {

        iModelo=new ImplementacionModeloCliente();
        try {
            iModelo.agreagarOyenteDelCambio(this);
            registrarModelo(iModelo);
            arrayPlatosPedidos=iModelo.getHashSetPlatoPedido();

        } catch (ExcepcionRotiseria excepcionRotiseria) {
            excepcionRotiseria.printStackTrace();
        }

        mAdapter = new AdaptadorRecyclerPedido(arrayPlatosPedidos);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

    }



    @Override
    public void agregaOyenteAcciones(IControladorCliente iControladorCliente) throws ExcepcionRotiseria {

    }



    @Override
    public void registrarModelo(IModeloCliente modelo) throws ExcepcionRotiseria {

    }



    @Override
    public void mostrarPantalla(Object object) throws ExcepcionRotiseria {

    }



    @Override
    public void manejadorDeCambioModeloCliente(Pedido pedido) throws ExcepcionRotiseria {

    }

    }
