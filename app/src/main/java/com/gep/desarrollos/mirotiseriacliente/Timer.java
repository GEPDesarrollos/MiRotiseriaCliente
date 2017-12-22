package com.gep.desarrollos.mirotiseriacliente;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by gep on 27/11/17.
 */

public class Timer extends Service {


    private int tiempo;



    @Override
    public void onCreate() {
        super.onCreate();

    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Timer","empezó");
        tiempo=Integer.parseInt(((MiRotiseriaCliente)getApplication()).getDemora());


        new CountDownTimer(tiempo*60*1000,10000) {


            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("pasaron","10 seg");
            }

            public void onFinish() {

                Log.d("Timer","termino");

                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Recuerde pasar a retirar su pedido")
                        .setAutoCancel(true);


                Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                notificationBuilder.setSound(alarmSound);


                NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

                notificationManager.notify(0, notificationBuilder.build());


            }
        }.start();


        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
