package com.gep.desarrollos.mirotiseriacliente.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gep.desarrollos.mirotiseriacliente.R;
import com.gep.desarrollos.mirotiseriacliente.modelo.Menu;
import com.gep.desarrollos.mirotiseriacliente.modelo.Plato;


public class MenuFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Menu menu;

    public MenuFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        menu=new Menu();
        Plato[]platos=menu.getMenu();
        mAdapter = new Adaptador(platos);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

}
