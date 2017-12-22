package com.gep.desarrollos.mirotiseriacliente;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
 * Created by guille on 02/10/2017.
 */

public class MiRotiseriaCliente extends Application{
    private SharedPreferences preferences;
    private Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

    }
    public String getDemora() {

        preferences=getSharedPreferences("preferencias",MODE_PRIVATE);
        String demora=preferences.getString("demora","");
        Log.d("DemoraEnGetDemora",demora);
        return demora;
    }

    public void setDemora(String demora) {

        preferences=getSharedPreferences("preferencias",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("demora",demora);
        editor.commit();

    }

    public void setTimer(){

        startService(new Intent(getApplicationContext(),Timer.class));
    }

}
