package com.gep.desarrollos.mirotiseriacliente.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gep.desarrollos.mirotiseriacliente.R;
import com.gep.desarrollos.mirotiseriacliente.fragments.PedidoConfirmadoFragment;

/**
 * Created by gep on 23/11/17.
 */

public class PantallaPedidoConfirmado extends AppCompatActivity {

    private Bundle bundle,args;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_confirmado);

        /*bundle=getIntent().getExtras();
        String demora = bundle.getString("demora");
        Log.d("DEMORA_PANTALLA",""+demora);

        // Creamos un nuevo Bundle
        args = new Bundle();

        // Colocamos el String
        args.putString("demora", demora);
*/
//        Log.d("ARGS_DEMORA", "" + args.toString());
//        pedidoConfirmadoFragment.setArguments(args);

        PedidoConfirmadoFragment pedidoConfirmadoFragment = new PedidoConfirmadoFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_tres, pedidoConfirmadoFragment).commit();

    }

}
