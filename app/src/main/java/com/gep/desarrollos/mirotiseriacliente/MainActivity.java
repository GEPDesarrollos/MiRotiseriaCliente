package com.gep.desarrollos.mirotiseriacliente;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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

            iModeloCliente.modificaPedido(101,1);
            iModeloCliente.modificaPedido(101,1);
            iModeloCliente.modificaPedido(101,1);
            iModeloCliente.modificaPedido(101,1);
            iModeloCliente.modificaPedido(101,1);
            iModeloCliente.modificaPedido(102,1);
            iModeloCliente.modificaPedido(102,1);
            iModeloCliente.modificaPedido(103,1);
            iModeloCliente.modificaPedido(204,1);
            iModeloCliente.modificaPedido(105,1);
            iModeloCliente.modificaPedido(205,1);
            //Log.i("tokenUsuario", firebaseInstanceId.getToken());



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
