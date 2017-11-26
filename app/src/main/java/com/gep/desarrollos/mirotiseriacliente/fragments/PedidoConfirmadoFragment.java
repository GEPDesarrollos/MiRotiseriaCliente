package com.gep.desarrollos.mirotiseriacliente.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gep.desarrollos.mirotiseriacliente.MiRotiseriaCliente;
import com.gep.desarrollos.mirotiseriacliente.R;
import com.gep.desarrollos.mirotiseriacliente.modelo.Rotiseria;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.zip.Inflater;

/**
 * Created by gep on 23/11/17.
 */

public class PedidoConfirmadoFragment extends Fragment {

    private TextView titulo;
    private TextView contenido;
    private FirebaseUser usuario;
    private String demora;


    public PedidoConfirmadoFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        usuario= FirebaseAuth.getInstance().getCurrentUser();

        demora=((MiRotiseriaCliente)getActivity().getApplication()).getDemora();

       /* SharedPreferences preferences=getContext().getSharedPreferences("preferencias",Context.MODE_PRIVATE);
        demora = preferences.getString("demora","No");
*/
    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_pedido_confirmado,container,false);




//        demora = getArguments().getString("demora");
//        Log.d("FragmentPedConfirmado",demora);


        titulo=(TextView)view.findViewById(R.id.titulo_pedido_confirmado);
        contenido=(TextView)view.findViewById(R.id.texto_pedido_confirmado);


        titulo.setText("Hola "+usuario.getDisplayName()+"!");


        contenido.setText("Su pedido estará listo en "+demora+" minutos. Muchas Gracias!");



        return view;
    }
}
