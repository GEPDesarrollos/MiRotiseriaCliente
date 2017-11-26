package com.gep.desarrollos.mirotiseriacliente.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.gep.desarrollos.mirotiseriacliente.IControladorCliente;
import com.gep.desarrollos.mirotiseriacliente.IVistaCliente;
import com.gep.desarrollos.mirotiseriacliente.R;
import com.gep.desarrollos.mirotiseriacliente.activities.PantallaPrincipalActivity;
import com.gep.desarrollos.mirotiseriacliente.modelo.ExcepcionRotiseria;
import com.gep.desarrollos.mirotiseriacliente.modelo.IModeloCliente;
import com.gep.desarrollos.mirotiseriacliente.modelo.ImplementacionModeloCliente;
import com.gep.desarrollos.mirotiseriacliente.modelo.Pedido;
import com.gep.desarrollos.mirotiseriacliente.modelo.Plato;


public class MenuFragment extends Fragment implements IVistaCliente {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Plato[] platos;
    private IModeloCliente modeloCliente;
    private IControladorCliente controladorCliente;
    private ImageButton botonPedido;
    private TextView textViewTotal;

    public MenuFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler_menu);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);


        // agrega la vista como oyente del modelo y llena el vector platos para el Adapter
        modeloCliente=new ImplementacionModeloCliente();
        try {
            modeloCliente.agreagarOyenteDelCambio(this);
            registrarModelo(modeloCliente);
            platos=modeloCliente.getMenu();


        } catch (ExcepcionRotiseria excepcionRotiseria) {
            excepcionRotiseria.printStackTrace();
        }




        mAdapter = new AdaptadorMenu(platos,modeloCliente);
        mRecyclerView.setAdapter(mAdapter);

        textViewTotal=(TextView)view.findViewById(R.id.precio_total);

        return view;
    }



    @Override
    public void registrarModelo(IModeloCliente modelo) throws ExcepcionRotiseria {
        modeloCliente=modelo;
    }

    @Override
    public void agregaOyenteAcciones(IControladorCliente iControladorCliente) throws ExcepcionRotiseria {
        controladorCliente=iControladorCliente;

    }

    @Override
    public void refrescar() {
        try {
            textViewTotal.setText("$ "+modeloCliente.getPedido().getPrecioTotal());
        } catch (ExcepcionRotiseria excepcionRotiseria) {
            excepcionRotiseria.printStackTrace();
        }

    }

    @Override
    public void mostrarPantalla(Object object) throws ExcepcionRotiseria {
        refrescar();

    }

    @Override
    public void manejadorDeCambioModeloCliente(Pedido pedido) throws ExcepcionRotiseria {

    }
}
