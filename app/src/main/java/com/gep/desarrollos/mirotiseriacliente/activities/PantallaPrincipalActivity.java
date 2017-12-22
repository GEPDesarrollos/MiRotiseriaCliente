package com.gep.desarrollos.mirotiseriacliente.activities;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.gep.desarrollos.mirotiseriacliente.R;
import com.gep.desarrollos.mirotiseriacliente.fragments.MenuFragment;
import com.gep.desarrollos.mirotiseriacliente.fragments.PedidoFragment;
import com.gep.desarrollos.mirotiseriacliente.modelo.ExcepcionRotiseria;
import com.gep.desarrollos.mirotiseriacliente.modelo.IModeloCliente;
import com.gep.desarrollos.mirotiseriacliente.modelo.ImplementacionModeloCliente;
import com.gep.desarrollos.mirotiseriacliente.modelo.Plato;
import com.gep.desarrollos.mirotiseriacliente.modelo.Rotiseria;

public class PantallaPrincipalActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private IModeloCliente modeloCliente;
    private static PedidoFragment pedidoFragment;
    private ImageButton botonPedido;
    private static PantallaPrincipalActivity pantallaPrincipalActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

//        inicializar el token de la rotiseria



        Rotiseria.leerTokenRotiseria();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        modeloCliente=new ImplementacionModeloCliente();

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());


        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);




        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position==1){
                    pedidoFragment.refrescar();
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


    }



    public void jumpToPage(View view) {

        switch (mViewPager.getCurrentItem()){

            case 0:

                mViewPager.setCurrentItem(1);
                break;

            case 1:

                mViewPager.setCurrentItem(0);
                break;

        }

    }



    public void irPantallaPedido(View view) {

        try {

            modeloCliente.enviarPedido(Rotiseria.getTokenApp());
        } catch (ExcepcionRotiseria excepcionRotiseria) {
            excepcionRotiseria.printStackTrace();
        }

        Intent intent=new Intent(this,PantallaEspera.class);
        startActivity(intent);

    }



    public  class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }



        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    MenuFragment menuFragment=new MenuFragment();

                    return menuFragment;

                case 1:

                    pedidoFragment=new PedidoFragment();
                    return pedidoFragment;

            }

            return null;
        }

        @Override
        public int getCount() {

            return 2;
        }



        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Menu";
                case 1:
                    return "Pedido";

            }
            return null;
        }


    }



//    Evitar que se cierre al presionar back
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mViewPager.setCurrentItem((mViewPager.getCurrentItem()==0)?1:0);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pantalla_principal, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
