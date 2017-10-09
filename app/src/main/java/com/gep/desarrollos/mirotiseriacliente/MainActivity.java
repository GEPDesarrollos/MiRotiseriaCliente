package com.gep.desarrollos.mirotiseriacliente;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView platos;
    private Menu menu;
    private IModeloCliente iModeloCliente=new ImplementacionModeloCliente();
    private IVistaCliente iVistaCliente=new ImplementacionVistaCliente();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        platos = (TextView) findViewById(R.id.platos);
        try {
            iVistaCliente.registrarModelo(iModeloCliente);
            iModeloCliente.agreagarOyenteDelCambio(iVistaCliente);
            iVistaCliente.refrescar();

            iModeloCliente.modificaPedido(101,1);
            iModeloCliente.modificaPedido(102,1);
            iModeloCliente.modificaPedido(102,1);
            iModeloCliente.modificaPedido(101,-1);
            iModeloCliente.modificaPedido(102,-1);
            iModeloCliente.modificaPedido(101,-1);

        } catch (ExcepcionRotiseria excepcionRotiseria) {
            excepcionRotiseria.printStackTrace();
        }
    }



    }
