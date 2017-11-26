package com.gep.desarrollos.mirotiseriacliente.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gep.desarrollos.mirotiseriacliente.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.zip.Inflater;

/**
 * Created by gep on 07/11/17.
 */

public class EsperaFragment extends Fragment {

    private TextView titulo, contenido;
    private FirebaseUser usuario;
    private FirebaseDatabase database;


    public EsperaFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usuario= FirebaseAuth.getInstance().getCurrentUser();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_espera,container,false);


        database=FirebaseDatabase.getInstance();

        titulo=(TextView)view.findViewById(R.id.titulo_espera);
        contenido=(TextView)view.findViewById(R.id.texto_espera);


        titulo.setText("Hola "+usuario.getDisplayName()+"!");

        contenido.setText("Por favor aguarde unos instantes, su pedido está siendo procesado");


        return view;
    }
}
