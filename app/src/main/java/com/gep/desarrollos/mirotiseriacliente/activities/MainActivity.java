package com.gep.desarrollos.mirotiseriacliente.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gep.desarrollos.mirotiseriacliente.modelo.ExcepcionRotiseria;
import com.gep.desarrollos.mirotiseriacliente.modelo.IModeloCliente;
import com.gep.desarrollos.mirotiseriacliente.IVistaCliente;
import com.gep.desarrollos.mirotiseriacliente.modelo.ImplementacionModeloCliente;
import com.gep.desarrollos.mirotiseriacliente.ImplementacionVistaCliente;
import com.gep.desarrollos.mirotiseriacliente.modelo.Menu;
import com.gep.desarrollos.mirotiseriacliente.R;
import com.gep.desarrollos.mirotiseriacliente.modelo.Rotiseria;
import com.google.firebase.iid.FirebaseInstanceId;


public class MainActivity extends AppCompatActivity {

    private TextView platos;
    private Menu menu;
    private IModeloCliente iModeloCliente=new ImplementacionModeloCliente();
    private IVistaCliente iVistaCliente=new ImplementacionVistaCliente();
    private FirebaseInstanceId firebaseInstanceId=FirebaseInstanceId.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Rotiseria.leerTokenRotiseria();

        platos = (TextView) findViewById(R.id.platos);
        try {
            iVistaCliente.registrarModelo(iModeloCliente);
            iModeloCliente.agreagarOyenteDelCambio(iVistaCliente);
            iVistaCliente.refrescar();




        } catch (ExcepcionRotiseria excepcionRotiseria) {
            excepcionRotiseria.printStackTrace();
        }
    }


    public void recibirToken(View view) {
        String token=firebaseInstanceId.getToken();
        platos.setText(token);
        try {
            iModeloCliente.enviarPedido(token);

        } catch (ExcepcionRotiseria excepcionRotiseria) {
            excepcionRotiseria.printStackTrace();
        }
    }
}
