package com.gep.desarrollos.mirotiseriacliente.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import com.gep.desarrollos.mirotiseriacliente.fragments.EsperaFragment;
import com.gep.desarrollos.mirotiseriacliente.fragments.FaceLoginFragment;
import com.gep.desarrollos.mirotiseriacliente.fragments.PedidoConfirmadoFragment;
import com.gep.desarrollos.mirotiseriacliente.modelo.IModeloCliente;
import com.gep.desarrollos.mirotiseriacliente.IVistaCliente;
import com.gep.desarrollos.mirotiseriacliente.modelo.ImplementacionModeloCliente;
import com.gep.desarrollos.mirotiseriacliente.ImplementacionVistaCliente;
import com.gep.desarrollos.mirotiseriacliente.modelo.Menu;
import com.gep.desarrollos.mirotiseriacliente.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.iid.FirebaseInstanceId;


public class PantallaEspera extends AppCompatActivity implements FaceLoginFragment.OnFragmentInteractionListener {

    private TextView platos;
    private Menu menu;
    private IModeloCliente iModeloCliente=new ImplementacionModeloCliente();
    private IVistaCliente iVistaCliente=new ImplementacionVistaCliente();
    private FirebaseInstanceId firebaseInstanceId=FirebaseInstanceId.getInstance();
    private ImageButton botonPedido;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private final String TAG="PantallaEspera";
    private FirebaseUser usuario;
    private Bundle bundle,args;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        usuario=FirebaseAuth.getInstance().getCurrentUser();

        if(usuario==null){

            FaceLoginFragment faceLoginFragment = new FaceLoginFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container_dos, faceLoginFragment).commit();

        }else{


                EsperaFragment esperaFragment= new EsperaFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container_dos, esperaFragment).commit();
            }





    }



    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d(TAG,"onFragmentInteraction pantallaEspera");

    }


}
